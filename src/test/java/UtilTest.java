import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.patrick.Util;

public class UtilTest {
    @Test
    @DisplayName("ToTitleCase(): hello -> Hello")
    public void toTitleCase1() {
        String str = "hello";
        String expected = "Hello";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ToTitleCase(): yi wang -> Yi Wang")
    public void toTitleCase2() {
        String str = "yi wang";
        String expected = "Yi Wang";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ToTitleCase(): COMPUTER SCIENCE AND MATH -> Computer Science And Math")
    public void toTitleCase3() {
        String str = "COMPUTER SCIENCE AND MATH";
        String expected = "Computer Science And Math";
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ToTitleCase(): null -> null")
    public void toTitleCase4() {
        String str = null;
        String expected = null;
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("ToTitleCase(): \"\" -> null")
    public void toTitleCase5() {
        String str = "";
        String expected = null;
        String actual = Util.toTitleCase(str);

        Assertions.assertEquals(expected, actual);
    }
}
