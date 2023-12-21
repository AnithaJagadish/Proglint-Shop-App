package org.stepdefinition;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ShopAppCustomer  extends Baseclass{
	@Given("Lanuch the correct customer url")
	public void lanuch_the_correct_customer_url() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		launchUrl("https://shop.proglint.com/", driver);
		Thread.sleep(3000);
		refreshTab();
		Thread.sleep(3000);
	}
	@When("Store selection dropdown")
	public void store_selection_dropdown() throws InterruptedException {
		Thread.sleep(3000);
		XpathClick("//div[@class=' css-tlfecz-indicatorContainer']");
		Thread.sleep(2000);
	}
	@When("Selecting the store")
	public void selecting_the_store() throws InterruptedException {
		Actions act=new Actions(driver);
		WebElement strselect=driver.findElement(By.id("react-select-2-input"));
		act.moveToElement(strselect).sendKeys("Comp").build().perform();
		strselect.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
	}
	@Then("Clicking on the proceed button")
	public void clicking_on_the_proceed_button() throws InterruptedException {
		XpathClick("//div[@class='modal-body p-50']/child::div[3]/button");
		System.out.println("Tc-8-Store selection is successfull ");
		Thread.sleep(2000);
	}
	@When("Clicking on the login")
	public void clicking_on_the_login() throws InterruptedException {
		Thread.sleep(2000);
		IdClick("openLogin");
		Thread.sleep(2000);
		//TakeScreenShots("Login");
	}
	@When("Dropdown selection for country code")
	public void dropdown_selection_for_country_code() {
		WebElement no=driver.findElement(By.xpath("//select[@class='form-control custom-field']"));
		Select s= new Select(no);
		s.selectByValue("+91");
	}
	@When("Entering the mobile no and pswd")
	public void entering_the_mobile_no_and_pswd() {
		XpathSendkey("//div[@class='form-group']/child::div/input","8489998517");
		XpathSendkey("//div[@class='input-group mb-4']/input","Dhina@123");
		driver.findElement(By.id("view-pass")).click();
		actionXpathClick("//div[@class='text-center pt-4']/button");
		System.out.println("Tc-9-Login is successfull");
	}
	@When("Profile data")
	public void profile_data() {
		XpathClick("//span[@class='user d-none d-lg-inline-block me-4 text-link']");
		System.out.println("Tc-10-Navigated to the Profile screen is Successful");
	}
	@When("Capturing the Recent Order details")
	public void capturing_the_recent_order_details() throws InterruptedException {
		String orderdetails=getText("(//*[@id='navOrderSummary']/div[1])[1]");
		System.out.println("Tc-11-Capturing the Recent Order details");
		System.out.println(orderdetails);
		Thread.sleep(2000);
	}
	@When("Navigate to Profile and editing the profile")
	public void navigate_to_profile_and_editing_the_profile() throws InterruptedException {
		System.out.println("Tc-12-Navigate to Profile is successfull");
		//TakeScreenShots("Profile");		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		XpathClick("//div[@id='account-nav']/ul/li[2]");
		Thread.sleep(2000);
		System.out.println("Tc-13-Edit click is successfull");
		//	TakeScreenShots("Edit option");
		Thread.sleep(2000);
		WebElement fname = elementCreateXpath("//input[@id='FirstName']");
		String fname1 = fname.getAttribute("value");
		WebElement lname = elementCreateXpath("//input[@id='LastName']");
		String lname1 = lname.getAttribute("value");
		WebElement mailid = elementCreateXpath("//input[@id='EmailField']");
		String mailid1 = mailid.getAttribute("value");
		System.out.println("\n Before updating the profile \n");
		System.out.println(fname1);
		System.out.println(lname1);
		System.out.println(mailid1);
		Thread.sleep(2000);
		System.out.println("Tc-14-Before Edit is successfull");
		//TakeScreenShots("Before Edit");
	}
	@When("Updating the profile with different data")
	public void updating_the_profile_with_different_data() throws InterruptedException {
		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys(Keys.BACK_SPACE);
		XpathSendkey("//input[@id='LastName']","T");
		xpathClear("//input[@id='EmailField']");
		XpathSendkey("//input[@id='EmailField']","adlinselvarex.a@proglint.com");
		//xpathJavaScriptScrollIntoViewClick("//button[@id='update']");

        //Again Profile data
		System.out.println("\n After updating the profile \n");
		WebElement fname2 = elementCreateXpath("//input[@id='FirstName']");
		String fname3 = fname2.getAttribute("value");
		WebElement lname2 = elementCreateXpath("//input[@id='LastName']");
		String lname3 = lname2.getAttribute("value");
		WebElement mailid2 = elementCreateXpath("//input[@id='EmailField']");
		String mailid3 = mailid2.getAttribute("value");
		System.out.println(fname3);
		System.out.println(lname3);
		System.out.println(mailid3);
		Thread.sleep(2000);
		System.out.println("Tc-15-After Edit is successfull");
		//	TakeScreenShots("After Edit");
		Thread.sleep(3000);
		/*
			xpathJavaScriptScrollIntoViewClick("(//img[@src='/static/media/user.13be5495.svg'])[1]");
			xpathJavaScriptScrollIntoViewClick("//*[text()=' Logout']");
			xpathJavaScriptScrollIntoViewClick("//*[text()='Yes']");
		 */
		System.out.println();
		//System.out.println("Proceeding to verify the Dashboard Screen functions");
	}
	@When("Managing the address")
	public void managing_the_address() throws InterruptedException {
		XpathClick("//div[@id='account-nav']/ul/li[4]");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Tc-16-Manage address is successfull");
		boolean b = elementIsDisplayedById("delete");
		if(b==true)
		{
		//WebElement q =	elementCreateId("delete");		
		IdClick("delete");
		XpathClick("//span[@class='btn btn-success font14 w-100 p-3']");
		}
		else
		{
			String empty=getText("//div[@class='text-center']/h2");
			
			if (empty.equals("Address not added. Please add new one"))
			{
				WebElement address = elementCreateXpath("//div[@class='col-12 col-md text-md-end']/button");
				if(address.isDisplayed()) 
				{
					XpathClick("//div[@class='col-12 col-md text-md-end']/button");
					System.out.println("Tc-17-Add new address is successfull");
					//Enter the address details
					IdSendKeys("doorNo", "No.10");
					IdSendKeys("landmark", "Dr.VSI Estate,Thiruvanmiyur");

					WebElement Residency=driver.findElement(By.id("addressType"));
					Select s1=new Select(Residency);
					s1.selectByVisibleText("Others");
					IdSendKeys("phone", "8712400440");
					IdClick("closeAddressModal");
					System.out.println("Tc-18-New address is added successfull");
					
					//Capturing the address details 
					String add=getText("//div[@id='manage-addr-grid']/div");
					System.out.println("Address we added is "+add);
					System.out.println();
					System.out.println("Tc-19-Capturing New address details is successfull");
					
					//Updating the address details
					actionXpathClick("//div[@class='col text-end']/small/snap[1]");
					idClear("phone");
					IdSendKeys("phone", "8712400000");
					IdClick("closeAddressModal");
					System.out.println("Tc-20-Updating the address details is successfull");
					
					//Capturing the updated address details 
					String add1=getText("//p[@class='card-text mb-2']");
					System.out.println("The Updated address is "+add1);
					System.out.println("Tc-21-Capturing the new address details is successfull");
					Thread.sleep(8000);

					WebElement address1=elementCreateXpath("//div[@class='col-12 col-md text-md-end']/button");
					if(address1.isDisplayed()) 
					{
						XpathClick("//div[@class='col-12 col-md text-md-end']/button");
					}

					//Entering the another address details
					IdSendKeys("doorNo","No.121");
					IdSendKeys("landmark","Phase II,Thiruvanmiyur");
					WebElement Residency1=driver.findElement(By.id("addressType"));
					Select s2=new Select(Residency1);
					s2.selectByVisibleText("Apartments");
					IdSendKeys("phone","8220776699");
					IdClick("closeAddressModal");
					System.out.println("Tc-22-Again adding the new address is successfull");

					//deleting the address
					actionXpathClick("//div[contains(@id,'manage-addr-grid')]/div[2]/div/div/div[@class='card-footer text-end']/div/div[@class='col text-end']/small/snap[2]");
					IdClick("alert-onFailure");
					actionXpathClick("//div[contains(@id,'manage-addr-grid')]/div[2]/div/div/div[@class='card-footer text-end']/div/div[@class='col text-end']/small/snap[2]");
					IdClick("alert-onSuccess");
					System.out.println("Tc-23-Deleting the new address is successfull");
				}
				else System.out.println("Add New Address button is not Displayed");
			}	
		}
		
		/*
		//Manage Payments
		System.out.println("Tc-24-Manage payment click is successfull");
		XpathClick("//div[@id='account-nav']/ul/li[5]");
		System.out.println("Tc-25-Add new card click is successfull");
		WebElement addcard=elementCreateId("addNewCard");
		if(addcard.isDisplayed())
		{
			addcard.click();

			Thread.sleep(8000);
			//Adding card details
			driver.switchTo().frame("payment_iframe_id");
			Thread.sleep(5000);
			Select card=new Select(driver.findElement(By.xpath("//ul[contains(@class,'payments')]//select[@id='CARDTYPE']")));
			card.selectByIndex(3);
			XpathSendkey("//ul[contains(@class,'payments')]//input[contains(@name,'CARDNUMBER')]", "5000330000000000");
			XpathSendkey("//ul[contains(@class,'payments')]//input[contains(@name,'CVV')]", "123");
			Select month=new Select(driver.findElement(By.xpath("//ul[contains(@class,'payments')]//select[@name='CCMONTH']")));
			month.selectByVisibleText("07-Jul");
			Select year=new Select(driver.findElement(By.xpath("//ul[contains(@class,'payments')]//select[@name='CCYEAR']")));
			year.selectByVisibleText("2030");
			driver.findElement(By.name("CARDHOLDERNAME")).sendKeys("Kamal");	
			driver.findElement(By.name("EMAIL")).sendKeys("");
			scrollDown(400);
			XpathClick("//button[@name='Submit']");
			Thread.sleep(5000);
			System.out.println("Tc-26-Card Details entered successfull");

		}
		else System.out.println("Add card button is not displayed");
		*/
	}
	@When("Checking the Rewards")
	public void checking_the_rewards() {
		XpathClick("//div[@id='account-nav']/ul/li[6]");
		System.out.println("Tc-24-Rewards click is successfull");
		System.out.println();
		List<WebElement>Pointsdetail=driver.findElements(By.xpath("//p[contains(@class,'text-secondary')]"));
		for(WebElement point:Pointsdetail) 
		{
			String text=point.getText();
			System.out.println(text);
		}
		System.out.println();
		System.out.println("Tc-25-Recent reward transaction capturing is successfull");
		System.out.println();
		String Currentrewardpt=getText("//h3[@class='font42 fw-bold mb-4']");
		System.out.println("Current Reward point is "+Currentrewardpt);
		String Remainingpoint=getText("//div[@class='bg-ltcream p-4 rounded-0 text-center mb-5']");
		System.out.println(Remainingpoint);
		System.out.println("Tc-26-Remaining point to reach next reward capturing is successfull");
		System.out.println();
	}
	@When("Checking the Help")
	public void checking_the_help() throws InterruptedException {
		System.out.println("Tc-26-Help click is sucessfull");
		XpathClick("//div[@id='account-nav']/ul/li[7]");
		List<WebElement>help=driver.findElements(By.className("accordion-item"));
		for(WebElement helpclick:help) {
			helpclick.click();
			Set<String>windId=driver.getWindowHandles();
			List<String>singlewind=new ArrayList(windId);
			String parentwindname=singlewind.get(0);
			String windname=singlewind.get(1);
			System.out.println(windname);
			driver.switchTo().window(windname);
			Thread.sleep(4000);
			System.out.println("Title of the Page is-->"+driver.getTitle());
			driver.close();
			driver.switchTo().window(parentwindname);
		}
		System.out.println("Tc-27-Help detail data is captured sucessfull");
		System.out.println();
	}
	@When("Checking the Contact")
	public void checking_the_contact() {
		xpathJavaScriptScrollIntoViewClick("//div[@id='account-nav']/ul/li[8]");
		System.out.println("Tc-28-contact click is sucessfull");
		List<WebElement>contact=driver.findElements(By.className("accordion-item"));
		for(WebElement ele:contact) {
			String function=ele.getText();
			System.out.println("The Contact screen contains the details-->"+function);
		}
		System.out.println("Tc-29-Contact detail data is captured sucessfull");
		System.out.println();
	}
	@When("Checking the Legal Information")
	public void checking_the_legal_information() throws InterruptedException {
		System.out.println("Tc-30-Legal information is sucessfull");
		scrollDown(600);
		Thread.sleep(10000);
		XpathClick("//li[@class='text-link' and @id='LegalInfo']");
		Thread.sleep(8000);
		List<WebElement>legal=driver.findElements(By.xpath("//h2[@id='shop-heading']"));
		for(WebElement ele:legal) {
			String function=ele.getText();
			System.out.println("The Legal information details-->"+function);
		}
		System.out.println("Tc-31-Legal information data is captured sucessfull");
		System.out.println();	}
	@When("Checking the About")
	public void checking_the_about() throws InterruptedException {
		System.out.println("Tc-32-About is sucessfull");
		scrollDown(600);
		Thread.sleep(8000);
		XpathClick("//div[@id='account-nav']/ul/li[10]");
		String details=getText("//h4[@class='text-center']");
		System.out.println("The About details contains-->"+details);
	}
	@When("Checking the About details in Footer")
	public void Checking_the_About_details_in_Footer() throws InterruptedException {
	scrollDown(900);
	XpathClick("//ul[contains(@class,'d-flex justify-content-center')]//li[1]");
	System.out.println("Tc-33-About is sucessfull");
	}
	/*
	//Feedback
	scrollDown(900);
	IdClick("openFeedBack");
	Select feed=new Select(driver.findElement(By.xpath("//select[@id='feedBackType']")));
	feed.selectByValue("1");
	XpathSendkey("//textarea[@id='feedBack']", "This feature is being tested");
	XpathClick("//div[@class='text-center pt-4 mb-5']//button");
	System.out.println("Feedback one is given sucessfull");
	Thread.sleep(2000);
	
	//Feedback one
	IdClick("openFeedBack");
	Select feed1=new Select(driver.findElement(By.xpath("//select[@id='feedBackType']")));
	feed1.selectByValue("2");
	XpathSendkey("//textarea[@id='feedBack']", "This feature is being tested");
	XpathClick("//div[@class='text-center pt-4 mb-5']//button");
	System.out.println("Feedback two is given sucessfull");
	Thread.sleep(2000);
	
	//Feedback two
	IdClick("openFeedBack");
	Select feed2=new Select(driver.findElement(By.xpath("//select[@id='feedBackType']")));
	feed2.selectByValue("3");
	XpathSendkey("//textarea[@id='feedBack']", "This feature is being tested");
	XpathClick("//div[@class='text-center pt-4 mb-5']//button");
	System.out.println("Feedback three is given sucessfull");
	*/

	
	@When("Checking the customer care")
	public void Checking_the_customer_care() throws InterruptedException {
	IdClick("FeedBack");
	Set<String>secondwind=driver.getWindowHandles();
	List<String>wind=new ArrayList(secondwind);
	String curwind=wind.get(0);
	String carewind=wind.get(1);
	System.out.println("The id of the currenet window :"+curwind);
	System.out.println("The id of the child window :"+carewind);
	driver.switchTo().window(carewind);
	Thread.sleep(4000);
	System.out.println("The Title of this page is : "+driver.getTitle());
	driver.close();
	driver.switchTo().window(curwind);	}
	
	@Then("Checking the Logout")
	public void checking_the_logout() {
		XpathClick("//div[@id='account-nav']/ul/li[11]");
		System.out.println("Tc--Logout Click is sucessfull");
		IdClick("alert-onFailure");
		System.out.println("Logout is canceled");
		XpathClick("//div[@id='account-nav']/ul/li[11]");
		IdClick("alert-onSuccess");
		System.out.println("Tc-34-Logged out is sucessfull");
		}
}
