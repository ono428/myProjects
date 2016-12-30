package mypackage;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class iflogin {
	public WebDriver wd = new SafariDriver();
	
	
	@Test
	public void test() {
		junittest test = new junittest();
		wd.get("http://www.bestbuy.com");
		String buttonName = wd.findElement(By.id("menu0")).getText();
		
		System.out.println("This BestBuy link text should say Products");	
		String output = test.ifLogin(buttonName);
			assertEquals("Products", output);
		
		wd.quit();
	}

}
