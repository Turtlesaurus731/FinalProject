package org.patrick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@EqualsAndHashCode
public class Student {
    private String studentId;
    private String studentName;
    private Gender gender;
    private Address address;
    private Department department;
    private ArrayList<Course> registeredCourses;
    private static int nextId = 1;

    public enum Gender {
        MALE, FEMALE
    }

    public Student(String studentName, Gender gender, Address address, Department department) {
        this.studentId = String.format("S%05d", nextId++);
        this.studentName = Util.toTitleCase(studentName);
        this.gender = gender;
        this.address = address;
        this.department = department;
        this.registeredCourses = new ArrayList<>();
    }

    /**
     * Registers a course for a student
     * @param course the course to register
     * @return [False] if already registered and [True] if successfully registered
     */
    public boolean registerCourse(Course course) {
        if (registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.add(course);

        if (!course.getRegisteredStudents().contains(this)) {
            course.getRegisteredStudents().add(this);
        }

        for (Assignment a : course.getAssignments()) {
            a.getScores().add(null);
        }
        return true;
    }

    /**
     * Drops a course for a student
     * @param course the course to drop
     * @return [False] if not registered and true of successfully dropped
     */
    public boolean dropCourse(Course course) {
        if (!registeredCourses.contains(course)) {
            return false;
        }
        registeredCourses.remove(course);

        for (Assignment a : course.getAssignments()) {
            int index = course.getRegisteredStudents().indexOf(this);
            if (index >= 0 && index < a.getScores().size()) {
                a.getScores().remove(index);
            }
        }

        course.getRegisteredStudents().remove(this);
        return true;
    }

    /**
     * Simplify a given string
     * @return the simplified string
     */
    public String toSimplifiedString() {
        return String.format("%s - %s - %s", studentId, studentName, department.getDepartmentName());
    }

    @Override
    public String toString() {
        String registeredCourses1 = "[";
        for (int i = 0; i < registeredCourses.size(); i++) {
            registeredCourses1 += registeredCourses.get(i).toSimplifiedString();
            if (i < registeredCourses.size() - 1) {
                registeredCourses1 += ", ";
            }
        }

        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", address=" + address +
                ", department=" + department +
                ", registeredCourses=" + registeredCourses1 +
                '}';
    }
}
