package pageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
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

public class Registry_Module3_MEC {
	WebDriver driver;
	publicHomePage PH;
	CommonMethods CM;
	public static Properties prop;
	private String ECDCEng;
	private String Exchange;
	private String ContractCodeEng;
	private String ContractCodeFr;
	private String existingExchange;
	private String existingContractCodeEng;
	private String existingContractCodeFr;
	WebDriverWait wait;
	
	
	@FindBy(xpath = "//button[text()='MENU']")
	WebElement MegaMenu;
	
	@FindBy(xpath = "//p[text()='Exchange Management']")
	WebElement MECLabelLink;

	// Manage Exchange and Contract Description Code
	@FindBy(xpath = "//h1[text()='Manage Exchange and Contract Description Code']")
	WebElement MECTitle;
	@FindBy(xpath = "//h2[text()='Exchange and Contract Description Codes']")
	WebElement MECCardLabel;
	@FindBy(xpath = "//div[contains(@class,'MuiDataGrid-columnHeader MuiDataGrid-columnHeader--sortable')]")
	List<WebElement> MECCardColumns;
	@FindBy(xpath = "//div[@class='MuiDataGrid-pinnedColumnHeaders MuiDataGrid-pinnedColumnHeaders--right css-1yo84k3']")
	WebElement QuickActionColumn;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[1]")
	WebElement MECInfoCard;
	
	@FindBy(xpath = "//button[@data-testid='more-actions']")
	WebElement MoreAction;
	@FindBy(xpath = "//p[text()='ADD EXCHANGE AND CONTRACT DESCRIPTION CODE']")
	WebElement AddSubMenu;
	@FindBy(xpath = "//input[@type='search']")
	WebElement SearchField;
	@FindBy(xpath = "//p[text()='The Exchange and Contract Description Code added successfully.']")
	WebElement SuccessMsg;
	@FindBy(xpath = "(//*[@data-testid='CloseIcon'])[2]")
	WebElement CloseMsg;
	@FindBy(xpath = "(//div[@data-field='contract_description_code_english'])[2]")
	WebElement SearchCodeGrid;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[3]")
	WebElement DisplayInDrpdownValue;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[4]")
	WebElement UserEnteredValue;
	@FindBy(xpath = "//*[@data-testid='MoreHorizIcon']")
	WebElement QuickActionBtn;
	@FindBy(xpath = "(//*[@data-testid='MoreHorizIcon'])[1]")
	WebElement QuickActionBtn1;
	@FindBy(xpath = "//span[text()='EDIT']")
	WebElement EditSubMenu;
	@FindBy(xpath = "(//span[@class='css-1pqd204'])[1]")
	WebElement StopDisplayInDropdownSubMenu;
	@FindBy(xpath = "//p[text()='The Exchange and Contract Description Code edited successfully.']")
	WebElement EditSuccessMsg;
	@FindBy(xpath = "(//*[@data-testid='MoreHorizIcon'])[2]")
	WebElement QuickAction2;
	@FindBy(xpath = "//button[text()='Welcome,']")
	WebElement WelcomeButton;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement Logout;
	@FindBy(xpath = "(//div[@data-field='updated_by'])[2]")
	WebElement UpdateByValue;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[5]")
	WebElement UpdateDateValue;

	// Edit Exchange and Contract Description Code Page
	@FindBy(xpath = "//h1[text()='Edit Exchange and Contract Description Code']")
	WebElement EditMECTitle;
	@FindBy(xpath = "//div[text()='Edit Exchange and Contract Description Code']")
	WebElement EditMECCardLabel;
	
	@FindBy(xpath = "//button[@data-testid='priv_modal_Continue']")
	WebElement EditContinueBtnPopUp;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Search']")
	WebElement WrngEditCntnuePopUpBtn;
	@FindBy(xpath = "//input[@name='displayInDropDown']")
	WebElement DisplayInDDCheckbox;
	@FindBy(xpath = "//label[text()='Comments']")
	WebElement CommentsLabel;
	@FindBy(xpath = "//input[@id='comments']")
	WebElement CommentsField;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[3]")
	WebElement UpdatedByField;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[2]")
	WebElement UpdatedDateField;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[1]")
	WebElement EditedECDC;
	@FindBy(xpath = "//p[@data-testid='updatedDate']")
	WebElement UpdatedDateLabel;
	@FindBy(xpath = "//p[@data-testid='updatedBy']")
	WebElement UpdatedByLabel;
	@FindBy(xpath = "//h2[text()='Exchange and Contract Description Code History']")
	WebElement ExchangeandContractDescriptionCodeHistoryCardLabel;
	
