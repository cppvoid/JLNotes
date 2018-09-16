package com.cppvoid.jlnotes.config;

public class SQLStatements {
    public static String getCreateTableNote() {
        return  "CREATE TABLE IF NOT EXISTS note(" +
                "note_id int NOT NULL AUTO_INCREMENT," +
                "title VARCHAR(50)," +
                "html_content VARCHAR(10000)," +
                "PRIMARY KEY(note_id)" +
                ");";
    }

    public static String getCreateTableDirectory() {
        return  "CREATE TABLE IF NOT EXISTS directory(" +
                "directory_id int NOT NULL AUTO_INCREMENT," +
                "name VARCHAR(50)," +
                "PRIMARY KEY (directory_id)" +
                ");";
    }

    public static String getCreateTableDirectoryList() {
        return  "CREATE TABLE IF NOT EXISTS directory_list(" +
                "directory_id INT NOT NULL," +
                "containing_directory_id INT NOT NULL," +
                "PRIMARY KEY (directory_id, containing_directory_id)," +
                "FOREIGN KEY (directory_id) REFERENCES directory (directory_id)," +
                "FOREIGN KEY (containing_directory_id) REFERENCES directory (directory_id)" +
                ");";
    }

    public static String getCreateTableNoteList() {
        return  "CREATE TABLE IF NOT EXISTS note_list(" +
                "directory_id INT NOT NULL," +
                "note_id INT NOT NULL," +
                "PRIMARY KEY (directory_id, note_id)," +
                "FOREIGN KEY (directory_id) REFERENCES directory (directory_id)," +
                "FOREIGN KEY (note_id) REFERENCES note (note_id)" +
                ");";
    }
}
