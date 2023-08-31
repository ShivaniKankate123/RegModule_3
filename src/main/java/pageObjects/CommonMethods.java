package pageObjects;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import resources.base;

public class CommonMethods  {

	private WebDriver driver;
	String url = "";
	int count;

	public CommonMethods(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void findBrokenLinks() throws InterruptedException {
		Thread.sleep(12000);
		// Storing the links in a list and traversing through the links
		List<WebElement> links = driver.findElements(By.tagName("a"));
		// This line will print the number of links and the count of links.
		System.out.println("No of links are " + links.size());
		System.out.println("Total No of links Present on this webpage as below");
		for (int i = 0; i < links.size(); i++) {
			System.out.println(links.get(i).getText());
		}
		System.out.println("***********************************************************************************");
		// checking the Brokenlinks fetched.
		for (int i = 0; i < links.size(); i++) {
			WebElement E1 = links.get(i);
			String url = E1.getAttribute("href");
			if (url == null || url.isEmpty()) {
				String BrokenLink = E1.getText();
				System.out.println("BrokenLink present on this webpage:" + BrokenLink);
			}
		}
		System.out.println("***********************************************************************************");
	}
	public void scroll(WebElement element, String scrollType, String elementName) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			switch (scrollType) {
			case "scrollToElement":
				js.executeScript("arguments[0].scrollIntoView();", element);
				break;
			case "scrollToBottomOFPage":
				js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
				break;
			case "scrollToTopOFPage":
				js.executeScript("window.scrollTo(0, -document.body.scrollHeight);");
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail();
		}
	}
	public void click2(WebElement element, String clickType, String elementName) {

		try {
			switch (clickType) {
			case "seleniumClick":
				element.click();
				break;
			case "javascriptClick":
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
				break;
			case "moveToElementClick":
				Actions actions = new Actions(driver);
				actions.moveToElement(element).click().perform();
//				actions.doubleClick(element).perform();
//				actions.perform();
//				actions.click();
				break;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			Assert.fail();
		}
	}
	

}
