package report;

import java.io.File;
import java.text.SimpleDateFormat;

import setup.CommonUtils;

public class ReportMetadata 
{
	public static String reportFolder;
	
	public ReportMetadata()
	{
		String reportBaseFolder = System.getProperty("user.dir") + "\\Reports\\";
		String reportDateFolder = CommonUtils.GetCurrentDateStamp() + "\\";
		String reportRunFolder = "Run_" + CommonUtils.GetCurrentTimeStamp() + "\\";
		reportFolder = reportBaseFolder + reportDateFolder + reportRunFolder;
		new File(reportFolder).mkdirs();
	}
}
