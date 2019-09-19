package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
	
public WebDriver driver;
    
public HomePage(WebDriver driver) {
	
	this.driver=driver;
	
}

By searchbox=By.name("q");
By headercontent=By.xpath("//ul[@class='_114Zhd']/li");


public WebElement searchTextBox() {
	return driver.findElement(searchbox);
}
public List<WebElement> headerContentList() {
	return driver.findElements(headercontent);
}
}
