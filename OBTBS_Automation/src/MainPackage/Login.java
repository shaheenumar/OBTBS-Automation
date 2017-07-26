package MainPackage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelOps.ExcelRead;
import masterBeans.state;
import masterOps.stateMasterOps;
import UtilityOps.UtitlityOps;


public class Login {
	public static void  main(String[] args) throws InterruptedException, IOException{
		
		//Declarations and initializations
		WebDriver driver = new FirefoxDriver();
		//WebDriver driver = new ChromeDriver();

		String baseUrl = "http://otp-admin-qa.qburst.build/";
		

		WebElement tbUsername,tbPassword;
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		List<WebElement> list;
		
				
	    //Navigating to url
		driver.get(baseUrl);
		
		
		
		//Login - Username
		tbUsername  = driver.findElement(By.name("username"));
		tbUsername.sendKeys("superadmin");
		
		//Login - Password
		tbPassword  = driver.findElement(By.name("password"));
		tbPassword.sendKeys("ults@123");
		tbPassword.submit();
		
		
//		//Wait until page load
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"root-app\"]/div/div/section/main/section/div/div/div/section[2]/form/button")));
//		//driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
//		//Thread.sleep(5000);
//		
//		
//		//Choose corporation
//		list = driver.findElements(By.tagName("button"));
//		System.out.println(list.size());
//		list.get(2).click();
//		
//		String xpath = "/html/body/div[3]/div/div/div/div[2]/span/div/div/div";
//		driver.findElement(By.xpath(xpath)).click();
//
//		list.get(3).submit();		
//		
		
		
		
		//Create an object of ReadExcel class
		ExcelRead objExcelFile = new ExcelRead();
		//Call read file method of the class to read data
		List<state> sts = objExcelFile.readStatesFromExcel("test.xlsx","state");
		
		
		
		//Add State
		stateMasterOps stateOb=new stateMasterOps();
		stateOb.addState(driver,sts,baseUrl);
		UtilityOps.UtitlityOps.takeScreenshot(driver, "sreenshot");
		System.out.println("Closing browser...");
		driver.quit();
		
	}
	

}

