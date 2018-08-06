package java8Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class amazon2 {
	
	static String asin;
	static String img_name;
	static String description;
	static String title;

	public static void downloader(WebDriver driver, boolean firstRun ) throws AWTException, InterruptedException{
		Boolean newPage = true;
		int pageTracker = 33;
//		while(newPage){
			driver.get("https://www.amazon.com/s?marketplaceID=ATVPDKIKX0DER&me=A309JWQ1Q79FDW&merchant=A309JWQ1Q79FDW&redirect=true");
			Thread.sleep(5000);
			
			
			Actions act = new Actions(driver);
			Robot robot = new Robot();
			
			WebElement ul = driver.findElement(By.id("s-results-list-atf"));
			List<WebElement> li = ul.findElements(By.tagName("li"));
			for (WebElement webElement : li) {
				asin = webElement.getAttribute("data-asin");
				
				title = webElement.findElement(By.tagName("H2")).getText();
				
				WebElement img = webElement.findElement(By.tagName("img"));
				
				img_name = img.getAttribute("currentSrc");
				
				act.moveToElement(img).contextClick().sendKeys("v").perform();
				
				Thread.sleep(1500);
				robot.keyPress(KeyEvent.VK_ENTER);
				robot.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(1500);
				System.out.println(asin + "," + img_name + "," + title);
			}
			
//		}
	}
}
