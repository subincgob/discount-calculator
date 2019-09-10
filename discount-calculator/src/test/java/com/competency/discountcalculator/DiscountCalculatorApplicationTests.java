package com.competency.discountcalculator;

import com.competency.discountcalculator.model.Bill;
import com.competency.discountcalculator.model.DiscountResponse;
import com.competency.discountcalculator.model.Item;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.model.enums.ItemType;
import com.competency.discountcalculator.model.enums.UserType;
import com.competency.discountcalculator.model.users.Affiliate;
import com.competency.discountcalculator.model.users.Customer;
import com.competency.discountcalculator.model.users.Employee;
import com.competency.discountcalculator.service.DiscountService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiscountCalculatorApplicationTests extends BaseTest{

	@Autowired
	DiscountService discountService;

	private MockMvc mockMvc;

	@Test
	public void testAffiliateDiscount() {

		List<Item> billItems = getItems();

		Order order = getAffilateUsersOrder(billItems);

		DiscountResponse discountResponse=discountService.calculateDiscount(order);
		Assert.assertEquals(261.5,discountResponse.getNetPayableAmount(),0);
	}



	@Test
	public void testEmployeeDiscount() {

		Order order = getEmployeesOrder();

		DiscountResponse discountResponse=discountService.calculateDiscount(order);
		Assert.assertEquals(234.5,discountResponse.getNetPayableAmount(),0);
	}



	@Test
	public void testCustomerDiscount() {

		Order order = getCustomersOrder();

		DiscountResponse discountResponse=discountService.calculateDiscount(order);
		Assert.assertEquals(268.25,discountResponse.getNetPayableAmount(),0);
	}



}
