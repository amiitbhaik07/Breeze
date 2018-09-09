package report;

import java.io.IOException;
import java.util.ArrayList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

import interfaces.IReport;
import interfaces.IReport.LOG_STATUS;
import interfaces.IReportCollection;

public class MyReportCollection implements IReportCollection
{	
	public ArrayList<MyReport> allExtentReports = new ArrayList<MyReport>();
	public MyReport myReport;
	public MyReport consolidatedReport;
		
	public MyReportCollection()
	{
		consolidatedReport = new MyReport("Consolidated_Report");
	}
	
	public void CompleteMyCollection()
	{
		consolidatedReport.EndReport();
	}
	
	@Override
	public void AddExtentReport(String feature)
	{
		myReport = new MyReport(feature);
		consolidatedReport.StartTest(feature);
	}

	@Override
	public void CompleteExtentReport()
	{
		if(myReport.featureSuccess)
			consolidatedReport.AddStepResult(LOG_STATUS.PASS, "All scenarios passed!");
		else
			consolidatedReport.AddStepResult(LOG_STATUS.FAIL, "'"+myReport.fail+"' out of '"+myReport.total+"' scenarios failed!");
		myReport.EndReport();
		allExtentReports.add(myReport);
	}
}