	// Add Exchange and Contract Description Code page
	@FindBy(xpath = "//h1[text()='Add Exchange and Contract Description Code']")
	WebElement AddMECTitle;
	@FindBy(xpath = "//div[text()='Add Exchange and Contract Description Code']")
	WebElement AddMECCardLabel;
	@FindBy(xpath = "(//div[@class='label-wrapper MuiBox-root css-0'])[1]")
	WebElement ExchangeLabel;
	@FindBy(xpath = "(//div[@class='label-wrapper MuiBox-root css-0'])[2]")
	WebElement ContractDescriptionCodeinEnglishLabel;
	@FindBy(xpath = "(//div[@class='label-wrapper MuiBox-root css-0'])[3]")
	WebElement ContractDescriptionCodeinFrenchLabel;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-v4i5id']")
	WebElement DisplayDropdownLabel;
	
	@FindBy(xpath = "//input[@id='exchangeCode']")
	WebElement AddExchange;
	@FindBy(xpath = "//p[@id='exchangeCode-helper-text']")
	WebElement ErrorMsgExchange;
	@FindBy(xpath = "//input[@id='contractDescriptionCodeEnglish']")
	WebElement AddCDCEng;
	@FindBy(xpath = "//p[@id='contractDescriptionCodeEnglish-helper-text']")
	WebElement ErrorMsgCDCEng;
	@FindBy(xpath = "//input[@id='contractDescriptionCodeFrench']")
	WebElement AddCDCFr;
	@FindBy(xpath = "//p[@id='contractDescriptionCodeFrench-helper-text']")
	WebElement ErrorMsgCDCFr;
	@FindBy(xpath = "//input[@name='displayInDropDown']")
	WebElement DisplayInDropdown;
	@FindBy(xpath = "//button[@data-testid='submitBtn']")
	WebElement SubmitBtn;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Search']")
	WebElement ContinueBtnPopUp;
	@FindBy(xpath = "//h6[text()='Confirm!']")
	WebElement ConfirmMsg;
//	@FindBy(xpath = "//p[@id=\"contractDescriptionCodeEnglish-helper-text\"]")
//	WebElement Char63ErrorMsgCDCEng;
//	@FindBy(xpath = "//p[@id=\"contractDescriptionCodeFrench-helper-text\"]")
//	WebElement Char63ErrorMsgCDCFr;

	@FindBy(xpath = "//button[@data-testid='cancelBtn']")
	WebElement CancelBtn;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Cancel']")
	WebElement CancelPopUpBtn;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Continue']")
	WebElement CntinuePopUpBtn;

	@FindBy(xpath = "//h6[text()='Warning!']")
	WebElement WarningmMsg;

	JavascriptExecutor js;

