package MainPackage;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import ExcelOps.ExcelRead;
import masterBeans.place;
import masterBeans.state;
import masterOps.PlaceMasterOps;
import masterOps.ServiceMasterOps;
import masterOps.StateMasterOps;
import UtilityOps.UtitlityOps;


public class Login {
	public static void  main(String[] args) throws InterruptedException, IOException{
		
		//Initialization of Web-driver
	      WebDriver driver = new FirefoxDriver();
	    //WebDriver driver= new HtmlUnitDriver();
		//WebDriver driver = new ChromeDriver();
		
	    //Defining implicit wait of 10 seconds
	      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      
	      WebDriverWait wait = new WebDriverWait(driver, 3);
	 
	      
	    //Base URL
		String baseUrl = "http://qa.otp-admin.qburst.build/";
		

		WebElement tbUsername,tbPassword;
		
		
		
				
	    //Navigating to url
		driver.get(baseUrl);
		
		
		
		//Login - Username
		tbUsername  = driver.findElement(By.name("username"));
		tbUsername.sendKeys("shaheen");
		
		//Login - Password
		tbPassword  = driver.findElement(By.name("password"));
		tbPassword.sendKeys("12345678");
		tbPassword.submit();
				
	
		//Wait until redirected to dashboard
		WebElement dashboardHeading = wait.
				until(ExpectedConditions.
				 presenceOfElementLocated(By.
				  cssSelector("#root-app > main > div > section > main > header > div.app-shell__header-container > h1")));
		
		wait.
		 until(ExpectedConditions.
		  invisibilityOfElementLocated(By.
		   xpath("//*[@id=\"root-app\"]/main/div/section/main/section/div[1]/div[1]/div/div/svg")));
		
		System.out.println("Successfully logged In");
		
		
		//Choosing among multiple corporations
		//otherOps.chooseCorpFromTop(driver,"KSRTC");
		
		
				
		
		//Create an object of ReadExcel class
		//ExcelRead objExcelFile = new ExcelRead();
	    
		//Read State data from excel
    	//List<state> sts = objExcelFile.readStatesFromExcel("test.xlsx","state");
    	
    	//Read Place data from excel
    	//List<place> pls = objExcelFile.readPlacesFromExcel("test.xlsx","Place");
    	
		//Thread.sleep(2000);
		
		
		//AddPlace
		//PlaceMasterOps placeOb=new PlaceMasterOps();
		//placeOb.addPlace(driver, pls, baseUrl);
		
    	//Add State
		//StateMasterOps stateOb=new StateMasterOps();
		//stateOb.addState(driver,sts,baseUrl);
		
		//Add Service
		ServiceMasterOps serviceOb=new ServiceMasterOps(); 
		serviceOb.addService(driver,"services",baseUrl);
		
		//Take screenshot
		UtilityOps.UtitlityOps.takeScreenshot(driver, "Before_Closing_Browser");

		
		System.out.println("Closing browser...");
		driver.quit();
		
	}
}

