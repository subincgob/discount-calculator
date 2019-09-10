package com.competency.discountcalculator.service;

import com.competency.discountcalculator.model.DiscountResponse;
import com.competency.discountcalculator.model.Order;

/**
 * This class is responsible finding the discount.
 */
public interface DiscountService {

    public DiscountResponse calculateDiscount(Order order) ;


}
