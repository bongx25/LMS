package com.library.model;

public class Book {
    private int id;
    private String title;
    private boolean issued;

    public Book(int id, String title, boolean issued) {
        this.id = id;
        this.title = title;
        this.issued = issued;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public boolean isIssued() { return issued; }
}
