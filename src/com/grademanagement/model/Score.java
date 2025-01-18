package com.grademanagement.model;

public class Score {
    private final Subject subject;
    private final double score;

    public Score(Subject subject, double score) {
        this.subject = subject;
        this.score = score;
    }

    public Subject getSubject() {
        return subject;
    }

    public double getScore() {
        return score;
    }
}