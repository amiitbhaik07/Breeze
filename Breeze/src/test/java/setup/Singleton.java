package setup;

import base.TestBase;
import base.TestBase;

public class Singleton 
{
	private static Singleton single_instance = null;
	public TestBase testBase = new TestBase();
	
	private Singleton()
	{
		
	}
	
	public static Singleton getInstance()
	{
		if(single_instance == null)
			single_instance = new Singleton(); 
		return single_instance;
	}
}