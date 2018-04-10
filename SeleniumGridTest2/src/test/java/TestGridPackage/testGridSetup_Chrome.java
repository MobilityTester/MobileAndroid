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
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testGridSetup_Chrome {
	WebDriver driver;
	String baseURL, nodeURL, runOnLocalOrRemote; 
	
	@BeforeTest
	public void setupTest_Chrome() throws MalformedURLException {
		baseURL = "http://www.google.com";
		
		System.setProperty("webdriver.chrome.driver", "D:\\Tools\\chromedriver_win32\\chromedriver.exe");
	/*		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap = DesiredCapabilities.chrome();
		cap.setPlatform(org.openqa.selenium.Platform.WINDOWS);	
	*/
		ChromeOptions cap = new ChromeOptions();
		cap.setCapability(CapabilityType.PLATFORM_NAME, Platform.WINDOWS);
		cap.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		runOnLocalOrRemote = "node2"; 	// "local" i.e. on *hub* OR "remote" i.e. on *node*
		if (runOnLocalOrRemote == "node1"){
			
			//driver = new RemoteWebDriver(new URL("http://172.21.141.244:4444/wd/hub"),cap);
			driver = new RemoteWebDriver(new URL("http://172.21.55.152:5555/wd/hub"),cap);			
			System.out.println("--- Running test on HUB !!! ");
			
		}else if (runOnLocalOrRemote == "node2"){
			
			driver = new RemoteWebDriver(new URL("http://172.21.33.95:5555/wd/hub"),cap);			
			System.out.println("--- Running test on NODE !!! ");
		}else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
	}
	
	@AfterTest
	public void afterTest(){
		driver.quit();
	}

	@Test
	public void simpleTest() throws InterruptedException{
		driver.get(baseURL);		
		Assert.assertEquals("Google", driver.getTitle());
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
		Thread.sleep(5000);
	}
	
}