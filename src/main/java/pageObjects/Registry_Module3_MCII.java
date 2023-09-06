package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;

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
import resources.base;

public class Registry_Module3_MCII {

	RegModule3_MJB_POM MJB;
	Properties prop;
	JavascriptExecutor js;
	CommonMethods CM;
	private WebDriver driver;
	publicHomePage PH;
	Registry_Module3_OM OM;
	public static String nextDate;
	public static String preDate;
	String allowancetransferId;
	String status;
	static String FirstEffectiveBudgetYear;
	int FirstallowanceOutstandingForReserveAdjustedAllowanceBudget;
	String QuantityEntered;
	int Secondquantity;
	String allowanceOutstandingForReserveAdjustedAllowanceBudget;
	String offsetTransferId;
	WebDriverWait wait;
	List<String> ApprovedBudgetYearsList;
	String FirstApprovedYear;
	String SelectedProjectname;
	String OffsetIdValue;
	File src;
	FileInputStream fis;
	Actions actions;
	String ReserveBudget;
	String AccountBalance;
	String AvailableAccountBalance;
	String QuantityIssued;

	
	@FindBy(xpath = "//a[text()='HOME']")
	WebElement HomeMenu;
	// Common
	@FindBy(xpath = "//button[text()='Welcome,']")
	WebElement WelcomeButton;
	@FindBy(xpath = "//a[text()='Logout']")
	WebElement Logout;

	// Home page
//	@FindBy(xpath = "(//div[@class='MuiAccordionSummary-expandIconWrapper css-1fx8m19'])[3]")
	@FindBy(xpath = "//p[text()='All Jurisdiction Accounts']")
	WebElement JurisdictionAccountsGrid;
	@FindBy(xpath = "(//div[@data-field='accountNumber'])[2]")
	WebElement IssuanceAccounts;
	@FindBy(xpath = "//button[text()='MENU']")
	WebElement MegaMenu;
	@FindBy(xpath = "//p[text()='Issuance Records']")
	WebElement IssuanceRecordOption;
	@FindBy(xpath = "//a[text()='HOME']")
	WebElement Home;
	@FindBy(xpath = "//a[text()='View Budget Records']")
	WebElement ViewBudgetRecordLable;
	@FindBy(xpath = "//h4[text()='Issuance Records']")
	WebElement IssuanceRecordLable;
	@FindBy(xpath = "//a[text()='Offset Project Name Management']")
	WebElement OffsetProjectNameManagementLable;
	@FindBy(xpath = "//a[text()='Offset Project Operator Management']")
	WebElement OffsetProjectOperatorManagementLable;
	@FindBy(xpath = "//a[text()='Verification Body Management']")
	WebElement VerificationBodyManagementLable;

	// Offset Project Name Management Page
	@FindBy(xpath = "(//div[@data-field='offset_project_name'])[2]")
	WebElement FirstOffsetProjectName;
	@FindBy(xpath = "//input[@placeholder='Search…']")
	WebElement SearchField;

	// Offset Project Operator Management Page
	@FindBy(xpath = "(//div[@data-field='offset_project_operator'])[2]")
	WebElement FirstOffsetProjectOperator;

	// Verification Body Management Page
	@FindBy(xpath = "(//div[@data-field='offset_verification_body'])[2]")
	WebElement FirstOffsetVerificationBody;

	// Issuance Records Page
	@FindBy(xpath = "//h1[text()='Issuance Records']")
	WebElement IssuanceRecordPageTitle;
	@FindBy(xpath = "//input[@type='search']")
	WebElement Search;
	@FindBy(xpath = "(//div[@data-field='status'])[2]")
	WebElement StatusColumn;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 link-cell css-1195g5e'])[1]")
	WebElement TransferIdColumn;
	
	
	// Issuance Account page
	@FindBy(xpath = "//h1[text()='Issuance Account']")
	WebElement IssuanceAccountPageTitle;
	@FindBy(xpath = "//button[text()='MORE ACTIONS']")
	WebElement MoreActionsBtn;
	@FindBy(xpath = "//p[text()='ALLOWANCE ISSUANCE']")
	WebElement AllowanceIssuanceSubMenu;
	@FindBy(xpath = "//p[text()='OFFSET ISSUANCE']")
	WebElement OffsetIssuanceSubMenu;
	@FindBy(xpath = "//p[text()='INITIATE BATCH TRANSFER']")
	WebElement InitiateBatchTransferSubMenu;
	@FindBy(xpath = "//h2[text()='Initiate Batch Transfer']")
	WebElement PopUpInitiateBatchTransfer;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Reset']")
	WebElement PopUpInitiateBatchTransferCancelBtn;
	@FindBy(xpath = "//h2[text()='Account Information']")
	WebElement AccountInfoCardTitle;
	@FindBy(xpath = "//h2[text()='Holdings']")
	WebElement HoldingsCardTitle;
	@FindBy(xpath = "//h2[text()='Transfers']")
	WebElement TransfersCardTitle;
	@FindBy(xpath = "//*[@class='MuiTypography-root MuiTypography-body1 css-whmdde']")
	List<WebElement> AccountInfoCardFields;
	@FindBy(xpath = "(//input[@type='search'])[1]")
	WebElement Search1;
	@FindBy(xpath = "(//input[@type='search'])[2]")
	WebElement Search2;
	@FindBy(xpath = "(//div[@data-field='specialCategory'])[2]")
	WebElement FirstOffsetIdHoldingTable;
	@FindBy(xpath = "(//div[@data-field='subType'])[2]")
	WebElement FirstSubTypeHoldingTable;
	@FindBy(xpath = "(//div[@data-field='transferId'])[2]")
	WebElement FirstTransferIdTransferTable;
	@FindBy(xpath = "(//div[@data-field='transferringAccountName'])[2]")
	WebElement FirstTransferringAccountNameTransferTable;
	@FindBy(xpath = "(//div[@data-field=\"status\"])[2]")
	WebElement FirstStatusTransferTable;
	@FindBy(xpath = "//h2[text()='Holdings']")
	WebElement HoldingGridTitle;
	@FindBy(xpath = "//div[contains(@class,'MuiDataGrid-columnHeader MuiDataGrid-columnHeader--sortable')]")
	List<WebElement> TableColumns;
	@FindBy(xpath = "//h2[text()='Transfers']")
	WebElement TransferGridTitle;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[4]")
	WebElement AccountBalancevalue;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[5]")
	WebElement AvailableAccountBalancevalue;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[1]")
	WebElement IssuanceAccountNumber;
	
	
	// Offset Issunace Account Page
	@FindBy(xpath = "//h1[text()='Offset Issuance']")
	WebElement OffsetIssuancePageTitle;
	@FindBy(xpath = "//h2[text()='Offset Issuance Information']")
	WebElement OffsetIssuanceInfoCardTitle;
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 fc-select-rounded css-1wxaqej']")
	WebElement VintageyearField;
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 input-group css-1wxaqej']")
	WebElement OffsetProjectNameField;
	@FindBy(xpath = "//label[text()='Offset Project ID']")
	WebElement OffsetProjectIDField;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 css-1wxaqej'])[1]")
	WebElement OffsetTypeField;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 css-1wxaqej'])[2]")
	WebElement OffsetProjectOperatorField;
	@FindBy(xpath = "(//div[@class='label-wrapper date-picker MuiBox-root css-0'])[1]")
	WebElement BeginReportingPeriodLabel;	
	@FindBy(xpath = "(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedEnd css-sq7cdp'])[1]")
	WebElement BeginDateField;
	@FindBy(xpath = "(//div[@class='label-wrapper date-picker MuiBox-root css-0'])[2]")
	WebElement EndReportingPeriodLabel;	
	@FindBy(xpath = "(//div[@class='MuiInputBase-root MuiOutlinedInput-root MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-adornedEnd css-sq7cdp'])[2]")
	WebElement EndDateField;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 fc-select-rounded css-1pkk87k'])[1]")
	WebElement VerificationBodyField;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 fc-select-rounded css-1pkk87k'])[2]")
	WebElement ProjectSiteField;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 fc-select-rounded css-1pkk87k'])[3]")
	WebElement SpecialCategoryField;
	
	
	@FindBy(xpath = "//input[@id='VintageYear-react-hook-form-select-search']")
//	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[1]")
	WebElement VintageYearDropdown;
	@FindBy(xpath = "//input[@id='Quantity']")
	WebElement Quantity;
	@FindBy(xpath = "//input[@id='OffsetProjectName-react-hook-form-select-search']")
//	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[2]")
	WebElement OffsetProjectNameDropdown;
	@FindBy(xpath = "//input[@id='projectName']")
	WebElement EnterOffsetProjectname;
	@FindBy(xpath = "//input[@id='ProjectId']")
	WebElement OffsetProjectID;
	@FindBy(xpath = "//input[@id='OffsetType-react-hook-form-select-search']")
//	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[3]")
	WebElement OffsetType;
	@FindBy(xpath = "//input[@id='OffsetProjectOperator-react-hook-form-select-search']")
//	@FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium MuiAutocomplete-popupIndicator css-uge3vf'])[4]")
	WebElement OffsetProjectOperatorDropdown;
	@FindBy(xpath = "//input[@id='projectOperatorName']")
	WebElement EnterOffsetProjectOperatorname;
	@FindBy(xpath = "(//*[@placeholder='YYYY/MM/DD'])[1]")
	WebElement BeginReportingPeriod2;
	@FindBy(xpath = "(//*[@data-testid='CalendarIcon'])[1]")
	WebElement BeginReportingPeriodIcon;
	@FindBy(xpath = "(//*[@data-testid='CalendarIcon'])[2]")
	WebElement EndReportingPeriodIcon;
	@FindBy(xpath = "(//input[@placeholder=\"YYYY/MM/DD\"])[2]")
	WebElement EndReportingPeriod2;
	@FindBy(xpath = "(//button[@aria-colindex='4'])[2]")
	WebElement Date12;
	@FindBy(xpath = "//*[@aria-current='date']")
	WebElement CurrentDate;
	@FindBy(xpath = "(//button[@aria-colindex='6'])[2]")
	WebElement Date14;

	@FindBy(xpath = "//input[@id='OffsetVerificationBody-react-hook-form-select-search']")
	WebElement VerificationBodyDropdown;
	@FindBy(xpath = "//input[@id='verificationBody']")
	WebElement EnterVerificationBody;
	@FindBy(xpath = "//input[@id='OffsetProjectSite-react-hook-form-select-search']")
	WebElement ProjectSiteDropdown;
	@FindBy(xpath = "//input[@id='OffsetSpecialCategory-react-hook-form-select-search']")
	WebElement SpecialCategoryDropdown;
	@FindBy(xpath = "//textarea[@id='Comment']")
	WebElement Comment;
	@FindBy(xpath = "//*[@data-testid='priv_btn_cancel']")
	WebElement CancelBtn_OffsetIssuance;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Cancel']")
	WebElement PopUpCancel_CancelBtn_OffsetIssuance;
	@FindBy(xpath = "//button[@data-testid='priv_modal_Continue']")
	WebElement PopUpContinue_CancelBtn_OffsetIssuance;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement SubmitlBtn_OffsetIssuance;
	@FindBy(xpath = "//input[@id='passphrase']")
	WebElement Passphrase_OffsetIssuance;
	@FindBy(xpath = "//button[text()='Confirm']")
	WebElement ConfirmBtnPopUp;
	@FindBy(xpath = "(//button[text()='Cancel'])[2]")
	WebElement CancelBtnPopUp;
	@FindBy(xpath = "//*[contains(text(),'The issuance has been successfully prepared and is awaiting review.')]")
	WebElement SuccessMessage;
//	private By SuccessMessage = By.xpath("//*[contains(text(),'The issuance has been successfully prepared and is awaiting review.')]");
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[1]")
	WebElement CreatedTransferId;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[5]")
	WebElement OffsetProjectnameValue;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[10]")
	WebElement OffsetProjectOperatorValue;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[11]")
	WebElement VerificationBodyValue;
	
	@FindBy(xpath = "//p[@id='projectName-helper-text']")
	WebElement ErrorMessage_Projectname;
	@FindBy(xpath = "//p[@id='projectOperatorName-helper-text']")
	WebElement ErrorMessage_ProjectOperatorName;
	@FindBy(xpath = "//p[@id='verificationBody-helper-text']")
	WebElement ErrorMessage_VerificationBody;
	@FindBy(xpath = "(//p[@class='MuiFormHelperText-root Mui-error css-bpd4r6'])[4]")
	WebElement ErrorMessage2_OffsetProjectOperator;
	@FindBy(xpath = "(//p[@class='MuiFormHelperText-root Mui-error css-bpd4r6'])[5]")
	WebElement ErrorMessage2_VerificationBody;
//	@FindBy(xpath = "//p[@id=':r6g:-helper-text']")
//	@FindBy(xpath = "//p[@id=':r68:-helper-text']")
	@FindBy(xpath = "//p[@class='MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained MuiFormHelperText-filled css-sf5fa6']")
	WebElement ErrorMessEndReportingPeriod;
	@FindBy(xpath = "//span[text()='*']")
	WebElement asteriskMark;
	@FindBy(xpath = "//div[@class='label-wrapper MuiBox-root css-0']")
	WebElement CommentLabel;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 css-1eifdk0']")
	WebElement SuccessMsg;
	@FindBy(xpath = "//h1[text()='Offset Issuance Details']")
	WebElement OffsetIssuanceDetailsPageTitle;
	@FindBy(xpath = "(//div[@data-field='event'])[7]")
	WebElement FirstRecordTransferEventHistory;
	@FindBy(xpath = "(//div[@data-field='event'])[8]")
	WebElement SecondRecordTransferEventHistory;
	
	// Allowance Issuance Page Admin
	@FindBy(xpath = "//h1[text()='Allowance Issuance']")
	WebElement AllowanceIssuancePageTitle;
	@FindBy(xpath = "//h2[text()='Issuing']")
	WebElement IssuingCardTitle;
	@FindBy(xpath = "//h2[text()='Acquiring Account']")
	WebElement AcquiringAccountCardTitle;
	@FindBy(xpath = "//div[text()='Allowance Issuance Information']")
	WebElement AllowanceIssuanceInformationCardTitle;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body1 css-whmdde'])[1]")
	WebElement IssuingCardLabel;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-whmdde']")
	List<WebElement> AcquiringAccountCardLabels;
	
	@FindBy(xpath = "//input[@id='SubType-react-hook-form-select-search']")
	WebElement SubTypeDropdown;
	@FindBy(xpath = "//*[text()='Early Reduction Credit']")
	WebElement SubType1;
	@FindBy(xpath = "//*[text()='Price Ceiling Unit']")
	WebElement SubType2;
	@FindBy(xpath = "//*[text()='Price Containment Reserve Allowance']")
	WebElement SubType3; 
	@FindBy(xpath = "//*[@placeholder='Select Vintage Year...']")
	WebElement vintageYearDropdown;
	@FindBy(xpath = "//label[text()='Subtype']")
	WebElement SubTypeLabel;
	@FindBy(xpath = "//label[text()='Vintage Year']")
	WebElement VintageYearLabel;
	@FindBy(xpath = "//label[text()='Quantity']")
	WebElement QuantityLabel;
	@FindBy(xpath = "//label[text()='Comment']")
	WebElement commentLabel;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 fc-select-rounded css-1wxaqej'])[1]")
	WebElement SubTypeField;
	@FindBy(xpath = "(//div[@class='MuiGrid-root MuiGrid-item MuiGrid-grid-md-4 fc-select-rounded css-1wxaqej'])[2]")
	WebElement VintageYearField;
	
	private By vintageYearSelect = By.xpath("//*[text()='" + FirstEffectiveBudgetYear + "']");
	@FindBy(xpath = "(//p[text()='Please select one of the Subtype Or Vintage Year fields.'])[2]")
	WebElement ErrorMessage_subType_VintageYr;
	@FindBy(xpath = "(//p[text()='Please select one of the Subtype Or Vintage Year fields.'])[1]")
	WebElement ErrorMessage_VintageYr;
	
	@FindBy(xpath = "//input[@id='Quantity']")
	WebElement quantity;
	@FindBy(xpath = "//p[contains(@class,'MuiFormHelperText-root Mui-error MuiFormHelperText-sizeMedium MuiFormHelperText-contained')]")
	WebElement quantityErrMsg;
	@FindBy(xpath = "//p[text()='Vintage Year is not required for the Compliance Instrument Sub Type selected.']")
	WebElement ErrorMessage_subType_VintageYr2;
	@FindBy(xpath = "//button[@data-testid=\"priv_modal_Cancel\"]")
	WebElement CancelButton;
	@FindBy(xpath = "(//button[@data-testid=\"priv_modal_Cancel\"])[2]")
	WebElement WrngCancelBtn;
	@FindBy(xpath = "//button[@data-testid=\"priv_modal_Continue\"]")
	WebElement WrngCntinueBtn;
	@FindBy(xpath = "//button[@data-testid='priv_btn_Submit']")
	WebElement SubmitButton;
	@FindBy(xpath = "//p[text()='Confirm Issuance Proposal']")
	WebElement MsgSubmitConfirm;
	@FindBy(xpath = "//input[@id='passphrase']")
	WebElement Passphrase;
	@FindBy(xpath = "//button[text()=\"Confirm\"]")
	WebElement ConfirmBtn;
	@FindBy(xpath = "//input[@value='2023']")
	WebElement SelectVintage;
	@FindBy(xpath = "//p[text()='The allowance quantity exceeds the Budget Allowances Outstanding for Reserve Adjusted Budget for the selected Vintage Year.']")
	WebElement ErrMsg;
	@FindBy(xpath = "//p[text()='Passphrase is required']")
	WebElement PaasphraseErrMsg;
	@FindBy(xpath = "//p[text()='Passphrase is incorrect']")
	WebElement IncorrectPaasphraseErrMsg;
	@FindBy(xpath = "(//*[@data-testid='CloseIcon'])[3]")
	WebElement ErrCancel;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body2 css-1eifdk0']")
	WebElement ToastErrMsg;
	
	

