package com.example.vcare;

public class Article {
    private String title;
    private String content;
    private String weblink;

    public Article() {}
    public Article(String title, String content, String weblink) {
        this.title = title;
        this.content = content;
        this.weblink = weblink;
    }

    public Article(String title, String weblink) {
        this.title = title;
        this.weblink = weblink;
    }

    public Article(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWeblink() { return weblink; }

    public void setWeblink(String weblink) { this.weblink = weblink; }

}
