package com.example.vcare;

public class Quote {
    String quoteTxt, author;

    public Quote() {}
    public Quote(String quoteTxt, String author) {
        this.quoteTxt = quoteTxt;
        this.author = author;
    }
    public Quote(String quoteTxt){
        this.quoteTxt = quoteTxt;
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
