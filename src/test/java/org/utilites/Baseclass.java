package org.utilites;
import java.awt.AWTException;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.Robot;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
public class Baseclass {
	public static WebDriver driver = new FirefoxDriver();

	//public static WebDriver driver= new ChromeDriver();
	public static JavascriptExecutor js=(JavascriptExecutor) driver;
	
	
	public static void launchUrl(String url,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	
	public static void xpathClear(String ele)
	{
		driver.findElement(By.xpath(ele)).clear();
	}
	
	
	public static void winMax() {
		
		driver.manage().window().maximize();
	}
	
	
	public static void XpathClick(String ele) {
		
		driver.findElement(By.xpath(ele)).click();
	}
	
	
	public static void XpathSendkey(String ele,String k) {
		
		driver.findElement(By.xpath(ele)).sendKeys(k);
	}
	
	
	public static void buttonClk(WebElement element) {
		
		element.click();
	}
	
	
	public static void IdClick(String ele) {
		
		driver.findElement(By.id(ele)).click();
	}
	
	
	public static void IdSendKeys(String ele,String txt) {
		
		driver.findElement(By.id(ele)).sendKeys(txt);
	}
	
	
	public static void printTitle() {
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}
	
	
	public static String getURL() {
			
			String title = driver.getCurrentUrl();
			return title;
			
	}

	public static String getText(String ele) {
		
		WebElement ele1 = driver.findElement(By.xpath(ele));
		String text = ele1.getText();
		return text;
		
}
	
	public static String getAttribute(String ele,String att) {
		
		WebElement ele1 = driver.findElement(By.xpath(ele));
		String text = ele1.getAttribute(att);
		return text;
}
public static String getAttributeid(String ele,String att) {
		
		WebElement ele1 = driver.findElement(By.id(ele));
		String text = ele1.getAttribute(att);
		return text;
}
	
	public static void driverLaunch() 
	{
		WebDriver driver1= new ChromeDriver();
	}
	
	
	
	public static void TakeScreenShots(String name) throws Exception{
	
	    Thread.sleep(2000);
	    TakesScreenshot tk = (TakesScreenshot)driver;
		File src = tk.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src,new File("C:\\Users\\PLAP016\\OneDrive\\Desktop\\Screenshots Automationn\\"+name+".png"));
	}
	
	
	
	public static boolean elementIsDisplayed(String ele)
	{
		int a=1;
		try
		{
			
		driver.findElement(By.xpath(ele));
		
		}
		catch(Exception e)
		{
			a++;	
		}
		finally
		{
			if (a==1)
				return true;
			else
				return false;
		}
			
	}
	
	
	
	public static void actionXpathClick(String ele)
	{
		Actions a=new Actions(driver);
		WebElement b = driver.findElement(By.xpath(ele));
		a.moveToElement(b).click().perform();
		//b.click();
		
	}
	
	
	public static void xpathJavaScriptScrollIntoViewClick(String ele)
	{
		
		try
		{
			WebElement element = driver.findElement(By.xpath(ele));
			js.executeScript("arguments[0].scrollIntoView();",element);
			js.executeScript("arguments[0].click();", element);
		}
		catch(Exception e) 
		{
			WebElement element = driver.findElement(By.xpath(ele));
			js.executeScript("arguments[0].scrollIntoView();",element);
			js.executeScript("arguments[0].click();", element);
		}
	}	
	
	
	public static String getTextById(String ele)
	{
		String a=driver.findElement(By.id(ele)).getText();
		return a;
		
	}
	
	
	
	public static String getTextByIdDropDown(String ele)
	{
		WebElement a = driver.findElement(By.id(ele));
	  Select select = new Select(a);
     // WebElement b = select.getFirstSelectedOption();
      String selectedoption = a.getText(); 
	   return selectedoption;
	}

	
	
	public static boolean elementIsDisplayedById(String ele)
	{
		int a=1;
		try
		{
			
		driver.findElement(By.id(ele));
		
		}
		catch(Exception e)
		{
			a++;	
		}
		finally
		{
			if (a==1)
				return true;
			else
				return false;
		}
			
	}
	
	
	public static boolean elementIsDisplayedByXpath(String ele)
	{
		int a=1;
		try
		{
			
		driver.findElement(By.xpath(ele));
		
		}
		catch(Exception e)
		{
			a++;	
		}
		finally
		{
			if (a==1)
				return true;
			else
				return false;
		}
			
	}
	
	
	
	
	public static void closeTab()
	{
		driver.close();
	}
	
	
	public static void closeBrowser()
	{
		driver.quit();
	}
	
	
	
	public static void refreshTab()
	{
		driver.navigate().refresh();
	}
	
	
	public static void idJavaScriptScrollIntoViewClick(String ele)
	{
		WebElement element = driver.findElement(By.id(ele));
		js.executeScript("arguments[0].scrollIntoView();",element);
		js.executeScript("arguments[0].click();", element);
	}		

	
	public static void openInNewTab(String url, WebDriver driver )
	{
		driver.switchTo().newWindow(WindowType.TAB);
		driver.navigate().to(url);
	}
	
	
	
	public static void sendKeyboardKeys(String ele) throws AWTException
	{
		Robot robot = new Robot();
		if(ele.equalsIgnoreCase("Enter"))
		{
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		}
		else if(ele.equalsIgnoreCase("tab"))
		{
			robot.keyPress(KeyEvent.VK_TAB);
			robot.keyRelease(KeyEvent.VK_TAB);
		}
		else if(ele.equalsIgnoreCase("down"))
		{
			robot.keyPress(KeyEvent.VK_DOWN);
			robot.keyRelease(KeyEvent.VK_DOWN);
		}
		else if(ele.equalsIgnoreCase("back space"))
		{
			robot.keyPress(KeyEvent.VK_BACK_SPACE);
			robot.keyRelease(KeyEvent.VK_BACK_SPACE);
		}
		
	}
	

	public static void selectByIndex(int val, WebElement ele)
	{
		Select objSelect = new Select(ele);
		objSelect.selectByIndex(val);
	}
	
	
	public static WebElement elementCreateXpath(String ele)
	{
		WebElement element = driver.findElement(By.xpath(ele));
		return element;
		
	}

	
	public static WebElement elementCreateId(String ele)
	{
		WebElement element = driver.findElement(By.id(ele));
		return element;
		
	}

	
	public static void scrollDown(int a)
	{
		
	js.executeScript("window.scrollBy(0,"+a+")","");
	}
	
	public static void scrollToTop()
	{
		//js.executeScript("window.scrollTo(0,0)", "");
	    js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");

	}
	
	public static boolean elementIsClickableId(String ele) {
		 int b=1;
		try
		{
			
			driver.findElement(By.id(ele)).isEnabled();
		
		}
		catch(Exception e)
		{
			b++;	
		}
		finally
		{
			if (b==1)
				return true;
			else
				return false;
		}		}

	public static boolean elementIsClickableXpath(String ele) 
	{
		 int b=1;
		try
		{
			
			driver.findElement(By.xpath(ele)).isEnabled();
		
		}
		catch(Exception e)
		{
			b++;	
		}
		finally
		{
			if (b==1)
				return true;
			else
				return false;
		}
	}
		
		
		public static void idClear(String ele)
		{
			driver.findElement(By.id(ele)).clear();
		}
	
}