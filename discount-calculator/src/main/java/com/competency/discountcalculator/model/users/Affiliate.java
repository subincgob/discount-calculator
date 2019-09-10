package com.competency.discountcalculator.model.users;

import lombok.*;

/**
 * This class holds Affiliate details.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Affiliate extends Person {

    private int affiliateId;
    @Override
    public float getDiscountPercentage() {
        return 10;
    }
}