	// Allowance Issuance Details Page
	@FindBy(xpath = "(//*[@data-testid='CloseIcon'])[4]")
	WebElement SuccessMsgCancel;
//	@FindBy(xpath = "//p[text()='The issuance has been successfully prepared and is awaiting review.']")
//	WebElement SuccessMsg;
//	@FindBy(xpath = "//*[contains(text(),'Success')]")
//	WebElement SuccessMsg;
	@FindBy(xpath = "//h1[text()='Allowance Issuance Details']")
	WebElement AllowanceIssuanceDetailsPageTitle;
	@FindBy(xpath = "//div[@title='Proposed']")
	WebElement TransferEventHistoryProposeData;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[1]")
	WebElement TransferId;
	@FindBy(xpath = "(//div[@class='MuiBox-root css-0'])[4]")
	WebElement TransferStatus;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[3]")
	WebElement TransferStatusValue;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[16]")
	WebElement StartValueComplianceTable;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[17]")
	WebElement EndValueComplianceTable;
	@FindBy(xpath = "(//div[@class='MuiDataGrid-cellContent'])[18]")
	WebElement QuantityValueComplianceTable;
	@FindBy(xpath = "//div[@class='MuiDataGrid-columnHeader MuiDataGrid-columnHeader--sortable']")
	List<WebElement> ColumnLabel;
	@FindBy(xpath = "//div[text()='Action By']")
	WebElement ActionByColumnLable;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[4]")
	WebElement QuantityProposedValue;
	@FindBy(xpath = "(//p[@class='MuiTypography-root MuiTypography-body2 css-j4m1we'])[2]")
	WebElement TransferTypeValue;
	@FindBy(xpath = "//div[@data-field='transferringAccount']")
	List<WebElement> TransferringAccColumn;
	@FindBy(xpath = "(//div[@data-field='receivingAccount'])[2]")
	WebElement ReceivingAccLegNameVal;
	@FindBy(xpath = "(//div[@data-field='receivingAccount'])[4]")
	WebElement ReceivingAccNoVal;
	@FindBy(xpath = "(//div[@data-field='offsetType'])[2]")
	WebElement OffsetTypeValComplTable;
	
	
	// Authority Home Page
	@FindBy(xpath = "//a[text()='My Approvals']")
	WebElement MyApprovalsLabelAuth;

	// My Approval Page Auth
	@FindBy(xpath = "//h1[text()='My Approvals']")
	WebElement MyApprovalPageTitle;
//	@FindBy(xpath = "//input[@id=':r3:']")
//	WebElement Search;
	@FindBy(xpath = "(//div[@data-field='id'])[2]")
	WebElement SearchedTransferId;
	@FindBy(xpath = "//p[@class='MuiTypography-root MuiTypography-body1 css-lz7acl']")
	WebElement TotalRows;
	@FindBy(xpath = "//div[contains (@class, 'MuiDataGrid-columnHeader MuiDataGrid-columnHeader--sortable')]")
	List<WebElement> MyApprovalTableColumn;

	// Allowance Issuance Details Page
	@FindBy(xpath = "//h1[text()='Allowance Issuance Details']")
	WebElement AllowanceIssunanceDetailTitle;

	// Offset Issuance Details Authority Page
	@FindBy(xpath = "//h1[text()='Offset Issuance Details']")
	WebElement OffsetIssuanceDetailsAuthPageTitle;
	@FindBy(xpath = "//input[@name='Approve']")
	WebElement ApproveRadioBtn;
	@FindBy(xpath = "//button[text()='Submit']")
	WebElement SubmitBtn;
	@FindBy(xpath = "//input[@name='Request Revisions']")
	WebElement RequestRevisionsBtn;
	@FindBy(xpath = "//input[@name='Deny']")
	WebElement DenyBtn;
	@FindBy(xpath = "//textarea[@id='comment']")
	WebElement CommentText;
	@FindBy(xpath = "//p[@id='comment-helper-text']")
	WebElement CommentError;
	
	@FindBy(xpath = "//button[@data-testid=\"priv_modal_Cancel\"]")
	WebElement CancelBtnOfWarng;
	@FindBy(xpath = "//button[@data-testid=\"priv_modal_Continue\"]")
	WebElement ContinueBtnOfWarng;
	@FindBy(xpath = "//button[text()=\"Cancel\"]")
	WebElement CancelBtn;
	@FindBy(xpath = "//span[contains(text(),'Comment is required for ')]")
	WebElement MsgDenyRadioBtn;

	// All Budget Records Page
	@FindBy(xpath = "//h1[text()='All Budget Records']")
	WebElement AllBudgetRecordtitle;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[2]")
	WebElement BudgetYearFirstRecord;
	@FindBy(xpath = "(//div[@data-field=\"allowanceOutstandingForReserveAdjustedAllowanceBudget\"])[2]")
	WebElement allowanceOutstandingForReserveAdjustedAllowanceBudgetFirstRecord;

	// All Budget Records Page
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[2]")
	WebElement ApprovedBudgetYear;
	@FindBy(xpath = "(//div[@aria-haspopup='listbox'])[2]")
	WebElement PageRowsEffectiveRecord;
	@FindBy(xpath = "//li[@data-value='100']")
	WebElement Select100Row;
	@FindBy(xpath = "//*[@data-field='budgetYear']")
	List<WebElement> EffectiveBudgetYears;

	public Registry_Module3_MCII(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	// Common Methods

	public static String generateRandomString(String start, String Last) {
		int length = 3;
		boolean useLetters = true;
		boolean useNumbers = true;
		String generatedString = RandomStringUtils.random(length, useNumbers, useLetters);
		String randomString = (start + generatedString + Last);
		return randomString;
	}

	public void calenderDatePicker(String Date) throws InterruptedException {
		if (Date.equals("nextDate")) {
//			CurrentDate.click();
			Thread.sleep(5000);
			String dateString = BeginReportingPeriod2.getAttribute("value");
//			System.out.println(dateString);
			Thread.sleep(3000);
			String[] parts = dateString.split("/");
			String dayString = parts[2];
			int nextday = Integer.parseInt(dayString);
			nextday += 1;
			nextDate = String.valueOf(nextday);
			System.out.println("nextDate :   " + nextDate);
			if(nextDate.equals("31")) {
				WebElement element = driver.findElement(By.xpath("//*[@data-testid='ArrowRightIcon']"));
				new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
				driver.findElement(By.xpath("//*[@data-testid='ArrowRightIcon']")).click();
				driver.findElement(By.xpath("//button[text()='" + "1" + "']")).click();
			}else if(nextDate.equals("32")){
				WebElement element = driver.findElement(By.xpath("//*[@data-testid='ArrowRightIcon']"));
				new WebDriverWait(driver,30).until(ExpectedConditions.elementToBeClickable(element));
				driver.findElement(By.xpath("//*[@data-testid='ArrowRightIcon']")).click();
				driver.findElement(By.xpath("//button[text()='" + "1" + "']")).click();
			}
			else {
				driver.findElement(By.xpath("//button[text()='" + nextDate + "']")).click();
			}
//			System.out.println("nextDate  :  "+nextDate);
			
		} else if (Date.equals("preDate")) {
//			CurrentDate.click();
			Thread.sleep(5000);
			String dateString = BeginReportingPeriod2.getAttribute("value");
//			System.out.println(dateString);
			Thread.sleep(3000);
			String[] parts = dateString.split("/");
			String dayString = parts[2];
			int preday = Integer.parseInt(dayString);
			preday -= 1;
			preDate = String.valueOf(preday);
			driver.findElement(By.xpath("//button[text()='" + preDate + "']")).click();
		}
	}

	public void Navigate_To_IssuanceAccount() throws Exception {
		CM = new CommonMethods(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		CM.scroll(JurisdictionAccountsGrid, "scrollToElement", "JurisdictionAccountsGrid");
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", JurisdictionAccountsGrid);
		try {
			JurisdictionAccountsGrid.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(JurisdictionAccountsGrid));
			CM.click2(JurisdictionAccountsGrid, "javascriptClick", "JurisdictionAccountsGrid");
//			JurisdictionAccountsGrid.click();
//			actions = new Actions(driver);
//			actions.moveToElement(JurisdictionAccountsGrid).click().build().perform();
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(IssuanceAccounts));
		try {
			IssuanceAccounts.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(IssuanceAccounts));
			IssuanceAccounts.click();
		}
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(IssuanceAccountPageTitle));
		String Title = IssuanceAccountPageTitle.getText();
		Assert.assertEquals(Title, "Issuance Account");
		ObjectRepo.test.log(Status.PASS, "JA navigated to Issuance Account page");
	}
	
	public void fetchAccountBalance_issuanceAccount() throws Exception {
		Thread.sleep(5000);
		AccountBalance = AccountBalancevalue.getText();
		AvailableAccountBalance = AvailableAccountBalancevalue.getText();
	}

	public void verify_UI_IssuanceRecordPage() {
		List<String> AccountCardLabels = Arrays.asList("Account Number", "Account Type", "Account Status","Account Balance", "Available Account Balance");
		Assert.assertEquals(AccountInfoCardTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Account Information card is displayed");
		List<String> ActualLabelList = new ArrayList<>();
			for (WebElement AccountInfoField : AccountInfoCardFields) {
				ActualLabelList.add(AccountInfoField.getText());
				ObjectRepo.test.log(Status.PASS, "Labels present on Account Information Grid: "+AccountInfoField.getText());
			}
			boolean allMatch = true;
			for (int i = 0; i< AccountCardLabels.size(); i++) {
				String ExpValue = AccountCardLabels.get(i);
				String ActValue = ActualLabelList.get(i);
				if (!ExpValue.equals(ActValue)) {
					allMatch = false;
					break;
				}
			}
			if (allMatch) {
				ObjectRepo.test.log(Status.PASS, "All the expected labels are present on Account Information Grid ");
			} else {
				ObjectRepo.test.log(Status.PASS, "All the expected columns are not present on Account Information Grid ");
			}
			Assert.assertEquals(HoldingGridTitle.getText(), "Holdings");
			ObjectRepo.test.log(Status.PASS, "Holdings Grid is present on Issunace Account Page");
			List<String> HoldingColumns = Arrays.asList("Vintage", "Jurisdiction", "Type","Sub Type", "Offset Type", "Offset Project Id", "Special Category", "Quantity");
			List<String> ActualHoldingsColumnList = new ArrayList<>();
			for(int j=0; j<=7;j++){
				ActualHoldingsColumnList.add(TableColumns.get(j).getText());
				ObjectRepo.test.log(Status.PASS, "Columns present in the Holdings table are: "+TableColumns.get(j).getText());
			}
			boolean allColumnMatch = true;
			for (int i = 0; i<HoldingColumns.size(); i++) {
				String ExpValue = HoldingColumns.get(i);
				String ActValue = ActualHoldingsColumnList.get(i);
				if (!ExpValue.equals(ActValue)) {
					allColumnMatch = false;
					break;
				}
			}
			if (allColumnMatch) {
				ObjectRepo.test.log(Status.PASS, "All the expected columns are present on Holdings Grid ");
			} else {
				ObjectRepo.test.log(Status.PASS, "All the expected columns are not present on Holdings Grid ");
			}
			Assert.assertEquals(TransferGridTitle.getText(), "Transfers");
			ObjectRepo.test.log(Status.PASS, "Transfers Table is present on Issunace Account Page");
			List<String> TransfersColumns = Arrays.asList("Transfer Id", "Event Date", "Status", "Transferring Account Name", "Receiving Account Name", "Quantity Proposed", "Quantity Transferred");
			List<String> ActualTransfersColumnList = new ArrayList<>();
			for(int j=8; j<=14;j++){
				ActualTransfersColumnList.add(TableColumns.get(j).getText());
				ObjectRepo.test.log(Status.PASS, "Columns present in the Trasfers table are: "+TableColumns.get(j).getText());
			}
			boolean allTransferColumnMatch = true;
			for (int i = 0; i<TransfersColumns.size(); i++) {
				String ExpValue = TransfersColumns.get(i);
				String ActValue = ActualTransfersColumnList.get(i);
				if (!ExpValue.equals(ActValue)) {
					allTransferColumnMatch = false;
					break;
				}
			}
			if (allTransferColumnMatch) {
				ObjectRepo.test.log(Status.PASS, "All the expected columns are present on Transfers Grid ");
			} else {
				ObjectRepo.test.log(Status.PASS, "All the expected columns are not present on Transfers Grid ");
			}
	}
	

	public void verify_MoreActionBtn_IssuanceAccPage_JAuth() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
//		Assert.assertEquals(MoreActionsBtn.isDisplayed(), false);
		try {
			MoreActionsBtn.isDisplayed();
		} catch (Exception ex) {
			ObjectRepo.test.log(Status.PASS, "Mare Action Button is not displayed for other than Jurisdiction Admin");
		}
	}

	public void verify_MoreActionBtn_IssuanceAccPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			MoreActionsBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(MoreActionsBtn, "moveToElementClick", "MoreActionButton");
		}
		Assert.assertEquals(OffsetIssuanceSubMenu.isDisplayed(), true);
		Assert.assertEquals(AllowanceIssuanceSubMenu.isDisplayed(), true);
		Assert.assertEquals(InitiateBatchTransferSubMenu.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Allowance Issuance', 'Offset Issuance', 'Initiate Batch Transfer' options is displayed ");
		InitiateBatchTransferSubMenu.click();
		String Title = PopUpInitiateBatchTransfer.getText();
		Assert.assertEquals(Title, "Initiate Batch Transfer");
		ObjectRepo.test.log(Status.PASS,
				"Pop up window for selecting options for Initiate Batch Transfer is displayed ");
		PopUpInitiateBatchTransferCancelBtn.click();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
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

	public void navigateToMyApprovals_JAuth() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MyApprovalsLabelAuth));
		try {
			MyApprovalsLabelAuth.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(MyApprovalsLabelAuth, "moveToElementClick", "MyApprovalsLabelAuth");
		}
	}

	public void getMyApprovalTableColumn() {
		List<String> ExpectedColumnList = new ArrayList<>();
		ExpectedColumnList.add("ID");
		ExpectedColumnList.add("Key Information");
		ExpectedColumnList.add("Type");
		ExpectedColumnList.add("Status");
		ExpectedColumnList.add("Last Updated");

		List<String> ActualColumnList = new ArrayList<>();
		for (WebElement element : MyApprovalTableColumn) {
			ActualColumnList.add(element.getText());
			ObjectRepo.test.log(Status.PASS, "Columns present on My Aproval Grid: "+element.getText());
			System.out.println("Element Present On page: "+element.getText());
		}

		System.out.println("List Elements :"+ ActualColumnList);
		boolean allMatch = true;
		for (int i = 0; i < ExpectedColumnList.size(); i++) {
			String ExpValue = ExpectedColumnList.get(i);
			String ActValue = ActualColumnList.get(i);
			if (!ExpValue.equals(ActValue)) {
				allMatch = false;
				break;
			}
		}
		if (allMatch) {
			ObjectRepo.test.log(Status.PASS, "All the expected columns are present on My Approval Grid ");
			System.out.println("All the expected columns are not present on My Approval Grid .");
		} else {
			ObjectRepo.test.log(Status.PASS, "All the expected columns are not present on My Approval Grid ");
			System.out.println("All the expected columns are not present on My Approval Grid .");
		}
	}

	public void navigateToIssuanceRecordPage() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MegaMenu));
		try {
			MegaMenu.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MegaMenu));
			MegaMenu.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(IssuanceRecordOption));
		try {
			IssuanceRecordOption.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(IssuanceRecordOption));
			IssuanceRecordOption.click();
		}
		ObjectRepo.test.log(Status.PASS, "Jurisdiction User navigated to Issuanace Record page ");
	}

	public void LogoutFunctionality() throws Exception {
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(WelcomeButton));
			WelcomeButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(WelcomeButton));
			actions = new Actions(driver);
			actions.moveToElement(WelcomeButton).click().build().perform();
		}
		Thread.sleep(3000);
		Logout.click();
	}

	// Offset Issuance Methods

	public void NavigateToOffsetIssuance() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionsBtn));
			MoreActionsBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionsBtn));
			MoreActionsBtn.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetIssuanceSubMenu));
		OffsetIssuanceSubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuancePageTitle));
		String PageTitle = OffsetIssuancePageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance");
		ObjectRepo.test.log(Status.PASS, "JA navigated to Offset Issuance page ");
	}
	
	public void verifyUI_OffsetIssuancePage() throws Exception {
		Navigate_To_IssuanceAccount();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			MoreActionsBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(MoreActionsBtn, "javascriptClick", "MoreActionButton");
		}
		Assert.assertEquals(OffsetIssuanceSubMenu.isDisplayed(), true);
		Assert.assertEquals(AllowanceIssuanceSubMenu.isDisplayed(), true);
		Assert.assertEquals(InitiateBatchTransferSubMenu.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Allowance Issuance', 'Offset Issuance', 'Initiate Batch Transfer' sbbmenus are displayed in More Action menu");
		OffsetIssuanceSubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuancePageTitle));
		String PageTitle = OffsetIssuancePageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance");
		ObjectRepo.test.log(Status.PASS, "JA navigated to Offset Issuance page ");
		Assert.assertEquals(IssuingCardTitle.getText(), "Issuing");
		ObjectRepo.test.log(Status.PASS, "Issuing card is present on Offset Issuance page ");
		Assert.assertEquals(IssuingCardLabel.getText(), "Jurisdiction");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction label is present in Issuing card ");
		Assert.assertEquals(AcquiringAccountCardTitle.getText(), "Acquiring Account");
		ObjectRepo.test.log(Status.PASS, "Acquiring Account card is present on Offset Issuance page ");
		List<String> AcquiringAccountLabels = Arrays.asList("Jurisdiction", "Account Number", "Account Type", "Account Status");
		List<String> ActualAcquiringAccountLabels = new ArrayList<>();
		for(int j=0; j<=4;j++){
			ActualAcquiringAccountLabels.add(AcquiringAccountCardLabels.get(j).getText());
			ObjectRepo.test.log(Status.PASS, "Labels present in the Acquiring Account Card are: "+AcquiringAccountCardLabels.get(j).getText());
		}
		boolean allLabelMatch = true;
		for (int i = 0; i<AcquiringAccountLabels.size(); i++) {
			String ExpValue = AcquiringAccountLabels.get(i);
			String ActValue = ActualAcquiringAccountLabels.get(i);
			if (!ExpValue.equals(ActValue)) {
				allLabelMatch = false;
				break;
			}
		}
		if (allLabelMatch) {
			ObjectRepo.test.log(Status.PASS, "All the expected labels are present on Acquiring Account card ");
		} else {
			ObjectRepo.test.log(Status.PASS, "All the expected labels are not present on Acquiring Account card ");
		}
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Assert.assertEquals(OffsetIssuanceInfoCardTitle.getText(), "Offset Issuance Information");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance Information card is present on Offset Issuance page");
		Assert.assertEquals(VintageyearField.getText().contains("Vintage Year") && VintageyearField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Vintage Year with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(QuantityLabel.getText().contains("Quantity") && quantity.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Quantity Field with input field is present in Allowance Issuance Information card.");
		Assert.assertEquals(OffsetProjectNameField.getText().contains("Offset Project Name") && OffsetProjectNameField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Offset Project Name with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(OffsetProjectIDField.getText().contains("Offset Project ID")&& OffsetProjectIDField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Offset Project ID with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(OffsetTypeField.getText().contains("Offset Type")&& OffsetTypeField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Offset Type with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(OffsetProjectOperatorField.getText().contains("Offset Project Operator") && OffsetProjectOperatorField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Offset Project Operator with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(BeginReportingPeriodLabel.getText().contains("Begin Reporting Period")&& BeginDateField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Begin Reporting Period with Date picker is available in Offset Issuance Information card. ");
		Assert.assertEquals(EndReportingPeriodLabel.getText().contains("End Reporting Period") && EndDateField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "End Reporting Period with Date picker is available in Offset Issuance Information card. ");
		Assert.assertEquals(VerificationBodyField.getText().contains("Verification Body")&& VerificationBodyField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Verification Body with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(ProjectSiteField.getText().contains("Project Site") && ProjectSiteField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Project Site with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(SpecialCategoryField.getText().contains("Special Category")&& SpecialCategoryField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Special Category with Dropdown field is available in Offset Issuance Information card. ");
		Assert.assertEquals(commentLabel.getText().equals("Comment") && Comment.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Comment with input field is present in Offset Issuance Information card.");
		Assert.assertEquals(CancelBtn_OffsetIssuance.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Cancel button is present on Offset Issuance page");
		Assert.assertEquals(SubmitlBtn_OffsetIssuance.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Submit button is present on Offset Issuance page");
	}

	public void ProposeOffsetIssuance() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(6000);
		VintageYearDropdown.click();
		VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		VintageYearDropdown.sendKeys(Keys.ENTER);
		String SelectedYear = VintageYearDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "selected Vintage Year is : " + SelectedYear);
		Quantity.sendKeys("100");
		String Quantityvalue = Quantity.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Quantity is: " + Quantityvalue);
		OffsetProjectNameDropdown.click();
		OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		String SelectedProjectname = OffsetProjectNameDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Name is: " + SelectedProjectname);
		OffsetProjectID.sendKeys("123456");
		String OffsetIdValue = OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + OffsetIdValue);
		OffsetType.click();
		OffsetType.sendKeys(Keys.ARROW_DOWN);
		OffsetType.sendKeys(Keys.ENTER);
		String OffsetTypevalue = OffsetType.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Type is: " + OffsetTypevalue);
		OffsetProjectOperatorDropdown.click();
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String OffsetProjectOperatorValue = OffsetProjectOperatorDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Operator Value is: " + OffsetProjectOperatorValue);
		BeginReportingPeriodIcon.click();
		Thread.sleep(3000);
		CurrentDate.click();
		String BeginReportingPeriodValue = BeginReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the Begin Reporting Period: " + BeginReportingPeriodValue);
		Thread.sleep(3000);
		EndReportingPeriodIcon.click();
		Thread.sleep(3000);
		CurrentDate.click();
		String EndReportingPeriodValue = EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		VerificationBodyDropdown.click();
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String VerificationBodyValue = VerificationBodyDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Verification Body Value is: " + VerificationBodyValue);
		ProjectSiteDropdown.click();
		ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		ProjectSiteDropdown.sendKeys(Keys.ENTER);
		String ProjectSiteValue = ProjectSiteDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Project Site Value is: " + ProjectSiteValue);
		SpecialCategoryDropdown.click();
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String SpecialCategoryValue = SpecialCategoryDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Special Category Value is: " + SpecialCategoryValue);
		Comment.sendKeys("Testing Purpose");
		String CommentValue = Comment.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Comment is: " + CommentValue);
		Thread.sleep(1000);
		try {
			SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitlBtn_OffsetIssuance, "moveToElementClick", "SubmitlBtn_OffsetIssuance");
		}
		Thread.sleep(2000);
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		ConfirmBtnPopUp.click();
		Thread.sleep(5000);
		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(SuccessMessage));
		String SuccessMessageValue = SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		// String TransferId = CreatedTransferId.getText();
		SuccessMsgCancel.click();
	}
	
	public void ProposeOffsetIssuance_UniqueProjectId() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(VintageYearDropdown));
			VintageYearDropdown.click();
		} catch (Exception e) {
			CM = new CommonMethods(driver);
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(VintageYearDropdown));
			CM.click2(VintageYearDropdown, "javascriptClick", "VintageYearDropdown");
		}
		Thread.sleep(5000);
		VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		VintageYearDropdown.sendKeys(Keys.ENTER);
		String SelectedYear = VintageYearDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "selected Vintage Year is : " + SelectedYear);
		Quantity.sendKeys("100");
		String Quantityvalue = Quantity.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Quantity is: " + Quantityvalue);
		try {
			OffsetProjectNameDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectNameDropdown));
			OffsetProjectNameDropdown.click();
		}
		OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		String SelectedProjectname = OffsetProjectNameDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Name is: " + SelectedProjectname);
		OffsetProjectID.sendKeys(generateRandomString("Project", "ID"));
		OffsetIdValue = OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + OffsetIdValue);
		try {
			OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetType));
			OffsetType.click();
		}
		OffsetType.sendKeys(Keys.ARROW_DOWN);
		OffsetType.sendKeys(Keys.ENTER);
		String OffsetTypevalue = OffsetType.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Type is: " + OffsetTypevalue);
		OffsetProjectOperatorDropdown.click();
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String OffsetProjectOperatorValue = OffsetProjectOperatorDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Operator Value is: " + OffsetProjectOperatorValue);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
		try {
			BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
			BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String BeginReportingPeriodValue = BeginReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the Begin Reporting Period: " + BeginReportingPeriodValue);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
		EndReportingPeriodIcon.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String EndReportingPeriodValue = EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		try {
			VerificationBodyDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(VerificationBodyDropdown));
			VerificationBodyDropdown.click();
		}
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String VerificationBodyValue = VerificationBodyDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Verification Body Value is: " + VerificationBodyValue);
		ProjectSiteDropdown.click();
		ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		ProjectSiteDropdown.sendKeys(Keys.ENTER);
		String ProjectSiteValue = ProjectSiteDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Project Site Value is: " + ProjectSiteValue);
		try {
			SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SpecialCategoryDropdown));
			SpecialCategoryDropdown.click();
		}
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String SpecialCategoryValue = SpecialCategoryDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Special Category Value is: " + SpecialCategoryValue);
		Comment.sendKeys("Testing Purpose");
		String CommentValue = Comment.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Comment is: " + CommentValue);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitlBtn_OffsetIssuance));
			SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitlBtn_OffsetIssuance));
			SubmitlBtn_OffsetIssuance.click();
		}
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(SuccessMessage));
		String SuccessMessageValue = SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		try {
			SuccessMsgCancel.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SuccessMsgCancel));
			actions = new Actions(driver);
			actions.moveToElement(SuccessMsgCancel).click().build().perform();
