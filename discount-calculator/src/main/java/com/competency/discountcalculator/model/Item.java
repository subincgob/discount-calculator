package com.competency.discountcalculator.model;

import lombok.*;

/**
 * This class contains the detail about a item in the bill;
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Item {
    private String name;
    private String type;
    private Float quantity;
    private Float price;
}
