package com.knacksystems.commonfunctionlibrary;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

// import static io.github.bonigarcia.wdm.DriverManagerType.CHROME;
import com.knacksystems.utilities.PropertyFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalLibrary 
{
	//WebDriver driver;
	public static WebDriver startBrowser(WebDriver driver) throws Throwable
	{
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		if(PropertyFileUtil.getValueForKey("Browser").equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
	public static void openApplication(WebDriver driver) throws Throwable
	{
		driver.get(PropertyFileUtil.getValueForKey("URL"));
	}
	
	public static void closeApplication(WebDriver driver)
	{
		driver.close();
	}
	
	public static void clickAction(WebDriver driver, String locatorType, String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			driver.findElement(By.cssSelector(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			driver.findElement(By.className(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			driver.findElement(By.tagName(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			driver.findElement(By.linkText(locatorValue)).click();
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			driver.findElement(By.partialLinkText(locatorValue)).click();
		}
	}
	
	public static void typeAction(WebDriver driver, String locatorType, String locatorValue, String data) throws InterruptedException
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			driver.findElement(By.id(locatorValue)).clear();
			driver.findElement(By.id(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			driver.findElement(By.name(locatorValue)).clear();
			driver.findElement(By.name(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			//driver.findElement(By.xpath(locatorValue)).clear();
			/*Thread.sleep(4000);
			backSpace(driver,locatorType,locatorValue);*/
			driver.findElement(By.xpath(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			//driver.findElement(By.cssSelector(locatorValue)).clear();
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			driver.findElement(By.className(locatorValue)).clear();
			driver.findElement(By.className(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			driver.findElement(By.tagName(locatorValue)).clear();
			driver.findElement(By.tagName(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			driver.findElement(By.linkText(locatorValue)).clear();
			driver.findElement(By.linkText(locatorValue)).sendKeys(data);
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			driver.findElement(By.partialLinkText(locatorValue)).clear();
			driver.findElement(By.partialLinkText(locatorValue)).sendKeys(data);
		}
	}
	
	public static void titleValidation(WebDriver driver, String exp_title)
	{
		String act_title=driver.getTitle();
		Assert.assertEquals(act_title, exp_title);
	}
	
	public static String generateDate()
	{
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/YYYY");
		return sdf.format(date);
	}
	
	public static void captureData(WebDriver driver, String locatorType, String locatorValue) throws Throwable
	{
		Thread.sleep(3000);
		String data="";
		if(locatorType.equalsIgnoreCase("id"))
		{
			data=driver.findElement(By.id(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			data=driver.findElement(By.name(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			data=driver.findElement(By.xpath(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			data=driver.findElement(By.className(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			data=driver.findElement(By.tagName(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			data=driver.findElement(By.partialLinkText(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			data=driver.findElement(By.cssSelector(locatorValue)).getAttribute("value");
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			data=driver.findElement(By.linkText(locatorValue)).getAttribute("value");
		}
		
		FileWriter fw=new FileWriter("./CapturedData/Data.txt");
		BufferedWriter bw=new BufferedWriter(fw);
		bw.write(data);
		bw.flush();
		bw.close();
	}
	
	public static void mouseHoverActions(WebDriver driver, String locatorType, String locatorValue)
	{
		Actions a=new Actions(driver);
		if(locatorType.equalsIgnoreCase("id"))
		{
			WebElement locator=driver.findElement(By.id(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			WebElement locator=driver.findElement(By.name(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			WebElement locator=driver.findElement(By.xpath(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			WebElement locator=driver.findElement(By.className(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			WebElement locator=driver.findElement(By.tagName(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			WebElement locator=driver.findElement(By.partialLinkText(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			WebElement locator=driver.findElement(By.cssSelector(locatorValue));
			a.moveToElement(locator).perform();
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			WebElement locator=driver.findElement(By.linkText(locatorValue));
			a.moveToElement(locator).perform();
		}
			
	}
	
	public static void dropDown(WebDriver driver, String locatorType, String locatorValue, String data)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			Select s=new Select(driver.findElement(By.id(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			Select s=new Select(driver.findElement(By.name(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			Select s=new Select(driver.findElement(By.xpath(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			Select s=new Select(driver.findElement(By.className(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			Select s=new Select(driver.findElement(By.tagName(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			Select s=new Select(driver.findElement(By.partialLinkText(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			Select s=new Select(driver.findElement(By.cssSelector(locatorValue)));
			s.selectByVisibleText(data);
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			Select s=new Select(driver.findElement(By.linkText(locatorValue)));
			s.selectByVisibleText(data);
		}
	}
	
	public static void datePicker(WebDriver driver, String locatorValue, String data)
	{
		((JavascriptExecutor)driver).executeScript("document.getElementById(' "+locatorValue+"').value='" +data+ " ' ");
	}
	
	public static void sleepTime(String time) throws Throwable
	{
		int t=Integer.parseInt(time);
		Thread.sleep(t);
	}
	
	public static void dragDrop(WebDriver driver, String locatorType, String locatorValue, String data)
	{
		Actions a=new Actions(driver);
		if(locatorType.equalsIgnoreCase("id"))
		{
			WebElement src=driver.findElement(By.id(locatorValue));
			WebElement dest=driver.findElement(By.id(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			WebElement src=driver.findElement(By.name(locatorValue));
			WebElement dest=driver.findElement(By.name(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			WebElement src=driver.findElement(By.xpath(locatorValue));
			WebElement dest=driver.findElement(By.xpath(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			WebElement src=driver.findElement(By.className(locatorValue));
			WebElement dest=driver.findElement(By.className(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			WebElement src=driver.findElement(By.tagName(locatorValue));
			WebElement dest=driver.findElement(By.tagName(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			WebElement src=driver.findElement(By.partialLinkText(locatorValue));
			WebElement dest=driver.findElement(By.partialLinkText(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			WebElement src=driver.findElement(By.cssSelector(locatorValue));
			WebElement dest=driver.findElement(By.cssSelector(data));
			a.dragAndDrop(src, dest).build().perform();
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			WebElement src=driver.findElement(By.linkText(locatorValue));
			WebElement dest=driver.findElement(By.linkText(data));
			a.dragAndDrop(src, dest).build().perform();
		}
			
	}
	
	public static void rightClick(WebDriver driver, String locatorType, String locatorValue)
	{
		Actions a=new Actions(driver);
		if(locatorType.equalsIgnoreCase("id"))
		{
			WebElement e=driver.findElement(By.id(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			WebElement e=driver.findElement(By.name(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			WebElement e=driver.findElement(By.xpath(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			WebElement e=driver.findElement(By.className(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			WebElement e=driver.findElement(By.tagName(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			WebElement e=driver.findElement(By.partialLinkText(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			WebElement e=driver.findElement(By.cssSelector(locatorValue));
			a.contextClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			WebElement e=driver.findElement(By.linkText(locatorValue));
			a.contextClick(e).perform();
		}
			
	}
	
	public static void doubleClick(WebDriver driver, String locatorType, String locatorValue)
	{
		Actions a=new Actions(driver);
		if(locatorType.equalsIgnoreCase("id"))
		{
			WebElement e=driver.findElement(By.id(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			WebElement e=driver.findElement(By.name(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			WebElement e=driver.findElement(By.xpath(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			WebElement e=driver.findElement(By.className(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			WebElement e=driver.findElement(By.tagName(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			WebElement e=driver.findElement(By.partialLinkText(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			WebElement e=driver.findElement(By.cssSelector(locatorValue));
			a.doubleClick(e).perform();
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			WebElement e=driver.findElement(By.linkText(locatorValue));
			a.doubleClick(e).perform();
		}
			
	}
	

	public static void waitForElement(WebDriver driver, String locatorType, String locatorValue, String data) 
	{
		int t=Integer.parseInt(data);
		WebDriverWait wait=new WebDriverWait(driver,t);
		if(locatorType.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("className"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("tagName"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("linkText"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("partialLinkText"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(locatorValue)));
			
		}
	}
	
	public static void switchTab(WebDriver driver, String windownum)
	{
		int num=Integer.parseInt(windownum);   
		List<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		driver.switchTo().window(tabs.get(num)); //switches to new tab
	}

	public static void newTab(WebDriver driver) 
	{
		((JavascriptExecutor)driver).executeScript("window.open()");
	}
	
	public static void frameChange(WebDriver driver, String locatorType, String locatorValue)
	{
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("NO.OF FRAMES ARE: "+size);
		WebElement ele;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			ele=driver.findElement(By.xpath(locatorValue));
			for(int i=0;i<size;i++)
			{
				if(ele.isDisplayed())
				{
					System.out.println("Locator found in this frame");
					driver.switchTo().frame(i);
				}
				else
				{
					System.out.println("Not Found in this Frame");
				}
			}
			driver.switchTo().defaultContent();
		}
		
	}
	
	public static void frameSwitch(WebDriver driver)
	{
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("NO.OF FRAMES ARE: "+size);
		driver.switchTo().frame(0);
	}
	
	public static void waitForClickable(WebDriver driver, String locatorType, String locatorValue, String data)
	{
		int t=Integer.parseInt(data);
		WebDriverWait wait=new WebDriverWait(driver,t);
		if(locatorType.equalsIgnoreCase("id"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.id(locatorValue)));
		}
		
		if(locatorType.equalsIgnoreCase("name"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.name(locatorValue)));
		}
		
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath(locatorValue)));
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(locatorValue)));
		}
	}
	
	public static void backSpace(WebDriver driver, String locatorType, String locatorValue) 
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
			//driver.findElement(By.id(locatorValue)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			driver.findElement(By.id(locatorValue)).sendKeys(Keys.DELETE);
			driver.findElement(By.id(locatorValue)).sendKeys(Keys.BACK_SPACE);
		}
		if(locatorType.equalsIgnoreCase("cssSelector"))
		{
			driver.findElement(By.cssSelector(locatorValue)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		}
		
	}
	
	public static void btnjs(WebDriver driver,String locatorType,String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("id"))
		{
		    WebElement element=driver.findElement(By.id(locatorValue));
			JavascriptExecutor js = (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].click();", element);
	    }
	}
	
	public static void links(WebDriver driver) throws Throwable, MalformedURLException
	{
		 String url="";
		 HttpURLConnection huc = null;
	     int respCode = 200;
		 List<WebElement> links = driver.findElements(By.tagName("a"));
	     Iterator<WebElement> it = links.iterator();
	     while(it.hasNext())
	     {
	    	 url=it.next().getAttribute("href");
	    	 System.out.println(url);
	    	    	    	 
	    	 try
	    	 {
	    		huc=(HttpURLConnection)new URL(url).openConnection();
	    		huc.setRequestMethod("HEAD");
	    		huc.connect();
	    		respCode=huc.getResponseCode();
	    		if(respCode==200)
	    		{
	    			System.out.println(url+" is a Valid Link");
	    			
	    		}
	    		else
	    		{
	    			System.out.println(url+" is a broken Link");
	    			 
	    		}
	    	 }
	    	 catch(MalformedURLException mfe)
	    	 {
	    		 mfe.printStackTrace();
	    	 }
	    	 catch(Exception e)
	    	 {
	    		 e.printStackTrace();
	    	 }
	     }
	}
	
	public static void uploadFile(WebDriver driver, String data) throws AWTException, InterruptedException
	{
		
		String path = data;
		StringSelection ss=new StringSelection(path);
		Clipboard cb=Toolkit.getDefaultToolkit().getSystemClipboard();
		cb.setContents(ss, ss);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(5000);
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	public static void sendKeysJS(WebDriver driver, String locatorType, String locatorValue) throws AWTException, InterruptedException
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		if(locatorType.equalsIgnoreCase("xpath"))
		{
		   WebElement ele=driver.findElement(By.xpath(locatorValue));
		   ele.clear();
		   js.executeScript("arguments[0].value='3566000020000410';",ele);	   
		  
	    }
	}
	
	public static void selectFunc(WebDriver driver,String locatorType, String locatorValue, String data)
	{
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			Select s=new Select(driver.findElement(By.xpath(locatorValue)));
			s.selectByVisibleText(data);
		}
		
		if(locatorType.equalsIgnoreCase("id"))
		{
			Select s=new Select(driver.findElement(By.id(locatorValue)));
			s.selectByVisibleText(data);
		}
	}
	
	public static void keyActions(WebDriver driver, String action) throws AWTException
	{
		Robot r=new Robot();
		if(action.equalsIgnoreCase("Tab"))
		{
			r.keyPress(KeyEvent.VK_TAB);
			r.keyRelease(KeyEvent.VK_TAB);
		}
		
		if(action.equalsIgnoreCase("Select All"))
		{
			r.keyPress(KeyEvent.VK_CONTROL);
			r.keyPress(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_A);
			r.keyRelease(KeyEvent.VK_CONTROL);
		}
	}
	
	public static void clearText(WebDriver driver, String locatorType, String locatorValue)
	{
		if(locatorType.equalsIgnoreCase("xpath"))
		{
			driver.findElement(By.xpath(locatorValue)).clear();
		}
	}
	
	public static void quitWin(WebDriver driver)
	{
		driver.quit();
	}
}
