package com.eluxoneb2c.customlibrary;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.knacksystems.commonfunctionlibrary.FunctionalLibrary;

public class CustomLibraryB2C 
{

	public static void loginPage(WebDriver driver, String username, String pwd) 
	{
		 WebDriverWait wait=new WebDriverWait(driver,30);
		  
		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_username']")));
			driver.findElement(By.xpath("//input[@id='j_username']")).clear();
			driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(username);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_password']")));
			driver.findElement(By.xpath("//input[@id='j_password']")).clear();
			driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(pwd);
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginForm']/button")));
			driver.findElement(By.xpath("//*[@id='loginForm']/button")).click();
		
	}
	
	public static void typeJS(WebDriver driver, String locatorType, String locatorValue) throws AWTException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
		   WebElement ele=driver.findElement(By.xpath(locatorValue));
		   ele.clear();
		   js.executeScript("arguments[0].value='FFES3026TS';",ele);	   
		  
	    }
	}
	
	public static void paymentB2C(WebDriver driver)
	{
		System.out.println("Enter Name of Card");
		FunctionalLibrary.waitForElement(driver, "id", "name", "60");
		driver.findElement(By.id("name")).clear();
		driver.findElement(By.id("name")).sendKeys("Tom Holland");
		
		System.out.println("Enter Address Line 1");
		FunctionalLibrary.waitForElement(driver, "id", "address", "60");
		driver.findElement(By.id("address")).clear();
		driver.findElement(By.id("address")).sendKeys("B221, Bakers Street");
		
		System.out.println("Enter Address Line 1");
		FunctionalLibrary.waitForElement(driver, "id", "address2", "60");
		driver.findElement(By.id("address2")).clear();
		driver.findElement(By.id("address2")).sendKeys("174th Avenue");
		
		System.out.println("Enter City");
		FunctionalLibrary.waitForElement(driver, "id", "city", "60");
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Queens");
		
		System.out.println("Select Province / State");
		FunctionalLibrary.waitForElement(driver, "id", "state", "60");
		FunctionalLibrary.selectFunc(driver, "id", "state", "New York");
		
		System.out.println("Enter Postal Code");
		FunctionalLibrary.waitForElement(driver, "id", "postal_code", "60");
		driver.findElement(By.id("postal_code")).clear();
		driver.findElement(By.id("postal_code")).sendKeys("11365");
		
		System.out.println("Select Country");
		FunctionalLibrary.waitForElement(driver, "id", "country", "60");
		FunctionalLibrary.selectFunc(driver, "id", "country", "United States");
		
		System.out.println("Enter Card Number");
		FunctionalLibrary.waitForElement(driver, "id", "ccNumber", "60");
		driver.findElement(By.id("ccNumber")).clear();
		driver.findElement(By.id("ccNumber")).sendKeys("5112345112345114");
		
		System.out.println("Enter CVC Number");
		FunctionalLibrary.waitForElement(driver, "id", "CVV2", "60");
		driver.findElement(By.id("CVV2")).clear();
		driver.findElement(By.id("CVV2")).sendKeys("123");
		
		System.out.println("Select Card Type");
		FunctionalLibrary.waitForElement(driver, "id", "ccType", "60");
		FunctionalLibrary.selectFunc(driver, "id", "ccType", "Mastercard");
		
		System.out.println("Select Expiry Date");
		FunctionalLibrary.waitForElement(driver, "id", "expMonth", "60");
		FunctionalLibrary.selectFunc(driver, "id", "expMonth", "03");
		FunctionalLibrary.waitForElement(driver, "id", "expYear", "60");
		FunctionalLibrary.selectFunc(driver, "id", "expYear", "22");
		
		FunctionalLibrary.waitForElement(driver, "xpath", "//*[@id='completeButton']", "60");
		
		
		
		
		
		
	}
  
}
