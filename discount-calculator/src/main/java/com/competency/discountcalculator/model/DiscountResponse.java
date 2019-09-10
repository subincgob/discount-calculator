package com.competency.discountcalculator.model;

import lombok.Builder;
import lombok.Getter;

/**
 * This class holds the response detail after discount.
 */
@Getter
@Builder
public class DiscountResponse {
    private double totalAmount;
    //Discount percentage to be applied on the bill.
    private float discountPercentage;
    //Discounted amount
    private double discountedAmount;
    //Billed amount after the discount..
    private double netPayableAmount;
}
