package com.example;

public class App {
    public int add(int a, int b) {
        return a + b;
    }

    public String greet(String name) {
        if (name == null) return "Hello, Guest";
        return "Hello, " + name;
    }
}

