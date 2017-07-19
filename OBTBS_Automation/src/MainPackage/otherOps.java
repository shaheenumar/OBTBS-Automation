package MainPackage;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class otherOps {
	
	//function to create random string 
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
	
	//function refresh-button click
	public void refresh(WebDriver driver ){
		//Refresh Click
		driver.findElement(By.cssSelector(".panel__header > button:nth-child(2)")).click();
		driver.findElement(By.cssSelector("body > div:nth-child(7) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > button:nth-child(2)")).click();
	}
	
	//function take screenshot
	public void takeScreenshot(WebDriver driver){
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("/home/ults/Documents/error.png"));
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		 }
	}	

}
