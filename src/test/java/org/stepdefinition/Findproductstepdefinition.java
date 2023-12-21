package org.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.utilites.Baseclass;

import io.cucumber.java.en.*;

public class Findproductstepdefinition extends Baseclass {
	@Given("To verify the Find Product tab is displayed in the side bar menu and click on the same")
	public void to_verify_the_find_product_tab_is_displayed_in_the_side_bar_menu_and_click_on_the_same() throws InterruptedException {
		boolean tab=driver.findElement(By.xpath("//span[@id='Product']")).isDisplayed();
		if(tab==true)
		{
			System.out.println("Product tab is displayed");

		}

		else
		{
			System.out.println("Product tab is not displayed");
		}

         Thread.sleep(2000);
			boolean Product=tab;
		if (Product==true)
		{
			//driver.findElement(By.xpath("//span[@id='Product']")).click();
			
			XpathClick("//span[@id='Product']");
			System.out.println("Product tab is clicked");
		}
		else
		{
			System.out.println("The product tab is not clickable");
		}

	}
	@When("Verify the Find Product header is displayed in the screen if not throw error message")
	public void verify_the_find_product_header_is_displayed_in_the_screen_if_not_throw_error_message() {
		String header=driver.findElement(By.xpath("//h1[normalize-space()='Find product']")).getText();
		if(header.equals("Find product"))
		{
			System.out.println("Header is displayed:"+ header);
		}

		else
		{
			System.out.println("Header is not displayed");
		}
	}
	@When("Verify the Search box is displayed")
	public void verify_the_search_box_is_displayed() {
		boolean search=driver.findElement(By.xpath("//input[@placeholder='Search by Product Name']")).isDisplayed();
		if (search==true)
		{
			System.out.println("Search box is displayed");
		}

	}
	@When("Verify the drop down field is displayed")
	public void verify_the_drop_down_field_is_displayed() {
		boolean drp= driver.findElement(By.id("selectProduct")).isDisplayed();
		if (drp=true)
		{
			System.out.println("Dropdown is displayed");
		}

	}
	@When("Verify the placeholder is displayed in the Search box")
	public void verify_the_placeholder_is_displayed_in_the_search_box() throws InterruptedException {
		String placeholder=driver.findElement(By.xpath("//input[@placeholder='Search by Product Name']")).getAttribute("placeholder");
		if(placeholder.equals("Search by Product Name"))
		{
			System.out.println(placeholder);
		}

		Thread.sleep(3000);
	}
	@When("Click on the Products which is displayed in the list")
	public void click_on_the_products_which_is_displayed_in_the_list() throws InterruptedException {
		XpathClick("//form/following::div/span[1]");
		Thread.sleep(3000);		
		XpathClick("//img[@id='close']");
		Thread.sleep(3000);		
		XpathClick("//form/following::div/span[2]");
		Thread.sleep(3000);		
		XpathClick("//img[@id='close']");
		Thread.sleep(3000);		
		XpathClick("//form/following::div/span[3]");
		Thread.sleep(3000);		
		XpathClick("//img[@id='close']");
		Thread.sleep(3000);		
		XpathClick("//form/following::div/span[4]");
		Thread.sleep(3000);		
	XpathClick("//img[@id='close']");
		Thread.sleep(3000);
	}
	@When("Search the products by Product name")
	public void search_the_products_by_product_name() {
		XpathSendkey("//input[@placeholder='Search by Product Name']", "top ramen - masala noodles" );

	}
	@When("Verify the Searched product name is displayed in the Search box and displayed in the list")
	public void verify_the_searched_product_name_is_displayed_in_the_search_box_and_displayed_in_the_list() throws InterruptedException {
		Thread.sleep(5000);
		String pd=driver.findElement(By.xpath("//div/h3[@class='product-name title-case']")).getText();

		if(pd.equalsIgnoreCase("top ramen - masala noodles"))
		{
			System.out.println("Searched product is displayed");
		}
		else
		{
			System.out.println("Product not found");
		}

		Thread.sleep(5000);
	}
	@When("Clear the product name in the search box")
	public void clear_the_product_name_in_the_search_box() throws InterruptedException {
		xpathClear("//input[@placeholder='Search by Product Name']");
		Thread.sleep(5000);
		refreshTab();
		Thread.sleep(3000);
	}
	@When("Search the product by SKU id and clear the id")
	public void search_the_product_by_sku_id_and_clear_the_id() throws InterruptedException {
		XpathSendkey("//input[@placeholder='Search by Product Name']", "8901396460404");
		String sku=driver.findElement(By.xpath("//span[text() = '8901396460404']")).getText();
		sku.replaceAll("SKU - ", "");
		System.out.println(sku);
		if(sku.equals("SKU - 8901396460404"))
		{
			System.out.println("SKU is matched");
		}
		else
		{
			System.out.println("SKU not matched");
		}

		Thread.sleep(10000);
			xpathClear("(//input[@type='text'])[2]");
		Thread.sleep(5000);
		refreshTab();
		Thread.sleep(5000);
	}
	@When("Verify the grocery is selected in the drop down")
	public void verify_the_grocery_is_selected_in_the_drop_down() {
		String dropdown=driver.findElement(By.xpath("//select[@id='selectProduct']/option[1]")).getText();
		if(dropdown.equals("Grocery"))
		{
			System.out.println(dropdown);
		}

		else
		{
			System.out.println("Text not found");
		}
	}
	@When("Verify two options is displayed in the dropdown and print the options")
	public void verify_two_options_is_displayed_in_the_dropdown_and_print_the_options() throws InterruptedException {
		WebElement drop=driver.findElement(By.xpath("//select[@id='selectProduct']"));
		Select drpOptions=new Select(drop);

		List<WebElement> options=drpOptions.getOptions();
		System.out.println("Dropdown options:"+ options.size());
			for(WebElement op:options)
		{
			System.out.println(op.getText());

		}

		Thread.sleep(3000);
			drpOptions.selectByVisibleText("Bistro");

		//Verify the bistro is displayed in the dropdown after selected
		String dispOption=driver.findElement(By.xpath("//select[@id='selectProduct']/option[2]")).getText();
		if(dispOption.equals("Bistro"))
		{
			System.out.println("After selecting in dropdown:" +dispOption);
		}
		else
		{
			System.out.println("Selected option not displayed");
		}
		String BistroProd=driver.findElement(By.xpath("//h2[normalize-space()='Product Not Found']")).getText();
		if(BistroProd.equals("Product Not Found"))
		{
			Thread.sleep(3000);
			drpOptions.selectByValue("2");
		}
		else
		{
			System.out.println("Can't able to select Grocery");
		}
	}
	@Then("Verify the grocery is displayed after selecting it")
	public void verify_the_grocery_is_displayed_after_selecting_it() throws InterruptedException {
		String selectText=driver.findElement(By.xpath("//select[@id='selectProduct']/option[1]")).getText();
		if(selectText.equals("Grocery"))
		{
			System.out.println("After selecting option if product not found in bistro category:" +selectText);
		}

		else
		{
			System.out.println("Option not selected");
		}

		Thread.sleep(3000);
		
	}
}
