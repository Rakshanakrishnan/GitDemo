package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResetPwdPage {

	public WebDriver driver;

	public ResetPwdPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By mail = By.name("email");
	By Send_me_inst= By.name("commit");
	
	public WebElement mail() {
		return driver.findElement(mail);
	}

	public WebElement btn() {
		return driver.findElement(Send_me_inst);
	}
}

