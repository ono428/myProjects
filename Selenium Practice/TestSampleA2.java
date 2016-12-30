package mypackage;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSampleA2 {
	
	private WebDriver driver;

	@Before
	public void doSetup() {
		System.out.println("Setting up test");
        //creates a new driver object for safari (only for safariv10.x)
        driver = new SafariDriver();     
        //navigate to url
        driver.get("http://www.javascriptkit.com/javatutors/event2.shtml");
        
        //main test to call each unit tests here
        testThread();
        
        driver.quit();
        System.out.println("Quitting test");

	}
	
	@Test
	public void testThread(){
		//maximize browser window
        driver.manage().window().maximize();
        //wait 5 seconds
        //driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        timeoutMs(5000);
        //find element via xPath and simulate a button click
        driver.findElement(By.xpath("//*[@id='contentcolumn']/div[1]/table/tbody/tr/td[2]/form/input")).click();
        //driver.manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);
        timeoutMs(5000);
	}
	
	private void findElementByXpath(){
		
	}
	
	private void timeoutMs(int second){
		driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
	}
	
	
	
	

}
