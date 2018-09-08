package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumActions
{
	SeleniumWaits waits;
	WebDriver driver;
	public SeleniumActions(SeleniumWaits waits, WebDriver driver)
	{
		this.driver = driver;
		this.waits = waits;
	}
	
	public WebElement getWebElement(By by)
	{
		scrollIntoViewIfNotVisible(by);
		return waits.waitForElementVisible(by);
	}
	
	public void click(By by)
	{
		scrollIntoViewIfNotVisible(by);
		waits.waitForElementClickable(by).click();
	}
	
	public void sendKeys(By by, String text)
	{
		scrollIntoViewIfNotVisible(by);
		waits.waitForElementClickable(by).sendKeys(text);
	}
	
	public void selectDropdown(By by, String valueToSelect)
	{
		scrollIntoViewIfNotVisible(by);
		Select select = new Select(getWebElement(by));
		select.selectByVisibleText(valueToSelect);
	}
	
	public void selectDropdown(By by, int index)
	{
		scrollIntoViewIfNotVisible(by);
		Select select = new Select(getWebElement(by));
		select.selectByIndex(index);
	}
	
	public void scrollIntoView(By by)
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("Element.prototype.documentOffsetTop = function () {return this.offsetTop + ( this.offsetParent ? this.offsetParent.documentOffsetTop() : 0 );}; var top = arguments[0].documentOffsetTop() - ( window.innerHeight / 2 );window.scrollTo( 0, top );", getWebElement(by));
	}
	
	public void scrollIntoViewIfNotVisible(By by)
	{
		if(!isWebElementInViewPort(by))
		{
			JavascriptExecutor jse = (JavascriptExecutor)driver;
			jse.executeScript("Element.prototype.documentOffsetTop = function () {return this.offsetTop + ( this.offsetParent ? this.offsetParent.documentOffsetTop() : 0 );}; var top = arguments[0].documentOffsetTop() - ( window.innerHeight / 2 );window.scrollTo( 0, top );", getWebElement(by));
		}
	}
	
	private long getXOffset()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return (Long) executor.executeScript("return window.pageXOffset;");
	}
	
	private long getYOffset()
	{
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		return (Long) executor.executeScript("return window.pageYOffset;");
	}
	
	public boolean isWebElementInViewPort(By by) 
	{
		WebElement w = waits.waitForElementPresence(by);
	    Dimension weD = w.getSize();
	    Point weP = w.getLocation();
	    Dimension d = driver.manage().window().getSize();
	    int x = d.getWidth()+(int)getXOffset()-75; //if(x>150){x=x-100;}
	    int y = d.getHeight()+(int)getYOffset()-75; //if(y>150){y=y-100;}
	    int x2 = weD.getWidth() + weP.getX();
	    int y2 = weD.getHeight() + weP.getY();
	    return (x2 <= x && y2 <= y);
	}
	
	
	
	

}
