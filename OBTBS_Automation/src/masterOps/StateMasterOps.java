package masterOps;


import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import masterBeans.state;
import MainPackage.*;

public class StateMasterOps {
	
	
	otherOps Ops = new otherOps();
	
	public void addState(WebDriver driver,List<state> sts ,String url) throws InterruptedException{
	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Add State with random values
		driver.navigate().to(url+"state-master");
		System.out.println("Add State");
		
		
		Thread.sleep(3000);
		for(state st:sts) {
			
    		//Checking for duplication message
    		Boolean isPresent = driver.findElements(By.cssSelector(".panel > div:nth-child(3) > button:nth-child(2)")).size() > 0 ;
    		System.out.println(isPresent);
    		//handling if the entry is duplication
    		if(isPresent == false){
    			WebElement btnAddState = driver.findElement(By.cssSelector(".app-shell__actions > button:nth-child(2)"));
    			System.out.println(btnAddState.getText());
    			btnAddState.click();
    		}else{
    			
    			Ops.clickRefresh(driver);
    			
    		}
    			
    		
						
			
            System.out.println(st.getStateName());
            System.out.println(st.getStateCode());
            
    		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("code")));
    		WebElement stateCode = driver.findElement(By.name("code"));
    		stateCode.sendKeys(st.getStateCode());
    		WebElement stateName = driver.findElement(By.name("name"));
    		stateName.sendKeys(st.getStateName());
    		driver.findElement(By.cssSelector(".panel > div:nth-child(3) > button:nth-child(2)")).click();
    		Thread.sleep(2000);

		
		}
		
		
					
	}
	



}