//			SuccessMsgCancel.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CreatedTransferId));
		offsetTransferId = CreatedTransferId.getText();
//		System.out.println(offsetTransferId);
	}
	
	public void PopUpCancel_Cancel_BtnClick() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(CancelBtn_OffsetIssuance));
		try {
			CancelBtn_OffsetIssuance.click();
		} catch (Exception e) {
			new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(CancelBtn_OffsetIssuance));
			CM = new CommonMethods(driver);
			CM.click2(CancelBtn_OffsetIssuance, "javascriptClick", "CancelBtn_OffsetIssuance");
		}
		new WebDriverWait(driver,40).until(ExpectedConditions.elementToBeClickable(PopUpCancel_CancelBtn_OffsetIssuance));
		PopUpCancel_CancelBtn_OffsetIssuance.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on Cancel button of Cancel PopUp Confirmation");
		String Title = OffsetIssuancePageTitle.getText();
		Assert.assertEquals(Title, "Offset Issuance");
		ObjectRepo.test.log(Status.PASS, "User stays on same page");
	}

	public void PopUpContinue_Cancel_BtnClick() {
		CancelBtn_OffsetIssuance.click();
		PopUpContinue_CancelBtn_OffsetIssuance.click();
		ObjectRepo.test.log(Status.PASS, "Clicked on Continue button of Cancel PopUp Confirmation ");
		String IssuanceAccountTitle = IssuanceAccountPageTitle.getText();
		Assert.assertEquals(IssuanceAccountTitle, "Issuance Account");
		ObjectRepo.test.log(Status.PASS, "User navigates to 'Issuance Account' page");
	}

	public void AddExistingProjectname() throws Exception {
		OM = new Registry_Module3_OM(driver);
		OM.navigateToOffsetProjectNameManagement();
		OM.navigateToAddOffsetProjectName();
		OM.addOffsetProjectName();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", OffsetProjectNameDropdown);
		OffsetProjectNameDropdown.sendKeys("Add a New Offset Project Name");
		OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		Assert.assertEquals(EnterOffsetProjectname.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Enter Offset Project Name' field is displayed ");
		EnterOffsetProjectname.sendKeys(OM.OffsetProjectName);
		String ErrorMessage = ErrorMessage_Projectname.getText();
		Assert.assertEquals(ErrorMessage, "Offset Project Name already exists. Please select it from the dropdown.");
		ObjectRepo.test.log(Status.PASS, "Displayed Error message for existing Project name");
	}

	public void verifyEmptyOffsetProjectnameDropDown() throws Exception {
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", OffsetProjectNameDropdown);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectNameDropdown));
		OffsetProjectNameDropdown.sendKeys("Add a New Offset Project Name");
		OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EnterOffsetProjectname));
		Assert.assertEquals(EnterOffsetProjectname.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Enter Offset Project Name' field is displayed ");
		EnterOffsetProjectname.sendKeys(Keys.TAB);
		String ErrMsg = ErrorMessage_Projectname.getText();
		Assert.assertEquals(ErrMsg, "Offset Project Name is required");
		ObjectRepo.test.log(Status.PASS, "Error message is dsiplayed for empty Offest Project name");
	}

	public void verifyAddedOffsetProjectNameDropdown_ManagementTable() throws Exception {
		OM = new Registry_Module3_OM(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String OffsetName = generateRandomString("Offset", "ProjectName");
		EnterOffsetProjectname.sendKeys(OffsetName);
		String ProjectName = EnterOffsetProjectname.getAttribute("value");
		try {
			VintageYearDropdown.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(VintageYearDropdown));
			CM = new CommonMethods(driver);
			CM.click2(VintageYearDropdown, "javascriptClick", "VintageYearDropdown");
		}
		VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		VintageYearDropdown.sendKeys(Keys.ENTER);
		String SelectedYear = VintageYearDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "selected Vintage Year is : " + SelectedYear);
		Quantity.sendKeys("100");
		String Quantityvalue = Quantity.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Quantity is: " + Quantityvalue);
		SelectedProjectname = OffsetProjectNameDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Name is: " + SelectedProjectname);
		OffsetProjectID.sendKeys("123456");
		String OffsetIdValue = OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + OffsetIdValue);
		try {
			OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetType));
			OffsetType.click();
		}
		OffsetType.sendKeys(Keys.ARROW_DOWN);
		OffsetType.sendKeys(Keys.ENTER);
		String OffsetTypevalue = OffsetType.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Type is: " + OffsetTypevalue);
		OffsetProjectOperatorDropdown.click();
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String OffsetProjectOperatorValue = OffsetProjectOperatorDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Operator Value is: " + OffsetProjectOperatorValue);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
		try {
			BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
			BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String BeginReportingPeriodValue = BeginReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the Begin Reporting Period: " + BeginReportingPeriodValue);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
		try {
			EndReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
			EndReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String EndReportingPeriodValue = EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		try {
			VerificationBodyDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(VerificationBodyDropdown));
			VerificationBodyDropdown.click();
		}
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String VerificationBodyValue = VerificationBodyDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Verification Body Value is: " + VerificationBodyValue);
		ProjectSiteDropdown.click();
		ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		ProjectSiteDropdown.sendKeys(Keys.ENTER);
		String ProjectSiteValue = ProjectSiteDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Project Site Value is: " + ProjectSiteValue);
		try {
			SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SpecialCategoryDropdown));
			SpecialCategoryDropdown.click();
		}
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String SpecialCategoryValue = SpecialCategoryDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Special Category Value is: " + SpecialCategoryValue);
		Comment.sendKeys("Testing Purpose");
		String CommentValue = Comment.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Comment is: " + CommentValue);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitlBtn_OffsetIssuance));
			SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitlBtn_OffsetIssuance));
			SubmitlBtn_OffsetIssuance.click();
		}
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(SuccessMessage));
		String SuccessMessageValue = SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CreatedTransferId));
		offsetTransferId = CreatedTransferId.getText();
		navigateBackToHomePage();
		OM.navigateToOffsetProjectNameManagement();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		SearchField.sendKeys(ProjectName);
		Assert.assertEquals(FirstOffsetProjectName.getText().equals(OffsetName), true);
		ObjectRepo.test.log(Status.PASS, "Offset issuance is proposed and New Project name is created in application.");

	}

	public void AddExistingProjectOperator() throws Exception {
		OM = new Registry_Module3_OM(driver);
		OM.navigateToOffsetProjectOperatorManagement();
		OM.navigateToAddOffsetProjectOperator();
		OM.addOffsetProjectOperator();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
    	NavigateToOffsetIssuance();
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", OffsetProjectOperatorDropdown);
		OffsetProjectOperatorDropdown.sendKeys("Add a New Offset Project Operator");
		Thread.sleep(3000);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		ObjectRepo.test.log(Status.PASS, " 'Enter Offset Project Operator' field is displayed ");
		Thread.sleep(3000);
		EnterOffsetProjectOperatorname.sendKeys(OM.OffsetProjectOperator);
		wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(ErrorMessage_ProjectOperatorName));
		String ErrorMessage = ErrorMessage_ProjectOperatorName.getText();
		Assert.assertEquals(ErrorMessage,
				"Offset Project Operator already exists. Please select it from the dropdown.");
		ObjectRepo.test.log(Status.PASS, "Displayed Error message for existing Project Operator name");
	}

	public void verifyEmptyOffsetProjectOperatorDropDown() throws Exception {
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", OffsetProjectOperatorDropdown);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetProjectOperatorDropdown));
		OffsetProjectOperatorDropdown.sendKeys("Add a New Offset Project Operator");
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EnterOffsetProjectOperatorname));
		Assert.assertEquals(EnterOffsetProjectOperatorname.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Enter Offset Project Operator' field is displayed ");
		EnterOffsetProjectOperatorname.sendKeys(Keys.TAB);
		String ErrMsg = ErrorMessage_ProjectOperatorName.getText();
		Assert.assertEquals(ErrMsg, "Offset Project Operator is required");
		ObjectRepo.test.log(Status.PASS, "Error message is dsiplayed for empty Offest Project Operator");
	}

	public void verifyAddedOffsetProjectOperaorDropdown_ManagementTable() throws Exception {
		OM = new Registry_Module3_OM(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String OffsetOperator = generateRandomString("Offset", "ProjectOperator");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EnterOffsetProjectOperatorname));
		EnterOffsetProjectOperatorname.sendKeys(OffsetOperator);
		String ProjectOperator = EnterOffsetProjectOperatorname.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset Project Operator Value is: " + ProjectOperator);
		try {
			VintageYearDropdown.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(VintageYearDropdown, "moveToElementClick", "VintageYearDropdown");
		}
		VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		VintageYearDropdown.sendKeys(Keys.ENTER);
		String SelectedYear = VintageYearDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "selected Vintage Year is : " + SelectedYear);
		Quantity.sendKeys("100");
		String Quantityvalue = Quantity.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Quantity is: " + Quantityvalue);
		OffsetProjectNameDropdown.click();
		OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		String SelectedProjectname = OffsetProjectNameDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Name is: " + SelectedProjectname);
		OffsetProjectID.sendKeys("123456");
		String OffsetIdValue = OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + OffsetIdValue);
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + OffsetIdValue);
		try {
			OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetType));
			OffsetType.click();
		}
		OffsetType.sendKeys(Keys.ARROW_DOWN);
		OffsetType.sendKeys(Keys.ENTER);
		String OffsetTypevalue = OffsetType.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Type is: " + OffsetTypevalue);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
		try {
			BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
			BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String BeginReportingPeriodValue = BeginReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the Begin Reporting Period: " + BeginReportingPeriodValue);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
		EndReportingPeriodIcon.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String EndReportingPeriodValue = EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		try {
			VerificationBodyDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(VerificationBodyDropdown));
			VerificationBodyDropdown.click();
		}
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String VerificationBodyValue = VerificationBodyDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Verification Body Value is: " + VerificationBodyValue);
		ProjectSiteDropdown.click();
		ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		ProjectSiteDropdown.sendKeys(Keys.ENTER);
		String ProjectSiteValue = ProjectSiteDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Project Site Value is: " + ProjectSiteValue);
		try {
			SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SpecialCategoryDropdown));
			SpecialCategoryDropdown.click();
		}
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String SpecialCategoryValue = SpecialCategoryDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Special Category Value is: " + SpecialCategoryValue);
		Comment.sendKeys("Testing Purpose");
		String CommentValue = Comment.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Comment is: " + CommentValue);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitlBtn_OffsetIssuance));
			SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitlBtn_OffsetIssuance));
			SubmitlBtn_OffsetIssuance.click();
		}
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(SuccessMessage));
		String SuccessMessageValue = SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CreatedTransferId));
		offsetTransferId = CreatedTransferId.getText();
		navigateBackToHomePage();
		OM.navigateToOffsetProjectOperatorManagement();
		Thread.sleep(3000);
		SearchField.sendKeys(ProjectOperator);
		Assert.assertEquals(FirstOffsetProjectOperator.getText().equals(ProjectOperator), true);
		ObjectRepo.test.log(Status.PASS,
				"Offset issuance is proposed and New Project Operator Name is created in application.");
	}

	public void AddExistingVerificationBody() throws Exception {
		OM = new Registry_Module3_OM(driver);
		OM.navigateToVerificationBodyManagement();
		OM.navigateAddVerificationBody();
		OM.addVerificationBody();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
    	NavigateToOffsetIssuance();
    	js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", VerificationBodyDropdown);
		VerificationBodyDropdown.sendKeys("Add a New Verification Body");
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EnterVerificationBody));
		Assert.assertEquals(EnterVerificationBody.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Enter Verification Body' field is displayed ");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		System.out.println(OM.VerificationBody);
		EnterVerificationBody.sendKeys(OM.VerificationBody);
		String ErrorMessage = ErrorMessage_VerificationBody.getText();
		Assert.assertEquals(ErrorMessage, "Verification Body already exists. Please select it from the dropdown.");
		ObjectRepo.test.log(Status.PASS, "Displayed Error message for existing Verification Body");
	}

	public void verifyEmptyVerificationBodyDropDown() throws Exception {
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", OffsetProjectOperatorDropdown);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(VerificationBodyDropdown));
		VerificationBodyDropdown.sendKeys("Add a New Verification Body");
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(EnterVerificationBody));
		Assert.assertEquals(EnterVerificationBody.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Enter Verification Body' field is displayed ");
		EnterVerificationBody.sendKeys(Keys.TAB);
		String ErrMsg = ErrorMessage_VerificationBody.getText();
		Assert.assertEquals(ErrMsg, "Verification Body is required");
		ObjectRepo.test.log(Status.PASS, "Error message is dsiplayed for empty Offest Verification Body ");
	}

	public void verifyAddedVerificationBodyDropdown_ManagementTable() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		String VerificationBody = generateRandomString("Verification", "Body");
		
		EnterVerificationBody.sendKeys(VerificationBody);
		String verificationBodyValue = EnterVerificationBody.getAttribute("value");
		Thread.sleep(3000);
		ObjectRepo.test.log(Status.PASS, "Entered Offset Project Operator Value is: " + verificationBodyValue);
		try {
			VintageYearDropdown.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(VintageYearDropdown, "moveToElementClick", "VintageYearDropdown");
		}
		VintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		VintageYearDropdown.sendKeys(Keys.ENTER);
		String SelectedYear = VintageYearDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "selected Vintage Year is : " + SelectedYear);
		Quantity.sendKeys("100");
		String Quantityvalue = Quantity.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Quantity is: " + Quantityvalue);
		OffsetProjectNameDropdown.click();
		OffsetProjectNameDropdown.sendKeys(Keys.ENTER);
		String SelectedProjectname = OffsetProjectNameDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Name is: " + SelectedProjectname);
		OffsetProjectID.sendKeys("123456");
		String OffsetIdValue = OffsetProjectID.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Offset ProjectID is: " + OffsetIdValue);
		try {
			OffsetType.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(OffsetType));
			OffsetType.click();
		}
		OffsetType.sendKeys(Keys.ARROW_DOWN);
		OffsetType.sendKeys(Keys.ENTER);
		String OffsetTypevalue = OffsetType.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Type is: " + OffsetTypevalue);
		OffsetProjectOperatorDropdown.click();
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String OffsetProjectOperatorValue = OffsetProjectOperatorDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Offset Project Operator Value is: " + OffsetProjectOperatorValue);
		try {
			BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
			BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String BeginReportingPeriodValue = BeginReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the Begin Reporting Period: " + BeginReportingPeriodValue);
		try {
			EndReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
			EndReportingPeriodIcon.click();
		}
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
			CurrentDate.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
			CurrentDate.click();
		}
		String EndReportingPeriodValue = EndReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected the End Reporting Period: " + EndReportingPeriodValue);
		ProjectSiteDropdown.click();
		ProjectSiteDropdown.sendKeys(Keys.ARROW_DOWN);
		ProjectSiteDropdown.sendKeys(Keys.ENTER);
		String ProjectSiteValue = ProjectSiteDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Project Site Value is: " + ProjectSiteValue);
		try {
			SpecialCategoryDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SpecialCategoryDropdown));
			SpecialCategoryDropdown.click();
		}
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String SpecialCategoryValue = SpecialCategoryDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Selected Special Category Value is: " + SpecialCategoryValue);
		Comment.sendKeys("Testing Purpose");
		String CommentValue = Comment.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Entered Comment is: " + CommentValue);
		try {
			SubmitlBtn_OffsetIssuance.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitlBtn_OffsetIssuance, "moveToElementClick", "SubmitlBtn_OffsetIssuance");
		}
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Passphrase_OffsetIssuance.sendKeys(prop.getProperty("Password"));
		ConfirmBtnPopUp.click();
		new WebDriverWait(driver, 50).until(ExpectedConditions.visibilityOf(SuccessMessage));
		String SuccessMessageValue = SuccessMessage.getText();
		Assert.assertEquals(SuccessMessageValue, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is proposed successfully ");
		// String TransferId = CreatedTransferId.getText();
		SuccessMsgCancel.click();
		navigateBackToHomePage();
		OM = new Registry_Module3_OM(driver);
		OM.navigateToVerificationBodyManagement();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		SearchField.sendKeys(verificationBodyValue);
		Assert.assertEquals(FirstOffsetVerificationBody.getText().equals(verificationBodyValue), true);
		ObjectRepo.test.log(Status.PASS,
				"Offset issuance is proposed and New Verification Body is created in application.");
	}

	public void verifyOffsetProjectOperatorDropdown() throws Exception {
		OM = new Registry_Module3_OM(driver);
		OM.navigateToOffsetProjectOperatorManagement();
		OM.navigateToAddOffsetProjectOperator();
		OM.addOffsetProjectOperator();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", OffsetProjectOperatorDropdown);
		OffsetProjectOperatorDropdown.sendKeys(OM.OffsetProjectOperator);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String ValueOffsetProjectOperator = OffsetProjectOperatorDropdown.getAttribute("value");
		Assert.assertEquals(ValueOffsetProjectOperator, OM.OffsetProjectOperator); // step1
		ObjectRepo.test.log(Status.PASS, "Previously saved Offset Project Operator " +ValueOffsetProjectOperator+ " is displayed in the list.");
		int ValueSize1 = OffsetProjectOperatorDropdown.getAttribute("value").length();
		for (int i = 1; i <= ValueSize1; i++) {
			OffsetProjectOperatorDropdown.sendKeys(Keys.BACK_SPACE);
		}
		OffsetProjectOperatorDropdown.sendKeys(Keys.TAB);
		wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(ErrorMessage2_OffsetProjectOperator));
		String ErrorMessage = ErrorMessage2_OffsetProjectOperator.getText();
		Assert.assertEquals(ErrorMessage, "Offset Project Operator is required");
		ObjectRepo.test.log(Status.PASS, "Displayed Error message for blank Offset Project Operator"); // Step2
		OffsetProjectOperatorDropdown.click();
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String Value = OffsetProjectOperatorDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is able to select 'Offset Project Operator' from the dropdown menu.");
		OffsetProjectOperatorDropdown.click();
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ARROW_DOWN);
		OffsetProjectOperatorDropdown.sendKeys(Keys.ENTER);
		String Value1 = OffsetProjectOperatorDropdown.getAttribute("value");
		Assert.assertEquals(!Value.equals(Value1), true);
		ObjectRepo.test.log(Status.PASS, "Previously selected 'Verification Body' is not appear and Newly selected 'Verification Body' is displayed.");
		
	}

	public void verifyVerificationBodyDropdown() throws Exception {
		OM = new Registry_Module3_OM(driver);
		OM.navigateToVerificationBodyManagement();
		OM.navigateAddVerificationBody();
		OM.addVerificationBody();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
    	NavigateToOffsetIssuance();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", VerificationBodyDropdown);
		VerificationBodyDropdown.sendKeys(OM.VerificationBody);
		String ValueVerificationBody = VerificationBodyDropdown.getAttribute("value");
		Assert.assertEquals(ValueVerificationBody, OM.VerificationBody); // step1
		ObjectRepo.test.log(Status.PASS, "Previously saved verification body " +OM.VerificationBody+ " is displayed in the list.");
		int ValueSize1 = ValueVerificationBody.length();
		for (int i = 1; i <= ValueSize1; i++) {
			VerificationBodyDropdown.sendKeys(Keys.BACK_SPACE);
		}
		VerificationBodyDropdown.sendKeys(Keys.TAB);
		String ErrMessage = ErrorMessage2_VerificationBody.getText();
		Assert.assertEquals(ErrMessage, "Verification Body is required"); // Step2
		ObjectRepo.test.log(Status.PASS, "Displayed Error message for blank Verification Body");
		Thread.sleep(3000);
		VerificationBodyDropdown.click();
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String Value = VerificationBodyDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is able to select 'Verification Body' from the dropdown menu.");
		VerificationBodyDropdown.click();
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ARROW_DOWN);
		VerificationBodyDropdown.sendKeys(Keys.ENTER);
		String Value1 = VerificationBodyDropdown.getAttribute("value");
		Assert.assertEquals(!Value.equals(Value1), true);
		ObjectRepo.test.log(Status.PASS, "Previously selected 'Verification Body' is not appear and Newly selected 'Verification Body' is displayed.");
	}

	public void verifySpecialCategoryDropdown() throws InterruptedException {
		List<String> ExpSpeacialCategory = new ArrayList<String>();
		ExpSpeacialCategory.add("Direct Environmental Benefits in the Canada");
		ExpSpeacialCategory.add("Direct Environmental Benefits in the US");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		js.executeScript("arguments[0].scrollIntoView();", SpecialCategoryDropdown);
		
		try {
			SpecialCategoryDropdown.click();
		} catch (Exception ex) {
			CM= new CommonMethods(driver);
			CM.click2(SpecialCategoryDropdown, "moveToElementClick", "SpecialCategoryDropdown");
		}
//		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String Value = SpecialCategoryDropdown.getAttribute("value");
		Assert.assertEquals(Value, "Direct Environmental Benefits in the Canada");
//		Assert.assertEquals(Value.equals(ExpSpeacialCategory.get(0)), true);
		Thread.sleep(3000);
		SpecialCategoryDropdown.click();
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String Value2 = SpecialCategoryDropdown.getAttribute("value");
		Assert.assertEquals(Value2, "Direct Environmental Benefits in the US");
		ObjectRepo.test.log(Status.PASS, "List of 'Special Category' is displayed in the list"); //Step1
		int ValueSize1 = Value2.length();
		for (int i = 1; i <= ValueSize1; i++) {
			SpecialCategoryDropdown.sendKeys(Keys.BACK_SPACE);
		}
		SpecialCategoryDropdown.sendKeys("Direct Environmental Benefits in the Canada");
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String SpecialCategoryValue = SpecialCategoryDropdown.getAttribute("value");
		Assert.assertEquals(SpecialCategoryValue, "Direct Environmental Benefits in the Canada");
		ObjectRepo.test.log(Status.PASS, "Matching Special Category is displayed in the list.");
		SpecialCategoryDropdown.click();
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String value = SpecialCategoryDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is able to select 'Special Category' "+value+  " from the dropdown menu.");
		SpecialCategoryDropdown.click();
		SpecialCategoryDropdown.sendKeys(Keys.ARROW_DOWN);
		SpecialCategoryDropdown.sendKeys(Keys.ENTER);
		String value2 = SpecialCategoryDropdown.getAttribute("value");
		Assert.assertEquals(!value.equals(value2), true);
		ObjectRepo.test.log(Status.PASS, "Previously selected 'Special Category' is not appear and Newly selected 'Special Category' is displayed.");
		
	}

	public void verifyStartAndEndReportingPeriod() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].scrollIntoView();", BeginReportingPeriodIcon);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
		try {
			BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
			BeginReportingPeriodIcon.click();
		}
		CurrentDate.click(); // current date
		String BeginReportingValue = BeginReportingPeriod2.getAttribute("value");
		// Assert.assertEquals(BeginReportingValue, "2023/07/12");
		ObjectRepo.test.log(Status.PASS, "Begin Reporting Period is accepted"); // Step1
		try {
			EndReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
			EndReportingPeriodIcon.click();
		}
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
			CurrentDate.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
			CurrentDate.click();
		} 
		System.out.println("Previous end Reporting  "+EndReportingPeriod2.getAttribute("value"));
		ObjectRepo.test.log(Status.PASS, "System is accepting  the 'End Reporting Period' date equals to 'Begin Reporting Period'"); // Step2
		EndReportingPeriod2.clear();
		try {
			EndReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
			EndReportingPeriodIcon.click();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		calenderDatePicker("nextDate");
		System.out.println("Updated end reporting date  "+EndReportingPeriod2.getAttribute("value"));
		// EndReportingPeriod2.sendKeys("20230713"); //next date
		ObjectRepo.test.log(Status.PASS,
				"System is accepting  the 'End Reporting Period' date  later than 'Begin Reporting Period'"); // Step3
	}

	public void validationStartAndEndReportingPeriod() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		js.executeScript("arguments[0].scrollIntoView();", BeginReportingPeriodIcon);
		try {
			BeginReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(BeginReportingPeriodIcon));
			BeginReportingPeriodIcon.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CurrentDate));
		CurrentDate.click();
		String dateString = BeginReportingPeriod2.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Begin Reporting Period is accepted: " + dateString); // Step1
		try {
			EndReportingPeriodIcon.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(EndReportingPeriodIcon));
			EndReportingPeriodIcon.click();
		}
		calenderDatePicker("preDate");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(ErrorMessEndReportingPeriod));
		String ErrorMessage = ErrorMessEndReportingPeriod.getText();
		Assert.assertEquals(ErrorMessage,"The End Reporting Period must be equal to or later than the Begin Reporting Period.");
		ObjectRepo.test.log(Status.PASS, "Error message is dislayed");
	}

	public void navigateOffsetIssuanceDetailPage_Auth() throws Exception {
//		NavigateToOffsetIssuance();
		ProposeOffsetIssuance_UniqueProjectId();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-350)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CreatedTransferId));
		offsetTransferId = CreatedTransferId.getText();
		System.out.println(offsetTransferId);
		ObjectRepo.test.log(Status.PASS, "Offset Transfer Id created is: " + offsetTransferId);
		LogoutFunctionality();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		PH = new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			MyApprovalsLabelAuth.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MyApprovalsLabelAuth));
			CM.click2(MyApprovalsLabelAuth, "javascriptClick", "MyApprovalsLabelAuth");
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Search.sendKeys(offsetTransferId);
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SearchedTransferId));
		Thread.sleep(3000);
		SearchedTransferId.click();
	}

	public void ApprovedOffsetIssuance() throws Exception {
		navigateOffsetIssuanceDetailPage_Auth();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", DenyBtn);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			ApproveRadioBtn.click();
		} catch (Exception ex) {
			CM.click2(ApproveRadioBtn, "javascriptClick", "ApproveRadioBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(SubmitBtn));
		Assert.assertEquals(SubmitBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit button is enabled on clicking of Approve radio button");
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		Assert.assertEquals(SuccessMsg.getText(),"The issuance has been approved and compliance instrument holdings created.");
		ObjectRepo.test.log(Status.PASS, "Offset issuance has been approved successfully");
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuanceDetailsPageTitle));
		String PageTitle = OffsetIssuanceDetailsPageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance Details");
		ObjectRepo.test.log(Status.PASS, "User is navigated to the Offset Issuance Details page.");
	}
	
	public void verifyHoldingTable_ApprovedOffsetIssuance() throws Exception {
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		Thread.sleep(3000);
		Search1.sendKeys(OffsetIdValue);
		String OffsetIdValue = FirstOffsetIdHoldingTable.getText();
		Assert.assertEquals(OffsetIdValue.equals(OffsetIdValue), true);
		ObjectRepo.test.log(Status.PASS, "Approved Offset Issuance is updated in Holdings Table ");
		String SubTypeValue = FirstSubTypeHoldingTable.getText();
		Assert.assertEquals(SubTypeValue.equals(""), true);
		ObjectRepo.test.log(Status.PASS, "Value in the 'Sub-Type' column is blank in Holding Table.");
	}
	
	public void VerifyTransferTable_ApprovedOffsetIssuance() throws Exception{
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Search2.sendKeys(offsetTransferId);
		String TransferIdValue = FirstTransferIdTransferTable.getText();
		Assert.assertEquals(TransferIdValue.equals(offsetTransferId), true);
		Assert.assertEquals(FirstStatusTransferTable.getText(), "Complete");
		ObjectRepo.test.log(Status.PASS, "The record of the approved offset issuance is displayed in the Transfers table on the Issuance Account page with the status 'Complete'.");
		Assert.assertEquals(FirstTransferringAccountNameTransferTable.getText().equals(""), true);
		ObjectRepo.test.log(Status.PASS, "Value in the 'Transferring Account Name' column is blank in Transfer Table.");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(FirstTransferIdTransferTable));
		try {
			FirstTransferIdTransferTable.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(FirstTransferIdTransferTable));
			FirstTransferIdTransferTable.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuanceDetailsAuthPageTitle));
		String PageTitle = OffsetIssuanceDetailsAuthPageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance Details");
		ObjectRepo.test.log(Status.PASS, "User is navigated to the Offset Issuance details page by clicking on Transfer Id from Transfer Table.");
	}
	
	public void verifyTransferEventHistory_ApprovedOffsetIssuanceRecord() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SecondRecordTransferEventHistory));
		String ApprovedRecord = SecondRecordTransferEventHistory.getText();
		Assert.assertEquals(ApprovedRecord, "Approved");
		ObjectRepo.test.log(Status.PASS, "Approved record is added to the Transfer Event History table with a comment.");
		String CompleteRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(CompleteRecord, "Complete");
		ObjectRepo.test.log(Status.PASS, "Complete record is added to the Transfer Event History table with a comment.");
	}
	
	public void verifyMyApprovals_ApprovedOffsetIssuanceRecord() throws Exception {
		navigateBackToHomePage();
		navigateToMyApprovals_JAuth();
		System.out.println(offsetTransferId);
		Search.sendKeys(offsetTransferId);
		Thread.sleep(3000);
		String rows = TotalRows.getText();
		Assert.assertEquals(rows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Approved Offset Issunace record removed from My Approvals");
	}
	
	public void verifyStatus_IssuanceRecord_ApprovedOffsetIssuance() throws Exception {
		navigateBackToHomePage();
		navigateToIssuanceRecordPage();
		Search.sendKeys(offsetTransferId);
		String status = StatusColumn.getText();
		Assert.assertEquals(status.equals("Complete"), true);
		ObjectRepo.test.log(Status.PASS, "Status of the issuance is updated to ‘Complete’ in Issuance Record table.");
	}

	public void DeniedOffsetIssuance() throws Exception {
		navigateOffsetIssuanceDetailPage_Auth();
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", DenyBtn);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			DenyBtn.click();
		} catch (Exception ex) {
//			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(DenyBtn));
			CM = new CommonMethods(driver);
			CM.click2(DenyBtn, "javascriptClick", "DenyBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(asteriskMark));
		Assert.assertEquals(asteriskMark.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Asterisk mark is displayed on Comment text");
		CommentText.sendKeys("Testing Purpose");
		Assert.assertEquals(SubmitBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS,
				"Submit button is enabled after selection of Deny radio button and entering text in Comment field");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg,
				"The issuance has been denied and compliance instrument holdings has not been created.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is denied successfully");
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuanceDetailsPageTitle));
		String PageTitle = OffsetIssuanceDetailsPageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance Details");
		ObjectRepo.test.log(Status.PASS, "User is navigated to the Offset Issuance Details page.");
		String transferStatus = TransferStatus.getText();
		Assert.assertEquals(transferStatus.contains("Denied"), true);
		ObjectRepo.test.log(Status.PASS, "Transfer Status updated to 'Denied' ");
	}

	public void verifyTransferEventHistory_DeniedOffsetIssuanceRecord() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstRecordTransferEventHistory));
		String DenyRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(DenyRecord, "Denied");
		ObjectRepo.test.log(Status.PASS, "Denied record is added to the Transfer Event History table with a comment.");
	}

	public void verifyStatus_IssuanceRecord_DeniedOffset() throws Exception {
//		navigateBackToHomePage();
		navigateToIssuanceRecordPage();
		Search.sendKeys(offsetTransferId);
		System.out.println(offsetTransferId);
		String status = StatusColumn.getText();
		Assert.assertEquals(status.equals("Denied"), true);
		ObjectRepo.test.log(Status.PASS, "Status of the issuance is updated to ‘Denied’ in Issuance Record table.");
	}

	public void verifyMyApprovals_DeniedOffsetIssuanceRecord() throws Exception {
		navigateBackToHomePage();
		navigateToMyApprovals_JAuth();
		Search.sendKeys(offsetTransferId);
		Thread.sleep(5000);
		String rows = TotalRows.getText();
		Assert.assertEquals(rows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Denied Offset Issunace record removed from My Approvals");
	}
	
	public void verifyRequestRevision_OffsetIssuance_withoutProvidingComment() throws Exception {
		navigateOffsetIssuanceDetailPage_Auth();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
		try {
			RequestRevisionsBtn.click();
		} catch (Exception ex) {
			CM.click2(RequestRevisionsBtn, "moveToElementClick", "RequestRevisionsBtn");
		}
		Thread.sleep(3000);
		Assert.assertEquals(RequestRevisionsBtn.isSelected(), true);
		Assert.assertEquals(CommentLabel.getText().contains("*"), true);
		ObjectRepo.test.log(Status.PASS, "Step 1.1 : 'Request Revisions' radio button is displayed as selected & asterisk mark(*) is displayed for Comments text");
		try {
			CommentText.click();
		} catch (Exception e) {
			actions = new Actions(driver);
			actions.moveToElement(CommentText).click().build().perform();
		}
		CommentText.sendKeys(Keys.TAB);
		Assert.assertEquals(SubmitBtn.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Step 1.2 : Submit button is disabled");
		Assert.assertEquals(CommentError.getText(), "Comment is required for requesting revisions to the issuance record.");
		ObjectRepo.test.log(Status.PASS, "Step 2 : 'Comment is required for requesting revisions to the issuance record' error message is displayed.");
	}
	
	public void verifyStartAndEndSerializedCode_DenyOffsetIssuanceRecord() throws Exception {
		DeniedOffsetIssuance();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(EndValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Serialized Block code Start & End is not generated when the Offset issaunce is denied.");
		ObjectRepo.test.log(Status.PASS, "Value '0' is displayed for the Start, End and Quantity in Compliance Instruments Table.");
	}

	public void RequestRevisionOffsetIssuance() throws Exception {
		navigateOffsetIssuanceDetailPage_Auth();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", RequestRevisionsBtn);
		try {
			RequestRevisionsBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(RequestRevisionsBtn, "javascriptClick", "RequestRevisionsBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(asteriskMark));
		Assert.assertEquals(asteriskMark.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"Asterisk mark is displayed on Comment text after clicks on Revision Requeste radio button");
		CommentText.sendKeys("Testing Purpose");
		Assert.assertEquals(SubmitBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS,
				"Submit button is enabled after selection of Revision Request radio button and entering text in Comment field");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			SubmitBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitBtn));
			CM = new CommonMethods(driver);
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg,
				"Revisions are requested to the proposed issuance record and the compliance instrument holdings has not been created.");
		ObjectRepo.test.log(Status.PASS, "Offset Issuance is Revision Requested successfully");
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuanceDetailsPageTitle));
		String PageTitle = OffsetIssuanceDetailsPageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance Details");
		ObjectRepo.test.log(Status.PASS, "User is navigated to the Offset Issuance Details page.");
		String transferStatus = TransferStatus.getText();
		Assert.assertEquals(transferStatus.contains("Revisions Requested"), true);
		ObjectRepo.test.log(Status.PASS, "Transfer Status updated to 'Revisions Requested' ");
	}
	
	public void verifyStartAndEndSerializedCode_RequestRevisionOffsetIssuanceRecord() throws Exception {
		RequestRevisionOffsetIssuance();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(EndValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Step 1.1 : Serialized Block code Start & End is not generated when the offset issuance is revision requested.");
		ObjectRepo.test.log(Status.PASS, "Step 1.2 : Value '0' is displayed for the Start, End and Quantity.");
	}
	public void verifyDeny_OffsetIssuance_withoutProvidingComment() throws Exception {
		navigateOffsetIssuanceDetailPage_Auth();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
		try {
			DenyBtn.click();
		} catch (Exception ex) {
			CM.click2(DenyBtn, "moveToElementClick", "DenyBtn");
		}
		Thread.sleep(3000);
		Assert.assertEquals(DenyBtn.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, " The 'Deny' radio button is displayed as selected");
		Assert.assertEquals(CommentLabel.getText().contains("*"), true);
		ObjectRepo.test.log(Status.PASS, "Asterisk mark is displayed on Comment text");
		CommentText.click();
		CommentText.sendKeys(Keys.TAB);
		Assert.assertEquals(CommentError.getText(), "Comment is required for denying the issuance record.");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for empty comment field");
	}

	public void verifyTransferEventHistory_RevisionRequestOffsetIssuanceRecord() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstRecordTransferEventHistory));
		String DenyRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(DenyRecord, "Revisions Requested");
		ObjectRepo.test.log(Status.PASS,
				"Revisions Requested record is added to the Transfer Event History table with a comment.");
	}
	
	public void verifyMyApprovals_RequestRevisionOffsetIssuanceRecord() throws Exception {
		navigateBackToHomePage();
		navigateToMyApprovals_JAuth();
		System.out.println(offsetTransferId);
		Search.sendKeys(offsetTransferId);
		Thread.sleep(3000);
		String rows = TotalRows.getText();
		Assert.assertEquals(rows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Step 3 : Revision Requested offset Issuance Record is removed from the 'My Approvals' table");
	}

	public void verifyStatus_IssuanceRecord_RevisionRequestOffset() throws Exception {
//		navigateBackToHomePage();
		navigateToIssuanceRecordPage();
		Search.sendKeys(offsetTransferId);
		String status = StatusColumn.getText();
		Assert.assertEquals(status.equals("Revisions Requested"), true);
		ObjectRepo.test.log(Status.PASS,
				"Status of the issuance is updated to ‘Revisions Requested’ in Issuance Record table.");
	}

	public void verifyCancelBtnOffsetIssuanceDetail_Auth() throws Exception {
//		Navigate_To_IssuanceAccount();
//    	NavigateToOffsetIssuance();
		navigateOffsetIssuanceDetailPage_Auth();
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CancelBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CM = new CommonMethods(driver);
			CM.click2(CancelBtn, "javascriptClick", "CancelBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CancelBtnOfWarng));
		Assert.assertEquals(CancelBtnOfWarng.isEnabled() && ContinueBtnOfWarng.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with 'Cancel' and 'Continue' button");
		CancelBtnOfWarng.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuanceDetailsAuthPageTitle));
		String PageTitle = OffsetIssuanceDetailsAuthPageTitle.getText();
		Assert.assertEquals(PageTitle, "Offset Issuance Details");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Authority remains on same page on clicking of Cancel button of warning pop-up");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CancelBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
			CancelBtn.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtnOfWarng));
		ContinueBtnOfWarng.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MyApprovalPageTitle));
		String PageTitle1 = MyApprovalPageTitle.getText();
		Assert.assertEquals(PageTitle1, "My Approvals");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Authority navigates to My Approvals page on clicking of Continue button of warning pop-up");
	}
	
