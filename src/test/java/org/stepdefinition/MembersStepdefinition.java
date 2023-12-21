package org.stepdefinition;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class MembersStepdefinition extends Baseclass{
	@When("Navigate to Members screen")
	public void navigate_to_members_screen() throws InterruptedException {
		
        scrollDown(1000);
        
		Thread.sleep(5000);
		idJavaScriptScrollIntoViewClick("Branches");
		
		Thread.sleep(7000);
	}
	@When("Adding the new members")
	public void adding_the_new_members() throws InterruptedException {
		xpathJavaScriptScrollIntoViewClick("//button[@class='btn btn-dark']");
		Thread.sleep(2000);
        IdSendKeys("onInput", "Automation");
        Thread.sleep(2000);
        XpathSendkey("//input[@placeholder='Enter Your Last Name']", "Testing");
        for (int i = 1; i <= 15; i++) {
            String email = "testaproglint" + i + "@gmail.com";
            IdSendKeys("emailId", email);
        }
        IdSendKeys("password", "Proglint@1");
        for (int j = 1; j <= 15; j++) {
            String Employeeid = "Test" + j + "2";
            IdSendKeys("Employee", Employeeid);
        }
        
        Thread.sleep(1000);
	    idJavaScriptScrollIntoViewClick("role-id");
	    WebElement no9=elementCreateXpath("//select[@class='form-select']");
		Select s9= new Select(no9);
		s9.selectByValue("11");
		Thread.sleep(3000); 
		XpathClick("//div[@class=' css-1hwfws3']");
		Thread.sleep(3000); 
		//String sss = getText("//div[text()='branch']");
		//System.out.println(sss);
		xpathJavaScriptScrollIntoViewClick("//div[text()='branch']");
		Thread.sleep(3000); 
		idJavaScriptScrollIntoViewClick("manageClick");
		Thread.sleep(3000); 
	}
	@When("Checking the pagination on Members screen")
	public void checking_the_pagination_on_members_screen() throws InterruptedException {
		scrollDown(300);
		xpathJavaScriptScrollIntoViewClick("//a[@aria-label='Go to last page']");  //Checked the pagination 
		Thread.sleep(3000); 
	}
	@Then("Checking the view,edit,search employee functionality")
	public void checking_the_view_edit_search_employee_functionality() throws InterruptedException {
xpathJavaScriptScrollIntoViewClick("(//button[@id='openMultibuy'])[1]");  //View button
		
		String Employeeno = getText("(//div[@class='col-8'])[2]");   //getting the employee number
		
		idJavaScriptScrollIntoViewClick("onClose");  // close the view pop up
		Thread.sleep(3000); 
		idJavaScriptScrollIntoViewClick("EditMul");  //click on the edit option and updating the value
		Thread.sleep(3000);
		IdSendKeys("Employee", "1234567");
		idJavaScriptScrollIntoViewClick("manageClick");
		
		Thread.sleep(3000);
		IdSendKeys("searchOrder", Employeeno); //search the valid employee details
		Thread.sleep(3000);
		IdClick("switch");
		Thread.sleep(3000);
		IdClick("switch");
		Thread.sleep(2000);
		idClear("searchOrder");
		Thread.sleep(3000);
		IdSendKeys("searchOrder", "itrtirt95"); //search the invalid employee details
		Thread.sleep(3000);
		idClear("searchOrder");
		Thread.sleep(3000);

}
}
