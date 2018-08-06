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

public class PaleGirlsNakedDownloader {

	public static void downloader(WebDriver driver, boolean firstRun ) throws AWTException, InterruptedException{
		Boolean newPage = true;
		int pageTracker = 33;
		while(newPage){
			driver.get("http://palegirlsnaked.com/page/" + pageTracker);
			Thread.sleep(5000);
			List<WebElement> imgs = driver.findElements(By.className("entry-content"));
			Actions act = new Actions(driver);
			Robot robot = new Robot();
			
			try{
				for(int i=0; i<imgs.size(); i++){
					if(!firstRun){
						WebElement dateElement = imgs.get(i).findElement(By.tagName("date"));
						Calendar cal = Calendar.getInstance();
						cal.setTime(new Date());
						cal.set(Calendar.HOUR_OF_DAY, cal.getMinimum(Calendar.HOUR_OF_DAY));
						cal.set(Calendar.MINUTE, cal.getMinimum(Calendar.MINUTE));
						Date date = new Date(dateElement.getText());
						//if the date of the post is after the start of today, we stop this (already downloaded)
						if(cal.before(date)){
							return;
						}
					}
					
					WebElement img = imgs.get(i).findElement(By.tagName("img"));
					
					act.moveToElement(img).contextClick().sendKeys("W").perform();
					Iterator<String> windowsAdd = driver.getWindowHandles().iterator();
					String parent = windowsAdd.next();
					String child = windowsAdd.next();
					driver.switchTo().window(child);
					act.moveToElement(driver.findElement(By.tagName("img"))).contextClick().sendKeys("v").perform(); //this will by default save in default folder
		
					Thread.sleep(1500);
					robot.keyPress(KeyEvent.VK_ENTER);
					robot.keyRelease(KeyEvent.VK_ENTER);
					Thread.sleep(1500);
					driver.close();
					driver.switchTo().window(parent);
				}
			} catch (Exception e){
				System.out.println("errorcillo, ni modo");
			}
			pageTracker++;
		}
	}
}
