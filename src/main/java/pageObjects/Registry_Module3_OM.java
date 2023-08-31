package pageObjects;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import resources.ObjectRepo;

public class Registry_Module3_OM {
	
	private WebDriver driver;
	JavascriptExecutor js;
	CommonMethods CM;
	WebDriverWait wait;
	String VerificationBody;
	String OffsetProjectName;
	String OffsetProjectOperator;
	String editedOffsetProjectName;
	String editedOffsetProjectOperator;
	String editedVerificationBody;
	Registry_Module3_MCII MCII;
	Actions actions;
	
	@FindBy(xpath = "//a[text()='HOME']")
	WebElement HomeMenu;
	@FindBy(xpath = "//h1[@class='MuiTypography-root MuiTypography-h1 css-1l7rfk3']")
	WebElement AddOMPageTitle;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-1yfaah8']")
	WebElement AddOffsetMangement;
	
	//Home Page
	@FindBy(xpath = "//a[text()='Offset Project Name Management']")
	WebElement OffsetProjectNameManagementLable;
	@FindBy(xpath = "//a[text()='Verification Body Management']")
	WebElement VerificationBodyManagementLable;
	@FindBy(xpath = "//a[text()='Offset Project Operator Management']")
	WebElement OffsetProjectOperatorManagementLable;
	
	//Verification Body Management Page
	@FindBy(xpath = "//h1[text()='Verification Body Management']")
	WebElement VerificationBodyManagementTitle;
	@FindBy(xpath = "//button[text()='MORE ACTIONS']")
	WebElement MoreActionBtn;
	@FindBy(xpath = "//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz']")
	WebElement SearchInput;
	@FindBy(xpath = "(//div[@data-field='offset_verification_body'])[2]")
	WebElement FirstOffsetVerificationBody;
	
	//Offset Project Name management page
	@FindBy(xpath = "(//div[@data-field='offset_project_name'])[2]")
	WebElement FirstOffsetProjectName;
	@FindBy(xpath = "//h1[text()='Offset Project Name Management']")
	WebElement OffsetProjectNameManagementTitle;
	@FindBy(xpath = "(//div[@data-field='display_in_drop_down'])[2]")
	WebElement FirstDisplayInDropdownRow;
	@FindBy(xpath = "(//span[@class='css-1pqd204'])[1]")
	WebElement Stop_DisplayInDropdownRow_SubMenu;
	@FindBy(xpath = "(//span[@class='css-1pqd204'])[2]")
	WebElement Edit_SubMenu;
	@FindBy(xpath = "(//div[@data-field='quickactions'])[2]")
	WebElement QuickAction;
	@FindBy(xpath = "//h6[text()='Confirm']")
    WebElement ConfirmPopUpText;
	@FindBy(xpath = "//div[contains(@class,'MuiDataGrid-columnHeader MuiDataGrid-columnHeader--sortable')]")
	List<WebElement> TableColumns;
	@FindBy(xpath = "//div[text()='Quick Actions']")
    WebElement QuickActionColumn;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[1]")
    WebElement SampleTextCard;
	@FindBy(xpath = "//h2[text()='Offset Project Name']")
    WebElement TableTitle;
	
	
	//Edit Offset Project Name page
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[1]")
    WebElement EditedRecord_HistoryTable;
	
	
	//Offset Project Operator Management page
	@FindBy(xpath = "//h1[text()='Offset Project Operator Management']")
	WebElement OffsetProjectOperatorManagementTitle;
	@FindBy(xpath = "(//div[@data-field='offset_project_operator'])[2]")
	WebElement FirstOffsetProjectOperator;
	//Add Verification Body Page
	@FindBy(xpath = "//input[@data-testid='verificationBody']")
	WebElement VerificationBodyInputField;
	@FindBy(xpath = "//button[@data-testid='submitBtn']")
	WebElement SubmitBtn;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Search']")
	WebElement ConfirmBtnPopUp;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 css-1eifdk0']")
	WebElement SuccessMsg;
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-5zd7v5']")
	WebElement SuccessCancel;
	
	//Add Offset Project Name
	@FindBy(xpath = "//input[@data-testid='offsetProjectName']")
	WebElement OffsetProjectnameInputField;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[1]")
	WebElement sampleTextCard;	
	@FindBy(xpath = "//div[@class='MuiTypography-root MuiTypography-h2 css-11brs9n']")
	WebElement AddOffsetProjectNameCardLabel;	
	@FindBy(xpath = "//label[text()='Offset Project Name']")
	WebElement OffsetProjectNameFieldLabel;
//	@FindBy(xpath = "//*[@data-testid='CheckBoxIcon']")
	@FindBy(xpath = "//input[@name='displayInDropDown']") // Checked
	WebElement CheckBox;
	@FindBy(xpath = "(//*[@class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv'])[1]")
	WebElement CheckBox2;
	@FindBy(xpath = "//p[text()='Display in Dropdown']")
	WebElement DisplayInDropDownLabel;
	@FindBy(xpath = "//button[@data-testid='cancelBtn']")
	WebElement CancelBtn;
	@FindBy(xpath = "//h6[text()='Warning!']")
	WebElement ConfirmPopUP_cancel;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Cancel']")
	WebElement CancelBtn_PopUp;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Continue']")
	WebElement ContinueBtn_PopUp;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Reset']")
	WebElement CancelBtn_SubmitPopUp;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Search']")
	WebElement ContinueBtn_SubmitPopUp;
	
	//Add Offset Project Operator
	@FindBy(xpath = "//input[@data-testid='offsetProjectOperator']")
	WebElement OffsetProjectOperatorInputField;	
	@FindBy(xpath = "//div[text()='Add Offset Project Operator']")
	WebElement AddOffsetProjectOperatorCardTitle;	
	@FindBy(xpath = "//label[text()='Offset Project Operator']")
	WebElement OffsetProjectOperatorLabel;
	
	
	public Registry_Module3_OM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public static String generateRandomString(String start, String Last) {
		int length = 3;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useNumbers, useLetters);
		String randomString = (start + generatedString + Last);
		return randomString;
	}
	
	public void navigateToVerificationBodyManagement() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			VerificationBodyManagementLable.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(VerificationBodyManagementLable, "javascriptClick", "VerificationBodyManagementLable");
		}
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Operator Management");
	}
	
	public void verifyQuickAction_VerificationBodyManagement() throws Exception {
		navigateToVerificationBodyManagement();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		if(FirstDisplayInDropdownRow.getText().equals("Yes")) {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "STOP DISPLAY IN DROPDOWN");
			Assert.assertEquals(Edit_SubMenu.getText(), "EDIT");
			ObjectRepo.test.log(Status.PASS, "Edit and STOP DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'Yes' ");
		}
		else {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "DISPLAY IN DROPDOWN");
			Assert.assertEquals(Edit_SubMenu.getText(), "EDIT");
			ObjectRepo.test.log(Status.PASS, "Edit and DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'No' ");
		}
	}
	
	public void navigateAddVerificationBody() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionBtn));
		MoreActionBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(AddOffsetMangement));
		AddOffsetMangement.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Add Verification Body");
		ObjectRepo.test.log(Status.PASS, "User navigated to Add Verification Body Page");
	}
	
	public void verifyCancelBtn_AddVerificationBody() throws Exception {
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(VerificationBodyInputField));
		VerificationBodyInputField.sendKeys("VerificationBody");
		String VerificationBody = VerificationBodyInputField.getAttribute("value");
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			CancelBtn.click();
		}
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button.");
		Assert.assertEquals(ConfirmPopUP_cancel.isDisplayed(), true);
		Assert.assertEquals(CancelBtn_PopUp.isEnabled() && ContinueBtn_PopUp.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons after clicking on Cancel button of Add Verification Body Page");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button of Cancel Confirmation pop-up.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and  Jurisdiction Admin user is navigated to the ' Add Verification Body' screen");
		String VerificationBody2 = VerificationBodyInputField.getAttribute("value");
		Assert.assertEquals(VerificationBody.equals(VerificationBody2), true);
		ObjectRepo.test.log(Status.PASS, "Entered data by Jurisdiction Admin is remain as it is.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			CancelBtn.click();
		}
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button.");
		ContinueBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Click on Continue button of Cancel Confirmation pop-up.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(VerificationBodyManagementTitle));
		Assert.assertEquals(VerificationBodyManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and All the entered  values is cleared and Jurisdiction Admin user is navigated to Verification Body Management page");
	}
	
	public void addVerificationBody() throws Exception {
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(VerificationBodyInputField));
		VerificationBodyInputField.sendKeys(generateRandomString("Verification","Body"));
		String verificationBodyValue = VerificationBodyInputField.getAttribute("value");
		System.out.println(verificationBodyValue);
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmBtnPopUp));
		ConfirmBtnPopUp.click();
		wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "You have successfully added the verification body");
		ObjectRepo.test.log(Status.PASS, "Verification Body created Successfully");
		SuccessCancel.click();	
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(verificationBodyValue);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			actions = new Actions(driver);
			actions.moveToElement(SearchInput).click().build().perform();
			SearchInput.sendKeys(verificationBodyValue);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(FirstOffsetVerificationBody));
		VerificationBody = FirstOffsetVerificationBody.getText();
		Assert.assertEquals(VerificationBody.equals(verificationBodyValue), true);
	}
	
	public void addVerificationBody_UncheckDisplayInDropdown() throws Exception {
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(VerificationBodyInputField));
		VerificationBodyInputField.sendKeys(generateRandomString("Verification","Body"));
		String VerificationBodyValue = VerificationBodyInputField.getAttribute("value");
