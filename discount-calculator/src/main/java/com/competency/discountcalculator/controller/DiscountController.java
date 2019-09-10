package com.competency.discountcalculator.controller;

import com.competency.discountcalculator.model.DiscountResponse;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.service.DiscountService;
import com.competency.discountcalculator.validator.PurchaseOrderValidator;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class handles all the
 */
@RestController
@RequestMapping("calculate")
public class DiscountController {
    @Autowired
    private DiscountService discountService;

    @Autowired
    private PurchaseOrderValidator validator;

    @PostMapping("/discount")
    @ApiOperation(value = "API to calculate the discount",produces = MediaType.APPLICATION_JSON_UTF8_VALUE,consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DiscountResponse calculateDiscount(@RequestBody Order order) {
        validator.validateOrder(order);
        return discountService.calculateDiscount(order);
    }
}
