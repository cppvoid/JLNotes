package com.cppvoid.jlnotes.viewmodel.database;

import com.cppvoid.jlnotes.model.Directory;
import com.cppvoid.jlnotes.model.Note;

public interface DatabaseConnection {
    void createDirectory(final Directory parent, final Directory directory) throws Exception;

    void createNote(final Directory location, final Note note) throws Exception;
}
