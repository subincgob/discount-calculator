package com.competency.discountcalculator.model.users;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * This class hold the basic details of a person.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {
    private String name;
    private String gender;
    private String mobileNumber;
    private String email;

    @JsonIgnore
    public abstract float getDiscountPercentage();
}
