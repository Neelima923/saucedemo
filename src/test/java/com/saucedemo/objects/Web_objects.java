package com.saucedemo.objects;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Web_objects {
	WebDriver driver=new ChromeDriver();
	//--------- LOGIN---------
	
	
	public static By username= By.id("user-name");
	public static By password= By.id("password");
	public static By login=By.id("login-button");
	
	// --------- Add to cart --------- validation 
	
	public static By addtocart= By.id("add-to-cart-sauce-labs-backpack");
	public static By actualname= By.xpath("(//div[@data-test='inventory-item-name'])[1]");
	public static By addtocartxpath= By.xpath("//span[@class='shopping_cart_badge']");
	public static By expectedname=By.xpath("//div[@data-test='inventory-item-name']");
//-----------------changing drop down
	
	public static By dropdown=By.xpath("//select[@class='product_sort_container']//option[@value='za']");
	//select[@class='product_sort_container']//option[@value='za']
	//select[@class='product_sort_container']//option[@value='lohi']
	public static By dropdownforlowtohigh=By.xpath("//select[@class='product_sort_container']//option[@value='lohi']");
	public static By dropdownforhightolow=By.xpath("//select[@class='product_sort_container']//option[@value='hilo']");
}



