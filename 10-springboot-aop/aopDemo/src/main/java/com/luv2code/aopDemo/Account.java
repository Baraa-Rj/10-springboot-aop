package com.luv2code.aopDemo;

public class Account {
    private String name;
    private String level;

    public Account(String level, String name) {
        this.level = level;
        this.name = name;
    }

    public Account() {
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
