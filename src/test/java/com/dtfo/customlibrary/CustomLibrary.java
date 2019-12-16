package com.dtfo.customlibrary;

import java.awt.AWTException;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.knacksystems.commonfunctionlibrary.FunctionalLibrary;


public class CustomLibrary 
{
 public static void openBackOffice(WebDriver driver)
 {
	 driver.get("https://backoffice.cteili-oneworldt1-s1-public.model-t.cc.commerce.ondemand.com/backoffice/login.zul;jsessionid=51C3CEFB8CFBC5E282AC9B767F84FDC0.backoffice-f5c5b8f96-fvxxv");
 }
 public static void storeFinder(WebDriver driver)
 {
	 driver.get("https://accstorefront.cteili-oneworldt1-s1-public.model-t.cc.commerce.ondemand.com/store-finder");
 }
 
 public static void signOut(WebDriver driver) throws InterruptedException
 {
	 driver.findElement(By.xpath("//a[@href='/logout']")).click();
	 Thread.sleep(2000);
 }
 
 public static void loginFunc(WebDriver driver, String username, String pwd) throws InterruptedException
 {
	driver.findElement(By.xpath("/html/body/main/header/nav/div/div[1]/div/div/div/div/ul/li[2]/a")).click();
	
	WebDriverWait wait=new WebDriverWait(driver,30);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_username']")));
	driver.findElement(By.xpath("//input[@id='j_username']")).clear();
	driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys(username);
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='j_password']")));
	driver.findElement(By.xpath("//input[@id='j_password']")).clear();
	driver.findElement(By.xpath("//input[@id='j_password']")).sendKeys(pwd);
	Thread.sleep(3000);
	
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='loginForm']/button")));
	driver.findElement(By.xpath("//*[@id='loginForm']/button")).click();
 }
 
 public static void cardDetails(WebDriver driver, String cardNumber, String expiryDate, String cvv) throws InterruptedException
 {
	 String card,exp,cvvc;
	 card=cardNumber;
	 exp=expiryDate;
	 cvvc=cvv;
	 WebDriverWait wait=new WebDriverWait(driver,30);	 
	 
	 System.out.println("Enter Card Number");
	
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cardNum']")));
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//*[@id='cardNum']")).clear();
	 driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys(card);
	 Thread.sleep(4000);
	 
	 System.out.println("Enter Expiry Date");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='expiryDate']")));
	 driver.findElement(By.xpath("//*[@id='expiryDate']")).clear();
	 driver.findElement(By.xpath("//*[@id='expiryDate']")).sendKeys(exp);
	 
	 System.out.println("Enter CVV");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cvv']")));
	 driver.findElement(By.xpath("//*[@id='cvv']")).clear();
	 driver.findElement(By.xpath("//*[@id='cvv']")).sendKeys(cvvc);
	 
	 System.out.println("Click on Pay Button");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payBtn")));
	 driver.findElement(By.id("payBtn")).click();
 }
 
 public static void paymentPage(WebDriver driver) throws InterruptedException, AWTException
 {
	WebDriverWait wait=new WebDriverWait(driver,60);	 
	System.out.println("Enter Card Number"); 
 	/*JavascriptExecutor js = (JavascriptExecutor)driver;	 
 	WebElement ele=driver.findElement(By.xpath("//*[@id='cardNum']"));
	ele.clear();
	js.executeScript("arguments[0].value='5112345112345114';",ele);
	ele.clear();
	js.executeScript("arguments[0].value='5112345112345114';",ele);*/
	FunctionalLibrary.waitForElement(driver, "xpath", "//*[@id='cardNum']", "60");
	driver.findElement(By.xpath("//*[@id='cardNum']")).clear();
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("5");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("2");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("3");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("4");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("5");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("2");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("3");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("4");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("5");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("1");
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id='cardNum']")).sendKeys("4");
	Thread.sleep(1000);
	
	
	
	
 	 
	 System.out.println("Enter Expiry Date");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='expiryDate']")));
	 driver.findElement(By.xpath("//*[@id='expiryDate']")).clear();
	 driver.findElement(By.xpath("//*[@id='expiryDate']")).sendKeys("0323");
	 
	 System.out.println("Enter CVV");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cvv']")));
	 driver.findElement(By.xpath("//*[@id='cvv']")).clear();
	 driver.findElement(By.xpath("//*[@id='cvv']")).sendKeys("123");
	 
	  
	 System.out.println("Click on Pay Button");
	 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payBtn")));
	 driver.findElement(By.id("payBtn")).click();
	 
 }
 
 public static void addressValidation(WebDriver driver) throws InterruptedException
 {
	 System.out.println("Enter First Name");
	 FunctionalLibrary.waitForElement(driver, "id", "address.firstName", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.firstName", "Robert");
	 
	 System.out.println("Enter Last Name");
	 FunctionalLibrary.waitForElement(driver, "id", "address.surname", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.surname", "Holland");
	 
	 System.out.println("Enter Address Line 1");
	 FunctionalLibrary.waitForElement(driver, "id", "address.line1", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.line1", "584S, 234th Street,");
	 
	 System.out.println("Enter Address Line 2");
	 FunctionalLibrary.waitForElement(driver, "id", "address.line2", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.line2", "Bakery Street");
	 
	 System.out.println("Enter City");
	 FunctionalLibrary.waitForElement(driver, "id", "address.townCity", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.townCity", "Concord");
	 
	
	 System.out.println("Click on State Dropdown");
	 FunctionalLibrary.waitForElement(driver, "id", "address.region", "30");
	 FunctionalLibrary.clickAction(driver, "id", "address.region");
	 System.out.println("Select State / Provision");
	 FunctionalLibrary.waitForElement(driver, "xpath", "//*[@id='address.region']/option[36]", "30");
	 FunctionalLibrary.clickAction(driver, "xpath", "//*[@id='address.region']/option[36]");
	
	 System.out.println("Enter Zip / Postal Code");
	 FunctionalLibrary.waitForElement(driver, "id", "address.postcode", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.postcode", "100021");
	 
	 
	 System.out.println("Enter Phone Number");
	 FunctionalLibrary.waitForElement(driver, "id", "address.phone", "30");
	 FunctionalLibrary.typeAction(driver, "id", "address.phone", "4032546783"); 
	 
	 System.out.println("Click on Next Button");
	 FunctionalLibrary.waitForElement(driver, "xpath", "//*[@id='addressSubmit']", "30");
	 FunctionalLibrary.clickAction(driver, "xpath", "//*[@id='addressSubmit']");
 }
 
 
 public static void passwordUpdate(WebDriver driver, String pwd) throws InterruptedException
	{
		String t="30";
		
	System.out.println("Enter New Password");
	//give new password locators
	FunctionalLibrary.waitForElement(driver, "id", "newPassword", t);
	FunctionalLibrary.clearText(driver, "id", "newPassword");
	FunctionalLibrary.typeAction(driver, "id","newPassword",pwd);
	
	System.out.println("Enter Confirm New Password");
	//give new password locators
	FunctionalLibrary.waitForElement(driver, "id", "checkNewPassword", t);
	FunctionalLibrary.clearText(driver, "id", "checkNewPassword");
	FunctionalLibrary.typeAction(driver, "id","checkNewPassword",pwd);
	
	}


	 public static void payment(WebDriver driver, String CardNum, String exp,String cvv) throws InterruptedException
	   {
		   WebDriverWait wait=new WebDriverWait(driver,60);	
		   JavascriptExecutor js = (JavascriptExecutor)driver;	 
			System.out.println("Enter Card Number"); 
			String cn=CardNum;
			System.out.println(cn);
			   String s="";
		   int i;
		   int size=CardNum.length();
		   WebElement ele=driver.findElement(By.xpath("//*[@id='cardNum']"));
		   	FunctionalLibrary.waitForElement(driver, "xpath", "//*[@id='cardNum']", "30");
			ele.clear();
			
			for(i=0;i<size;i++)
			{
				char c=cn.charAt(i);
				s=new StringBuilder().append(c).toString();
				ele.sendKeys(s);
				//js.executeScript("arguments[0].value='[\" + s + \"]';",ele);
				Thread.sleep(1000);
			}
			
			 System.out.println("Enter Expiry Date");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='expiryDate']")));
			 driver.findElement(By.xpath("//*[@id='expiryDate']")).clear();
			 driver.findElement(By.xpath("//*[@id='expiryDate']")).sendKeys(exp);
			 
			 System.out.println("Enter CVV");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='cvv']")));
			 driver.findElement(By.xpath("//*[@id='cvv']")).clear();
			 driver.findElement(By.xpath("//*[@id='cvv']")).sendKeys(cvv);
			 
			  
			 System.out.println("Click on Pay Button");
			 wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("payBtn")));
			 driver.findElement(By.id("payBtn")).click();
	   }
 }

