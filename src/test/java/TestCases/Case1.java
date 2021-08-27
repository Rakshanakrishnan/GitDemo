package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Components.HomePage;
import PageObjects.Firstpage;
import PageObjects.LoginPage;
import PageObjects.ResetPwdPage;



public class Case1 extends HomePage {
public WebDriver driver;
	public static Logger log=LogManager.getLogger(HomePage.class.getName());
	@BeforeTest
	public void ini() throws IOException {
		driver = initialization();
		driver.get(prop.getProperty("url"));
		 
	}
	@Test(dataProvider = "getData")
	public void Data(String username, String pwd) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Logged in successfully");
		Firstpage fp = new Firstpage(driver);
		fp.login().click();
		LoginPage lp= new LoginPage(driver);
		System.out.println("hello");
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		lp.emailId().sendKeys(username);
		lp.password().sendKeys(pwd);
		lp.submitbtn().click();
		log.info("Successfully login page credentials given");
		ResetPwdPage rp=lp.forgotpwd();
		rp.mail().sendKeys("hhshs");
		rp.btn().click();
	}
	
	

	@DataProvider(name = "getData")

	public static Object[][] getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "abc@gmail.com";
		data[0][1] = "12345";

		data[1][0] = "def@gmail.com"; 
		data[1][1] = "45678";
		 

		return data;

	}
	@AfterTest
	public void end() {
		driver.close();
	}

}