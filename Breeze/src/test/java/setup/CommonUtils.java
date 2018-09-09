package setup;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtils 
{
	public static String GetCurrentDateStamp()
	{
		return new SimpleDateFormat("yyyy_MM_dd").format(new Date());
	}
	
	public static String GetCurrentTimeStamp()
	{
		return new SimpleDateFormat("HH_mm_ss").format(new Date());
	}
}
