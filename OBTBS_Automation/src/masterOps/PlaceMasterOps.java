package masterOps;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MainPackage.otherOps;
import masterBeans.place;

public class PlaceMasterOps {
	otherOps Ops = new otherOps();
	
	public void addPlace(WebDriver driver,List<place> pls ,String url) throws InterruptedException{
	
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		driver.navigate().to(url+"place-master");
		System.out.println("Add State");
		
		
		Thread.sleep(3000);
		for(place pl:pls) {
			
    		//Checking for duplication message
    		Boolean isPresent = driver.findElements(By.cssSelector(".panel > div:nth-child(3) > button:nth-child(2)")).size() > 0 ;
    		System.out.println(isPresent);
    		//handling the entry duplication
    		if(isPresent == false){
    			WebElement btnAddPlace = driver.findElement(By.cssSelector(".app-shell__actions > button:nth-child(2)"));
    			System.out.println(btnAddPlace.getText());
    			btnAddPlace.click();
    		}else{
    			
    			Ops.clickRefresh(driver);
    			
    		}
    			
    		
						
			
            System.out.println(pl.getPlaceName());
   
            
//    		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("code")));
//    		WebElement stateCode = driver.findElement(By.name("code"));
//    		stateCode.sendKeys(st.getStateCode());
//    		WebElement stateName = driver.findElement(By.name("name"));
//    		stateName.sendKeys(st.getStateName());
//    		driver.findElement(By.cssSelector(".panel > div:nth-child(3) > button:nth-child(2)")).click();
//    		Thread.sleep(2000);

		
		}
		
		
					
	}
	


}
