package resources;

import org.apache.commons.lang3.RandomStringUtils;

public class CompanyInfo extends base {
	
	String companyName;
	
	String adminName;
	String adminEmail;
	String adminNumber;

	
	public String getCompanyName() 
	{
		return companyName = RandomStringUtils.randomAlphabetic(7);
		
	}
	
	public String getAminName() 
	{
		 return adminName= RandomStringUtils.randomAlphabetic(5)+" "+RandomStringUtils.randomAlphabetic(5);
	}
	
	public String getAdminEmail() 
	{
		adminEmail=RandomStringUtils.randomAlphabetic(5)+"@gmail.com";
		System.out.print("Admin Email is:   "+adminEmail+"@gmail.com");
		return adminEmail;
	}
	
	public String getAdminNumber() 
	{
		return adminNumber=RandomStringUtils.randomNumeric(10);
	}
	


}
