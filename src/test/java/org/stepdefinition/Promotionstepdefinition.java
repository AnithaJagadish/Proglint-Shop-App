package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;
import io.cucumber.java.en.*;

public class Promotionstepdefinition extends Baseclass{
	@Given("Navigating to Promotions screen")
	public void navigating_to_promotions_screen() throws Exception {
		idJavaScriptScrollIntoViewClick("Promotions");
		TakeScreenShots("Promotions screen");
	}
	@When("Verify the combo offer add and edit option")
	public void veriy_the_combo_offer_add_and_edit_option() throws Exception {
		//Click view button in combo offer
		XpathClick("//div[@id='all-offers']/div[1]/div[2]/a");
		Thread.sleep(2000);
		//Click Addnew button
		IdClick("addcombooffer");
		//Close the pop-up
		XpathClick("//div[@class='modal-content rounded-0']/img");
		//Click Addnew button
		IdClick("addcombooffer");
		//Close the pop-up
		IdClick("onClose");
		//Click Addnew button and adding the new Combo offer
		IdClick("addcombooffer");
		System.out.println("We are Creating the "+getText("//h5"));
		Select s=new Select(driver.findElement(By.id("category")));
		s.selectByVisibleText("Grocery");
		System.out.println("Product Type selected--->Test case passed");
		XpathClick("//input[@placeholder='Valid From']");
		XpathClick("//div[@role='button' and @tabindex='0']");
		System.out.println("From date selected---> Test case passed");
		/*
		xpathJavaScriptScrollIntoViewClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid From']");
		WebElement combotime=driver.findElement(By.name("time-input"));
		combotime.sendKeys("1");
		combotime.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		combotime.sendKeys("25");
		combotime.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		combotime.sendKeys("AM");
		Thread.sleep(4000);
		*/
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-16]");
		System.out.println("To date selected---> Test case passed");
		/*
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		WebElement combotime1=driver.findElement(By.name("time-input"));
		combotime1.sendKeys("12");
		combotime1.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		combotime1.sendKeys("25");
		combotime1.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		combotime1.sendKeys("PM");
		*/
		Thread.sleep(4000);
		IdSendKeys("OffePrice", "1");
		WebElement prds=elementCreateXpath("//div[contains(@class,' css-1hwfws3')]//input[@type='text']");
		prds.sendKeys("Parle-G");
		prds.sendKeys(Keys.TAB);
		prds.sendKeys("kurkure-");
		prds.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		TakeScreenShots("Combo offer creation screen");
		//IdClick("createNew");
		idJavaScriptScrollIntoViewClick("onClose");
		