	public Registry_Module3_MEC(WebDriver driver) {

		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void navigateToManageMECPage() throws Exception {
		CM = new CommonMethods(driver);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MegaMenu));
		MegaMenu.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,950)", "");
		try {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MECLabelLink));
			MECLabelLink.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MECLabelLink));
			CM.click2(MECLabelLink, "javascriptClick", "Label");
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MECTitle));
		String PageTitle = MECTitle.getText();
		Assert.assertEquals(PageTitle, "Manage Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Admin navigated to Manage Exchange and Contract Description Code page");
	}
	
	public void verifyUI_ManageMECPage() throws Exception {
		navigateToManageMECPage();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MECCardLabel));
		Assert.assertEquals(MECCardLabel.getText(), "Exchange and Contract Description Codes");
		ObjectRepo.test.log(Status.PASS, "Exchange and Contract Description Codes grid is available on Manage Exchange and Contract Description Code page");
		Assert.assertEquals(MECInfoCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Information Card is displayed on Manage Exchange and Contract Description Code page");
		Assert.assertEquals(MoreAction.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "More Action Button is available on Manage Exchange and Contract Description Code page");
		List<String> Columns = Arrays.asList("Exchange and Contract Description Code in English", "Exchange and Contract Description Code in French", "Displayed in Dropdown", "User Entered?", "Updated Date", "Updated By");
		List<String> ActualColumns = new ArrayList<>();
		for(int j=0; j<MECCardColumns.size();j++){
			ActualColumns.add(MECCardColumns.get(j).getText());
			ObjectRepo.test.log(Status.PASS, "Columns present in the Exchange and Contract Description Codes Grid are: "+MECCardColumns.get(j).getText());
		}
		Assert.assertEquals(QuickActionColumn.getText(), "Quick Actions");
		ObjectRepo.test.log(Status.PASS, "Columns present in the Exchange and Contract Description Codes table are: Quick Actions");
		
		boolean allLabelMatch = true;
		for (int i = 0; i<Columns.size(); i++) {
			String ExpValue = Columns.get(i);
			String ActValue = ActualColumns.get(i);
			if (!ExpValue.equals(ActValue)) {
				allLabelMatch = false;
				break;
			}
		}
		if (allLabelMatch) {
			ObjectRepo.test.log(Status.PASS, "All the expected Columns are present on Exchange and Contract Description Codes Grid ");
		} else {
			ObjectRepo.test.log(Status.PASS, "All the expected Columns are present on Exchange and Contract Description Codes Grid ");
		}
	}

	public void navigateToAddMEC() throws Exception {
		navigateToManageMECPage();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(MoreAction));
		MoreAction.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(AddSubMenu));
		Assert.assertEquals(AddSubMenu.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS,
				" 'Add Exchange and Contract Description Code' submenu is displayed under More Actions menu.");
		AddSubMenu.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(AddMECTitle));
		String PageTitle = AddMECTitle.getText();
		Assert.assertEquals(PageTitle, "Add Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Admin navigated to Add Exchange and Contract Description Code page");
	}
	
	public void verifyUI_AddMEC() throws Exception {
		navigateToAddMEC();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MECInfoCard));
		Assert.assertEquals(MECInfoCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Information Card is displayed on Add Manage Exchange and Contract Description Code page");
		Assert.assertEquals(AddMECCardLabel.getText(), "Add Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS, "Add Exchange and Contract Description Code Card is displayed on Add Manage Exchange and Contract Description Code page");
		Assert.assertEquals(ExchangeLabel.getText().contains("Exchange") && AddExchange.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Exchange with input field is available on Add Exchange and Contract Description Code Card.");
		Assert.assertEquals(ContractDescriptionCodeinEnglishLabel.getText().contains("Contract Description Code in English") && AddCDCEng.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Contract Description Code in English with input field is available on Add Exchange and Contract Description Code Card.");
		Assert.assertEquals(ContractDescriptionCodeinFrenchLabel.getText().contains("Contract Description Code in French")&& AddCDCFr.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Contract Description Code in French with input field is available on Add Exchange and Contract Description Code Card.");
		Assert.assertEquals(DisplayDropdownLabel.getText().contains("Display in Dropdown")&& DisplayInDropdown.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "Display in Dropdown with checked Checkbox is available on Add Exchange and Contract Description Code Card.");
		Assert.assertEquals(CancelBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Cancel button is available on Add Exchange and Contract Description Code Card.");
		Assert.assertEquals(SubmitBtn.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit button is available on Add Exchange and Contract Description Code Card.");
	}

	public static String generateRandomString(String start, String Last) {
		int length = 3;
		boolean useLetters = true;
		boolean useNumbers = false;
		String generatedString = RandomStringUtils.random(length, useNumbers, useLetters);
		String randomString = (start + generatedString + Last);
		return randomString;
	}

	public void addMEC() throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(AddExchange));
		AddExchange.sendKeys(generateRandomString("test", "Exc"));
		Exchange = AddExchange.getAttribute("value");
		AddCDCEng.sendKeys(generateRandomString("test", "Eng"));
		ContractCodeEng = AddCDCEng.getAttribute("value");
		AddCDCFr.sendKeys(generateRandomString("test", "Fr"));
		ContractCodeFr = AddCDCFr.getAttribute("value");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "Label");
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(ConfirmMsg));
		String Confirm = ConfirmMsg.getText();
		Assert.assertEquals(Confirm, "Confirm!");
		ObjectRepo.test.log(Status.PASS, "Confirmation Pop-Up is displayed with 'Cancel' and 'Continue' button");
		ContinueBtnPopUp.click();
		wait = new WebDriverWait(driver, 40);
        wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String Success = SuccessMsg.getText();
		Assert.assertEquals(Success, "The Exchange and Contract Description Code added successfully.");
		ObjectRepo.test.log(Status.PASS, "Exchange and Contract Description Code added successfully");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CloseMsg));
		CloseMsg.click();
		ECDCEng = Exchange + " - " + ContractCodeEng;
//		String ECDCFr = Exchange + " - " + ContractCodeFr;
	}

	public void SerachCodeInGrid() throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SearchField));
		SearchField.click();
		SearchField.sendKeys(ECDCEng);
	}

	public void VerifyCodeAddedToMECTable() throws Exception {
		SerachCodeInGrid();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(SearchCodeGrid));
		String SearchGrid = SearchCodeGrid.getText();
		Thread.sleep(3000);
		Assert.assertEquals(ECDCEng.equals(SearchGrid), true);
		ObjectRepo.test.log(Status.PASS,
				"Exchange and Contract Description Code added displayed in Exchange and Contract Description Codes table.");
		Thread.sleep(3000);
		String DropdownValue = DisplayInDrpdownValue.getText();
		Assert.assertEquals(DropdownValue, "Yes");
		ObjectRepo.test.log(Status.PASS,
				"Displayed in the Dropdown is 'Yes' as Displayed in the Dropdown checkbox is checked while adding the code");
		String UserEnteredVal = UserEnteredValue.getText();
		Assert.assertEquals(UserEnteredVal, "No");
		ObjectRepo.test.log(Status.PASS, "User Entered value  is 'No' as Jurisdiction Admin created this record");
	}

	public void QuickActionButton() throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(QuickActionBtn));
		QuickActionBtn.click();
		Assert.assertEquals(StopDisplayInDropdownSubMenu.isDisplayed() && EditSubMenu.isDisplayed(), true);
	}

	public void navigateToEditExchangeandContractDescriptionCode() throws Exception {
		SerachCodeInGrid();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(QuickActionBtn));
		QuickActionBtn.click();
		Assert.assertEquals(StopDisplayInDropdownSubMenu.isDisplayed() && EditSubMenu.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"Display/Stop Display In Dropdown' & 'Edit' submenu is displayed under Quick Actions menu");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(EditSubMenu));
		EditSubMenu.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(EditMECTitle));
		String PageTitle = EditMECTitle.getText();
		Assert.assertEquals(PageTitle, "Edit Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS,"Jurisdiction Admin navigated to Edit Exchange and Contract Description Code page");
	}
	
	public void verifyUI_EditExchangeandContractDescriptionCode() throws Exception {
		navigateToManageMECPage();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(QuickActionBtn1));
		QuickActionBtn1.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(EditSubMenu));
		EditSubMenu.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(EditMECTitle));
		String PageTitle = EditMECTitle.getText();
		Assert.assertEquals(PageTitle, "Edit Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS,"Jurisdiction Admin navigated to Edit Exchange and Contract Description Code page");
		Assert.assertEquals(MECInfoCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Information Card is displayed on Edit Manage Exchange and Contract Description Code page");
		Assert.assertEquals(EditMECCardLabel.getText(), "Edit Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS, "Edit Exchange and Contract Description Code is displayed on Edit Manage Exchange and Contract Description Code page");
		Assert.assertEquals(ExchangeLabel.getText().contains("Exchange") && AddExchange.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Exchange with input field is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(ContractDescriptionCodeinEnglishLabel.getText().contains("Contract Description Code in English") && AddCDCEng.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Contract Description Code in English with input field is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(ContractDescriptionCodeinFrenchLabel.getText().contains("Contract Description Code in French")&& AddCDCFr.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Contract Description Code in French with input field is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(DisplayDropdownLabel.getText().contains("Display in Dropdown")&& DisplayInDropdown.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Display in Dropdown with Checkbox is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(CancelBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Cancel button is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(SubmitBtn.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit button is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(CommentsLabel.getText().contains("Comments")&& CommentsField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Comment with input field is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(UpdatedDateLabel.getText(), "Updated Date");
		ObjectRepo.test.log(Status.PASS, "Updated Date field is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(UpdatedByLabel.getText(), "Updated By");
		ObjectRepo.test.log(Status.PASS, "Updated By field is available on Edit Exchange and Contract Description Code Card.");
		Assert.assertEquals(ExchangeandContractDescriptionCodeHistoryCardLabel.getText(), "Exchange and Contract Description Code History");
		ObjectRepo.test.log(Status.PASS, "Exchange and Contract Description Code History card is displayed on Edit Manage Exchange and Contract Description Code page");
		List<String> Columns = Arrays.asList("Exchange and Contract Description Code in English", "Exchange and Contract Description Code in French", "Displayed in Dropdown", "Comments", "Updated Date", "Updated By");
		List<String> ActualColumns = new ArrayList<>();
		for(int j=0; j<MECCardColumns.size();j++){
			ActualColumns.add(MECCardColumns.get(j).getText());
			ObjectRepo.test.log(Status.PASS, "Labels present in the Acquiring Account Card are: "+MECCardColumns.get(j).getText());
		}
		boolean allLabelMatch = true;
		for (int i = 0; i<Columns.size(); i++) {
			String ExpValue = Columns.get(i);
			String ActValue = ActualColumns.get(i);
			if (!ExpValue.equals(ActValue)) {
				allLabelMatch = false;
				break;
			}
		}
		if (allLabelMatch) {
			ObjectRepo.test.log(Status.PASS, "All the expected Columns are present on Exchange and Contract Description Code History Grid ");
		} else {
			ObjectRepo.test.log(Status.PASS, "All the expected Columns are present on Exchange and Contract Description Code History Grid ");
		}
	}
	
	public void VerifyExchangeandContractDescriptionCodeHistoryTable() throws Exception {
		navigateToEditExchangeandContractDescriptionCode();
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)", "");
		String Record = SearchCodeGrid.getText();
		Assert.assertEquals(ECDCEng.equals(Record), true);
		ObjectRepo.test.log(Status.PASS,
				"Added Record displayed in the Exchange and Contract Description Code History Table.");
	}

	public void verifyCancelBtnOnAddMEC() throws Exception {
		navigateToAddMEC();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(WarningmMsg));
		String wrngMsg = WarningmMsg.getText();
		Assert.assertEquals(wrngMsg, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning message is diplayed with 'Cancel' and 'Continue' button");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelPopUpBtn));
		CancelPopUpBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(AddMECTitle));
		Assert.assertEquals(AddMECTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is closed and user remains on same page");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelPopUpBtn));
		CntinuePopUpBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MECTitle));
		String PageTitle = MECTitle.getText();
		Assert.assertEquals(PageTitle, "Manage Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Admin is navigated to ‘Manage Exchange and Contract Description Code’ screen");
	}

	public void verifyMECForAuth() throws Exception {
		navigateToManageMECPage();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MoreAction));
		try {
			Assert.assertEquals(MoreAction.isDisplayed() && QuickActionBtn.isDisplayed(), true);
			ObjectRepo.test.log(Status.PASS,
					"More Action and Quick Action Button is enabled for Othen than Admin User");
		} catch (Exception ex) {
			ObjectRepo.test.log(Status.PASS,
					"More Action and Quick Action Button is disabled for Othen than Admin User");
		}
	}

	public void verifyCancelBtnOnEditMEC() throws Exception {
		CM = new CommonMethods(driver);
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			CancelBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CM.click2(CancelBtn, "javascriptClick", "Cancel");
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(WarningmMsg));
		String wrngMsg = WarningmMsg.getText();
		Assert.assertEquals(wrngMsg, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning message is diplayed with 'Cancel' and 'Continue' button");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelPopUpBtn));
		CancelPopUpBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(EditMECTitle));
		Assert.assertEquals(EditMECTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is closed and user remains on same page");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		CancelBtn.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(EditContinueBtnPopUp));
		EditContinueBtnPopUp.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MECTitle));
		String PageTitle = MECTitle.getText();
		Assert.assertEquals(PageTitle, "Manage Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Admin is navigated to ‘Manage Exchange and Contract Description Code’ screen");
	}

	public void existing_Exchange_CDCEng_And_CDCFrench_Code() throws Exception {
		QuickAction2.click();
		EditSubMenu.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(MECTitle));
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(AddExchange));
		existingExchange = AddExchange.getAttribute("value");
		existingContractCodeEng = AddCDCEng.getAttribute("value");
		existingContractCodeFr = AddCDCFr.getAttribute("value");
		try {
			CancelBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(CancelBtn, "moveToElementClick", "Cancel");
		}
		CntinuePopUpBtn.click();
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_BykeepingFields_Empty_AddPage() throws Exception {
		navigateToAddMEC();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(AddExchange));
		AddExchange.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(AddCDCEng));
		AddCDCEng.click();
		AddCDCFr.click();
		DisplayInDropdown.click();
		String ExcErrMsg = ErrorMsgExchange.getText();
		String CDCEngErrMsg = ErrorMsgCDCEng.getText();
		String CDCFrErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(ExcErrMsg, "Exchange is required");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for empty Exchange field");
		Assert.assertEquals(CDCEngErrMsg, "Contract Description Code in English is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for empty Contract Description Code in English field");
		Assert.assertEquals(CDCFrErrMsg, "Contract Description Code in French is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for empty Contract Description Code in French field");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Sapce_AddPage() {
		AddExchange.sendKeys(Keys.SPACE);
		AddCDCEng.sendKeys(Keys.SPACE);
		AddCDCFr.sendKeys(Keys.SPACE);
		String ExcErrMsg = ErrorMsgExchange.getText();
		String CDCEngErrMsg = ErrorMsgCDCEng.getText();
		String CDCFrErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(ExcErrMsg, "Exchange is required");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for Exchange field by entering space");
		Assert.assertEquals(CDCEngErrMsg, "Contract Description Code in English is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Contract Description Code in English field by entering space");
		Assert.assertEquals(CDCFrErrMsg, "Contract Description Code in French is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Contract Description Code in French field by entering space");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Morethan63Char_AddPage() {
		AddExchange.sendKeys("GFGDSUIHUYFREYHBJNBXSXFYGUTRDVKIYBIIIODJFNFDGHUFGHUHHGYMBGUZ");
		AddCDCEng.sendKeys("Q");
		AddCDCFr.sendKeys("Q");
		String CDCEngErrMsg = ErrorMsgCDCEng.getText();
		String CDCFrErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(CDCEngErrMsg,
				"The Exchange and Contract Description Code in English value cannot be longer than 63 characters.");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Exchange and  Contract Description Code in English field by entering more than 63 chars");
		Assert.assertEquals(CDCFrErrMsg,
				"The Exchange and Contract Description Code in French value cannot be longer than 63 characters.");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Exchange and  Contract Description Code in French field by entering more than 63 chars");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_ExistingCode_AddPage() throws Exception {
		String ExchangeValue = AddExchange.getAttribute("value");
		int ExcValueSize = ExchangeValue.length();
		for (int i = 1; i <= ExcValueSize; i++) {
			AddExchange.sendKeys(Keys.BACK_SPACE);
		}
		String CDCEngValue = AddCDCEng.getAttribute("value");
		int CDCEngValueSize = CDCEngValue.length();
		for (int i = 1; i <= CDCEngValueSize; i++) {
			AddCDCEng.sendKeys(Keys.BACK_SPACE);
		}
		String CDCFrValue = AddCDCFr.getAttribute("value");
		int CDCFrValueSize = CDCFrValue.length();
		for (int i = 1; i <= CDCFrValueSize; i++) {
			AddCDCFr.sendKeys(Keys.BACK_SPACE);
		}
		addMEC();
		MoreAction.click();
		AddSubMenu.click();
		AddExchange.sendKeys(Exchange);
		AddCDCEng.sendKeys(ContractCodeEng);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(AddCDCFr));
		AddCDCFr.sendKeys(ContractCodeFr);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(ErrorMsgCDCFr));
		String ErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(ErrMsg,
				"The 'Exchange and Contract Description Code' you have entered already exists and cannot be created again.");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Exchange and  Contract Description Code in French field by entering existing code");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Validdata_AddPage() throws Exception {
		String ExchangeValue = AddExchange.getAttribute("value");
		int ExcValueSize = ExchangeValue.length();
		for (int i = 1; i <= ExcValueSize; i++) {
			AddExchange.sendKeys(Keys.BACK_SPACE);
		}
		String CDCEngValue = AddCDCEng.getAttribute("value");
		int CDCEngValueSize = CDCEngValue.length();
		for (int i = 1; i <= CDCEngValueSize; i++) {
			AddCDCEng.sendKeys(Keys.BACK_SPACE);
		}
		String CDCFrValue = AddCDCFr.getAttribute("value");
		int CDCFrValueSize = CDCFrValue.length();
		for (int i = 1; i <= CDCFrValueSize; i++) {
			AddCDCFr.sendKeys(Keys.BACK_SPACE);
		}
		addMEC();
	}

	
	public void Verify_Displayed_in_Drop_Down_is_checked_on_Edit_Exchange_and_Contract_Description_Code_card()
			throws Exception {
		navigateToAddMEC();
		addMEC();
		navigateToEditExchangeandContractDescriptionCode();
		Thread.sleep(4000);
		AddExchange.sendKeys("12");
		ECDCEng = AddExchange.getAttribute("value");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "Submit");
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ContinueBtnPopUp));
		ContinueBtnPopUp.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CloseMsg));
		CloseMsg.click();
		SerachCodeInGrid();
		String DropdownValue = DisplayInDrpdownValue.getText();
		Assert.assertEquals(DropdownValue, "Yes");
		ObjectRepo.test.log(Status.PASS,
				"Value in 'Displayed in Dropdown' column is 'Yes' for that specific code after editing the code");
	}

	public void Verify_Displayed_in_Drop_Down_is_Unchecked_on_Edit_Exchange_and_Contract_Description_Code_card()
			throws Exception {
		navigateToAddMEC();
		addMEC();
		navigateToEditExchangeandContractDescriptionCode();
		Thread.sleep(4000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(DisplayInDDCheckbox));
		DisplayInDDCheckbox.click();
		ObjectRepo.test.log(Status.PASS, "'Displayed in Dropdown' checkbox is unchecked");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "Submit");
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(ContinueBtnPopUp));
		ContinueBtnPopUp.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CloseMsg));
		CloseMsg.click();
		SerachCodeInGrid();
		String DropdownValue = DisplayInDrpdownValue.getText();
		Assert.assertEquals(DropdownValue, "No");
		ObjectRepo.test.log(Status.PASS,
				"Value in 'Displayed in Dropdown' column is 'No' for that specific code after editing the code");
	}

	public void Verify_previous_filled_data_Edit_Page() throws Exception {
		navigateToAddMEC();
		addMEC();
		navigateToEditExchangeandContractDescriptionCode();
		Thread.sleep(3000);
		String ExchangeValue = AddExchange.getAttribute("value");
		String CDCEngValue = AddCDCEng.getAttribute("value");
		String CDCFrValue = AddCDCFr.getAttribute("value");
		Assert.assertEquals(Exchange.equals(ExchangeValue), true);
		Assert.assertEquals(ContractCodeEng.equals(CDCEngValue), true);
		Assert.assertEquals(ContractCodeFr.equals(CDCFrValue), true);
		ObjectRepo.test.log(Status.PASS,
				"The previously filled data is displayed for 'Exchange', 'Contract Description Code in English' and 'Contract Description Code in French'");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_ByClearingFields_Empty_EditPage() {
		String ExchangeValue = AddExchange.getAttribute("value");
		String CDCEngValue = AddCDCEng.getAttribute("value");
		String CDCFrValue = AddCDCFr.getAttribute("value");
		int ExcValueSize = ExchangeValue.length();
		for (int i = 1; i <= ExcValueSize; i++) {
			AddExchange.sendKeys(Keys.BACK_SPACE);
		}

		int CDCEngValueSize = CDCEngValue.length();
		for (int i = 1; i <= CDCEngValueSize; i++) {
			AddCDCEng.sendKeys(Keys.BACK_SPACE);
		}

		int CDCFrValueSize = CDCFrValue.length();
		for (int i = 1; i <= CDCFrValueSize; i++) {
			AddCDCFr.sendKeys(Keys.BACK_SPACE);
		}

		String ExcErrMsg = ErrorMsgExchange.getText();
		String CDCEngErrMsg = ErrorMsgCDCEng.getText();
		String CDCFrErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(ExcErrMsg, "Exchange is required");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for empty Exchange field");
		Assert.assertEquals(CDCEngErrMsg, "Contract Description Code in English is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for empty Contract Description Code in English field");
		Assert.assertEquals(CDCFrErrMsg, "Contract Description Code in French is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for empty Contract Description Code in French field");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Sapce_EditPage() {
		AddExchange.sendKeys(Keys.SPACE);
		AddCDCEng.sendKeys(Keys.SPACE);
		AddCDCFr.sendKeys(Keys.SPACE);
		String ExcErrMsg = ErrorMsgExchange.getText();
		String CDCEngErrMsg = ErrorMsgCDCEng.getText();
		String CDCFrErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(ExcErrMsg, "Exchange is required");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for Exchange field by entering space");
		Assert.assertEquals(CDCEngErrMsg, "Contract Description Code in English is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Contract Description Code in English field by entering space");
		Assert.assertEquals(CDCFrErrMsg, "Contract Description Code in French is required");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Contract Description Code in French field by entering space");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Morethan63Char_EditPage() {
		String ExchangeValue = AddExchange.getAttribute("value");
		String CDCEngValue = AddCDCEng.getAttribute("value");
		String CDCFrValue = AddCDCFr.getAttribute("value");
		int ExcValueSize = ExchangeValue.length();
		for (int i = 1; i <= ExcValueSize; i++) {
			AddExchange.sendKeys(Keys.BACK_SPACE);
		}

		int CDCEngValueSize = CDCEngValue.length();
		for (int i = 1; i <= CDCEngValueSize; i++) {
			AddCDCEng.sendKeys(Keys.BACK_SPACE);
		}

		int CDCFrValueSize = CDCFrValue.length();
		for (int i = 1; i <= CDCFrValueSize; i++) {
			AddCDCFr.sendKeys(Keys.BACK_SPACE);
		}
		AddExchange.sendKeys("GFGDSUIHUYFREYHBJNBXSXFYGUTRDVKIYBIIIODJFNFDGHUFGHUHHGYMBGUZ");
		AddCDCEng.sendKeys("Q");
		AddCDCFr.sendKeys("Q");
		String CDCEngErrMsg = ErrorMsgCDCEng.getText();
		String CDCFrErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(CDCEngErrMsg,
				"The Exchange and Contract Description Code in English value cannot be longer than 63 characters.");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Exchange and  Contract Description Code in English field by entering more than 63 chars");
		Assert.assertEquals(CDCFrErrMsg,
				"The Exchange and Contract Description Code in French value cannot be longer than 63 characters.");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Exchange and  Contract Description Code in French field by entering more than 63 chars");
	}

	public void Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_ExistingCode_EditPage() throws Exception {
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(CancelBtn, "javascriptClick", "Cancel");
		}
		CntinuePopUpBtn.click();
		Thread.sleep(3000);
		existing_Exchange_CDCEng_And_CDCFrench_Code();
		navigateToEditExchangeandContractDescriptionCode();
		String ExchangeValue = AddExchange.getAttribute("value");
		int ExcValueSize = ExchangeValue.length();
		for (int i = 1; i <= ExcValueSize; i++) {
			AddExchange.sendKeys(Keys.BACK_SPACE);
		}
		String CDCEngValue = AddCDCEng.getAttribute("value");
		int CDCEngValueSize = CDCEngValue.length();
		for (int i = 1; i <= CDCEngValueSize; i++) {
			AddCDCEng.sendKeys(Keys.BACK_SPACE);
		}
		String CDCFrValue = AddCDCFr.getAttribute("value");
		int CDCFrValueSize = CDCFrValue.length();
		for (int i = 1; i <= CDCFrValueSize; i++) {
			AddCDCFr.sendKeys(Keys.BACK_SPACE);
		}
		AddExchange.sendKeys(existingExchange);
		AddCDCEng.sendKeys(existingContractCodeEng);
		AddCDCFr.sendKeys(existingContractCodeFr);
		String ErrMsg = ErrorMsgCDCFr.getText();
		Assert.assertEquals(ErrMsg, "The 'Exchange and Contract Description Code' you have entered already exists.");
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed for Exchange and  Contract Description Code in French field by entering existing code");
	}
	
	public void verify_Comment_Field_EditPage() {
		int length = 8001;
		boolean useLetters = false;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useNumbers, useLetters);
		String randomString = (generatedString);
		String ExchangeValue = AddExchange.getAttribute("value");
		int ExcValueSize = ExchangeValue.length();
		for (int i = 1; i <= ExcValueSize; i++) {
			AddExchange.sendKeys(Keys.BACK_SPACE);
		}
		String CDCEngValue = AddCDCEng.getAttribute("value");
		int CDCEngValueSize = CDCEngValue.length();
		for (int i = 1; i <= CDCEngValueSize; i++) {
			AddCDCEng.sendKeys(Keys.BACK_SPACE);
		}
		String CDCFrValue = AddCDCFr.getAttribute("value");
		int CDCFrValueSize = CDCFrValue.length();
		for (int i = 1; i <= CDCFrValueSize; i++) {
			AddCDCFr.sendKeys(Keys.BACK_SPACE);
		}
		AddExchange.sendKeys(Exchange);
		AddCDCEng.sendKeys(ContractCodeEng);
		AddCDCFr.sendKeys(ContractCodeFr);
		CommentsField.sendKeys(randomString);
		
	}
	
	public void verify_EditFunctionality_Other_JurisdictionAdmin() throws Exception {
		String Admin1 = UpdateByValue.getText();
		ObjectRepo.test.log(Status.PASS, " Value of 'Updated By'column is: "+Admin1);
		WelcomeButton.click(); 
		Logout.click();
		PH= new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("Washington", "JurisdictionAdmin");
		PH.secQueAns();
		navigateToManageMECPage();
		navigateToEditExchangeandContractDescriptionCode();
		Thread.sleep(4000);
		AddExchange.sendKeys("1");
		AddCDCEng.sendKeys("2");
		AddCDCFr.sendKeys("3");
		String editedExchange = AddExchange.getAttribute("value");
		String editedCDCEng =  AddCDCEng.getAttribute("value");
		String editedCDCFr = AddCDCFr.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Exchange and Contract Description Code is edited by Washington Jurisdiction Admin");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "Submit");
		}
		ContinueBtnPopUp.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CloseMsg));
		CloseMsg.click();
		String Admin2 = UpdateByValue.getText();
		Assert.assertEquals(Admin1.equals(Admin2), false);
		ObjectRepo.test.log(Status.PASS, " 'Updated By' field is updated with the Washington Jurisdiction Admin who has edited the Exchange and Contract Description Code");
		ObjectRepo.test.log(Status.PASS, " Value of 'Updated By'column is: "+Admin2);
		ECDCEng = editedExchange+ " - " +editedCDCEng;
		SerachCodeInGrid();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(SearchCodeGrid));
		String SearchGrid = SearchCodeGrid.getText();
		Thread.sleep(3000);
		Assert.assertEquals(ECDCEng.equals(SearchGrid), true);
		ObjectRepo.test.log(Status.PASS, "Edited Exchange and Contract Description Code added displayed in Exchange and Contract Description Codes table.");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(DisplayInDrpdownValue));
		String DropdownValue = DisplayInDrpdownValue.getText();
		Assert.assertEquals(DropdownValue, "Yes");
		ObjectRepo.test.log(Status.PASS, "Displayed in the Dropdown is 'Yes' as Displayed in the Dropdown checkbox is checked while editing the code");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(UserEnteredValue));
		String UserEnteredVal = UserEnteredValue.getText();
		Assert.assertEquals(UserEnteredVal, "No");
		ObjectRepo.test.log(Status.PASS, "User Entered value  is 'No' as Jurisdiction Admin edited this record");
	}
	
	public void verify_EditFunctionalityon_Edit_Exchange_and_Contract_Description_Code_page_Other_JurisdictionAdmin() throws Exception{
		WelcomeButton.click(); 
		Logout.click();
		PH= new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("Washington", "JurisdictionAdmin");
		PH.secQueAns();
		navigateToManageMECPage();
		navigateToEditExchangeandContractDescriptionCode();
		Thread.sleep(4000);
		AddExchange.sendKeys("1");
		AddCDCEng.sendKeys("2");
		AddCDCFr.sendKeys("3");
		Thread.sleep(3000);
		Exchange = AddExchange.getAttribute("value");
		ContractCodeEng =  AddCDCEng.getAttribute("value");
		ContractCodeFr = AddCDCFr.getAttribute("value");
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "Submit");
		}
		ContinueBtnPopUp.click();
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(CloseMsg));
		CloseMsg.click();
		ECDCEng = Exchange+ " - " +ContractCodeEng;
		SerachCodeInGrid();
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(UpdateDateValue));
		String updatedDateValue = UpdateDateValue.getText();
		String Admin2 = UpdateByValue.getText();
		QuickActionBtn.click();
		EditSubMenu.click();
		Thread.sleep(4000);
		String ExchangeValue = AddExchange.getAttribute("value");
		String CDCEngValue = AddCDCEng.getAttribute("value");
		String CDCFrValue = AddCDCFr.getAttribute("value");
		Assert.assertEquals(Exchange.equals(ExchangeValue), true);
		Assert.assertEquals(ContractCodeEng.equals(CDCEngValue), true);
		Assert.assertEquals(ContractCodeFr.equals(CDCFrValue), true);
		ObjectRepo.test.log(Status.PASS, "'Exchange', 'Contract Description Code in English' and 'Contract Description Code in French' is updated with edited values");
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(UpdatedDateField));
		String updatedDate = UpdatedDateField.getText();
		String updateBy = UpdatedByField.getText();
		Assert.assertEquals(updatedDate.equals(updatedDateValue), true);
		Assert.assertEquals(updateBy.equals(Admin2), true);
		ObjectRepo.test.log(Status.PASS, " 'Updated Date' and 'Updated By' field should be updated");
		String editedECDC = EditedECDC.getText();
		Assert.assertEquals(editedECDC.equals(ECDCEng), true);
		ObjectRepo.test.log(Status.PASS, "Edited Record is added to the  'Exchange and Contract Description Code History' Table.");	
	}

}
