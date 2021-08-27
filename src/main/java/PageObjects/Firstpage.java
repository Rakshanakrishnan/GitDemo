package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Firstpage {

	public WebDriver driver;

	public Firstpage(WebDriver driver) {
		this.driver=driver;
	}
	
	By loginbutton= By.xpath("//*[text()='Login']");

	By text= By.xpath("//*[@id=\"content\"]/div/div/h2");
	
	By contact = By.xpath("//*[@id=\"homepage\"]/header/div[2]/div/nav/ul/li[8]/a");

	public WebElement login() {
		return driver.findElement(loginbutton);
		
	}
	public WebElement gettext() {
		return driver.findElement(text);
	}
	
	public WebElement contact() {
		return driver.findElement(contact);
	}
}

