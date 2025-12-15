package org.patrick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> registeredStudents;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseId = String.format("C-%s-%02d", department.getDepartmentId(), nextId++);
        this.courseName = Util.toTitleCase(courseName);
        this.credits = credits;
        this.department = department;
        this.registeredStudents = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    /**
     * Check if sum of the assignment weight equals 100%
     * @return [True] if sum of the assignment weight equals 100%, otherwise [False]
     */
    public boolean isAssignmentWeightValid() {
        double total = 0;
        for (Assignment a : assignments) {
            total += a.getWeight();
        }
        return Math.abs(total - 100) < 0.00001;
    }

    /**
     * Adds a student to the course
     * @param student the student that is to be registered
     * @return [False] if student is already registered, otherwise [True]
     */
    public boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);

        for (Assignment a : assignments) {
            a.getScores().add(null);
        }

        if (!student.getRegisteredCourses().contains(this)) {
            student.getRegisteredCourses().add(this);
        }
        return true;
    }

    /**
     * Calculates weighted average for each registered student
     * @return array of weighted averages in the same order as the registeredStudents
     */
    public int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalScore = 0;
            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                if (score != null) {
                    totalScore += score * a.getWeight() / 100.0;
                }
            }
            averages[i] = (int) Math.round(totalScore);
        }
        return averages;
    }

    /**
     * Adds a new assignment to the course
     * @param assignmentName the name of the assignment
     * @param weight the weight of the assignment
     * @param maxScore tje max score of the assignment
     * @return [True] if added
     */
    public boolean addAssignment(String assignmentName, double weight, int maxScore) {
        Assignment a = new Assignment(assignmentName, weight);
        for (int i = 0; i < registeredStudents.size(); i++) {
            a.getScores().add(null);
        }
        assignments.add(a);
        return true;
    }

    /**
     * Generate random scores for all assignments and students
     */
    public void generateScroes(){
        for (Assignment a : assignments) {
            a.generateRandomScore();
        }
    }

    /**
     * Displays the scores of a course in a table
     */
    public void displayScores() {
        System.out.printf("Course: %s (%s)%n", courseName, courseId);
        printHeader();
        printStudentScores();
        printAssignmentAverage();
    }

    /**
     * Helper method: prints the header with assignment names and final scores
     */
    private void printHeader() {
        System.out.printf("%-20s","Student");
        for (Assignment a : assignments) {
            System.out.printf("%-15s", a.getAssignmentName());
        }
        System.out.printf("%-15s%n", "Final score");
    }

    /**
     * Helper method: prints students scores and weighted average
     */
    private void printStudentScores() {
        int[] finalScores = calcStudentsAverage();

        for (int i = 0; i < registeredStudents.size(); i++) {
            Student s = registeredStudents.get(i);
            System.out.printf("%-20s", s.getScores().get(i));

            for (Assignment a : assignments) {
                Integer score = a.getScores().get(i);
                System.out.printf("%-15s", score == null ? "-" : score);
            }
            System.out.printf("%-15d%n", finalScores[i]);
        }
    }

    /**
     * Helper method: prints the average score for each assignment
     */
    private void printAssignmentAverage() {
        System.out.printf("%-20s", "Average");
        for (Assignment a : assignments) {
            int avg = (int) Math.round(a.getAverageScore());
            System.out.printf("%-15d", avg);
        }
        System.out.println();
    }

    public String toSimplifiedString() {
        return String.format("%s - %s (%.1f credits) - %s",
                courseId, courseName, credits, department.getDepartmentName());
    }

    @Override
    public String toString() {
        String registeredStudents1 = "[";
        for (int i = 0; i < registeredStudents.size(); i++) {
            registeredStudents1 += registeredStudents.get(i).toSimplifiedString();
            if (i < registeredStudents.size() - 1) {
                registeredStudents1 += ", ";
            }
        }
        registeredStudents1 += "]";

        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                ", assignments=" + assignments +
                ", registeredStudents=" + registeredStudents +
                ", assignmentWeightsValid" + isAssignmentWeightValid() +
                '}';
    }
}
