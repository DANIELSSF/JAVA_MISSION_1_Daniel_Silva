package com.grademanagement.ui;

import com.grademanagement.model.*;
import com.grademanagement.service.GradeManagementService;

import java.util.*;

public class GradeManagementUI {
    private final Scanner scanner;
    private final GradeManagementService gradeService;

    public GradeManagementUI() {
        this.scanner = new Scanner(System.in);
        this.gradeService = new GradeManagementService();
    }

    public void start() {
        int studentCount = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("How many students are in this class? : ");
            String input = scanner.nextLine().trim();

            try {
                studentCount = Integer.parseInt(input);

                if (studentCount <= 0) {
                    System.out.println("Error: Please enter a positive number greater than 0.");
                } else {
                    validInput = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input. Please enter a valid numeric value.");
            }
        }

        for (int i = 1; i <= studentCount; i++) {
            String studentId = String.format("STD%02d", i);
            Student student = new Student(studentId);

            for (Subject subject : Subject.values()) {
                double score = -1;
                boolean validScore = false;

                while (!validScore) {
                    System.out.printf("%s Student's %s Score : ", studentId, subject.getDisplayName());
                    String scoreInput = scanner.nextLine().trim();

                    try {
                        score = Double.parseDouble(scoreInput);

                        if (score < 0 || score > 100) {
                            System.out.println("Error: Score must be between 0 and 100. Please try again.");
                        } else {
                            validScore = true;
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Invalid input. Please enter a valid numeric value.");
                    }
                }

                student.addScore(subject, score);
            }

            gradeService.addStudent(student);
            printStudentStatus(student);
        }

        printFinalResults();
    }


    private void printStudentStatus(Student student) {
        System.out.println("-------------------------------------------");
        System.out.printf("[%s] Student's Score Status%n", student.getId());

        StringJoiner scores = new StringJoiner(", ");
        for (Score score : student.getScores()) {
            scores.add(String.format("%s %,.0f",
                    score.getSubject().getDisplayName(),
                    score.getScore()));
        }

        System.out.println(scores);
        System.out.println("-------------------------------------------");
        System.out.printf("Avg. : %.2f, Rank : %d\n",
                student.getAverage(),
                student.getRank());
        System.out.println("-------------------------------------------");
    }

    private void printFinalResults() {
        System.out.println("\nFinal Rankings:");
        for (Student student : gradeService.getStudentsByRank()) {
            System.out.printf("%s : => Avg. : %.2f, Rank : %d\n",
                    student.getId(),
                    student.getAverage(),
                    student.getRank());
        }

        System.out.println("===============================");
        Map<Subject, Double> classAverages = gradeService.calculateClassAverages();
        for (Subject subject : Subject.values()) {
            System.out.printf("%s Class Avg. : %.2f\n",
                    subject.getDisplayName(),
                    classAverages.get(subject));
        }
        System.out.println("===============================");
    }

    public static void main(String[] args) {
        new GradeManagementUI().start();
    }
}