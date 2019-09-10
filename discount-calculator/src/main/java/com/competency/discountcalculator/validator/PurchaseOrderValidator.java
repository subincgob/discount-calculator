package com.competency.discountcalculator.validator;

import com.competency.discountcalculator.exception.InvalidRequestException;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.model.enums.UserType;
import com.competency.discountcalculator.model.users.Customer;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * This class validates the incoming order.
 */
@Component
public class PurchaseOrderValidator {
    /**
     * This method validates the order.
     *
     * @param order purchase order.
     */
    public void validateOrder(Order order) {

        if (order.getPerson() != null && order.getUserType().equals(UserType.CUSTOMER.getDescription()) && ObjectUtils.isEmpty(((Customer) order.getPerson()).getJoiningDate())) {
            throw new InvalidRequestException("Please provide a joining date for customer");
        }


    }

}
