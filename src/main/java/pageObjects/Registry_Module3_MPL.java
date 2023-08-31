package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import resources.ObjectRepo;
import resources.base;

public class Registry_Module3_MPL extends base{
	public WebDriver driver;
	CommonMethods demo = new CommonMethods(driver);
	publicHomePage sc;
	JavascriptExecutor js;
	
	public Registry_Module3_MPL(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	@FindBy(xpath ="//p[@class=\"MuiTypography-root MuiTypography-body1 css-rgrsvq\"]")
	WebElement ClickOnAllJurisdictions;
	@FindBy(xpath="(//*[@class=\"MuiSvgIcon-root MuiSvgIcon-fontSizeMedium dot-icon css-1ylescl\"])[2]")
	WebElement ClickOnNSThreeDotsMenu;
	@FindBy(xpath="//p[text()=\"MANAGE PURCHASE LIMIT\"]")
	WebElement CLickOnManagePurchaseLimit;
	@FindBy(xpath="//button[text()=\"EDIT\"]")
	WebElement ClickOnEdit;
	@FindBy(xpath="//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"]")
	List <WebElement> CurrentPurchaseLimitPer;
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[1]")
	WebElement CurrentPurchaseLimitPer1;
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[2]")
	WebElement FuturePurchaseLimitPer1;
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[3]")
	WebElement CurrentPurchaseLimitPer2;
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[4]")
	WebElement FuturePurchaseLimitPer2;
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[5]")
	WebElement CurrentPurchaseLimitPer3;
	@FindBy(xpath="(//input[@class=\"MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq\"])[6]")
	WebElement FuturePurchaseLimitPer3;
	@FindBy(xpath = "//button[@data-testid='submit_btn']")
	WebElement SubmitButton;
	@FindBy(xpath="//button[@data-testid=\"cancel_btn\"]")
	WebElement Cancel_Button;
	@FindBy(xpath = "//h6[text()=\"Warning!\"]")
	WebElement WarningPopup;
	@FindBy(xpath="//button[@data-testid=\"priv_modal_Cancel\"]")
	WebElement CancelButtonOnPopup;
	@FindBy(xpath="//button[@data-testid=\"priv_modal_Continue\"]")
	WebElement ContinueButtonOnPopup;
	@FindBy(xpath="//h1[text()=\"Manage Purchase Limits\"]")
	WebElement ManagePLText;
	@FindBy(xpath="(//p[@class=\"MuiTypography-root MuiTypography-body2 css-j4m1we\"])[2]")
	WebElement CurrentPurchaseLimitPer1Value;
	@FindBy(xpath="//a[text()=\"View Purchase Limits\"]")
	WebElement NavigateToViewPurchaseLimits;
	@FindBy(xpath="//button[@data-testid=\"more-actions\"]")
	WebElement MoreActions;
	@FindBy(xpath="//p[@class=\"MuiTypography-root MuiTypography-body1 css-11npd1\"]")
	WebElement EditPurchaseLimit;
	@FindBy(xpath="(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[2]")
	WebElement Checkbox;
	@FindBy(xpath="//input[@id=\"selectedValuesCurrent-react-hook-form-select-search\"]")
	WebElement CurrentVintagePurchaseLimitPerDropDown;
	@FindBy(xpath="//input[@id=\"selectedValuesFuture-react-hook-form-select-search\"]")
	WebElement FutureVintagePurchaseLimitPerDropDown;
	@FindBy(xpath="//button[text()=\"SUBMIT\"]")
	WebElement SubmitButtonForReg;
	@FindBy(xpath="//h2[text()=\"Edit Purchase Limit\"]")
	WebElement EditPurchaseLimitSection;
	@FindBy(xpath="//h6[text()=\"Confirmation!\"]")
	WebElement ConfirmationPopup;
	@FindBy(xpath="//button[@data-testid=\"priv_btn_Reset\"]")
	WebElement CancelButtonOnConfirmationPopup;
	@FindBy(xpath="//button[@data-testid=\"priv_btn_Search\"]")
	WebElement ContinueButtonOnConfirmationPopup;
	@FindBy(xpath="//p[contains(text(),'have been updated')]")
	WebElement SuccessPopup;
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-5zd7v5\"]")
	WebElement SuccessPopupClose;
	@FindBy(xpath="(//div[@data-field=\"currentPurchaseLimit\"])[2]")
	WebElement CurrentPLPreviousVal;
	@FindBy(xpath="(//div[@data-field=\"futurePurchaseLimit\"])[2]")
	WebElement FuturePLPreviousVal;
	@FindBy(xpath = "//*[text()=\"Browse Files\"]")
	WebElement ClickOnBrowseFiles;
	@FindBy(xpath = "//button[text()=\"Upload\"]")
	WebElement Upload;
	@FindBy(xpath="(//p[@class=\"MuiTypography-root MuiTypography-body1 css-7myxtt\"])[2]")
	WebElement UploadedFile;
	@FindBy(xpath = "//button[text()=\"CANCEL\"]")
	WebElement ClickCancelOnFileUpload;
	@FindBy(xpath="//div[text()=\"Edit Purchase Limit - Uploaded File\"]")
	WebElement EditPlUploadFileCard;
	@FindBy(xpath = "//p[text()=\"Upload Files\"]")
	WebElement UploadFilesPopUp;
	@FindBy(xpath="(//p[@class=\"MuiTypography-root MuiTypography-body1 css-1195g5e\"])[1]")
	WebElement FiveMbError;
	@FindBy(xpath = "//input[@id=\"passphrase\"]")
	WebElement PasspharseEnter;
	@FindBy(xpath="(//button[text()=\"SUBMIT\"])[2]")
	WebElement SubmitButtonOnPassphrase;
	@FindBy(xpath="//p[contains(text(),'record(s) have been updated')]")
	WebElement SuccessPopupAfterFileUpload;
	@FindBy(xpath = "//h6[text()=\"Success!\"]")
	WebElement SuccessMessage;
	@FindBy(xpath ="//h6[text()=\"Error!\"]")
	WebElement ErrorMessage;
	

	
	public void Navigate_to_Manage_Purchase_Limit_NS() throws Exception {
		Thread.sleep(2000);
		ClickOnAllJurisdictions.click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		Thread.sleep(2000);
		ClickOnNSThreeDotsMenu.click();
		Thread.sleep(2000);
		CLickOnManagePurchaseLimit.click();
	}
	
