import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.patrick.Address;

public class AddressTest {

    @Test
    @DisplayName("isPostalCodeValid(String postalCode): A1B2C3 -> True")
    public void isPostalCodeValid1() {
        String postalCode = "A1B2C3";
        boolean expected = true;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid(String postalCode): 11B2C3 -> False")
    public void isPostalCodeValid2() {
        String postalCode = "11B2C3";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid(String postalCode): null -> False")
    public void isPostalCodeValid3() {
        String postalCode = null;
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid(String postalCode): A1B2C3D4 -> False")
    public void isPostalCodeValid4() {
        String postalCode = "A1B2C3D4";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("isPostalCodeValid(String postalCode): \" \" -> False")
    public void isPostalCodeValid() {
        String postalCode = " ";
        boolean expected = false;
        boolean actual = Address.isPostalCodeValid(postalCode);

        Assertions.assertEquals(expected, actual);
    }
}
