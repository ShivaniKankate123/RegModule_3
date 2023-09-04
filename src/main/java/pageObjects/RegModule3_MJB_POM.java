package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import resources.ObjectRepo;

public class RegModule3_MJB_POM {

	WebDriver driver;
	JavascriptExecutor js;
	String AddBudgetYear;
	CommonMethods CM;
	Properties prop;
	publicHomePage PH;
//	String ReserveBudget;
	String ReserveAllowancesIssued;

	// All Jurisdiction Page for WCI Inc Admin
	@FindBy(xpath = "//*[@id='panel1a-header']")
	WebElement AllJurisdiction;
	@FindBy(xpath = "//div[text()='Jurisdiction']")
	WebElement AllJurisdictionColumn1;
	@FindBy(xpath = "//div[text()='California']")
	WebElement JurisdictionValueColumn1;
	@FindBy(xpath = "//div[text()='Nova Scotia']")
	WebElement JurisdictionValueColumn2;
	@FindBy(xpath = "//div[text()='Quebec']")
	WebElement JurisdictionValueColumn3;
	@FindBy(xpath = "//div[text()='Washington State']")
	WebElement JurisdictionValueColumn4;
	@FindBy(xpath = "//div[text()='Jurisdiction ID']")
	WebElement AllJurisdictionColumn2;
	@FindBy(xpath = "//div[text()='25639c51-f558-440b-90ab-ee496dd32f27']")
	WebElement JurisdictionIDValueColumn1;
	@FindBy(xpath = "//div[text()='377a3150-11b0-4066-b1ac-bd1228c796f6']")
	WebElement JurisdictionIDValueColumn2;
	@FindBy(xpath = "//div[text()='01df741e-1036-4d00-a941-e650eece959f']")
	WebElement JurisdictionIDValueColumn3;
	@FindBy(xpath = "//div[text()='8ed88405-b7de-497c-94b7-38aaef0f6293']")
	WebElement JurisdictionIDValueColumn4;
	@FindBy(xpath = "//div[text()='2 Letter Code']")
	WebElement AllJurisdictionColumn3;
	@FindBy(xpath = "//div[text()='CA']")
	WebElement JurisdictionCodeValueColumn1;
	@FindBy(xpath = "//div[text()='NS']")
	WebElement JurisdictionCodeValueColumn2;
	@FindBy(xpath = "//div[text()='QC']")
	WebElement JurisdictionCodeValueColumn3;
	@FindBy(xpath = "//div[text()='WA']")
	WebElement JurisdictionCodeValueColumn4;
	@FindBy(xpath = "//div[text()='Status']")
	WebElement AllJurisdictionColumn4;
	@FindBy(xpath = "(//div[text()='Active'])[1]")
	WebElement JurisdictionStatusValueColumn1;
	@FindBy(xpath = "(//div[text()='Active'])[2]")
	WebElement JurisdictionStatusValueColumn2;
	@FindBy(xpath = "(//div[text()='Active'])[3]")
	WebElement JurisdictionStatusValueColumn3;
	@FindBy(xpath = "(//div[text()='Active'])[4]")
	WebElement JurisdictionStatusValueColumn4;
	@FindBy(xpath = "//div[text()='Quick Actions']")
	WebElement AllJurisdictionColumn5;

	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")
	WebElement QuickActionCalifornia;
	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[2]")
	WebElement QuickActionNS;
	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[3]")
	WebElement QuickActionQuebec;
	@FindBy(xpath = "(//*[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[4]")
	WebElement QuickActionWashington;

	@FindBy(xpath = "//p[text()='MANAGE BUDGET']")
	WebElement ManageBudget;
	@FindBy(xpath = "//p[text()='MANAGE PURCHASE LIMIT']")
	WebElement ManagePurchaseLimit;

	@FindBy(xpath = "//h1[text()='Manage Jurisdiction Budget']")
	WebElement ManageJurisdictionBudget;
	@FindBy(xpath = "//div[text()='Budget Details']")
	WebElement BudgetDetailsCard;
	@FindBy(xpath = "//p[text()='Jurisdiction']")
	WebElement BudgetDetailsJurisdiction;
	@FindBy(xpath = "//p[text()='California']")
	WebElement BudgetDetailsJurisdictionValue;
	@FindBy(xpath = "//button[@data-testid='add-btn']")
	WebElement ButtonAddBudgetRecords;
	@FindBy(xpath = "//div[text()='Effective Budget Records']")
	WebElement EffectiveBudgetRecordsCard;
	@FindBy(xpath = "//div[text()='Proposed Budget Records']")
	WebElement ProposedBudgetRecordsCard;
	@FindBy(xpath = "//div[text()='Jurisdiction Allowance Request Status History']")
	WebElement JurisdictionAllowanceRequestStatusHistoryCard;

	// Add Budget Records Page
	@FindBy(xpath = "//h1[text()='Add Budget Records']")
	WebElement HeadingAddBudgetRecords;
	@FindBy(xpath = "//h2[text()='Add Records']")
	WebElement HeadingAddRecords;
	@FindBy(xpath = "//div[text()='Budget Year']")
	WebElement BudgetYearColumn1;
	@FindBy(xpath = "//strong[text()='Annual Allowance Budget']")
	WebElement AnnualAllowanceBudgetColumn2;
	@FindBy(xpath = "//strong[text()='Reserve Adjusted Allowance Budget']")
	WebElement ReserveAdjustedAllowanceBudgetColumn3;
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement ButtonCancel;
	@FindBy(xpath = "//button[text()='Propose']")
	WebElement ButtonPropose;

	// Add Budget Record pop-up UI
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[1]")
	WebElement EnterAnnualAllowanceBudget;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[2]")
	WebElement EnterReserveAdjustedAllowanceBudget;
	@FindBy(xpath = "(//input[@class='MuiInputBase-input MuiOutlinedInput-input css-1x5jdmq'])[15]")
	WebElement EnterReserveAdjustedAllowanceBudget15;
	@FindBy(xpath = "//h6[text()='Confirm Proposal']")
	WebElement ProposeBudgetPopupHeading;
	@FindBy(xpath = "//p[text()='Are you sure you would like to propose the entered budget records?']")
	WebElement ProposeBudgetPopupSubHeading;
	@FindBy(xpath = "//button[text()='CANCEL']")
	WebElement ProposeBudgetPopupCancelButton;
	@FindBy(xpath = "//button[text()='CONTINUE']")
	WebElement ProposeBudgetPopupContinueButton;
	@FindBy(xpath = "//h6[text()='Warning!']")
	WebElement CancelBudgetPopupHeading;
	@FindBy(xpath = "//p[text()='Clicking “Continue” will take you back to the previous page.']")
	WebElement CancelBudgetPopupSubHeading;
	@FindBy(xpath = "//p[text()='No changes will be saved.']")
	WebElement CancelBudgetPopupSubHeading1;

	// Add Budget Record Page Validations
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[2]")
	WebElement EffectiveBudgetRecord1;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[3]")
	WebElement EffectiveBudgetRecord2;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[4]")
	WebElement EffectiveBudgetRecord3;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[5]")
	WebElement EffectiveBudgetRecord4;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[6]")
	WebElement EffectiveBudgetRecord5;

	@FindBy(xpath = "(//div[@data-field='budgetYear'])[2]")
	WebElement AddBudgetRecordYear1;

	@FindBy(xpath = "//div[@data-field='budgetYear']")
	List<WebElement> BudgetYears;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[3]")
	WebElement AddBudgetRecordYear2;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[4]")
	WebElement AddBudgetRecordYear3;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[5]")
	WebElement AddBudgetRecordYear4;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[6]")
	WebElement AddBudgetRecordYear5;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[7]")
	WebElement AddBudgetRecordYear6;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[8]")
	WebElement AddBudgetRecordYear7;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[9]")
	WebElement AddBudgetRecordYear8;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[10]")
	WebElement AddBudgetRecordYear9;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[11]")
	WebElement AddBudgetRecordYear10;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[12]")
	WebElement AddBudgetRecordYear11;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[13]")
	WebElement AddBudgetRecordYear12;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[14]")
	WebElement AddBudgetRecordYear13;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[15]")
	WebElement AddBudgetRecordYear14;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[16]")
	WebElement AddBudgetRecordYear15;

	// Edit Budget Record Cancel Button Functionality for Effective Budget Records
	@FindBy(xpath = "//div[text()='Effective Budget Records']")
	WebElement EffectiveBudgetRecordsGridTitle;
	@FindBy(xpath = "//div[@class='MuiDataGrid-cell--withRenderer MuiDataGrid-cell MuiDataGrid-cell--textCenter']")
	WebElement MoreActionsButtonOnEffectiveBudgetRecordsGrid;
	@FindBy(xpath = "//p[text()='Edit Budget Record']")
	WebElement EditBudgetRecordButtonOnEffectiveBudgetRecordsGrid;

	@FindBy(xpath = "//div[text()='Edit Budget Record']")
	WebElement EditEffectiveBudgetRecordsPopupCard;
	@FindBy(xpath = "//label[text()='Budget Year']")
	WebElement LabelBudgetYear;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 css-1cpdyr0']")
	WebElement ValueBudgetYear;
	@FindBy(xpath = "//label[text()='Annual Allowance Budget']")
	WebElement LabelAnnualAllowanceBudget;
	@FindBy(xpath = "//input[@name='annualAllowanceBudget']")
	WebElement AnnualAllowanceBudgetTextfield;
	@FindBy(xpath = "//label[text()='Reserve Adjusted Allowance Budget']")
	WebElement LabelReserveAdjustedAllowanceBudget;
	@FindBy(xpath = "//input[@name='reserveAdjustedAllowanceBudget']")
	WebElement ReserveAdjustedAllowanceBudgetTextfield;
	@FindBy(xpath = "//p[text()='Comments']")
	WebElement LabelComments;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we']")
	WebElement ValueComments;

	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement CancelButtonOnEditEffectiveBudgetRecordsGrid;
	@FindBy(xpath = "//button[text()='Propose']")
	WebElement ProposeButtonOnEditEffectiveBudgetRecordsGrid;
	@FindBy(xpath = "//h6[text()='Warning!']")
	WebElement WarningTitleOnEditEffectiveBudgetRecordsPopup;
	@FindBy(xpath = "//p[text()='Are you sure you want to proceed with this action?']")
	WebElement WarningMessageOnEditEffectiveBudgetRecordsPopup;
	@FindBy(xpath = "(//button[text()='CANCEL'])[2]")
	WebElement CancelButtonOnEditEffectiveBudgetRecordsPopup;
	@FindBy(xpath = "(//button[@data-testid='priv_modal_Continue'])[2]")
	WebElement ContinueButtonOnEditEffectiveBudgetRecordsPopup;
	@FindBy(xpath = "//div[text()='Request Status']")
	WebElement ColumnNameRequestStatus;
	// Edit Proposed Budget Records
	@FindBy(xpath = "//div[text()='Proposed Budget Records']")
	WebElement ProposedBudgetRecordsGridTitle;
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[6]")
	WebElement MoreActionsButtonOnProposedBudgetRecordsGrid;
	@FindBy(xpath = "//p[text()='CANCEL PROPOSED RECORD']")
	WebElement CancelProposedRecordButton;
	@FindBy(xpath = "//p[text()='Are you sure you want to remove the proposed budget record?']")
	WebElement WarningMessageOnEditProposedBudgetPopup;
	@FindBy(xpath = "//h6[text()='Warning!']")
	WebElement WarningHeadingOnEditProposedBudgetPopup;
	@FindBy(xpath = "//button[text()='CANCEL']")
	WebElement CancelButtonOnEditProposedBudgetPopup;
	@FindBy(xpath = "//button[text()='CONTINUE']")
	WebElement ContinueButtonOnEditProposedBudgetPopup;
	@FindBy(xpath = "//div[@title='Cancelled']")
	WebElement RequestHistoryStatusForcancelledRecord;
	// Cancel Edit Proposed Budget Record inRequest Revision State
	@FindBy(xpath = "(//input[@type='search'])[2]")
	WebElement SearchProposedBudgetRecords;
	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
	WebElement RowsperPage;
	@FindBy(xpath = "//li[@data-value='100']")
	WebElement RowsperPage100;
	@FindBy(xpath = "//p[text()='Edit Budget Record']")
	WebElement EditBudgetRecordButtonOnProposedBudgetRecordsGrid;
	@FindBy(xpath = "//button[text()='Cancel']")
	WebElement CacnelButtonOnEditProposedBudgetRecord;
	@FindBy(xpath = "//p[text()='Are you sure you want to proceed with this action?']")
	WebElement WarningMessageOnEditRequestRevisionBudgetPopup;
	WebElement WarningMessageOnEditRequestRevisionBudgetRecordsPopup;
	@FindBy(xpath = "(//button[text()='CANCEL'])[2]")
	WebElement CancelButtonOnEditRequestRevisionBudgetRecordsPopup;
	@FindBy(xpath = "(//button[@data-testid='priv_modal_Continue'])[2]")
	WebElement ContinueButtonOnEditRequestRevisionBudgetRecordsPopup;
	// Reset DecisionCard details on Proposed Budget Record page for Admin
	@FindBy(xpath = "//button[text()='Search Users']")
	WebElement SearchUsersHeadingOnHomePage;
	@FindBy(xpath = "//h4[text()='USER MANAGEMENT']")
	WebElement UserManagementHeadingOnHomePage;
	@FindBy(xpath = "//h4[text()='Budget Records']")
	WebElement BudgetRecordsHeadingOnHomePage;
	@FindBy(xpath = "//li[text()='Proposed Budget Records']")
	WebElement ProposedBudgetRecordsLinkOnHomePage;
	@FindBy(xpath = "//li[text()='View Budget Records']")
	WebElement ViewBudgetRecordsLinkOnHomePage;
	@FindBy(xpath = "//h1[text()='Budget Records']")
	WebElement BudgetRecordsHeadingBudgetRecordsPage;
	@FindBy(xpath = "//div[text()='Effective Budget Records']")
	WebElement EffectiveBudgetRecordsHeadingOnBudgetRecordsPage;
	@FindBy(xpath = "//div[text()='Proposed Budget Records']")
	WebElement ProposedBudgetRecordsHeadingOnBudgetRecordsPage;
	@FindBy(xpath = "(//input[@type='checkbox'])[2]")
	WebElement ProposedBudgetRecordsFirstCheckbox;
	@FindBy(xpath = "//p[text()='Approve Proposed Budgets']")
	WebElement DecisionCardHeading;
	@FindBy(xpath = "//input[@value='REVISIONS_REQUESTED']")
	WebElement RevisionRequestedRadioButton;
	@FindBy(xpath = "//input[@value='PROPOSED_TO_AUTHORITY']")
	WebElement ProposedToAuthorityRadioButton;
	@FindBy(xpath = "//input[@value='DENIED']")
	WebElement DenyRadioButton;
	@FindBy(xpath = "//textarea[@name='comment']")
	WebElement CommentTextArea;
	@FindBy(xpath = "//button[@data-testid='reset_btn']")
	WebElement ResetButtonOnAdminDecisioncard;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitButtonOnAdminDecisioncard;
	@FindBy(xpath = "//h6[text()='Warning!']")
	WebElement WarningHeadingOnResetPopup;
	@FindBy(xpath = "//p[text()='No changes will be saved.']")
	WebElement WarningSubHeadingOnResetPopup;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Cancel']")
	WebElement CancelButtonOnResetPopup;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Continue']")
	WebElement ContinueButtonOnResetPopup;

