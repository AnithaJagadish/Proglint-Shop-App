package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class Refundrequeststepdefinition extends Baseclass{
	@When("click on the refundrequest tab")
	public void click_on_the_refundrequest_tab() throws Exception {
		idJavaScriptScrollIntoViewClick("refund");
	    TakeScreenShots("Refundrequest screen");
	    Thread.sleep(3000);
	}
	@When("checking the Refund requests title is present on the screen")
	public void checking_the_refund_requests_title_is_present_on_the_screen() throws InterruptedException {
		 String Tittleofthepage ="Refund requests";
		    String ActualTittleofthepage = getText("//h1[@class='font20 fw-bold']");
		    Thread.sleep(3000);
		    if(Tittleofthepage.equals(ActualTittleofthepage))
		    {
		    System.out.println("Tittle of the screen: Refund requests");	
		    }
		    else
		    {
		    	System.out.println("Incorrect tittle");
		    }
	}
	@When("Launching the order and check the refund action in admin")
	public void launching_the_order_and_check_the_refund_action_in_admin() throws Exception {
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
				
				//print the receipt no 
				String Receiptno = getText("(//div[@class='col-auto text-end'])[3]");
				System.out.println(Receiptno);
				String m2=driver.getWindowHandle();
				String orderId=getText("(//strong[@class='font16'])[1]");
				int orderNo=Integer.parseInt(orderId);
				Thread.sleep(2000);
				driver.switchTo().window(m);
				Thread.sleep(4000);
				refreshTab();
				Thread.sleep(1500);   
				 idJavaScriptScrollIntoViewClick("orders");
				    Thread.sleep(3000);
				IdSendKeys("searchOrder", orderId);
				xpathJavaScriptScrollIntoViewClick("//div[@class='row align-items-center']");
			    Thread.sleep(2000);
			    scrollToTop();
			    XpathClick("//input[@class='cursor-pointer'][1]");
			    XpathClick("//button[@class='btn btn-success font14 w-100 p-3']"); //Accept
			    Thread.sleep(5000);
			    //Ready to pickup the order
			    XpathClick("//button[@class='btn btn-success font14 w-100 p-3']"); //Ready to pickup
			    Thread.sleep(5000);
			    //Confirm Delivery the order
			    XpathClick("//button[@class='btn btn-success font14 w-100 p-3']"); //Confirm Delivery
			    Thread.sleep(5000);
			    scrollToTop();
			    XpathClick("//img[@class='modal-close']");
			    
			    //Raising the refund request
			    String m1=driver.getWindowHandle();
				driver.switchTo().window(m2);
			    Thread.sleep(1000);		 
			    xpathJavaScriptScrollIntoViewClick("//button[@class='btn btn-dark next-btn px-4 text-uppercase']"); //raising the refund
			    Thread.sleep(1000);
			    xpathJavaScriptScrollIntoViewClick("//img[@src='/static/media/plus.abd95bd6.svg']");
			    Thread.sleep(1000);
			    idJavaScriptScrollIntoViewClick("refundType");
			    WebElement no1=elementCreateXpath("//select[@class='form-select custom-field rounded-0 border-0']");
				Select s1= new Select(no1);
				s1.selectByValue("0");
				Thread.sleep(3000);    
			    xpathJavaScriptScrollIntoViewClick("//button[@class='btn btn-dark big-btn w-100 px-5 text-uppercase']");
                System.out.println("Refund has been raised in customer side");
                
			    //back to admin screen and try to accept the refund
			    driver.switchTo().window(m);
			    idJavaScriptScrollIntoViewClick("refund");
			    Thread.sleep(3000);
	            IdSendKeys("refundinput", Receiptno);
	            xpathJavaScriptScrollIntoViewClick("//div[@class='row align-items-center']");
			    Thread.sleep(2000);
			    idJavaScriptScrollIntoViewClick("selectAll");
			    Thread.sleep(2000);
			    idJavaScriptScrollIntoViewClick("APPROVE");
                System.out.println("Refund has been accepted in SM side");

			    
			    //back to refund screen and reject the refund
			    Thread.sleep(5000);
	            xpathJavaScriptScrollIntoViewClick("(//div[@class='row align-items-center'])[1]");
			    Thread.sleep(2000);
			    idJavaScriptScrollIntoViewClick("DECLINE");
			    Thread.sleep(2000);
			    IdSendKeys("setText", "Automation Testing");
			    Thread.sleep(5000);
			    idJavaScriptScrollIntoViewClick("setShowError");
                System.out.println("Refund has been Rejected in SM side");
			    Thread.sleep(20000);
			    
			    scrollToTop();
	}
	
	@When("checking the dropdown options and results")
	public void checking_the_dropdown_options_and_results() throws InterruptedException {		 
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    Thread.sleep(1000);
	    WebElement selectRefund = elementCreateXpath("//select[@class='form-select downfield mb-lg-0']");
	    Thread.sleep(1000);
	    js.executeScript("arguments[0].click();", selectRefund);
	    Thread.sleep(1000);
	    Select s2 = new Select(selectRefund);
	    Thread.sleep(1000);
	    java.util.List<WebElement> options = s2.getOptions();
	    Thread.sleep(1000);
	    for (WebElement option : options) {
		    Thread.sleep(1000);
	        System.out.println(option.getText());
	        Thread.sleep(2000);
	        option.click();
	        Thread.sleep(2000);
	    } 
	}
	@Then("checking the Filter conditions and results")
	public void checking_the_filter_conditions_and_results() throws InterruptedException {
		
		Thread.sleep(4000);
		scrollToTop();
		Thread.sleep(2000); 
		//xpathJavaScriptScrollIntoViewClick("//span[text()='Filter']");
		IdClick("FontAwesomeIcon");
		Thread.sleep(1000); 
		xpathJavaScriptScrollIntoViewClick("//input[@placeholder='From']");
		XpathClick("(//div[@aria-disabled='false'])[last()-0]");
	    
	    Thread.sleep(2000);
	    xpathJavaScriptScrollIntoViewClick("//input[@placeholder='To']");
	    XpathClick("(//div[@aria-disabled='false'])[last()-0]");
	    Thread.sleep(2000);
	    XpathClick("//span[@class='btn btn-success font14 w-100 p-3']");
	    Thread.sleep(2000);
        System.out.println("Filtered datas are displayed successfully");

	}

}
