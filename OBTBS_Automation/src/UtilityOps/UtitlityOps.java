package UtilityOps;

import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class UtitlityOps {
	
	String charSetUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String charSetAlpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	String charSetAlphanum = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
	
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
	
	
	//function take screenshot
	public static void takeScreenshot(WebDriver driver,String screenshotName){
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			// now copy the  screenshot to desired location using copyFile //method
			FileUtils.copyFile(src, new File("/home/ults/Documents/"+screenshotName+".png"));
			System.out.println("Screen-Shot Taken.");
		}
		catch (IOException e){
			System.out.println(e.getMessage());
		 }
	}	
	
	

}