//		Assert.assertEquals(CheckBox.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "By default, 'Display in Dropdown' checkbox is checked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CheckBox2));
		try {
			CheckBox2.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CheckBox2).click().build().perform();
		}
		ObjectRepo.test.log(Status.PASS, "Unchecked the Displayed In Dropdown Checkbox");
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			actions = new Actions(driver);
			actions.moveToElement(SubmitBtn).click(SubmitBtn).build().perform();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ConfirmBtnPopUp));
		ConfirmBtnPopUp.click();
		wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "You have successfully added the verification body");
		ObjectRepo.test.log(Status.PASS, "Verification Body created Successfully");
		SuccessCancel.click();	
		Thread.sleep(2000);
		try {
			SearchInput.sendKeys(VerificationBodyValue);
		} catch (Exception e) {
			actions = new Actions(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			actions.moveToElement(SearchInput).build().perform();
			SearchInput.sendKeys(VerificationBodyValue);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(FirstOffsetVerificationBody));
		VerificationBody = FirstOffsetVerificationBody.getText();
		
		Assert.assertEquals(VerificationBody.equals(VerificationBodyValue), true);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Verification Body’ table");
	}
	
	public void verifyAddVerificationBodyFunctionality() throws Exception {
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		addVerificationBody_UncheckDisplayInDropdown();
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver); 
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.VerificationBodyDropdown);
		MCII.VerificationBodyDropdown.sendKeys(VerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Verification Body is not displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		addVerificationBody();
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.VerificationBodyDropdown);
		MCII.VerificationBodyDropdown.sendKeys(VerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String VerificationBodyDropdown = MCII.VerificationBodyDropdown.getAttribute("value");
		Assert.assertEquals(VerificationBody, VerificationBodyDropdown);
		ObjectRepo.test.log(Status.PASS, "Verification Body is displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void navigateEditVerificationBody() throws Exception {
//		navigateToVerificationBodyManagement();
//		navigateAddVerificationBody();
//		addVerificationBody();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Edit Verification Body"); 
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Edit Verification Body");
	}
	
	public void proposeOffsetIssuance_NewVerificationBody() throws Exception  {
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		addVerificationBody();
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.VintageYearDropdown));
			MCII.VintageYearDropdown.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.VintageYearDropdown));
			CM.click2(MCII.VintageYearDropdown, "javascriptClick", "VintageYearDropdown");
		}
		MCII.VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.VintageYearDropdown.sendKeys(Keys.ENTER);
		MCII.Quantity.sendKeys("100");
		try {
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ARROW_DOWN);
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectNameDropdown));
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ARROW_DOWN);
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		}
		MCII.OffsetProjectID.sendKeys(generateRandomString("Project", "ID"));
		MCII.OffsetIdValue = MCII.OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + MCII.OffsetIdValue);
		try {
			MCII.OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.OffsetType));
			MCII.OffsetType.click();
		}
		MCII.OffsetType.sendKeys(Keys.ARROW_DOWN);
		MCII.OffsetType.sendKeys(Keys.ENTER);
		MCII.OffsetProjectOperatorDropdown.click();
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.BeginReportingPeriodIcon));
		try {
			MCII.BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.BeginReportingPeriodIcon));
			MCII.BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
		MCII.CurrentDate.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.EndReportingPeriodIcon));
		MCII.EndReportingPeriodIcon.click();
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
			MCII.CurrentDate.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
			MCII.CurrentDate.click();
		}
		String EndReportingPeriodValue = MCII.EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		try {
			MCII.VerificationBodyDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.VerificationBodyDropdown));
			MCII.VerificationBodyDropdown.click();
		}
		MCII.VerificationBodyDropdown.sendKeys(VerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		MCII.ProjectSiteDropdown.click();
		MCII.ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.ProjectSiteDropdown.sendKeys(Keys.ENTER);
		try {
			MCII.SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SpecialCategoryDropdown));
			MCII.SpecialCategoryDropdown.click();
		}
		MCII.SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		MCII.Comment.sendKeys("Testing Purpose");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SubmitlBtn_OffsetIssuance));
			MCII.SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SubmitlBtn_OffsetIssuance));
			MCII.SubmitlBtn_OffsetIssuance.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MCII.Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		MCII.ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(MCII.SuccessMessage));
		String SuccessMessageValue = MCII.SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		MCII.SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.CreatedTransferId));
		MCII.offsetTransferId = MCII.CreatedTransferId.getText();
	}
	
	public void verifyDisplayOrStopDisplayInDropdownFunctionality_QuickActions_VerificationBody() throws Exception {
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		addVerificationBody();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		if(FirstDisplayInDropdownRow.getText().equals("Yes")) {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "STOP DISPLAY IN DROPDOWN");
			ObjectRepo.test.log(Status.PASS, "STOP DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'Yes' ");
		}
		else {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "DISPLAY IN DROPDOWN");
			ObjectRepo.test.log(Status.PASS, "DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'No' ");
		}
		Stop_DisplayInDropdownRow_SubMenu.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on STOP DISPLAY IN DROPDOWN sub menu");
		Thread.sleep(3000);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Verification Body’ table");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver); 
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.VerificationBodyDropdown);
		MCII.VerificationBodyDropdown.sendKeys(VerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Verification Body is not displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToVerificationBodyManagement();
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(VerificationBody);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(VerificationBody);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		Stop_DisplayInDropdownRow_SubMenu.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on DISPLAY IN DROPDOWN sub menu");
		Thread.sleep(3000);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText(), "Yes");
		ObjectRepo.test.log(Status.PASS, "value in 'Displayed in Dropdown' column is displayed as 'Yes' for the specific record.");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.VerificationBodyDropdown);
		MCII.VerificationBodyDropdown.sendKeys(VerificationBody);
		Thread.sleep(2000);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String VerificationBodyDropdown = MCII.VerificationBodyDropdown.getAttribute("value");
		Assert.assertEquals(VerificationBody, VerificationBodyDropdown);
		ObjectRepo.test.log(Status.PASS, "Verification Body is displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void verify_EditVerificationBodyFunctionality() throws Exception {
		js = (JavascriptExecutor) driver;
		proposeOffsetIssuance_NewVerificationBody();
		String VerificationBodyvalue = MCII.VerificationBodyValue.getText();
		navigateBackToHomePage();
		navigateToVerificationBodyManagement();
		SearchInput.sendKeys(VerificationBody);
		Thread.sleep(5000);
		navigateEditVerificationBody();
		Thread.sleep(7000);
		VerificationBodyInputField.sendKeys("123");
		editedVerificationBody = VerificationBodyInputField.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Verification Body is edited.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUpText));
        Assert.assertEquals(ConfirmPopUpText.isDisplayed(), true);
        Assert.assertEquals(CancelBtn_SubmitPopUp.isEnabled() && ContinueBtn_SubmitPopUp.isEnabled(), true);
        ObjectRepo.test.log(Status.PASS, "Clicked on Submit Button.");
        ObjectRepo.test.log(Status.PASS, "Pop-up confirmation is displayed with 'CANCEL and 'CONFIRM' buttons");
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the verification body.");
        Assert.assertEquals(VerificationBodyManagementTitle.getText(), "Verification Body Management");
        ObjectRepo.test.log(Status.PASS, "Verification Body is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Verification Body Management Page");
		SuccessCancel.click();	
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(editedVerificationBody);
		} catch (Exception e) {
			Thread.sleep(3000);
//			new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz']")));
//			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedVerificationBody);
		}
		String VerificationBody = FirstOffsetVerificationBody.getText();
		Assert.assertEquals(editedVerificationBody.equals(VerificationBody), true);
		ObjectRepo.test.log(Status.PASS, "Edited record for Verification Body is updated in the 'Verification Body' table");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EditedRecord_HistoryTable));
		Assert.assertEquals(EditedRecord_HistoryTable.getText().equals(editedVerificationBody), true);
		ObjectRepo.test.log(Status.PASS, "The edited record details is updated as a new record in the 'Verification Body History' table on the 'Edit Verification Body' screen.");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.VerificationBodyDropdown));
		MCII.VerificationBodyDropdown.sendKeys(editedVerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String VerificationBodyDropdown = MCII.VerificationBodyDropdown.getAttribute("value");
		Assert.assertEquals(VerificationBodyDropdown, editedVerificationBody);
		ObjectRepo.test.log(Status.PASS, "Verification Body' dropdown in 'Propose Offset Issuances screen' is displayed the edited Verification Body as the Display in Dropdown is selected by default.");
		MCII.navigateToIssuanceRecordPage();
		Thread.sleep(5000);
		SearchInput.sendKeys(MCII.offsetTransferId);
		Thread.sleep(3000);
		MCII.TransferIdColumn.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.VerificationBodyValue));
