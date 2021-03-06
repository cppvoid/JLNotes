package com.cppvoid.jlnotes.model;

import java.util.LinkedList;

public class Directory {
    public Directory(String name, String databaseId) {
        this.setName(name);
        this.setDatabaseId(databaseId);
    }
    
    public String getDatabaseId() {
        return databaseId;
    }

    public void setDatabaseId(String databaseId) {
        this.databaseId = databaseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name == null) {
            throw new NullPointerException("Directory: name is null");
        }

        this.name = name;
    }

    public LinkedList<Directory> getDirectories() {
        return directories;
    }

    public LinkedList<Note> getNotes() {
        return notes;
    }

    public void addDirectory(Directory directory) {
        if(directory == null) {
            throw new NullPointerException("Directory: directory is null");
        }

        directories.add(directory);
    }

    public void removeDirectory(Directory directory) {
        if(directory == null) {
            throw new NullPointerException("Directory: directory is null");
        }

        if(!directories.remove(directory)) {
            throw new IllegalArgumentException("Directory: directory not exists");
        }
    }

    private String databaseId;
    private String name;
    private LinkedList<Directory> directories;
    private LinkedList<Note> notes;
}
