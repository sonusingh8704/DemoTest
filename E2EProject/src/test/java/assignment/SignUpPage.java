package assignment;

import java.io.IOException;
import resources.CompanyInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import resources.base;

public class SignUpPage extends base {
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void DriverInitiation() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("signUpPageUrl"));
		log.info("navigated to signup page");
	}
	
	@Test
	public void SignUpPageNavigation() throws IOException, InterruptedException
	{
		//creating object to the class and invoking methods
		CompanyInfo fetchDetail = new CompanyInfo();
		LandingPage newObject = new LandingPage(driver);
		newObject.companyName().sendKeys(fetchDetail.getCompanyName());//entering the random company name
		newObject.countryName().sendKeys(prop.getProperty("country"));
		newObject.companyProfile().sendKeys(prop.getProperty("company"));
		newObject.numberOfEmployees().sendKeys(prop.getProperty("employees"));
		newObject.describeYourself().sendKeys(prop.getProperty("describe"));
		newObject.adminEmail().sendKeys(fetchDetail.getAdminEmail());//entering the randon admin email
		newObject.adminEmail().getText();
		newObject.adminName().sendKeys(fetchDetail.getAminName()); // randon admin name
		newObject.adminPhone().sendKeys(fetchDetail.getAdminNumber());//random admin number
		newObject.linkSecurePassword().click(); //entering the secure password
		System.out.println("secure password is:  "+newObject.securePassword().getText());
		log.info("secured password has been saved");
		newObject.securePasswordButton().click(); 
		
		//selecting checkboxes
		newObject.checkBoxTermsAndConditions().click();
		newObject.checkBoxPrivacyPolicy().click();
		newObject.checkBoxPersonalData().click();
		
		//agreeing to terms and conditions
		newObject.linkTermsAndConditions().click();
		Thread.sleep(3000);
		newObject.termsAndConditionsButton().click();
		log.info("Terms and conditions have been accepted");

		
		//agreesing to policies
		newObject.linkPrivacyPolicy().click();
		newObject.scrollDown();
		newObject.privacyPolicyButton().click();
		
		//submitting details for signup
		//newObject.signUpSubmitButton().click();
		log.info("signup details has been submitted for account creation");
		
	}
		//validating the dashboard page
		
		@AfterTest(enabled = true)
		public void validate() throws InterruptedException
		{
			Thread.sleep(30000);
			
			log.error("validation has failed due to ..... reason");

			//validating url
			String currentUrl = driver.getCurrentUrl();
			Assert.assertEquals((prop.getProperty("signUpPageUrl")), currentUrl);
			
			//validateing dashboardpage
			Assert.assertTrue(driver.findElement(By.cssSelector("a[href*='/dashboard/view']")).isDisplayed());
			
			//closing the window
			driver.close();
		}
		
		
		

	

}
