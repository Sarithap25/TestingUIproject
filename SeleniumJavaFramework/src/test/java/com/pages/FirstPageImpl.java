package com.pages;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FirstPageImpl implements FirstPage {
	
	WebDriver driver;
	public void launchapplication() {
		// TODO Auto-generated method stub
		/*
		 * System.setProperty("webdriver.chrome.driver", ""); driver= new
		 * ChromeDriver();
		 */
		 String Projectpath = System.getProperty("user.dir");
		 System.out.println("Projectpath:"+Projectpath);
		//we can set it this path in environment varibles also.Here we are setting up the chrome driver path.
		System.setProperty("webdriver.chrome.driver", Projectpath+"/driver/chrome/chromedriver.exe");
		 driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
		driver.manage().window().maximize();
	try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	
	//Validating Header of the page
	public void validatePageHeader() {
		// TODO Auto-generated method stub
		String Header=driver.findElement(By.xpath(Text_PageHeader)).getText();		
		System.out.println("Header");
		if(Header.equals(Constants.Const_Header)){
			
			System.out.println("Matching the values");
		}
		else {
		
			System.out.println("If values are not matching");
			
		}
	}	

	public void clickingbuttonsearch() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(button_search)).click();
		System.out.println("successfully clicked button search");
	}

	public void clickingbuttonalert() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(button_alert)).click();
		System.out.println("successfully clickingbuttonalert");
	}
		
//Here using explict wait Validating Button success
	
	public void clickingbuttonsuccess() {
		// TODO Auto-generated method stub
		driver.findElement(By.xpath(button_success)).click();
		System.out.println("successfully clickingbuttonsuccess");
	}
	List<String> expectedcolumnvalues = new ArrayList<>();		
	List<String> UIcolumnvalues = new ArrayList<>();
	//Validating Second column Values
	public void Secondcolumnvalues() throws Exception {
		// TODO Auto-generated method stub
		List<WebElement> Secondcolumnvaluess=driver.findElements(By.xpath("//*[@class='large-10 columns']//tbody/tr/td[2]"));
		for(int i=0;i<Secondcolumnvaluess.size();i++) {
			WebElement we = (WebElement) Secondcolumnvaluess.get(i);
			String text = we.getAttribute("innerText").trim();
			UIcolumnvalues.add(text);
		}			
		for (int i=0;i<10;i++) {
			expectedcolumnvalues.add("Apeirian"+ i);			
		}
		boolean iscolumnvalues=mycompareLists(UIcolumnvalues,expectedcolumnvalues);
		driver.close();
	}
	@Override
	public void Firstcolumnvalues() throws Exception {
		// TODO Auto-generated method stub
		//This is sample we can validate column values(Below is written First column value)
		List<WebElement> Firstcolumnvaluess=driver.findElements(By.xpath("//*[@class='large-10 columns']//tbody/tr/td[1]"));
		for(int i=0;i<Firstcolumnvaluess.size();i++) {
			WebElement we = (WebElement) Firstcolumnvaluess.get(i);
			String text = we.getAttribute("innerText").trim();
			UIcolumnvalues.add(text);
		}			
		for (int i=0;i<10;i++) {
			expectedcolumnvalues.add("Iuvaret"+ i);			
		}
		//Comparing the Values of UI first coulmns vaules against expected.
		boolean iscolumnvalues=mycompareLists(UIcolumnvalues,expectedcolumnvalues);
		
		UIcolumnvalues.clear();
		expectedcolumnvalues.clear();
		//Below function is to navigate perticular column example Phaedrum6 and then click on edit or delete
		clickteditbasedoncolumnandvalue("Diceret","Phaedrum6",driver,"delete");
		System.out.println("Program successfully comleted");
	}
	
public static void clickteditbasedoncolumnandvalue(String column,String val,WebDriver driver,String action) throws Exception
	{
		//9.Checking the all the table header values
		List<WebElement> tableheader=driver.findElements(By.xpath("//*[@class='large-10 columns']//tr/th"));
		
		for(int i=0;i<tableheader.size();i++)
		{
			if(tableheader.get(i).getText().equalsIgnoreCase(column))
			{				
				System.out.println("index is : "+i);
				List<WebElement> value=	driver.findElements(By.xpath("//*[@class='large-10 columns']//tr/td["+(i+1)+"][text()='"+val+"']/../td[7]"));
							
				if(value.size()==0)
				{
				System.out.println("Invalid input data combination");
				}				
				else
				{
				if(action.equalsIgnoreCase("edit"))
				{
					driver.findElement(By.xpath("//*[@class='large-10 columns']//tr/td["+(i+1)+"][text()='"+val+"']/../td[7]/a[1]")).click();				}
					else if(action.equalsIgnoreCase("delete"))
					{
						driver.findElement(By.xpath("//*[@class='large-10 columns']//tr/td["+(i+1)+"][text()='"+val+"']/../td[7]/a[2]")).click();
						
					}
				}
				}
			}
		
		}
	
public static boolean mycompareLists(List<String> List1,List<String> List2){
    	
    	boolean returntype = true;
    	
    	if((List1.size()) == (List2.size())){
    		for(int j=0;j<List1.size();j++)
    		{
    			if((List1.get(j).trim()).equals(List2.get(j).trim()))
	    		{ 
    				System.out.println(+ j+1+ "-" +List1.get(j) + " (This is Web UI Value) || "+ List2.get(j) +" (This is Expected value)");  
	    		}
	    		else
	    		{   returntype=false;
	    			System.out.println("Mismatch!! -"+ j+1+ "-" +List1.get(j) + " (This is Web UI Value) || "+ List2.get(j) +" (This is Expected value)");
                   
	    		}
            }
       	}
    	else
		{   returntype=false;
			System.out.println("List1 and List2 size is not matching -List1=" + List1.size() + "List2=" +List2.size());
			
   			 
		}
    	
		return returntype;    	       	
	}


}



  


