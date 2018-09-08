package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumWaits 
{
	private WebDriverWait wait;
	
	public SeleniumWaits(WebDriver driver)
	{
		wait = new WebDriverWait(driver, 60);
	}
	
	public WebElement waitForElementPresence(By locator)
	{
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	public boolean waitForElementStale(WebElement webElement)
	{
		return wait.until(ExpectedConditions.stalenessOf(webElement));
	}
	
	public WebElement waitForElementVisible(By locator)
	{
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public boolean waitForElementToBeInvisible(By locator)
	{
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
	}
	
	public WebElement waitForElementClickable(By locator)
	{		
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public void waitForAlert()
	{
		wait.until(ExpectedConditions.alertIsPresent());
	}
	
}
