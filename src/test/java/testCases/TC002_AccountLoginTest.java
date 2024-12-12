package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	@Test(groups = {"sanity","master"})
	public void verify_account_login() {
		logger.info("*****Starting TC002_AccountLoginTest*****");

		try {
			// HOME PAGE
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			logger.info("*****Clicked On My Account Link*****");
			hp.clickLogin();
			logger.info("*****Clicked On Login Link*****");

			// LOGIN PAGE
			AccountLoginPage lp = new AccountLoginPage(driver);
			logger.info("*****Providing Customer Details*****");
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogin();

			// MY ACCOUNT PAGE
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();
			Assert.assertTrue(targetPage);
		} 
		catch (Exception e) 
		{
			Assert.fail();
		}
		logger.info("*****Finished TC002_AccountLoginTest");
	}

}
