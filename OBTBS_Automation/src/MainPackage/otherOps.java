package MainPackage;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class otherOps {
	

	
	//function refresh-button click - Common in most masters
	public void clickRefresh(WebDriver driver ){
		//Refresh Click
		driver.findElement(By.cssSelector(".panel__header > button:nth-child(2)")).click();
		driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)")).click();
	}

}
