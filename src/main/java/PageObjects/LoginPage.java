package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	By mailid= By.id("user_email");
	By pwd= By.id("user_password");
	By submit= By.name("commit");
	By forgotpwd= By.xpath("//*[@id=\"hero\"]/div/form/div[4]/a");


	public WebElement emailId() {
		return driver.findElement(mailid);
	}
	public WebElement password() {
		return driver.findElement(pwd);
	}

	public WebElement submitbtn() {
		return driver.findElement(submit);
	}
	public ResetPwdPage forgotpwd() {
		driver.findElement(forgotpwd).click();
		ResetPwdPage rp = new ResetPwdPage(driver);
		return rp;
	}

}
