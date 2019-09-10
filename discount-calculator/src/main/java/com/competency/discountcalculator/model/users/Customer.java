package com.competency.discountcalculator.model.users;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.*;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import static java.util.Calendar.*;

/**
 * This class holds user details.
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel
public class Customer extends Person{

    private int customerId;
    @JsonFormat(pattern="dd/MM/yyyy")
    @ApiModelProperty(value = "Provide value in dd/MM/yyyy format.")
    private Date joiningDate;

    @Override
    public float getDiscountPercentage() {
        if (getNoOfYearsSinceJoiningDate()>1){
            return 5;
        }
        return 0;
    }
    private   int getNoOfYearsSinceJoiningDate() {
        try {
            Calendar a = getCalendar(getJoiningDate());
            Calendar now = Calendar.getInstance();
            int diff = now.get(YEAR) - a.get(YEAR);
            if (a.get(MONTH) > now.get(MONTH) ||
                    (a.get(MONTH) == now.get(MONTH) && a.get(DATE) > now.get(DATE))) {
                diff--;
            }
            return diff;
        }catch (Exception e){
            return 0;
        }
    }

    private   Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;




    }
}
