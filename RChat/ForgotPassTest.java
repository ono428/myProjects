package RocketChatTestPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.safari.SafariDriver;

public class ForgotPassTest {
	public static WebDriver wd; 
	
	public static void main(String[] args) throws Exception {
		org.junit.runner.JUnitCore.main("RocketChatTestPackage.UnitTest");
		org.junit.runner.JUnitCore.main("RocketChatTestPackage.ChannelsTest");
		Thread.sleep(3000);
		end();
		}
		
	private static void end(){
		wd.quit();
		System.out.println("Reached end of test, quitting.");
		}
}
