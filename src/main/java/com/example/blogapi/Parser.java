package com.example.blogapi;

public abstract class Parser {
    public static Integer tryParseStringToInteger(String string) {
        try {
            return Integer.parseInt(string);
        } catch (Exception e) {
            return null;
        }
    }
}
