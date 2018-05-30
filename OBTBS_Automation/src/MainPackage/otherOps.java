package MainPackage;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class otherOps {
	
	
	
	//function refresh-button click - Common in most masters
	public void clickRefresh(WebDriver driver ){
		//Refresh Click
		driver.findElement(By.cssSelector(".panel > div:nth-child(1) > div:nth-child(2) > button:nth-child(1)")).click();
		driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)")).click();
	}
	
	
	//function to choose the corporation
	public static void chooseCorpFromTop(WebDriver driver,String corpName) throws InterruptedException{
		driver.findElement(By.cssSelector("#root-app > main > div > section > header > div > span:nth-child(5)")).click();
		
		//Choose corporation
		List<WebElement> list;
		list = driver.findElements(By.tagName("button"));
		System.out.println(list.size());
		list.get(2).click();
		
	
    	driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[3]")).click();
//		driver.findElement(By.xpath("//div/div//*[text()='State']")).click();
		
		Thread.sleep(2000);

		list.get(4).click();
				
	}
	

}