		//Capturing The First Combo Offer Details in the Table  
		System.out.println("The First Combo Offer Details in the Table ");
		for(int i=1;i<=5;i++) 
		{
		String ofrdtls=getText("//*[@id=\"all-offers\"]/div[1]/table/thead/tr/th["+i+"]");
		System.out.print(ofrdtls+"\t");
		}
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			String comboofr=getText("//*[@id=\"all-offers\"]/div[1]/table/tbody/tr[1]/td["+i+"]");
			System.out.print(comboofr+"\t");
		}
		System.out.println();
		System.out.println("------------------");
		XpathClick("//tbody/tr[1]/td[6]/div[@class='col-auto'][1]");
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-content rounded-0']/img");
		XpathClick("//tbody/tr[1]/td[6]/div[@class='col-auto'][1]");
		System.out.println(getText("//*[@id=\"unblock-modal\"]/div/div/div[2]"));
		IdClick("onClose");
		XpathClick("//tbody/tr[1]/td[6]/div[@class='col-auto'][2]");
		IdClick("modalClose");
		XpathClick("//tbody/tr[1]/td[6]/div[@class='col-auto'][2]");
		idClear("OffePrice");
		IdSendKeys("OffePrice", "2");
		TakeScreenShots("Combo offer edit screen");
		IdClick("createNew");
		//IdClick("onClose");
		Thread.sleep(5000);
        idJavaScriptScrollIntoViewClick("Promotions")	;
        Thread.sleep(5000);
	}
	@When("Verify the multibuy offer add and edit option")
	public void veriy_the_multibuy_offer_add_and_edit_option() throws Exception {
		XpathClick("//div[@id='all-offers']/div[2]/div[2]/a");
		Thread.sleep(5000);
		idJavaScriptScrollIntoViewClick("modalClick");
		Select s1=new Select(driver.findElement(By.id("category")));
		s1.selectByVisibleText("Grocery");
		Select s2=new Select(driver.findElement(By.id("offer-type")));
		s2.selectByVisibleText("DOLLAR");
		IdSendKeys("Offer", "2");
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid From']");
		XpathClick("//div[@role='button' and @tabindex='0']");
		System.out.println("From date selected---> Test case passed");
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-16]");
		System.out.println("To date selected---> Test case passed");
		IdSendKeys("number", "3");
		/*
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		Thread.sleep(3000);
		WebElement multitime=driver.findElement(By.name("time-input"));
		multitime.sendKeys("11");
		multitime.sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(3000);
		multitime.sendKeys("59");
		multitime.sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(3000);
		multitime.sendKeys("PM");
		multitime.sendKeys(Keys.ARROW_LEFT);
		Thread.sleep(4000);
		*/
		WebElement multi=elementCreateXpath("//div[contains(@class,' css-1hwfws3')]//input[@type='text']");
		multi.sendKeys("Lay's Max");
		multi.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		TakeScreenShots("Multibuy offer creation screen");
		//IdClick("manageClick");
		idJavaScriptScrollIntoViewClick("openClick");
		//Edit and view the multibuy offers
		System.out.println("The First Multibuy Offer Details in the Table ");
		for(int i=1;i<=5;i++) 
		{
		String ofrdtls=getText("//*[@id=\"all-offers\"]/div[1]/table/thead/tr/th["+i+"]");
		System.out.print(ofrdtls+"\t");
		}
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			String comboofr=getText("//*[@id=\"all-offers\"]/div[1]/table/tbody/tr[1]/td["+i+"]");
			System.out.print(comboofr+"\t");
		}
		System.out.println();
		System.out.println("------------------");
		
		
		IdClick("EditMul");
		idClear("Offer");
		IdSendKeys("Offer", "2");
		idClear("number");
		IdSendKeys("number", "2");
		TakeScreenShots("Multibuy offer edit screen");
		IdClick("manageClick");
		System.out.println("Multibuy promotions edit was successfull");
		//IdClick("onClose");
		Thread.sleep(5000);
        idJavaScriptScrollIntoViewClick("Promotions")	;
        Thread.sleep(5000);
	}
	@When("Verify the Free item offer add and edit option")
	public void veriy_the_free_item_offer_add_and_edit_option() throws Exception {
		XpathClick("(//a[@id='viewPro'])[3]");
        idJavaScriptScrollIntoViewClick("addFreeItem");
        Select s3=new Select(driver.findElement(By.id("category")));
		s3.selectByVisibleText("Grocery");
		
		WebElement multi1=elementCreateXpath("//div[contains(@class,' css-1hwfws3')]//input[@type='text']");
		multi1.sendKeys("Lay's Max");
		multi1.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid From']");
		XpathClick("//div[@role='button' and @tabindex='0']");
		System.out.println("From date selected---> Test case passed");
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-16]");
		System.out.println("To date selected---> Test case passed");
		
		WebElement multi2=elementCreateXpath("(//div[contains(@class,' css-1hwfws3')]//input[@type='text'])[2]");
		multi2.sendKeys("Parle-G");
		multi2.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		TakeScreenShots("Freeitem creation screen");
		//idJavaScriptScrollIntoViewClick("onCreateFree");
		idJavaScriptScrollIntoViewClick("onCloseonFreeItems");
		
		
		//Editing Freeitem offer
		System.out.println("The First Freeitem Offer Details in the Table ");
		for(int i=1;i<=5;i++) 
		{
		String ofrdtls=getText("//*[@id=\"all-offers\"]/div[1]/table/thead/tr/th["+i+"]");
		System.out.print(ofrdtls+"\t");
		}
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			String comboofr=getText("//*[@id=\"all-offers\"]/div[1]/table/tbody/tr[1]/td["+i+"]");
			System.out.print(comboofr+"\t");
		}
		System.out.println();
		System.out.println("------------------");
		
		Thread.sleep(5000);
		IdClick("editFreeItem");
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-17]");
		System.out.println("Freeitem offer edit was successfull");
		TakeScreenShots("Freeitem edit screen");
		IdClick("onClose");
		Thread.sleep(5000);
       idJavaScriptScrollIntoViewClick("Promotions")	;
       Thread.sleep(5000);
	}
	@When("Verify the Dollar off offer add and edit option")
	public void veriy_the_dollar_off_offer_add_and_edit_option() throws Exception {
		 XpathClick("(//a[@id='viewPro'])[4]");
         idJavaScriptScrollIntoViewClick("OpenDollarModal");
         Select s4=new Select(driver.findElement(By.id("offer-type")));
			s4.selectByVisibleText("DOLLAR");
         IdSendKeys("setDiscount", "1");
         IdSendKeys("setCartGrossValue", "3");
         XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid From']");
			XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-17]");
			System.out.println("From date selected---> Test case passed");
			Thread.sleep(3000);
			XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
			XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-16]");
			System.out.println("To date selected---> Test case passed");
			TakeScreenShots("dollar off creation screen");
			//idJavaScriptScrollIntoViewClick("manageProduct");
			idJavaScriptScrollIntoViewClick("Cancel");
			
			//Editing the dollar offer
			System.out.println("The First dollar Offer Details in the Table ");
			for(int i=1;i<=5;i++) 
			{
			String ofrdtls=getText("//*[@id=\"all-offers\"]/div[1]/table/thead/tr/th["+i+"]");
			System.out.print(ofrdtls+"\t");
			}
			System.out.println();
			for(int i=1;i<=5;i++)
			{
				String comboofr=getText("//*[@id=\"all-offers\"]/div[1]/table/tbody/tr[1]/td["+i+"]");
				System.out.print(comboofr+"\t");
			}
			System.out.println();
			System.out.println("------------------");
			
			Thread.sleep(5000);
			IdClick("EditDollarModal");
			idClear("setDiscount");
			IdSendKeys("setDiscount", "1");
			Thread.sleep(5000);
			TakeScreenShots("dollar off edit screen");
			idJavaScriptScrollIntoViewClick("manageProduct");
			System.out.println("dollar offer edit was successfull");
			Thread.sleep(5000);
         idJavaScriptScrollIntoViewClick("Promotions")	;
         Thread.sleep(5000);
			
	}
	@When("Verify the Happy hours offer add and edit option")
	public void veriy_the_happy_hours_offer_add_and_edit_option() throws Exception {
		//Adding the happy hours offer
		XpathClick("(//a[@id='viewPro'])[5]");
        idJavaScriptScrollIntoViewClick("addNew");
        Thread.sleep(5000);
        Select s5=new Select(driver.findElement(By.id("setProductType")));
			s5.selectByVisibleText("Grocery");
			WebElement multi3=elementCreateXpath("(//div[contains(@class,' css-1hwfws3')]//input[@type='text'])[1]");
		multi3.sendKeys("Anil Finger Millet Vermicelli");
		multi3.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		Select s6=new Select(driver.findElement(By.id("setOfferType")));
		s6.selectByVisibleText("DOLLAR");
		IdSendKeys("Offer", "1");
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid From']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-16]");
		System.out.println("From date selected---> Test case passed");
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-15]");
		System.out.println("To date selected---> Test case passed");
		Select s7=new Select(driver.findElement(By.id("hour-start")));
			s7.selectByVisibleText("01:00 AM");
			Select s8=new Select(driver.findElement(By.id("hour-stop")));
			s8.selectByVisibleText("02:00 AM");
			TakeScreenShots("Happy hours offer creation screen");
			//idJavaScriptScrollIntoViewClick("manageClick");
			idJavaScriptScrollIntoViewClick("manageModal");
			
			//Editing the happyhours offer
		System.out.println("The First happyhours Offer Details in the Table ");
		for(int i=1;i<=5;i++) 
		{
		String ofrdtls=getText("//*[@id=\"all-offers\"]/div[1]/table/thead/tr/th["+i+"]");
		System.out.print(ofrdtls+"\t");
		}
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			String comboofr=getText("//*[@id=\"all-offers\"]/div[1]/table/tbody/tr[1]/td["+i+"]");
			System.out.print(comboofr+"\t");
		}
		System.out.println();
		System.out.println("------------------");
		
		Thread.sleep(5000);
		IdClick("editHappyHours");
		idClear("Offer");
		IdSendKeys("Offer", "0.5");
		TakeScreenShots("Happy hours offer edit screen");
		idJavaScriptScrollIntoViewClick("manageClick");
		System.out.println("Happyhours offer edit was successfull");
		Thread.sleep(5000);
        idJavaScriptScrollIntoViewClick("Promotions")	;
        Thread.sleep(5000);
	}
	@Then("Verify the customer coupon offer add and edit option")
	public void veriy_the_customer_coupon_offer_add_and_edit_option() throws Exception {
		XpathClick("(//a[@id='viewPro'])[6]");
        idJavaScriptScrollIntoViewClick("OpenCreateModal");
        Thread.sleep(5000);
        Select s9=new Select(driver.findElement(By.id("offer-type")));
		s9.selectByVisibleText("DOLLAR");
		IdSendKeys("setCouponValue", "1");
		IdSendKeys("coupon-code2", "AUTOMATION");
		IdSendKeys("coupon-code", "AUTOMATION Testing");
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid From']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-16]");
		System.out.println("From date selected---> Test case passed");
		Thread.sleep(3000);
		XpathClick("//div[@class='modal-body font13 p-40']//input[@placeholder='Valid To']");
		XpathClick("(//div[@role='button' and @tabindex='-1'])[last()-15]");
		System.out.println("To date selected---> Test case passed");
		TakeScreenShots("customer coupon offer creation screen");
		//idJavaScriptScrollIntoViewClick("CreateOrUpdate");
		idJavaScriptScrollIntoViewClick("Cancel");
		
		//Editing the Customer coupons offer
		System.out.println("The First Customer coupons Offer Details in the Table ");
		for(int i=1;i<=5;i++) 
		{
		String ofrdtls=getText("//*[@id=\"all-offers\"]/div[1]/table/thead/tr/th["+i+"]");
		System.out.print(ofrdtls+"\t");
		}
		System.out.println();
		for(int i=1;i<=5;i++)
		{
			String comboofr=getText("//*[@id=\"all-offers\"]/div[1]/table/tbody/tr[1]/td["+i+"]");
			System.out.print(comboofr+"\t");
		}
		System.out.println();
		System.out.println("------------------");
		
		Thread.sleep(5000);
		IdClick("OpenEditModal");
		idClear("setCouponValue");
		IdSendKeys("setCouponValue", "0.5");
		TakeScreenShots("Customer coupon offer edit screen");
		idJavaScriptScrollIntoViewClick("CreateOrUpdate");
		System.out.println("Customer coupons offer edit was successfull");
		Thread.sleep(5000);
        idJavaScriptScrollIntoViewClick("Promotions")	;
        Thread.sleep(5000);
	}



}
