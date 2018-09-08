package helpers;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverActions 
{
	WebDriver driver;
	static String hubUrl;
	private static BROWSER defaultBrowser;
	static boolean runOnGrid=false;
	static boolean quitBrowserOnFailure = true;
	static boolean quitBrowserOnSuccess = true;
	static Properties prop = new Properties();	
	public enum BROWSER {CHROME, FIREFOX, PHANTOMJS, HTMLUNIT}
	static InputStream input;
	
	public DriverActions()
	{
		loadPropertyFile();
	}
	
	public WebDriver launchBrowser() throws Exception
	{
		if(runOnGrid)
			return launchBrowser(defaultBrowser, Platform.WINDOWS);
		else
			return launchBrowser(defaultBrowser);
	}

	public WebDriver launchBrowser(BROWSER browser)
	{
		switch(browser)
		{
		case CHROME: 
			driver = new ChromeDriver();
			break;
			
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
			
		case PHANTOMJS:
			System.setProperty("phantomjs.binary.path",".\\lib\\phantomjs.exe");
			driver = new PhantomJSDriver(null);
			break;
			
		case HTMLUNIT:
			driver = new HtmlUnitDriver();
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	public WebDriver launchBrowser(BROWSER browser, Platform platform) throws Exception 
	{
		DesiredCapabilities cap;
		WebDriver driver = null;
		switch(browser)
		{
		case CHROME: 
			cap=DesiredCapabilities.chrome();
			cap.setPlatform(platform);
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			break;
			
		case FIREFOX:
			cap=DesiredCapabilities.firefox();
			cap.setPlatform(platform);
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			break;
			
		case PHANTOMJS:
			System.setProperty("phantomjs.binary.path",".\\lib\\phantomjs.exe");
			cap=DesiredCapabilities.phantomjs();
			cap.setPlatform(platform);
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			break;
			
		case HTMLUNIT:
			cap=DesiredCapabilities.htmlUnit();
			cap.setPlatform(platform);
			driver = new RemoteWebDriver(new URL(hubUrl),cap);
			break;
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	private void loadPropertyFile()
	{
		try
		{
			input = new FileInputStream("common.properties");
			prop.load(input);
		}
		catch(Exception e){}
		hubUrl = prop.getProperty("hubUrl");
		switch(prop.getProperty("browserName").toLowerCase().trim())
		{
		case "chrome": defaultBrowser = BROWSER.CHROME; break;
		case "firefox": defaultBrowser = BROWSER.FIREFOX; break;
		case "phantomjs": defaultBrowser = BROWSER.PHANTOMJS; break;
		}
		try
		{
			if(prop.getProperty("runOnGrid")!=null)
				if(prop.getProperty("runOnGrid").trim().equalsIgnoreCase("true") && hubUrl!=null)
					if(! hubUrl.trim().equalsIgnoreCase(""))
						runOnGrid = true;
		}
		catch(Exception e){
			runOnGrid = false;
		}
		try
		{
			if(prop.getProperty("quitBrowserOnFailure")!=null)
				if(prop.getProperty("quitBrowserOnFailure").trim().equalsIgnoreCase("false"))
					quitBrowserOnFailure = false;
			if(prop.getProperty("quitBrowserOnSuccess")!=null)
				if(prop.getProperty("quitBrowserOnSuccess").trim().equalsIgnoreCase("false"))
					quitBrowserOnSuccess = false;
		}
		catch(Exception e){}		
		System.out.println("Property File Loaded Successfully");
	}
}
