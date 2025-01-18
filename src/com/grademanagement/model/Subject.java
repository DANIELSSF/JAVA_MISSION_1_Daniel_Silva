package com.grademanagement.model;

public enum Subject {
    JAVA("Java"),
    SQL("SQL"),
    MATH("Math."),
    ENGLISH("English");

    private final String displayName;

    Subject(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}