//		System.out.println(VerificationBodyValue);
		Assert.assertEquals(MCII.VerificationBodyValue.getText().equals(VerificationBodyvalue), false);
		Assert.assertEquals(MCII.VerificationBodyValue.getText().equals(editedVerificationBody), true);
		ObjectRepo.test.log(Status.PASS, "The edited Verification Body is updated on the Offset Issuance Details Page.");
		
	}
	
	public void verifyCancelBtn_EditVerificationBody() throws Exception {
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		addVerificationBody();
		navigateEditVerificationBody();
		Thread.sleep(7000);
		VerificationBodyInputField.sendKeys("123");
		String VerificationBody = VerificationBodyInputField.getAttribute("value");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on Cancel button");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUP_cancel));
		Assert.assertEquals(ConfirmPopUP_cancel.isDisplayed(), true);
		Assert.assertEquals(CancelBtn_PopUp.isEnabled() && ContinueBtn_PopUp.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons after clicking on Cancel button of Edit Verification Body Page");
		CancelBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on Cancel button of Cancel Pop-up confirmation screen");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and  Jurisdiction Admin user is navigated to the ' Edit Verification Body' screen");
		String VerificationBody2 = VerificationBodyInputField.getAttribute("value");
		Assert.assertEquals(VerificationBody.equals(VerificationBody2), true);
		ObjectRepo.test.log(Status.PASS, "Entered data by Jurisdiction Admin is remain as it is.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_PopUp));
		ContinueBtn_PopUp.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(VerificationBodyManagementTitle));
		Assert.assertEquals(VerificationBodyManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and All the entered  values is cleared and Jurisdiction Admin user is navigated to Verification Body Management page");
		
	}
	
	public void verifyDisplayInDropDownFunctionality_EditVerificationBody() throws Exception {
		navigateToVerificationBodyManagement();
		navigateAddVerificationBody();
		addVerificationBody();
		navigateEditVerificationBody();
		Thread.sleep(7000);
		VerificationBodyInputField.sendKeys("123");
		editedVerificationBody = VerificationBodyInputField.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "	'Display in Dropdown' checkbox is checked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the verification body.");
        SuccessCancel.click();
        Assert.assertEquals(VerificationBodyManagementTitle.getText(), "Verification Body Management");
        ObjectRepo.test.log(Status.PASS, "Verification Body is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Verification Body Management Page");
		Thread.sleep(3000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(editedVerificationBody);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedVerificationBody);
		}
		Assert.assertEquals(FirstDisplayInDropdownRow.getText(), "Yes");
		ObjectRepo.test.log(Status.PASS, "value in 'Displayed in Dropdown' column is displayed as 'Yes' for the specific record.");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.VerificationBodyDropdown);
		MCII.VerificationBodyDropdown.sendKeys(editedVerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String VerificationBodyDropdown = MCII.VerificationBodyDropdown.getAttribute("value");
		
		Assert.assertEquals(editedVerificationBody, VerificationBodyDropdown);
		ObjectRepo.test.log(Status.PASS, "'Verification Body' dropdown in 'Propose Offset Issuances screen' is displayed the edited Verification Body");
		navigateBackToHomePage();
		navigateToVerificationBodyManagement();
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(editedVerificationBody);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(editedVerificationBody);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Edit Verification Body"); 
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Edit Verification Body");
		Thread.sleep(4000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CheckBox2));
		try {
			CheckBox2.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CheckBox2).click().build().perform();
		}
		Assert.assertEquals(CheckBox2.isSelected(), false);
		ObjectRepo.test.log(Status.PASS, " 'Display in Dropdown' checkbox is Unchecked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUpText));
        Assert.assertEquals(ConfirmPopUpText.isDisplayed(), true);
        Assert.assertEquals(CancelBtn_SubmitPopUp.isEnabled() && ContinueBtn_SubmitPopUp.isEnabled(), true);
        ObjectRepo.test.log(Status.PASS, "Pop-up confirmation is displayed with 'CANCEL and 'CONTINUE' buttons");
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the verification body.");
        SuccessCancel.click();
        Assert.assertEquals(VerificationBodyManagementTitle.getText(), "Verification Body Management");
        ObjectRepo.test.log(Status.PASS, "Verification Body is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Verification Body Management Page");	
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(editedVerificationBody);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedVerificationBody);
		}
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Verification Body’ table");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.VerificationBodyDropdown);
		MCII.VerificationBodyDropdown.sendKeys(editedVerificationBody);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "'Verification Body' dropdown in 'Propose Offset Issuances screen' is not display the edited Verification Body");
