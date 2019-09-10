package com.competency.discountcalculator.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This enum describes different types of items.
 */
@Getter
@AllArgsConstructor
public enum ItemType {
    GROCERIES(0,"Groceries"),
    STATIONERY(1,"Stationery");

    private int code;
    private String description;
}
