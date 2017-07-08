package masterOps;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import masterBeans.state;


public class stateMasterOps {
	
	String stateUrl ;
	
	public void addState(WebDriver driver,List<state> sts ,String url) throws InterruptedException{
		
		stateUrl =url + "state-master";
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Add State with random values
		driver.navigate().to(stateUrl);
		String cssSelector = "#root-app > div > div > section > main > header > div.app-shell__actions > button";
		
		Thread.sleep(2000);
		for(state st:sts) {
						
			WebElement btnAddState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
			System.out.println(btnAddState.getText());
			btnAddState.click();
            System.out.println(st.getStateName());
            System.out.println(st.getStateCode());
    		//driver.findElement(By.cssSelector(cssSelector)).click();
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("code")));
    		WebElement stateCode = driver.findElement(By.name("code"));
    		stateCode.sendKeys(st.getStateCode());
    		WebElement stateName = driver.findElement(By.name("name"));
    		stateName.sendKeys(st.getStateName());
    		driver.findElement(By.cssSelector("#root-app > div > div > section > main > section > section > section.panel__content > form > span.main-wrapper__btn > button:nth-child(2)")).click();
			Thread.sleep(2000);
		
		}
		
		
					
	}
	



}