//		
	}
	
	public void navigateToOffsetProjectNameManagement() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			OffsetProjectNameManagementLable.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetProjectNameManagementLable));
			CM.click2(OffsetProjectNameManagementLable, "javascriptClick", "OffsetProjectNameManagementLable");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectNameManagementTitle));
		Assert.assertEquals(OffsetProjectNameManagementTitle.getText(), "Offset Project Name Management");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Name Management Page");
	}
	
	public void verifyUI_OffsetProjectNameManagement() throws Exception {
		navigateToOffsetProjectNameManagement();
		Assert.assertEquals(SampleTextCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "A Sample Text card is present, above the ‘Offset Project Name Management page ");
		Assert.assertEquals(TableTitle.getText(), "Offset Project Name");
		ObjectRepo.test.log(Status.PASS, "Offset Project Name table is displayed on ‘Offset Project Name Management page ");
		Assert.assertEquals(MoreActionBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "More Action button is available to Jurisdiction Admin only.");
		List<String> columns = Arrays.asList("Offset Project Name","Displayed in Dropdown","Updated Date","Updated By");
		List<String> ActualCoulmns = new ArrayList<>();
		for (WebElement Coulmn : TableColumns) {
			ActualCoulmns.add(Coulmn.getText());
			ObjectRepo.test.log(Status.PASS, "Columns present on Offset Project Name Grid: "+Coulmn.getText());
		}
		Assert.assertEquals(QuickActionColumn.getText(), "Quick Actions");
		ObjectRepo.test.log(Status.PASS, "Columns present on Offset Project Name Grid: "+QuickActionColumn.getText());
		boolean allMatch = true;
		for (int i = 0; i< columns.size(); i++) {
			String ExpValue = columns.get(i);
			String ActValue = ActualCoulmns.get(i);
			if (!ExpValue.equals(ActValue)) {
				allMatch = false;
				break;
			}
		}
		if (allMatch) {
			ObjectRepo.test.log(Status.PASS, "All the expected columns are present on Offset Project Name Grid ");
		} else {
			ObjectRepo.test.log(Status.PASS, "All the expected columns are not present on Offset Project Name Grid ");
		}
	}
	
	public void verifyQuickAction_OffsetProjectNameManagement() throws Exception {
		navigateToOffsetProjectNameManagement();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		if(FirstDisplayInDropdownRow.getText().equals("Yes")) {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "STOP DISPLAY IN DROPDOWN");
			Assert.assertEquals(Edit_SubMenu.getText(), "EDIT");
			ObjectRepo.test.log(Status.PASS, "Edit and STOP DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'Yes' ");
		}
		else {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "DISPLAY IN DROPDOWN");
			Assert.assertEquals(Edit_SubMenu.getText(), "EDIT");
			ObjectRepo.test.log(Status.PASS, "Edit and DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'No' ");
		}
	}
	
	public void navigateToAddOffsetProjectName() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionBtn));
		MoreActionBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(AddOffsetMangement));
		AddOffsetMangement.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Add Offset Project Name");
		ObjectRepo.test.log(Status.PASS, "User navigated to Add Offset Project Name Page");
	}
	
	public void addOffsetProjectName() throws Exception {
		OffsetProjectnameInputField.sendKeys(generateRandomString("Offset","ProjectName"));
		String OffsetProjectNameValue = OffsetProjectnameInputField.getAttribute("value");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
			
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ConfirmBtnPopUp));
		ConfirmBtnPopUp.click();
		wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "You have successfully added the offset project name");
		ObjectRepo.test.log(Status.PASS, "Offset Project Name created Successfully");
		SuccessCancel.click();	
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(OffsetProjectNameValue);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(OffsetProjectNameValue);
		}
		OffsetProjectName = FirstOffsetProjectName.getText();
		Assert.assertEquals(OffsetProjectName.equals(OffsetProjectNameValue), true);
	}
	
	public void verifyAddedOffsetProjectNameInOffsetIssuance() throws Exception {
		MCII = new Registry_Module3_MCII(driver);
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		Assert.assertEquals(CheckBox.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "By default, 'Display in Dropdown' checkbox is checked.");
		addOffsetProjectName();
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("Yes"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'Yes' in ‘Offset Project Name’ table");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		String offestProjectnameValue = MCII.OffsetProjectNameDropdown.getAttribute("value");
		Assert.assertEquals(offestProjectnameValue, OffsetProjectName);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CheckBox2));
		try {
			CheckBox2.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CheckBox2).click().build().perform();
		}
		Thread.sleep(3000);
		Assert.assertEquals(CheckBox.isSelected(), false);
		ObjectRepo.test.log(Status.PASS, " 'Display in Dropdown' checkbox is Unchecked.");
		addOffsetProjectName();
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Offset Project Name’ table");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is not displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void verifyDisplayOrStopDisplayInDropdownFunctionality_QuickActions_OffsetProjectName() throws Exception {
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		addOffsetProjectName();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		if(FirstDisplayInDropdownRow.getText().equals("Yes")) {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "STOP DISPLAY IN DROPDOWN");
			ObjectRepo.test.log(Status.PASS, "STOP DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'Yes' ");
		}
		else {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "DISPLAY IN DROPDOWN");
			ObjectRepo.test.log(Status.PASS, "DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'No' ");
		}
		Stop_DisplayInDropdownRow_SubMenu.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on STOP DISPLAY IN DROPDOWN sub menu");
		Thread.sleep(3000);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Offset Project Name’ table");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver); 
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is not displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToOffsetProjectNameManagement();
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(OffsetProjectName);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(OffsetProjectName);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		Stop_DisplayInDropdownRow_SubMenu.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on DISPLAY IN DROPDOWN sub menu");
		Thread.sleep(3000);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText(), "Yes");
		ObjectRepo.test.log(Status.PASS, "value in 'Displayed in Dropdown' column is displayed as 'Yes' for the specific record.");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		Thread.sleep(2000);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String OffsetProjectNameDropdown = MCII.OffsetProjectNameDropdown.getAttribute("value");
		Assert.assertEquals(OffsetProjectName, OffsetProjectNameDropdown);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void navigateToEditOffsetProjectName() throws Exception {
//		navigateToOffsetProjectNameManagement();
//		navigateToAddOffsetProjectName();
//		addOffsetProjectName();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Edit Offset Project Name"); 
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Edit Offset Project Name");
	}
	
	public void proposeOffsetIssuance_NewOffsetProjectname() throws Exception  {
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		addOffsetProjectName();
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.VintageYearDropdown));
			MCII.VintageYearDropdown.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.VintageYearDropdown));
			CM.click2(MCII.VintageYearDropdown, "javascriptClick", "VintageYearDropdown");
		}
		MCII.VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.VintageYearDropdown.sendKeys(Keys.ENTER);
		MCII.Quantity.sendKeys("100");
		try {
			MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectNameDropdown));
			MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		}
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		MCII.OffsetProjectID.sendKeys(generateRandomString("Project", "ID"));
		MCII.OffsetIdValue = MCII.OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + MCII.OffsetIdValue);
		try {
			MCII.OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.OffsetType));
			MCII.OffsetType.click();
		}
		MCII.OffsetType.sendKeys(Keys.ARROW_DOWN);
		MCII.OffsetType.sendKeys(Keys.ENTER);
		MCII.OffsetProjectOperatorDropdown.click();
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.BeginReportingPeriodIcon));
		try {
			MCII.BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.BeginReportingPeriodIcon));
			MCII.BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
		MCII.CurrentDate.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.EndReportingPeriodIcon));
		MCII.EndReportingPeriodIcon.click();
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
			MCII.CurrentDate.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
			MCII.CurrentDate.click();
		}
		String EndReportingPeriodValue = MCII.EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		try {
			MCII.VerificationBodyDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.VerificationBodyDropdown));
			MCII.VerificationBodyDropdown.click();
		}
		MCII.VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		MCII.ProjectSiteDropdown.click();
		MCII.ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.ProjectSiteDropdown.sendKeys(Keys.ENTER);
		try {
			MCII.SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SpecialCategoryDropdown));
			MCII.SpecialCategoryDropdown.click();
		}
		MCII.SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		MCII.Comment.sendKeys("Testing Purpose");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SubmitlBtn_OffsetIssuance));
			MCII.SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SubmitlBtn_OffsetIssuance));
			MCII.SubmitlBtn_OffsetIssuance.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MCII.Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		MCII.ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(MCII.SuccessMessage));
		String SuccessMessageValue = MCII.SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		MCII.SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.CreatedTransferId));
		MCII.offsetTransferId = MCII.CreatedTransferId.getText();
	}
	
	public void verify_EditOffsetProjectNameFunctionality() throws Exception {
		js = (JavascriptExecutor) driver;
		proposeOffsetIssuance_NewOffsetProjectname();
		String OffsetProjectNamevalue = MCII.OffsetProjectnameValue.getText();
		navigateBackToHomePage();
		navigateToOffsetProjectNameManagement();
		SearchInput.sendKeys(OffsetProjectName);
		Thread.sleep(5000);
		navigateToEditOffsetProjectName();
		Thread.sleep(7000);
		OffsetProjectnameInputField.sendKeys("123");
		editedOffsetProjectName = OffsetProjectnameInputField.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is edited.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUpText));
        Assert.assertEquals(ConfirmPopUpText.isDisplayed(), true);
        Assert.assertEquals(CancelBtn_SubmitPopUp.isEnabled() && ContinueBtn_SubmitPopUp.isEnabled(), true);
        ObjectRepo.test.log(Status.PASS, "Clicked on Submit Button.");
        ObjectRepo.test.log(Status.PASS, "Pop-up confirmation is displayed with 'CANCEL and 'CONFIRM' buttons");
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the offset project name.");
        Assert.assertEquals(OffsetProjectNameManagementTitle.getText(), "Offset Project Name Management");
        ObjectRepo.test.log(Status.PASS, "Offset Project Name is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Name Management Page");
		SuccessCancel.click();	
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(editedOffsetProjectName);
		} catch (Exception e) {
			Thread.sleep(3000);
//			new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz']")));
//			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedOffsetProjectName);
		}
		String OffsetProjectName = FirstOffsetProjectName.getText();
		Assert.assertEquals(editedOffsetProjectName.equals(OffsetProjectName), true);
		ObjectRepo.test.log(Status.PASS, "Edited record for Offset Project Name is updated in the 'Offset Project Name' table");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EditedRecord_HistoryTable));
		Assert.assertEquals(EditedRecord_HistoryTable.getText().equals(editedOffsetProjectName), true);
		ObjectRepo.test.log(Status.PASS, "The edited record details is updated as a new record in the 'Offset Project Name History' table on the 'Edit Offset Project Name' screen.");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectNameDropdown));
		MCII.OffsetProjectNameDropdown.sendKeys(editedOffsetProjectName);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		String OffsetProjectNameDropdown = MCII.OffsetProjectNameDropdown.getAttribute("value");
		Assert.assertEquals(OffsetProjectNameDropdown, editedOffsetProjectName);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name' dropdown in 'Propose Offset Issuances screen' is displayed the edited Project Name as the Display in Dropdown is selected by default.");
		MCII.navigateToIssuanceRecordPage();
		Thread.sleep(5000);
		SearchInput.sendKeys(MCII.offsetTransferId);
		Thread.sleep(3000);
		MCII.TransferIdColumn.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectnameValue));
		System.out.println(OffsetProjectNamevalue);
		Assert.assertEquals(MCII.OffsetProjectnameValue.getText().equals(OffsetProjectNamevalue), false);
		Assert.assertEquals(MCII.OffsetProjectnameValue.getText().equals(editedOffsetProjectName), true);
		ObjectRepo.test.log(Status.PASS, "The edited Project Name is updated on the Offset Issuance Details Page.");
	}
	
	public void verifyDisplayInDropDownFunctionality_EditOffsetProjectName() throws Exception {
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		addOffsetProjectName();
		navigateToEditOffsetProjectName();
		Thread.sleep(7000);
		OffsetProjectnameInputField.sendKeys("123");
		editedOffsetProjectName = OffsetProjectnameInputField.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "	'Display in Dropdown' checkbox is checked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the offset project name.");
        Assert.assertEquals(OffsetProjectNameManagementTitle.getText(), "Offset Project Name Management");
        ObjectRepo.test.log(Status.PASS, "Offset Project Name is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Name Management Page");
		SuccessCancel.click();	
		Thread.sleep(3000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(editedOffsetProjectName);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedOffsetProjectName);
		}
		Assert.assertEquals(FirstDisplayInDropdownRow.getText(), "Yes");
		ObjectRepo.test.log(Status.PASS, "value in 'Displayed in Dropdown' column is displayed as 'Yes' for the specific record.");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectNameDropdown.sendKeys(editedOffsetProjectName);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String OffsetProjectOperatorDropdown = MCII.OffsetProjectNameDropdown.getAttribute("value");
		
		Assert.assertEquals(editedOffsetProjectName, OffsetProjectOperatorDropdown);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToOffsetProjectNameManagement();
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(editedOffsetProjectName);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(editedOffsetProjectName);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Edit Offset Project Name"); 
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Edit Offset Project Name");
		Thread.sleep(4000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CheckBox2));
		try {
			CheckBox2.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CheckBox2).click().build().perform();
		}