	// View Jurisdiction Allowance Request Status History Grid
	@FindBy(xpath = "//div[text()='Jurisdiction Allowance Request Status History']")
	WebElement JurisdictionAllowanceRequestStatusHistoryHeading;
	@FindBy(xpath = "//span[text()='Request Status']")
	WebElement RequestStatusFirstColumn;
	@FindBy(xpath = "//span[text()='Budget Year']")
	WebElement RequestStatusSecondColumn;
	@FindBy(xpath = "//span[text()='Annual Allowance Budget']")
	WebElement AnnualAllowanceBudgetThirdColumn;
	@FindBy(xpath = "//span[text()='Reserve Adjusted Allowance Budget']")
	WebElement ReserveAdjustedAllowanceBudgetFourthColumn;
	@FindBy(xpath = "//span[text()='Request Initiation Date']")
	WebElement RequestInitiationDateFifthColumn;
	@FindBy(xpath = "//span[text()='Request Status Update Date']")
	WebElement RequestStatusUpdateDateSixthColumn;
	@FindBy(xpath = "//span[text()='Updated By']")
	WebElement UpdatedBySeventhColumn;
	@FindBy(xpath = "//span[text()='Comment']")
	WebElement CommentEighthColumn;
	@FindBy(xpath = "(//button[@aria-label='Select columns'])[3]")
	WebElement SelectColumns;
	@FindBy(xpath = "//button[text()='Welcome,']")
	WebElement UserNameWelcome;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement Logout;

	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-5zd7v5']")
	WebElement SuccessCross;
	@FindBy(xpath = "//button[text()='Welcome,']")
	WebElement WelcomeButton;
	@FindBy(xpath = "//a[text()='Proposed Budget Records']")
	WebElement ProposedBudgetRecordLabel;
	@FindBy(xpath = "(//input[@type='search'])[2]")
	WebElement SearchProposeBudget;
	@FindBy(xpath = "//input[@aria-label='Select row']")
	WebElement SelectRecord;
	@FindBy(xpath = "//input[@name='Propose to Authority']")
	WebElement ProposeToAuthRadio;
	@FindBy(xpath = "//input[@name='Deny']")
	WebElement DenyRadio;
	@FindBy(xpath = "//input[@name='Request Revisions']")
	WebElement RequestRevisionRadio;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitBtn;
	@FindBy(xpath = "//input[@type='password']")
	WebElement PassphraseText;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	WebElement ConfirmBtn_popUp;
	@FindBy(xpath = "//textarea[@data-testid='comment']")
	WebElement CommentField;
	@FindBy(xpath = "//input[@name='Approve']")
	WebElement ApproveRadio;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cell MuiDataGrid-cell--textCenter'])[38]")
	WebElement BudgetYear;
	@FindBy(xpath = "(//div[@title='Denied'])[1]")
	WebElement RequestStatusDenied;
	@FindBy(xpath = "(//div[@title='Revisions Requested'])[1]")
	WebElement RequestStatusRevisionRequested;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-lz7acl'])[2]")
	WebElement NumberOfRows;
	@FindBy(xpath = "//div[text()='Proposed Budget Records']")
	WebElement ProposedBudgetRecordsGridHeading;
	@FindBy(xpath = "(//button[@aria-label='Clear'])[2]")
	WebElement ClearSearchProposedGrid;

	// Manage Jurisdiction Budget Page WCI Inc Admin
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[1]")
	WebElement QuickActionEffectiveRecord;
	@FindBy(xpath = "(//input[@type='search'])[1]")
	WebElement SearchEffectiveRecord;
	@FindBy(xpath = "(//input[@type='search'])[2]")
	WebElement SearchProposeRecord;
	@FindBy(xpath = "//input[@data-testid='annualAllowanceBudget']")
	WebElement AnnualAllowanceBudgetInput;
	@FindBy(xpath = "//input[@data-testid='reserveAdjustedAllowanceBudget']")
	WebElement ReserveAdjustedAllowanceBudgetInput;
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[6]")
	WebElement QuickActionProposedBudgetRecord;
	@FindBy(xpath = "(//div[@data-field=\"budgetYear\"])[8]")
	WebElement SearchedRRYear;

	// Request Revision Status & Comment verification for WCI Inc Admin
	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[6]")
	WebElement EditProposedBudgetQuickAction;
	@FindBy(xpath = "//p[text()='Edit Budget Record']")
	WebElement EditBudgetRecord;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 css-1cpdyr0']")
	WebElement BudgetYearValue;
	@FindBy(xpath = "//p[text()='Testing Purpose']")
	WebElement AddedComment;
	
	//All Budget Records
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-7myxtt'])[2]")
	WebElement ReserveBudgetValue;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-7myxtt'])[3]")
	WebElement ReserveAllowancesIssuedValue;
	
	

	public RegModule3_MJB_POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void navigateToManageJurisdictionBudget_WCIAdmin() throws Exception {
		js = (JavascriptExecutor) driver;
		CM = new CommonMethods(driver);
		try {
			WebDriverWait wait = new WebDriverWait(driver, 40);
			wait.until(ExpectedConditions.elementToBeClickable(AllJurisdiction));
			AllJurisdiction.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(AllJurisdiction, "javascriptClick", "AllJurisdiction");
		}
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,350)");
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(QuickActionCalifornia));
			QuickActionCalifornia.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(QuickActionCalifornia, "moveToElementClick", "QuickActionCalifornia");
		}
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.elementToBeClickable(ManageBudget));
			ManageBudget.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ManageBudget, "moveToElementClick", "ManageBudget");
		}

	}

	public void navigateToAddBudgetRecordsPage_WCIAdmin() throws Exception {
		Thread.sleep(4000);
		try {
			ButtonAddBudgetRecords.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ButtonAddBudgetRecords, "javascriptClick", "AddBudget");
		}
	}

	public void proposeBudgetRecord() throws Exception {
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		AddBudgetYear = AddBudgetRecordYear1.getText();
		EnterAnnualAllowanceBudget.sendKeys("1000");
		EnterReserveAdjustedAllowanceBudget.sendKeys("100");
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		try {
			ButtonPropose.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ButtonPropose, "moveToElementClick", "ProposeBtn");
		}
		ProposeBudgetPopupContinueButton.click();
		Thread.sleep(4000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Budget Record proposed successfully. " + AddBudgetYear);
	}

	public void LogoutFunctionality() throws Exception {
		Thread.sleep(6000);
		try {
			WelcomeButton.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(WelcomeButton, "moveToElementClick", "Welcome");
		}
		Logout.click();
	}

	public void navigateToBudgetRecordsPage_JAdmin() throws Exception {
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(3000);
		try {
			ProposedBudgetRecordLabel.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ProposedBudgetRecordLabel, "moveToElementClick", "Label");
		}
	}

	public void ProposeToAuthority() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			ProposeToAuthRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ProposeToAuthRadio, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(3000);
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}

		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record Proposed To Authority successfully.");
	}

	public void DenyRecord_JAdmin() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			DenyRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(DenyRadio, "moveToElementClick", "DenyRadio");
		}
		CommentField.sendKeys("Testing Purpose");
		Thread.sleep(3000);

		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}

		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record Denied successfully by Jurisdiction Admin.");
	}

	public void DenyRecord_JAdmin1() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			DenyRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(DenyRadio, "moveToElementClick", "SelectRecord");
		}
		CommentField.sendKeys("Testing Purpose");
		Thread.sleep(3000);

		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}

		ObjectRepo.test.log(Status.PASS, "Proposed Record Submitted by Jurisdiction Admin for Denial.");
		Thread.sleep(3000);

		try {
			ProposeBudgetPopupCancelButton.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ProposeBudgetPopupCancelButton, "moveToElementClick", "ProposeBudgetPopupCancelButton");
		}

		ObjectRepo.test.log(Status.PASS, "Proposed Denial Record Cancelled by Jurisdiction Admin.");
		Thread.sleep(3000);

		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}

		ObjectRepo.test.log(Status.PASS, "Proposed Record again Submitted by Jurisdiction Admin for Denial.");
		Thread.sleep(3000);
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record Denied successfully by Jurisdiction Admin.");
	}

	public void RequestRevisionRecord_JAdmin() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			RequestRevisionRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(RequestRevisionRadio, "moveToElementClick", "SelectRecord");
		}
		CommentField.sendKeys("Testing Purpose");
		Thread.sleep(3000);
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record is Revision Requested successfully by Jurisdiction Admin.");
	}

	public void navigateToBudgetRecordsPage_JAuth() throws Exception {
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(4000);
		try {
			ProposedBudgetRecordLabel.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ProposedBudgetRecordLabel, "moveToElementClick", "Label");
		}
		Thread.sleep(4000);
	}

	public void ApprovedRecord_JAuth() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			ApproveRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ApproveRadio, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(3000);
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record Proposed To Authority successfully.");
	}

	public void DeniedRecord_JAuth() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			DenyRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(DenyRadio, "moveToElementClick", "SelectRecord");
		}
		CommentField.sendKeys("Testing Puprpose");
		Thread.sleep(3000);
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record Denied successfully by Jurisdiction Admin.");
	}

	public void RequestRevisionRecord_JAuth() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			RequestRevisionRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(RequestRevisionRadio, "moveToElementClick", "SelectRecord");
		}
		CommentField.sendKeys("Testing Purpose");
		Thread.sleep(3000);
		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		try {
			ConfirmBtn_popUp.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ConfirmBtn_popUp, "moveToElementClick", "ConfirmBtn_popUp");
		}
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS,
				"Proposed Record is Revision Requested successfully by Jurisdiction Authority.");
	}

	public void Propose_Record_Functionality() throws Exception {
		navigateToManageJurisdictionBudget_WCIAdmin();
		navigateToAddBudgetRecordsPage_WCIAdmin();
		proposeBudgetRecord();
	}

	public void ProposeToAuthority_Functionality() throws Exception {
		Propose_Record_Functionality();
		PH= new publicHomePage(driver, prop);
		LogoutFunctionality();
		Thread.sleep(4000);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		Thread.sleep(4000);
		navigateToBudgetRecordsPage_JAdmin();
		ProposeToAuthority();
//        ApprovedRecord_JAuth();
	}

	public void Deny_Functionality_ByJAdmin() throws Exception {
		Propose_Record_Functionality();
		PH= new publicHomePage(driver, prop);
		LogoutFunctionality();
		Thread.sleep(4000);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		Thread.sleep(4000);
		navigateToBudgetRecordsPage_JAdmin();
		DenyRecord_JAdmin();
	}

	public void RequestRevision_Functionality_ByJAdmin() throws Exception {
		Propose_Record_Functionality();
		PH= new publicHomePage(driver, prop);
		LogoutFunctionality();
		Thread.sleep(4000);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		Thread.sleep(4000);
		navigateToBudgetRecordsPage_JAdmin();
		RequestRevisionRecord_JAdmin();
	}

	public void Approved_Functionality_ByJAuth() throws Exception {
		ProposeToAuthority_Functionality();
		LogoutFunctionality();
		Thread.sleep(4000);
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		Thread.sleep(4000);
		navigateToBudgetRecordsPage_JAuth();
		ApprovedRecord_JAuth();
	}

	public void Denied_Functionality_ByJAuth() throws Exception {
		ProposeToAuthority_Functionality();
		PH= new publicHomePage(driver, prop);
		LogoutFunctionality();
		Thread.sleep(4000);
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		Thread.sleep(4000);
		navigateToBudgetRecordsPage_JAuth();
		DeniedRecord_JAuth();
	}

	public void RequestRevision_Functionality_ByJAuth() throws Exception {
		ProposeToAuthority_Functionality();
		PH= new publicHomePage(driver, prop);
		LogoutFunctionality();
		Thread.sleep(4000);
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		Thread.sleep(4000);
		navigateToBudgetRecordsPage_JAuth();
		// RequestRevision_Functionality_ByJAdmin();
		RequestRevisionRecord_JAuth();
	}

	public void naviagteToEditEffectiveRecordPage() throws Exception {
		Approved_Functionality_ByJAuth();
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "WciincAdmin");
		navigateToManageJurisdictionBudget_WCIAdmin();
		Thread.sleep(3000);
		SearchEffectiveRecord.sendKeys(AddBudgetYear);
		QuickActionEffectiveRecord.click();
		EditBudgetRecordButtonOnProposedBudgetRecordsGrid.click();
	}

	public void EditEffectiveRecordFunctionality() throws Exception {
		naviagteToEditEffectiveRecordPage();
		AnnualAllowanceBudgetInput.sendKeys("0");
		ReserveAdjustedAllowanceBudgetInput.sendKeys("0");
		ObjectRepo.test.log(Status.PASS,
				"Edited Annual allowance Budget is: " + AnnualAllowanceBudgetInput.getAttribute("value"));
		ObjectRepo.test.log(Status.PASS,
				"Edited Annual allowance Budget is: " + ReserveAdjustedAllowanceBudgetInput.getAttribute("value"));
		ButtonPropose.click();
		Thread.sleep(3000);
		ProposeBudgetPopupContinueButton.click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Effective Budget Record Edited successfully ");
	}

	public void EditEffectiveRecord_ProposetoAuthorityFunctionality_JAdmin() throws Exception {
		EditEffectiveRecordFunctionality();
		SuccessCross.click();
		Thread.sleep(3000);
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		navigateToBudgetRecordsPage_JAdmin();
		ProposeToAuthority();
		ObjectRepo.test.log(Status.PASS,
				"Edited Effective Budget Record Proposed to Authority successfully by Jurisdiction Admin ");
	}

	public void EditEffectiveRecord_ApproveFunctionality_JAuth() throws Exception {
		EditEffectiveRecord_ProposetoAuthorityFunctionality_JAdmin();
		Thread.sleep(3000);
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "Authority");
		navigateToBudgetRecordsPage_JAuth();
		ApprovedRecord_JAuth();
		ObjectRepo.test.log(Status.PASS,
				"Edited Effective Budget Record Approved successfully by Jurisdiction Authority");
	}

	public void naviagteToEditProposeRecordPage() throws Exception {
		RequestRevision_Functionality_ByJAuth();
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "WciincAdmin");
		navigateToManageJurisdictionBudget_WCIAdmin();
		Thread.sleep(3000);
		SearchProposeRecord.sendKeys(AddBudgetYear);
		QuickActionProposedBudgetRecord.click();
		EditBudgetRecordButtonOnProposedBudgetRecordsGrid.click();
		ObjectRepo.test.log(Status.PASS, "WCI Inc Admin navigated to Edit Propose Record card ");
	}

	public void EditProposeRecordFunctionality() throws Exception {
		naviagteToEditProposeRecordPage();
		AnnualAllowanceBudgetInput.sendKeys("0");
		ReserveAdjustedAllowanceBudgetInput.sendKeys("0");
		ObjectRepo.test.log(Status.PASS,
				"Edited Annual allowance Budget is: " + AnnualAllowanceBudgetInput.getAttribute("value"));
		ObjectRepo.test.log(Status.PASS,
				"Edited Annual allowance Budget is: " + ReserveAdjustedAllowanceBudgetInput.getAttribute("value"));
		ButtonPropose.click();
		Thread.sleep(3000);
		ProposeBudgetPopupContinueButton.click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Requested Revision Budget Record Edited successfully ");
	}

	public void EditProposeRecord_ProposetoAuthorityFunctionality_JAdmin() throws Exception {
		EditProposeRecordFunctionality();
		SuccessCross.click();
		Thread.sleep(3000);
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		navigateToBudgetRecordsPage_JAdmin();
		ProposeToAuthority();
		ObjectRepo.test.log(Status.PASS,
				"Edited Revision Requested Budget Record Proposed to Authority successfully by Jurisdiction Admin ");
	}

	public void EditPropseRecord_ApproveFunctionality_JAuth() throws Exception {
		EditProposeRecord_ProposetoAuthorityFunctionality_JAdmin();
		Thread.sleep(3000);
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "Authority");
		navigateToBudgetRecordsPage_JAuth();
		ApprovedRecord_JAuth();
		ObjectRepo.test.log(Status.PASS,
				"Edited Revision Requested Budget Record Approved successfully by Jurisdiction Authority");
	}

	public void selectJurisdictionToAddBudgetRecord() throws InterruptedException {
		// Scroll to the All Jurisdiction Tab
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(AllJurisdiction));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		// Click on the All Jurisdiction Tab
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AllJurisdiction));
			AllJurisdiction.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(AllJurisdiction, "moveToElementClick", "AllJurisdiction");
		}
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "All Juridiction Grid Displayed");
		// Verify the All Jurisdiction Grid
		String ActualJurisdiction = AllJurisdictionColumn1.getText();
		String ExpectedJurisdiction = "Jurisdiction";
		Assert.assertEquals(ActualJurisdiction, ExpectedJurisdiction);
		ObjectRepo.test.log(Status.PASS, "Juridiction Column Displayed");
		String ActualJurisdictionID = AllJurisdictionColumn2.getText();
		String ExpectedJurisdictionID = "Jurisdiction ID";
		Assert.assertEquals(ActualJurisdictionID, ExpectedJurisdictionID);
		ObjectRepo.test.log(Status.PASS, "Juridiction ID Column Displayed");
		String Actual2LetterCode = AllJurisdictionColumn3.getText();
		String Expected2LetterCode = "2 Letter Code";
		Assert.assertEquals(Actual2LetterCode, Expected2LetterCode);
		ObjectRepo.test.log(Status.PASS, "2 Letter Code Column is Displayed");
		String ActualStatus = AllJurisdictionColumn4.getText();
		String ExpectedStatus = "Status";
		Assert.assertEquals(ActualStatus, ExpectedStatus);
		ObjectRepo.test.log(Status.PASS, "Active Column is Displayed");
		String ActualQuickActions = AllJurisdictionColumn5.getText();
		String ExpectedQuickActions = "Quick Actions";
		Assert.assertEquals(ActualQuickActions, ExpectedQuickActions);
		ObjectRepo.test.log(Status.PASS, "Quick Actions Column is Displayed");
		// Click on Quick Actions button
		try {
			wait.until(ExpectedConditions.elementToBeClickable(QuickActionCalifornia));
			QuickActionCalifornia.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(QuickActionCalifornia, "moveToElementClick", "QuickActionCalifornia");
		}
		Thread.sleep(3000);
		// Verify the options displayed on click of Quick Actions button
		String ActualManageBudget = ManageBudget.getText();
		String ExpectedManageBudget = "MANAGE BUDGET";
		Assert.assertEquals(ActualManageBudget, ExpectedManageBudget);
		ObjectRepo.test.log(Status.PASS, "Manage Budget option is Displayed");
		String ActualManagePurchaseLimit = ManagePurchaseLimit.getText();
		String ExpectedManagePurchaseLimit = "MANAGE PURCHASE LIMIT";
		Assert.assertEquals(ActualManagePurchaseLimit, ExpectedManagePurchaseLimit);
		ObjectRepo.test.log(Status.PASS, "Manage Purchase Limit option is Displayed");
		// Select Manage Budget option
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ManageBudget));
			ManageBudget.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ManageBudget, "moveToElementClick", "ManageBudget");
		}
		Thread.sleep(3000);
		// Verify the displayed page details
		String ActualHeading = ManageJurisdictionBudget.getText();
		String ExpectedHeading = "Manage Jurisdiction Budget";
		Assert.assertEquals(ActualHeading, ExpectedHeading);
		ObjectRepo.test.log(Status.PASS, "Manage Jurisdiction Budget heading is Displayed");
		String ActualButtonAddBudgetRecords = ButtonAddBudgetRecords.getText();
		String ExpectedButtonAddBudgetRecords = "ADD BUDGET RECORDS";
		Assert.assertEquals(ActualButtonAddBudgetRecords, ExpectedButtonAddBudgetRecords);
		ObjectRepo.test.log(Status.PASS, "Add Budget Records button is Displayed");
		// Verify the displayed card details
		String ActualBudgetDetailsCard = BudgetDetailsCard.getText();
		String ExpectedBudgetDetailsCard = "Budget Details";
		Assert.assertEquals(ActualBudgetDetailsCard, ExpectedBudgetDetailsCard);
		ObjectRepo.test.log(Status.PASS, "Budget Details card is Displayed");
		String ActualBudgetDetailsJurisdiction = BudgetDetailsJurisdiction.getText();
		String ExpectedBudgetDetailsJurisdiction = "Jurisdiction";
		Assert.assertEquals(ActualBudgetDetailsJurisdiction, ExpectedBudgetDetailsJurisdiction);
		ObjectRepo.test.log(Status.PASS, "Budget Details Jurisdiction label is Displayed");
		Thread.sleep(3000);
