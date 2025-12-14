package org.patrick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    /**
     * Check if department name is valid (Only contains letters and spaces)
     * @param departmentName the name that is to be checked
     * @return true if valid, otherwise false
     */
    public static boolean isDepartmentNameValid(String departmentName) {
        if (departmentName == null || departmentName.isEmpty()) {
            return false;
        }
        char[] chars = departmentName.toCharArray();

        for (char c : chars) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    public Department(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = String.format("d%02d", nextId++);
        } else {
            this.departmentName = null;
            this.departmentId = null;
        }
    }

    public void setDepartmentName(String departmentName) {
        if (isDepartmentNameValid(departmentName)) {
            this.departmentName = departmentName;
        }
    }
}
