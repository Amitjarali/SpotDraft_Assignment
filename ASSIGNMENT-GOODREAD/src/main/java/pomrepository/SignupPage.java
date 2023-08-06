package pomrepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupPage {

	@FindBy(linkText = "Sign In")
	private WebElement signInLink;
	@FindBy(xpath = "//button[normalize-space()='Sign in with email']")
	private WebElement signInWithEmail;
	@FindBy(name = "email")
	private WebElement emailTbx;
	@FindBy(name = "password")
	private WebElement pwdTbx;
	@FindBy(id = "signInSubmit")
	private WebElement signInBtn;

	public SignupPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignInLink() {
		return signInLink;
	}

	public WebElement getSignInWithEmail() {
		return signInWithEmail;
	}

	public WebElement getEmailTbx() {
		return emailTbx;
	}

	public WebElement getPwdTbx() {
		return pwdTbx;
	}

	public WebElement getSignInBtn() {
		return signInBtn;
	}

}
