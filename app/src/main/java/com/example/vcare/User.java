package com.example.vcare;

import java.util.ArrayList;

public class User {
    private String first, last, email, number, pass;
    private ArrayList<Integer> science, mind, quote;

    public User(){

    }

    public User(String first, String last, String email, String number, String pass){
        this.first = first;
        this.last = last;
        this.email = email;
        this.number = number;
        this.pass = pass;
        /**science = new ArrayList<Integer>();
        mind = new ArrayList<Integer>();
        quote = new ArrayList<Integer>();**/
    }


    public String getFirst() {
        return first;
    }

    public String getLast() {
        return last;
    }

    public String getEmail() {
        return email;
    }

    public String getNumber() {
        return number;
    }

    public String getPass() {
        return pass;
    }

    /**public ArrayList<Integer> getScience() {
        return science;
    }

    public void addScience(int n) {
        science.add(n);
    }

    public void rmScience(int n) {
        science.remove(((Integer) n));
    }

    public ArrayList<Integer> getMind() {
        return mind;
    }

    public void addMind(int n) {
        mind.add(n);
    }

    public void rmMind(int n) {
        mind.remove(((Integer) n));
    }

    public ArrayList<Integer> getQuote() {
        return quote;
    }

    public void addQuote(int n) {
        quote.add(n);
    }

    public void rmQuote(int n) {
        quote.remove(((Integer) n)); }**/
}
