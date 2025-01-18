package com.grademanagement.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student implements Comparable<Student> {
    private final String id;
    private final List<Score> scores;
    private double average;
    private int rank;

    public Student(String id) {
        this.id = id;
        this.scores = new ArrayList<>();
    }

    public void addScore(Subject subject, double score) {
        scores.add(new Score(subject, score));
        calculateAverage();
    }

    private void calculateAverage() {
        this.average = scores.stream()
                .mapToDouble(Score::getScore)
                .average()
                .orElse(0.0);
    }

    public String getId() {
        return id;
    }

    public List<Score> getScores() {
        return new ArrayList<>(scores);
    }

    public double getAverage() {
        return average;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }

    @Override
    public int compareTo(Student other) {
        return Double.compare(other.average, this.average);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}