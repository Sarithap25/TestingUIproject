package com.pages;

public interface FirstPage {
	
	String Text_PageHeader= "//h3[contains(text(),'Challenging DOM')]";
	String tableheader = "//*[@class='large-10 columns']//tr/th";
	String button_search = "//*[@class='button']";

	String button_alert = "//*[@class='button alert']";

	String button_success = "//*[@class='button success']";

	String Firstcolumnvalues ="//*[@class='large-10 columns']//tbody/tr/td[1]";
	
	String Secondcolumnvalues="//*[@class='large-10 columns']//tbody/tr/td[2]";

	public void launchapplication();
	public void clickingbuttonsearch();

	public void clickingbuttonalert() ;

	public void clickingbuttonsuccess() ;
	public void validatePageHeader();
	
	public void Firstcolumnvalues() throws Exception;
	
	public void Secondcolumnvalues() throws Exception;
	
}