//		driver.navigate().refresh();
//		Thread.sleep(5000);
		String ActualBudgetDetailsJurisdictionValue = BudgetDetailsJurisdictionValue.getText();
		String ExpectedBudgetDetailsJurisdictionValue = "California";
		Assert.assertEquals(ActualBudgetDetailsJurisdictionValue, ExpectedBudgetDetailsJurisdictionValue);
		ObjectRepo.test.log(Status.PASS, "California Jurisdiction is Displayed");
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		String ActualEffectiveBudgetRecordsCard = EffectiveBudgetRecordsCard.getText();
		String ExpectedEffectiveBudgetRecordsCard = "Effective Budget Records";
		Assert.assertEquals(ActualEffectiveBudgetRecordsCard, ExpectedEffectiveBudgetRecordsCard);
		ObjectRepo.test.log(Status.PASS, "Effective Budget Records card is Displayed");
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		String ActualProposedBudgetRecordsCard = ProposedBudgetRecordsCard.getText();
		String ExpectedProposedBudgetRecordsCard = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsCard, ExpectedProposedBudgetRecordsCard);
		ObjectRepo.test.log(Status.PASS, "Proposed Budget Records card is Displayed");
		wait.until(ExpectedConditions.elementToBeClickable(JurisdictionAllowanceRequestStatusHistoryCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		String ActualJurisdictionAllowanceRequestStatusHistoryCard = JurisdictionAllowanceRequestStatusHistoryCard
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryCard = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryCard,
				ExpectedJurisdictionAllowanceRequestStatusHistoryCard);
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Allowance Request Status History card is Displayed");
	}

	public void addBudgetRecordPageUI() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(5000);
		// Click on ADD BUDGET RECORDS button
		wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
		ButtonAddBudgetRecords.click();
		Thread.sleep(8000);
		// Verify the UI of Add Budget Records page
		String ActualHeadingAddBudgetRecords = HeadingAddBudgetRecords.getText();
		String ExpectedHeadingAddBudgetRecords = "Add Budget Records";
		Assert.assertEquals(ActualHeadingAddBudgetRecords, ExpectedHeadingAddBudgetRecords);
		ObjectRepo.test.log(Status.PASS, "Add Budget Records heading is Displayed");
		// Verify the displayed card details
		String ActualBudgetDetailsCard = BudgetDetailsCard.getText();
		String ExpectedBudgetDetailsCard = "Budget Details";
		Assert.assertEquals(ActualBudgetDetailsCard, ExpectedBudgetDetailsCard);
		ObjectRepo.test.log(Status.PASS, "Budget Details card Displayed");
		String ActualBudgetDetailsJurisdiction = BudgetDetailsJurisdiction.getText();
		String ExpectedBudgetDetailsJurisdiction = "Jurisdiction";
		Assert.assertEquals(ActualBudgetDetailsJurisdiction, ExpectedBudgetDetailsJurisdiction);
		ObjectRepo.test.log(Status.PASS, "Budget Details Jurisdiction label is Displayed");
		// driver.navigate().refresh();
		Thread.sleep(10000);
		String ActualBudgetDetailsJurisdictionValue = BudgetDetailsJurisdictionValue.getText();
		String ExpectedBudgetDetailsJurisdictionValue = "California";
		Assert.assertEquals(ActualBudgetDetailsJurisdictionValue, ExpectedBudgetDetailsJurisdictionValue);
		ObjectRepo.test.log(Status.PASS, "California Jurisdiction is Displayed");
		// Verify Add Budget Records Grid
		wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,450)");
		String ActualHeadingAddRecords = HeadingAddRecords.getText();
		String ExpectedHeadingAddRecords = "Add Records";
		Assert.assertEquals(ActualHeadingAddRecords, ExpectedHeadingAddRecords);
		ObjectRepo.test.log(Status.PASS, "Add Records sub-heading is Displayed");
		String ActualBudgetYearColumn1 = BudgetYearColumn1.getText();
		String ExpectedBudgetYearColumn1 = "Budget Year";
		Assert.assertEquals(ActualBudgetYearColumn1, ExpectedBudgetYearColumn1);
		ObjectRepo.test.log(Status.PASS, "Budget Year column is Displayed");
		String ActualAnnualAllowanceBudgetColumn2 = AnnualAllowanceBudgetColumn2.getText();
		String ExpectedAnnualAllowanceBudgetColumn2 = "Annual Allowance Budget*";
		Assert.assertEquals(ActualAnnualAllowanceBudgetColumn2, ExpectedAnnualAllowanceBudgetColumn2);
		ObjectRepo.test.log(Status.PASS, "Annual Allowance Budget Column is Displayed");
		String ActualReserveAdjustedAllowanceBudgetColumn3 = ReserveAdjustedAllowanceBudgetColumn3.getText();
		String ExpectedReserveAdjustedAllowanceBudgetColumn3 = "Reserve Adjusted Allowance Budget*";
		Assert.assertEquals(ActualReserveAdjustedAllowanceBudgetColumn3, ExpectedReserveAdjustedAllowanceBudgetColumn3);
		ObjectRepo.test.log(Status.PASS, "Reserve Adjusted Allowance Budget Column is Displayed");
		// Verify buttons displayed on Add Budget Records page
		wait.until(ExpectedConditions.elementToBeClickable(ButtonCancel));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,650)");
		String ActualButtonCancel = ButtonCancel.getText();
		String ExpectedButtonCancel = "CANCEL";
		Assert.assertEquals(ActualButtonCancel, ExpectedButtonCancel);
		ObjectRepo.test.log(Status.PASS, "CANCEL button is Displayed");
		String ActualButtonPropose = ButtonPropose.getText();
		String ExpectedButtonPropose = "PROPOSE";
		Assert.assertEquals(ActualButtonPropose, ExpectedButtonPropose);
		ObjectRepo.test.log(Status.PASS, "PROPOSE button is Displayed");
	}

	public void addBudgetRecordValidations() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		String ActualEffectiveBudgetRecordsCard = EffectiveBudgetRecordsCard.getText();
		String ExpectedEffectiveBudgetRecordsCard = "Effective Budget Records";
		Assert.assertEquals(ActualEffectiveBudgetRecordsCard, ExpectedEffectiveBudgetRecordsCard);
		ObjectRepo.test.log(Status.PASS, "Effective Budget Records card is Displayed");
		String ActualEffectiveBudgetRecord1 = EffectiveBudgetRecord1.getText();
		// String ExpectedEffectiveBudgetRecord1 = "Effective Budget Records";
		// Assert.assertEquals(ActualEffectiveBudgetRecord1,
		// ExpectedEffectiveBudgetRecord1);
		ObjectRepo.test.log(Status.PASS,
				"First Effective Budget Record Displayed is:- " + ActualEffectiveBudgetRecord1);
		// Click on ADD BUDGET RECORDS button
		Thread.sleep(5000);
		try {
			ButtonAddBudgetRecords.click();
		} catch (Exception ex) {
			driver.navigate().refresh();
			Thread.sleep(5000);
			wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
			ButtonAddBudgetRecords.click();
		}
		// Add Budget Records details
		wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,550)");
		Thread.sleep(5000);
		// Verify the Budget Years displayed on the Add Budget Year page
		for (WebElement Year : BudgetYears) {
			String BudYear = Year.getText();
			ObjectRepo.test.log(Status.PASS, "Budget Year displayed on Add Budget Record page is:- " + BudYear);
			Assert.assertNotEquals(BudYear, EffectiveBudgetRecord1);
			ObjectRepo.test.log(Status.PASS, "Effective Year is not displayed on Add Records Page");
		}
		Thread.sleep(5000);
	}

	public void addBudgetRecordPopup() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(5000);
		// Add Budget Records details
		wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,550)");
		Thread.sleep(5000);
		EnterAnnualAllowanceBudget.click();
		EnterAnnualAllowanceBudget.sendKeys("2000");
		EnterReserveAdjustedAllowanceBudget.click();
		EnterReserveAdjustedAllowanceBudget.sendKeys("1000");
		// Click Propose button
		wait.until(ExpectedConditions.elementToBeClickable(EnterReserveAdjustedAllowanceBudget15));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,750)");
		Thread.sleep(4000);
		ButtonPropose.click();
		Thread.sleep(4000);
		// Verify the Heading, Sub-Heding of displayed pop-up
		wait.until(ExpectedConditions.elementToBeClickable(ProposeBudgetPopupHeading));
		Thread.sleep(4000);
		String ActualProposeBudgetPopupHeading = ProposeBudgetPopupHeading.getText();
		String ExpectedProposeBudgetPopupHeading = "Confirm Proposal";
		Assert.assertEquals(ActualProposeBudgetPopupHeading, ExpectedProposeBudgetPopupHeading);
		ObjectRepo.test.log(Status.PASS,
				"Propose Budget Popup Heading is Displayed as:- " + ExpectedProposeBudgetPopupHeading);
		String ActualProposeBudgetPopupSubHeading = ProposeBudgetPopupSubHeading.getText();
		String ExpectedProposeBudgetPopupSubHeading = "Are you sure you would like to propose the entered budget records?";
		Assert.assertEquals(ActualProposeBudgetPopupSubHeading, ExpectedProposeBudgetPopupSubHeading);
		ObjectRepo.test.log(Status.PASS,
				"Propose Budget Popup Sub-Heading is Displayed as:- " + ExpectedProposeBudgetPopupSubHeading);
		// Verify the displayed buttons on pop-up
		String ActualProposeBudgetPopupCancelButton = ProposeBudgetPopupCancelButton.getText();
		String ExpectedProposeBudgetPopupCancelButtonl = "CANCEL";
		Assert.assertEquals(ActualProposeBudgetPopupCancelButton, ExpectedProposeBudgetPopupCancelButtonl);
		ObjectRepo.test.log(Status.PASS,
				"First button displayed on Propose Budget Popup is:- " + ExpectedProposeBudgetPopupCancelButtonl);
		String ActualProposeBudgetPopupContinueButton = ProposeBudgetPopupContinueButton.getText();
		String ExpectedProposeBudgetPopupContinueButton = "CONTINUE";
		Assert.assertEquals(ActualProposeBudgetPopupContinueButton, ExpectedProposeBudgetPopupContinueButton);
		ObjectRepo.test.log(Status.PASS,
				"Second button displayed on Propose Budget Popup is:- " + ExpectedProposeBudgetPopupContinueButton);
	}

	public void cancelButtonOnAddBudgetRecordPage() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		// Add Budget Records details
		wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,450)");
		Thread.sleep(3000);
		EnterAnnualAllowanceBudget.click();
		EnterAnnualAllowanceBudget.sendKeys("2000");
		EnterReserveAdjustedAllowanceBudget.click();
		EnterReserveAdjustedAllowanceBudget.sendKeys("1000");
		// Click Cancel button
		wait.until(ExpectedConditions.elementToBeClickable(EnterReserveAdjustedAllowanceBudget15));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,750)");
		Thread.sleep(4000);
		ButtonCancel.click();
		// Verify the Heading, Sub-Heading of displayed pop-up
		wait.until(ExpectedConditions.elementToBeClickable(CancelBudgetPopupHeading));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,350)");
		String ActualCancelBudgetPopupHeading = CancelBudgetPopupHeading.getText();
		String ExpectedCancelBudgetPopupHeading = "Warning!";
		Assert.assertEquals(ActualCancelBudgetPopupHeading, ExpectedCancelBudgetPopupHeading);
		ObjectRepo.test.log(Status.PASS,
				"Cancel Budget Popup Heading is Displayed as:- " + ExpectedCancelBudgetPopupHeading);
		String ActualCancelBudgetPopupSubHeading = CancelBudgetPopupSubHeading.getText();
		String ExpectedCancelBudgetPopupSubHeading = "Clicking “Continue” will take you back to the previous page.";
		Assert.assertEquals(ActualCancelBudgetPopupSubHeading, ExpectedCancelBudgetPopupSubHeading);
		ObjectRepo.test.log(Status.PASS,
				"Cancel Budget Popup Sub-Heading is Displayed as:- " + ExpectedCancelBudgetPopupSubHeading);
		String ActualCancelBudgetPopupSubHeading1 = CancelBudgetPopupSubHeading1.getText();
		String ExpectedCancelBudgetPopupSubHeading1 = "No changes will be saved.";
		Assert.assertEquals(ActualCancelBudgetPopupSubHeading1, ExpectedCancelBudgetPopupSubHeading1);
		ObjectRepo.test.log(Status.PASS,
				"Cancel Budget Popup Sub-Heading1 is Displayed as:- " + ExpectedCancelBudgetPopupSubHeading1);
		// Verify the displayed buttons on pop-up
		String ActualProposeBudgetPopupCancelButton = ProposeBudgetPopupCancelButton.getText();
		String ExpectedProposeBudgetPopupCancelButtonl = "CANCEL";
		Assert.assertEquals(ActualProposeBudgetPopupCancelButton, ExpectedProposeBudgetPopupCancelButtonl);
		ObjectRepo.test.log(Status.PASS,
				"First button displayed on Cancel Budget Popup is:- " + ExpectedProposeBudgetPopupCancelButtonl);
		String ActualProposeBudgetPopupContinueButton = ProposeBudgetPopupContinueButton.getText();
		String ExpectedProposeBudgetPopupContinueButton = "CONTINUE";
		Assert.assertEquals(ActualProposeBudgetPopupContinueButton, ExpectedProposeBudgetPopupContinueButton);
		ObjectRepo.test.log(Status.PASS,
				"Second button displayed on Propose Budget Popup is:- " + ExpectedProposeBudgetPopupContinueButton);
	}

	public void cancelButtonFunctionalityOnAddBudgetRecordPage() throws Exception {
		// Scroll to the All Jurisdiction Tab
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		// Add Budget Records details
		try {
			wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,450)");
			Thread.sleep(3000);
			EnterAnnualAllowanceBudget.click();
			EnterAnnualAllowanceBudget.sendKeys("2000");
			EnterReserveAdjustedAllowanceBudget.click();
			EnterReserveAdjustedAllowanceBudget.sendKeys("1000");
		} catch (InterruptedException e) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,450)");
			Thread.sleep(3000);
			EnterAnnualAllowanceBudget.click();
			EnterAnnualAllowanceBudget.sendKeys("2000");
			EnterReserveAdjustedAllowanceBudget.click();
			EnterReserveAdjustedAllowanceBudget.sendKeys("1000");
		}
		ObjectRepo.test.log(Status.PASS, "Budget Records added successfully");
		// Click Cancel button
		wait.until(ExpectedConditions.elementToBeClickable(EnterReserveAdjustedAllowanceBudget15));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,750)");
		Thread.sleep(4000);
		ButtonCancel.click();
		ObjectRepo.test.log(Status.PASS, "User is able to click on Cancel button and Pop-up is also displayed");
		// Functionality of Cancel button on Cancel Add Budget Record pop-up
		Thread.sleep(4000);
		ProposeBudgetPopupCancelButton.click();
		Thread.sleep(4000);
		// Verify entered value persist in Add Budget Records grid after canceling the
		// Cancel Add Budget Record
		wait.until(ExpectedConditions.elementToBeClickable(AddBudgetRecordYear9));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,-350)");
		String ActualEnterAnnualAllowanceBudget = EnterAnnualAllowanceBudget.getAttribute("value");
		String ExpectedEnterAnnualAllowanceBudget = "2000";
		Assert.assertEquals(ActualEnterAnnualAllowanceBudget, ExpectedEnterAnnualAllowanceBudget);
		ObjectRepo.test.log(Status.PASS,
				"Entered value for Annual Allowance Budget value persist after canceling the Cancel Propose Budget Record:- "
						+ ExpectedEnterAnnualAllowanceBudget);
		String ActualEnterReserveAdjustedAllowanceBudget = EnterReserveAdjustedAllowanceBudget.getAttribute("value");
		String ExpectedEnterReserveAdjustedAllowanceBudget = "1000";
		Assert.assertEquals(ActualEnterReserveAdjustedAllowanceBudget, ExpectedEnterReserveAdjustedAllowanceBudget);
		ObjectRepo.test.log(Status.PASS,
				"Entered value for Reserve Adjusted Allowance Budget value persist after canceling the Cancel Propose Budget Record:- "
						+ ExpectedEnterReserveAdjustedAllowanceBudget);
		// Click Cancel button
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(EnterReserveAdjustedAllowanceBudget15));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,750)");
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ButtonCancel));
			ButtonCancel.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ButtonCancel, "javascriptClick", "ButtonCancel");
		}
		ObjectRepo.test.log(Status.PASS, "User is able to click on Cancel button and Pop-up is also displayed");
		// Functionality of Continue button on Cancel Add Budget Record pop-up
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ProposeBudgetPopupContinueButton));
			ProposeBudgetPopupContinueButton.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ProposeBudgetPopupContinueButton, "javascriptClick", "ProposeBudgetPopupContinueButton");
		}
		Thread.sleep(4000);
		// Verify User is Navigated to the 'Manage Jurisdiction Budget' Page after
		// Continuing the Cancel Add Budget Record.
		wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
		String VerifyButtonAddBudgetRecords = ButtonAddBudgetRecords.getText();
		ObjectRepo.test.log(Status.PASS,
				"User is Navigated to the 'Manage Jurisdiction Budget' Page after Continuing the Cancel Add Budget Record.:- "
						+ VerifyButtonAddBudgetRecords);
		ButtonAddBudgetRecords.click();
		Thread.sleep(8000);
		// Verify entered value are cleared in Add Budget Records grid after Continuing
		// the Cancel Add Budget Record
		try {
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("window.scrollBy(0,350)");
			String ActualEnterAnnualAllowanceBudget1 = EnterAnnualAllowanceBudget.getAttribute("value");
			ObjectRepo.test.log(Status.PASS,
					"Entered value for Annual Allowance Budget value cleared after continuing the Cancel Propose Budget Record:- "
							+ ActualEnterAnnualAllowanceBudget1);
			String ActualEnterReserveAdjustedAllowanceBudget1 = EnterReserveAdjustedAllowanceBudget
					.getAttribute("value");
			ObjectRepo.test.log(Status.PASS,
					"Entered value for Reserve Adjusted Allowance Budget value cleared after continuing the Cancel Propose Budget Record:- "
							+ ActualEnterReserveAdjustedAllowanceBudget1);
		} catch (InterruptedException e) {
			driver.navigate().refresh();
			Thread.sleep(4000);
			wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
			JavascriptExecutor js5 = (JavascriptExecutor) driver;
			js5.executeScript("window.scrollBy(0,350)");
			String ActualEnterAnnualAllowanceBudget1 = EnterAnnualAllowanceBudget.getAttribute("value");
			ObjectRepo.test.log(Status.PASS,
					"Entered value for Annual Allowance Budget value cleared after continuing the Cancel Propose Budget Record:- "
							+ ActualEnterAnnualAllowanceBudget1);
			String ActualEnterReserveAdjustedAllowanceBudget1 = EnterReserveAdjustedAllowanceBudget
					.getAttribute("value");
			ObjectRepo.test.log(Status.PASS,
					"Entered value for Reserve Adjusted Allowance Budget value cleared after continuing the Cancel Propose Budget Record:- "
							+ ActualEnterReserveAdjustedAllowanceBudget1);
		}
	}

	public void addBudgetRecordValidationsbykeepingMandatoryFieldsempty() throws Exception {
		// Scroll to the All Jurisdiction Tab
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(5000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
			ButtonAddBudgetRecords.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			ButtonAddBudgetRecords.click();
		}
		Thread.sleep(5000);
		// Add Budget Records details
		wait.until(ExpectedConditions.elementToBeClickable(HeadingAddRecords));
		JavascriptExecutor js4 = (JavascriptExecutor) driver;
		js4.executeScript("window.scrollBy(0,550)");
		Thread.sleep(5000);
		// Verify the Tab button over the mandatory fields on Add Budget Records page
		EnterAnnualAllowanceBudget.click();
		EnterAnnualAllowanceBudget.sendKeys(" ");
		EnterReserveAdjustedAllowanceBudget.click();
		EnterReserveAdjustedAllowanceBudget.sendKeys(" ");
		// Click Propose button
		wait.until(ExpectedConditions.elementToBeClickable(EnterReserveAdjustedAllowanceBudget15));
		JavascriptExecutor js3 = (JavascriptExecutor) driver;
		js3.executeScript("window.scrollBy(0,750)");
		Thread.sleep(4000);
		Assert.assertEquals(ButtonPropose.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Propose button is in disabled state when mandatory fields are kept empty.");
	}

	public void cancelButtonFunctionalityOnEditBudgetRecordPageForEffectiveBudgetRecords() throws Exception {
		// Scroll to the All Jurisdiction Tab
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		// Click on Edit Effective BUDGET RECORDs
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,250)");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,250)");
			Thread.sleep(3000);
		}
		// Click on Quick Actions button
		MoreActionsButtonOnEffectiveBudgetRecordsGrid.click();
		Thread.sleep(5000);
		// Select Edit Budget option
		EditBudgetRecordButtonOnEffectiveBudgetRecordsGrid.click();
		Thread.sleep(8000);
		// Assert Edit Effective Budget Records page value
		String ActualHeadingEditBudgetRecord = EffectiveBudgetRecordsGridTitle.getText();
		String ExpectedHeadingEditBudgetRecord = "Effective Budget Records";
		Assert.assertEquals(ActualHeadingEditBudgetRecord, ExpectedHeadingEditBudgetRecord);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedHeadingEditBudgetRecord);
		String ActualLabelBudgetYear = LabelBudgetYear.getText();
		String ExpectedLabelBudgetYear = "Budget Year";
		Assert.assertEquals(ActualLabelBudgetYear, ExpectedLabelBudgetYear);
		ObjectRepo.test.log(Status.PASS, "First label on displayed card is:- " + ExpectedLabelBudgetYear);
		wait.until(ExpectedConditions.elementToBeClickable(ValueBudgetYear));
		String ActualValueBudgetYear = ValueBudgetYear.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Budget Year displayed as:- " + ActualValueBudgetYear);

		String ActualLabelAnnualAllowanceBudget = LabelAnnualAllowanceBudget.getText();
		String ExpectedLabelAnnualAllowanceBudget = "Annual Allowance Budget*";
		Assert.assertEquals(ActualLabelAnnualAllowanceBudget, ExpectedLabelAnnualAllowanceBudget);
		ObjectRepo.test.log(Status.PASS, "Second label on displayed card is:- " + ExpectedLabelAnnualAllowanceBudget);
		String ActualAnnualAllowanceBudgetTextfield = AnnualAllowanceBudgetTextfield.getAttribute("value");
		ObjectRepo.test.log(Status.PASS,
				"Annual Allowance Budget displayed as:- " + ActualAnnualAllowanceBudgetTextfield);

		String ActualReserveAdjustedAllowanceBudget = LabelReserveAdjustedAllowanceBudget.getText();
		String ExpectedReserveAdjustedAllowanceBudget = "Reserve Adjusted Allowance Budget*";
		Assert.assertEquals(ActualReserveAdjustedAllowanceBudget, ExpectedReserveAdjustedAllowanceBudget);
		ObjectRepo.test.log(Status.PASS,
				"Third label on displayed card is:- " + ExpectedReserveAdjustedAllowanceBudget);
		String ActualReserveAdjustedAllowanceBudgetTextfield = ReserveAdjustedAllowanceBudgetTextfield
				.getAttribute("value");
		ObjectRepo.test.log(Status.PASS,
				"Reserve Adjusted Allowance Budget displayed as:- " + ActualReserveAdjustedAllowanceBudgetTextfield);
		// Click on Cancel Button
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnEditEffectiveBudgetRecordsGrid));
			CancelButtonOnEditEffectiveBudgetRecordsGrid.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelButtonOnEditEffectiveBudgetRecordsGrid, "moveToElementClick",
					"CancelButtonOnEditEffectiveBudgetRecordsGrid");
		}
		ObjectRepo.test.log(Status.PASS, "User is able to click on Cancel button and Pop-up is also displayed");
		Thread.sleep(4000);
		// Verify the Heading, Sub-Heading of displayed pop-up
		wait.until(ExpectedConditions.elementToBeClickable(WarningTitleOnEditEffectiveBudgetRecordsPopup));
