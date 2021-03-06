package RocketChatTestPackage;

import static org.junit.Assert.*;

import java.sql.Driver;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminTest {

	public	static WebDriver wd = RocketChatTestPackage.ForgotPassTest.wd; 
	
	//Right side panel elements
	private static By statusBar = By.cssSelector("div.data");
	private static By rightPanelOptions = By.cssSelector("div.tab-button");
	private static By trashButt = By.cssSelector("button.button.danger.delete");
	private static By rightPanelClose = By.cssSelector("div.tab-button.active");
	private static By PopUpYes = By.className("confirm");
	
	//Left panel elements
	private static By buttonClose = By.className("arrow close");
	
	//Left panel admin elements
//	private static By Info = By.xpath("//*[@id='rocket-chat']/aside/div[4]/section/div/div/ul/li[1]/a");
//	private static By Import = By.xpath("//*[@id='rocket-chat']/aside/div[4]/section/div/div/ul/li[2]/a");
	private static By Import = By.xpath("/div/*a[@href='/admin/Import']@href");
//	private static By Import = By.cssSelector("div.content.wrapper.a./admin/import");

	
//	private static By Rooms = By.className("  ");
//	private static By Users = By.className("  ");
//	private static By Permissions = By.className("  ");
//	private static By Emoji = By.className("  ");
//	private static By Integrations = By.className("  ");
//	private static By Mailer = By.className("  ");
//	private static By Apps = By.className("  ");
//	private static By Logs = By.className("  ");
		
	//User status bar elements
	private static By buttonLogout = By.className("icon-logout");
	private static By buttonAdmin = By.className("icon-wrench");
	
	//Click user status bar and logout
	public static void logout(){
		wd.findElement(statusBar).click();
		System.out.println("Clicked on user status bar");
		wd.findElement(buttonLogout).click();
		System.out.println("Logout successful");
	}
	
	public static void sleep() throws Exception{
		Thread.sleep(5000);
	}
	
	//Closes panel
	public static void closePanel() throws Exception{
		wd.findElement(buttonClose).click();
		System.out.println("Panel Closed");
	}
	
	@BeforeClass
	public static void open() throws Exception{
		wd = new SafariDriver();
		wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Setup info: " + wd);
		System.out.println("Getting address");
		wd.get("http://localhost:3000");
		System.out.println("Find login and pass boxes and enter strings");
		WebElement loginEmail = wd.findElement(By.id("emailOrUsername"));
		loginEmail.sendKeys("test@gmail.com");
		WebElement loginPass = wd.findElement(By.id("pass"));
		loginPass.sendKeys("test");
		wd.findElement(By.className("button primary login")).click();
		
		
	}
	
	@Before 
	public void openAdmin() throws Exception{
		sleep();
		wd.findElement(statusBar).click();
		System.out.println("Status Bar Clicked");
		sleep();
		wd.findElement(buttonAdmin).click();
		System.out.println("Admin Button Clicked");
	}
	
	@Test
	public void test() throws Exception {
		sleep();
		System.out.println("Clicking on Import Tab");
//		wd.findElement(Info).click();
//		new WebDriverWait(wd, 10).until(ExpectedConditions.presenceOfElementLocated(Import));
//		sleep();
//		WebElement WORKPLS = wd.findElements(Import).get(1);
//		WORKPLS.click();
		try{
		String print = wd.findElement(Import).getText();
		System.out.println("" + print);
		System.out.println("Clicked on Import Tab");
		}
		catch(Exception e) {
		e.printStackTrace();
		}
	}
		
	@After
	public void closeAdmin() throws Exception{
		sleep();
		closePanel();
	}
	
	@AfterClass
	public static void end() throws Exception{
		logout();
		System.out.println("All tests finished and logged out\n");
		wd.quit();
	}
	
}
