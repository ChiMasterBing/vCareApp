package com.example.vcare;

public class Friend {

    private String name;
    private boolean isOnline;

    public Friend() {}
    public Friend(String name, boolean isOnline) {
        this.name = name;
        this.isOnline = isOnline;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public boolean getOnlineStatus() { return isOnline; }

    public void setOnlineStatus(boolean isOnline) { this.isOnline = isOnline; }
}
