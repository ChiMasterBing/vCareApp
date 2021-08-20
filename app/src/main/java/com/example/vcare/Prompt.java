package com.example.vcare;

public class Prompt {
    private String name;
    private String text;

    public Prompt(String name, String text) {
        this.name = name;
        this.text = text;
    }

    public Prompt(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
