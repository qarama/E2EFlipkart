package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.io.OutputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class base {
	public static WebDriver driver;
	public Properties prop;
 public WebDriver startDriver() throws IOException {
	 prop=new Properties();
	 FileInputStream fis=new FileInputStream("C:\\Users\\Sony\\E2EDemoProject\\src\\main\\java\\resources\\data.properties");
	prop.load(fis);
	 if (prop.get("browser").equals("Chrome")) {
		System.setProperty("webdriver.chrome.driver", "G:/New Eclipse/Selenium Jar/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
	 }
	 else if (prop.getProperty("browser").equalsIgnoreCase("Firefox")) {
		System.setProperty("webdriver.gecko.driver", "");
	}
	 else if (prop.getProperty("browser").equalsIgnoreCase("IE")) {
		 System.setProperty("webdriver.ie.driver", "");
		}
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 return driver;
}
 
 public void getScreenshot(String result) throws IOException 
 {
	
	System.out.println("Entering the getScreenshot() method");
	File src=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	File DestFile=new File(".//resources"+result+"screenshot.png");
	FileHandler.copy(src, DestFile);
	
 }

}
