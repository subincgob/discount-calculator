package com.competency.discountcalculator.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * This class contains the detail of the bill;
 */
@Builder
@Getter
@Setter
public class Bill {
    //Items in th bill.
    private List<Item> billItems;
    //Total amount for all of the items.
    private double totalAmount;

}
