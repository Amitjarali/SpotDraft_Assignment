package genericutility;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pomrepository.SignupPage;
import pomrepository.UpdatesPage;

public class BaseClass {

	public WebDriver driver;
	public FileUtility fileUtils = new FileUtility();
	@BeforeClass
	public void openBrowser() throws IOException {
	String	browsername=fileUtils.toReadData("browsername");
	if(browsername.equalsIgnoreCase("chrome")){
		driver = new ChromeDriver();
	}else if(browsername.equalsIgnoreCase("edge")) {
		driver= new EdgeDriver();
	}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@BeforeMethod
	public void login() throws IOException {
		String url = fileUtils.toReadData("url");
		driver.get(url);
		SignupPage s = new SignupPage(driver);
		String email = fileUtils.toReadData("mailid");
		String password = fileUtils.toReadData("password");
		s.getSignInLink().click();
		s.getSignInWithEmail().click();
		s.getEmailTbx().sendKeys(email);
		s.getPwdTbx().sendKeys(password);
		s.getSignInBtn().click();
		
		// if application is asking for captcha

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.titleIs("Recent updates | Goodreads"));
	}

	@AfterMethod
	public void logout() {
		UpdatesPage r = new UpdatesPage(driver);
		r.getSignOutTab().click();
		r.getSignOutBtn().click();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
