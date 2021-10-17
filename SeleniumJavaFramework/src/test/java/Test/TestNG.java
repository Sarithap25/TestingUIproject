package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Pages.ChallengePageTestobjects;

public class TestNG {

private static WebDriver driver=null;
	@BeforeTest
	public  void setUpTest() {
		
		String Projectpath = System.getProperty("user.dir");
		System.out.println("Projectpath:"+Projectpath);
	//we can set it this path in environment varibles also.Here we are setting up the chrome driver path.
	System.setProperty("webdriver.chrome.driver", Projectpath+"/driver/chrome/chromedriver.exe");
	driver=new ChromeDriver();
		
	}
	@Test
	public static void challengeTest() {		
	
	ChallengePageTestobjects button=new ChallengePageTestobjects(driver);
	
	driver.get("https://the-internet.herokuapp.com/challenging_dom");
	button.clickingbuttonsearch();
	
	button.clickingbuttonalert();

	button.clickingbuttonsuccess();

	driver.close();	
	}

}