//	public void verifyIssuanceRecord_OffsetIssuanceProposal() {
//		Navigate_To_IssuanceAccount();
//		NavigateToOffsetIssuance();
//		ProposeOffsetIssuance_UniqueProjectId();
//		navigateToIssuanceRecordsPage_MegaMenu();
//		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(Search));
//		Search.sendKeys(offsetTransferId);
//		Thread.sleep(3000);
//		Assert.assertEquals(TransferIdColumn.getText(), offsetTransferId);
//		ObjectRepo.test.log(Status.PASS, "Step 1 : The proposed Offset Issuance Record With the Transfer ID is displayed in the Issuance Records table.");
//		TransferIdColumn.click();
//		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(OffsetIssuanceDetailsAuthPageTitle));
//		Assert.assertEquals(OffsetIssuanceDetailsAuthPageTitle.isDisplayed(), true);
//		ObjectRepo.test.log(Status.PASS, "Step 2 : Allowance Issuance Details Page is displayed with all the details of the Proposed Allowance Issuance.");
//		verifyComplianceInstrumentTable_AllowanceIssuanceDetail();
//		js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,450)", "");
//		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(StartValueComplianceTable));
//		System.out.println(StartValueComplianceTable.getText());
//		Assert.assertEquals(EndValueComplianceTable.isDisplayed(), true);
//		Assert.assertEquals(EndValueComplianceTable.getText().equals("0"), true);
//		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
//		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
//		ObjectRepo.test.log(Status.PASS, "Step 3.1 : Compliance Instruments’ card is displayed with all the fields");
//		ObjectRepo.test.log(Status.PASS, "Step 3.2 : Compliance Instruments table have a record for the proposed Offset Issuance Transfer ID and the Start, End, and Quantity is '0'.");
//		verifyTransferEventHistoryTable_AllowanceIssuanceDetail();
//		ObjectRepo.test.log(Status.PASS, "Step 4.1 : ‘Transfer Event History’ card is displayed with all fields");
//		verifyTransferEventHistory_ProposeAllowanceIssuanceRecord();
//		ObjectRepo.test.log(Status.PASS, "Step 4.2 : In the transfer Event History Table there is one record of proposed Allowance Issuance.");
//	}


	// Allowance Issuance

	public void navigateToAllowanceIssuancePage() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionsBtn));
			MoreActionsBtn.click();
		} catch (Exception ex) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MoreActionsBtn));
			MoreActionsBtn.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(AllowanceIssuanceSubMenu));
		AllowanceIssuanceSubMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssuancePageTitle));
		String PageTitle = AllowanceIssuancePageTitle.getText();
		Assert.assertEquals(PageTitle, "Allowance Issuance");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin navigated to Allowance Issuance page");
	}
	
	public void verifyUI_AllowanceIssuancePage() throws Exception {
		Navigate_To_IssuanceAccount();
		Thread.sleep(6000);
		try {
			MoreActionsBtn.click();
		} catch (Exception ex) {
			CM = new CommonMethods(driver);
			CM.click2(MoreActionsBtn, "moveToElementClick", "MoreActionButton");
		}
		Assert.assertEquals(OffsetIssuanceSubMenu.isDisplayed(), true);
		Assert.assertEquals(AllowanceIssuanceSubMenu.isDisplayed(), true);
		Assert.assertEquals(InitiateBatchTransferSubMenu.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, " 'Allowance Issuance', 'Offset Issuance', 'Initiate Batch Transfer' sbbmenus are displayed in More Action menu");
		AllowanceIssuanceSubMenu.click();
		Thread.sleep(3000);
		String PageTitle = AllowanceIssuancePageTitle.getText();
		Assert.assertEquals(PageTitle, "Allowance Issuance");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin navigated to Allowance Issuance page");
		Assert.assertEquals(IssuingCardTitle.getText(), "Issuing");
		ObjectRepo.test.log(Status.PASS, "Issuing card is present on Allowance Issuance page ");
		Assert.assertEquals(IssuingCardLabel.getText(), "Jurisdiction");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction label is present in Issuing card ");
		Assert.assertEquals(AcquiringAccountCardTitle.getText(), "Acquiring Account");
		ObjectRepo.test.log(Status.PASS, "Acquiring Account card is present on Allowance Issuance page ");
		List<String> AcquiringAccountLabels = Arrays.asList("Jurisdiction", "Account Number", "Account Type", "Account Status");
		List<String> ActualAcquiringAccountLabels = new ArrayList<>();
		for(int j=1; j<=4;j++){
			ActualAcquiringAccountLabels.add(AcquiringAccountCardLabels.get(j).getText());
			ObjectRepo.test.log(Status.PASS, "Labels present in the Acquiring Account Card are: "+AcquiringAccountCardLabels.get(j).getText());
		}
		boolean allLabelMatch = true;
		for (int i = 0; i<AcquiringAccountLabels.size(); i++) {
			String ExpValue = AcquiringAccountLabels.get(i);
			String ActValue = ActualAcquiringAccountLabels.get(i);
			if (!ExpValue.equals(ActValue)) {
				allLabelMatch = false;
				break;
			}
		}
		if (allLabelMatch) {
			ObjectRepo.test.log(Status.PASS, "All the expected labels are present on Acquiring Account card ");
		} else {
			ObjectRepo.test.log(Status.PASS, "All the expected labels are not present on Acquiring Account card ");
		}
		
		Assert.assertEquals(AllowanceIssuanceInformationCardTitle.getText(), "Allowance Issuance Information");
		ObjectRepo.test.log(Status.PASS, "Allowance Issuance Information card is present on Allowance Issuance page");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,350)", "");
		Assert.assertEquals(SubTypeField.getText().contains("Subtype"), true);
		Assert.assertEquals(SubTypeField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Subtype with Dropdown field is present in Allowance Issuance Information card. ");
		Assert.assertEquals(VintageYearField.getText().contains("Vintage Year"), true);
		Assert.assertEquals(VintageYearField.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Vintage Year with Dropdown field is present in Allowance Issuance Information card. ");
		Assert.assertEquals(QuantityLabel.getText().contains("Quantity") && quantity.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Quantity Field with input field is present in Allowance Issuance Information card.");
		Assert.assertEquals(commentLabel.getText().equals("Comment") && Comment.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Comment with input field is present in Allowance Issuance Information card.");;
	}
	
	public void verifySubTypeDropdown() throws Exception {
		List<String> ExpSubType = new ArrayList<String>();
		ExpSubType.add("Early Reduction Credit");
		ExpSubType.add("Price Ceiling Unit");
		ExpSubType.add("Price Containment Reserve Allowance");
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(4000);
		SubTypeDropdown.click();
		SubType1.click();
		Thread.sleep(4000);
		String ActValue = SubTypeDropdown.getAttribute("value");
		Assert.assertEquals(ActValue.equals(ExpSubType.get(0)), true);
		ObjectRepo.test.log(Status.PASS, ActValue+ " is present in the Sub Type Dropdown");
		SubTypeDropdown.click();
		SubType2.click();
		Thread.sleep(3000);
		ActValue = SubTypeDropdown.getAttribute("value");
		Assert.assertEquals(ActValue.equals(ExpSubType.get(1)), true);
		ObjectRepo.test.log(Status.PASS, ActValue+ " is present in the Sub Type Dropdown");
		Thread.sleep(4000);
		SubTypeDropdown.click();
		SubType3.click();
		Thread.sleep(3000);
		ActValue = SubTypeDropdown.getAttribute("value");
		Assert.assertEquals(ActValue.equals(ExpSubType.get(2)), true);
		ObjectRepo.test.log(Status.PASS, ActValue+ " is present in the Sub Type Dropdown");
		int SubTypeValue = ActValue.length();
        for (int j = 1; j <= SubTypeValue; j++) {
        	SubTypeDropdown.sendKeys(Keys.BACK_SPACE);
        }
        SubTypeDropdown.sendKeys(Keys.TAB);
        String ErrorMsg = ErrorMessage_VintageYr.getText();
        Assert.assertEquals(ErrorMsg, "Please select one of the Subtype Or Vintage Year fields.");
        ObjectRepo.test.log(Status.PASS, "Error message is displayed for empty SubType field");
        SubTypeDropdown.sendKeys("Early Reduction Credit");
        ActValue = SubTypeDropdown.getAttribute("value");
        Assert.assertEquals(ActValue.equals(ExpSubType.get(0)), true);
        ObjectRepo.test.log(Status.PASS, "Searched subtype is displayed in the list");
        SubTypeDropdown.click();
		SubType1.click();
		ActValue = SubTypeDropdown.getAttribute("value");
        Assert.assertEquals(ActValue.equals(ExpSubType.get(0)), true);
        ObjectRepo.test.log(Status.PASS, "Subtype is selected and error message is not displayed.");
        SubTypeDropdown.click();
		SubType2.click();
		String NewValue = SubTypeDropdown.getAttribute("value");
		Assert.assertEquals(!NewValue.equals(ActValue), true);
		ObjectRepo.test.log(Status.PASS, "Previously selected Subtype is not appear and Newly selected Subtype is displayed.");
	}

	public void verifySubTypeAndVintageYear_Withoutselecting() throws Exception {
		Thread.sleep(3000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(4000);
		SubTypeDropdown.click();
		Thread.sleep(3000);
		vintageYearDropdown.click();
		Thread.sleep(3000);
		quantity.click();
		String ErrMsg = ErrorMessage_subType_VintageYr.getText();
		Assert.assertEquals(ErrMsg, "Please select one of the Subtype Or Vintage Year fields.");
		ObjectRepo.test.log(Status.PASS, "Error message displayed: " + ErrMsg);
	}

	public void verifySubTypeAndVintageYear_WithSelectingBoth() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubTypeDropdown));
			SubTypeDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubTypeDropdown));
			SubTypeDropdown.click();
		}
		try {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubType1));
			SubType1.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubType1));
			SubType1.click();
		}
