package com.competency.discountcalculator.model.users;

import lombok.*;

/**
 *  This class holds Affiliate details.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {

    private  int employeeId;
    @Override
    public float getDiscountPercentage() {
        return 30;
    }
}
