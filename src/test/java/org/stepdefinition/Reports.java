package org.stepdefinition;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.utilites.Baseclass;
import io.cucumber.java.en.*;

public class Reports extends Baseclass{

	@When("click on the Reports tab")
	public void click_on_the_reports_tab() throws Exception {
		idJavaScriptScrollIntoViewClick("reports");
	    TakeScreenShots("Reports screen");
	    Thread.sleep(3000);
	}
	@When("checking the Reports title is present on the screen")
	public void checking_the_reports_title_is_present_on_the_screen() throws InterruptedException {
		String Tittleofthepage ="Reports";
	    String ActualTittleofthepage = getText("//h1[@class='font20 fw-bold']");
	    Thread.sleep(3000);
	    if(Tittleofthepage.equals(ActualTittleofthepage))
	    {
	    	System.out.println("Tittle of the screen: Reports");	
	    }
	    else
	    {
	    	System.out.println("Incorrect tittle");
	    }
	}
	@When("click on the Download report button to check the validation")
	public void click_on_the_download_report_button_to_check_the_validation() throws Exception {
		IdClick("onSubmitReport");
	    TakeScreenShots("WithoutChoosedTheDataForReport");
	    String validationerrormessage = getText("//span[text()='Please choose from date']");
		String Actualvalidationerrormessage ="Please choose from date";
	    Thread.sleep(3000);
	    if(validationerrormessage.equals(Actualvalidationerrormessage))
	    {
	    	System.out.println("Validation error message is correct");	
	    }
	    else
	    {
	    	System.out.println("Validation error message is incorrect");
	    }
	}
	@When("Checking the From input field and Choosing the current date")
	public void checking_the_from_input_field_and_choosing_the_current_date() throws InterruptedException {
		XpathClick("//input[@placeholder='From']");
	    Thread.sleep(2000);
	    XpathClick("(//div[@tabindex='0'])[last()-1]");
	}
	@When("Checking the To input field and Choosing the current date")
	public void checking_the_to_input_field_and_choosing_the_current_date() throws InterruptedException {
		XpathClick("//input[@placeholder='To']");
	    Thread.sleep(2000);
	    XpathClick("(//div[@tabindex='0'])[last()-1]");
	    Thread.sleep(2000);
	}
	@When("selecting the report type")
	public void selecting_the_report_type() throws InterruptedException {
		Actions act=new Actions(driver);
		WebElement strselect=driver.findElement(By.id("reportType"));
		act.moveToElement(strselect).sendKeys("Comp").build().perform();
		strselect.sendKeys(Keys.ENTER);
		Thread.sleep(2000);	
		driver.findElement(By.xpath("//option[@value='DAILY_SALES_REPORT']")).click();	
		Thread.sleep(2000);
	}
	@When("clicking the view report button")
	public void clicking_the_view_report_button() throws InterruptedException {
		IdClick("viewSubmitReport");
		Thread.sleep(4000); 
	}
	@When("clicking on the download button to download the report")
	public void clicking_on_the_download_button_to_download_the_report() throws Exception {
		IdClick("onSendEmail");
		System.out.println("Report has been downloaded");
		TakeScreenShots("ChoosedDateForReport");
	}
	@Then("Checking the clear button functionality")
	public void checking_the_clear_button_functionality() throws Exception {
		IdClick("clear");
		TakeScreenShots("ClearedTheDate");
		Thread.sleep(4000); 
	}
}
