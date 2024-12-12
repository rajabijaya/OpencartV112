package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement txtFirstName;

	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement txtLastName;

	@FindBy(xpath = "//input[@id='input-email']")
	WebElement txtEmailId;

	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement txtPhNo;

	@FindBy(xpath = "//input[@id='input-password']")
	WebElement txtPassword;

	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement txtCnfPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement btnAgree;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement btnContinue;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") //// input[@value='Continue']
	WebElement msgConfirmation;

	public void setFirstName(String fname) {
		txtFirstName.sendKeys(fname);
	}

	public void setLastName(String lname) {
		txtLastName.sendKeys(lname);
	}

	public void setEmailId(String emailid) {
		txtEmailId.sendKeys(emailid);
	}

	public void setPhNo(String phonenumber) {
		txtPhNo.sendKeys(phonenumber);
	}

	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}

	public void setCnfPassword(String cnfpassword) {
		txtCnfPassword.sendKeys(cnfpassword);
	}

	public void setPrivacyPolicy() {
		btnAgree.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String getConfirmationMsg() {
		try {
			return (msgConfirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}

	}

}
