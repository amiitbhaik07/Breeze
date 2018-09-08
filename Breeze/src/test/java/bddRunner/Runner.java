package bddRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import setup.Singleton;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/bddFeatures", 
		glue = { "bddSteps", "base" },
		dryRun = false
		)
public class Runner
{	
	@BeforeClass
	public static void BeforeFeature()	
	{
		Singleton.getInstance().testBase.runBeforeAllFeatures();
	}
	
	@AfterClass
	public static void AfterFeature()
	{
		Singleton.getInstance().testBase.runAfterAllFeatures();
	}
}
