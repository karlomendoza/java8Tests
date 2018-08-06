package java8Test;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;

public class ImgDownloader {
	
	public static void main(String[] args) throws AWTException, IOException, InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			 File adblock = new File("C:\\work\\extensions\\firefox\\adblock_plus-2.7.3-sm+tb+fx+an.xpi");
			 profile.addExtension(adblock);
			} catch(IOException e) {
				e.printStackTrace();
			}
		profile.setPreference("browser.download.folderList", 2);
		profile.setPreference( "browser.download.dir", "C:\\images2");
		WebDriver driver = new FirefoxDriver(profile);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		PaleGirlsNakedDownloader.downloader(driver, true);
		//download from every site:
		
		
		
	}
}
