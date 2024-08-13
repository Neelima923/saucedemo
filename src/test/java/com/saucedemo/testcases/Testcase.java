package com.saucedemo.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.saucedemo.pages.AddtoCart;

public class Testcase extends BaseClass {
	
	@Test(priority = 1, enabled = false)	
	public void AddtoCart2() throws InterruptedException  //---test case for addto cart
	{
		
		AddtoCart object=new AddtoCart(driver);
		object.AddtoCartQuantity();	
	}
	@Test(priority = 2, enabled = false)	
	public void SortingInAscendingOrder()
	{
		AddtoCart obj=new AddtoCart(driver);
		obj.sortinginascendingorder();
	}
	@Test(priority = 3, enabled = true)	
	public void SortingInDescendingOrder1() throws InterruptedException
	{
		AddtoCart obj=new AddtoCart(driver);
		obj.SortinginDescending();
	}
	@Test(priority = 4, enabled = true)
	public void PriceSortingLowtoHigh()
	{
		AddtoCart obj=new AddtoCart(driver);
		obj.PriceLowtoHigh();
	}
	@Test(priority = 5, enabled = true)
	public void PriceSortingHightoLow()
	{
		AddtoCart obj=new AddtoCart(driver);
		obj.PriceHightoLow();
	}
	
	
	
}
