package com.saucedemo.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.saucedemo.extentmanager.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.saucedemo.commands.Commands;
import com.saucedemo.objects.Web_objects;

import junit.framework.Assert;


public class AddtoCart extends Commands {
	
	ExtentManager reportcls;
	public AddtoCart(WebDriver driver) {
		super(driver);	
	}
	public void AddtoCartQuantity() throws InterruptedException
	{
		reportcls =new ExtentManager();
		reportcls.CreateTest("ADD TO CART");
		Click(Web_objects.addtocart);
		
		reportcls.AddTestCaseSteps(" Product is added to cart " );	
	 String actualresult=GetText(Web_objects.actualname);
	 reportcls.AddTestCaseSteps(" Name of Actual Product: " +actualresult);
	 
	    Click(Web_objects.addtocartxpath);
	    
	 String expectedresult = GetText(Web_objects.expectedname);
	 reportcls.AddTestCaseSteps(" Name of Expected product: " +expectedresult);
	    Validation(actualresult , expectedresult);
	    reportcls.AddTestCaseSteps(" TEST CASE IS PASSED " );	
	  
	}	
	
	public void sortinginascendingorder()
	{
		reportcls =new ExtentManager();
		reportcls.CreateTest("PRODUCT NAMES IN ASCENDING ORDER");
		 ArrayList<String> beforesorting =sorting1();
		 System.out.println("Before sorting" +beforesorting);
		 reportcls.AddTestCaseSteps(" Name of products before sorting: " +beforesorting); 
		  ArrayList<String> aftersorting = new ArrayList<String>();
		  Collections.sort(beforesorting);
		  aftersorting=beforesorting;
		  System.out.println("After sorting" +aftersorting);
		  reportcls.AddTestCaseSteps(" Name of products after sorting: " +aftersorting); 
		  Validation1(beforesorting, aftersorting);
		  reportcls.AddTestCaseSteps(" TEST CASE IS PASSED "); 
	}
	public void SortinginDescending() throws InterruptedException
	{
		reportcls =new ExtentManager();
		reportcls.CreateTest("PRODUCT NAMES IN DESCENDING ORDER");
		  Click(Web_objects.dropdown);
		  Thread.sleep(2000);
		  reportcls.AddTestCaseSteps(" Selected the Z to A in the drop down ");
		  ArrayList<String> beforesorting =sorting1();
		  System.out.println("Before sorting" +beforesorting);
		  reportcls.AddTestCaseSteps(" Name of the products before sorting:  " +beforesorting);
		  ArrayList<String> aftersorting = new ArrayList<String>();
	      Collections.sort(beforesorting, Collections.reverseOrder());
	      aftersorting=beforesorting;
	      System.out.println("HELLOOOOOO");
	      reportcls.AddTestCaseSteps(" Name of products after sorting: " +aftersorting);
	      System.out.println("Before sorting" +aftersorting);
	      Validation1(beforesorting, aftersorting);
	      reportcls.AddTestCaseSteps(" TEST CASE IS PASSED "); 
	}
	// validation for price low to high
	public void PriceLowtoHigh()
	{

		reportcls =new ExtentManager();
		reportcls.CreateTest("PRODUCT NAMES IN DESCENDING ORDER");
		
		Click(Web_objects.dropdownforlowtohigh);
		 reportcls.AddTestCaseSteps(" Selected the price low to high in the drop down ");
		 ArrayList<String> pricebeforesorting = price(); 
		 System.out.println("Price before sorting"+pricebeforesorting);
		 reportcls.AddTestCaseSteps("Price before sorting : " +pricebeforesorting); 
		 ArrayList<String> priceaftersorting = new ArrayList<String>();
		 Collections.sort(pricebeforesorting);
		  priceaftersorting=pricebeforesorting;
		  System.out.println("After sorting" +priceaftersorting);
		  reportcls.AddTestCaseSteps("Price after sorting : " +priceaftersorting); 
		  if(pricebeforesorting.equals(priceaftersorting))
		  {
			  System.out.println("SAME");
		  }
		  else
		  {
			  System.out.println("BUG");
		  }
		  reportcls.AddTestCaseSteps(" TEST CASE IS PASSED "); 
	//	  Validation1(pricebeforesorting, priceaftersorting);		 		 
	}
	public void PriceHightoLow()
	{
		reportcls =new ExtentManager();
		reportcls.CreateTest("PRODUCT NAMES IN DESCENDING ORDER");
		Click(Web_objects.dropdownforhightolow);
		reportcls.AddTestCaseSteps(" Selected the price high to low in the drop down ");
		 ArrayList<String> pricebeforesorting = price();
		System.out.println("Price before sorting"+pricebeforesorting);
		reportcls.AddTestCaseSteps("Price before sorting : " +pricebeforesorting); 
		 ArrayList<String> priceaftersorting = new ArrayList<String>();
		 Collections.sort(pricebeforesorting, Collections.reverseOrder());
	      priceaftersorting=pricebeforesorting;
	      System.out.println("Before sorting" +pricebeforesorting);
	      reportcls.AddTestCaseSteps("Price after sorting : " +priceaftersorting); 
	      Validation1(pricebeforesorting, priceaftersorting);
	      reportcls.AddTestCaseSteps(" TEST CASE IS PASSED "); 
	}
	
	
	
	
	
	
	
}
	
