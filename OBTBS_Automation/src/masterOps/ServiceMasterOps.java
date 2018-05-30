package masterOps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ServiceMasterOps {
	WebElement Tripcode,RouteNo,SourceDropdownBtn,DestinationDropdownBtn,SourceChoice;
	public void addService(WebDriver driver,String pls ,String url) throws InterruptedException{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.navigate().to(url+"service-master/master/add");
		wait.until(ExpectedConditions.textToBe(By.tagName("h1"), "Add Service"));
		System.out.println("Navigated to - Add Service");
		
		
		Tripcode = driver.findElements(By.tagName("input")).get(0);
		RouteNo = driver.findElements(By.tagName("input")).get(1);
		SourceDropdownBtn = driver.findElements(By.tagName("button")).get(3);
		DestinationDropdownBtn = driver.findElements(By.tagName("button")).get(3);
		
		
		
		Tripcode.sendKeys("1230TVMKKD");
		RouteNo.sendKeys("AC20123");
		SourceDropdownBtn.click();
		SourceChoice = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()[contains(.,' (AYR)')]]")));
		SourceChoice.click();
		
		
		Thread.sleep(2000);
		
		
		
	}

}
