import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelOps.ExcelRead;
import masterBeans.state;
import masterOps.stateMasterOps;


public class Login {
	public static void  main(String[] args) throws InterruptedException, IOException{
		
		//Declarations and initializations
		WebDriver foxDriver = new FirefoxDriver();
		String baseUrl = "http://otp-admin-qa.qburst.build/";
		
		String charSetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String charSetAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String charSetAlphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		WebElement tbUsername,tbPassword;
		WebDriverWait wait = new WebDriverWait(foxDriver, 10);
		
		List<WebElement> list;
		
		
		
		
		
	    //Navigating to url
		foxDriver.get(baseUrl);
		
		
		//Login - Username
		tbUsername  = foxDriver.findElement(By.name("username"));
		tbUsername.sendKeys("nirmal");
		
		//Login - Password
		tbPassword  = foxDriver.findElement(By.name("password"));
		tbPassword.sendKeys("qburst123");
		tbPassword.submit();
		
		
		
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.name("code")));
		Thread.sleep(5000);
		
		
		//Choose corporation
		list = foxDriver.findElements(By.tagName("button"));
		System.out.println(list.size());
		list.get(2).click();
		
		String xpath = "/html/body/div[3]/div/div/div/div[2]/span/div/div/div";
		foxDriver.findElement(By.xpath(xpath)).click();

		list.get(3).submit();		
		
		
		
		
		//Create an object of ReadExcel class
		ExcelRead objExcelFile = new ExcelRead();

		//Prepare the path of excel file
		String filePath = System.getProperty("user.dir");

		//Call read file method of the class to read data
		List<state> sts = objExcelFile.readExcel(filePath,"test.xlsx","state");
		
		
		
		//Add State
		stateMasterOps stateOb=new stateMasterOps();
		stateOb.addState(foxDriver,sts,baseUrl);
		
				
		foxDriver.quit();
		
	}
	
	public static String createRandomCode(int codeLength, String id) {   
	    List<Character> temp = id.chars()
	            .mapToObj(i -> (char)i)
	            .collect(Collectors.toList());
	    Collections.shuffle(temp, new SecureRandom());
	    return temp.stream()
	            .map(Object::toString)
	            .limit(codeLength)
	            .collect(Collectors.joining());
	}
	
	public void takeScreenshot(WebDriver driver){
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		 // now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File("/home/ults/Documents/error.png"));
		}
		catch (IOException e)
		 {
		  System.out.println(e.getMessage());
		 
		 }
	}
	

}
