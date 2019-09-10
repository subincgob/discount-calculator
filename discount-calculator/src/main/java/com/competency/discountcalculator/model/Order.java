package com.competency.discountcalculator.model;

import com.competency.discountcalculator.model.users.Affiliate;
import com.competency.discountcalculator.model.users.Employee;
import com.competency.discountcalculator.model.users.Person;
import com.competency.discountcalculator.model.users.Customer;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

/**
 * This class holds an order from a user.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Order from a customer")
public class Order {
    //Type of the user.
    @ApiModelProperty("This define s the type of user; Affiliate,Employee or Customer")
    private String userType;

    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "userType", include = JsonTypeInfo.As.EXTERNAL_PROPERTY)
    @JsonSubTypes(value = {
            @JsonSubTypes.Type(value = Affiliate.class, name = "Affiliate"),
            @JsonSubTypes.Type(value = Employee.class, name = "Employee"),
            @JsonSubTypes.Type(value = Customer.class, name = "Customer")
    })
    //Person detail.
    @ApiModelProperty(value = "Person detail.")
    private Person person;

    //Purchase detail of the order.
    @ApiModelProperty(value = "Purchase detail of the order.")
    private Bill bill;

}
