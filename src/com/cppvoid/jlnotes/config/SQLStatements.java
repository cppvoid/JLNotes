package com.cppvoid.jlnotes.config;

public class SQLStatements {
    public static String getCreateTableNote() {
        return  "CREATE TABLE IF NOT EXISTS note(" +
                "note_id INT NOT NULL AUTO_INCREMENT," +
                "directory_id INT NOT NULL" +
                "title VARCHAR(50)," +
                "html_content VARCHAR(10000)," +
                "PRIMARY KEY(note_id)" +
                "FOREIGN KEY (directory_id) directory (directory_id)" +
                ");";
    }

    public static String getCreateTableDirectory() {
        return  "CREATE TABLE IF NOT EXISTS directory(" +
                "directory_id INT NOT NULL AUTO_INCREMENT," +
                "parent INT" +
                "name VARCHAR(50)," +
                "PRIMARY KEY (directory_id)" +
                "FOREIGN KEY (directory_id) directory (directory_id)" +
                ");";
    }

    public static String getInsertDirectory() {
        return  "INSERT INTO directory (" +
                "parent, name) VALUES (" +
                "?, ?)" +
                ");";
    }

    public static String getInsertNote() {
        return  "INSERT INTO note (" +
                "directory_id, title, html_content) VALUES (" +
                "?, ?, ?)" +
                ");";
    }
}