	public void Edit_Current_and_Future_vintage_Purchase_Limit_Per() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnEdit));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ClickOnEdit);
		Thread.sleep(2000);
		for(WebElement currentpl:CurrentPurchaseLimitPer)
		{
			Assert.assertEquals(currentpl.isEnabled(), true);
			ObjectRepo.test.log(Status.PASS, "The Current and Future vintage Purchase Limit % fields (for all entity types) are displayed in editable mode with existing values.");
			ObjectRepo.test.log(Status.PASS, "Existing Value " + currentpl.getAttribute("value"));
		}
		Thread.sleep(3000);
//		int size = val.length();
//		Thread.sleep(3000);
//		for (int i = 1; i <= size; i++) {
//			CurrentPurchaseLimitPer1.sendKeys(Keys.BACK_SPACE);
//		}
//		Thread.sleep(2000);
		CurrentPurchaseLimitPer1.clear();
		Thread.sleep(2000);
		CurrentPurchaseLimitPer1.sendKeys("20");
		ObjectRepo.test.log(Status.PASS, "User is able to edit the fields");
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Thread.sleep(2000);
		Assert.assertEquals(SubmitButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit button is enabled");
	}
	
	public void Submit_Button_Of_Edit_Current_and_Future_vintage_Purchase_Limit_Per() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnEdit));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ClickOnEdit);
		Thread.sleep(2000);
		for(WebElement currentpl:CurrentPurchaseLimitPer)
		{
			Assert.assertEquals(currentpl.isEnabled(), true);
			ObjectRepo.test.log(Status.PASS, "The Current and Future vintage Purchase Limit % fields (for all entity types) are displayed in editable mode with existing values.");
			ObjectRepo.test.log(Status.PASS, "Existing Value " + currentpl.getAttribute("value"));
		}
		Thread.sleep(3000);
		CurrentPurchaseLimitPer1.clear();
		Thread.sleep(2000);
		Assert.assertEquals(SubmitButton.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit button is disabled");
		Thread.sleep(2000);
		CurrentPurchaseLimitPer1.sendKeys("23");
		Assert.assertEquals(SubmitButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit button is enabled");	
	}
	
	public void Cancel_Button_Of_Edit_Current_and_Future_vintage_Purchase_Limit_Per() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnEdit));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ClickOnEdit);
		Thread.sleep(2000);
		for(WebElement currentpl:CurrentPurchaseLimitPer)
		{
			Assert.assertEquals(currentpl.isEnabled(), true);
			ObjectRepo.test.log(Status.PASS, "The Current and Future vintage Purchase Limit % fields (for all entity types) are displayed in editable mode with existing values.");
			ObjectRepo.test.log(Status.PASS, "Existing Value " + currentpl.getAttribute("value"));
		}
		Thread.sleep(3000);
		String val1= CurrentPurchaseLimitPer1.getAttribute("value");
		CurrentPurchaseLimitPer1.clear();
		Thread.sleep(2000);
		CurrentPurchaseLimitPer1.sendKeys("23");
		Thread.sleep(2000);
		Cancel_Button.click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		Assert.assertEquals(CancelButtonOnPopup.isEnabled(), true);
		Assert.assertEquals(ContinueButtonOnPopup.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "A warning pop-up is displayed with CANCEL and CONTINUE buttons.");
		Thread.sleep(2000);
		CancelButtonOnPopup.click();
		Thread.sleep(2000);
		Assert.assertEquals(ManagePLText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The warning pop-up is closed and WCI Inc admin remains on the Manage Purchase Limits page.");
		Cancel_Button.click();
		Thread.sleep(2000);
		ContinueButtonOnPopup.click();
		Thread.sleep(2000);
		Assert.assertEquals(ManagePLText.isDisplayed(), true);
		String val2 = CurrentPurchaseLimitPer1Value.getText();
		Assert.assertEquals(val1, val2);
		ObjectRepo.test.log(Status.PASS,"Privious Data:- "+ val1 + " and " + "Current Data after click on continue" +val2);
	}
	
	public void Navigate_to_View_Purchase_Limits() throws Exception{
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(NavigateToViewPurchaseLimits));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", NavigateToViewPurchaseLimits);
	}
	
	public void Navigate_to_Edit_Purchase_Limits_Page_By_Per() throws Exception{
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", MoreActions);
		js.executeScript("arguments[0].click();", EditPurchaseLimit);
		Thread.sleep(4000);	
	}
	
	public void Submit_Button_On_PL_Page_Registrar() throws Exception{
		Thread.sleep(3000);
		Assert.assertEquals(Checkbox.isEnabled(), true);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(3000);
		Assert.assertEquals(CurrentVintagePurchaseLimitPerDropDown.isEnabled(), true);
		Assert.assertEquals(FutureVintagePurchaseLimitPerDropDown.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Manage Purchase limit page is in edit mode with 'View Purchase Limits' grid have a check box column and 'Edit Purchase Limit' card.");
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)", "");
		Thread.sleep(3000);
		Checkbox.click();
		Thread.sleep(2000);
		Assert.assertEquals(Checkbox.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "Entity is checked and selected.");
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		CurrentVintagePurchaseLimitPerDropDown.click();
		CurrentVintagePurchaseLimitPerDropDown.sendKeys(Keys.ARROW_DOWN);
		CurrentVintagePurchaseLimitPerDropDown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		FutureVintagePurchaseLimitPerDropDown.click();
		FutureVintagePurchaseLimitPerDropDown.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		Assert.assertEquals(CurrentVintagePurchaseLimitPerDropDown.isDisplayed(), true);
		Assert.assertEquals(FutureVintagePurchaseLimitPerDropDown.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Current and future holding limit is selected.");
		Thread.sleep(2000);
		Assert.assertEquals(SubmitButtonForReg.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit button is enabled");
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)", "");
		Thread.sleep(3000);
		Checkbox.click();
		Thread.sleep(3000);
		Assert.assertEquals(Checkbox.isSelected(), false);
		ObjectRepo.test.log(Status.PASS, "Checkbox is unchaked and No entity is selected.");
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		Assert.assertEquals(SubmitButtonForReg.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit button is disabled");
	}
	
	public void Edit_Purchase_Limit_Functionality() throws Exception{
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(3000);
		Assert.assertEquals(EditPurchaseLimitSection.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Edit Purchase Limit section is displayed.");
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)", "");
		Thread.sleep(3000);
		Checkbox.click();
		Thread.sleep(2000);
		String PriviousValOfCurrentPl = CurrentPLPreviousVal.getText();
		System.out.println("Privious Current Purchase Limit:- " +PriviousValOfCurrentPl);
		String PriviousValOfFuturePl = FuturePLPreviousVal.getText();
		System.out.println("Privious Future Purchase Limit:- " +PriviousValOfFuturePl);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(3000);
		CurrentVintagePurchaseLimitPerDropDown.click();
		CurrentVintagePurchaseLimitPerDropDown.sendKeys(Keys.ARROW_DOWN);
		CurrentVintagePurchaseLimitPerDropDown.sendKeys(Keys.ENTER);
		String UpdatedValOfCurrentPl = CurrentVintagePurchaseLimitPerDropDown.getAttribute("value");
		System.out.println("Updated Current Purchase Limit:- " +UpdatedValOfCurrentPl);
		Thread.sleep(2000);
		FutureVintagePurchaseLimitPerDropDown.click();
		FutureVintagePurchaseLimitPerDropDown.sendKeys(Keys.ENTER);
		String UpdatedValOfFuturePl = FutureVintagePurchaseLimitPerDropDown.getAttribute("value");
		System.out.println("Updated Future Purchase Limit:- " +UpdatedValOfFuturePl);
		Thread.sleep(3000);
		SubmitButtonForReg.click();
		Thread.sleep(2000);
		Assert.assertEquals(ConfirmationPopup.isDisplayed(), true);
		Assert.assertEquals(CancelButtonOnConfirmationPopup.isDisplayed(), true);
		Assert.assertEquals(ContinueButtonOnConfirmationPopup.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with CANCEL and CONTINUE buttons.");
		ContinueButtonOnConfirmationPopup.click();
		Thread.sleep(3000);
//		String NoOfRecords = SuccessPopup.getText();
//		System.out.println(NoOfRecords);
//		Assert.assertEquals(SuccessPopup.isDisplayed(), true);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String successpopup1 = SuccessMessage.getText();
		Thread.sleep(2000);
		Assert.assertEquals(successpopup1, "Success!");
		ObjectRepo.test.log(Status.PASS, "Success message is displayed" );
		Thread.sleep(2000);
		SuccessPopupClose.click();
		Thread.sleep(2000);
		Assert.assertEquals(ManagePLText.isDisplayed(), true);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		Assert.assertEquals(CurrentVintagePurchaseLimitPerDropDown.isEnabled(), true);
		Assert.assertEquals(FutureVintagePurchaseLimitPerDropDown.isEnabled(), true);
		Assert.assertEquals(SubmitButtonForReg.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "User is Remain on the same screen in Edit mode with Submit button disabled.");	
	}
	
	public void Cancel_Button_On_Upload_File() throws Exception{
		ClickOnBrowseFiles.click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT_MPL\\Valid Purchase Limit.exe");
		Thread.sleep(4000);
		Upload.click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		String Uploadedfile = UploadedFile.getText();
		ObjectRepo.test.log(Status.PASS, Uploadedfile +" is displayed in Edit Purchase Limit - Uploaded File card");
		Assert.assertEquals(Cancel_Button.isDisplayed(), true);
		Assert.assertEquals(SubmitButtonForReg.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Submit and Cancel buttons are displayed below the Edit Purchase Limit - Uploaded File card");
		Thread.sleep(2000);
		Cancel_Button.click();
		Assert.assertEquals(WarningPopup.isDisplayed(), true);
		Assert.assertEquals(CancelButtonOnPopup.isDisplayed(), true);
		Assert.assertEquals(ContinueButtonOnPopup.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Warning Pop Up is displayed with 'Cancel' and 'Submit' button");
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", CancelButtonOnPopup);
		Thread.sleep(2000);
		Assert.assertEquals(EditPlUploadFileCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Warning Pop Up is closed");
		Thread.sleep(2000);
		Cancel_Button.click();
		Thread.sleep(2000);
		js.executeScript("arguments[0].click();", ContinueButtonOnPopup);
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)", "");
		Thread.sleep(2000);
		Assert.assertEquals(ManagePLText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Uploaded file is removed and User is remain on same page.");	
	}
	
	public void Validation_Of_FileSize() throws Exception{
		Thread.sleep(2000);
		Assert.assertEquals(UploadFilesPopUp.isDisplayed(), true);
		Assert.assertEquals(ClickCancelOnFileUpload.isDisplayed(), true);
		Assert.assertEquals(Upload.isDisplayed(), true);
		Assert.assertEquals(ClickOnBrowseFiles.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "User is able to see file Upload Pop up ('Browse Files' Option) with 'Cancel' and 'Upload' options.");
		Thread.sleep(1000);
		ClickOnBrowseFiles.click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT_MPL\\Purchase Limit File More Than 5mb.exe");
		Thread.sleep(4000);
		String FileError = FiveMbError.getText();
		Assert.assertEquals(FileError, "File must be less than 5MB");
		ObjectRepo.test.log(Status.PASS, "File must be less than 5MB error message is displayed.");
		Thread.sleep(2000);
		ClickOnBrowseFiles.click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT_MPL\\Valid Purchase Limit.exe");
		Thread.sleep(4000);
		Upload.click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		String Uploadedfile = UploadedFile.getText();
		ObjectRepo.test.log(Status.PASS, Uploadedfile +" is displayed in Edit Purchase Limit - Uploaded File card");	
	}
	
	public void Validation_Comma_Excel_File() throws Exception{
		Thread.sleep(2000);
		Assert.assertEquals(UploadFilesPopUp.isDisplayed(), true);
		Assert.assertEquals(ClickCancelOnFileUpload.isDisplayed(), true);
		Assert.assertEquals(Upload.isDisplayed(), true);
		Assert.assertEquals(ClickOnBrowseFiles.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "User is able to see file Upload Pop up ('Browse Files' Option) with 'Cancel' and 'Upload' options.");
		Thread.sleep(1000);
		ClickOnBrowseFiles.click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT_MPL\\Purchase Limit Comma Seprated.exe");
		Thread.sleep(4000);
		Upload.click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		String Uploadedfile = UploadedFile.getText();
		ObjectRepo.test.log(Status.PASS, Uploadedfile +" is displayed in Edit Purchase Limit - Uploaded File card");
		SubmitButtonForReg.click();
		Thread.sleep(3000);
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(5000);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		SubmitButtonOnPassphrase.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		Assert.assertEquals(SuccessPopup.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Excel file having comma separated numbers is uploaded with a Success Message");
		Thread.sleep(2000);
		SuccessPopupClose.click();
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-700)", "");	
		Thread.sleep(3000);
	}
	
	public void Validation_Comma_Csv_File() throws Exception{
		Thread.sleep(2000);
		Assert.assertEquals(UploadFilesPopUp.isDisplayed(), true);
		Assert.assertEquals(ClickCancelOnFileUpload.isDisplayed(), true);
		Assert.assertEquals(Upload.isDisplayed(), true);
		Assert.assertEquals(ClickOnBrowseFiles.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "User is able to see file Upload Pop up ('Browse Files' Option) with 'Cancel' and 'Upload' options.");
		Thread.sleep(1000);
		ClickOnBrowseFiles.click();
		Thread.sleep(4000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT_MPL\\MPL csv.exe");
		Thread.sleep(4000);
		Upload.click();
		Thread.sleep(2000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		String Uploadedfile = UploadedFile.getText();
		ObjectRepo.test.log(Status.PASS, Uploadedfile +" is displayed in Edit Purchase Limit - Uploaded File card");
		SubmitButtonForReg.click();
		Thread.sleep(3000);
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(5000);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		Thread.sleep(5000);
		SubmitButtonOnPassphrase.click();
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ErrorMessage));
		Assert.assertEquals(ErrorMessage.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, ".csv file having comma separated numbers is not accepted and error message is displayed.");
	}
	
}