package com.saucedemo.testcases;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.saucedemo.extentmanager.ExtentManager;
import com.saucedemo.utilities.ReadConfig;

public class BaseClass extends LoginAndLogout{
	public WebDriver driver;
	public String url;
	public String username;
	public String password;
	public ExtentManager extentmanagerreport;
	
	@BeforeSuite(alwaysRun = true)
	public void StartExtent()
	{
		extentmanagerreport=new ExtentManager();
		extentmanagerreport.StartExtentReport();
	}
	
@BeforeMethod
	
	public void SetUp() throws IOException, InterruptedException
	{
		ReadConfig credentials=new ReadConfig();
		url=credentials.geturl();
		username=credentials.getusername();
		password=credentials.getpassword();
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		Login(driver, username, password);
		Thread.sleep(3000);	
	}
	@AfterMethod
	public void tearDown()
	{
		Logout(driver);
	}
	@AfterSuite(alwaysRun = true)
	public void EndExtent()
	{
		extentmanagerreport.EndExtentReport();
	}

}