//		JavascriptExecutor js2 = (JavascriptExecutor) driver;
//		js2.executeScript("window.scrollBy(0,350)");
		String ActualCancelEditEffectiveBudgetPopupHeading = WarningTitleOnEditEffectiveBudgetRecordsPopup.getText();
		String ExpectedCancelEditEffectiveBudgetPopupHeading = "Warning!";
		Assert.assertEquals(ActualCancelEditEffectiveBudgetPopupHeading, ExpectedCancelEditEffectiveBudgetPopupHeading);
		ObjectRepo.test.log(Status.PASS, "Cancel Effective Budget Record Popup Heading is Displayed as:- "
				+ ExpectedCancelEditEffectiveBudgetPopupHeading);
		String ActualWarningMessageOnEditEffectiveBudgetRecordsPopup = WarningMessageOnEditEffectiveBudgetRecordsPopup
				.getText();
		String ExpectedWarningMessageOnEditEffectiveBudgetRecordsPopup = "Are you sure you want to proceed with this action?";
		Assert.assertEquals(ActualWarningMessageOnEditEffectiveBudgetRecordsPopup,
				ExpectedWarningMessageOnEditEffectiveBudgetRecordsPopup);
		ObjectRepo.test.log(Status.PASS, "Cancel Effective Budget Record Popup Sub-Heading is Displayed as:- "
				+ ExpectedWarningMessageOnEditEffectiveBudgetRecordsPopup);
		// Verify the displayed buttons on pop-up
		String ActualCancelButtonOnEditEffectiveBudgetRecordsPopup = CancelButtonOnEditEffectiveBudgetRecordsPopup
				.getText();
		String ExpectedCancelButtonOnEditEffectiveBudgetRecordsPopup = "CANCEL";
		Assert.assertEquals(ActualCancelButtonOnEditEffectiveBudgetRecordsPopup,
				ExpectedCancelButtonOnEditEffectiveBudgetRecordsPopup);
		ObjectRepo.test.log(Status.PASS, "First button displayed on Cancel Budget Popup is:- "
				+ ExpectedCancelButtonOnEditEffectiveBudgetRecordsPopup);
		String ActualContinueButtonOnEditEffectiveBudgetRecordsPopup = ContinueButtonOnEditEffectiveBudgetRecordsPopup
				.getText();
		String ExpectedContinueButtonOnEditEffectiveBudgetRecordsPopup = "CONTINUE";
		Assert.assertEquals(ActualContinueButtonOnEditEffectiveBudgetRecordsPopup,
				ExpectedContinueButtonOnEditEffectiveBudgetRecordsPopup);
		ObjectRepo.test.log(Status.PASS, "Second button displayed on Propose Budget Popup is:- "
				+ ExpectedContinueButtonOnEditEffectiveBudgetRecordsPopup);
		// Click on Cancel button of displayed pop-up
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnEditEffectiveBudgetRecordsPopup));
			CancelButtonOnEditEffectiveBudgetRecordsPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelButtonOnEditEffectiveBudgetRecordsPopup, "moveToElementClick",
					"CancelButtonOnEditEffectiveBudgetRecordsPopup");
		}
		Thread.sleep(4000);
		// Assert values after canceling the cancel Edit Budget Record
		// driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(ColumnNameRequestStatus));
		js.executeScript("window.scrollBy(0,-350)");
		String ActualValueBudgetYear1 = ValueBudgetYear.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Budget Year displayed as:- " + ActualValueBudgetYear1);
		String ActualAnnualAllowanceBudgetTextfield1 = AnnualAllowanceBudgetTextfield.getAttribute("value");
		ObjectRepo.test.log(Status.PASS,
				"Annual Allowance Budget displayed as:- " + ActualAnnualAllowanceBudgetTextfield1);
		String ActualReserveAdjustedAllowanceBudgetTextfield1 = ReserveAdjustedAllowanceBudgetTextfield
				.getAttribute("value");
		ObjectRepo.test.log(Status.PASS,
				"Reserve Adjusted Allowance Budget displayed as:- " + ActualReserveAdjustedAllowanceBudgetTextfield1);
