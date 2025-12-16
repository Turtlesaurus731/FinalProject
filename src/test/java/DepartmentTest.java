import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.patrick.Department;

public class DepartmentTest {
    @Test
    @DisplayName("isDepartmentNameValid(): Computer Science -> true")
    public void isDepartmentNameValid1() {
        String name = "Computer Science";
        boolean expected = true;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid(): CS1 -> false")
    public void isDepartmentNameValid2() {
        String name = "CS1";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid(): \"\" -> false")
    public void isDepartmentNameValid3() {
        String name = "";
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected,actual);
    }

    @Test
    @DisplayName("isDepartmentNameValid(): null -> false")
    public void isDepartmentNameValid4() {
        String name = null;
        boolean expected = false;
        boolean actual = Department.isDepartmentNameValid(name);

        Assertions.assertEquals(expected,actual);
    }
}
