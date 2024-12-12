package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass 
{
	@Test(groups = { "regression","master"})
	public void verify_account_registration() 
	{
		logger.info("*****Starting TC001_AccountRegistrationTest*****");
		try 
		{
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*****Clicked On My Account Link*****");
			hp.clickRegister();
			logger.info("*****Clicked On Register Link*****");
			AccountRegistrationPage ar = new AccountRegistrationPage(driver);
			logger.info("*****Providing Customer Details*****");
			ar.setFirstName(randomString().toUpperCase());
			ar.setLastName(randomString().toUpperCase());
			ar.setEmailId(randomString() + "@gmail.com");
			ar.setPhNo(randomNumber());

			String password = randomAlphaNumeric();
			ar.setPassword(password);
			ar.setCnfPassword(password);

			ar.setPrivacyPolicy();
			ar.clickContinue();
			logger.info("*****Validating expected message*****");
			String cnfMsg = ar.getConfirmationMsg();
			if(cnfMsg.equals("Your Account Has Been Created!"))
			{
				Assert.assertTrue(true);
			}
			else
			{
				logger.error("*****Test Failed*****");
				logger.debug("*****Debug logs*****");
				Assert.assertTrue(false);
			}
			//Assert.assertEquals(cnfMsg, "Your Account Has Been Created!");
		} 
		catch (Exception e) 
		{
			
			Assert.fail();
		}
	}

}
