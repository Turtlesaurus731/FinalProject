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
        QC,
        ON,
        NS,
        PEI,
        BC,
        AB,
        SK,
        MB,
        NB,
        Nl
    }
}
