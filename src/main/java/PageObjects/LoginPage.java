package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
public WebDriver driver;	
	
public LoginPage(WebDriver driver) {
	this.driver=driver;
}
By emailid=By.xpath("//input[@class='_2zrpKA _1dBPDZ']");
By password=By.cssSelector("input[type='password']");
By login=By.cssSelector("button[class='_2AkmmA _1LctnI _7UHT_c']");
By search_button=By.cssSelector("button[class='vh79eN']");
public WebElement getEmailId() {
	return driver.findElement(emailid);
}
public WebElement getPassword() {
	return driver.findElement(password);
}
public WebElement getLogin() {
	return driver.findElement(login);
}
public WebElement clickOnSearchButton() {
	return driver.findElement(search_button);
}
}
