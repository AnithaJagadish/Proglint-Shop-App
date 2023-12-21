package org.stepdefinition;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class ChatStepDefinition extends Baseclass{

	@Then("Navigate to Chat screen and priniting and send message to customer")
	public void navigate_to_chat_screen_and_priniting_and_send_message_to_customer() throws InterruptedException {
		scrollDown(1000);
        JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,250)");
		idJavaScriptScrollIntoViewClick("Chat");
		System.out.println("Navigated to the Chat options");
		Thread.sleep(5000);
	System.out.println("The list of chat is :");
	System.out.println();
	Actions act=new Actions(driver);
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	List<WebElement>chatlist=driver.findElements(By.xpath("//div[@id='chat-content']/span/div/div"));
	for(WebElement chat:chatlist) 
	{
		System.out.println();
		String chatdata=chat.getText();
		System.out.println(chatdata);
	}
	
	//chat screen
	XpathClick("//div[@id='chat-content']/span/div[1]");
	Thread.sleep(10000);
	String chatwindow=getText("//div[@id='chatting-window']");
	System.out.println(chatwindow);
	IdClick("ViewReceipt");
	Thread.sleep(7000);
	String customerDetail=getText("//div[@class='modal-body font13 p-40']/div[1]/div[2]");
	System.out.println("The customer details is "+customerDetail);
	String orderType=getText("//div[@class='row align-items-center mb-2']");
	System.out.println("The Order type is "+orderType);
	String pickup=getText("//h3[@class='font16 fw-bold mb-2']");
	System.out.println(pickup);
	String address=getText("//p[@class='font14 mb-2']");
	System.out.println("Address of the customer--->"+address);
	System.out.println("----Bill Details----");
	String product=getText("//*[@id=\"order-details-modal\"]/div/div/div[2]/div[5]");
	System.out.println(product);
	String taxdetails=getText("//*[@id=\"order-details-modal\"]/div/div/div[2]/div[6]");
	System.out.println(taxdetails);
	String discount=getText("//*[@id=\"order-details-modal\"]/div/div/div[2]/div[7]");
	System.out.println(discount);
	String totalamt=getText("//*[@id=\"order-details-modal\"]/div/div/div[2]/div[8]");
	System.out.println("Total price-->"+totalamt);
	driver.findElement(By.className("modal-close")).click();
	IdSendKeys("keyDown", "How may i help you sir");
	Thread.sleep(3000);
	WebElement enter=driver.findElement(By.xpath("//div[@class='bg-light']/div[3]/button"));
	act.moveToElement(enter).click().build().perform();
	System.out.println("Message is sent successfully");
	}
}
