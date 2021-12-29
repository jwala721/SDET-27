package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
/**
 * 
 * @author JWALA KUMAR
 *
 */
public class RetryAnalyserDemo {
	@Test( retryAnalyzer = com.crm.autodest.genericUtility.RetryAnalyserImpl.class)
	
	public void retryAnalyserDemoTest() 
	{
		System.out.println("RetryAnalyser");
		Assert.fail();
	}

}
