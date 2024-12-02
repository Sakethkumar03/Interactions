package com.testing.Project1;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Interactions extends Base {
	

//1-Input Types
	@Test
		  public void SendKeys() throws InterruptedException {
				
		driver.findElement(By.xpath("//a[text()='Edit']")).click();
		System.out.println("	Title:- "+driver.getTitle());
		
		driver.findElement(By.id("fullName")).sendKeys("SAKETH");
		driver.findElement(By.id("join")).sendKeys("man" ,Keys.TAB);
		
		String attribute= 	driver.findElement(By.id("getMe")).getAttribute("value");
		System.out.println("getAttribute"+attribute);
		
		driver.findElement(By.id("clearMe")).clear();
		
		boolean  Enabled = driver.findElement(By.id("noEdit")).isEnabled();
		System.out.println("isEnabled:"+Enabled);
		
		String readonly =driver.findElement(By.id("dontwrite")).getAttribute("readonly");
		System.out.println("readonly:"+readonly);
		
		System.out.println(" 1-COMPLETED--Interact with Input fields");
		
		driver.navigate().back();
	
		Thread.sleep(2000);
		}	
		
//2-Type of clicks
		@Test
		  public void clicks() throws InterruptedException {
			
		driver.findElement(By.xpath("//a[text()='Click']")).click();
		System.out.println("	Title:- "+driver.getTitle());
		
		driver.findElement(By.id("home")).click();
		driver.navigate().back();
		
		Point location = driver.findElement(By.xpath("//*[@id=\"position\"]")).getLocation();
		System.out.println("location(x,y):"+location);
		
		WebElement colorWeb = driver.findElement(By.id("color"));
		String color= colorWeb.getCssValue("background-color");
		System.out.println("buttoncolor:"+color);
				
		Dimension size = driver.findElement(By.id("property")).getSize();
		System.out.println("size(H,W)"+size);
		
		
		boolean isDisabled= driver.findElement(By.id("isDisabled")).isEnabled();
		System.out.println("isDisabled:"+isDisabled);

		Actions action = new Actions(driver);
		WebElement hold = driver.findElement(By.xpath("//*[@id=\"isDisabled\"]"));
		action.clickAndHold(hold).perform();
		System.out.println("ClickAndHold-COMPLETED");
		
		System.out.println("2-COMPLETED--Interact with Button fields");
		driver.navigate().back();
		Thread.sleep(2000);
		}	
//3-Drop-Down	
		@Test
		  public void DropDown() throws InterruptedException {
	driver.findElement(By.xpath("//a[text()='Drop-Down']")).click();
	Thread.sleep(3000);
	System.out.println("	Title:- " +driver.getTitle());
	
	Select dd = new Select(driver.findElement(By.id("fruits")));
	dd.selectByVisibleText("Apple");
	
	Select sh = new Select(driver.findElement(By.id("superheros")));
	sh.selectByIndex(0);
	sh.selectByIndex(3);
	sh.selectByIndex(4);
	System.out.println(sh.isMultiple());
	
	WebElement ele= driver.findElement(By.id("lang"));
	Select lang = new Select(ele);
	 lang.selectByIndex(3);
	
	List <WebElement> options = lang.getOptions() ;
	 for (WebElement option : options) {
         System.out.println("ALL OPTIONS :"+option.getText());
     }

	Select country = new Select(driver.findElement(By.id("country")));
	 country.selectByValue("India");
	 
	 WebElement mycountry=  country.getFirstSelectedOption();
	 System.out.println(mycountry.getText());
	 
	System.out.println("3-Interact with Drop-Down fields --COMPLETED");
	driver.navigate().back();
	Thread.sleep(2000);
		}
		
//4-ALERTS 
	@Test
	  public void ALERTS() throws InterruptedException {
	driver.findElement(By.xpath("/html/body/app-root/app-test-site/section[2]/div/div/div/div[4]/app-menu/div/footer/a")).click();
	Thread.sleep(3000);
	  System.out.println("	Title:- "+driver.getTitle());
	
	driver.findElement(By.id("accept")).click();
	Alert alert = driver.switchTo().alert();
	driver.switchTo().alert().accept();
	
	driver.findElement(By.id("confirm")).click();
	String text= alert.getText();
	System.out.println("Alert text: "+text);
	driver.switchTo().alert().dismiss();

	driver.findElement(By.id("prompt")).click();
	driver.switchTo().alert();
	alert.sendKeys("DONE");
	System.out.println("alertTest:" +alert.getText());
	alert.accept();
		
	driver.findElement(By.id("modern")).click();
	driver.findElement(By.xpath("/html/body/app-root/app-alert/section[1]/div/div/div[1]/div/div/div[5]/button")).click();

	//driver.switchTo().alert();

	System.out.println("4-Interact with ALERT fields --COMPLETED");
	
	
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
//5-Frames 
	@Test
	  public void Frames() throws InterruptedException {
		
//	driver.findElement(By.xpath("//a[text()='Inner HTML']")).click();
	driver.get("https://letcode.in/frame");
	driver.switchTo().frame("firstFr");
	driver.findElement(By.xpath("//input[@name='fname']")).sendKeys("BSK");
	driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("the greatest in world");
	
	driver.switchTo().frame(0);
	driver.findElement(By.xpath("//input[@name='email']")).sendKeys("BSK@gmail.com");

	driver.switchTo().parentFrame();
	driver.findElement(By.xpath("//input[@name='lname']")).sendKeys("-god");
	
	Thread.sleep(3000);
	driver.switchTo().defaultContent();
	WebElement ele = driver.findElement(By.xpath("//h1[text()=' Frame']"));
	 String act= ele.getText();
	 String ex= ele.getText();
	 System.out.println(act);
	Assert.assertEquals(act,ex);
	
	System.out.println("5 -Interact with Frames fields --COMPLETED");
	driver.navigate().back();
	Thread.sleep(2000);
	}
	
//6-Drag 
		@Test
		  public void Drag() throws InterruptedException {
			
		driver.get("https://letcode.in/draggable");
		
		System.out.println("  Title:- " +driver.getTitle());
		
		WebElement ele = driver.findElement(By.id("sample-box"));
		Actions ac =new Actions(driver);
		
//		int x = ele.getLocation().getX();
//		int y = ele.getLocation().getY();
//		System.out.println("x: " +x+ "y:"+y);
//		ac.dragAndDropBy(ele, x+24, y+38).perform();
//	
//		int X = ele.getLocation().getX();
//		int Y = ele.getLocation().getY();
//		System.out.println("x: " +X+ "Y:"+Y);
		
		ac.dragAndDropBy(ele, 24, 38).perform();
		System.out.println("6-Interact with Drag  fields --COMPLETED");
		driver.navigate().back();
		Thread.sleep(2000);
		}
		
//7-Drop
		@Test
		  public void Drop() throws InterruptedException {
		driver.get("https://letcode.in/dropable");
		System.out.println("  Title:- " +driver.getTitle());
		
		WebElement Sele = driver.findElement(By.id("draggable"));
		WebElement Tele = driver.findElement(By.id("droppable"));
		Actions ac =new Actions(driver);
		
		ac.dragAndDrop(Sele, Tele).perform();
		System.out.println("7 -Interact with Drop fields --COMPLETED");
		driver.navigate().back();
		Thread.sleep(2000);
		}

//8-windows
		@Test
		  public void windows () {
			driver.get("https://letcode.in/windows");
		System.out.println("  Title:- " +driver.getTitle());
		
		String pw = driver.getWindowHandle();
		driver.findElement(By.xpath("//button[@id='home']")).click();
		 
		 String cw = driver.getWindowHandle();	
		 driver.switchTo().window(cw);
		 System.out.println(cw);
		 driver.switchTo().window(pw);
		 
		 driver.findElement(By.xpath("//button[@id='multi']")).click();
		 Set<String> Mw = driver.getWindowHandles();
		 List<String> list = new ArrayList<String>(Mw);
		 int  wsize =list.size();
		 System.out.println("multi-wsize: "+wsize);
		 
		 for(int i=0; i<wsize;i++) {
			 driver.switchTo().window(list.get(i));
			 System.out.println(driver.getCurrentUrl());
		 }
		 
		System.out.println("8 -Interact with Window handling fields --COMPLETED");

		}
		
//slider
		@Test
		  public void slider () {
			driver.get("https://letcode.in/slider");
		System.out.println("  Title:- " +driver.getTitle());
		
		WebElement ele = driver.findElement(By.id("generate"));
		Actions ac =new Actions(driver);
		ac.clickAndHold(ele)
		.moveByOffset(0, 0)
		.release().perform();
		
		WebElement slidetvalue =driver.findElement(By.cssSelector("h1[class='subtitle has-text-info']"));
		System.out.println(slidetvalue.getText());
		
		driver.findElement(By.xpath("//button[text()='Get Countries']")).click();
		
		WebElement contentEle = driver.findElement(By.xpath("(//div[@class='card-content'])[2]"));
		System.out.println(contentEle.getText());
		
		System.out.println("10 -Interact with slider fields --COMPLETED");

		}
		
		
		
		
}

//	driver.findElement(By.xpath("//button[text()='Get Countries']")).sendKeys("");		
