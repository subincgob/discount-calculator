package com.competency.discountcalculator.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * This enum describes different types of items.
 */
@AllArgsConstructor
public enum UserType {
    EMPLOYEE(0,"Employee"),
    AFFILIATE(1,"Affiliate"),
    CUSTOMER(2,"Customer");

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }


}