//		String ActualComments1 = ValueComments.getAttribute("value");
//		ObjectRepo.test.log(Status.PASS, "Comments displayed as:- " + ActualComments1);
		// Now cancel Effective Budget Record
		Thread.sleep(8000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnEditEffectiveBudgetRecordsGrid));
			CancelButtonOnEditEffectiveBudgetRecordsGrid.click();
		} catch (Exception ex) {
			CM.click2(CancelButtonOnEditEffectiveBudgetRecordsGrid, "moveToElementClick",
					"CancelButtonOnEditEffectiveBudgetRecordsGrid");
		}
		ObjectRepo.test.log(Status.PASS, "User is able to click on Cancel button and Pop-up is also displayed");
		Thread.sleep(4000);
		// Now click on Continue button
		// Functionality of Continue button on Cancel Edit Effective Budget Record
		// pop-up
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ContinueButtonOnEditEffectiveBudgetRecordsPopup));
			ContinueButtonOnEditEffectiveBudgetRecordsPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ContinueButtonOnEditEffectiveBudgetRecordsPopup, "moveToElementClick",
					"ContinueButtonOnEditEffectiveBudgetRecordsPopup");
		}
		Thread.sleep(4000);
		// Verify User is Navigated to the 'Manage Jurisdiction Budget' Page after
		// Continuing the Cancel Edit Effective Budget Record.
//		driver.navigate().refresh();
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
//		String VerifyButtonAddBudgetRecords = ButtonAddBudgetRecords.getText();
//		ObjectRepo.test.log(Status.PASS,
//				"User is Navigated to the 'Manage Jurisdiction Budget' Page after Continuing the Cancel Add Budget Record.:- "
//						+ VerifyButtonAddBudgetRecords);
	}

	public void cancelButtonFunctionalityOnEditBudgetRecordPageForProposedBudgetRecords() throws Exception {
		// Scroll to the All Jurisdiction Tab
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(AllJurisdiction));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)");
		Thread.sleep(3000);
		// Click on the All Jurisdiction Tab
		AllJurisdiction.click();
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "All Juridiction Grid Displayed");
		// Click on Quick Actions button
		QuickActionCalifornia.click();
		Thread.sleep(3000);
		// Select Manage Budget option
		ManageBudget.click();
		Thread.sleep(8000);
		// Click on Edit Effective BUDGET RECORDs
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,750)");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,750)");
			Thread.sleep(3000);
		}
		// Click on Quick Actions button
		String ActualHeadingOfProposedBudgetRecordCard = ProposedBudgetRecordsGridTitle.getText();
		String ExpectedHeadingOfProposedBudgetRecordCard = "Proposed Budget Records";
		Assert.assertEquals(ActualHeadingOfProposedBudgetRecordCard, ExpectedHeadingOfProposedBudgetRecordCard);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedHeadingOfProposedBudgetRecordCard);
		MoreActionsButtonOnProposedBudgetRecordsGrid.click();
		Thread.sleep(5000);
		// Select Cancel Budget option
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelProposedRecordButton));
			CancelProposedRecordButton.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelProposedRecordButton, "moveToElementClick", "CancelProposedRecordButton");
		}
		Thread.sleep(8000);
		// Assert Cancel Proposed Budget Records pop-up
		String ActualWarningHeadingOnEditProposedBudgetPopup = WarningHeadingOnEditProposedBudgetPopup.getText();
		String ExpectedWarningHeadingOnEditProposedBudgetPopup = "Warning!";
		Assert.assertEquals(ActualWarningHeadingOnEditProposedBudgetPopup,
				ExpectedWarningHeadingOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Heading on the displayed pop-up:- " + ExpectedWarningHeadingOnEditProposedBudgetPopup);

		String ActualWarningMessageOnEditProposedBudgetPopup = WarningMessageOnEditProposedBudgetPopup.getText();
		String ExpectedWarningMessageOnEditProposedBudgetPopup = "Are you sure you want to remove the proposed budget record?";
		Assert.assertEquals(ActualWarningMessageOnEditProposedBudgetPopup,
				ExpectedWarningMessageOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Sub-Heading displayed on pop-up:- " + ExpectedWarningMessageOnEditProposedBudgetPopup);

		String ActualCancelButtonOnEditProposedBudgetPopup = CancelButtonOnEditProposedBudgetPopup.getText();
		String ExpectedCancelButtonOnEditProposedBudgetPopup = "CANCEL";
		Assert.assertEquals(ActualCancelButtonOnEditProposedBudgetPopup, ExpectedCancelButtonOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Button displayed on pop-up:- " + ExpectedCancelButtonOnEditProposedBudgetPopup);
		String ActualContinueButtonOnEditProposedBudgetPopup = ContinueButtonOnEditProposedBudgetPopup.getText();
		String ExpectedContinueButtonOnEditProposedBudgetPopup = "CONTINUE";
		Assert.assertEquals(ActualContinueButtonOnEditProposedBudgetPopup,
				ExpectedContinueButtonOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Button displayed on pop-up:- " + ExpectedContinueButtonOnEditProposedBudgetPopup);

		// Click on Cancel button of displayed pop-up
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnEditProposedBudgetPopup));
			CancelButtonOnEditProposedBudgetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelButtonOnEditProposedBudgetPopup, "moveToElementClick",
					"CancelButtonOnEditProposedBudgetPopup");
		}
		Thread.sleep(4000);
		// Again Cancel the Proposed Budget Record
		driver.navigate().refresh();
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
		js.executeScript("window.scrollBy(0,+850)");
		MoreActionsButtonOnProposedBudgetRecordsGrid.click();
		Thread.sleep(5000);
		// Select Cancel Budget option
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelProposedRecordButton));
			CancelProposedRecordButton.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelProposedRecordButton, "moveToElementClick", "CancelProposedRecordButton");
		}
		Thread.sleep(8000);
		// Now click on Continue button
		// Functionality of Continue button on Cancel Proposed Budget Record pop-up
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ContinueButtonOnEditProposedBudgetPopup));
			ContinueButtonOnEditProposedBudgetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ContinueButtonOnEditProposedBudgetPopup, "moveToElementClick",
					"ContinueButtonOnEditProposedBudgetPopup");
		}
		Thread.sleep(4000);
		// Verify User is Navigated to the 'Manage Jurisdiction Budget' Page after
		// Continuing the Continue Cancel Proposed Budget Record.
		driver.navigate().refresh();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
		String VerifyButtonAddBudgetRecords = ButtonAddBudgetRecords.getText();
		ObjectRepo.test.log(Status.PASS,
				"User is Navigated to the 'Manage Jurisdiction Budget' Page after Continuing the Cancel Add Budget Record.:- "
						+ VerifyButtonAddBudgetRecords);
		// Verify the history maintained for the cancelled record
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
		js.executeScript("window.scrollBy(0,1000)");
		String ActualRequestHistoryStatusForcancelledRecord = RequestHistoryStatusForcancelledRecord.getText();
		String ExpectedRequestHistoryStatusForcancelledRecord = "Cancelled";
		Assert.assertEquals(ActualRequestHistoryStatusForcancelledRecord,
				ExpectedRequestHistoryStatusForcancelledRecord);
		ObjectRepo.test.log(Status.PASS,
				"Request history Status for cancelled record is:- " + ExpectedRequestHistoryStatusForcancelledRecord);
	}

	public void cancelButtonFunctionalityOnEditBudgetRecordPageForProposedRequestRevisionBudgetRecords()
			throws Exception {
		// Scroll to the All Jurisdiction Tab
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(3000);
		// Click on Edit Effective BUDGET RECORDs
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,900)");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			driver.navigate().refresh();
			wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsGridTitle));
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,900)");
			Thread.sleep(3000);
		}
		// Click on Quick Actions button
		String ActualHeadingOfProposedBudgetRecordCard = ProposedBudgetRecordsGridTitle.getText();
		String ExpectedHeadingOfProposedBudgetRecordCard = "Proposed Budget Records";
		Assert.assertEquals(ActualHeadingOfProposedBudgetRecordCard, ExpectedHeadingOfProposedBudgetRecordCard);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedHeadingOfProposedBudgetRecordCard);
		// Select 100 Rows Per Page
		Thread.sleep(5000);
		RowsperPage.click();
		Thread.sleep(5000);
		RowsperPage100.click();
		Thread.sleep(5000);
		// Search Request Revision Records
		SearchProposedBudgetRecords.click();
		SearchProposedBudgetRecords.sendKeys("Revisions Requested");
		Thread.sleep(5000);
		MoreActionsButtonOnProposedBudgetRecordsGrid.click();
		Thread.sleep(5000);
		// Select Edit Budget option
		EditBudgetRecordButtonOnProposedBudgetRecordsGrid.click();
		Thread.sleep(8000);
		// Assert Cancel Edit Proposed Budget Records page
		String ActualHeadingEditBudgetRecord = EffectiveBudgetRecordsGridTitle.getText();
		String ExpectedHeadingEditBudgetRecord = "Effective Budget Records";
		Assert.assertEquals(ActualHeadingEditBudgetRecord, ExpectedHeadingEditBudgetRecord);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedHeadingEditBudgetRecord);
		String ActualLabelBudgetYear = LabelBudgetYear.getText();
		String ExpectedLabelBudgetYear = "Budget Year";
		Assert.assertEquals(ActualLabelBudgetYear, ExpectedLabelBudgetYear);
		ObjectRepo.test.log(Status.PASS, "First label on displayed card is:- " + ExpectedLabelBudgetYear);
		wait.until(ExpectedConditions.elementToBeClickable(ValueBudgetYear));
		String ActualValueBudgetYear = ValueBudgetYear.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Budget Year displayed as:- " + ActualValueBudgetYear);
		String ActualLabelAnnualAllowanceBudget = LabelAnnualAllowanceBudget.getText();
		String ExpectedLabelAnnualAllowanceBudget = "Annual Allowance Budget*";
		Assert.assertEquals(ActualLabelAnnualAllowanceBudget, ExpectedLabelAnnualAllowanceBudget);
		ObjectRepo.test.log(Status.PASS, "Second label on displayed card is:- " + ExpectedLabelAnnualAllowanceBudget);
		String ActualAnnualAllowanceBudgetTextfield = AnnualAllowanceBudgetTextfield.getAttribute("value");
		ObjectRepo.test.log(Status.PASS,
				"Annual Allowance Budget displayed as:- " + ActualAnnualAllowanceBudgetTextfield);

		String ActualReserveAdjustedAllowanceBudget = LabelReserveAdjustedAllowanceBudget.getText();
		String ExpectedReserveAdjustedAllowanceBudget = "Reserve Adjusted Allowance Budget*";
		Assert.assertEquals(ActualReserveAdjustedAllowanceBudget, ExpectedReserveAdjustedAllowanceBudget);
		ObjectRepo.test.log(Status.PASS,
				"Third label on displayed card is:- " + ExpectedReserveAdjustedAllowanceBudget);
		String ActualReserveAdjustedAllowanceBudgetTextfield = ReserveAdjustedAllowanceBudgetTextfield
				.getAttribute("value");
		ObjectRepo.test.log(Status.PASS,
				"Reserve Adjusted Allowance Budget displayed as:- " + ActualReserveAdjustedAllowanceBudgetTextfield);
		// Click on Cancel button
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CacnelButtonOnEditProposedBudgetRecord));
			CacnelButtonOnEditProposedBudgetRecord.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CacnelButtonOnEditProposedBudgetRecord, "moveToElementClick",
					"CacnelButtonOnEditProposedBudgetRecord");
		}
		Thread.sleep(8000);
		// Assert Cancel Proposed Budget Records pop-up
		String ActualWarningHeadingOnEditProposedBudgetPopup = WarningHeadingOnEditProposedBudgetPopup.getText();
		String ExpectedWarningHeadingOnEditProposedBudgetPopup = "Warning!";
		Assert.assertEquals(ActualWarningHeadingOnEditProposedBudgetPopup,
				ExpectedWarningHeadingOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Heading on the displayed pop-up:- " + ExpectedWarningHeadingOnEditProposedBudgetPopup);
		String ActualWarningMessageOnEditRequestRevisionBudgetPopup = WarningMessageOnEditRequestRevisionBudgetPopup
				.getText();
		String ExpectedWarningMessageOnEditRequestRevisionBudgetPopup = "Are you sure you want to proceed with this action?";
		Assert.assertEquals(ActualWarningMessageOnEditRequestRevisionBudgetPopup,
				ExpectedWarningMessageOnEditRequestRevisionBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Sub-Heading displayed on pop-up:- " + ExpectedWarningMessageOnEditRequestRevisionBudgetPopup);
		String ActualCancelButtonOnEditProposedBudgetPopup = CancelButtonOnEditProposedBudgetPopup.getText();
		String ExpectedCancelButtonOnEditProposedBudgetPopup = "CANCEL";
		Assert.assertEquals(ActualCancelButtonOnEditProposedBudgetPopup, ExpectedCancelButtonOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Button displayed on pop-up:- " + ExpectedCancelButtonOnEditProposedBudgetPopup);
		String ActualContinueButtonOnEditProposedBudgetPopup = ContinueButtonOnEditProposedBudgetPopup.getText();
		String ExpectedContinueButtonOnEditProposedBudgetPopup = "CONTINUE";
		Assert.assertEquals(ActualContinueButtonOnEditProposedBudgetPopup,
				ExpectedContinueButtonOnEditProposedBudgetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Button displayed on pop-up:- " + ExpectedContinueButtonOnEditProposedBudgetPopup);
		// Click on Cancel button of displayed pop-up
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnEditProposedBudgetPopup));
			CancelButtonOnEditProposedBudgetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelButtonOnEditProposedBudgetPopup, "moveToElementClick",
					"CancelButtonOnEditProposedBudgetPopup");
		}
		Thread.sleep(4000);
