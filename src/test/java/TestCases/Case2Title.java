 


package TestCases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Components.HomePage;
import PageObjects.Firstpage;
import PageObjects.LoginPage;
public class Case2Title extends HomePage{
	public WebDriver driver;
	@BeforeTest
	public void ini() throws IOException {
		driver = initialization();
		
	}
	@Test
	public void FeaturedCourse() throws IOException {
		
		driver.get(prop.getProperty("url"));
		Firstpage fp = new Firstpage(driver);
		Assert.assertEquals(fp.gettext().getText(), "FEATURED123COURSES");
//		Assert.assertTrue(fp.contact().isDisplayed(), "SUCCESS");
		
	

	}
	
	@AfterTest
	public void end() {
		driver.close();
	}




	

}