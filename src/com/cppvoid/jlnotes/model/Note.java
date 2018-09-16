package com.cppvoid.jlnotes.model;

public class Note {
    public Note(String title, String htmlContent, String databaseID) {
        this.setTitle(title);
        this.setHtmlContent(htmlContent);
        this.setDatabaseID(databaseID);
    }

    public String getDatabaseID() {
        return databaseID;
    }

    public void setDatabaseID(String databaseID) {
        this.databaseID = databaseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null) {
            throw new NullPointerException("Note: title is null");
        }

        this.title = title;
    }

    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        if(title == null) {
            throw new NullPointerException("Note: htmlContent is null");
        }

        this.htmlContent = htmlContent;
    }

    private String databaseID;
    private String title;
    private String htmlContent;
}