//		// Now click on Cancel button to verify the
//		// Functionality of Continue button on Cancel Proposed Budget Record pop-up
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CacnelButtonOnEditProposedBudgetRecord));
			CacnelButtonOnEditProposedBudgetRecord.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CacnelButtonOnEditProposedBudgetRecord, "moveToElementClick",
					"CacnelButtonOnEditProposedBudgetRecord");
		}
		Thread.sleep(4000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ContinueButtonOnEditProposedBudgetPopup));
			ContinueButtonOnEditProposedBudgetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ContinueButtonOnEditProposedBudgetPopup, "moveToElementClick",
					"ContinueButtonOnEditProposedBudgetPopup");
		}
		Thread.sleep(4000);
		// Verify User is Navigated to the 'Manage Jurisdiction Budget' Page after
		// Continuing the Continue Cancel Proposed Budget Record.
//		driver.navigate().refresh();
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.elementToBeClickable(ButtonAddBudgetRecords));
//		String VerifyButtonAddBudgetRecords = ButtonAddBudgetRecords.getText();
//		ObjectRepo.test.log(Status.PASS,
//				"User is Navigated to the 'Manage Jurisdiction Budget' Page after Continuing the Cancel Add Budget Record.:- "
//						+ VerifyButtonAddBudgetRecords);

	}

	public void verifyFunctionalityOfResetButton0nProposedBudgetRecordsForAdmin() throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SearchUsersHeadingOnHomePage));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		String ActualBudgetRecordsHeadingOnHomePage = BudgetRecordsHeadingOnHomePage.getText();
		String ExpectedBudgetRecordsHeadingOnHomePage = "BUDGET RECORDS";
		Assert.assertEquals(ActualBudgetRecordsHeadingOnHomePage, ExpectedBudgetRecordsHeadingOnHomePage);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedBudgetRecordsHeadingOnHomePage);
		String ActualProposedBudgetRecordsLinkOnHomePage = ProposedBudgetRecordsLinkOnHomePage.getText();
		String ExpectedProposedBudgetRecordsLinkOnHomePage = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsLinkOnHomePage, ExpectedProposedBudgetRecordsLinkOnHomePage);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedProposedBudgetRecordsLinkOnHomePage);
		// Click on the Proposed Budget Records Tab
		ProposedBudgetRecordsLinkOnHomePage.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetRecordsHeadingBudgetRecordsPage));
		ObjectRepo.test.log(Status.PASS, "Budget Records page is Displayed");
		// Scroll to the Proposed Budget Records grid to select Decision Card
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsHeadingOnBudgetRecordsPage));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,850)");
		String ActualProposedBudgetRecordsHeadingOnBudgetRecordsPage = ProposedBudgetRecordsHeadingOnBudgetRecordsPage
				.getText();
		String ExpectedProposedBudgetRecordsHeadingOnBudgetRecordsPage = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsHeadingOnBudgetRecordsPage,
				ExpectedProposedBudgetRecordsHeadingOnBudgetRecordsPage);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedProposedBudgetRecordsHeadingOnBudgetRecordsPage);
		// Click on the required Budget Year record
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsHeadingOnBudgetRecordsPage));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,150)");
		Thread.sleep(3000);
		ProposedBudgetRecordsFirstCheckbox.click();
		Thread.sleep(3000);
		RevisionRequestedRadioButton.click();
		Thread.sleep(3000);
		CommentTextArea.click();
		Thread.sleep(3000);
		CommentTextArea.sendKeys("Test Comment for Reset Functionality");
		// Verify functionality of Reset button and the displayed pop-up details
		String ActualResetButtonOnAdminDecisioncard = ResetButtonOnAdminDecisioncard.getText();
		String ExpectedResetButtonOnAdminDecisioncard = "RESET";
		Assert.assertEquals(ActualResetButtonOnAdminDecisioncard, ExpectedResetButtonOnAdminDecisioncard);
		ObjectRepo.test.log(Status.PASS, "Displayed button is:- " + ExpectedResetButtonOnAdminDecisioncard);
		String ActualSubmitButtonOnAdminDecisioncard = SubmitButtonOnAdminDecisioncard.getText();
		String ExpectedSubmitButtonOnAdminDecisioncard = "SUBMIT";
		Assert.assertEquals(ActualSubmitButtonOnAdminDecisioncard, ExpectedSubmitButtonOnAdminDecisioncard);
		ObjectRepo.test.log(Status.PASS, "Displayed button is:- " + ExpectedSubmitButtonOnAdminDecisioncard);
		ResetButtonOnAdminDecisioncard.click();
		Thread.sleep(3000);
		String ActualWarningHeadingOnResetPopup = WarningHeadingOnResetPopup.getText();
		String ExpectedWarningHeadingOnResetPopup = "Warning!";
		Assert.assertEquals(ActualWarningHeadingOnResetPopup, ExpectedWarningHeadingOnResetPopup);
		ObjectRepo.test.log(Status.PASS, "Title on the displayed pop-up is:- " + ExpectedWarningHeadingOnResetPopup);
		String ActualWarningSubHeadingOnResetPopup = WarningSubHeadingOnResetPopup.getText();
		String ExpectedWarningSubHeadingOnResetPopup = "No changes will be saved.";
		Assert.assertEquals(ActualWarningSubHeadingOnResetPopup, ExpectedWarningSubHeadingOnResetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Sub-Title on the displayed pop-up is:- " + ExpectedWarningSubHeadingOnResetPopup);
		String ActualCancelButtonOnResetPopup = CancelButtonOnResetPopup.getText();
		String ExpectedCancelButtonOnResetPopup = "CANCEL";
		Assert.assertEquals(ActualCancelButtonOnResetPopup, ExpectedCancelButtonOnResetPopup);
		ObjectRepo.test.log(Status.PASS, "Button on the displayed pop-up is:- " + ExpectedCancelButtonOnResetPopup);
		String ActualContinueButtonOnResetPopup = ContinueButtonOnResetPopup.getText();
		String ExpectedContinueButtonOnResetPopup = "CONTINUE";
		Assert.assertEquals(ActualContinueButtonOnResetPopup, ExpectedContinueButtonOnResetPopup);
		ObjectRepo.test.log(Status.PASS, "Button on the displayed pop-up is:- " + ExpectedContinueButtonOnResetPopup);
		// Cancel the Reset action
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnResetPopup));
			CancelButtonOnResetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelButtonOnResetPopup, "moveToElementClick", "CancelButtonOnResetPopup");
		}
		Thread.sleep(3000);
		// Verify the details after canceling the Reset action
		String ActualRevisionRequestedRadioButton = RevisionRequestedRadioButton.getAttribute("Value");
		ObjectRepo.test.log(Status.PASS,
				"Decision made before Resetting the inputs is:- " + ActualRevisionRequestedRadioButton);
		Assert.assertEquals(RevisionRequestedRadioButton.isSelected(), true);
		String ActualCommentTextArea = CommentTextArea.getText();
		ObjectRepo.test.log(Status.PASS, "Comments made before Resetting the inputs is:- " + ActualCommentTextArea);
		// Again click on the Reset button
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ResetButtonOnAdminDecisioncard));
			ResetButtonOnAdminDecisioncard.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ResetButtonOnAdminDecisioncard, "moveToElementClick", "ResetButtonOnAdminDecisioncard");
		}
		Thread.sleep(3000);
		// Now selects Continue button
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ContinueButtonOnResetPopup));
			ContinueButtonOnResetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ContinueButtonOnResetPopup, "moveToElementClick", "ContinueButtonOnResetPopup");
		}
		Thread.sleep(3000);
		// Now verify the details after click on Continue button
		String ActualRevisionRequestedRadioButton1 = RevisionRequestedRadioButton.getAttribute("Value");
		ObjectRepo.test.log(Status.PASS,
				"Decision made before Resetting the inputs is:- " + ActualRevisionRequestedRadioButton1);
		Assert.assertEquals(RevisionRequestedRadioButton.isSelected(), false);
		ObjectRepo.test.log(Status.PASS, "Checked radio button is now Unchecked.");
		String ActualCommentTextArea1 = CommentTextArea.getText();
		ObjectRepo.test.log(Status.PASS, "Comments made before Resetting the inputs is:- " + ActualCommentTextArea1);
	}

	public void verifyFunctionalityOfResetButton0nProposedBudgetRecordsForAuthority() throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SearchUsersHeadingOnHomePage));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		String ActualBudgetRecordsHeadingOnHomePage = BudgetRecordsHeadingOnHomePage.getText();
		String ExpectedBudgetRecordsHeadingOnHomePage = "BUDGET RECORDS";
		Assert.assertEquals(ActualBudgetRecordsHeadingOnHomePage, ExpectedBudgetRecordsHeadingOnHomePage);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedBudgetRecordsHeadingOnHomePage);
		String ActualProposedBudgetRecordsLinkOnHomePage = ProposedBudgetRecordsLinkOnHomePage.getText();
		String ExpectedProposedBudgetRecordsLinkOnHomePage = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsLinkOnHomePage, ExpectedProposedBudgetRecordsLinkOnHomePage);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedProposedBudgetRecordsLinkOnHomePage);
		// Click on the Proposed Budget Records Tab
		ProposedBudgetRecordsLinkOnHomePage.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetRecordsHeadingBudgetRecordsPage));
		ObjectRepo.test.log(Status.PASS, "Budget Records page is Displayed");
		// Scroll to the Proposed Budget Records grid to select Decision Card
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsHeadingOnBudgetRecordsPage));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,850)");
		String ActualProposedBudgetRecordsHeadingOnBudgetRecordsPage = ProposedBudgetRecordsHeadingOnBudgetRecordsPage
				.getText();
		String ExpectedProposedBudgetRecordsHeadingOnBudgetRecordsPage = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsHeadingOnBudgetRecordsPage,
				ExpectedProposedBudgetRecordsHeadingOnBudgetRecordsPage);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedProposedBudgetRecordsHeadingOnBudgetRecordsPage);
		// Click on the required Budget Year record
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsHeadingOnBudgetRecordsPage));
		JavascriptExecutor js2 = (JavascriptExecutor) driver;
		js2.executeScript("window.scrollBy(0,150)");
		Thread.sleep(3000);
		ProposedBudgetRecordsFirstCheckbox.click();
		Thread.sleep(3000);
		RevisionRequestedRadioButton.click();
		Thread.sleep(3000);
		CommentTextArea.click();
		Thread.sleep(3000);
		CommentTextArea.sendKeys("Test Comment for Reset Functionality");
		// Verify functionality of Reset button and the displayed pop-up details
		String ActualResetButtonOnAdminDecisioncard = ResetButtonOnAdminDecisioncard.getText();
		String ExpectedResetButtonOnAdminDecisioncard = "RESET";
		Assert.assertEquals(ActualResetButtonOnAdminDecisioncard, ExpectedResetButtonOnAdminDecisioncard);
		ObjectRepo.test.log(Status.PASS, "Displayed button is:- " + ExpectedResetButtonOnAdminDecisioncard);
		String ActualSubmitButtonOnAdminDecisioncard = SubmitButtonOnAdminDecisioncard.getText();
		String ExpectedSubmitButtonOnAdminDecisioncard = "SUBMIT";
		Assert.assertEquals(ActualSubmitButtonOnAdminDecisioncard, ExpectedSubmitButtonOnAdminDecisioncard);
		ObjectRepo.test.log(Status.PASS, "Displayed button is:- " + ExpectedSubmitButtonOnAdminDecisioncard);
		ResetButtonOnAdminDecisioncard.click();
		Thread.sleep(3000);
		String ActualWarningHeadingOnResetPopup = WarningHeadingOnResetPopup.getText();
		String ExpectedWarningHeadingOnResetPopup = "Warning!";
		Assert.assertEquals(ActualWarningHeadingOnResetPopup, ExpectedWarningHeadingOnResetPopup);
		ObjectRepo.test.log(Status.PASS, "Title on the displayed pop-up is:- " + ExpectedWarningHeadingOnResetPopup);
		String ActualWarningSubHeadingOnResetPopup = WarningSubHeadingOnResetPopup.getText();
		String ExpectedWarningSubHeadingOnResetPopup = "No changes will be saved.";
		Assert.assertEquals(ActualWarningSubHeadingOnResetPopup, ExpectedWarningSubHeadingOnResetPopup);
		ObjectRepo.test.log(Status.PASS,
				"Sub-Title on the displayed pop-up is:- " + ExpectedWarningSubHeadingOnResetPopup);
		String ActualCancelButtonOnResetPopup = CancelButtonOnResetPopup.getText();
		String ExpectedCancelButtonOnResetPopup = "CANCEL";
		Assert.assertEquals(ActualCancelButtonOnResetPopup, ExpectedCancelButtonOnResetPopup);
		ObjectRepo.test.log(Status.PASS, "Button on the displayed pop-up is:- " + ExpectedCancelButtonOnResetPopup);
		String ActualContinueButtonOnResetPopup = ContinueButtonOnResetPopup.getText();
		String ExpectedContinueButtonOnResetPopup = "CONTINUE";
		Assert.assertEquals(ActualContinueButtonOnResetPopup, ExpectedContinueButtonOnResetPopup);
		ObjectRepo.test.log(Status.PASS, "Button on the displayed pop-up is:- " + ExpectedContinueButtonOnResetPopup);
		// Cancel the Reset action
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnResetPopup));
			CancelButtonOnResetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(CancelButtonOnResetPopup, "moveToElementClick", "CancelButtonOnResetPopup");
		}
		Thread.sleep(3000);
		// Verify the details after canceling the Reset action
		String ActualRevisionRequestedRadioButton = RevisionRequestedRadioButton.getAttribute("Value");
		ObjectRepo.test.log(Status.PASS,
				"Decision made before Resetting the inputs is:- " + ActualRevisionRequestedRadioButton);
		String ActualCommentTextArea = CommentTextArea.getText();
		ObjectRepo.test.log(Status.PASS, "Comments made before Resetting the inputs is:- " + ActualCommentTextArea);
		// Again click on the Reset button
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ResetButtonOnAdminDecisioncard));
			ResetButtonOnAdminDecisioncard.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ResetButtonOnAdminDecisioncard, "moveToElementClick", "ResetButtonOnAdminDecisioncard");
		}
		Thread.sleep(3000);
		// Now selects Continue button
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ContinueButtonOnResetPopup));
			ContinueButtonOnResetPopup.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(ContinueButtonOnResetPopup, "moveToElementClick", "ContinueButtonOnResetPopup");
		}
		Thread.sleep(3000);
		// Now verify the details after click on Continue button
		String ActualRevisionRequestedRadioButton1 = RevisionRequestedRadioButton.getAttribute("Value");
		ObjectRepo.test.log(Status.PASS,
				"Decision made before Resetting the inputs is:- " + ActualRevisionRequestedRadioButton1);
		String ActualCommentTextArea1 = CommentTextArea.getText();
		ObjectRepo.test.log(Status.PASS, "Comments made before Resetting the inputs is:- " + ActualCommentTextArea1);
	}

	public void verifyJurisdictionAllowanceRequestStatusHistoryGridForAdmin() throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SearchUsersHeadingOnHomePage));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		String ActualBudgetRecordsHeadingOnHomePage = BudgetRecordsHeadingOnHomePage.getText();
		String ExpectedBudgetRecordsHeadingOnHomePage = "BUDGET RECORDS";
		Assert.assertEquals(ActualBudgetRecordsHeadingOnHomePage, ExpectedBudgetRecordsHeadingOnHomePage);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedBudgetRecordsHeadingOnHomePage);
		String ActualProposedBudgetRecordsLinkOnHomePage = ProposedBudgetRecordsLinkOnHomePage.getText();
		String ExpectedProposedBudgetRecordsLinkOnHomePage = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsLinkOnHomePage, ExpectedProposedBudgetRecordsLinkOnHomePage);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedProposedBudgetRecordsLinkOnHomePage);
		// Click on the Proposed Budget Records Tab
		ProposedBudgetRecordsLinkOnHomePage.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetRecordsHeadingBudgetRecordsPage));
		ObjectRepo.test.log(Status.PASS, "Budget Records page is Displayed");
		// Scroll to the Proposed Budget Records grid to select Decision Card
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsHeadingOnBudgetRecordsPage));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1200)");
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		// Verify the grid details listed under the Jurisdiction Allowance Request
		// Status History
		Thread.sleep(3000);
		SelectColumns.click();
		Thread.sleep(3000);
		String ActualRequestStatusFirstColumn = RequestStatusFirstColumn.getText();
		String ExpectedRequestStatusFirstColumn = "Request Status";
		Assert.assertEquals(ActualRequestStatusFirstColumn, ExpectedRequestStatusFirstColumn);
		ObjectRepo.test.log(Status.PASS, "First Column heading is:- " + ExpectedRequestStatusFirstColumn);
		String ActualRequestStatusSecondColumn = RequestStatusSecondColumn.getText();
		String ExpectedRequestStatusSecondColumn = "Budget Year";
		Assert.assertEquals(ActualRequestStatusSecondColumn, ExpectedRequestStatusSecondColumn);
		ObjectRepo.test.log(Status.PASS, "Second Column heading is:- " + ExpectedRequestStatusSecondColumn);
		String ActualAnnualAllowanceBudgetThirdColumn = AnnualAllowanceBudgetThirdColumn.getText();
		String ExpectedAnnualAllowanceBudgetThirdColumn = "Annual Allowance Budget";
		Assert.assertEquals(ActualAnnualAllowanceBudgetThirdColumn, ExpectedAnnualAllowanceBudgetThirdColumn);
		ObjectRepo.test.log(Status.PASS, "Third Column heading is:- " + ExpectedAnnualAllowanceBudgetThirdColumn);
		String ActualReserveAdjustedAllowanceBudgetFourthColumn = ReserveAdjustedAllowanceBudgetFourthColumn.getText();
		String ExpectedReserveAdjustedAllowanceBudgetFourthColumn = "Reserve Adjusted Allowance Budget";
		Assert.assertEquals(ActualReserveAdjustedAllowanceBudgetFourthColumn,
				ExpectedReserveAdjustedAllowanceBudgetFourthColumn);
		ObjectRepo.test.log(Status.PASS,
				"Fourth Column heading is:- " + ExpectedReserveAdjustedAllowanceBudgetFourthColumn);
		String ActualRequestInitiationDateFifthColumn = RequestInitiationDateFifthColumn.getText();
		String ExpectedRequestInitiationDateFifthColumn = "Request Initiation Date";
		Assert.assertEquals(ActualRequestInitiationDateFifthColumn, ExpectedRequestInitiationDateFifthColumn);
		ObjectRepo.test.log(Status.PASS, "Fifth Column heading is:- " + ExpectedRequestInitiationDateFifthColumn);
		Thread.sleep(3000);
		String ActualRequestStatusUpdateDateSixthColumn = RequestStatusUpdateDateSixthColumn.getText();
		String ExpectedRequestStatusUpdateDateSixthColumn = "Request Status Update Date";
		Assert.assertEquals(ActualRequestStatusUpdateDateSixthColumn, ExpectedRequestStatusUpdateDateSixthColumn);
		ObjectRepo.test.log(Status.PASS, "Sixth Column heading is:- " + ExpectedRequestStatusUpdateDateSixthColumn);
		Thread.sleep(3000);
		String ActualUpdatedBySeventhColumn = UpdatedBySeventhColumn.getText();
		String ExpectedUpdatedBySeventhColumn = "Updated By";
		Assert.assertEquals(ActualUpdatedBySeventhColumn, ExpectedUpdatedBySeventhColumn);
		ObjectRepo.test.log(Status.PASS, "Seventh Column heading is:- " + ExpectedUpdatedBySeventhColumn);
		Thread.sleep(3000);
		String ActualCommentEighthColumn = CommentEighthColumn.getText();
		String ExpectedCommentEighthColumn = "Comment";
		Assert.assertEquals(ActualCommentEighthColumn, ExpectedCommentEighthColumn);
		ObjectRepo.test.log(Status.PASS, "Eighth Column heading is:- " + ExpectedCommentEighthColumn);
		driver.navigate().refresh();
		Thread.sleep(8000);
		Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(UserNameWelcome));
		UserNameWelcome.click();
		Thread.sleep(4000);
		Logout.click();
		Thread.sleep(4000);
	}

	public void verifyJurisdictionAllowanceRequestStatusHistoryGridForAuthority() throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(SearchUsersHeadingOnHomePage));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)");
		Thread.sleep(3000);
		String ActualBudgetRecordsHeadingOnHomePage = BudgetRecordsHeadingOnHomePage.getText();
		String ExpectedBudgetRecordsHeadingOnHomePage = "BUDGET RECORDS";
		Assert.assertEquals(ActualBudgetRecordsHeadingOnHomePage, ExpectedBudgetRecordsHeadingOnHomePage);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedBudgetRecordsHeadingOnHomePage);
		String ActualProposedBudgetRecordsLinkOnHomePage = ProposedBudgetRecordsLinkOnHomePage.getText();
		String ExpectedProposedBudgetRecordsLinkOnHomePage = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsLinkOnHomePage, ExpectedProposedBudgetRecordsLinkOnHomePage);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedProposedBudgetRecordsLinkOnHomePage);
		// Click on the Proposed Budget Records Tab
		ProposedBudgetRecordsLinkOnHomePage.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetRecordsHeadingBudgetRecordsPage));
		ObjectRepo.test.log(Status.PASS, "Budget Records page is Displayed");
		// Scroll to the Proposed Budget Records grid to select Decision Card
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsHeadingOnBudgetRecordsPage));
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1200)");
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		// Verify the grid details listed under the Jurisdiction Allowance Request
		// Status History
		Thread.sleep(3000);
		SelectColumns.click();
		Thread.sleep(3000);
		String ActualRequestStatusFirstColumn = RequestStatusFirstColumn.getText();
		String ExpectedRequestStatusFirstColumn = "Request Status";
		Assert.assertEquals(ActualRequestStatusFirstColumn, ExpectedRequestStatusFirstColumn);
		ObjectRepo.test.log(Status.PASS, "First Column heading is:- " + ExpectedRequestStatusFirstColumn);
		String ActualRequestStatusSecondColumn = RequestStatusSecondColumn.getText();
		String ExpectedRequestStatusSecondColumn = "Budget Year";
		Assert.assertEquals(ActualRequestStatusSecondColumn, ExpectedRequestStatusSecondColumn);
		ObjectRepo.test.log(Status.PASS, "Second Column heading is:- " + ExpectedRequestStatusSecondColumn);
		String ActualAnnualAllowanceBudgetThirdColumn = AnnualAllowanceBudgetThirdColumn.getText();
		String ExpectedAnnualAllowanceBudgetThirdColumn = "Annual Allowance Budget";
		Assert.assertEquals(ActualAnnualAllowanceBudgetThirdColumn, ExpectedAnnualAllowanceBudgetThirdColumn);
		ObjectRepo.test.log(Status.PASS, "Third Column heading is:- " + ExpectedAnnualAllowanceBudgetThirdColumn);
		String ActualReserveAdjustedAllowanceBudgetFourthColumn = ReserveAdjustedAllowanceBudgetFourthColumn.getText();
		String ExpectedReserveAdjustedAllowanceBudgetFourthColumn = "Reserve Adjusted Allowance Budget";
		Assert.assertEquals(ActualReserveAdjustedAllowanceBudgetFourthColumn,
				ExpectedReserveAdjustedAllowanceBudgetFourthColumn);
		ObjectRepo.test.log(Status.PASS,
				"Fourth Column heading is:- " + ExpectedReserveAdjustedAllowanceBudgetFourthColumn);
		String ActualRequestInitiationDateFifthColumn = RequestInitiationDateFifthColumn.getText();
		String ExpectedRequestInitiationDateFifthColumn = "Request Initiation Date";
		Assert.assertEquals(ActualRequestInitiationDateFifthColumn, ExpectedRequestInitiationDateFifthColumn);
		ObjectRepo.test.log(Status.PASS, "Fifth Column heading is:- " + ExpectedRequestInitiationDateFifthColumn);
		String ActualRequestStatusUpdateDateSixthColumn = RequestStatusUpdateDateSixthColumn.getText();
		String ExpectedRequestStatusUpdateDateSixthColumn = "Request Status Update Date";
		Assert.assertEquals(ActualRequestStatusUpdateDateSixthColumn, ExpectedRequestStatusUpdateDateSixthColumn);
		ObjectRepo.test.log(Status.PASS, "Sixth Column heading is:- " + ExpectedRequestStatusUpdateDateSixthColumn);
		String ActualUpdatedBySeventhColumn = UpdatedBySeventhColumn.getText();
		String ExpectedUpdatedBySeventhColumn = "Updated By";
		Assert.assertEquals(ActualUpdatedBySeventhColumn, ExpectedUpdatedBySeventhColumn);
		ObjectRepo.test.log(Status.PASS, "Seventh Column heading is:- " + ExpectedUpdatedBySeventhColumn);
		String ActualCommentEighthColumn = CommentEighthColumn.getText();
		String ExpectedCommentEighthColumn = "Comment";
		Assert.assertEquals(ActualCommentEighthColumn, ExpectedCommentEighthColumn);
		ObjectRepo.test.log(Status.PASS, "Eighth Column heading is:- " + ExpectedCommentEighthColumn);
