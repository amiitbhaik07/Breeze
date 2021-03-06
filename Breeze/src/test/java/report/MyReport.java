package report;

import java.io.File;
import java.util.ArrayList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import interfaces.IReport;

public class MyReport implements IReport
{	
	ExtentHtmlReporter html;
	ExtentReports currentExtentReport;
	ArrayList<ExtentTest> allExtentTests = new ArrayList<ExtentTest>();
	ExtentTest currentExtentTest = null;
	boolean featureSuccess = true;
	int total=0, fail=0;
	private String extentReportFolderPath;
	public String extentReportHtmlPath;
	
	public MyReport(String featureName, String reportPath)
	{
		if(featureName.toLowerCase().contains("consolidated")&&featureName.toLowerCase().contains("report"))
			extentReportFolderPath = reportPath + "\\";
		else
			extentReportFolderPath = reportPath + featureName + "\\";
		new File(extentReportFolderPath).mkdirs();
		extentReportHtmlPath = extentReportFolderPath + featureName + ".html";
		html = new ExtentHtmlReporter(extentReportHtmlPath);
		currentExtentReport = new ExtentReports();
		currentExtentReport.attachReporter(html);
	}
	
	public void EndReport()
	{
		currentExtentReport.flush();
	}
	
	@Override
	public void StartTest(String testName) 
	{
		new File(extentReportFolderPath + testName).mkdirs();
		total++;
		if(currentExtentTest!=null)
			allExtentTests.add(currentExtentTest);
		currentExtentTest = currentExtentReport.createTest(testName);
	}

	@Override
	public void EndTest() 
	{
		
	}

	@Override
	public void AddScreenshot() throws Exception
	{
		currentExtentTest.addScreenCaptureFromPath("");
	}

	@Override
	public void AddStepResult(LOG_STATUS stepStatus, String stepDescription) 
	{
		switch(stepStatus)
		{
		case PASS :
			currentExtentTest.pass(stepDescription);
			break;
			
		case FAIL :
			currentExtentTest.fail(stepDescription);
			fail++;
			featureSuccess = false;
			break;
			
		case SKIP :
			currentExtentTest.skip(stepDescription);
			break;		
			
		case INFO:
			currentExtentTest.info(stepDescription);
		}
	}
}
