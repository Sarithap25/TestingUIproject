package com.test;

import com.pages.FirstPageImpl;


public class Test {

	public static void main(String[] args) throws InterruptedException {
		

		
	
	FirstPageImpl pageobject= new FirstPageImpl();
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