//		driver.navigate().refresh();
//		Thread.sleep(8000);
//		Thread.sleep(4000);
//		wait.until(ExpectedConditions.elementToBeClickable(UserNameWelcome));
//		UserNameWelcome.click();
//		Thread.sleep(4000);
//		Logout.click();
//		Thread.sleep(4000);
	}

	public void VerifyRequeststatusBudgetRecordStatusforJuriAdminAfterDenialofBudgetRecord() throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsGridHeading));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		String ActualRequestStatus = RequestStatusDenied.getText();
		String ExpectedRequestStatus = "Denied";
		Assert.assertEquals(ActualRequestStatus, ExpectedRequestStatus);
		ObjectRepo.test.log(Status.PASS, "Request Status for the denied budget record is:- " + ExpectedRequestStatus);
		// String FetchedBudgetYear = BudgetYear.getText();
		String AddedBudgetYear = AddBudgetYear;
		// Assert.assertEquals(FetchedBudgetYear, AddedBudgetYear);
		ObjectRepo.test.log(Status.PASS, "Budget Year for the denied budget record was:- " + AddedBudgetYear);
		wait.until(ExpectedConditions.elementToBeClickable(JurisdictionAllowanceRequestStatusHistoryHeading));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
//		SearchProposedBudgetRecords.click();
//		Thread.sleep(3000);
		ClearSearchProposedGrid.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys("Denied");
		Thread.sleep(3000);
		String ActualNumberOfRows = NumberOfRows.getText();
		System.out.println(ActualNumberOfRows);
		Assert.assertEquals(ActualNumberOfRows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS,
				"Denied Budget Record Status is not present in Proposed Budget Record grid:- " + ActualNumberOfRows);
	}

	public void VerifyPendingQueueofApprovalafterDenialofBudget() throws Exception {
		// Navigate to Proposed Budget Records card
		Thread.sleep(3000);
//		SearchProposedBudgetRecords.click();
//		Thread.sleep(3000);
		ClearSearchProposedGrid.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys(AddBudgetYear);
		Thread.sleep(3000);
		String ActualNumberOfRows = NumberOfRows.getText();
		System.out.println(ActualNumberOfRows);
		Assert.assertEquals(ActualNumberOfRows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS,
				"Denied Budget Record is moved from the Pending Queue of Approval and it is moved to the Jurisdiction Allowance Request Status History with the updated Request Status:- "
						+ ActualNumberOfRows);
	}

	public void VerifyRequestStatusForWCIIncAdminAfterDenial() throws Exception {
		// Navigate to Jurisdiction Allowance Request Status History card
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetDetailsCard));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		String ActualRequestStatus = RequestStatusDenied.getText();
		String ExpectedRequestStatus = "Denied";
		Assert.assertEquals(ActualRequestStatus, ExpectedRequestStatus);
		ObjectRepo.test.log(Status.PASS, "Request Status for the denied budget record is:- " + ExpectedRequestStatus);
		// String FetchedBudgetYear = BudgetYear.getText();
		String AddedBudgetYear = AddBudgetYear;
		// Assert.assertEquals(FetchedBudgetYear, AddedBudgetYear);
		ObjectRepo.test.log(Status.PASS, "Budget Year for the denied budget record was:- " + AddedBudgetYear);
	}

	public void VerifyBudgetRecordStatusAfterDenialForWCIIncAdmin() throws Exception {
		// Navigate to Proposed Budget Records card
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetDetailsCard));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		String ActualProposedBudgetRecordsHeading = ProposedBudgetRecordsHeadingOnBudgetRecordsPage.getText();
		String ExpectedProposedBudgetRecordsHeading = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsHeading, ExpectedProposedBudgetRecordsHeading);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedProposedBudgetRecordsHeading);
		// Verify the Budget Record Status for denied Budget Year record
		Thread.sleep(3000);
