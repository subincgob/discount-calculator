package com.competency.discountcalculator;

import com.competency.discountcalculator.model.Bill;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.model.enums.UserType;
import com.competency.discountcalculator.model.users.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ControllerTest extends BaseTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext wac;


    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

    }

    @Test
    public void checkCustomerValidationTest () throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate/discount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(getCustomersOrder()))
                .accept(MediaType.APPLICATION_JSON))
                    .andExpect(jsonPath("$.netPayableAmount").value(268));
    }

    @Test
    public void checkEmptyOrderTest () throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/calculate/discount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new Order().toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

    }

    @Test
    public void checkCustomerWithoutJoiningDateTest () throws Exception {
        Order order=Order.builder()
                .person(Customer.builder()
                        .build())
                .userType(UserType.CUSTOMER.getDescription())
                .bill(
                        Bill.builder()
                                .billItems(getItems())
                                .build()
                )
                .build();
        mockMvc.perform(MockMvcRequestBuilders.post("/calculate/discount")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(order))
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity());

    }
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