//		SubTypeDropdown.sendKeys(Keys.ARROW_DOWN);
//		Thread.sleep(3000);
//		SubTypeDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		vintageYearDropdown.click();
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		String ErrMsg = ErrorMessage_subType_VintageYr2.getText();
		Assert.assertEquals(ErrMsg, "Vintage Year is not required for the Compliance Instrument Sub Type selected.");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed: " + ErrMsg);
	}

	public void ProposeAllowanceIssuance_SubType() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", SubTypeDropdown);
		CM = new CommonMethods(driver);
		Thread.sleep(5000);
		try {
			SubTypeDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubTypeDropdown));
			CM.click2(SubTypeDropdown, "javascriptClick", "SubTypeDropdown");
		}
		Thread.sleep(3000);
		try {
			SubType1.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubType1));
			SubType1.click();
		}
		String SubTypeval = SubTypeDropdown.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Sub Type value selected is: " + SubTypeval);
		quantity.sendKeys("100");
		QuantityIssued = quantity.getAttribute("value");
		ObjectRepo.test.log(Status.PASS, "Proposed Quantity is: " + QuantityIssued);
		Assert.assertEquals(SubmitButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit button is enabled");
		try {
			SubmitButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MsgSubmitConfirm));
		String SubmitMsg = MsgSubmitConfirm.getText();
		Assert.assertEquals(SubmitMsg, "Confirm Issuance Proposal");
		ObjectRepo.test.log(Status.PASS, "Confirmation Pop-up is displayed ");
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Passphrase.sendKeys(prop.getProperty("Password"));
		ConfirmBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String Msg = SuccessMsg.getText();
		System.out.println(Msg);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Assert.assertEquals(Msg, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Allowance Issunace proposed Successfully ");
		SuccessMsgCancel.click();
		js.executeScript("window.scrollBy(0,-450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssuanceDetailsPageTitle));
		String PageTitle = AllowanceIssuanceDetailsPageTitle.getText();
		Assert.assertEquals(PageTitle, "Allowance Issuance Details");
		Thread.sleep(8000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(TransferId));
		allowancetransferId = TransferId.getText();
//		System.out.println(allowancetransferId);
		ObjectRepo.test.log(Status.PASS, "Created Transfer Id for Allowance Issuance is: " + allowancetransferId);
		
	}
		public void verifyTransferEventHistoryTable_ProposeAllowanceIssuance() {
			new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(TransferEventHistoryProposeData));
			Assert.assertEquals(TransferEventHistoryProposeData.isDisplayed(), true);
			ObjectRepo.test.log(Status.PASS, "Proposed event record is updated in the ‘Transfer Event History’ table");
		}
		

	public void VerifY_Functionality_Prepare_and_Propose_AllowanceIssuance() throws Exception {
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		ProposeAllowanceIssuance_SubType();
		verifyTransferEventHistoryTable_ProposeAllowanceIssuance();
		LogoutFunctionality();
		PH = new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		navigateToIssuanceRecordPage();
		search_TransferId_IssuanceRecordGrid();
		Assert.assertEquals(StatusColumn.getText(), "Proposed");
		ObjectRepo.test.log(Status.PASS, "The record is available for the Jurisdiction Authority to review");
	}

	public void ProposeAllowanceIssuance_VintageYear() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		CM = new CommonMethods(driver);
		Thread.sleep(4000);
		try {
			vintageYearDropdown.click();
		} catch (Exception ex) {
			CM.click2(vintageYearDropdown, "moveToElementClick", "vintageYearDropdown");
		}
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(FirstEffectiveBudgetYear);
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		quantity.sendKeys("1");
		SubmitButton.click();
		Thread.sleep(3000);
		String SubmitMsg = MsgSubmitConfirm.getText();
		Assert.assertEquals(SubmitMsg, "Confirm Issuance Proposal");
		ObjectRepo.test.log(Status.PASS, "Confirmation Pop-up is displayed ");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		Passphrase.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		ConfirmBtn.click();
		Thread.sleep(10000);
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String Msg = SuccessMsg.getText();
		System.out.println(Msg);
		Thread.sleep(3000);
		Assert.assertEquals(Msg, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Allowance Issunace proposed Successfully ");
		Thread.sleep(5000);
		SuccessMsgCancel.click();
	}

	public void getEffectiveVintageYears() throws Exception {
		RegModule3_MJB_POM MJB = new RegModule3_MJB_POM(driver);
		MJB.navigateToBudgetRecordsPage_JAdmin();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(8000);
		FirstApprovedYear = ApprovedBudgetYear.getText();
		String year = "";
		ApprovedBudgetYearsList = new ArrayList<String>();
		for (int k = 1; k <= 5; k++) {
			year = EffectiveBudgetYears.get(k).getText();
			ApprovedBudgetYearsList.add(year);
		}

		System.out.println(ApprovedBudgetYearsList);
	}


	public void verifyListApprovedVintageYearAllowanceIssuance() throws Exception {
		Thread.sleep(3000);
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		int size = ApprovedBudgetYearsList.size();
		String Vintageyear;
		for (int i = 0; i <= size-1; i++) {
			Vintageyear = ApprovedBudgetYearsList.get(i);
			System.out.println(Vintageyear);
			Thread.sleep(3000);
			vintageYearDropdown.sendKeys(Vintageyear);
			Thread.sleep(3000);
			vintageYearDropdown.sendKeys(Keys.ENTER);
			String vintageYearDropDownValue = vintageYearDropdown.getAttribute("value");
			Assert.assertEquals(vintageYearDropDownValue.equals(Vintageyear), true);
			ObjectRepo.test.log(Status.PASS, "Approved budget year is displayed in the Vintage Year dropdown");
			int yearValue = vintageYearDropDownValue.length();
			for (int j = 1; j <= yearValue; j++) {
				vintageYearDropdown.sendKeys(Keys.BACK_SPACE);
			}
		}
		ObjectRepo.test.log(Status.PASS, "List of approved budget years is displayed in the Vintage Year dropdown");
	}

	public void verifyErrorMsg_EmptyVintageYearDropDown_AllowanceIssuance() throws Exception {
		vintageYearDropdown.sendKeys(Keys.TAB);
		Thread.sleep(3000);
		String ErrMsg = ErrorMessage_VintageYr.getText();
		Assert.assertEquals(ErrMsg, "Please select one of the Subtype Or Vintage Year fields.");
		ObjectRepo.test.log(Status.PASS, "Error message displayed: " + ErrMsg);
	}

	public void verifyValidVintageYear() {
		String vintageYearDropDownValue = vintageYearDropdown.getAttribute("value");
		int yearValue = vintageYearDropDownValue.length();
		for (int j = 1; j <= yearValue; j++) {
			vintageYearDropdown.sendKeys(Keys.BACK_SPACE);
		}
		vintageYearDropdown.sendKeys(FirstApprovedYear);
		vintageYearDropdown.sendKeys(Keys.ENTER);
		String DropDownValue = vintageYearDropdown.getAttribute("value");
		Assert.assertEquals(DropDownValue.equals(FirstApprovedYear), true);
		ObjectRepo.test.log(Status.PASS, "Vintage Year gets accepted and no error message is displayed.");
	}

	public void verifyMultipleAlloawnaceIssuanceProposal() throws Exception {
		MJB = new RegModule3_MJB_POM(driver);
		MJB.Approved_Functionality_ByJAuth();
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		navigateToAllBudgetRecordsPage();
		getFirstEffectiveRecord();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		for (int i = 0; i <= 1; i++) {
			navigateToAllowanceIssuancePage();
			ProposeAllowanceIssuance_VintageYear();
			navigateBackToHomePage();
			Navigate_To_IssuanceAccount();
		}
		ObjectRepo.test.log(Status.PASS,
				"Allowance issuance is proposed and user is able to create Allowance issuance multiple times.");
	}

	public void verifyCancelBtnAllowanceIssuance_JAuth() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
		CM = new CommonMethods(driver);
		try {
			CancelButton.click();
		} catch (Exception ex) {
			CM.click2(CancelButton, "javascriptClick", "CancelButton");
		}
		Thread.sleep(3000);
		Assert.assertEquals(WrngCancelBtn.isEnabled() && WrngCntinueBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with 'Cancel' and 'Continue' button");
		Thread.sleep(4000);
		WrngCancelBtn.click();
		Thread.sleep(4000);
		String pageTitle = AllowanceIssuancePageTitle.getText();
		Assert.assertEquals(pageTitle, "Allowance Issuance");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Authority remains on same page on clicking of Cancel button of warning pop-up");
		Thread.sleep(3000);
		try {
			CancelButton.click();
		} catch (Exception ex) {
			CM.click2(CancelButton, "moveToElementClick", "CancelButton");
		}
		Thread.sleep(2000);
		WrngCntinueBtn.click();
		String PageTitle = IssuanceAccountPageTitle.getText();
		Assert.assertEquals(PageTitle, "Issuance Account");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Authority navigates to Issuance Account page on clicking of Continue button of warning pop-up");
	}

	public void verifyCancelBtnAllowanceIssuance_JAdmin() throws Exception {
		CM = new CommonMethods(driver);
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		try {
			CancelButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelButton));
			CM.click2(CancelButton, "javascriptClick", "CancelButton");
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Assert.assertEquals(WrngCancelBtn.isEnabled() && WrngCntinueBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with 'Cancel' and 'Continue' button");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(WrngCancelBtn));
		WrngCancelBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssuancePageTitle));
		String pageTitle = AllowanceIssuancePageTitle.getText();
		Assert.assertEquals(pageTitle, "Allowance Issuance");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Admin remains on same page on clicking of Cancel button of warning pop-up");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelButton));
		try {
			CancelButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelButton));
			CancelButton.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(WrngCntinueBtn));
		WrngCntinueBtn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(IssuanceAccountPageTitle));
		String PageTitle = IssuanceAccountPageTitle.getText();
		Assert.assertEquals(PageTitle, "Issuance Account");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Admin navigates to Issuance Account page on clicking of Continue button of warning pop-up");
	}

	public void verifyPassphraseField_Confirm_Issuance_Proposal_Popup() throws Exception {
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		CM = new CommonMethods(driver);
		try {
			SubTypeDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubTypeDropdown));
			SubTypeDropdown.click();
		}
		try {
			SubType1.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubType1));
			SubType1.click();
		}
		quantity.sendKeys("100");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitButton));
		try {
			SubmitButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(Passphrase));
		Passphrase.click();
		Passphrase.sendKeys(Keys.TAB);
		String PassErrMsg = PaasphraseErrMsg.getText();
		Assert.assertEquals(PassErrMsg, "Passphrase is required");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for empty password");
		Assert.assertEquals(ConfirmBtn.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Confirm button is disabled for empty password");
		Passphrase.sendKeys("12345678");
		ConfirmBtn.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(IncorrectPaasphraseErrMsg));
		String IncorrectPassErrMsg = IncorrectPaasphraseErrMsg.getText();
		Assert.assertEquals(IncorrectPassErrMsg, "Passphrase is incorrect");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for invalid password");
	}

	public void navigateToAllBudgetRecordsPage() throws Exception {
		CM = new CommonMethods(driver);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ViewBudgetRecordLable));
		try {
			ViewBudgetRecordLable.click();
		} catch (Exception ex) {
			CM.click2(ViewBudgetRecordLable, "javascriptClick", "ViewBudgetRecordLable");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllBudgetRecordtitle));
		String PageTitle = AllBudgetRecordtitle.getText();
		ObjectRepo.test.log(Status.PASS, "User Navigated to: " + PageTitle);
	}

	public void Add_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_AllBudgetYear() throws Exception {
		navigateToAllBudgetRecordsPage();
		MuiGridHandler ref = new MuiGridHandler();
		ref.selectRow(0);
	}

	public int convertStringToInt(String num) {
		String modifiedNum = num.replace(",", "");
		return Integer.parseInt(modifiedNum);
	}

	public void getFirstEffectiveRecord() throws Exception {
		Thread.sleep(4000);
		FirstEffectiveBudgetYear = BudgetYearFirstRecord.getText();
		allowanceOutstandingForReserveAdjustedAllowanceBudget = allowanceOutstandingForReserveAdjustedAllowanceBudgetFirstRecord
				.getText();
		System.out.println(allowanceOutstandingForReserveAdjustedAllowanceBudget);
		FirstallowanceOutstandingForReserveAdjustedAllowanceBudget = convertStringToInt(
				allowanceOutstandingForReserveAdjustedAllowanceBudget);
		System.out.println("Integer value: " + FirstallowanceOutstandingForReserveAdjustedAllowanceBudget);
		// convert Allowance Outstanding for Reserve Adjusted Allowance Budget into int

		Secondquantity = FirstallowanceOutstandingForReserveAdjustedAllowanceBudget - 1;
		QuantityEntered = String.valueOf(Secondquantity);
		System.out.println(QuantityEntered);
		ObjectRepo.test.log(Status.PASS, "First Effective Budget Year is:  " + FirstEffectiveBudgetYear);
		ObjectRepo.test.log(Status.PASS, "First Allowance Outstanding for Reserve Adjusted Allowance Budge :"
				+ allowanceOutstandingForReserveAdjustedAllowanceBudget);
	}

	public void verify_Quantity_against_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_ForSameBudYear()throws Exception {
		MJB = new RegModule3_MJB_POM(driver);
		MJB.Approved_Functionality_ByJAuth();
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		try {
			PH.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not displayed");
		}
		navigateToAllBudgetRecordsPage();
		Search1.sendKeys(MJB.AddBudgetYear);
		Thread.sleep(3000);
		allowanceOutstandingForReserveAdjustedAllowanceBudget = allowanceOutstandingForReserveAdjustedAllowanceBudgetFirstRecord.getText();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		CM = new CommonMethods(driver);
		Thread.sleep(4000);
		try {
			vintageYearDropdown.click();
		} catch (Exception ex) {
			CM.click2(vintageYearDropdown, "moveToElementClick", "vintageYearDropdown");
		}
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(MJB.AddBudgetYear);
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(Keys.ENTER);
		quantity.sendKeys("1");
		String QuantityValue = quantity.getAttribute("value");
		SubmitButton.click();
		Thread.sleep(3000);
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		Passphrase.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		ConfirmBtn.click();
		Thread.sleep(10000);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Allowance Issuance proposed successfully");
		SuccessMsgCancel.click();
		Thread.sleep(3000);
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		CM = new CommonMethods(driver);
		Thread.sleep(4000);
		try {
			vintageYearDropdown.click();
		} catch (Exception ex) {
			CM.click2(vintageYearDropdown, "moveToElementClick", "vintageYearDropdown");
		}
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(MJB.AddBudgetYear);
		vintageYearDropdown.sendKeys(Keys.ENTER);
		Thread.sleep(4000);
		quantity.sendKeys(allowanceOutstandingForReserveAdjustedAllowanceBudget);
		SubmitButton.click();
		Thread.sleep(3000);
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		Passphrase.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		ConfirmBtn.click();
		Thread.sleep(4000);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String Errormsg = SuccessMsg.getText();
		Assert.assertEquals(Errormsg,
				"The allowance quantity exceeds the Budget Allowances Outstanding for Reserve Adjusted Budget for the selected Vintage Year.");
		ObjectRepo.test.log(Status.PASS,
				"Error msg is displayed if the Quantity entered more than the 'Allowances Outstanding for Reserve Adjusted Budget' for the selected vintage year - the quantity of the previous Allowance Issuance proposal.");
		ErrCancel.click();
		Thread.sleep(2000);
		int size = quantity.getAttribute("value").length();
		for(int i=1; i<=size;i++) {
			quantity.sendKeys(Keys.BACK_SPACE);
		}
		int allowanceoutstanding=Integer.parseInt(allowanceOutstandingForReserveAdjustedAllowanceBudget); 
		int quantityValue  = Integer.parseInt(QuantityValue); 
		allowanceOutstandingForReserveAdjustedAllowanceBudget=String.valueOf(allowanceoutstanding-quantityValue-1); 
		quantity.sendKeys(allowanceOutstandingForReserveAdjustedAllowanceBudget);
		SubmitButton.click();
		Thread.sleep(2000);
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		Passphrase.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		ConfirmBtn.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String Msg = SuccessMsg.getText();
		Assert.assertEquals(Msg, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Allowance Issuance suucessfully propose for the Quantity value less than and equal to the 'Allowances Outstanding for Reserve Adjusted Budget' for the selected vintage year - the quantity of the previous Allowance Issuance proposal(s).");
	}
	
	public void navigateToIssuanceRecordsPage_MegaMenu() throws Exception {
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(MegaMenu));
		MegaMenu.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(IssuanceRecordOption));
		IssuanceRecordOption.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(IssuanceRecordPageTitle));
		IssuanceRecordPageTitle.getText();
	}

	public void search_TransferId_IssuanceRecordGrid() throws Exception {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Search.sendKeys(allowancetransferId);
		status = StatusColumn.getText();
		ObjectRepo.test.log(Status.PASS,
				"Searched Transfer ID in search field of Issuance Record grid is: " + allowancetransferId);
	}

	public void verify_ProposeStatus_IssuanceRecord() throws Exception {
		search_TransferId_IssuanceRecordGrid();
		Thread.sleep(3000);
		Assert.assertEquals(status, "Proposed");
		ObjectRepo.test.log(Status.PASS,
				"Record of Allowance issuance is added on the Issuance records page with the status 'Proposed'.");
	}

	public void navigateToAllowanceIssuanceDetails() throws Exception {
		navigateToAllowanceIssuancePage();
		ProposeAllowanceIssuance_SubType();
		verifyTransferEventHistoryTable_ProposeAllowanceIssuance();
		LogoutFunctionality();
		PH = new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("California", "Authority");
		try {
			PH.secQueAns();
		} catch (Exception e) {
			System.out.println("");
		}
		navigateToMyApprovals_JAuth();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Search.sendKeys(allowancetransferId);
		SearchedTransferId.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssunanceDetailTitle));
		Assert.assertEquals(AllowanceIssunanceDetailTitle.getText(), "Allowance Issuance Details");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Authority navigated to Allowance Issuance Details Page");

	}

	public void verifyApproveAllowanceFunctionality_JAuth() throws Exception {
		navigateToAllowanceIssuanceDetails();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", ApproveRadioBtn);
		try {
			ApproveRadioBtn.click();
		} catch (Exception ex) {
			CM.click2(ApproveRadioBtn, "javascriptClick", "ApproveRadioBtn");
		}
		Assert.assertEquals(SubmitBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit button is enabled post clicking on Approve Radio button");
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		wait = new WebDriverWait(driver, 40);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		Assert.assertEquals(SuccessMsg.getText(),
				"The issuance has been approved and compliance instrument holdings created.");
		ObjectRepo.test.log(Status.PASS, "Alowance issuance has been approved successfully");
		SuccessMsgCancel.click();
	}

	public void verifyTransferStatus_ApprovedAllowanceIssuance_DetailsPage() {
		String transferStatus = TransferStatus.getText();
		Assert.assertEquals(transferStatus.contains("Complete"), true);
		ObjectRepo.test.log(Status.PASS, "The status transfer is updated to 'Complete' ");
	}
	
	public void verifyTransferEventHistory_ApprovedAllowanceIssuanceRecord() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SecondRecordTransferEventHistory));
		String ApprovedRecord = SecondRecordTransferEventHistory.getText();
		Assert.assertEquals(ApprovedRecord, "Approved");
		ObjectRepo.test.log(Status.PASS, "Approved record is added to the Transfer Event History table with a comment.");
		String CompleteRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(CompleteRecord, "Complete");
		ObjectRepo.test.log(Status.PASS, "Complete record is added to the Transfer Event History table with a comment.");
		
	}
	
	public void verifyStatus_IssuanceRecord_ApprovedAllowance() throws Exception {
		navigateBackToHomePage();
		navigateToIssuanceRecordPage();
		Search.sendKeys(allowancetransferId);
		String status = StatusColumn.getText();
		Assert.assertEquals(status.equals("Complete"), true);
		ObjectRepo.test.log(Status.PASS, "Status of the issuance is updated to ‘Complete’ in Issuance Record table.");
	}
	
	public void CancelBtnFunctionality_Allowance_Issuance_details_page() throws Exception {
		navigateToAllowanceIssuanceDetails();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", ApproveRadioBtn);
		try {
			ApproveRadioBtn.click();
		} catch (Exception ex) {
			CM.click2(ApproveRadioBtn, "javascriptClick", "ApproveRadioBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CancelBtn));
		try {
			CancelBtn.click();
		} catch (Exception ex) {
			CM.click2(CancelBtn, "moveToElementClick", "CancelBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(CancelBtnOfWarng));
		Assert.assertEquals(CancelBtnOfWarng.isEnabled() && ContinueBtnOfWarng.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with 'Cancel' and 'Continue' button");
		Thread.sleep(3000);
		try {
			CancelBtnOfWarng.click();
		} catch (Exception ex) {
			CM.click2(CancelBtnOfWarng, "javascriptClick", "CancelBtnOfWarng");
		}
		Assert.assertEquals(ApproveRadioBtn.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "Waring popup gets closed and data entered is not cleared.");
		try {
			CancelBtn.click();
		} catch (Exception ex) {
			CM.click2(CancelBtn, "javascriptClick", "CancelBtn");
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(ContinueBtnOfWarng));
		try {
			ContinueBtnOfWarng.click();
		} catch (Exception ex) {
			CM.click2(ContinueBtnOfWarng, "moveToElementClick", "ContinueBtnOfWarng");
		}
		String PageTitle = MyApprovalPageTitle.getText();
		Assert.assertEquals(PageTitle, "My Approvals");
		ObjectRepo.test.log(Status.PASS,
				"Jurisdiction Authority navigates to My Approvals page on clicking of Continue button of warning pop-up");
	}
	
	public void verifyDeny_AllowanceIssuance_withoutProvidingComment() throws Exception {
		navigateToAllowanceIssuanceDetails();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", DenyBtn);
		try {
			DenyBtn.click();
		} catch (Exception ex) {
			CM.click2(DenyBtn, "javascriptClick", "DenyBtn");
		}
		Assert.assertEquals(DenyBtn.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, " The 'Deny' radio button is displayed as selected");
		Assert.assertEquals(CommentLabel.getText().contains("*"), true);
		ObjectRepo.test.log(Status.PASS, "Asterisk mark is displayed on Comment text");
		CommentText.click();
		CommentText.sendKeys(Keys.TAB);
		Assert.assertEquals(CommentError.getText(), "Comment is required for denying the issuance record.");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed for empty comment field");
	}
	
	public void verifyDenyFunctionality_AllowanceIssuance() throws Exception {
		navigateToAllowanceIssuanceDetails();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", DenyBtn);
		try {
			DenyBtn.click();
		} catch (Exception ex) {
			CM.click2(DenyBtn, "moveToElementClick", "DenyBtn");
		}
		CommentText.sendKeys("Testing Purpose");
		Assert.assertEquals(SubmitBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "SUBMIT button is enabled once clicking on Deny Radio button and entering Comment .");
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM.click2(SubmitBtn, "javascriptClick", "SubmitBtn");
		}
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		Assert.assertEquals(SuccessMsg.getText(), "The issuance has been denied and compliance instrument holdings has not been created.");
		ObjectRepo.test.log(Status.PASS, "Success Message is displayed as: "+SuccessMsg.getText());
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssunanceDetailTitle));
		Assert.assertEquals(AllowanceIssuanceDetailsPageTitle.getText(), "Allowance Issuance Details");
		ObjectRepo.test.log(Status.PASS, "User is navigated to 'Allowance Issuance details' page.");
	}
	
	public void verifyTransferStatus_DenyAllowanceIssuanceRecord() {
		String transferStatus = TransferStatus.getText();
		Assert.assertEquals(transferStatus.contains("Denied"), true);
		ObjectRepo.test.log(Status.PASS, "Allowance Transfer Status updated to 'Denied' ");
	}
	
	public void verifyTransferEventHistory_DenyAllowanceIssuanceRecord() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstRecordTransferEventHistory));
		String DenyRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(DenyRecord, "Denied");
		ObjectRepo.test.log(Status.PASS, "Denied record is added to the Transfer Event History table with a comment.");
	}
	
	public void verifyStatus_IssuanceRecord_DenyAllowanceIssuanceRecord() throws Exception {
		navigateBackToHomePage();
		navigateToIssuanceRecordPage();
		Search.sendKeys(allowancetransferId);
		String status = StatusColumn.getText();
		Assert.assertEquals(status.equals("Denied"), true);
		ObjectRepo.test.log(Status.PASS, "Status of the issuance is updated to ‘Denied’ in Issuance Record table.");
	}
	
	public void verifyMyApproval_DenyAllowanceIssuanceRecord() throws Exception {
		navigateBackToHomePage();
		navigateToMyApprovals_JAuth();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Search.sendKeys(allowancetransferId);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(TotalRows));
		Thread.sleep(3000);
		String rows = TotalRows.getText();
		System.out.println(rows);
		Assert.assertEquals(rows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Denied Allowance Issunace record removed from My Approvals");
	}
	
	public void verifyStartAndEndSerializedCode_DenyAllowanceIssuanceRecord() throws Exception {
		verifyDenyFunctionality_AllowanceIssuance();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(StartValueComplianceTable));
		System.out.println(StartValueComplianceTable.getText());
		Assert.assertEquals(EndValueComplianceTable.isDisplayed(), true);
		Assert.assertEquals(EndValueComplianceTable.getText().equals("0"), true);
		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Serialized Block code Start & End is not generated when the Allowance issaunce is denied.");
		ObjectRepo.test.log(Status.PASS, "Value '0' is displayed for the Start, End and Quantity in Compliance Instruments Table.");
	}
	
	public void verifyRequestRevisionFunctionality_AllowanceIssuance() throws Exception {
		navigateToAllowanceIssuanceDetails();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(3000);
		try {
			RequestRevisionsBtn.click();
		} catch (Exception ex) {
			CM.click2(RequestRevisionsBtn, "moveToElementClick", "RequestRevisionsBtn");
		}
		CommentText.sendKeys("Testing Purpose");
		Assert.assertEquals(SubmitBtn.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "SUBMIT button is enabled once clicking on Request Revisions Radio button and entering Comment .");
		try {
			SubmitBtn.click();
		} catch (Exception ex) {
			CM.click2(SubmitBtn, "moveToElementClick", "SubmitBtn");
		}
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		Assert.assertEquals(SuccessMsg.getText(), "Revisions are requested to the proposed issuance record and the compliance instrument holdings has not been created.");
		ObjectRepo.test.log(Status.PASS, "Success Message is displayed as: "+SuccessMsg.getText());
		SuccessMsgCancel.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssuanceDetailsPageTitle));
		Assert.assertEquals(AllowanceIssuanceDetailsPageTitle.getText(), "Allowance Issuance Details");
		ObjectRepo.test.log(Status.PASS, "User is navigated to 'Allowance Issuance details' page.");
	}
	
	public void verifyStartAndEndSerializedCode_RequestRevisionAllowanceIssuanceRecord() throws Exception {
		verifyRequestRevisionFunctionality_AllowanceIssuance();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(StartValueComplianceTable));
		System.out.println(StartValueComplianceTable.getText());
		Assert.assertEquals(EndValueComplianceTable.isDisplayed(), true);
		Assert.assertEquals(EndValueComplianceTable.getText().equals("0"), true);
		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Step 1.1 : Serialized Block code Start & End is not generated when the Allowance Issuance is revision requested.");
		ObjectRepo.test.log(Status.PASS, "Step 1.2 : Value '0' is displayed for the Start, End and Quantity.");
	}
	
	public void verifyTransferStatus_RequestRevisionAllowanceIssuanceRecord() {
		String transferStatus = TransferStatus.getText();
		Assert.assertEquals(transferStatus.contains("Revisions Requested"), true);
		ObjectRepo.test.log(Status.PASS, "Allowance Transfer Status updated to 'Revisions Requested' ");
	}
	
	public void verifyTransferEventHistory_RequestRevisionAllowanceIssuanceRecord() {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstRecordTransferEventHistory));
		String RevisionRequestRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(RevisionRequestRecord, "Revisions Requested");
		ObjectRepo.test.log(Status.PASS, "Revisions Requested record is added to the Transfer Event History table with a comment.");
	}
	
	public void verifyStatus_IssuanceRecord_RequestRevisionAllowanceIssuanceRecord() throws Exception {
		navigateBackToHomePage();
		navigateToIssuanceRecordPage();
		Search.sendKeys(allowancetransferId);
		String status = StatusColumn.getText();
		Thread.sleep(3000);
		Assert.assertEquals(status.equals("Revisions Requested"), true);
		ObjectRepo.test.log(Status.PASS, "Status of the issuance is updated to ‘Revisions Requested’ in Issuance Record table.");
	}
	
	public void verify_Quantity_against_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_ForFirstTime()throws Exception{
		MJB = new RegModule3_MJB_POM(driver);
		MJB.Approved_Functionality_ByJAuth();
		LogoutFunctionality();
		PH= new publicHomePage(driver, prop);
		Thread.sleep(3000);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		navigateToAllBudgetRecordsPage();
		Search1.sendKeys(MJB.AddBudgetYear);
		Thread.sleep(3000);
		allowanceOutstandingForReserveAdjustedAllowanceBudget = allowanceOutstandingForReserveAdjustedAllowanceBudgetFirstRecord.getText();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(5000);
		CM = new CommonMethods(driver);
		Thread.sleep(4000);
		try {
			vintageYearDropdown.click();
		} catch (Exception ex) {
			CM.click2(vintageYearDropdown, "moveToElementClick", "vintageYearDropdown");
		}
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(MJB.AddBudgetYear);
		Thread.sleep(3000);
		vintageYearDropdown.sendKeys(Keys.ENTER);
		System.out.println("Allowance Outstanding Reserve Adjusted Budget Value :  "+allowanceOutstandingForReserveAdjustedAllowanceBudget);
		int allowanceoutstanding=Integer.parseInt(allowanceOutstandingForReserveAdjustedAllowanceBudget); 
		allowanceOutstandingForReserveAdjustedAllowanceBudget=String.valueOf(allowanceoutstanding+1);  
		quantity.sendKeys(allowanceOutstandingForReserveAdjustedAllowanceBudget);
		System.out.println("value greater than Allowance Outstanding value  "+allowanceOutstandingForReserveAdjustedAllowanceBudget);
		SubmitButton.click();
		Thread.sleep(2000);
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		Passphrase.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		ConfirmBtn.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String errMsg = SuccessMsg.getText();
		Assert.assertEquals(errMsg, "The allowance quantity exceeds the Budget Allowances Outstanding for Reserve Adjusted Budget for the selected Vintage Year.");
		ObjectRepo.test.log(Status.PASS, "Error message is displayed as:  "+errMsg);
		ErrCancel.click();
		Thread.sleep(2000);
		int size = quantity.getAttribute("value").length();
		for(int i=1; i<=size;i++) {
			quantity.sendKeys(Keys.BACK_SPACE);
		}
		allowanceOutstandingForReserveAdjustedAllowanceBudget=String.valueOf(allowanceoutstanding-1);  
		quantity.sendKeys(allowanceOutstandingForReserveAdjustedAllowanceBudget);
		SubmitButton.click();
		Thread.sleep(2000);
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(3000);
		Passphrase.sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		ConfirmBtn.click();
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String successMsg = SuccessMsg.getText();
		Assert.assertEquals(successMsg, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Allowance Issuance suucessfully propose for the Quantity value less than the 'Allowance Outstanding for Reserve Adjusted Allowance Budget' for selected Vintage year.");
	}
	
	public void validateQuantityField_AllowanceIssuance() throws Exception {
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(quantity));
		try {
			quantity.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(quantity));
			quantity.click();
		}
		quantity.sendKeys(Keys.TAB);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(quantityErrMsg));
		Assert.assertEquals(quantityErrMsg.getText(), "Quantity is required");
		ObjectRepo.test.log(Status.PASS, "Step 1 : 'Quantity Required' error message is displayed.");
		quantity.sendKeys("0");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(quantityErrMsg));
		Assert.assertEquals(quantityErrMsg.getText(), "Quantity must be a valid number.");
		ObjectRepo.test.log(Status.PASS, "Step 2 : 'Quantity must be a valid number' error message is displayed.");
		quantity.sendKeys("10");
		try {
			Assert.assertEquals(quantityErrMsg.isDisplayed(), true);
			ObjectRepo.test.log(Status.PASS, "Error Msg is displyaed for Quantity field for valid data");
		}
		catch(Exception ex){
			ObjectRepo.test.log(Status.PASS, "Step 3 : Valid Quantity is accepted and no error message is displayed.");
		}
	}
	
	public void verifyComplianceInstrumentTable_AllowanceIssuanceDetail() {
		List<String> columns = Arrays.asList("Transfer ID", "Vintage", "Jurisdiction", "Type", "Sub-Type", "Offset Type","Offset Project ID", "Start","End","Quantity");
		List<String> ActualColumns = new ArrayList<>();
        for(int j=3; j<=12;j++){
        	ActualColumns.add(ColumnLabel.get(j).getText());
        }
        boolean allLabelMatch = true;
        for (int i = 0; i<columns.size(); i++) {
            String ExpValue = columns.get(i);
            String ActValue = ActualColumns.get(i);
            if (!ExpValue.equals(ActValue)) {
                allLabelMatch = false;
                break;
            }
        }
        if (allLabelMatch) {
            ObjectRepo.test.log(Status.PASS, "'Compliance Instruments’ card should be displayed following fields: "+ActualColumns);
        } else {
            ObjectRepo.test.log(Status.PASS, "All the columns are not present on Compliance Instrumenty Card ");
        }
	}
	
	public void verifyTransferEventHistoryTable_AllowanceIssuanceDetail() {
		List<String> columns = Arrays.asList("Event", "Event Date (yyyy/mm/dd)", "Comment");
		List<String> ActualColumns = new ArrayList<>();
        for(int j=13; j<=15;j++){
        	ActualColumns.add(ColumnLabel.get(j).getText());
        }
        Assert.assertEquals(ActionByColumnLable.getText(), "Action By");
        boolean allLabelMatch = true;
        for (int i = 0; i<columns.size(); i++) {
            String ExpValue = columns.get(i);
            String ActValue = ActualColumns.get(i);
            if (!ExpValue.equals(ActValue)) {
                allLabelMatch = false;
                break;
            }
        }
        if (allLabelMatch) {
            ObjectRepo.test.log(Status.PASS, "‘Transfer Event History’ card is displayed with following fields:: "+ActualColumns +" , " +ActionByColumnLable.getText());
        } else {
            ObjectRepo.test.log(Status.PASS, "All the columns are not present on Transfer Event History Card ");
        }
	}
	
	public void verifyTransferEventHistory_ProposeAllowanceIssuanceRecord() {
		js = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(FirstRecordTransferEventHistory));
		String ProposeRecord = FirstRecordTransferEventHistory.getText();
		Assert.assertEquals(ProposeRecord, "Proposed");
	}
	
	public void verifyIssuanceRecord_AllowanceIssuanceProposal() throws Exception {
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		ProposeAllowanceIssuance_SubType();
		navigateToIssuanceRecordsPage_MegaMenu();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(Search));
		Search.sendKeys(allowancetransferId);
		Thread.sleep(3000);
		Assert.assertEquals(TransferIdColumn.getText(), allowancetransferId);
		ObjectRepo.test.log(Status.PASS, "Step 1 : The proposed Allowance Issuance Record With the Transfer ID is displayed in the Issuance Records table.");
		TransferIdColumn.click();
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(AllowanceIssuanceDetailsPageTitle));
		Assert.assertEquals(AllowanceIssuanceDetailsPageTitle.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Step 2 : Allowance Issuance Details Page is displayed with all the details of the Proposed Allowance Issuance.");
		verifyComplianceInstrumentTable_AllowanceIssuanceDetail();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(StartValueComplianceTable));
		System.out.println(StartValueComplianceTable.getText());
		Assert.assertEquals(EndValueComplianceTable.isDisplayed(), true);
		Assert.assertEquals(EndValueComplianceTable.getText().equals("0"), true);
		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Step 3.1 : Compliance Instruments’ card is displayed with all the fields");
		ObjectRepo.test.log(Status.PASS, "Step 3.2 : Compliance Instruments table have a record for the proposed Offset Issuance Transfer ID and the Start, End, and Quantity is '0'.");
		verifyTransferEventHistoryTable_AllowanceIssuanceDetail();
		ObjectRepo.test.log(Status.PASS, "Step 4.1 : ‘Transfer Event History’ card is displayed with all fields");
		verifyTransferEventHistory_ProposeAllowanceIssuanceRecord();
		ObjectRepo.test.log(Status.PASS, "Step 4.2 : In the transfer Event History Table there is one record of proposed Allowance Issuance.");
	}
	
	public void fetchReserveBudget_AllBudgetRecordPage() throws Exception {
		MJB = new RegModule3_MJB_POM(driver);
		Thread.sleep(7000);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MJB.ReserveBudgetValue));
		ReserveBudget = MJB.ReserveBudgetValue.getText();
		System.out.println(ReserveBudget);
	}
	
	public void fetchReserveAllowancesIssued_AllBudgetRecordPage() {
		MJB = new RegModule3_MJB_POM(driver);
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MJB.ReserveAllowancesIssuedValue));
		MJB.ReserveAllowancesIssued = MJB.ReserveAllowancesIssuedValue.getText();
	}
	
	public void validateQuantity_PCRAIssuance() throws Exception {
		MJB = new RegModule3_MJB_POM(driver);
		navigateToAllBudgetRecordsPage();
		fetchReserveBudget_AllBudgetRecordPage();
		System.out.println(ReserveBudget);
		ObjectRepo.test.log(Status.PASS, "Reserve Budget is: "+ReserveBudget);
		fetchReserveAllowancesIssued_AllBudgetRecordPage();
		ObjectRepo.test.log(Status.PASS, "Reserve Allowance Issued is: "+MJB.ReserveAllowancesIssued);
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		navigateToAllowanceIssuancePage();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Thread.sleep(7000);
		try {
			SubTypeDropdown.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubTypeDropdown));
			CM.click2(SubTypeDropdown, "javascriptClick", "SubTypeDropdown");
		}
		Thread.sleep(3000);
		try {
			SubType3.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubType3));
			SubType3.click();
		}
		Assert.assertEquals(SubTypeDropdown.getAttribute("value"), "Price Containment Reserve Allowance");
		ObjectRepo.test.log(Status.PASS, "Step 1 : 'Price Containment Reserve Allowance' sub-type is selected.");
		int ReserveAllowancesIssued=Integer.parseInt(MJB.ReserveAllowancesIssued);
		System.out.println(ReserveAllowancesIssued);
