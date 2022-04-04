package testCases;



import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;


import pageObjects.Homepage;
import pageObjects.RegisteringAccount;
import testBase.BaseClass;

public class TC001_RegisteringAccount extends BaseClass {
	
	
	@Test(groups= {"regression","master"})
	public void testcaseRegisteringAccount() throws IOException
	{
		
		logger.info("Starting TC001_RegisteringAccount");
		
		try 
		{
			driver.get(rb.getString("appURL"));
			logger.info("Home Page Displayed ");
		
		driver.manage().window().maximize();
		
		Homepage hp=new Homepage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My Account ");
		hp.clickRegister();
		logger.info("Clicked on Register ");
		
		
		RegisteringAccount ra=new RegisteringAccount(driver);
		ra.setFirstName("Rajesh");
		logger.info("Provided First Name ");
		
		ra.setLastName("Gorantla");
		logger.info("Provided Last Name ");
		
		ra.setEmail(randomestring()+"@gmail.com");
		logger.info("Provided Email ");
		
		ra.setTelephone("8758759878");
		logger.info("Provided Telephone ");
		
		ra.setPassword("12345");
		logger.info("Provided Password ");
		
		ra.setConPassword("12345");
		logger.info("Provided Confrmed Password ");
		
		ra.setPrivacyPolicy();
		logger.info("Set Privacy Policy ");
		
		ra.setContinue();
		logger.info("Clicked on Continue ");
		
		String conmsg=ra.getConfirmationMsg();
		
		if(conmsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Account Registration Success ");
			Assert.assertTrue(true);
			
		}
		else
		{
			logger.fatal("Account Registration Failed ");
			captureScreen(driver, "testcaseRegisteringAccount"); //Capturing screenshot
			Assert.assertTrue(false);
		}
		}
		catch(Exception e) 
		{
			
			logger.fatal("Account Registration Failed ");
			captureScreen(driver, "testcaseRegisteringAccount"); //Capturing screenshot
			Assert.fail();
		}
		
		
		logger.info(" Finished TC001_RegisteringAccount ");
				
	}
	
	
	
	
}
