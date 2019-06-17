package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "src/main/java/driver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browserName.equals("firefox"))
		{
			//here we can add code for the firefox or any other browser as required
		}
	
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String dest=System.getProperty("user.dir") + "\\target\\screenshots\\"+result+ System.currentTimeMillis()+".png";
		File destPath = new File(dest);
		FileUtils.copyFile(src, destPath);
		
	}

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	

}
