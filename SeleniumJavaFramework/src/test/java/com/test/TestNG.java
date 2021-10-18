package com.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import com.pages.FirstPageImpl;

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
	
	//ChallengePageTestobjects button=new ChallengePageTestobjects(driver);
		FirstPageImpl pageobject= new FirstPageImpl();
	
	driver.get("https://the-internet.herokuapp.com/challenging_dom");
	pageobject.launchapplication();
	pageobject.validatePageHeader();
	pageobject.clickingbuttonsearch();
	pageobject.clickingbuttonalert();
	pageobject.clickingbuttonsuccess();
	try {
		pageobject.Firstcolumnvalues();
		pageobject.Secondcolumnvalues();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}


