package pomrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdatesPage {

	@FindBy(xpath = "//input[@class='searchBox__input searchBox__input--navbar']")
	private WebElement searchBox;
	@FindBy(xpath = "//div[text()='Godgift: A Godly Child']")
	private WebElement book;
	@FindBy(xpath = "(//button[@class='Button Button--wtr Button--medium Button--block' and @type = 'button'] )[1]")
	private WebElement wantToReadBtn;
	@FindBy(xpath = "//a[text()='My Books']")
	private WebElement myBookTab;
	@FindBy(xpath = "//img[@title='Remove from my books']")
	private WebElement removeBookBtn;
	@FindBy(xpath = "//span[@class=\"headerPersonalNav__icon\"]")
	private WebElement signOutTab;
	@FindBy(linkText = "Sign out")
	private WebElement signOutBtn;

	@FindBy(xpath = "//i[@class='Icon CloseIcon']")
	private WebElement popupCloseBtn;

	public WebElement getPopupCloseBtn() {
		return popupCloseBtn;
	}

	public WebElement getSignOutTab() {
		return signOutTab;
	}

	public WebElement getSignOutBtn() {
		return signOutBtn;
	}

	public UpdatesPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getBook() {
		return book;
	}

	public WebElement getWantToReadBtn() {
		return wantToReadBtn;
	}

	public WebElement getMyBookTab() {
		return myBookTab;
	}

	public WebElement getRemoveBookBtn() {
		return removeBookBtn;
	}

}