//		Assert.assertEquals(CheckBox.isSelected(), false);
		ObjectRepo.test.log(Status.PASS, " 'Display in Dropdown' checkbox is Unchecked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUpText));
        Assert.assertEquals(ConfirmPopUpText.isDisplayed(), true);
        Assert.assertEquals(CancelBtn_SubmitPopUp.isEnabled() && ContinueBtn_SubmitPopUp.isEnabled(), true);
        ObjectRepo.test.log(Status.PASS, "Pop-up confirmation is displayed with 'CANCEL and 'CONTINUE' buttons");
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the offset project name.");
        Assert.assertEquals(OffsetProjectNameManagementTitle.getText(), "Offset Project Name Management");
        ObjectRepo.test.log(Status.PASS, "Offset Project Name is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Name Management Page");
		SuccessCancel.click();	
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(editedOffsetProjectName);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedOffsetProjectName);
		}
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Offset Project Name’ table");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectNameDropdown.sendKeys(OffsetProjectName);
		MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name is not displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void verifyUI_addOffsetProjectName() throws Exception {
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		Assert.assertEquals(sampleTextCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Sample card is displayed on the Add Offset Project Name page");
		Assert.assertEquals(AddOffsetProjectNameCardLabel.getText(), "Add Offset Project Name");
		ObjectRepo.test.log(Status.PASS, "Add Offset Project Name card is displayed on the Add Offset Project Name page");
		Assert.assertEquals(OffsetProjectNameFieldLabel.getText(), "Offset Project Name*");
		ObjectRepo.test.log(Status.PASS, "Offset Project Name field is displayed on the Add Offset Project Name Card");
		Assert.assertEquals(OffsetProjectnameInputField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name text field is displayed on the Add Offset Project Name Card");
		Assert.assertEquals(CheckBox.isEnabled() && CheckBox.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "Checkbox for Display In Dropdown is displayed and By default it is checked on the Add Offset Project Name Card");
		Assert.assertEquals(DisplayInDropDownLabel.getText(), "Display in Dropdown?");
		ObjectRepo.test.log(Status.PASS, "Display in Dropdown? label is displayed on the Add Offset Project Name Card");
		Assert.assertEquals(CancelBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Cancel Button is displayed on the Add Offset Project Name Card");
		Assert.assertEquals(SubmitBtn.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit Button is displayed and  in disabled state on the Add Offset Project Name Card");
	}
	
	public void verifyCancelBtn_addOffsetProjectName() throws Exception {
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetProjectnameInputField));
		OffsetProjectnameInputField.sendKeys("OffsetProjectname");
		String Projectnamevalue = OffsetProjectnameInputField.getAttribute("value");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button.");
		Assert.assertEquals(ConfirmPopUP_cancel.isDisplayed(), true);
		Assert.assertEquals(CancelBtn_PopUp.isEnabled() && ContinueBtn_PopUp.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with the 'CANCEL' & 'CONFIRM' buttons after clicking on Cancel button of Add Offset Project Name Page");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button of Cancel Confirmation pop-up.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and  Jurisdiction Admin user is navigated to the ' Add Offset Project Name' screen");
		String Projectnamevalue2 = OffsetProjectnameInputField.getAttribute("value");
		Assert.assertEquals(Projectnamevalue.equals(Projectnamevalue2), true);
		ObjectRepo.test.log(Status.PASS, "Entered data by Jurisdiction Admin is remain as it is.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		ContinueBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Click on Continue button of Cancel Confirmation pop-up.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectNameManagementTitle));
		Assert.assertEquals(OffsetProjectNameManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and All the entered  values is cleared and Jurisdiction Admin user is navigated to Offset Project Name Management page");
	}
	
	public void verifyCancelBtn_EditOffsetProjectName() throws Exception {
		navigateToOffsetProjectNameManagement();
		navigateToAddOffsetProjectName();
		addOffsetProjectName();
		navigateToEditOffsetProjectName();
		Thread.sleep(3000);
		OffsetProjectnameInputField.sendKeys("123");
		String Projectnamevalue = OffsetProjectnameInputField.getAttribute("value");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CM = new CommonMethods(driver);
			CM.click2(CancelBtn, "javascriptClick", "CancelBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUP_cancel));
		Assert.assertEquals(ConfirmPopUP_cancel.isDisplayed(), true);
		Assert.assertEquals(CancelBtn_PopUp.isEnabled() && ContinueBtn_PopUp.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with the 'CANCEL' & 'CONFIRM' buttons after clicking on Cancel button of Edit Offset Project Name Page");
		CancelBtn_PopUp.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and  Jurisdiction Admin user is navigated to the ' Edit Offset Project Name' screen");
		String Projectnamevalue2 = OffsetProjectnameInputField.getAttribute("value");
		Assert.assertEquals(Projectnamevalue.equals(Projectnamevalue2), true);
		ObjectRepo.test.log(Status.PASS, "Entered data by Jurisdiction Admin is remain as it is.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CM = new CommonMethods(driver);
			CM.click2(CancelBtn, "javascriptClick", "CancelBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_PopUp));
		ContinueBtn_PopUp.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectNameManagementTitle));
		Assert.assertEquals(OffsetProjectNameManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and All the entered  values is cleared and Jurisdiction Admin user is navigated to Offset Project Name Management page");
	}
	
	public void navigateToOffsetProjectOperatorManagement() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			OffsetProjectOperatorManagementLable.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(OffsetProjectOperatorManagementLable, "moveToElementClick",
					"OffsetProjectOperatorManagementLable");
		}
		Assert.assertEquals(OffsetProjectOperatorManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Operator Management Page");
	}
	
	public void verifyQuickAction_OffsetProjectOperatorManagement() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		if(FirstDisplayInDropdownRow.getText().equals("Yes")) {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "STOP DISPLAY IN DROPDOWN");
			Assert.assertEquals(Edit_SubMenu.getText(), "EDIT");
			ObjectRepo.test.log(Status.PASS, "Edit and STOP DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'Yes' ");
		}
		else {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "DISPLAY IN DROPDOWN");
			Assert.assertEquals(Edit_SubMenu.getText(), "EDIT");
			ObjectRepo.test.log(Status.PASS, "Edit and DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'No' ");
		}
	}

	public void navigateToAddOffsetProjectOperator() throws Exception {
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionBtn));
		MoreActionBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(AddOffsetMangement));
		AddOffsetMangement.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Add Offset Project Operator");
		ObjectRepo.test.log(Status.PASS, "User navigated to Add Offset Project Operator Page");
	}
	
	public void verifyUI_AddOffsetProjectOperator() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		Assert.assertEquals(SampleTextCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "A Sample Text card is present, above the Add Offset Project Operator card");
		Assert.assertEquals(AddOffsetProjectOperatorCardTitle.getText(), "Add Offset Project Operator");
		ObjectRepo.test.log(Status.PASS, "Add Offset Project Operator card is present on Add Offset Project Operator Page");
		Assert.assertEquals(OffsetProjectOperatorLabel.getText(), "Offset Project Operator*");
		Assert.assertEquals(OffsetProjectOperatorInputField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator label with text input field is present on Add Offset Project Operator card");
		Assert.assertEquals(CheckBox.isEnabled() && CheckBox.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "Checkbox for Display In Dropdown is displayed and By default it is checked on the Add Offset Project Operator Card");
		Assert.assertEquals(DisplayInDropDownLabel.getText(), "Display in Dropdown?");
		ObjectRepo.test.log(Status.PASS, "Display in Dropdown? label is displayed on the Add Offset Project Operator Card");
		Assert.assertEquals(CancelBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Cancel Button is displayed on the Add Offset Project Operator Card");
		Assert.assertEquals(SubmitBtn.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit Button is displayed and  in disabled state on the Add Offset Project Operator Card");
	}
	
	public void verifyCancelBtn_AddOffsetProjectOperator() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetProjectOperatorInputField));
		OffsetProjectOperatorInputField.sendKeys("OffsetProjectOperator");
		String OffsetProjectOperator = OffsetProjectOperatorInputField.getAttribute("value");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button.");
		Assert.assertEquals(ConfirmPopUP_cancel.isDisplayed(), true);
		Assert.assertEquals(CancelBtn_PopUp.isEnabled() && ContinueBtn_PopUp.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons after clicking on Cancel button of Add Offset Project Operator Page");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button of Cancel Confirmation pop-up.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and  Jurisdiction Admin user is navigated to the ' Add Offset Project Operator' screen");
		String OffsetProjectOperator2 = OffsetProjectOperatorInputField.getAttribute("value");
		Assert.assertEquals(OffsetProjectOperator.equals(OffsetProjectOperator2), true);
		ObjectRepo.test.log(Status.PASS, "Entered data by Jurisdiction Admin is remain as it is.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			CancelBtn.click();
		}
		ObjectRepo.test.log(Status.PASS, "Click on Cancel button.");
		ContinueBtn_PopUp.click();
		ObjectRepo.test.log(Status.PASS, "Click on Continue button of Cancel Confirmation pop-up.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectOperatorManagementTitle));
		Assert.assertEquals(OffsetProjectOperatorManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and All the entered  values is cleared and Jurisdiction Admin user is navigated to Offset Project Operator Management page");
		
	}
	
	public void navigateToEditOffsetProjectOperator() throws Exception {
//		navigateToOffsetProjectOperatorManagement();
//		navigateToAddOffsetProjectOperator();
//		addOffsetProjectOperator();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Edit Offset Project Operator"); 
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Edit Offset Project Operator page");
	}
	
	public void proposeOffsetIssuance_NewOffsetProjectOperator() throws Exception  {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		addOffsetProjectOperator();
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Thread.sleep(3000);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.VintageYearDropdown));
			MCII.VintageYearDropdown.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.VintageYearDropdown));
			CM.click2(MCII.VintageYearDropdown, "javascriptClick", "VintageYearDropdown");
		}
		MCII.VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.VintageYearDropdown.sendKeys(Keys.ENTER);
		MCII.Quantity.sendKeys("100");
		try {
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ARROW_DOWN);
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectNameDropdown));
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ARROW_DOWN);
			MCII.OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		}
		MCII.OffsetProjectID.sendKeys(generateRandomString("Project", "ID"));
		MCII.OffsetIdValue = MCII.OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + MCII.OffsetIdValue);
		try {
			MCII.OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.OffsetType));
			MCII.OffsetType.click();
		}
		MCII.OffsetType.sendKeys(Keys.ARROW_DOWN);
		MCII.OffsetType.sendKeys(Keys.ENTER);
		MCII.OffsetProjectOperatorDropdown.click();
		MCII.OffsetProjectOperatorDropdown.sendKeys(OffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.BeginReportingPeriodIcon));
		try {
			MCII.BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.BeginReportingPeriodIcon));
			MCII.BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
		MCII.CurrentDate.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.EndReportingPeriodIcon));
		MCII.EndReportingPeriodIcon.click();
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
			MCII.CurrentDate.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.CurrentDate));
			MCII.CurrentDate.click();
		}
		String EndReportingPeriodValue = MCII.EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		try {
			MCII.VerificationBodyDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.VerificationBodyDropdown));
			MCII.VerificationBodyDropdown.click();
		}
		MCII.VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.VerificationBodyDropdown.sendKeys(Keys.ENTER);
		MCII.ProjectSiteDropdown.click();
		MCII.ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.ProjectSiteDropdown.sendKeys(Keys.ENTER);
		try {
			MCII.SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SpecialCategoryDropdown));
			MCII.SpecialCategoryDropdown.click();
		}
		MCII.SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		MCII.SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		MCII.Comment.sendKeys("Testing Purpose");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SubmitlBtn_OffsetIssuance));
			MCII.SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MCII.SubmitlBtn_OffsetIssuance));
			MCII.SubmitlBtn_OffsetIssuance.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		Properties prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MCII.Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		MCII.ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(MCII.SuccessMessage));
		String SuccessMessageValue = MCII.SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		MCII.SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.CreatedTransferId));
		MCII.offsetTransferId = MCII.CreatedTransferId.getText();
	}
	
	public void verify_EditOffsetProjectOperatorFunctionality() throws Exception {
		js = (JavascriptExecutor) driver;
		proposeOffsetIssuance_NewOffsetProjectOperator();
		String OffsetProjectOperatorvalue = MCII.OffsetProjectOperatorValue.getText();
		navigateBackToHomePage();
		navigateToOffsetProjectOperatorManagement();
		SearchInput.sendKeys(OffsetProjectOperator);
		Thread.sleep(5000);
		navigateToEditOffsetProjectOperator();
		Thread.sleep(7000);
		OffsetProjectOperatorInputField.sendKeys("123");
		editedOffsetProjectOperator = OffsetProjectOperatorInputField.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator is edited.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUpText));
        Assert.assertEquals(ConfirmPopUpText.isDisplayed(), true);
        Assert.assertEquals(CancelBtn_SubmitPopUp.isEnabled() && ContinueBtn_SubmitPopUp.isEnabled(), true);
        ObjectRepo.test.log(Status.PASS, "Clicked on Submit Button.");
        ObjectRepo.test.log(Status.PASS, "Pop-up confirmation is displayed with 'CANCEL and 'CONFIRM' buttons");
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the offset project operator.");
        Assert.assertEquals(OffsetProjectOperatorManagementTitle.getText(), "Offset Project Operator Management");
        ObjectRepo.test.log(Status.PASS, "Offset Project Operator is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Operator Management Page");
		SuccessCancel.click();	
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(editedOffsetProjectOperator);
		} catch (Exception e) {
			Thread.sleep(3000);
//			new WebDriverWait(driver, 40).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//input[@class='MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz']")));
//			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedOffsetProjectOperator);
		}
		String OffsetProjectOperator = FirstOffsetProjectOperator.getText();
		Assert.assertEquals(editedOffsetProjectOperator.equals(OffsetProjectOperator), true);
		ObjectRepo.test.log(Status.PASS, "Edited record for Offset Project Operator is updated in the 'Offset Project Operator' table");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EditedRecord_HistoryTable));
		Assert.assertEquals(EditedRecord_HistoryTable.getText().equals(editedOffsetProjectOperator), true);
		ObjectRepo.test.log(Status.PASS, "The edited record details is updated as a new record in the 'Offset Project Operator History' table on the 'Edit Offset Project Operator' screen.");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectOperatorDropdown));
		MCII.OffsetProjectOperatorDropdown.sendKeys(editedOffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String OffsetProjectOperatorDropdown = MCII.OffsetProjectOperatorDropdown.getAttribute("value");
		Assert.assertEquals(OffsetProjectOperatorDropdown, editedOffsetProjectOperator);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator' dropdown in 'Propose Offset Issuances screen' is displayed the edited Project Operator as the Display in Dropdown is selected by default.");
		MCII.navigateToIssuanceRecordPage();
		Thread.sleep(5000);
		SearchInput.sendKeys(MCII.offsetTransferId);
		Thread.sleep(3000);
		MCII.TransferIdColumn.click();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MCII.OffsetProjectOperatorValue));
		System.out.println(OffsetProjectOperatorvalue);
		Assert.assertEquals(MCII.OffsetProjectOperatorValue.getText().equals(OffsetProjectOperatorvalue), false);
		Assert.assertEquals(MCII.OffsetProjectOperatorValue.getText().equals(editedOffsetProjectOperator), true);
		ObjectRepo.test.log(Status.PASS, "The edited Project Operator is updated on the Offset Issuance Details Page.");
	}
	
	public void verifyCancelBtn_EditOffsetProjectOperator() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		addOffsetProjectOperator();
		navigateToEditOffsetProjectOperator();
		Thread.sleep(5000);
		OffsetProjectOperatorInputField.sendKeys("123");
		Thread.sleep(2000);
		String OffsetProjectOperatorvalue = OffsetProjectOperatorInputField.getAttribute("value");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CancelBtn).build().perform();
			CancelBtn.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUP_cancel));
		Assert.assertEquals(ConfirmPopUP_cancel.isDisplayed(), true);
		Assert.assertEquals(CancelBtn_PopUp.isEnabled() && ContinueBtn_PopUp.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons after clicking on Cancel button of Edit Offset Project Operator Page");
		CancelBtn_PopUp.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and  Jurisdiction Admin user is navigated to the ' Edit Offset Project Operator' screen");
		Thread.sleep(2000);
		String OffsetProjectOperatorvalue2 = OffsetProjectOperatorInputField.getAttribute("value");
		Assert.assertEquals(OffsetProjectOperatorvalue.equals(OffsetProjectOperatorvalue2), true);
		ObjectRepo.test.log(Status.PASS, "Entered data by Jurisdiction Admin is remain as it is.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_PopUp));
		ContinueBtn_PopUp.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectOperatorManagementTitle));
		Assert.assertEquals(OffsetProjectOperatorManagementTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Confirmation pop-up is closed and All the entered  values is cleared and Jurisdiction Admin user is navigated to Offset Project Operator Management page");
		
	}
	
	public void addOffsetProjectOperator() throws Exception {
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectOperatorInputField));
		OffsetProjectOperatorInputField.sendKeys(generateRandomString("Offset","Operator"));
		String OffsetProjectOperatorValue = OffsetProjectOperatorInputField.getAttribute("value");
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			actions = new Actions(driver);
			actions.moveToElement(SubmitBtn).click(SubmitBtn).build().perform();
