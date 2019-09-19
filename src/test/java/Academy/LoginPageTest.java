package Academy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.LoginPage;
import resources.base;

public class LoginPageTest extends base{
	public static Logger log=LogManager.getLogger(base.class.getName());
@BeforeTest
public void initialize() throws Exception {
	driver=startDriver();
	
}

@Test(dataProvider = "getData")
public void getLoginPage(String emailid,String password,String text) throws Exception {
	driver.get(prop.getProperty("url"));
	LoginPage lp=new LoginPage(driver);
	log.info("Started Login Validation");
	Thread.sleep(5000);
	lp.getEmailId().sendKeys(emailid);
	lp.getPassword().sendKeys(password);
	log.info(text);
	lp.getLogin().click();
	
}

@DataProvider
public Object[][] getData() {
	Object[][]	data=new Object[2][3];
	data[0][0]  ="rcdas2012";
    data[0][1]	="9874a5612";
    data[0][2] 	="Invalid Login";	
    data[1][0]  ="rcdas2012@gmail.com";
    data[1][1]	="9778a474132";
    data[1][2]	="Valid Info";
    return data;
}
@AfterTest
public void tearDown() {
	driver.close();
	log.info("successfully closed the browser");
}
}
