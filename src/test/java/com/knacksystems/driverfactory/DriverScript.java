package com.knacksystems.driverfactory;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.dtfo.customlibrary.CustomLibrary;
import com.eluxoneb2c.customlibrary.CustomLibraryB2C;
import com.knacksystems.commonfunctionlibrary.FunctionalLibrary;
import com.knacksystems.utilities.ExcelFileUtil;
import com.knacksystems.utilities.PropertyFileUtil;

public class DriverScript 
{
	WebDriver driver;
	ExtentHtmlReporter path;
	ExtentReports report;
	ExtentTest logger;
	
	public void startTest() throws Throwable
	{
		ExcelFileUtil excel=new ExcelFileUtil();
		//In Excel Sheets, 1st row(0th row) contains headings. so, we've to start from second row. i.e., 1st row
		for(int i=1;i<=excel.rowCount("MasterTestCases");i++)
		{
			String ModuleStatus="";
			//Store modules in a variable
		  
			if(excel.getData("MasterTestCases", i, 2).equalsIgnoreCase("Y"))
			{
				String TCModule=excel.getData("MasterTestCases", i, 1);
							
				//Generating Reports
				path=new ExtentHtmlReporter("./Reports/"+PropertyFileUtil.getValueForKey("project_name")+"/"+TCModule+"_"+FunctionalLibrary.generateDate()+".html");
				report=new ExtentReports();
				report.attachReporter(path);
				logger=report.createTest(TCModule);
				
				int rowcount=excel.rowCount(TCModule);
				System.out.println("MTC ROW NO:"+rowcount);
				
				
				for(int j=1;j<=rowcount;j++)
				{
					System.out.println("ROW NO IN SHEET:"+j);
					String Description=excel.getData(TCModule, j, 0);
					//System.out.println("Description: "+Description);
					String Object_Type=excel.getData(TCModule, j, 1);
					String Locator_Type=excel.getData(TCModule, j, 2);
					String Locator_Value=excel.getData(TCModule, j, 3);
					String Test_Data=excel.getData(TCModule, j, 4);
					//System.out.println("Test data: "+Test_Data);
					
					try
					{
						if(Object_Type.equalsIgnoreCase("startBrowser"))
						{
							driver=FunctionalLibrary.startBrowser(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("openApplication"))
						{
							FunctionalLibrary.openApplication(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("clickAction"))
						{
							FunctionalLibrary.clickAction(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("typeAction"))
						{
							FunctionalLibrary.typeAction(driver,Locator_Type,Locator_Value,Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("waitForElement"))
						{
							FunctionalLibrary.waitForElement(driver, Locator_Type, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("closeApplication"))
						{
							FunctionalLibrary.closeApplication(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("titleValidation"))
						{
							FunctionalLibrary.titleValidation(driver, Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("captureData"))
						{
							FunctionalLibrary.captureData(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("mouseHoverActions"))
						{
							FunctionalLibrary.mouseHoverActions(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("dropDown"))
						{
							FunctionalLibrary.dropDown(driver, Locator_Type, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("datePicker"))
						{
							FunctionalLibrary.datePicker(driver, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("sleepTime"))
						{
							FunctionalLibrary.sleepTime(Test_Data);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("dragDrop"))
						{
							FunctionalLibrary.dragDrop(driver, Locator_Type, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("rightClick"))
						{
							FunctionalLibrary.rightClick(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("newTab"))
						{
							FunctionalLibrary.newTab(driver);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("switchTab"))
						{
							FunctionalLibrary.switchTab(driver, Test_Data);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("frameChange"))
						{
							FunctionalLibrary.frameChange(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("frameSize"))
						{
							FunctionalLibrary.frameSize(driver);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("waitForClickable"))
						{
							FunctionalLibrary.waitForClickable(driver, Locator_Type, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("backSpace"))
						{
							FunctionalLibrary.backSpace(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("btnjs"))
						{
							FunctionalLibrary.btnjs(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("links"))
						{
							FunctionalLibrary.links(driver);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("uploadFile"))
						{
							FunctionalLibrary.uploadFile(driver);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("openBackOffice"))
						{
							CustomLibrary.openBackOffice(driver);
							logger.log(Status.INFO, Description);
						}
						
						if(Object_Type.equalsIgnoreCase("signOut"))	
						{
							CustomLibrary.signOut(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("loginFunc"))
						{
							CustomLibrary.loginFunc(driver, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("cardDetails"))
						{
							CustomLibrary.cardDetails(driver, Locator_Type, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("paymentPage"))
						{
							CustomLibrary.paymentPage(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("loginPage"))
						{
							CustomLibraryB2C.loginPage(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("sendKeysJS"))
						{
							FunctionalLibrary.sendKeysJS(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("addressValidation"))
						{
							CustomLibrary.addressValidation(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("typeJS"))
						{
							CustomLibraryB2C.typeJS(driver, Locator_Type, Locator_Value);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("paymentB2C"))
						{
							CustomLibraryB2C.paymentB2C(driver);
							logger.log(Status.INFO, Description);
						}
						if(Object_Type.equalsIgnoreCase("selectFunc"))
						{
							FunctionalLibrary.selectFunc(driver, Locator_Type, Locator_Value, Test_Data);
							logger.log(Status.INFO, Description);
						}
						
											
						
						
						
						excel.setData(TCModule,j,5,"Pass");
						ModuleStatus="True";
						logger.log(Status.PASS, Description+" Pass");
					}//try block termination
					catch(Exception e)
					{
						excel.setData(TCModule, j, 5, "Fail");
						ModuleStatus="Fail";
						logger.log(Status.FAIL, Description+" Fail \n"+e.toString());
						//System.out.println(Description+" Fail \n"+e.toString());
						File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(src, new File("./Screenshots/"+PropertyFileUtil.getValueForKey("project_name")+"/"+Description+"_"+FunctionalLibrary.generateDate()+".jpg"));
						break;
					}
					catch(AssertionError a)
					{
						excel.setData(TCModule, j, 5, "Fail");
						ModuleStatus="Fail";
						logger.log(Status.FAIL, Description+" Fail \n"+a.toString());
						File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
						FileUtils.copyFile(src, new File("./Screenshots/"+PropertyFileUtil.getValueForKey("project_name")+"/"+Description+"_"+FunctionalLibrary.generateDate()+".jpg"));
						break;
					}
				}// J Loop Termination
				if(ModuleStatus.equalsIgnoreCase("True"))
				{
					excel.setData("MasterTestCases", i, 3, "Pass");
					//logger.log(Status.PASS," Pass");
				}
				else
				{
					excel.setData("MasterTestCases", i, 3, "Fail");
					//logger.log(Status.FAIL, "Fail");
				}
				report.flush();
			}//if condition termination
			else
			{
				excel.setData("MasterTestCases", i, 3, "NOT EXECUTED");
				//logger.log(Status.SKIP, "NOT EXECUTED");
			}			
		}	//I Loop Termination
	}
}
