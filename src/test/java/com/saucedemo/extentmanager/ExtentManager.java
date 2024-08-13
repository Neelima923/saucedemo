package com.saucedemo.extentmanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter spark;
	public static ExtentTest test;
	
	public void StartExtentReport()
	{
		DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYYY-MM-DD HH-mm-ss");
		LocalDateTime time= LocalDateTime.now();
		String date=dtf.format(time).toString();
		
		extent=new ExtentReports();
		spark=new ExtentSparkReporter("./Reports/"+date+"sample.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setDocumentTitle("TEST REPORT");
		extent.attachReporter(spark);
		
	}
	public void CreateTest(String testcasename)
	{
		test=extent.createTest(testcasename);
	}
	
	public void AddTestCaseSteps(String step)
	{
		test.info(step);
		
	}
	
	public void EndExtentReport()
	{
		extent.flush();
	}
}


