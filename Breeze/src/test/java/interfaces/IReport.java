package interfaces;

public interface IReport 
{
	public enum LOG_STATUS {PASS, FAIL, SKIP}
	
	public void EndReport();
	
	public void StartTest(String testName);
	
	public void EndTest();
	
	public void AddScreenshot() throws Exception;
	
	public void AddStepResult(LOG_STATUS stepStatus, String stepDescription);
}
