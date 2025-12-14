package org.patrick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Random;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private ArrayList<Integer> scores;
    private double averageScore;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight) {
        this.assignmentId = String.format("Assignment%03d", nextId++);
        this.assignmentName = Util.toTitleCase(assignmentName);
        this.weight = weight;
        this.scores = new ArrayList<>();
        this.averageScore = 0;
    }

    /**
     * Calculates the average score of the assignment
     */
    public void calcAssignmentAvg() {
        double sum = 0;
        int count = 0;
        for (Integer s : scores) {
            if (s != null) {
                sum += s;
                count++;
            }
        }
        averageScore = count == 0 ? 0 : sum / count;
    }

    /**
     * Generates a random score for all students in an assignment
     */
    public void generateRandomScore() {
        Random random = new Random();
        for (int i = 0; i < scores.size(); i++) {
            int rangeSelector = random.nextInt(11);
            int score = switch (rangeSelector) {
                case 0 -> random.nextInt(60);
                case 1, 2 -> 60 + random.nextInt(10);
                case 3, 4 -> 70 + random.nextInt(10);
                case 5, 6, 7, 8 -> 80 + random.nextInt(10);
                case 9, 10 -> 90 + random.nextInt(11);
                default -> 0;
            };
            scores.set(i, score);
        }
        calcAssignmentAvg();
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "assignmentId='" + assignmentId + '\'' +
                ", assignmentName='" + assignmentName + '\'' +
                ", weight=" + weight +
                '}';
    }
}
