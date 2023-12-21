package org.stepdefinition;

import java.io.File;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class StoreTiming extends Baseclass{
   /* @Given("Create file Log")
    public static void create_file_log() throws IOException {
        File file = new File("C:\\Users\\PLAP016\\eclipse-workspace\\cucumber\\target\\output.log");
        file.createNewFile(); 
       }*/
    @When("click on the store timing tab")
    public void click_on_the_store_timing_tab() throws InterruptedException {
        idJavaScriptScrollIntoViewClick("storeavailability");
        Thread.sleep(3000);
    }
    @When("checking the {string} title is present on the screen")
    public void checking_the_title_is_present_on_the_screen(String string) throws Exception {
    	String Tittleofthepage ="Store hours";
        String ActualTittleofthepage = getText("//h2[@class='font15 fw-bold mb-3']");
        TakeScreenShots("StoreTiming");
        Thread.sleep(3000);
        if(Tittleofthepage.equals(ActualTittleofthepage))
        {
        	
        	 System.out.println("Tittle of the screen: Store hours");	
        }
        else
        {
        	 System.out.println("Incorrect tittle");
        }
    }
    @When("checking all the days and timings are present on the screen")
    public void checking_all_the_days_and_timings_are_present_on_the_screen() {
    	 for(int i=1;i<=14;i++)
    	    {
    	    String ActualdayspresentOnthepage = getText("(//div[@class='col'])[" + i + "]");
    	    //String dayNameOnly = ActualdayspresentOnthepage.split(" ", 1)[0];
    	    //String dayNameOnly = ActualdayspresentOnthepage.trim();
    	    System.out.println(ActualdayspresentOnthepage);}
    }
    @And("Click on the Edit button and changing the start time and checking the same and checking the cancel functionality")
    public void click_on_the_edit_button_and_changing_the_start_time() throws InterruptedException {
    	IdClick("isStoreEdit");
        xpathJavaScriptScrollIntoViewClick("(//input[@id='startUpdateDate'])[3]");
        Actions act=new Actions(driver);
        WebElement strselect=driver.findElement(By.xpath("(//li[@role='button'])[1]"));
        String ChoosedtimeTOupdate = getText("(//li[@role='button'])[1]");
        System.out.println("Choosed time to update: " + ChoosedtimeTOupdate);
    	act.moveToElement(strselect).sendKeys("Comp").build().perform();
    	strselect.sendKeys(Keys.ENTER);
    	idJavaScriptScrollIntoViewClick("store-info");
    	Thread.sleep(2000);
    	
        WebElement strselect1=driver.findElement(By.xpath("(//li[@tabindex='0'])[30]"));
    	act.moveToElement(strselect1).sendKeys("Comp").build().perform();
    	strselect1.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	IdClick("onUpdate");
    	Thread.sleep(3000);
    	IdClick("isStoreEdit");
   	 xpathJavaScriptScrollIntoViewClick("(//input[@id='startUpdateDate'])[3]");
   	String Timeonafterupdate = getText("(//li[@role='button'])[1]");
    System.out.println("Time on after update: " + Timeonafterupdate);
       if(ChoosedtimeTOupdate.equals(Timeonafterupdate))
       {
    	   System.out.println("Choosed and updated Time is correct");
       }
       else
       {
    	   System.out.println("Choosed and updated Time is incorrect");

       }
       Thread.sleep(2000);
   	 XpathClick("//button[@id='Cancel']");
   	Thread.sleep(2000);
    }
    @Then("Click on the Edit button and changing the end time")
    public void click_on_the_edit_button_and_changing_the_end_time() throws InterruptedException {
    	IdClick("isStoreEdit");
    	xpathJavaScriptScrollIntoViewClick("(//input[@id='endUpdateDate'])[4]");
    	Actions actt=new Actions(driver);
        WebElement strselect2=driver.findElement(By.xpath("(//li[@role='button'])[1]"));
    	actt.moveToElement(strselect2).sendKeys("Comp").build().perform();
    	strselect2.sendKeys(Keys.ENTER);
    	Thread.sleep(2000);
    	
        WebElement strselect3=driver.findElement(By.xpath("(//li[@tabindex='0'])[30]"));
    	actt.moveToElement(strselect3).sendKeys("Comp").build().perform();
    	strselect3.sendKeys(Keys.ENTER);
    	Thread.sleep(5000);
        IdClick("onUpdate");

        
    }

}