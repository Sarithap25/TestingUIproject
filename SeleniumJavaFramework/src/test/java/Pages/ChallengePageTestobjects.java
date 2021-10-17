package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChallengePageTestobjects {
	
	WebDriver driver= null;
	
	By button_search = By.xpath("//*[@class='button']");
	
	By button_alert = By.xpath("//*[@class='button alert']");
	
	By button_success = By.xpath("//*[@class='button success']");
	
	By  columnvalues = By.xpath("//*[@class='large-10 columns']//tbody/tr/td[1]");
	
	//Here creating constructor
	public ChallengePageTestobjects(WebDriver driver) {
		
		this.driver=driver;
	}
	public void clickingbuttonsearch() {
		
		driver.findElement(button_search).click();
		
		
	}
	
       public void clickingbuttonalert() {
		
		driver.findElement(button_search).click();
		
		
	}
public void clickingbuttonsuccess() {
	
	driver.findElement(button_search).click();
	
	
}
public void columnvalues() {
	
	driver.findElements(columnvalues);
	
	
}
}