//			SubmitBtn.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ConfirmBtnPopUp));
		ConfirmBtnPopUp.click();
		wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "You have successfully added the offset project operator");
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator created Successfully");
		SuccessCancel.click();	
		Thread.sleep(2000);
		try {
			SearchInput.sendKeys(OffsetProjectOperatorValue);
		} catch (Exception e) {
			actions = new Actions(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			actions.moveToElement(SearchInput).build().perform();
			SearchInput.sendKeys(OffsetProjectOperatorValue);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(FirstOffsetProjectOperator));
		OffsetProjectOperator = FirstOffsetProjectOperator.getText();
		Assert.assertEquals(OffsetProjectOperator.equals(OffsetProjectOperatorValue), true);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("Yes"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'Yes' in ‘Offset Project Operator’ table");
	}
	
	public void addOffsetProjectOperator_UncheckDisplayInDropdown() throws Exception {
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectOperatorInputField));
		OffsetProjectOperatorInputField.sendKeys(generateRandomString("Offset","Operator"));
		String OffsetProjectOperatorValue = OffsetProjectOperatorInputField.getAttribute("value");
//		Assert.assertEquals(CheckBox.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "By default, 'Display in Dropdown' checkbox should be checked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CheckBox2));
		try {
			CheckBox2.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CheckBox2).click().build().perform();
		}
		ObjectRepo.test.log(Status.PASS, "Unchecked the Displayed In Dropdown Checkbox");
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			actions = new Actions(driver);
			actions.moveToElement(SubmitBtn).click(SubmitBtn).build().perform();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ConfirmBtnPopUp));
		ConfirmBtnPopUp.click();
		wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "You have successfully added the offset project operator");
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator created Successfully");
		SuccessCancel.click();	
		Thread.sleep(2000);
		try {
			SearchInput.sendKeys(OffsetProjectOperatorValue);
		} catch (Exception e) {
			actions = new Actions(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			actions.moveToElement(SearchInput).build().perform();
			SearchInput.sendKeys(OffsetProjectOperatorValue);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(FirstOffsetProjectOperator));
		OffsetProjectOperator = FirstOffsetProjectOperator.getText();
		Assert.assertEquals(OffsetProjectOperator.equals(OffsetProjectOperatorValue), true);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Offset Project Name’ table");
	}
	
	public void verifyDisplayOrStopDisplayInDropdownFunctionality_QuickActions_OffsetProjectOperator() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		addOffsetProjectOperator();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		if(FirstDisplayInDropdownRow.getText().equals("Yes")) {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "STOP DISPLAY IN DROPDOWN");
			ObjectRepo.test.log(Status.PASS, "STOP DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'Yes' ");
		}
		else {
			Assert.assertEquals(Stop_DisplayInDropdownRow_SubMenu.getText(), "DISPLAY IN DROPDOWN");
			ObjectRepo.test.log(Status.PASS, "DISPLAY IN DROPDOWN submenu is displayed in Quick Action Menu if Display In Dropdown column value is 'No' ");
		}
		Stop_DisplayInDropdownRow_SubMenu.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on STOP DISPLAY IN DROPDOWN sub menu");
		Thread.sleep(3000);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Offset Project Operator’ table");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver); 
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectOperatorDropdown);
		MCII.OffsetProjectOperatorDropdown.sendKeys(OffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator is not displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToOffsetProjectOperatorManagement();
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(OffsetProjectOperator);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(OffsetProjectOperator);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		Stop_DisplayInDropdownRow_SubMenu.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on DISPLAY IN DROPDOWN sub menu");
		Thread.sleep(3000);
		Assert.assertEquals(FirstDisplayInDropdownRow.getText(), "Yes");
		ObjectRepo.test.log(Status.PASS, "value in 'Displayed in Dropdown' column is displayed as 'Yes' for the specific record.");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectOperatorDropdown);
		MCII.OffsetProjectOperatorDropdown.sendKeys(OffsetProjectOperator);
		Thread.sleep(2000);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String OffsetProjectOperatorDropdown = MCII.OffsetProjectOperatorDropdown.getAttribute("value");
		Assert.assertEquals(OffsetProjectOperator, OffsetProjectOperatorDropdown);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator is displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void verifyAddOffsetProjectOperatorFunctionality() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		addOffsetProjectOperator_UncheckDisplayInDropdown();
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver); 
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectNameDropdown);
		MCII.OffsetProjectOperatorDropdown.sendKeys(OffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator is not displayed in the dropdown in Propose Offset Issuance page");
		navigateBackToHomePage();
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		addOffsetProjectOperator();
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectOperatorDropdown);
		MCII.OffsetProjectOperatorDropdown.sendKeys(OffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(2000);
		String OffsetProjectOperatorDropdown = MCII.OffsetProjectOperatorDropdown.getAttribute("value");
		Assert.assertEquals(OffsetProjectOperator, OffsetProjectOperatorDropdown);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator is displayed in the dropdown in Propose Offset Issuance page");
	}
	
	public void navigateBackToHomePage() throws Exception {
		CM = new CommonMethods(driver);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(HomeMenu));
		try {
			HomeMenu.click();
		} catch (Exception ex) {
			CM.click2(HomeMenu, "javascriptClick", "HomeMenu");
		}
	}

	public void verifyDisplayInDropDownFunctionality_EditOffsetProjectOperator() throws Exception {
		navigateToOffsetProjectOperatorManagement();
		navigateToAddOffsetProjectOperator();
		addOffsetProjectOperator();
		navigateToEditOffsetProjectOperator();
		Thread.sleep(7000);
		OffsetProjectOperatorInputField.sendKeys("123");
		editedOffsetProjectOperator = OffsetProjectOperatorInputField.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "	'Display in Dropdown' checkbox is checked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the offset project operator.");
        SuccessCancel.click();
        Assert.assertEquals(OffsetProjectOperatorManagementTitle.getText(), "Offset Project Operator Management");
        ObjectRepo.test.log(Status.PASS, "Offset Project Operator is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Operator Management Page");
		Thread.sleep(3000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		try {
			SearchInput.sendKeys(editedOffsetProjectOperator);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedOffsetProjectOperator);
		}
		Assert.assertEquals(FirstDisplayInDropdownRow.getText(), "Yes");
		ObjectRepo.test.log(Status.PASS, "value in 'Displayed in Dropdown' column is displayed as 'Yes' for the specific record.");
		navigateBackToHomePage();
		MCII = new Registry_Module3_MCII(driver);
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectOperatorDropdown);
		MCII.OffsetProjectOperatorDropdown.sendKeys(editedOffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String OffsetProjectOperatorDropdown = MCII.OffsetProjectOperatorDropdown.getAttribute("value");
		
		Assert.assertEquals(editedOffsetProjectOperator, OffsetProjectOperatorDropdown);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator' dropdown in 'Propose Offset Issuances screen' is displayed the edited Project Operator");
		navigateBackToHomePage();
		navigateToOffsetProjectOperatorManagement();
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(editedOffsetProjectOperator);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.click();
			SearchInput.sendKeys(editedOffsetProjectOperator);
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(QuickAction));
		QuickAction.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Edit_SubMenu));
		Edit_SubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AddOMPageTitle));
		Assert.assertEquals(AddOMPageTitle.getText(), "Edit Offset Project Operator"); 
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Edit Offset Project Operator");
		Thread.sleep(4000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CheckBox2));
		try {
			CheckBox2.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CheckBox2).click().build().perform();
		}
