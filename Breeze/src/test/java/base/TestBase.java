package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

import cucumber.api.Scenario;
import interfaces.IReport.LOG_STATUS;
import report.MyReport;
import report.MyReportCollection;

public class TestBase
{
	MyReportCollection reportCollection;
	MyReport report;
	
	//All Features
	public void runBeforeAllFeatures()
	{
		reportCollection = new MyReportCollection();
		System.out.println("__runBeforeAllFeatures");
	}
	
	public void runAfterAllFeatures()
	{
		reportCollection.CompleteMyCollection();
		System.out.println("__runAfterAllFeatures");
	}
	
	
	//Feature
	public void runBeforeEveryFeature(String featureName)
	{		
		reportCollection.AddExtentReport(featureName);
		report = reportCollection.myReport;
		System.out.println("____runBeforeEveryFeature");
	}
	
	public void runAfterEveryFeature()
	{
		reportCollection.CompleteExtentReport();
		System.out.println("____runAfterEveryFeature");
	}
	
	
	//Scenario
	public void runBeforeEveryScenario(Scenario scenario)
	{
		String name = scenario.getName();
		report.StartTest(name);
		report.AddStepResult(LOG_STATUS.PASS, "Started execution for " + name);
		System.out.println("______runBeforeEveryScenario");
	}
	
	public void runAfterEveryScenario(Scenario scenario)
	{
		if(scenario.isFailed())
			report.AddStepResult(LOG_STATUS.FAIL, "Scenario failed : " + scenario.getName());
		else
			report.AddStepResult(LOG_STATUS.PASS, "Scenario successfully executed : " + scenario.getName());
		
		System.out.println("______runAfterEveryScenario");
		
	}
	
	
	//Step
	public void runBeforeEveryStep()
	{
		System.out.println("________runBeforeEveryStep");
	}
	
	public void runAfterEveryStep()
	{
		System.out.println("________runAfterEveryStep");
	}
}