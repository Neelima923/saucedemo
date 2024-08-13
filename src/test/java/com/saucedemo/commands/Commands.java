package com.saucedemo.commands;

import org.testng.AssertJUnit;

import junit.framework.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commands {
	public WebDriver driver;

	public final static Logger logger=LogManager.getLogger("rootlogger");
	
	public Commands(WebDriver driver)
	{
		this.driver=driver;
		
	}
	public void Click(By locator)
	{
		try {
			Explicitwait(locator);
		driver.findElement(locator).click();
		logger.info("Click is passed :"+ " " +locator);
		}catch(Exception e)
		{
			logger.error("Click is failed:" +locator);
			logger.error(e.getMessage());
			Assert.fail();
		}
		
	}
		
	public void Type(By locator,String text)
	{
		Explicitwait(locator);
		try {
			
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
		logger.info("Click is passed :"+ " " +locator);
		}catch(Exception e)
		{
			logger.error("Click is failed:" +locator);
			logger.error(e.getMessage());
			Assert.fail();
		}
	}
	
	public String GetText(By locator)
	{
		String text="";
		try {
		text=driver.findElement(locator).getText();
		logger.info(" Got the text message"+ " " +locator);
		}
		catch(Exception e)
		{
			logger.error("Click is failed:" +locator);
			logger.error(e.getMessage());
			Assert.fail();
		}
		return text;
	}
	
	public void Validation(String expectedresult,String actualresult)
	{
		Assert.assertEquals(expectedresult,actualresult);
	}
	
	
	
	public void Explicitwait(By locator)
	{ 
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
	}
	
	
	public void Validation1(ArrayList<String> beforesorting,ArrayList<String> aftersorting)
	{
		AssertJUnit.assertEquals(beforesorting,aftersorting);
	}
	
	public void Sorting()
	{
	try {
	List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));
	
	System.out.println(list.size());

	ArrayList<String> productlist=new ArrayList<String> ();
	String productname;
	
	for(int i=1;i<=list.size();i++)
	{
		 productname=	driver.findElement(By.xpath("(//div[@data-test='inventory-item-name'])["+i+"]")).getText();
		
		productlist.add(productname);
	}
	System.out.println(productlist);

      ArrayList<String> aftersorting = new ArrayList<String>();
      Collections.sort(productlist);
      aftersorting = productlist;
	Assert.assertEquals(productlist, aftersorting);
	
	}catch(Exception e)
	{
		System.out.println("Error");
	}
	}
	
	// -------- sorting descending
	public  ArrayList<String> sorting1()
	{
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));
		
		System.out.println(list.size());

		ArrayList<String> productlist=new ArrayList<String> ();
		String productname;
		try {
		for(int i=1;i<=list.size();i++)
		{
			 productname=	driver.findElement(By.xpath("(//div[@data-test='inventory-item-name'])["+i+"]")).getText();
			
			productlist.add(productname);
		}
		logger.info(" ARRAY LIST ");
		}
		catch(Exception e)
		{
			logger.error("Click is failed:" );
			logger.error(e.getMessage());
			Assert.fail();
		}
		System.out.println(productlist);
	
		return productlist;

	}
	// price low to high------
	
	public  ArrayList<String> price(){
		
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='inventory_list']//div[@class='inventory_item']"));
		System.out.println(list.size());
		ArrayList<String> pricelist=new ArrayList<String> ();
		String pricevalue;
		
		for(int i=1;i<=list.size();i++)
		{
			
			pricevalue= driver.findElement(By.xpath("(//div[@class='inventory_item_price'])["+i+"]")).getText();
			String pricevalue1= pricevalue.substring(1, 5);
			pricelist.add(pricevalue1);
		}
		return pricelist;
			
	}
		
}
