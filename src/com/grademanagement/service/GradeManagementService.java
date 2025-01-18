package com.grademanagement.service;

import com.grademanagement.model.*;
import java.util.*;

public class GradeManagementService {
    private final List<Student> students;

    public GradeManagementService() {
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        calculateRanks();
    }

    private void calculateRanks() {
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents);

        int currentRank = 1;
        double previousAverage = -1;

        for (Student student : sortedStudents) {
            if (previousAverage != student.getAverage()) {
                currentRank = sortedStudents.indexOf(student) + 1;
            }
            student.setRank(currentRank);
            previousAverage = student.getAverage();
        }
    }

    public Map<Subject, Double> calculateClassAverages() {
        Map<Subject, Double> averages = new EnumMap<>(Subject.class);

        for (Subject subject : Subject.values()) {
            double average = students.stream()
                    .flatMap(student -> student.getScores().stream())
                    .filter(score -> score.getSubject() == subject)
                    .mapToDouble(Score::getScore)
                    .average()
                    .orElse(0.0);
            averages.put(subject, average);
        }

        return averages;
    }

    public List<Student> getStudentsByRank() {
        List<Student> sortedStudents = new ArrayList<>(students);
        Collections.sort(sortedStudents);
        return sortedStudents;
    }
}