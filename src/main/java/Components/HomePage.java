package Components;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class HomePage {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialization() throws IOException {
		// TODO Auto-generated method stub
		prop= new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\data.Properties");
		prop.load(fis);
		
		//String browser= System.getProperty("browser");
		String browser= prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equalsIgnoreCase("chrome")){
			
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();
		}
		
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "\\src\\main\\resources\\geckodriver-v0.29.1-win32\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		else{
			System.setProperty("webdriver,ie.driver", "C:\\Users\\Admin\\Downloads\\IEDriverServer_Win32_3.150.1\\IEDriverServer.exe");
			 driver = new InternetExplorerDriver();
			
		}
		return driver;
	}

public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
	TakesScreenshot ts= (TakesScreenshot)driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
	String destination = System.getProperty("user.dir")+ "\\reports\\" +testCaseName+ ".png";
	FileUtils.copyFile(src, new File(destination));
	return destination;
	
}
}
