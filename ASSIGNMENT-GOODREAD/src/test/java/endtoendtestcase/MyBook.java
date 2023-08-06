package endtoendtestcase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericutility.BaseClass;
import pomrepository.UpdatesPage;

public class MyBook extends BaseClass{
	
	@Test
	public void testAddAndRemoveBook() throws Throwable
	{
		UpdatesPage page = new UpdatesPage(driver);
		String book = fileUtils.toReadData("bookname");
		page.getSearchBox().sendKeys(book);
		page.getBook().click();
		Actions action =new Actions(driver);
		WebElement wantToRead = page.getWantToReadBtn();
		action.doubleClick(wantToRead).perform();
		Thread.sleep(10000);
		WebElement closeBtn = page.getPopupCloseBtn();
		action.doubleClick(closeBtn).perform();
		page.getMyBookTab().click();
		page.getRemoveBookBtn().click();
		driver.switchTo().alert().accept();
	}
}

