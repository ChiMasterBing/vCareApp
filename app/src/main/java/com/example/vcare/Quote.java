package com.example.vcare;

public class Quote {
    private String quoteTxt;
    private String author;

    public Quote(String quoteTxt, String author) {
        this.quoteTxt = quoteTxt;
        this.author = author;
    }

    public String getQuoteTxt() {
        return quoteTxt;
    }

    public void setQuoteTxt(String quoteTxt) {
        this.quoteTxt = quoteTxt;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
