package org.stepdefinition;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;
import io.cucumber.java.en.*;
public class Ordersstepdefinition extends Baseclass{
	String Orderno;
	@When("click on the orders tab")
	public void click_on_the_orders_tab() throws Exception {
		idJavaScriptScrollIntoViewClick("orders");
	    TakeScreenShots("Orders screen");
	    Thread.sleep(3000);
	}
	@When("Navigate to pending order details")
	public void navigate_to_pending_order_details() throws Exception {
		IdClick("OpenModal");
	    IdClick("category");
	    XpathClick("//option[text()='Pending']");
	    IdClick("category");
	    XpathClick("//span[@class='btn btn-success font14 w-100 p-3']");
	    Thread.sleep(2000);
	    TakeScreenShots("Pending Orders screen");
	}
	@When("Navigate to first order")
	public void navigate_to_first_order() {
		XpathClick("//p[@class='font14 mb-2  title-case'][1]");
	    scrollToTop();
	    XpathClick("//input[@class='cursor-pointer'][1]");
	}
	@When("Accept the order")
	public void accept_the_order() throws Exception {
		TakeScreenShots("Accept Orders screen");
	    XpathClick("//button[@class='btn btn-success font14 w-100 p-3']"); //Accept
	    Thread.sleep(5000);
	}
	@When("Ready to pickup the order")
	public void ready_to_pickup_the_order() throws Exception {
		TakeScreenShots("Ready to pickup Orders screen");
	    XpathClick("//button[@class='btn btn-success font14 w-100 p-3']"); //Ready to pickup
	    Thread.sleep(5000);
	}
	@When("Confirm Delivery the order")
	public void confirm_delivery_the_order() throws Exception {
		 TakeScreenShots("Confirm Delivery Orders screen");
		    XpathClick("//button[@class='btn btn-success font14 w-100 p-3']"); //Confirm Delivery
		    Thread.sleep(5000);
	}
	@When("Back to orders screen")
	public void back_to_orders_screen() {
		scrollToTop();
	    XpathClick("//img[@class='modal-close']");
	  //Navigate to first order
	    XpathClick("//p[@class='font14 mb-2  title-case'][1]");
	    scrollToTop();
	}
	@When("Navigate to order screen to reject order")
	public void navigate_to_order_screen_to_reject_order() throws Exception {
		IdClick("Decline");
	    TakeScreenShots("Decline the Order");
	    Thread.sleep(5000);
	    //Enter the Decline reason
	    IdSendKeys("setText", "Automation Testing");
	    IdClick("setShowError");
	    Thread.sleep(5000);
	    
	    xpathJavaScriptScrollIntoViewClick("//img[@class='modal-close']");
	    Thread.sleep(5000);
	}
	@When("Searching the valid number\\(search functionality)")
	public void searching_the_valid_number_search_functionality() throws Exception {
		 Orderno = getText("(//h3[contains(text(), 'Order no')][1])[1]");
	     Pattern pattern = Pattern.compile("\\d+");
	     Matcher matcher = pattern.matcher(Orderno);
	     if (matcher.find()) {
	         String cleanNumber = matcher.group();
	         System.out.println(cleanNumber);
	     IdSendKeys("searchOrder", cleanNumber);}
	     TakeScreenShots("valid number search screen");
	     Thread.sleep(5000);
	     idClear("searchOrder");
	}
	@When("Searching the invalid number\\(search functionality)")
	public void searching_the_invalid_number_search_functionality() throws Exception {
		IdSendKeys("searchOrder", "8990");
	     TakeScreenShots("Invalid number search screen");
	     Thread.sleep(5000);
	     idClear("searchOrder");
	     refreshTab();
	}
	@When("Navigate to Bistro order")
	public void navigate_to_bistro_order() throws Exception {
		Thread.sleep(5000);
		IdClick("togleChange");
	     XpathClick("//option[text()='Bistro']");
	     TakeScreenShots("Bistro order search screen");
	}
	@Then("Lanuch the correct customer url for order lanching")
	public void lanuch_the_correct_customer_url_for_order_lanching() throws Exception {
		scrollDown(300);
		
	     String m=driver.getWindowHandle();
			//val1 = getText("(//h3[@class='font40 fw-bold'])[1]");
			//val2=Integer.parseInt(val1);
			
			openInNewTab("https://shop.proglint.com/", driver);
			
			Thread.sleep(3000);
			/*
			driver.findElement(By.xpath("//div[@class='modal-body p-50']/child::div[2]/div/div")).click();
			Thread.sleep(4000);
			Actions act=new Actions(driver);
			WebElement strselect=driver.findElement(By.id("react-select-2-input"));
			act.moveToElement(strselect).sendKeys("Comp").build().perform();
			strselect.sendKeys(Keys.ENTER);
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//div[@class='modal-body p-50']/child::div[3]/button")).click();
			
			Thread.sleep(4000);
			
			
			Thread.sleep(3000);	
			xpathJavaScriptScrollIntoViewClick("(//img[@src='/static/media/user.13be5495.svg'])[1]");
			WebElement no=elementCreateXpath("//select[@class='form-control custom-field']");
			Select s= new Select(no);
			s.selectByValue("+91");
			Thread.sleep(3000);
			XpathSendkey("//input[@name='mobileNumber']","9659203699");
			XpathSendkey("//input[@type='password']","Anitha@06");
			Thread.sleep(2000);
			xpathJavaScriptScrollIntoViewClick("(//button[@type='button'])[3]");
			Thread.sleep(2000);
			refreshTab();
			*/
			IdClick("category");
			xpathJavaScriptScrollIntoViewClick("(//img[@alt='1'])[3]");
			Thread.sleep(2000);
				scrollDown(550);
			//	val1=getText("(//button[@class='btn btn-outline-dark font15 fw-bold mt-2'])[1]");
				
				xpathJavaScriptScrollIntoViewClick("(//*[text()='+ Add to cart'])[1]");
				idJavaScriptScrollIntoViewClick("navCartScreen");
				Boolean check=elementIsDisplayedByXpath("//*[text()='Select Delivery Options']");
			     TakeScreenShots("Cart screen");
				int i=2;
				while (check==false)
				{
					
					Thread.sleep(2000);
					launchUrl("https://shop.proglint.com/products?categoryId=1", driver);
					Thread.sleep(2000);
					xpathJavaScriptScrollIntoViewClick("(//*[text()='+ Add to cart'])["+i+"]");
					
					idJavaScriptScrollIntoViewClick("navCartScreen");
					check=elementIsDisplayedByXpath("//*[text()='Select Delivery Options']");
					
					if (check==false)
					{
						Thread.sleep(2000);
						i++;
					}
					else 
						break;
				}
					Thread.sleep(2000);
					scrollToTop();
					
						
				xpathJavaScriptScrollIntoViewClick("(//img[@alt='cart'])[1]");
				Thread.sleep(2000);
				xpathJavaScriptScrollIntoViewClick("//*[text()='Select Delivery Options']");	
				Thread.sleep(2000);
				xpathJavaScriptScrollIntoViewClick("//*[text()='Proceed to pay ']");
				Thread.sleep(2000);
				
				xpathJavaScriptScrollIntoViewClick("//*[text()='Checkout']");
				
				Boolean test1= elementIsDisplayed("//input[@id='phone']");
				if(test1==true)
				{
					xpathJavaScriptScrollIntoViewClick("//input[@id='phone']");
				Thread.sleep(25000);
				xpathJavaScriptScrollIntoViewClick("//span[@class='btn btn-success font14 w-100 p-3']");

				}
				Thread.sleep(2000);
				Boolean test=elementIsDisplayed("//span[text()='Proceed']");
				if(test==true)
					
				xpathJavaScriptScrollIntoViewClick("//span[text()='Proceed']");
				
				Thread.sleep(2000);
				
				String m2=driver.getWindowHandle();
				String orderId=getText("(//strong[@class='font16'])[1]");
				int orderNo=Integer.parseInt(orderId);
				System.out.println("newly created order number: " + orderNo);
				Thread.sleep(2000);
				driver.close();
				
				driver.switchTo().window(m);
				refreshTab();
				Thread.sleep(2000);
				Orderno = getText("(//h3[contains(text(), 'Order no')][1])[1]");
			     Pattern pattern1 = Pattern.compile("\\d+");
			     Matcher matcher1 = pattern1.matcher(Orderno);
				if (matcher1.find()) {
			         String cleanNumber = matcher1.group();
			         System.out.println("First pending order number in SM: " + cleanNumber);
				int cleanNumber1=Integer.parseInt(cleanNumber);
			       if (orderNo == cleanNumber1)   
			      {
			    	   System.out.println("Customer and SM order number are same");
			      }
			       else
			       {
			    	   System.out.println("Customer and SM order number not are same");
			       }
			       }
				Thread.sleep(4000);
				refreshTab();
				scrollToTop();
				Thread.sleep(1500);  
	    scrollDown(30);
	    Thread.sleep(3000);
	    xpathJavaScriptScrollIntoViewClick("//a[@aria-label='Go to next page']");
	   		
	   	}
	}



