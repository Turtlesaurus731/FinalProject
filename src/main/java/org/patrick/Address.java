package org.patrick;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Address {
    private int streetNo;
    private String street;
    private String city;
    private Province province;
    private String postalCode;

    public enum Province {
        QC, ON, NS, PEI, BC, AB, SK, MB, NB, NL
    }

    public static boolean isPostalCodeValid(String postalCode) {
        if (postalCode == null || postalCode.length() != 6) {
            return false;
        }
        // arrays maybe? man why am I sick right now  ;v; MY HEAD HURTS AAA god colds suck ._.
        char[] chars = postalCode.toCharArray();

        for (int i = 0; i < postalCode.length(); i++) {
            if (i % 2 == 0 && !Character.isLetter(chars[i])) {
                return false;
            }
            else if (i % 2 != 0 && !Character.isDigit(chars[i])) {
                return false;
            }
        }
        /*
        for (int i = 0; i < postalCode.length(); i++) {
            if (i % 2 == 0) {
                if (!Character.isLetter(chars[i])) {
                    return false;
                }
            } else {
                if (!Character.isDigit(chars[i])) {
                    return false;
                }
            }
        }
         */
        return true;
    }

    public Address(int streetNo, String street, String city, Province province, String postalCode) {

        if (isPostalCodeValid(postalCode)) {
            this.streetNo = streetNo;
            this.street = street;
            this.city = city;
            this.province = province;
            this.postalCode = postalCode.toUpperCase();
        } else {
            this.street = null;
            this.city = null;
            this.province = null;
            this.postalCode = null;
        }
    }

    public void setPostalCode(String postalCode) {
        if (isPostalCodeValid(postalCode)) {
            this.postalCode = postalCode.toUpperCase();
        }
    }
}