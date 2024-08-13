package com.saucedemo.testcases;

import org.openqa.selenium.WebDriver;

import com.saucedemo.objects.Web_objects;

public class LoginAndLogout {

	public void Login(WebDriver driver, String username, String password)
	{
		driver.findElement(Web_objects.username).sendKeys(username);	
		driver.findElement(Web_objects.password).sendKeys(password);
		driver.findElement(Web_objects.login).click();
	}
	public void Logout(WebDriver driver)
	{
		driver.quit();
	}
	
}
