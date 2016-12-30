package RocketChatTestPackage;

import static org.junit.Assert.*;

import java.util.List;

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
import org.openqa.selenium.support.ui.Select;

public class ChannelsTest {
	
	public	static WebDriver wd = RocketChatTestPackage.ForgotPassTest.wd; 
	
	//Channels Section Elements
	private static By buttonCreate = By.className("button primary save-channel");
	private static By buttonCancel = By.className("button cancel-channel");
	private static By buttonLogout = By.className("icon-logout");
	private static By autoCompleteOption = By.cssSelector("div.-autocomplete-container");
	private static By buttonPrivate = By.id("channel-type");
	private static By buttonReadOnly = By.id("channel-ro");
	private static By AddChannel = By.className("icon-plus");
	private static By ChannelName = By.id("channel-name");
	//private static By buttonCloseChnnl = By.className("arrow close");
	//private static By errorMessages = By.cssSelector("div.input-error");
	
	
	//User Status Bar Elements
	private static By statusBar = By.cssSelector("div.data");

	
	//Right Panel Elements
	private static By rightPanelOptions = By.cssSelector("div.tab-button");
	private static By trashButt = By.cssSelector("button.button.danger.delete");
	private static By rightPanelClose = By.cssSelector("div.tab-button.active");
	private static By PopUpYes = By.className("confirm");
	
	
	//Login Elements
	private static By Email = By.id("emailOrUsername");
	private static By Pass = By.id("pass");
	private static By CurrUsers = By.id("channel-members");
	private static By LoginButton = By.className("button primary login");
	
	
	//Pause
	public static void sleep() throws Exception{
		Thread.sleep(3000);
	}
	
	//Click user status bar and logout
	public static void close(){
		wd.findElement(statusBar).click();
		System.out.println("Clicked on user status bar");
		wd.findElement(buttonLogout).click();
		System.out.println("Logout successful");
		
	//Close left panel if it is open
//		if(detectElement(buttonCancel) == true){
//		wd.findElement(buttonCancel).click();
//		System.out.println("Cancel Pressed");
//		wd.findElement(statusBar).click();
//		System.out.println("Clicked on user status bar");
//		wd.findElement(buttonLogout).click();
//		System.out.println("Logout successful");
//		}
//		else{
//		wd.findElement(statusBar).click();
//		System.out.println("Clicked status bar");
//		wd.findElement(buttonLogout).click();
//		System.out.println("Logout successful");
//		}
	}
	

	//Detect if left channels panel is open
//	private static boolean detectElement(By element) {
//		
//		boolean ElementDetected = wd.findElements(element).size() > 0;
//		//int ElementDetected = wd.findElements(element).size();
//		System.out.println(ElementDetected);
//		if (ElementDetected) {
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
	
	//Delete New Created User
	public void DeleteChannel() throws Exception {
	WebElement infoIconButt = wd.findElements(rightPanelOptions).get(1);
	infoIconButt.click();
	sleep();
	wd.findElement(trashButt).click();
	sleep();
	wd.findElement(PopUpYes).click();
	sleep();
	wd.findElement(rightPanelClose).click();
	System.out.print("Channel has been deleted.");
}	
	
	//Search and Add Users
	private static void searchAddUsers() throws Exception{
		WebElement curUsers = wd.findElement(CurrUsers);
		curUsers.sendKeys("test");
		sleep();
		//System.out.println("Typed in test");	
		wd.findElement(autoCompleteOption).click();
		curUsers.clear();
		curUsers.sendKeys("test");
		sleep();
		wd.findElement(autoCompleteOption).click();
		curUsers.clear();
		System.out.println("Added selected users");
	}

	@BeforeClass
	//Open Driver
	public static void open() throws Exception{
		wd = new SafariDriver();
		System.out.println("Setup info: " + wd);
		System.out.println("Getting address");
		wd.get("http://localhost:3000");
		System.out.println("Find login and pass boxes and enter strings");
		WebElement loginEmail = wd.findElement(Email);
		loginEmail.sendKeys("test@gmail.com");
		WebElement loginPass = wd.findElement(Pass);
		loginPass.sendKeys("test");
		wd.findElement(LoginButton).click();
	}
	
	@Before
	//Go to Channels Panel
	public void clickOnChannels() throws Exception{
		sleep();
		System.out.println("Now clicking on Channels button");
		wd.findElement(AddChannel).click();
		sleep();
	}
	
	@Test
	//Find users and create channel
	public void createWithAddedUsrs() throws Exception {		
		WebElement Name = wd.findElement(ChannelName);
		Name.sendKeys("TestName1");
		searchAddUsers();
		wd.findElement(buttonCreate).click();
		Name.clear();
		sleep();
		DeleteChannel();
	}
	
	@Test
		//Test Private Group Entry
	public void privateGroup() throws Exception{
		
		
		WebElement Name = wd.findElement(ChannelName);
		Name.sendKeys("TestName2");
		searchAddUsers();
		sleep();
		wd.findElement(buttonPrivate).click();
		sleep();
		wd.findElement(buttonCreate).click();
		wd.findElement(buttonPrivate).clear();
		wd.findElement(buttonReadOnly).clear();
		Name.clear();
		sleep();
		DeleteChannel();
	}
	
	//Test Read Only Channel
	@Test
		public void readOnly() throws Exception{
		
		WebElement Name = wd.findElement(ChannelName);
		Name.sendKeys("TestName3");
		searchAddUsers();
		wd.findElement(buttonReadOnly).click();
		sleep();
		wd.findElement(buttonCreate).click();
		wd.findElement(buttonPrivate).clear();
		wd.findElement(buttonReadOnly).clear();
		Name.clear();
		sleep();
		DeleteChannel();
	}
	
	//Test Read Only Channel and Private Group Entry
	@Test
		public void readOnlyAndPrivateGroup() throws Exception{
		
		WebElement Name = wd.findElement(ChannelName);
		Name.sendKeys("TestName4");
		searchAddUsers();
		sleep();
		wd.findElement(buttonPrivate).click();
		sleep();
		wd.findElement(buttonReadOnly).click();
		sleep();
		wd.findElement(buttonCreate).click();
		wd.findElement(buttonPrivate).clear();
		wd.findElement(buttonReadOnly).clear();
		Name.clear();
		sleep();
		DeleteChannel();
	}
	
	//Test void entry
	@Test
		public void voidEntry() throws Exception{
		
		System.out.println("Clicking on Create\n");
		//check if error message appears
		wd.findElement(buttonCreate).click();
		sleep();
		wd.findElement(buttonCancel).click();
	}
		
	//Wait before next test
	@After
		public void pauseBeforeNextTest() throws Exception{
		sleep();
	}
	
	@AfterClass
	//Close Channels box and close server
	public static void end(){
		close();
//		wd.findElement(statusBar).click();
//		System.out.println("Status Bar Clicked");
//		wd.findElement(buttonLogout).click();
//		System.out.println("Logged Out");
		
		System.out.println("All tests finished and logged out\n");
		wd.quit();
	}
}