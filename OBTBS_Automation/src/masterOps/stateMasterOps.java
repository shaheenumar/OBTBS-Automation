package masterOps;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.apache.commons.io.FileUtils;

public class stateMasterOps {
	

	String charSetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String charSetAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	String charSetAlphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	String stateUrl = "http://otp-admin-qa.qburst.build/state-master";
	
	public void addState(WebDriver driver) throws InterruptedException{
		
		
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//Add State with random values
		driver.navigate().to(stateUrl);
		String cssSelector = "#root-app > div > div > section > main > header > div.app-shell__actions > button";
		
		
		//Thread.sleep(2000);
		
		WebElement btnAddState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssSelector)));
		System.out.println(btnAddState.getText());
		
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
		
		
		btnAddState.click();
		
		
		//driver.findElement(By.cssSelector(cssSelector)).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("code")));
		WebElement stateCode = driver.findElement(By.name("code"));
		stateCode.sendKeys(createRandomCode(2,charSetUpper));
		WebElement stateName = driver.findElement(By.name("name"));
		stateName.sendKeys(createRandomCode(8,charSetAlpha));
		driver.findElement(By.cssSelector("#root-app > div > div > section > main > section > section > section.panel__content > form > span.main-wrapper__btn > button:nth-child(2)")).click();
					
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


}
