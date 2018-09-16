package com.cppvoid.jlnotes.viewmodel.database;

import com.cppvoid.jlnotes.config.SQLStatements;
import com.cppvoid.jlnotes.model.Directory;
import com.cppvoid.jlnotes.model.Note;

import java.sql.*;

public class SQLConnection implements DatabaseConnection {
    private Connection connection;

    public SQLConnection(final String url) throws SQLException {
        this.connection = DriverManager.getConnection(url);
        this.createTables();
    }

    private void createTables() throws SQLException {
        final Statement statement = connection.createStatement();

        statement.execute(SQLStatements.getCreateTableDirectory());
        statement.execute(SQLStatements.getCreateTableNote());
    }

    @Override
    public void createDirectory(final Directory parent, final Directory directory) throws SQLException {
        final PreparedStatement statement = this.connection.prepareStatement(SQLStatements.getInsertDirectory());
        statement.setInt(1, Integer.parseInt(parent.getDatabaseId()));
        statement.setString(2, directory.getName());
        statement.executeUpdate();
    }

    @Override
    public void createNote(final Directory location, final Note note) throws Exception {
        if(location == null) {
            throw new NullPointerException("SQLConnection: location is null");
        }
        if(note == null) {
            throw new NullPointerException("SQLConnection: note is null");
        }

        final PreparedStatement statement = this.connection.prepareStatement(SQLStatements.getInsertNote());
        statement.setInt(1, Integer.parseInt(location.getDatabaseId()));
        statement.setString(2, note.getTitle());
        statement.setString(3, note.getHtmlContent());
        statement.executeUpdate();
    }
}
