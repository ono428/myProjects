package mypackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class ExpertTest {

	public static void main(String[] args) {
		WebDriver wd = new SafariDriver();
		wd.get("http:akhilreddy.com");
		
		//Get Page Title
		String title = wd.getTitle();
		System.out.println(title);
		
		//Get Page Source Code
		//String ps = wd.getPageSource();
		//System.out.println(ps);
		
		//Get count of dropdown buttons
		//List <WebElement> dropdown_buttons = wd.findElements(By.tagName("...."));
		//System.out.println("total of dropdowns are: "+ dropdown_buttons.size());
		
		//Get count of radioboxes
		//List <WebElement> radioboxes = wd.findElements(By.id("...."));
		//System.out.println("radio boxes: "+ radioboxes.size());
		
		//Get count of buttons on page
		//List <WebElement> button = wd.findElement(By.id("...."));
		//System.out.println("buttons: "+ button.size());
		
		//Get count of textboxes on page
		//List <WebElement> textboxes = wd.findElement(By.id("...."));
		//System.out.println("Number of Textboxes: "+ textboxes.size());
		
		//Get count of checkboxes on page
		//List <WebElement> checkboxes = wd.findElement(By.id("...."));
		//System.out.println("checkboxes: "+ checkboxes.size());
		
		//Get time for loading page
		//long start = System.currentTimeMillis();
		//wd.get("https:google.com");
		//long finish = System.currentTimeMillis();
		//long totaltime = finish - start;
		//System.out.println("Page load time: "+ totaltime);
		
		//Open new window
		//wd.get("http://google.com");
		//wd.findElement(By.cssSelector("body")).sendKeys.CONTROL+"n");
		//wd.get("http://facebook.com");
		//try{
		//Thread.sleep(30001);
		//wd.findElement(B.cssSelector("body")).sendKeys(Keys.CONTROL+"w");
		//}
				
		wd.quit();
	}

}
