package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountLoginPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_AccountLoginDataDrivenTesting extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class,groups = "datadriven") // getting data provider from different
																				// CLASS
	public void verify_account_login_data_driven_testing(String email, String pwd, String exp_res) {
		logger.info("*****Starting TC003_AccountLoginDataDrivenTesting*****");

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
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogin();

			// MY ACCOUNT PAGE
			MyAccountPage map = new MyAccountPage(driver);
			boolean targetPage = map.isMyAccountPageExists();

			// Data is valid - login success - test pass - logout
			// login failed - test fail
			if (exp_res.equalsIgnoreCase("Valid")) {
				if (targetPage == true) {
					map.clickLogout();
					Assert.assertTrue(true);
				} else {
					Assert.assertTrue(false);
				}
			}

			// Data is invalid - login success - test failed - logout
			// login failed - test pass
			if (exp_res.equalsIgnoreCase("invalid")) {
				if (targetPage == true) {
					map.clickLogout();
					Assert.assertTrue(false);
				} else {
					Assert.assertTrue(true);
				}
			}
		} catch (Exception e) {
			Assert.fail();
		}
		logger.info("*****Finished TC003_AccountLoginDataDrivenTesting");
	}

}
