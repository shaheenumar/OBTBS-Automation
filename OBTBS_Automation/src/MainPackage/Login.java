package MainPackage;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelOps.ExcelRead;
import masterBeans.state;
import masterOps.stateMasterOps;


public class Login {
	public static void  main(String[] args) throws InterruptedException, IOException{
		
		//Declarations and initializations
		WebDriver foxDriver = new FirefoxDriver();
		//WebDriver foxDriver = new ChromeDriver();

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
		
		System.out.println("Closing browser");
		foxDriver.quit();
		
	}
	

}

