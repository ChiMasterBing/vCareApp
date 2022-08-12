package com.example.vcare;

public class JournalEntry {

    private String entryType;
    private String txt;
    private String response;

    //TODO make subclass for each type since formatting will be different and need different properties
    //Prompt, Quote, Image
    public JournalEntry(String type, String text) {
        entryType = type;
        txt = text;
        response = "";
    }

    public String getTxt() {
        return txt;
    }
    public String getResponse() {
        return response;
    }
    public String getEntryType() {
        return entryType;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }
    public void setResponse(String response) {
        this.response = response;
    }
    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public boolean isPrompt(){
        return entryType.equals("prompt");
    }
    public boolean isQuote(){
        return entryType.equals("quote");
    }
}
