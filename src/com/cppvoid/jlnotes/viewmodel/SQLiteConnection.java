package com.cppvoid.jlnotes.viewmodel;

import com.cppvoid.jlnotes.config.SQLStatements;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLiteConnection {
    private Connection connection;

    public SQLiteConnection() throws SQLException {
        final String url = "jdbc:sqlite:../notes.db";
        this.connection = DriverManager.getConnection(url);
        this.createTables();
    }

    private void createTables() throws SQLException {
        final Statement statement = connection.createStatement();

        statement.execute(SQLStatements.getCreateTableNote());
        statement.execute(SQLStatements.getCreateTableDirectory());
        statement.execute(SQLStatements.getCreateTableNoteList());
        statement.execute(SQLStatements.getCreateTableDirectoryList());
    }
}