//		Assert.assertEquals(CheckBox.isSelected(), false);
		ObjectRepo.test.log(Status.PASS, " 'Display in Dropdown' checkbox is Unchecked.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		}
		catch(Exception ex){
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ConfirmPopUpText));
        Assert.assertEquals(ConfirmPopUpText.isDisplayed(), true);
        Assert.assertEquals(CancelBtn_SubmitPopUp.isEnabled() && ContinueBtn_SubmitPopUp.isEnabled(), true);
        ObjectRepo.test.log(Status.PASS, "Pop-up confirmation is displayed with 'CANCEL and 'CONTINUE' buttons");
        new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtn_SubmitPopUp));
        ContinueBtn_SubmitPopUp.click();
        new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SuccessMsg));
        Assert.assertEquals(SuccessMsg.getText(), "You have successfully updated the offset project operator.");
        Assert.assertEquals(OffsetProjectOperatorManagementTitle.getText(), "Offset Project Operator Management");
        ObjectRepo.test.log(Status.PASS, "Offset Project Operator is edited successfully with a success message");
		ObjectRepo.test.log(Status.PASS, "User navigated to Offset Project Operator Management Page");
		SuccessCancel.click();	
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
		Thread.sleep(3000);
		try {
			SearchInput.sendKeys(editedOffsetProjectOperator);
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SearchInput));
			SearchInput.sendKeys(editedOffsetProjectOperator);
		}
		Assert.assertEquals(FirstDisplayInDropdownRow.getText().equals("No"), true);
		ObjectRepo.test.log(Status.PASS, "Displayed in Dropdown column is updated to 'No' in ‘Offset Project Operator’ table");
		navigateBackToHomePage();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", MCII.OffsetProjectOperatorDropdown);
		MCII.OffsetProjectOperatorDropdown.sendKeys(editedOffsetProjectOperator);
		MCII.OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		Boolean elementdisplay = driver.findElement(By.xpath("//*[text()='No options']")).isDisplayed();
		Assert.assertTrue(elementdisplay);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator' dropdown in 'Propose Offset Issuances screen' is not display the edited Project Operator");
		
	}
}
