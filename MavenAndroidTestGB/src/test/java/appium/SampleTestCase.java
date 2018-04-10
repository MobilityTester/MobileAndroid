package appium;

import io.appium.java_client.MobileBy;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class SampleTestCase extends AppiumDriverBase{
 
    //Test Annotation changes any java function to TestNG test case
    @Test
    public void sampeTest(){
 
		System.out.println("*******Inside test******** "+new SimpleDateFormat("dd-MM-YYYY hh mm ss").format(new Date()));
	   	
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 String pck_name = "com.financialhospital.admin.finh:id/";
		 /* Click on 'Calculator' */
		 WebElement btn_Calculator=driver.findElement(By.id(pck_name+"calculator"));
		 btn_Calculator.click();
		 /* Click on 'SIP Calculator' */		 
		 WebElement btn_SIPCalculator=driver.findElement(By.xpath("//android.widget.TextView[@text='SIP Calculator']"));
		 btn_SIPCalculator.click();
		 /* Click on '+' */
		 try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 WebElement btn_plusMonthlyContribution=driver.findElement(By.id(pck_name+"increase"));
		 btn_plusMonthlyContribution.click();
		 btn_plusMonthlyContribution.click();
		 btn_plusMonthlyContribution.click();
		 WebElement btn_plusTimeLeft=driver.findElement(By.id(pck_name+"increase1"));
		 btn_plusTimeLeft.click();
		 btn_plusTimeLeft.click();
		 btn_plusTimeLeft.click();
		 /* RoR */
		 WebElement btn_plusRoR=driver.findElement(By.id(pck_name+"increase3"));
		 btn_plusRoR.click();
		 btn_plusRoR.click();
		 btn_plusRoR.click();
		 
		 WebElement btn_Calculate=driver.findElement(By.id(pck_name+"calculate"));
		 btn_Calculate.click();
		 
		 /* Validate Output */
		 WebElement btn_output1=driver.findElement(By.id(pck_name+"text1"));
		 String text1 = btn_output1.getText();
		 System.out.println( "Amount Invested: " + text1.toString());

		 WebElement btn_output2=driver.findElement(By.id(pck_name+"text3"));
		 String text2 = btn_output2.getText();
		 System.out.println( "Amount You Will Get: " + text2.toString());

		 WebElement btn_output3=driver.findElement(By.id(pck_name+"text5"));
		 String text3 = btn_output3.getText();
		 System.out.println( "My Total Gain: " + text3.toString());
		 
        try {
   		Thread.sleep(5000);
   	} catch (InterruptedException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
        System.out.println("*******outside test******** ");
    }
}