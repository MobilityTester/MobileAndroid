package appium;
 
import io.appium.java_client.android.AndroidDriver;
 
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
 
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
 
public class AppiumDriverBase {
 
    protected AndroidDriver driver;
    protected WebDriverWait wait;
 
    //Before Test Annotation makes a java function to run every time before a TestNG test case
    @BeforeTest
    protected void createAppiumDriver() throws MalformedURLException, InterruptedException {
 
    //relative path to apk file
    final File classpathRoot = new File(System.getProperty("user.dir"));
    final File appDir = new File(classpathRoot, "src/test/resources/apps/");
    final File app = new File(appDir, "Minty.apk");
 
    //setting up desired capability
  DesiredCapabilities caps = new DesiredCapabilities();
  	caps.setCapability("browserName", "");
    caps.setCapability("platform", "ANDROID");    
    caps.setCapability("platformVersion", "7.0");
    
    caps.setCapability("automationName", "uiautomator2"); //uiautomator2, Appium
	// 	Package Name and Launcher activity of app	
	caps.setCapability("appPackage", "com.financialhospital.admin.finh");
	caps.setCapability("appActivity", "com.financialhospital.admin.finh.MainActivity");
	caps.setCapability("app", app.getAbsolutePath());
    caps.setCapability("autoGrantPermissions", "true");

    caps.setCapability("deviceName", "ANDROID");
    caps.setCapability("autoGrantPermissions", "true");
    caps.setCapability("automationName", "uiautomator2"); //uiautomator2, Appium
    //relative path to apk file
   
    //initializing driver object
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    //initializing explicit wait object
    wait = new WebDriverWait(driver, 10);
    }
 
    //After Test Annotation makes a java function to run every time after a TestNG test case
    @AfterTest
    public void afterTest(){
    //driver.close();	
    //quit the driver
    driver.quit();
    }
 
}