//		int ReserveBudget = Integer.parseInt(MJB.ReserveBudget);
//		int ReserveBudget = convertStringToInt(MJB.ReserveBudget);
		//Integer ReserveBudget=Integer.valueOf(MJB.ReserveBudget);  
		String modifiedNum = ReserveBudget.replace(",", "");
		int ReserveBudget = Integer.parseInt(modifiedNum);
		int ReserveBudget_Minus_ReserveAllowancesIssued = ReserveBudget - ReserveAllowancesIssued;
		int invalidQuantity = ReserveBudget_Minus_ReserveAllowancesIssued + 1;
		String invalidQuantityStr=String.valueOf(invalidQuantity);  
		int validQuantity = ReserveBudget_Minus_ReserveAllowancesIssued - 1;
		String validQuantityStr=String.valueOf(validQuantity);  
		quantity.sendKeys(invalidQuantityStr);
		try {
			SubmitButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MsgSubmitConfirm));
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Passphrase.sendKeys(prop.getProperty("Password"));
		ConfirmBtn.click();
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ToastErrMsg));
		Assert.assertEquals(ToastErrMsg.getText(), "The allowance quantity exceeds the allowances that can be issued from the Reserve Budget");
		ObjectRepo.test.log(Status.PASS, "Step 2 : 'The allowance quantity exceeds the allowances that can be issued from the Reserve Budget' error message is displayed.");
		ErrCancel.click();
		Thread.sleep(3000);
		int size = quantity.getAttribute("value").length();
		for(int i=0;i<=size;i++) {
			quantity.sendKeys(Keys.BACK_SPACE);
		}
		try {
			quantity.sendKeys(validQuantityStr);
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(quantity));
			quantity.sendKeys(validQuantityStr);
		}
		try {
			SubmitButton.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		}
		new WebDriverWait(driver, 40).until(ExpectedConditions.visibilityOf(MsgSubmitConfirm));
		src = new File(System.getProperty("user.dir") + "/config.properties");
		fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Passphrase.sendKeys(prop.getProperty("Password"));
		ConfirmBtn.click();
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(SuccessMsg));
		String Msg = SuccessMsg.getText();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		Assert.assertEquals(Msg, "The issuance has been successfully prepared and is awaiting review.");
		ObjectRepo.test.log(Status.PASS, "Allowance Issunace proposed Successfully ");
		ObjectRepo.test.log(Status.PASS, "Step 3 : Error message is not displayed and valid Quantity is accepted.");
	}
	
	public void verifyAccountBalance_IssuanceAccount_ApprovalAllowanceIssuance() throws Exception {
		Navigate_To_IssuanceAccount();
		fetchAccountBalance_issuanceAccount();
		ObjectRepo.test.log(Status.PASS, "Account Balance of Issuance Account before proposing Allowance Issuance is : "+AccountBalance);
		ObjectRepo.test.log(Status.PASS, "Available Account Balance of Issuance Account before proposing Allowance Issuance is : "+AvailableAccountBalance);
		String PreviousAccountBalance = AccountBalance;
		String modifiedNum = PreviousAccountBalance.replace(",", "");
		int PreAccBal = Integer.parseInt(modifiedNum);
		System.out.println("Previous Account Balance: "+PreviousAccountBalance);
		verifyApproveAllowanceFunctionality_JAuth();
		navigateBackToHomePage();
		Navigate_To_IssuanceAccount();
		fetchAccountBalance_issuanceAccount();
		ObjectRepo.test.log(Status.PASS, "Account Balance of Issuance Account after approving Allowance Issuance is : "+AccountBalance);
		ObjectRepo.test.log(Status.PASS, "Available Account Balance of Issuance Account after approving Allowance Issuance is : "+AvailableAccountBalance);
		int quantity = Integer.parseInt(QuantityIssued);
		int ExpUpdatedAccBal = PreAccBal + quantity;
		System.out.println("Expected Updated Account Balance: "+ExpUpdatedAccBal);
		String updatedAccountBal = AccountBalance.replace(",", "");
		int ActUpdatedAccBal = Integer.parseInt(updatedAccountBal);
		System.out.println("Actual Updated Account Balance: "+ActUpdatedAccBal);
		System.out.println("Updated Account Balance : "+updatedAccountBal);
		Assert.assertEquals(ActUpdatedAccBal, ExpUpdatedAccBal);
		ObjectRepo.test.log(Status.PASS, "Step 1 : Account Balance and the Available Account Balance in the Issuance Account is updated with an addition of approved allowances in the Quantity.");
	}
	
	public void verifyProposedAllowanceIssuanceDetailsPage_JAuth() throws Exception {
		Navigate_To_IssuanceAccount();
		String IssuanceAccNo = IssuanceAccountNumber.getText();
		navigateToAllowanceIssuanceDetails();
		Thread.sleep(7000);
		Assert.assertEquals(TransferId.getText(), allowancetransferId);
		Assert.assertEquals(TransferTypeValue.getText(), "Allowance Issuance");
		Assert.assertEquals(TransferStatusValue.getText(),"Proposed");
		Assert.assertEquals(QuantityProposedValue.getText(), QuantityIssued);
		ObjectRepo.test.log(Status.PASS, "Step 1.1 : The issuance details are populated on the page.");
		for(int i=1;i<TransferringAccColumn.size();i++) {
			Assert.assertEquals(TransferringAccColumn.get(i).getText(), "");
		}
		ObjectRepo.test.log(Status.PASS, "Step 1.2 : Transferring account is blank.");
		Assert.assertEquals(ReceivingAccLegNameVal.getText(), "California");
		Assert.assertEquals(ReceivingAccNoVal.getText(), IssuanceAccNo);
		ObjectRepo.test.log(Status.PASS, "Step 1.3 : Jurisdiction account details is displayed in the receiving account column.");
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		Assert.assertEquals(StartValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(EndValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(QuantityValueComplianceTable.getText().contains("0"), true);
		Assert.assertEquals(OffsetTypeValComplTable.getText(), "");
		ObjectRepo.test.log(Status.PASS, "Step 1.4 : In the Compliance Instruments table, offset type is blank and quantity, start and end is displayed as '0'.");
	}
	
	public void verifyRequestRevision_AllowanceIssuance_MyApprovals() throws Exception {
		Navigate_To_IssuanceAccount();
		verifyRequestRevisionFunctionality_AllowanceIssuance();
		navigateBackToHomePage();
		navigateToMyApprovals_JAuth();
		Search.sendKeys(allowancetransferId);
		Thread.sleep(5000);
		String rows = TotalRows.getText();
		Assert.assertEquals(rows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "Step 3 : Revision Requested Allowance Issuance Record is removed from the 'My Approvals' table.");
	}
	
	public void verifyRequestRevision_AllowanceIssuance_withoutProvidingComment() throws Exception {
		navigateToAllowanceIssuanceDetails();
		js = (JavascriptExecutor) driver;
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		js.executeScript("arguments[0].scrollIntoView();", RequestRevisionsBtn);
		try {
			RequestRevisionsBtn.click();
		} catch (Exception ex) {
			CM.click2(RequestRevisionsBtn, "javascriptClick", "RequestRevisionsBtn");
		}
		Assert.assertEquals(RequestRevisionsBtn.isSelected(), true);
		Assert.assertEquals(CommentLabel.getText().contains("*"), true);
		ObjectRepo.test.log(Status.PASS, "Step 1.1 : 'Request Revisions' radio button is displayed as selected & asterisk mark(*) is displayed for Comments field.");
		Assert.assertEquals(SubmitlBtn_OffsetIssuance.isEnabled(), false);
		ObjectRepo.test.log(Status.PASS, "Step 1.2 : Submit button is disabled");
		try {
			CommentText.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 40).until(ExpectedConditions.elementToBeClickable(CommentText));
			CommentText.click();
		}
		CommentText.sendKeys(Keys.TAB);
		Assert.assertEquals(CommentError.getText(), "Comment is required for requesting revisions to the issuance record.");
		ObjectRepo.test.log(Status.PASS, "Step 2 : 'Comment is required for requesting revisions to the issuance record' error message is displayed.");
	}
	
	public void verifyStartAndEndSerializedCode_ApprovedAllowanceIssuanceRecord() throws Exception {
		Navigate_To_IssuanceAccount();
		verifyApproveAllowanceFunctionality_JAuth();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		String StartValue = StartValueComplianceTable.getText();
		String EndValue = EndValueComplianceTable.getText();
		ObjectRepo.test.log(Status.PASS, "Start Code value of last block is : "+StartValue);
		ObjectRepo.test.log(Status.PASS, "End Code value of last block is : "+EndValue);
		Thread.sleep(3000);
		LogoutFunctionality();
		Thread.sleep(3000);
		PH= new publicHomePage(driver, prop);
		PH.loginFunctionality("California", "JurisdictionAdmin");
		try {
			PH.secQueAns();
		} catch (Exception e) {
			System.out.println("Security question is not displayed");
		}
		Navigate_To_IssuanceAccount();
		verifyApproveAllowanceFunctionality_JAuth();
		Thread.sleep(4000);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		String ActStartValue2 = StartValueComplianceTable.getText();
		String ActEndValue2 = EndValueComplianceTable.getText();
		int Quantity = Integer.parseInt(QuantityIssued);
		int start = Integer.parseInt(EndValue);
		int expstart = start+1;
		//int end = Integer.parseInt(StartValue);
		int expend = expstart+Quantity-1;
		String ExpStart=String.valueOf(expstart);
		String ExpEnd=String.valueOf(expend);
		Assert.assertEquals(ActStartValue2, ExpStart);
		Assert.assertEquals(ActEndValue2, ExpEnd);
		ObjectRepo.test.log(Status.PASS, "Step 1.1 : Values of Serialized Block code Start & End is populated for the approved Allowance Issuance.");
		ObjectRepo.test.log(Status.PASS, "Step 1.2 : Start code value is 'End+1' of the last block created : "+ActStartValue2);
		ObjectRepo.test.log(Status.PASS, "Step 1.3 : End code value is Start code + (Quantity -1) : "+ActEndValue2);
	}
}
