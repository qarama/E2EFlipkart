package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.base;

public class Listners implements ITestListener{
	public static Logger log=LogManager.getLogger(base.class.getName());	
    base b=new base();
public void onTestStart(ITestResult result) {
	// TODO Auto-generated method stub
	
}
public void onTestSuccess(ITestResult result) {
	// TODO Auto-generated method stub
	log.info("Successfully passed ");
}
public void onTestSkipped(ITestResult result) {
	// TODO Auto-generated method stub
	
}
public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	// TODO Auto-generated method stub
	
}
public void onStart(ITestContext context) {
	// TODO Auto-generated method stub
	
}
public void onFinish(ITestContext context) {
	// TODO Auto-generated method stub
	
}
public void onTestFailure(ITestResult result) {
	log.error(result.getName()+" is failed");
	try {
		b.getScreenshot(result.getName());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
