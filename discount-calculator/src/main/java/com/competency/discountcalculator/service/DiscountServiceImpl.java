package com.competency.discountcalculator.service;


import com.competency.discountcalculator.model.DiscountResponse;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.model.enums.ItemType;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.stream.Collectors;

/**
 * Implementation of discount service.
 */
@Component
public class DiscountServiceImpl implements DiscountService {


    @Override
    public DiscountResponse calculateDiscount(@NotNull Order order) {
        float discountPercentage=0;
        if (order.getPerson()!=null){
            discountPercentage=order.getPerson().getDiscountPercentage();
        }
        double totalAmount=order.getBill().getBillItems().stream()
                .collect(Collectors.summingDouble(item->item.getPrice()*item.getQuantity()));

        order.getBill().setTotalAmount(totalAmount);
        double discountEligibleAmt=order.getBill().getBillItems().stream()
                .filter(item -> item.getType()==null||!item.getType().equalsIgnoreCase(ItemType.GROCERIES.getDescription()))
                .collect(Collectors.summingDouble(item->item.getPrice()*item.getQuantity()));
        //Percentage based discount
        double discountedAmt=calculateDiscount(discountEligibleAmt,discountPercentage);
        //5$ on every 100$ discount
        double flatDiscount=calculateDiscount(totalAmount);
        return DiscountResponse.builder()
                .discountedAmount(discountedAmt+flatDiscount)
                .discountPercentage(discountPercentage)
                .netPayableAmount(totalAmount-(discountedAmt+flatDiscount))
                .totalAmount(totalAmount)
                .build();
    }

    private double calculateDiscount(double discountEligibleAmt,float discountPercentage){
        return (discountEligibleAmt*discountPercentage/100);
    }

    /**
     * Flat discount calculation. 5$ on every 100$ discount
     * @param totalAmt Amount to avail discount;
     * @return discounted amount
     */
    private double calculateDiscount(double totalAmt){
        return  Math.floor((totalAmt/100))*5;
    }
}

