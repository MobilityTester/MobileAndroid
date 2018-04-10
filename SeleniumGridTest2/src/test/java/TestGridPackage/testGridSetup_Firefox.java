package TestGridPackage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testGridSetup_Firefox {
	WebDriver driver;
	String baseURL, nodeURL, runOnLocalOrRemote; 
	
	@BeforeTest
	public void setupTest_Firefox() throws MalformedURLException {
		baseURL = "http://www.google.com";
		
		System.setProperty("webdriver.gecko.driver", "D:\\Tools\\Geckodriver_Firefox_Driver\\geckodriver.exe");
			
/*		DesiredCapabilities cap = new DesiredCapabilities();
		cap = DesiredCapabilities.firefox();
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);	
*/	
		FirefoxOptions cap = new FirefoxOptions();
		//cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WIN10);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		runOnLocalOrRemote = "node"; 	// "local" i.e. on *hub* OR "remote" i.e. on *node*
		if (runOnLocalOrRemote == "hub"){
			
			driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),cap);
			
		}else if (runOnLocalOrRemote == "node"){
			driver = new RemoteWebDriver(new URL("http://localhost:5555/wd/hub"),cap);
		}else {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		driver.manage().window().maximize();	
		
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

	@Test
	public void simpleTest(){
		driver.get(baseURL);		
		Assert.assertEquals("Google", driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	}
	
}