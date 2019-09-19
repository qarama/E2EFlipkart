package Academy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import resources.base;

public class HomepageTest extends base {
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initialize() throws IOException {
		driver=startDriver();
		log.info("Driver is initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Home Page");
	}
	@Test
	public void getHomePage() throws Exception {
		LoginPage lp=new LoginPage(driver);
		lp.getEmailId().sendKeys(prop.getProperty("email"));
		lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.getLogin().click();
		log.info("Successfully logged ");
		HomePage hp=new HomePage(driver);
		Thread.sleep(3000);
		hp.searchTextBox().sendKeys("Mobile");
		lp.clickOnSearchButton().click();
		log.info("Searched text successfully");
      	
	}
  @Test
  public void headerValidation() {
	  HomePage hp=new HomePage(driver);
	  List<WebElement> l=hp.headerContentList();
	  log.info("counting the list of header "+l.size());
	  Iterator<WebElement> it=l.iterator();
	  for (int i = 0; i < l.size(); i++) {
		String value=l.get(i).getText();
	    if(value.equalsIgnoreCase("Electronics")) {
	    	Actions ac=new Actions(driver);
	    	ac.moveToElement(l.get(i)).build().perform();
	    	log.info("successfully selected");
	    	
	    }
	}
  }
  
  @Test
  public void getTitle() throws IOException
  {
	 log.info(driver.getTitle());
	 Assert.assertEquals(driver.getTitle(), "Flipkart");
  }
  @AfterTest
  public void tearDown() {
  	driver.close();
  	log.info("successfully closed the browser");
  }
}
