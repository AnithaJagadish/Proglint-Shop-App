package org.stepdefinition;

import java.sql.Time;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.utilites.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ALoginAndForgotPasswordStepdefinition extends Baseclass{
	String username;
	String email;
	
	@When("passing the valid and invalid username {string}")
	public void passing_the_valid_and_invalid_username(String string) {
		XpathSendkey("//input[@class='form-control']", string);
		
	}
	@When("passing the empty password {string}")
	public void passing_the_empty_password(String string) {
		IdSendKeys("setPassword", string);
	}
	/*@When("passing the valid and invalid username")
	public void passing_the_valid_and_invalid_username() {
		XpathSendkey("//input[@class='form-control']", "support@proglint.com");
		
	}
	@When("passing the empty password")
	public void passing_the_empty_password() {
		IdSendKeys("setPassword", "");
	}*/
	
	@When("click on the login button")
	public void click_on_the_login_button() throws Exception {
		 username=getAttribute("//input[@class='form-control']","value");
		IdClick("onLoginClick");		
		Thread.sleep(2000);
	}
	@When("check the error message")
	public void check_the_error_message() throws Exception {
		WebElement alertMessage1 = elementCreateXpath("//div[@class='alert alert-danger']");	
        String alertMessage11 = alertMessage1.getText();
        TakeScreenShots("Screenshots for " + username);
		String EmptyPWErrMsg = "Please enter password.";
		 if (alertMessage11.equals(EmptyPWErrMsg))
			{
		         System.out.println("Diaplyed correct error message when entering empty password");
			}
			else
			{
				System.out.println("Diaplyed incorrect error message when entering empty password");
			}
		 xpathClear("//input[@class='form-control']");
		idClear("setPassword");
		Thread.sleep(1000);
	}
	@Then("refresh the page")
	public void refresh_the_page() {
		refreshTab();
	}
	@When("passing the empty username")
	public void passing_the_empty_username() {
		XpathSendkey("//input[@class='form-control']", "");
	}
	@When("passing the valid password")
	public void passing_the_valid_password() {
		IdSendKeys("setPassword", "Proglint@1");
	}
	@When("check the error message empty username and valid password")
	public void check_the_error_message_empty_username_and_valid_password() throws Exception {
		TakeScreenShots("Emptyusernamevailspass");
		WebElement alertMessage2 = elementCreateXpath("//div[@class='alert alert-danger']");	
        String alertMessage22 = alertMessage2.getText();
		String EmptyemailErrMsg = "Please enter Email Id.";
		 if (alertMessage22.equals(EmptyemailErrMsg))
			{
		         System.out.println("Diaplyed correct error message when entering empty email ID");
			}
			else
			{
				System.out.println("Diaplyed incorrect error message when entering empty email ID");
			}
		xpathClear("//input[@class='form-control']");
		idClear("setPassword");
		Thread.sleep(1000);
	}
	@When("passing the valid username")
	public void passing_the_valid_username() {
		XpathSendkey("//input[@class='form-control']", "support@proglint.com");
	}
	@When("passing the invalid password")
	public void passing_the_invalid_password() throws InterruptedException {
		IdSendKeys("setPassword", "Proglint@11");
		Thread.sleep(2000);
	}
	@When("check the error message for valid username and invalid password")
	public void check_the_error_message_for_valid_username_and_invalid_password() throws Exception {
		TakeScreenShots("validusernameinvailspass");
		WebElement alertMessage3 = elementCreateXpath("//div[@class='alert alert-danger']");		
	     String alertMessage33 = alertMessage3.getText();
        String expectedMessage1 = "User Name and password you entered does not match!You have 1 chances left";
        String expectedMessage2 = "User Name and password you entered does not match!You have 2 chances left";
        String expectedMessage3 = "User Name and password you entered does not match!You have 3 chances left";
        String expectedMessage4 ="You've reached the maximum login verify attempts,";
        if (alertMessage33.equalsIgnoreCase(expectedMessage1)||alertMessage33.equalsIgnoreCase(expectedMessage2)||alertMessage33.equalsIgnoreCase(expectedMessage3) ) {
            System.out.println("Displayed correct error message when entering incorrect email ID and PW");
        } else {
       	 if(alertMessage33.contains(expectedMessage4))
            {
                System.out.println("User ID blocked");
            }
       	 else
       	 {
            System.out.println("Displayed incorrect error message when entering incorrect email ID and PW");
        }}
       xpathClear("//input[@class='form-control']");
		idClear("setPassword");
    Thread.sleep(1000);}
    
	@Given("Lanuch the correct url")
	public void lanuch_the_correct_url() throws Exception {
		launchUrl("https://shop-admin.proglint.com/dashboard", driver); 
		System.out.println("Lanuch the correct url");
		TakeScreenShots("launchUrl");
		
	}
	@When("Print the tittle of the page")
	public void print_the_tittle_of_the_page() throws Exception {
		printTitle();
	}
	
	@When("Checking Forgot password button active or not")
	public void checking_forgot_password_button_active_or_not() {
		boolean a = elementIsClickableId("OpenForget");
		if (a == true)
		{
	         System.out.println("Forgot password button is clickable : Yes");
		}
		else
		{
			System.out.println("Forgot password button is clickable : No");
		}
	    	}
	@When("click on the forgot password button")
	public void click_on_the_forgot_password_button() throws InterruptedException {
		
		IdClick("OpenForget");
		/*Thread.sleep(2000);
		XpathClick(("//strong[text()='Back to login']"));*/
	}
	/*@When("passing empty email address")
	public void passing_empty_email_address() {
		IdSendKeys("email", "");
		String s=getText("//p[@style='color: red;']");
		String ActalErrMsg1 = "Please enter Email Id.";
		 if (s.equals(ActalErrMsg1))
			{
		         System.out.println("Diaplyed correct error message when entering invalid email(alphabets only)");
			}
			else
			{
				System.out.println("Diaplyed incorrect error message when entering invalid email(alphabets only)");
			}
			idClear("email");	
		
	    	}*/
	@When("Passing invalid email address {string}")
	public void passing_invalid_email_address(String string) throws Exception {
		//IdClick("OpenForget");
	IdSendKeys("email", string);
	email = getAttributeid("email", "value");
    System.out.println(email);
    TakeScreenShots("screenshots for " + email);

		 String s=getText("//p[@style='color: red;']");		 
		 String ActalErrMsg = "Please enter valid Email Id.";
		 	 if (s.equals(ActalErrMsg))
			{
		         System.out.println("Diaplyed correct error message when entering invalid email(alphabets only)");
			}
			else
			{
				System.out.println("Diaplyed incorrect error message when entering invalid email(alphabets only)");
			}
			idClear("email");
			}
	@When("enter the correct email {string}")
	public void enter_the_correct_email(String string) throws Exception {
		IdSendKeys("email", string);
		TakeScreenShots("validemailaddress");
	    	}

/*
	@When("Passing the invalid email address")
	public void passing_the_invalid_email_address() throws Exception {
		IdSendKeys("email", "Anitha");
		 String s=getText("//p[@style='color: red;']");
		 TakeScreenShots("email");
		 String ActalErrMsg = "Please enter valid Email Id.";
		 if (s.equals(ActalErrMsg))
			{
		         System.out.println("Diaplyed correct error message when entering invalid email(alphabets only)");
			}
			else
			{
				System.out.println("Diaplyed incorrect error message when entering invalid email(alphabets only)");
			}
			idClear("email");
	   }
	@When("enter the correct email")
	public void enter_the_correct_email(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	    List<Map<String, String>> asMaps = dataTable.asMaps();
	    IdSendKeys("email", asMaps.get(1).get("email"));
		//Thread.sleep(2000);
		 System.out.println("Entered the correct email");
	}
*/
	@Then("click on the sumbit button")
	public void click_on_the_sumbit_button() throws InterruptedException {
		
		Thread.sleep(2000);
		XpathClick("//button[text()='SEND OTP']");
				 System.out.println("click on the sumbit button");
	}
	@When("enter the invaild otp")
	public void enter_the_invaild_otp() throws Exception {
		IdSendKeys("otp","12345");
		boolean test1 = elementIsClickableXpath("//button[text()='VERIFY OTP']");	
	    if (test1 == true)
		{
	         System.out.println("Verify OTP screen is open -Test case pass");
		}
		else
		{
			System.out.println("Verify OTP screen is open -Test case Fail");
		}
	    XpathClick("//button[text()='VERIFY OTP']");
	    TakeScreenShots("invalidOTP");
	   	}
	@Then("click on the verify otp button")
	public void click_on_the_verify_otp_button() {

	    JavascriptExecutor js=(JavascriptExecutor) driver;
	    WebElement element = driver.findElement(By.xpath("//strong[text()='Back to login']"));
	    js.executeScript("arguments[0].scrollIntoView();",element);
	js.executeScript("arguments[0].click();", element); 
}}