//		SearchProposedBudgetRecords.click();
//		Thread.sleep(3000);
		SearchProposedBudgetRecords.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys(AddBudgetYear);
		Thread.sleep(3000);
		String ActualNumberOfRows = NumberOfRows.getText();
		System.out.println(ActualNumberOfRows);
		Assert.assertEquals(ActualNumberOfRows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS,
				"Denied Budget Record Status is not present in Proposed Budget Record grid for WCI Inc Admin:- "
						+ ActualNumberOfRows);
	}

	public void VerifyBudgetYearIsDisplayOnTheAddBudgetScreenFoWCIncAdminAfterDenial() throws Exception {
		// Navigate to Proposed Budget Records card
		Thread.sleep(4000);
		try {
			ButtonAddBudgetRecords.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ButtonAddBudgetRecords, "moveToElementClick", "AddBudget");
		}
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		AddBudgetYear = AddBudgetRecordYear1.getText();
		System.out.println(AddBudgetYear);
		ObjectRepo.test.log(Status.PASS,
				"Budget Year is displayed on the Add Budget screen for WCI Inc. Admin after denial by Juri. Admin"
						+ AddBudgetYear);
	}

	public void RequestRevisionRecord_JAdmin1() throws Exception {
		Thread.sleep(10000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,650)");
		Thread.sleep(6000);
		SearchProposeBudget.sendKeys(AddBudgetYear);
		Thread.sleep(6000);
		try {
			SelectRecord.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SelectRecord, "moveToElementClick", "SelectRecord");
		}
		Thread.sleep(4000);
		js.executeScript("window.scrollBy(0,450)");
		try {
			RequestRevisionRadio.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(RequestRevisionRadio, "moveToElementClick", "SelectRecord");
		}
		CommentField.sendKeys("Testing Purpose");
		Thread.sleep(3000);

		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}
		ObjectRepo.test.log(Status.PASS, "Proposed Record Submitted by Jurisdiction Admin for Request Revision.");
		Thread.sleep(3000);
		try {
			ProposeBudgetPopupCancelButton.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(ProposeBudgetPopupCancelButton, "moveToElementClick", "ProposeBudgetPopupCancelButton");
		}

		ObjectRepo.test.log(Status.PASS, "Proposed Requested Revision Record Cancelled by Jurisdiction Admin.");
		Thread.sleep(3000);

		try {
			SubmitBtn.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}

		ObjectRepo.test.log(Status.PASS, "Proposed Record again Submitted by Jurisdiction Admin for Request Revision.");
		Thread.sleep(3000);
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		PassphraseText.sendKeys(prop.getProperty("Password"));
		ConfirmBtn_popUp.click();
		Thread.sleep(3000);
		SuccessCross.click();
		ObjectRepo.test.log(Status.PASS, "Proposed Record Requested Revision successfully by Jurisdiction Admin.");
	}

	public void VerifyRequestStatusForWCIIncAdminAfterRequestRevision() throws Exception {
		// Navigate to Jurisdiction Allowance Request Status History card
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetDetailsCard));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		String ActualRequestStatus = RequestStatusRevisionRequested.getText();
		String ExpectedRequestStatus = "Denied";
		Assert.assertEquals(ActualRequestStatus, ExpectedRequestStatus);
		ObjectRepo.test.log(Status.PASS, "Request Status for the denied budget record is:- " + ExpectedRequestStatus);
		// String FetchedBudgetYear = BudgetYear.getText();
		String AddedBudgetYear = AddBudgetYear;
		// Assert.assertEquals(FetchedBudgetYear, AddedBudgetYear);
		ObjectRepo.test.log(Status.PASS, "Budget Year for the denied budget record was:- " + AddedBudgetYear);
	}

	public void VerifyRequeststatusBudgetRecordStatusforJuriAdminAfterRequestRevisionofBudgetRecord() throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsGridHeading));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		String ActualRequestStatus = RequestStatusRevisionRequested.getText();
		String ExpectedRequestStatus = "Revisions Requested";
		Assert.assertEquals(ActualRequestStatus, ExpectedRequestStatus);
		ObjectRepo.test.log(Status.PASS,
				"Request Status for the revision requested budget record is:- " + ExpectedRequestStatus);
		// String FetchedBudgetYear = BudgetYear.getText();
		String AddedBudgetYear = AddBudgetYear;
		// Assert.assertEquals(FetchedBudgetYear, AddedBudgetYear);
		ObjectRepo.test.log(Status.PASS,
				"Budget Year for the revision requested budget record was:- " + AddedBudgetYear);
		wait.until(ExpectedConditions.elementToBeClickable(JurisdictionAllowanceRequestStatusHistoryHeading));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
//		SearchProposedBudgetRecords.click();
//		Thread.sleep(3000);
		ClearSearchProposedGrid.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys(AddBudgetYear);
		Thread.sleep(3000);
		String ActualNumberOfRows = NumberOfRows.getText();
		System.out.println(ActualNumberOfRows);
		Assert.assertEquals(ActualNumberOfRows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS,
				"Revision Requested Budget Record Status is not present in Proposed Budget Record grid:- "
						+ ActualNumberOfRows);
	}

	public void VerifyBudgetRecordStatusAfterRequestRevisionForWCIIncAdmin() throws Exception {
		// Navigate to Proposed Budget Records card
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetDetailsCard));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,800)");
		Thread.sleep(3000);
		String ActualProposedBudgetRecordsHeading = ProposedBudgetRecordsHeadingOnBudgetRecordsPage.getText();
		String ExpectedProposedBudgetRecordsHeading = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsHeading, ExpectedProposedBudgetRecordsHeading);
		ObjectRepo.test.log(Status.PASS, "Title of the displayed card is:- " + ExpectedProposedBudgetRecordsHeading);
		// Verify the Budget Record Status for Request Revision Budget Year record
		Thread.sleep(3000);
//		SearchProposedBudgetRecords.click();
//		Thread.sleep(3000);
		SearchProposedBudgetRecords.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys("Revisions Requested");
		Thread.sleep(3000);
		Thread.sleep(3000);
		// Fetch the year of the searched results
		String ActualSearchedRRYear = SearchedRRYear.getText();
//		String ExpectedSearchedRRYear = AddBudgetYear;
//		Assert.assertEquals(ActualSearchedRRYear, ExpectedSearchedRRYear);
		ObjectRepo.test.log(Status.PASS,
				"Revisions Requested Record is displayed in Proposed Budget Records for WCI Inc Admin:- "
						+ ActualSearchedRRYear);
	}

	public void VerifyRequestRevisionRecordsInProposedBudgetQueueForWCIIncAdminAfterRequestRevision() throws Exception {
		// Navigate to Proposed Budget Records card
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)");
		Thread.sleep(3000);
		String ActualProposedBudgetRecordsCard = ProposedBudgetRecordsCard.getText();
		String ExpectedProposedBudgetRecordsCard = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsCard, ExpectedProposedBudgetRecordsCard);
		ObjectRepo.test.log(Status.PASS, "Proposed Budget Records card is Displayed");
		Thread.sleep(3000);
		// Search for Requested Revision Record
		SearchProposedBudgetRecords.sendKeys("Revisions Requested");
		Thread.sleep(3000);
		// Fetch the year of the searched results
		String ActualSearchedRRYear = SearchedRRYear.getText();
		String ExpectedSearchedRRYear = AddBudgetYear;
		Assert.assertEquals(ActualSearchedRRYear, ExpectedSearchedRRYear);
		ObjectRepo.test.log(Status.PASS,
				"Revisions Requested Record is displayed in Proposed Budget Records for WCI Inc Admin:- "
						+ ActualSearchedRRYear);
	}

	public void VerifyViewRequestHistoryTableforWCIIncAdmin() throws Exception {
		// Scroll to the Jurisdiction Allowance Request Status History' Grid
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(BudgetDetailsCard));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(3000);
		// Verify the heading of Jurisdiction Allowance Request Status History' Grid
		String ActualJurisdictionAllowanceRequestStatusHistoryCard = JurisdictionAllowanceRequestStatusHistoryCard
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryCard = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryCard,
				ExpectedJurisdictionAllowanceRequestStatusHistoryCard);
		ObjectRepo.test.log(Status.PASS, "Heading of the grid whose UI needs to be check is:- "
				+ ExpectedJurisdictionAllowanceRequestStatusHistoryCard);
		// Verify the columns of Jurisdiction Allowance Request Status History' Grid
		Thread.sleep(3000);
		SelectColumns.click();
		Thread.sleep(3000);
		String ActualRequestStatusFirstColumn = RequestStatusFirstColumn.getText();
		String ExpectedRequestStatusFirstColumn = "Request Status";
		Assert.assertEquals(ActualRequestStatusFirstColumn, ExpectedRequestStatusFirstColumn);
		ObjectRepo.test.log(Status.PASS, "First Column heading is:- " + ExpectedRequestStatusFirstColumn);
		String ActualRequestStatusSecondColumn = RequestStatusSecondColumn.getText();
		String ExpectedRequestStatusSecondColumn = "Budget Year";
		Assert.assertEquals(ActualRequestStatusSecondColumn, ExpectedRequestStatusSecondColumn);
		ObjectRepo.test.log(Status.PASS, "Second Column heading is:- " + ExpectedRequestStatusSecondColumn);
		String ActualAnnualAllowanceBudgetThirdColumn = AnnualAllowanceBudgetThirdColumn.getText();
		String ExpectedAnnualAllowanceBudgetThirdColumn = "Annual Allowance Budget";
		Assert.assertEquals(ActualAnnualAllowanceBudgetThirdColumn, ExpectedAnnualAllowanceBudgetThirdColumn);
		ObjectRepo.test.log(Status.PASS, "Third Column heading is:- " + ExpectedAnnualAllowanceBudgetThirdColumn);
		String ActualReserveAdjustedAllowanceBudgetFourthColumn = ReserveAdjustedAllowanceBudgetFourthColumn.getText();
		String ExpectedReserveAdjustedAllowanceBudgetFourthColumn = "Reserve Adjusted Allowance Budget";
		Assert.assertEquals(ActualReserveAdjustedAllowanceBudgetFourthColumn,
				ExpectedReserveAdjustedAllowanceBudgetFourthColumn);
		ObjectRepo.test.log(Status.PASS,
				"Fourth Column heading is:- " + ExpectedReserveAdjustedAllowanceBudgetFourthColumn);
		String ActualRequestInitiationDateFifthColumn = RequestInitiationDateFifthColumn.getText();
		String ExpectedRequestInitiationDateFifthColumn = "Request Initiation Date";
		Assert.assertEquals(ActualRequestInitiationDateFifthColumn, ExpectedRequestInitiationDateFifthColumn);
		ObjectRepo.test.log(Status.PASS, "Fifth Column heading is:- " + ExpectedRequestInitiationDateFifthColumn);
		Thread.sleep(3000);
		String ActualRequestStatusUpdateDateSixthColumn = RequestStatusUpdateDateSixthColumn.getText();
		String ExpectedRequestStatusUpdateDateSixthColumn = "Request Status Update Date";
		Assert.assertEquals(ActualRequestStatusUpdateDateSixthColumn, ExpectedRequestStatusUpdateDateSixthColumn);
		ObjectRepo.test.log(Status.PASS, "Sixth Column heading is:- " + ExpectedRequestStatusUpdateDateSixthColumn);
		Thread.sleep(3000);
		String ActualUpdatedBySeventhColumn = UpdatedBySeventhColumn.getText();
		String ExpectedUpdatedBySeventhColumn = "Updated By";
		Assert.assertEquals(ActualUpdatedBySeventhColumn, ExpectedUpdatedBySeventhColumn);
		ObjectRepo.test.log(Status.PASS, "Seventh Column heading is:- " + ExpectedUpdatedBySeventhColumn);
		Thread.sleep(3000);
		String ActualCommentEighthColumn = CommentEighthColumn.getText();
		String ExpectedCommentEighthColumn = "Comment";
		Assert.assertEquals(ActualCommentEighthColumn, ExpectedCommentEighthColumn);
		ObjectRepo.test.log(Status.PASS, "Eighth Column heading is:- " + ExpectedCommentEighthColumn);
		Thread.sleep(8000);
	}

	public void VerifyRequeststatusBudgetRecordStatusforJuriAuthorityAfterRequestRevisionofBudgetRecord()
			throws Exception {
		// Navigate to Proposed Budget Records page
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsGridHeading));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		String ActualJurisdictionAllowanceRequestStatusHistoryHeading = JurisdictionAllowanceRequestStatusHistoryHeading
				.getText();
		String ExpectedJurisdictionAllowanceRequestStatusHistoryHeading = "Jurisdiction Allowance Request Status History";
		Assert.assertEquals(ActualJurisdictionAllowanceRequestStatusHistoryHeading,
				ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		ObjectRepo.test.log(Status.PASS,
				"Title of the displayed card is:- " + ExpectedJurisdictionAllowanceRequestStatusHistoryHeading);
		String ActualRequestStatus = RequestStatusRevisionRequested.getText();
		String ExpectedRequestStatus = "Revisions Requested";
		Assert.assertEquals(ActualRequestStatus, ExpectedRequestStatus);
		ObjectRepo.test.log(Status.PASS,
				"Request Status for the revision requested budget record is:- " + ExpectedRequestStatus);
		// String FetchedBudgetYear = BudgetYear.getText();
		String AddedBudgetYear = AddBudgetYear;
		// Assert.assertEquals(FetchedBudgetYear, AddedBudgetYear);
		ObjectRepo.test.log(Status.PASS,
				"Budget Year for the revision requested budget record was:- " + AddedBudgetYear);
		wait.until(ExpectedConditions.elementToBeClickable(JurisdictionAllowanceRequestStatusHistoryHeading));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-200)");
		Thread.sleep(3000);
//		SearchProposedBudgetRecords.click();
//		Thread.sleep(3000);
		ClearSearchProposedGrid.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys("Revisions Requested");
		Thread.sleep(3000);
		String ActualSearchedRRYear = SearchedRRYear.getText();
		System.out.println(ActualSearchedRRYear);
		// Assert.assertEquals(ActualSearchedRRYear, AddBudgetYear);
		ObjectRepo.test.log(Status.PASS,
				"Revision Requested Budget Record Status is present in Proposed Budget Record grid for the year:- "
						+ AddedBudgetYear);
	}

	public void VerifyBudgetRecordStatusforJuriAuthorityAfterRequestRevisionofBudgetRecord() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsGridHeading));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		Thread.sleep(3000);
		Thread.sleep(3000);
		ClearSearchProposedGrid.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.click();
		Thread.sleep(3000);
		SearchProposedBudgetRecords.sendKeys("Revisions Requested");
		Thread.sleep(3000);
		String ActualSearchedRRYear = SearchedRRYear.getText();
		System.out.println(ActualSearchedRRYear);
		Assert.assertEquals(ActualSearchedRRYear, AddBudgetYear);
		ObjectRepo.test.log(Status.PASS,
				"Proposed To Authority Budget Record Status is changed to Revisions Requested for the budget year:- "
						+ ActualSearchedRRYear);
	}

	public void VerifyRRBudgetRecordsInProposedBudgetQueueForWCIIncAdminAfterRRByJuriAuthority() throws Exception {
		// Navigate to Proposed Budget Records card
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveBudgetRecordsCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(3000);
		String ActualProposedBudgetRecordsCard = ProposedBudgetRecordsCard.getText();
		String ExpectedProposedBudgetRecordsCard = "Proposed Budget Records";
		Assert.assertEquals(ActualProposedBudgetRecordsCard, ExpectedProposedBudgetRecordsCard);
		ObjectRepo.test.log(Status.PASS, "Proposed Budget Records card is Displayed");
		Thread.sleep(3000);
		// Search for Requested Revision Record
		SearchProposedBudgetRecords.sendKeys("Revisions Requested");
		Thread.sleep(3000);
		// Fetch the year of the searched results
		String ActualSearchedRRYear = SearchedRRYear.getText();
//		String ExpectedSearchedRRYear = AddBudgetYear;
//		Assert.assertEquals(ActualSearchedRRYear, ExpectedSearchedRRYear);
		ObjectRepo.test.log(Status.PASS,
				"Revisions Requested Record is displayed in Proposed Budget Records for WCI Inc Admin:- "
						+ ActualSearchedRRYear);
		// Verify the added comment while Revisions Requested by Authority
		wait.until(ExpectedConditions.elementToBeClickable(ProposedBudgetRecordsCard));
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,100)");
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EditProposedBudgetQuickAction));
			EditProposedBudgetQuickAction.click();
		} catch (Exception ex) {
			CM.click2(EditProposedBudgetQuickAction, "moveToElementClick", "EditProposedBudgetQuickAction");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(EditBudgetRecord));
			EditBudgetRecord.click();
		} catch (Exception ex) {
			CM.click2(EditBudgetRecord, "moveToElementClick", "EditBudgetRecord");
		}
		String ActualBudgetYearValue = BudgetYearValue.getText();
//		String ExpectedBudgetYearValue = AddBudgetYear;
//		Assert.assertEquals(ActualBudgetYearValue, ExpectedBudgetYearValue);
		ObjectRepo.test.log(Status.PASS,
				"Revisions Requested Record is displayed in Proposed Budget Records for WCI Inc Admin for the year:- "
						+ ActualBudgetYearValue);
		String ActualAddedComment = AddedComment.getText();
//		String ExpectedAddedComment = AddBudgetYear;
//		Assert.assertEquals(ActualAddedComment, ExpectedAddedComment);
		ObjectRepo.test.log(Status.PASS,
				"Added comment in Proposed Budget Records for WCI Inc Admin for the year:- " + ActualAddedComment);
	}

}
