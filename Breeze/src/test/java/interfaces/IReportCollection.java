package interfaces;

import java.util.ArrayList;

import report.MyReportCollection;

public interface IReportCollection 
{
	public ArrayList<MyReportCollection> allExtentReports = new ArrayList<MyReportCollection>();
	
	public void AddExtentReport(String feature);
	
	public void CompleteExtentReport();
}
