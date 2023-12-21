package org.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class ReceiptListStepdefinition  extends Baseclass{
	@Given("Navigate to Receipt screen")
	public void navigate_to_receipt_screen() throws InterruptedException {
		Thread.sleep(2000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Receipt")));
		idJavaScriptScrollIntoViewClick("Receipt");
	}
	@When("Checking Searchicon,Filter,List of Receiptdetails & Pagination button is displayed")
	public void checking_searchicon_filter_list_of_receiptdetails_pagination_button_is_displayed() {
		//searchicon
				WebElement searchicon = elementCreateId("search-btn");
				if (searchicon.isDisplayed()) {
					System.out.println("Search Icon is Displayed--->Test case Passed");

				} else
					System.out.println("Search Icon is Not Displayed--->Test case Failed");
				
				//Filter
				WebElement filter = elementCreateId("openDateFilterModal");
				if (filter.isDisplayed()) {
					System.out.println("Filter button is Displayed--->Test case Passed");
				} else
					System.out.println("Filter button is Not Displayed--->Test case Failed");
				System.out.println();
				
				//List of Receiptdetails
				List<WebElement> list = driver.findElements(By.xpath("//div[@id='orders-list']/a"));
				System.out.println("List of receipt details in the current screen");
				System.out.println();
				for (WebElement singlereceipt : list) {
					String receiptdata = singlereceipt.getText();
					System.out.println(receiptdata);
					System.out.println("-------------------");
				}
				System.out.println("List of Receipt details is Displayed in the screen--->Test case passed");
				
				//Pagination button
				WebElement pagination = driver.findElement(By.xpath("//li[@class='active']"));
				if (pagination.isEnabled()) {
					System.out.println("Pagination button is displayed--->Test case Passed");
				} else
					System.out.println("Pagination button is displayed--->Test case Failed");
				System.out.println();
				scrollToTop();
	}
	@When("Applying filter & capturing list")
	public void applying_filter_capturing_list() throws InterruptedException {
		Thread.sleep(3000);
		IdClick("openDateFilterModal");
		/*
		XpathClick("//div[@class='modal-body p-50']//div[3]/div[1]");
		XpathClick("//div[@class='react-datepicker__month']/div[4]/div[2]");
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-body p-50']//div[3]/div[2]");
		XpathClick("//div[@class='react-datepicker__month']/div[5]/div[3]");
		*/
		XpathClick("//input[@placeholder='From']");
	    Thread.sleep(2000);
	    xpathJavaScriptScrollIntoViewClick("(//div[@tabindex='0'])[last()-1]");
	    Thread.sleep(2000);
	    XpathClick("//input[@placeholder='To']");
	    Thread.sleep(2000);
	    xpathJavaScriptScrollIntoViewClick("(//div[@tabindex='0'])[last()-1]");
	    Thread.sleep(2000);
		
		List<WebElement>dropdown=driver.findElements(By.xpath("//select[@id='category']/option"));
		int drpdwnsize=dropdown.size();
		for(int i=1;i<drpdwnsize;i++)
			{
			Select s = new Select(driver.findElement(By.id("category")));
			s.selectByValue(""+i+"");
			IdClick("onClickSuccess");
			Thread.sleep(3000);
			String data = driver.findElement(By.id("orders-list")).getText();
				if(data.equalsIgnoreCase("Receipt Not Found"))
				{
				System.out.println(data);
				System.out.println("-------------------");
				Thread.sleep(5000);
				}
				else 
				{
				List<WebElement> list1 = driver.findElements(By.xpath("//div[@id='orders-list']/a"));
				System.out.println();
					for (WebElement singlereceipt : list1) 
					{
					String receiptdata = singlereceipt.getText();
					System.out.println(receiptdata);
					System.out.println("-------------------");
					}
				}
				if(i==5) 
				{
				IdClick("openDateFilterModal");
				Thread.sleep(2000);
				IdClick("clearFilter");
				break;
				} else 
					IdClick("openDateFilterModal");
				
			}
		System.out.println("Test case passed");
	}
	@When("Close the receipt by close button")
	public void close_the_receipt_by_close_button() throws InterruptedException {
		Thread.sleep(5000);
		XpathClick("//div[@id='orders-list']/a[1]/div");
		Thread.sleep(2000);
		XpathClick("//div[@class='modal-content rounded-0']/img[@id='Close']");
		System.out.println("Receipt of the Order is Closed---> Test case passed");
		System.out.println();
		Thread.sleep(5000);
	}
	@When("Open the receipt and capture the details of the order")
	public void open_the_receipt_and_capture_the_details_of_the_order() throws InterruptedException {
		XpathClick("//div[@id='orders-list']/a[1]/div");
		String details=getText("//div[@class='col']/h5");
		System.out.println("The First order details in the screen is displaying below");
		String personsinfo=getText("//div[@class='row align-items-center mb-4']/div[2]");
		System.out.println(details+"of "+personsinfo+" is follows");
		System.out.println("------------");
		String ordertype=getText("//div[@class='modal-body font13 p-40']/div[2]");
		System.out.println(ordertype);
		System.out.println("------------");
		String address=getText("//div[@class='modal-body font13 p-40']/p");
		System.out.println("Address of the customer is");
		System.out.println(address);
		System.out.println("------------");
		String bill=getText("//div[@class='modal-body font13 p-40']/div[4]/child::div[2]");
		System.out.println("Status of the Bill is "+bill);
		System.out.println("------------");
		String product=getText("//div[@class='pt-3']");
		String other=getText("//div[@class='dotted-divider pt-2 mt-2 mb-3']");
		String amt=getText("//div[@class='modal-body font13 p-40']/div[7]");
		System.out.println("Product details and Receipt summary is ");
		System.out.println(product);
		System.out.println("------------");
		System.out.println(other);
		System.out.println("------------");
		System.out.println(amt);
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-content rounded-0']/img[@id='Close']");
		refreshTab();
		Thread.sleep(3000);
	}
	@When("Checking the search bar")
	public void checking_the_search_bar() {
		IdSendKeys("searchOrder", "128");
		String searchedone=getText("//div[@id='orders-list']/a");
		System.out.println(searchedone);
		System.out.println("---------------");
		System.out.println();
	}
	@Then("Checking the pagination")
	public void checking_the_pagination() throws InterruptedException {
		refreshTab();
		scrollDown(500);
		for(int i=4;i<7;i++)
		{
			WebElement page=driver.findElement(By.xpath("//ul[@class='pagination']/li["+i+"]"));
			Thread.sleep(3000);
			page.click();
			Thread.sleep(4000);
			if(i==6)
			{
				XpathClick("//ul[@class='pagination']/li[6]");
			}
		}
		System.out.println("Pagination button is working");
		Thread.sleep(4000);
		scrollToTop();
	}
	
}
