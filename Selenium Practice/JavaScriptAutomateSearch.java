package mypackage;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver; 

public class JavaScriptAutomateSearch {

	public static void main(String[] args) {
		WebDriver driver = new SafariDriver();
		
		driver.get("http://www.bestbuy.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("gh-search-input")).sendKeys("samsung");
		driver.findElement(By.className("hf-icon-search")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("The words in this input box say: " +driver.findElement(By.id("menu0")).getText());
		
		driver.quit();
		
		//for getting element coordinate location:
		//Point p = driver.findElement(By.id("...")).getLocation();
		//System.out.println(p.x);
		//System.out.println(p.y);
		
		//for navigating pop up alerts, use the following:
		//Alert a = driver.switchTo().alert();
		//Thread.sleep(3000);
		//a.accept(); or
		//a.dismiss();
		
		//for key stroke commands, use the following:
		//driver.findElement(By.id("....")).sendKeys("....");
		//driver.findElement(By.id("....")).sendKeys(Keys.TAB);
		//driver.findElement(By.id("....")).sendKeys(Keys.RETURN);
	}

}
