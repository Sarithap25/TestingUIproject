package Test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Challenge {

	public static void main(String[] args) {
			String Projectpath = System.getProperty("user.dir");
			System.out.println("Projectpath:"+Projectpath);
		//we can set it this path in environment varibles also.Here we are setting up the chrome driver path.
		System.setProperty("webdriver.chrome.driver", Projectpath+"/driver/chrome/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		//Navigate to url
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		//finding the all the buttons
		
		//1.Verifying the First Buttons.
		driver.findElement(By.xpath("//*[@class='button']")).click();
		//2.Verifying the Second Buttons.
		driver.findElement(By.xpath("//*[@class='button alert']")).click();
		//3.Verifying the Second Buttons.
		driver.findElement(By.xpath("//*[@class='button success']")).click();
		System.out.println("finding the all the buttons");
		//4.Verifying the First Column values
		List<WebElement> Firstcolumnvalues=driver.findElements(By.xpath("//*[@class='large-10 columns']//tbody/tr/td[1]"));
		List<String> columnvalues = new ArrayList<>();		
		List<String> UIcolumnvalues = new ArrayList<>();		
		for(int i=0;i<Firstcolumnvalues.size();i++) {
			WebElement we = (WebElement) Firstcolumnvalues.get(i);
			String text = we.getAttribute("innerText").trim();
			UIcolumnvalues.add(text);
		}			
		for (int i=0;i<10;i++) {
			columnvalues.add("Iuvaret"+ i);			
		}
		//5.Verifying the Second Column values
		List<WebElement> Secondcolumnvalues=driver.findElements(By.xpath("//*[@class='large-10 columns']//tbody/tr/td[2]"));
		for(int i=0;i<Secondcolumnvalues.size();i++) {
			WebElement we = (WebElement) Secondcolumnvalues.get(i);
			String text = we.getAttribute("innerText").trim();
			UIcolumnvalues.add(text);
		}			
		for (int i=0;i<10;i++) {
			columnvalues.add("Apeirian"+ i);			
		}
		//6.Verifying the Fifth Column values
		List<WebElement> Thirdcolumnvalues=driver.findElements(By.xpath("//*[@class='large-10 columns']//tbody/tr/td[5]"));
		for(int i=0;i<Thirdcolumnvalues.size();i++) {
			WebElement we = (WebElement) Thirdcolumnvalues.get(i);
			String text = we.getAttribute("innerText").trim();
			UIcolumnvalues.add(text);
		}			
		for (int i=0;i<10;i++) {
			columnvalues.add("Consequuntur"+ i);			
		}
		
		//7.Verifying the sixth Column values
				List<WebElement> sixthcolumnvalues=driver.findElements(By.xpath("//*[@class='large-10 columns']//tbody/tr/td[6]"));
				for(int i=0;i<sixthcolumnvalues.size();i++) {
					WebElement we = (WebElement) sixthcolumnvalues.get(i);
					String text = we.getAttribute("innerText").trim();
					UIcolumnvalues.add(text);
				}			
				for (int i=0;i<10;i++) {
					columnvalues.add("Phaedrum"+ i);			
				}
		boolean iscolumnvalues=mycompareLists(UIcolumnvalues,columnvalues);	
		// 8.Verifying the Edit or Delete Buttons
		try {
			clickteditbasedoncolumnandvalue("Diceret","Phaedrum6",driver,"delete");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
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
		 Thread.sleep(8000);		  
		driver.close();
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


