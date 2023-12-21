package org.stepdefinition;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class Dashboardstepdefinition extends Baseclass {
	int tc=13;
	String url = getURL();
	

	@Given("Navigation to Dashboard screen")
	public void navigation_to_dashboard_screen() throws Exception {
		
		if(url.contains("shop-admin.proglint.com"))
		{
			
			System.out.println("Test case "+tc+" Pass"+"-->Navigation to Dashboard screen");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail"+"-->Navigation to Dashboard screen");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
		
		}
	}
	@When("Requested order click")
	public void requested_order_click() throws Exception {
		tc++;
		xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold'])[1]");
		url = getURL();
		if(url.equals("https://shop-admin.proglint.com/orders"))
		{
			
			System.out.println("Test case "+tc+" Pass"+"-->Requested order navigation through dashboard");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail"+"-->Requested order navigation through dashboard");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);
		
		}
	}
	@When("Checking the dashboard orders count\\(Inprogress, Yet to deliver,refund accept and reject)")
	public void checking_the_dashboard_orders_count_inprogress_yet_to_deliver_refund_accept_and_reject() throws Exception {
		//TC3--
		//Check if requested orders increase after new order placed.
		tc++;
		String val1 = getText("(//h3[@class='font40 fw-bold'])[1]");
		int val2=Integer.parseInt(val1);
		tc++;
		scrollDown(300);
		String Tc=String.valueOf(tc)+"BeforeOrder";
		TakeScreenShots(Tc);
		String m=driver.getWindowHandle();
		val1 = getText("(//h3[@class='font40 fw-bold'])[1]");
		val2=Integer.parseInt(val1);
		
		openInNewTab("https://shop.proglint.com/", driver);
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@class='modal-body p-50']/child::div[2]/div/div")).click();
		Thread.sleep(4000);
		Actions act=new Actions(driver);
		WebElement strselect=driver.findElement(By.id("react-select-2-input"));
		act.moveToElement(strselect).sendKeys("Comp").build().perform();
		strselect.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		TakeScreenShots("Selected store");
		
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
		IdClick("category");
		xpathJavaScriptScrollIntoViewClick("(//img[@alt='1'])[2]");
		Thread.sleep(2000);
			scrollDown(550);
			//val1=getText("(//button[@class='btn btn-outline-dark font15 fw-bold mt-2'])[1]");
			val1=getText("(//h2[@class='font16 product-list title-case'])[1]");  //Anitha

			//xpathJavaScriptScrollIntoViewClick("(//*[text()='+ Add to cart'])[1]");
			xpathJavaScriptScrollIntoViewClick("(//button[@class='btn btn-outline-dark font15 fw-bold mt-2'])[1]"); //Anitha

			idJavaScriptScrollIntoViewClick("navCartScreen");
			Boolean check=elementIsDisplayedByXpath("//*[text()='Select Delivery Options']");
			
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
			Thread.sleep(2000);
			driver.switchTo().window(m);
			Thread.sleep(4000);
			refreshTab();
			Thread.sleep(1500);   
			val1 = getText("(//h3[@class='font40 fw-bold'])[1]");
			int val3=Integer.parseInt(val1);
			//For using in next tc val4
			int val4= val3;
			
			if (val3==val2 + 1)
			{
				System.out.println("Test case "+tc+" Pass"+"--->Request order increased after new order");
				Tc=String.valueOf(tc)+"AfterOrder";
				scrollDown(100); 
				TakeScreenShots(Tc);
			}
			
			else 
			{
				System.out.println("Test case "+tc+" Fail"+"--->Request order not increased after new order");
				Tc=String.valueOf(tc)+"AfterOrder";
				scrollDown(100);
				TakeScreenShots(Tc);
			}


//TC4
//Order In Progress Click

tc++;
xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold'])[2]");
url=getURL();

if(url.equals("https://shop-admin.proglint.com/orders"))
{
	
	System.out.println("Test case "+tc+" Pass"+"--->Inprogress click successfull");
	 Tc=String.valueOf(tc);
	TakeScreenShots(Tc);
	launchUrl("https://shop-admin.proglint.com/dashboard", driver);
	
}
else
{
	System.out.println("Test case "+tc+" Fail");
	Tc=String.valueOf(tc);
	TakeScreenShots(Tc);
	launchUrl("https://shop-admin.proglint.com/dashboard", driver);
}


//TC5
//Checking if order in progress increases in dashboard after an order is accepted.
tc++;
scrollDown(300);
Tc=String.valueOf(tc)+"BeforeOrderAccept";
TakeScreenShots(Tc);
val1 = getText("(//h3[@class='font40 fw-bold'])[2]");
val2=Integer.parseInt(val1);
xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold'])[1]");
IdSendKeys("searchOrder",orderId);
xpathJavaScriptScrollIntoViewClick("//*[text()='"+orderId+"']");
Thread.sleep(1500);
idJavaScriptScrollIntoViewClick("check");
Thread.sleep(1500);
xpathJavaScriptScrollIntoViewClick("//*[text()='Accept']");
Thread.sleep(1500);
idJavaScriptScrollIntoViewClick("Close");
Thread.sleep(1500);
launchUrl("https://shop-admin.proglint.com/dashboard", driver);
Thread.sleep(1500);
val1 = getText("(//h3[@class='font40 fw-bold'])[2]");
val3=Integer.parseInt(val1);
Thread.sleep(1500);
if (val3==val2 + 1)
{
	System.out.println("Test case "+tc+" Pass"+"--->Order in Progress increases after order accepted");
	Tc=String.valueOf(tc)+"AfterOrderAccepted";
	scrollDown(200);
	TakeScreenShots(Tc);
}

else 
{
	System.out.println("Test case "+tc+" Fail"+"--->Order in Progress not increased after order accepted");
	Tc=String.valueOf(tc)+"AfterOrderAccepted";
	scrollDown(200);
	TakeScreenShots(Tc);
}
scrollToTop();

//TC6
// Check if order requested decreases after order accepted.
tc++;
Thread.sleep(1500);
String val5= getText("(//h3[@class='font40 fw-bold'])[1]");
int value5=Integer.parseInt(val5);
if (value5==val4-1)
{
	System.out.println("Test case "+tc+" Pass"+"--->Requested Order decreases after order accepted");
	Tc=String.valueOf(tc)+"AfterOrderAccepted";
	scrollDown(200);
	TakeScreenShots(Tc);
}

else 
{
	System.out.println("Test case "+tc+" Fail"+"--->Requested Order does not decrease after order accepted");
	Tc=String.valueOf(tc)+"AfterOrderAccepted";
	scrollDown(200);
	TakeScreenShots(Tc);
}
scrollToTop();


//Check if Order in Progress  count decreases after order is Ready to pick up
//TC7
tc++;
val1 = getText("(//h3[@class='font40 fw-bold'])[2]");
val2=Integer.parseInt(val1);
val5=getText("(//h3[@class='font40 fw-bold '])[1]");
int val6=Integer.parseInt(val5);

xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold'])[2]");
IdSendKeys("searchOrder",orderId);
xpathJavaScriptScrollIntoViewClick("//*[text()='"+orderId+"']");
Thread.sleep(1500);
xpathJavaScriptScrollIntoViewClick("//button[@id='PickupAndScanButton']");
Thread.sleep(1500);
xpathJavaScriptScrollIntoViewClick("//img[@id='Close']");
launchUrl("https://shop-admin.proglint.com/dashboard", driver);
Thread.sleep(1500);
scrollDown(100);
val1 = getText("(//h3[@class='font40 fw-bold'])[2]");
val3=Integer.parseInt(val1);
Thread.sleep(1500);


if (val3==val2-1)
{
	System.out.println("Test case "+tc+" Pass"+"--->Order in Progress decreases when Ready to pickup clicked");
	Tc=String.valueOf(tc)+"AfterOrderPickupClicked";
	scrollDown(150);
	TakeScreenShots(Tc);
}

else 
{
	System.out.println("Test case "+tc+" Fail"+"--->Order in Progress does not decreases when Ready to pickup clicked");
	Tc=String.valueOf(tc)+"AfterOrderPickupClicked";
	scrollDown(150);
	TakeScreenShots(Tc);
}



//Check if Yet to deliver  count increases after order is Ready to pick up
		//TC8
		tc++;
		val5=getText("(//h3[@class='font40 fw-bold '])[1]");
		int val7=Integer.parseInt(val5);
		
		Thread.sleep(1500);
		
		
		if (val7==val6+1)
		{
			System.out.println("Test case "+tc+" Pass"+"--->Yet to deliver increases when Ready to pickup clicked");
			Tc=String.valueOf(tc)+"BeforeOrderPickupClicked";
			scrollDown(150);
			TakeScreenShots(Tc);
		}
		
		else 
		{
			System.out.println("Test case "+tc+" Fail"+"--->Yet to deliver does not increase when Ready to pickup clicked");
			Tc=String.valueOf(tc)+"AfterOrderPickupClicked";
			scrollDown(150);
			TakeScreenShots(Tc);
		}





//TC8
//Yet to deliver Click
tc++;
xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold '])[1]");
url=getURL();

if(url.equals("https://shop-admin.proglint.com/orders"))
{
	
	System.out.println("Test case "+tc+" Pass"+"-->Yet to deliver navigation from Dashboard");
	 Tc=String.valueOf(tc);
	TakeScreenShots(Tc);
	launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
}
else
{
	System.out.println("Test case "+tc+" Fail"+"-->Yet to deliver navigation from Dashboard");
	 Tc=String.valueOf(tc);
	TakeScreenShots(Tc);
	launchUrl("https://shop-admin.proglint.com/dashboard", driver);

}

//Check if Yet to deliver  count decreases after order is complete
//TC8
tc++;
Tc=String.valueOf(tc)+"BeforeOrderdelivered";
scrollDown(150);
TakeScreenShots(Tc);
Thread.sleep(1500);
xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold '])[1]");
IdSendKeys("searchOrder",orderId);
xpathJavaScriptScrollIntoViewClick("//*[text()='"+orderId+"']");
Thread.sleep(1500);
xpathJavaScriptScrollIntoViewClick("//*[text()='Confirm delivery']");
Thread.sleep(1500);
xpathJavaScriptScrollIntoViewClick("//img[@id='Close']");
launchUrl("https://shop-admin.proglint.com/dashboard", driver);
Thread.sleep(1500);
scrollDown(100);
val1 = getText("(//h3[@class='font40 fw-bold '])[1]");
val3=Integer.parseInt(val1);
Thread.sleep(1500);

if (val3==val7-1)
{
	System.out.println("Test case "+tc+" Pass"+"--->Yet to deliver decreases when order is delivered");
	Tc=String.valueOf(tc)+"AfterOrderdelivered";
	scrollDown(150);
	TakeScreenShots(Tc);
}

else 
{
	System.out.println("Test case "+tc+" Fail"+"--->Yet to deliver does not decrease after order is delivered");
	Tc=String.valueOf(tc)+"AfterOrderDelivered";
	scrollDown(150);
	TakeScreenShots(Tc);
}
scrollToTop();

//Check if Refund Request count increase after a new refund request is raised
	//TC17
			tc++;
			Tc=String.valueOf(tc)+"BeforeRefundRequest";
			scrollDown(150);
			TakeScreenShots(Tc);
			Thread.sleep(1500);
			val1 = getText("(//h3[@class='font40 fw-bold '])[2]");
			val3=Integer.parseInt(val1);
			
			scrollToTop();
			
			driver.switchTo().window(m2);
			
			xpathJavaScriptScrollIntoViewClick("//button[text()='Request Refund']");
			Thread.sleep(1500);
			xpathJavaScriptScrollIntoViewClick("//img[@alt='+']");
			Thread.sleep(1500);
			WebElement element=elementCreateId("refundType");
			selectByIndex(1,element);
			xpathJavaScriptScrollIntoViewClick("//button[text()='SUBMIT']");
			Thread.sleep(3000);
			//driver.close();
			/*
			xpathJavaScriptScrollIntoViewClick("(//img[@src='/static/media/user.13be5495.svg'])[1]");
			xpathJavaScriptScrollIntoViewClick("//*[text()=' Logout']");
			xpathJavaScriptScrollIntoViewClick("//*[text()='Yes']");
			*/
			
			driver.switchTo().window(m);
			refreshTab();
			scrollDown(150);
			Thread.sleep(2000);
			val5 = getText("(//h3[@class='font40 fw-bold '])[2]");
			val6=Integer.parseInt(val5);
			if (val6==val3+1)
			{
				System.out.println("Test case "+tc+" Pass"+"--->Refund Request count increases when new request is raised");
				Tc=String.valueOf(tc)+"AfterRequestRaised";
				scrollDown(50);
				TakeScreenShots(Tc);
				
			}
			
			else 
			{
				System.out.println("Test case "+tc+" Fail"+"--->Refund Request count is not increased when new request is raised");
				Tc=String.valueOf(tc)+"AfterRequestRaised";
				scrollDown(50);
				TakeScreenShots(Tc);
			}

			scrollToTop();

			
//Check if Refund Request count decrease after refund request is accepted
//TC18
					tc++;
					Tc=String.valueOf(tc)+"BeforeRefundAccept";
					scrollDown(200);
					TakeScreenShots(Tc);
					Thread.sleep(1500);
					val1 = getText("(//h3[@class='font40 fw-bold '])[2]");
					val3=Integer.parseInt(val1);
					
					scrollToTop();
					xpathJavaScriptScrollIntoViewClick("(//h3[@class='font40 fw-bold '])[2]");
					IdSendKeys("refundinput",orderId);
					Thread.sleep(1000);
					xpathJavaScriptScrollIntoViewClick("//*[text()='"+orderId+"']");
					Thread.sleep(1500);
					
					idJavaScriptScrollIntoViewClick("selectAll");
					Thread.sleep(1500);
					idJavaScriptScrollIntoViewClick("APPROVE");
					Thread.sleep(2000);
					launchUrl("https://shop-admin.proglint.com/dashboard", driver);
					Thread.sleep(1500);
					scrollDown(350);
					val5 = getText("(//h3[@class='font40 fw-bold '])[2]");
					val6=Integer.parseInt(val5);
				
					Thread.sleep(1500);
					
					if (val6==val3-1)
					{
						System.out.println("Test case "+tc+" Pass"+"--->Refund Request count decreases when Request is accepted");
						Tc=String.valueOf(tc)+"AfterRefundAccepted";
						
						TakeScreenShots(Tc);
					}
					
					else 
					{
						System.out.println("Test case "+tc+" Fail"+"--->Refund Request count does not decrease after Request is accepted");
						Tc=String.valueOf(tc)+"AfterRefundAccepted";
					
						TakeScreenShots(Tc);
					}
					scrollToTop();

	}

	
	@When("Set Max Visitor-->Increase")
	public void set_max_visitor_increase() throws Exception {
		tc++;
		//String Tc=String.valueOf(tc)+"BeforeSetMaxVisitor";
		String txt = getAttribute("(//input[@type='text'])[2]","value");
		int tdd= Integer.parseInt(txt);
		xpathJavaScriptScrollIntoViewClick("//img[@alt='+']");
		xpathJavaScriptScrollIntoViewClick("//button[@id='onUpdateVisitor']");
		Thread.sleep(2000);
		txt = getAttribute("(//input[@type='text'])[2]","value");
		int tdd1=Integer.parseInt(txt);
		
		if(tdd1==tdd+1)
		{
			System.out.println("Test case "+tc+" Pass"+"--->Increasing the max visitor count");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
			tc++;
			System.out.println("Test case "+tc+" Pass"+"--->The update button Works");		
		}
		else
		{
			System.out.println("Test case "+tc+" Fail");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
		
		}
	}
	@When("Set Max Visitor-->Decrease")
	public void set_max_visitor_decrease() throws Exception {
		tc++;
		String txt = getAttribute("(//input[@type='text'])[2]","value");
		int tdd= Integer.parseInt(txt);
		xpathJavaScriptScrollIntoViewClick("//img[@alt='-']");
		xpathJavaScriptScrollIntoViewClick("//button[@id='onUpdateVisitor']");
		Thread.sleep(2000);
		 txt = getAttribute("(//input[@type='text'])[2]","value");
		int tdd1=Integer.parseInt(txt);
		
		if(tdd1==tdd-1)
		{
			System.out.println("Test case "+tc+" Pass"+"--->Decreasing the max visitor count");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
		}
		else
		{
			System.out.println("Test case "+tc+" Fail");
			String Tc=String.valueOf(tc);
			TakeScreenShots(Tc);
		
		}
		scrollToTop();
	}
	@When("TC11 Store open close status , radio button checking")
	public void tc11_store_open_close_status_radio_button_checking() throws Exception {
		tc++;
		refreshTab();
		scrollToTop();
		xpathJavaScriptScrollIntoViewClick("(//input[@type='radio'])[2]");
		boolean val = elementIsDisplayed("//span[@class='btn btn-success font14 w-100 p-3']");
				if (val==true)
					{
						System.out.println("Test case "+tc+" Pass"+"---->Store is in open status");
						String Tc=String.valueOf(tc+" Module 1");
						scrollToTop();
						TakeScreenShots(Tc);
						xpathJavaScriptScrollIntoViewClick("//span[@class='btn btn-success font14 w-100 p-3']");
						tc++;
						scrollToTop();
						TakeScreenShots(tc+" Module 2");
						System.out.println("Test case "+tc+" Pass"+"--->Store is in close status");
						scrollToTop();
					}
				else
					{
						System.out.println("Test case "+tc+" Pass"+"---->Store is in close status");
						String Tc=String.valueOf(tc+"Module 1");
						scrollToTop();
						TakeScreenShots(Tc);
						xpathJavaScriptScrollIntoViewClick("(//input[@type='radio'])[1]");
						val = elementIsDisplayed("//span[@class='btn btn-success font14 w-100 p-3']");
						
						if (val==true)
							{	
								tc++;
								System.out.println("Test case "+tc+"Pass"+"---->Store Open radio button clicked");
								Tc=String.valueOf(tc+"Module 2");
								TakeScreenShots(Tc);
								xpathJavaScriptScrollIntoViewClick("//span[@class='btn btn-success font14 w-100 p-3']");
								tc++;
								Tc=String.valueOf(tc+"Module 3");		
								System.out.println("Test case "+tc+" Pass"+"---->Store is in open status");
								TakeScreenShots(Tc);
								scrollToTop();
							}
						else
							{
								tc++;
								System.out.println("Test case "+tc+"Pass"+"--->Store is in close status");
								
								Tc=String.valueOf(tc+"Module 2");
								TakeScreenShots(Tc);
								scrollToTop();
							}
						tc++;
						System.out.println("Test case "+tc+" Pass");
						scrollToTop();
					
					}
				xpathJavaScriptScrollIntoViewClick("(//input[@type='radio'])[1]");
				xpathJavaScriptScrollIntoViewClick("//span[@class='btn btn-success font14 w-100 p-3']");

	}
	@When("WIWO page navigating")
	public void wiwo_page_navigating() throws Exception {
		tc++;
		
		Thread.sleep(2000);	
		xpathJavaScriptScrollIntoViewClick("//*[text()=' WIWO ']");
		scrollToTop();
		refreshTab();
		Thread.sleep(2000);
		//idJavaScriptScrollIntoViewClick("openDateFilterModal");
		
		
		String Sample = getURL();
		 String Tc = tc+"";
		if(Sample.equals("https://shop-admin.proglint.com/invoiceList"))
		{
			System.out.println("Test case "+tc+" Pass"+"-->WIWO page navigation from Dashboard");
			TakeScreenShots(Tc);
			scrollToTop();
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail"+"-->WIWO page navigation from Dashboard");
			TakeScreenShots(Tc);
			scrollToTop();
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
	}
	@When("Hybrid Order page navigation from Dashboard")
	public void hybrid_order_page_navigation_from_dashboard() throws Exception {
		tc++;
		String Tc = tc+"";
		Thread.sleep(3000);	
		xpathJavaScriptScrollIntoViewClick("//*[text()=' Hybrid ']");
		//idJavaScriptScrollIntoViewClick("openDateFilterModal");
		
		String Sample = getURL();
		
		
		if(Sample.equals("https://shop-admin.proglint.com/invoiceList"))
		{
			System.out.println("Test case "+tc+" Pass"+"-->Hybrid Order page navigation from Dashboard");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail"+"-->Hybrid Order page navigation from Dashboard");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
	}
	@When("Online Order page navigation from Dashboard")
	public void online_order_page_navigation_from_dashboard() throws Exception {
		tc++;
		String Tc=tc+"";
		Thread.sleep(3000);	
		scrollToTop();
		xpathJavaScriptScrollIntoViewClick("//*[text()=' Online ']");
		//idJavaScriptScrollIntoViewClick("openDateFilterModal");
		String Sample = getURL();
		
		if(Sample.equals("https://shop-admin.proglint.com/invoiceList"))
		{
			System.out.println("Test case "+tc+" Pass"+"-->Online Order page navigation from Dashboard");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail"+"-->Online Order page navigation from Dashboard");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}

	}
	@When("Refund Requests page navigation from Dashboard")
	public void refund_requests_page_navigation_from_dashboard() throws Exception {
		tc++;
		String Tc=tc+"";
		Thread.sleep(3000);	
		xpathJavaScriptScrollIntoViewClick("//*[text()=' Refund ']");
		//IdClick("openDateFilterModal");
		//Sample =getText("//select[@id='category']");
		String Sample = getURL();
		
		//System.out.println(Sample);
		if(Sample.equals("https://shop-admin.proglint.com/refund"))
		{
			System.out.println("Test case "+tc+" Pass"+"-->Refund Requests page navigation from Dashboard");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail"+"-->Refund Requests page navigation from Dashboard");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
	}
	
	@When("Notifications page Navigation")
	public void notifications_page_navigation() throws Exception {
		tc++;
		String Tc=tc+"";
		Thread.sleep(3000);	
		xpathJavaScriptScrollIntoViewClick("(//*[text()=' Notifications'])[2]");
		scrollToTop();
		//IdClick("openDateFilterModal");
		//Sample =getText("//select[@id='category']");
		String Sample = getURL();
		
		if(Sample.equals("https://shop-admin.proglint.com/notification"))
		{
			System.out.println("Test case "+tc+" Pass"+"--->Checked the Notification page navigation");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
	}
	@When("Blocked Customer Page navigation from Dashboard")
	public void blocked_customer_page_navigation_from_dashboard() throws Exception {
		tc++;
		String Tc=tc+"";
		Thread.sleep(3000);	
		xpathJavaScriptScrollIntoViewClick("(//*[text()=' Blocked customers'])[3]");
		String Sample = getURL();
		
		if(Sample.equals("https://shop-admin.proglint.com/customerunblocking"))
		{
			System.out.println("Test case "+tc+" Pass"+"--->Checked the Blocked Customer page navigation");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Test case "+tc+" Fail");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}

	}
	@When("No Notifications")
	public void no_notifications() throws Exception {
		tc++;
		String Tc=tc+"";
		String Sample=getText("(//div[@class='row'])[3]");
		
		if(Sample.equals("You don't have any notifications currently"))
		{
			System.out.println("Test case "+tc+" Pass"+"--->Notifications page displayed correct message");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
		else
		{
			System.out.println("Unresolved Notifications are present");
			TakeScreenShots(Tc);
			launchUrl("https://shop-admin.proglint.com/dashboard", driver);	
			
		}
	}
	@When("PIM opened after clicking Goto PIM")
	public void PIM_opened_after_clicking_Goto_PIM() throws Exception {
		tc++;
		String Tc=tc+"";
		idJavaScriptScrollIntoViewClick("openPim");
		Actions action = new Actions(driver);
		action.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		String Sample=driver.getWindowHandle();
		Set<String> Sample1 = driver.getWindowHandles();
		Iterator<String> itr = Sample1.iterator();
		
		while(itr.hasNext())
			{
				String window = itr.next();
				driver.switchTo().window(window);
				int a=1;
				if(driver.getTitle().equals("PIM - Home"))
				{
					System.out.println("Test case "+tc+" Pass"+"--->PIM page is opened");
					TakeScreenShots(Tc);
					a++;
					closeTab();
				}
				else if(a>1)
				{
					System.out.println("Test case "+tc+" Fail");
					TakeScreenShots(Tc);
				}
			}
		
		
		driver.switchTo().window(Sample);
	}
	
	@When("Navigate to orders- verify")
	public void navigate_to_orders_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		idJavaScriptScrollIntoViewClick("Orders");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/orders"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Orders page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to Receipt List- verify")
	public void navigate_to_receipt_list_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Receipt");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/invoiceList"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Receipt List page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to Product Search- verify")
	public void navigate_to_product_search_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Product");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/products"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Find product page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to Store Timing - verify")
	public void Navigate_to_Store_Timing_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Timing");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/storeavailability"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Store Timing page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
		
	}
	@When("Navigate to Promotions- verify")
	public void navigate_to_promotions_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Promotions");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/promotion/dashboard"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Promotions page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to reports - verify")
	public void navigate_to_reports_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Reports");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/report"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Reports page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
		
	}
	@When("Navigate to planogram- verify")
	public void navigate_to_planogram_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Planogram");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/planogram"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Planogram page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to Refund- verify")
	public void navigate_to_refund_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Refund");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/refund"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Refund request page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to Blocked Customer- verify")
	public void navigate_to_blocked_customer_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Customers");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/customerunblocking"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Blocked Customer page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
		
	}
	@When("Navigate to chat- verify")
	public void navigate_to_chat_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Chat");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/chats"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Chat page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
	@When("Navigate to notification- verify")
	public void navigate_to_notification_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Notifications");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/notification"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Notification page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
		
	}
	@When("Navigate to members- verify")
	public void Navigate_to_members_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Branches");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/members"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Members page navigation from Dashboard");
				TakeScreenShots(Tc);
				idJavaScriptScrollIntoViewClick("Home");
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
				idJavaScriptScrollIntoViewClick("Home");
			}	
	}
	@Then("Navigate to settings- verify")
	public void navigate_to_settings_verify() throws Exception {
		tc++;
		String Tc=tc+"";
		
		idJavaScriptScrollIntoViewClick("Settings");
		url=getURL();
		
		if(url.equals("https://shop-admin.proglint.com/changepassword"))
			{
				System.out.println("Test case "+tc+" Pass"+"--->Settings page navigation from Dashboard");
				TakeScreenShots(Tc);
			}
		else
			{
				System.out.println("Test case "+tc+" Fail");
				TakeScreenShots(Tc);
			}
	}
}
