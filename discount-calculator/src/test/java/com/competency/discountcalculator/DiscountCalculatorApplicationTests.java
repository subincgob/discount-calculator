package com.competency.discountcalculator;

import com.competency.discountcalculator.model.DiscountResponse;
import com.competency.discountcalculator.model.Item;
import com.competency.discountcalculator.model.Order;
import com.competency.discountcalculator.service.DiscountService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class DiscountCalculatorApplicationTests extends BaseTest{

	@Autowired
	private DiscountService discountService;


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
