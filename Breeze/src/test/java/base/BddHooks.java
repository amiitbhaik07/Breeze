package base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.junit.JUnitReporter;
import setup.Singleton;

public class BddHooks 
{
	boolean isLastScenario = false;
	
	@Before("@FirstScenario")
	public void BeforeFeature(Scenario scenario)
	{
	    String rawFeatureName = scenario.getId().split(";")[0].replace("-","_");
	    String featureName = "Feature_" + rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
		isLastScenario = false;
		Singleton.getInstance().testBase.runBeforeEveryFeature(featureName);
	}
	
	@After("@LastScenario")
	public void AfterFeature(Scenario scenario)
	{
		AfterScenario(scenario);
		isLastScenario = true;		
		Singleton.getInstance().testBase.runAfterEveryFeature();
	}
	
	@Before
	public void BeforeScenario(Scenario scenario)
	{
		isLastScenario = false;
		Singleton.getInstance().testBase.runBeforeEveryScenario(scenario);
	}
	
	@After
	public void AfterScenario(Scenario scenario)
	{
		if(!isLastScenario)
		{
			isLastScenario = false;
			Singleton.getInstance().testBase.runAfterEveryScenario(scenario);
		}
	}

	
	public void BeforeStep()
	{
		System.out.println("########## Before Step yet to implement");
	}
	
	public void AfterStep()
	{
		System.out.println("########## After Step yet to implement");
	}
}
