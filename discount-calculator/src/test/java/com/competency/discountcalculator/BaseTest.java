package com.competency.discountcalculator;

import com.competency.discountcalculator.model.Bill;
import com.competency.discountcalculator.model.Item;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.model.enums.ItemType;
import com.competency.discountcalculator.model.enums.UserType;
import com.competency.discountcalculator.model.users.Affiliate;
import com.competency.discountcalculator.model.users.Customer;
import com.competency.discountcalculator.model.users.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseTest {

    protected List<Item> getItems() {
        List<Item> billItems=new ArrayList<>();
        billItems.add(Item.builder()
                .name("pen")
                .price(15f)
                .quantity(9f)
                .build());

        billItems.add(Item.builder()
                .name("Cucumber")
                .price(15f)
                .type(ItemType.GROCERIES.getDescription())
                .quantity(10f)
                .build());
        return billItems;
    }
    protected Order getAffilateUsersOrder(List<Item> billItems) {
        return Order.builder()
                .person(Affiliate.builder().build())
                .userType(UserType.AFFILIATE.getDescription())
                .bill(
                        Bill.builder()
                                .billItems(billItems)
                                .build()
                )
                .build();
    }
    protected Order getEmployeesOrder() {
        return Order.builder()
                .person(Employee.builder().build())
                .userType(UserType.EMPLOYEE.getDescription())
                .bill(
                        Bill.builder()
                                .billItems(getItems())
                                .build()
                )
                .build();
    }

    protected Order getCustomersOrder() {
        return Order.builder()
                .person(Customer.builder()
                        .joiningDate(new Date("23/09/1991"))
                        .build())
                .userType(UserType.CUSTOMER.getDescription())
                .bill(
                        Bill.builder()
                                .billItems(getItems())
                                .build()
                )
                .build();
    }
    @Test
    public void sample(){

    }

}
