package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Marta\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx ");
		
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.xpath("//a[@href=\"Process.aspx\"]")).click();
		Random rd = new Random(); 
		int n = rd.nextInt(100);
		String s=n+"";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(s);
		
		
		Random rd1 = new Random(); 
		int letter = rd1.nextInt(((90-65)+1)+65);
		char c=(char) letter;
		String str=c+"";
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys( "John "+str+ " Smith");
		
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Jones Branch Dr.");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("McLean");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("VA");
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys("22102");
        
        
        Random rd2 = new Random();
        int card = 1 + (int)(Math.random() * ((3 - 1) + 1));
        
        int n3;
        String s3="";
        for(int i=0; i<14; i++) {
        	Random rd3 = new Random();
        	n3 = rd3.nextInt(10);
        	s3+=n3;
        }
        
        
		switch(card) {
		case 1: driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("42"+s3);break;
		case 2:driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("51"+s3);break;
		case 3:driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("3"+s3);break;
		}
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("12/20");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		

				
				if(driver.getPageSource().contains("New order has been successfully added.")) {
					System.out.println("pass");
				}else {
					System.out.println("fail");
				
				}
	
		
	}
}