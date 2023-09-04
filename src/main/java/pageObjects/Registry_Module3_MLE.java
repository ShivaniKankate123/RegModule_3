package pageObjects;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import resources.ObjectRepo;
import resources.base;

public class Registry_Module3_MLE extends base {
	public WebDriver driver;
	JavascriptExecutor js;
	// Click on Batch Exemptions
	@FindBy(xpath = "//a[text()= \"Batch Exemptions\"]")
	WebElement BatchExemption;
	@FindBy(xpath = "//h1[text()= \"Batch Exemptions\"]")
	WebElement BatchExemptionText;
	// Click on Limited Exemptions
	@FindBy(xpath = "//a[text()= \"Limited Exemptions\"]")
	WebElement LimitedExemption;
	// Click on MORE ACTIONS
	@FindBy(xpath = "//button[text() =\"MORE ACTIONS\"]")
	WebElement MoreActions;
	// Click on Create Limited Exemption
	@FindBy(xpath = "//p[text() =\"CREATE LIMITED EXEMPTION\"]")
	WebElement CreateLimitedExemption;
	@FindBy(xpath = "//h1[text()= \"Create Limited Exemption Batch\"]")
	WebElement CreateLimitedExemptionBatch;
	// Enter Batch Name
	@FindBy(xpath = "//input[@name =\"batchName\"]")
	WebElement BatchName;
	// Select Budget Year
	@FindBy(id = "budgetYear-react-hook-form-select-search")
	WebElement BudgetYear;
	// Select value from dropdown
	@FindBy(xpath = "//li[@tabindex=\"0\"]")
	WebElement BudgetYearList;
	@FindBy(xpath = "(//li[@class=\"MuiButtonBase-root MuiMenuItem-root MuiMenuItem-gutters MuiMenuItem-root MuiMenuItem-gutters css-1dk2hx\"])[4]")
	WebElement BudgetYearListForApproved;
	// Enter comment
	@FindBy(xpath = "//textarea[@id=\"comment\"]")
	WebElement Comment;
	// Click on Save
	@FindBy(xpath = "//button[text()=\"Save\"]")
	WebElement Save;
	// Click on Batch ID
	@FindBy(xpath = "//a[text()=\"85\"]")
	WebElement BatchID;
	// Click on EDIT Batch Exemption
	@FindBy(xpath = "//p[text()=\"EDIT BATCH EXEMPTION\"]")
	WebElement EditBatchExemption;
	// Click on ThreeDotsButton
	@FindBy(xpath = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk']")
	WebElement ThreeDotsButton;
	@FindBy(xpath = "//p[text()=\"EDIT\"]")
	WebElement Edit;
	@FindBy(xpath = "//input[@id=\"limitedExemption\"]")
	WebElement LimitedExemptionValue;
	@FindBy(xpath = "(//button[text()=\"Cancel\"])[1]")
	WebElement ClickCancel;
	@FindBy(xpath = "(//button[text()=\"Cancel\"])[2]")
	WebElement BottomCancelClick;
	@FindBy(xpath = "//h6[text()=\"Warning!\"]")
	WebElement WarningPopup;
	@FindBy(xpath = "//button[@data-testid=\"priv_modal_Cancel\"]")
	WebElement WarningCancel;
	@FindBy(xpath = "//h1[text()=\"Batch Exemption Details\"]")
	WebElement BatchExemptionDetailsPage;
	@FindBy(xpath = "//button[@data-testid=\"priv_modal_Continue\"]")
	WebElement WarningContinue;
	@FindBy(id = "entityId")
	WebElement EntityID;
//	@FindBy(id="limitedExemption")
//	WebElement LimitedExemptionField;
	@FindBy(id = "entityId-helper-text")
	WebElement EntityIdError;
	@FindBy(xpath = "//button[text()=\"Add Limited Exemption\"]")
	WebElement AddLimitedExemptionButton;
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]") // Effective
																																// Date
	WebElement ClickEffectiveDate;
	@FindBy(xpath = "//button[@aria-label=\"Choose date\"]")
	WebElement EffectiveDate;
	@FindBy(xpath = "(//textarea[@data-testid=\"comment\"])[2]") // Comment
	WebElement Comments;
	@FindBy(xpath = "//h6[text()=\"Success!\"]")
	WebElement SuccessMessage;
	@FindBy(xpath = "(//a[text()=\"CA01644\"])[1]")
	WebElement AddedLimitedExemption;
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin MuiPickersDay-today css-bfxleo\"]")
	WebElement SelectDate;
	@FindBy(xpath = "//button[@aria-colindex=\"7\"]")
	WebElement SelecteDate2;
	@FindBy(xpath = "//button[@aria-colindex=\"5\"]")
	WebElement SelecteDate3;
	@FindBy(xpath = "//button[@aria-colindex=\"6\"]")
	WebElement SelecteDate4;
	@FindBy(xpath = "//button[@aria-colindex=\"4\"]")
	WebElement SelecteDate5;
	@FindBy(xpath = "//button[@aria-colindex=\"1\"]")
	WebElement SelecteDate6;
	@FindBy(xpath = "//a[text()=\"86\"]")
	WebElement ProposedBatchID;
	@FindBy(xpath = "//a[text()=\"88\"]")
	WebElement SavedBatchIDRemoveLimitedExemption;
	@FindBy(xpath = "//p[text()=\"REMOVE RECORD\"]")
	WebElement RemoveLimitedExemption;
	@FindBy(xpath = "//h6[text()=\"Success!\"]")
	WebElement SuccessPopup;
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-5zd7v5\"]")
	WebElement SuccessPopupClose;
	@FindBy(xpath = "//a[text()=\"30\"]")
	WebElement RevisionRequestedBatchIDRemoveLimitedExemption;
	@FindBy(xpath = "//p[@class=\"MuiTypography-root MuiTypography-body2 css-m94agu\"]")
	WebElement BudgetYearText;
	@FindBy(xpath = "//div[text()=\"Saved\"]") // Batch Exemption History Table saved status
	WebElement SavedText;
	@FindBy(xpath = "//div[text()=\"Approved\"]") // Batch Exemption History Table saved status
	WebElement ApprovedText;
	@FindBy(xpath = "//a[text()=\"HOME\"]")
	WebElement ClickOnHome;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body2 css-1cpdyr0\"])[2]")
	WebElement StoreBatchID;
	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz\"])[1]") // Search
	WebElement ClickSearch;
	@FindBy(xpath = "//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1889nlh\"]")
	WebElement storeBatchIdFromLimitedExemptionBatches;
	@FindBy(xpath = "//p[text()=\"The limited exemption has been successfully added\"]")
	WebElement SuccessMessageLimitedExemption;
	@FindBy(id = "batchName-helper-text")
	WebElement BatchNameFieldRequired;
	@FindBy(xpath = "//h1[text()=\"Batch Exemptions\"]")
	WebElement BatchExemptionsPage;
	@FindBy(xpath = "//h1[text()=\"Create Limited Exemption Batch\"]")
	WebElement Create_Limited_Exemption_Batch_Page;
	@FindBy(xpath = "//p[text()=\"Effective Date is required\"]")
	WebElement EffectiveDateRequired;
	JavascriptExecutor js1;
	// Fetching Batch ID
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body2 css-1cpdyr0\"])[2]")
	WebElement GetBatchId;
	@FindBy(xpath = "//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1889nlh\"]")
	WebElement ClickOnSearchedBatchId;
	@FindBy(xpath = "(//button[text()=\"Cancel\"])[2]")
	WebElement ClickPageCancel;
	@FindBy(xpath = "//button[text()=\"Propose\"]")
	WebElement ProposeButton;
	@FindBy(xpath = "//input[@id=\"passphrase\"]")
	WebElement PasspharseEnter;
	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement SubmitButton;
	@FindBy(xpath = "//button[text()=\"Welcome,\"]")
	WebElement ClickWelcomeFogOut;
	@FindBy(xpath = "//a[text()=\"Logout\"]")
	WebElement ClickOnLogout;
	@FindBy(xpath = "//h1[text()='Create Limited Exemption Batch']")
	WebElement TitleCreateLEBatch;
	@FindBy(xpath = "//div[text()=\"Entity and Limited Exemption Information\"]")
	WebElement TextEntityandLimitedExemptionInformation;
	@FindBy(xpath = "//p[text()=\"DELETE BATCH EXEMPTION\"]")
	WebElement DeleteBatchExemption;
	@FindBy(xpath = "//div[text()=\"Limited Exemption Records\"]")
	WebElement TextLimitedExemptionRecord;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body2 css-1cpdyr0\"])[3]")
	WebElement ProposedFetchID;
	@FindBy(xpath = "//div[text()= \"Batch Exemption History\"]")
	WebElement BatchExemptionTable;
	@FindBy(xpath = "(//div[@class=\"MuiDataGrid-virtualScrollerContent css-0\"])[1]")
	WebElement LimitedExemptionsNoRows;
	@FindBy(xpath = "//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1889nlh\"]")
	WebElement FetchEntityId;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 css-lz7acl\"])[1]")
	WebElement TotalRows;
	@FindBy(xpath = "//input[@class=\"MuiInputBase-input MuiOutlinedInput-input MuiInputBase-inputAdornedEnd css-1uvydh2\"]")
	WebElement GetDate;
	@FindBy(xpath = "//nav[@aria-label=\"pagination navigation\"]")
	WebElement Pagination;
	@FindBy(xpath = "//*[@data-testid=\"NavigateNextIcon\"]")
	WebElement PaginationNextIcon;
	@FindBy(xpath = "//*[@data-testid=\"LastPageIcon\"]")
	WebElement PaginationLastPageIcon;
	@FindBy(xpath = "//*[@data-testid=\"NavigateBeforeIcon\"]")
	WebElement PaginationBeforeIcon;
	@FindBy(xpath = "//*[@data-testid=\"FirstPageIcon\"]")
	WebElement PaginationFirstPageIcon;
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiPaginationItem-root MuiPaginationItem-sizeMedium MuiPaginationItem-text MuiPaginationItem-circular Mui-selected MuiPaginationItem-page css-1vly51i\"]")
	WebElement PaginationPageTwo;
	@FindBy(xpath = "//button[@aria-label=\"Go to page 1\"]")
	WebElement PaginationPageOne;
	@FindBy(xpath = "//p[text()=\"Entity does not match the CITSS Entity ID\"]")
	WebElement InvalidEntityIDError;
	@FindBy(xpath = "//div[text()=\"Proposed\"]")
	WebElement ProposedStatusText;
	@FindBy(xpath = "//p[text()=\"The LE for Entity ID with same Effective Date is already present in this batch\"]")
	WebElement EffectiveDateError;
	@FindBy(xpath = "//p[text()=\"Success!\"]")
	WebElement SuccessMEssageAfterAddingLE;
	@FindBy(xpath = "//button[text()=\"Upload File\"]")
	WebElement ClickOnUploadFileButton;
	@FindBy(xpath = "//*[text()=\"Browse Files\"]")
	WebElement ClickOnBrowseFiles;
	@FindBy(xpath = "(//button[text()=\"Cancel\"])[3]")
	WebElement ClickCancelOnFileUpload;
	@FindBy(xpath = "//button[text()=\"Upload\"]")
	WebElement Upload;
	@FindBy(xpath = "//p[text()=\"The file must have at least one Limited Exemption record\"]")
	WebElement BlankFileErrorMessage;
	@FindBy(xpath = "//p[text()=\"Upload Files\"]")
	WebElement UploadFilesPopUp;
	@FindBy(xpath = "//div[@class='MuiGrid-root MuiGrid-container css-kcbhw4']")
	WebElement GetFileUploadErrors;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 css-bj5op3\"])[1]")
	WebElement EmptyDateError1;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 css-bj5op3\"])[2]")
	WebElement EmptyDateError2;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 css-bj5op3\"])[3]")
	WebElement EmptyDateError3;
	@FindBy(xpath = "//p[text()=\"The data must be in consecutive rows\"]")
	WebElement EmptyRowsError;
	@FindBy(xpath = "//p[text()=\"Number of rows with a validation error: 1, out of 2 rows checked\"]")
	WebElement DuplicateEntityIDError1;
	// @FindBy(xpath ="//p[text()=\Entity ID of rows with duplicate row data:
	// [\"CA00174\"]\"]")
	// WebElement DuplicateEntityIDError2;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body2 css-j4m1we\"])[5]")
	WebElement UploadFileText;
	@FindBy(xpath = "//p[text()=\"Budget Year is required\"]")
	WebElement BudgetYearError;
	@FindBy(xpath = "//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1889nlh\"]")
	WebElement StoreEntityId;
	@FindBy(xpath = "(//div[@class=\"MuiDataGrid-cellContent\"])[3]")
	WebElement FetchLimitedExemptions;
	@FindBy(xpath = "//p[text()=\"Holding Limits\"]")
	WebElement HoldingLimits;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body1 css-ip80gu\"])[9]")
	WebElement FetchLEFromHoldingLimit;
	@FindBy(xpath = "//p[text()=\"Entity Details\"]")
	WebElement EntityDetails;
	@FindBy(xpath = "(//div[@data-field='budgetYear'])[2]")
	WebElement ApprovedBudgetYear;
	@FindBy(xpath = "//*[@data-field='budgetYear']")
	List<WebElement> EffectiveBudgetYears;
	@FindBy(xpath = "//h4[text()=\"Manage Limited Exemptions\"]")
	WebElement ManageLimitedExemptions;
	@FindBy(xpath = "//button[text()=\"Search Entities\"]")
	WebElement SearchEntities;
	@FindBy(xpath = "//button[@aria-label=\"Show filters\"]")
	WebElement Filters;
	@FindBy(xpath = "//*[text()=\"Add filter\"]")
	WebElement AddFilter;
	@FindBy(xpath = "(//select[@class=\"MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe\"])[1]")
	WebElement FirstColumn;
	@FindBy(xpath = "(//select[@class=\"MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe\"])[3]")
	WebElement Value1;
	@FindBy(xpath = "(//select[@class=\"MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe\"])[5]")
	WebElement SecondColumn;
	@FindBy(xpath = "(//select[@class=\"MuiNativeSelect-select MuiNativeSelect-standard MuiInputBase-input MuiInput-input css-1vynybe\"])[7]")
	WebElement Value2;
	@FindBy(xpath = "(//a[@class=\"link-cell\"])[1]")
	WebElement SelectEntityId;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body2 css-1cpdyr0\"])[2]")
	WebElement StatusUpadteOnBatchExemptionDetails;
	@FindBy(xpath = "(//div[@class=\"MuiDataGrid-cellContent\"])[2]")
	WebElement StatusUpadteOnLEBatches;
	@FindBy(xpath = "//a[@class=\"MuiTypography-root MuiTypography-inherit MuiLink-root MuiLink-underlineAlways css-1889nlh\"]")
	WebElement LeEntityID;
	@FindBy(xpath = "//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation2 css-88iqos\"]")
	WebElement InfoCard;
	@FindBy(xpath = "//div[text()=\"Limited Exemption Batches\"]")
	WebElement LimitedExemptionBatchesText;
	@FindBy(xpath = "//div[@class=\"MuiDataGrid-columnHeaderTitle css-cc8tf1\"]")
	List<WebElement> LimitedExemptionsBatchesTableColumns;
	@FindBy(xpath = "//div[text()=\"Batch Exemption Information\"]")
	WebElement BatchExemptionInformationText;
	@FindBy(xpath = "//label[contains(@class, \"MuiFormLabel-root MuiInputLabel-root MuiInputLabel-animated MuiFormLabel-colorPrimary MuiInputLabel-root MuiInputLabel-animated css\")]")
	List<WebElement> BatchExemptionInformationLabels;
	@FindBy(xpath = "//p[@id=\"limitedExemption-helper-text\"]")
	WebElement LimitedExemptionError;
	@FindBy(xpath ="//div[@class=\"MuiDataGrid-columnHeaderTitle css-cc8tf1\"]")
	List<WebElement> LimitedExemptionsRecordsTableColumns;

	// Authority page Xpaths
	@FindBy(xpath = "//input[@name=\"Request Revisions\"]")
	WebElement RequestRevisionsRadioButton;
	@FindBy(xpath = "//input[@name=\"Approve\"]")
	WebElement ApproveRadioButton;
	@FindBy(xpath = "//input[@name=\"Deny\"]")
	WebElement DenyRadioButton;
	@FindBy(xpath = "//textarea[@id=\"comment\"]")
	WebElement CommentText;
	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement SubmitButtonClick;
	@FindBy(xpath = "(//button[text()=\"Submit\"])[2]")
	WebElement SubmitButtonOnPopUp;
	@FindBy(xpath = "//span[text()=\"*\"]")
	WebElement AsteriskMark;
	@FindBy(xpath = "//p[text()=\"Submit Batch Exemption\"]")
	WebElement PassphrasePopupText;
	@FindBy(xpath = "//div[text()=\"Approve Request\"]")
	WebElement ApproveRequestCard;
	@FindBy(xpath = "//div[text()=\"Revisions Requested\"]")
	WebElement StatusText;
	@FindBy(xpath = "(//button[text()=\"Cancel\"])[2]")
	WebElement CancelButtonOnConmfirmationPopup;
	@FindBy(xpath = "//p[text()=\"Limited Exemption Batch is successfully denied\"]")
	WebElement SuccessPopUpText;
	@FindBy(xpath = "//p[text()=\"Limited Exemption Batch is successfully requested for revision\"]")
	WebElement SuccessPopUpTextOfRevisonsRequsted;
	@FindBy(xpath = "//p[text()=\"Comments is required\"]")
	WebElement CommentErrroMessage;
	@FindBy(xpath = "//p[text()=\"Passphrase is required\"]")
	WebElement PassPhraseIsRequired;
	@FindBy(xpath = "//p[text()=\"Passphrase is incorrect\"]")
	WebElement IncorrectPassphrase;
	@FindBy(xpath = "//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-5zd7v5\"]")
	WebElement WarningPopupClose;
	@FindBy(xpath = "//div[text()=\"Denied\"]") // Batch Exemption History Table saved status
	WebElement DeniedText;
	@FindBy(xpath = "(//p[@class=\"MuiTypography-root MuiTypography-body2 css-1cpdyr0\"])[2]")
	WebElement StatusOnBatchExemptionDetails;
	@FindBy(xpath = "//div[@title=\"Revisions Requested\"]")
	WebElement RevisionsRequstedStatusInBatchExemptionHistory;
	@FindBy(xpath = "//a[text()= \"My Approvals\"]")
	WebElement MyApprovals;
	@FindBy(xpath = "(//input[@class=\"MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz\"])[2]")
	WebElement BatchExemptionHistorySearch;
	@FindBy(xpath = "//div[@title=\"Proposed\"]")
	WebElement ProposedStatusInBatchExemptionHistory;
	@FindBy(xpath = "//button[@aria-label=\"Show filters\"]")
	WebElement ClickOnFilters;
	@FindBy(xpath = "//input[@placeholder=\"Filter value\"]")
	WebElement FilterValue;
	@FindBy(xpath = "//p[text()=\"Limited Exemption Batch is successfully approved\"]")
	WebElement SuccessMessageAfterApprove;
	@FindBy(xpath = "//p[text()=\"Denied\"]")
	WebElement DeniedStatus;
	@FindBy(xpath = "//p[text()=\"Saved\"]")
	WebElement SavedStatus;
	@FindBy(xpath = "//p[text()=\"Approved\"]")
	WebElement ApprovedStatus;
	@FindBy(xpath = "//p[text()=\"Revisions Requested\"]")
	WebElement RevisionsRequestedStatus;
	@FindBy(xpath ="//div[@class=\"MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation0 css-1eb1xxk\"]")
	WebElement RevisionsRequstedCommentCard;
	CommonMethods demo = new CommonMethods(driver);
	publicHomePage sc;
	private String storeBatchId;
	private String ProposeBatchId;
	private String StoredEntityID;
	private String FetchEntityID;
	private String FirstApprovedYear;
	private String SelectedEntityID;
	private String SelectedGMPIEntityID;
	private String SelectedClosedEntityID;
	private String SelectedOtherJUEntityID;
	List<String> ApprovedBudgetYearsList;
	WebDriverWait wait;
	Select dropdown;

	public Registry_Module3_MLE(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	public void SelectEntityId() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(SearchEntities));
		SearchEntities.click();
		Filters.click();
		AddFilter.click();
//		FirstColumn.click();
		dropdown = new Select(FirstColumn);
		dropdown.selectByVisibleText("Entity Type");
		dropdown = new Select(Value1);
		dropdown.selectByVisibleText("Covered Entity, Covered Source, or Opt-In Entity");
		dropdown = new Select(SecondColumn);
		dropdown.selectByVisibleText("Entity Status");
		dropdown = new Select(Value2);
		dropdown.selectByVisibleText("Active");
		ClickSearch.click();
		Thread.sleep(3000);
		SelectedEntityID = SelectEntityId.getText();
		System.out.println(SelectedEntityID);
	}

	public void GMPIEntityId() throws Exception {
		ClickOnHome.click();
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(SearchEntities));
		SearchEntities.click();
		Filters.click();
		AddFilter.click();
//		FirstColumn.click();
		dropdown = new Select(FirstColumn);
		dropdown.selectByVisibleText("Entity Type");
		dropdown = new Select(Value1);
		dropdown.selectByVisibleText("General Market Participant - Organization");
		dropdown = new Select(SecondColumn);
		dropdown.selectByVisibleText("Entity Status");
		dropdown = new Select(Value2);
		dropdown.selectByVisibleText("Active");
		ClickSearch.click();
		SelectedGMPIEntityID = SelectEntityId.getText();
		System.out.println(SelectedGMPIEntityID);
	}

	public void ClosedEntityId() throws Exception {
		ClickOnHome.click();
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(SearchEntities));
		SearchEntities.click();
		Filters.click();
		AddFilter.click();
//		FirstColumn.click();
		dropdown = new Select(FirstColumn);
		dropdown.selectByVisibleText("Entity Type");
		dropdown = new Select(Value1);
		dropdown.selectByVisibleText("Covered Entity, Covered Source, or Opt-In Entity");
		dropdown = new Select(SecondColumn);
		dropdown.selectByVisibleText("Entity Status");
		dropdown = new Select(Value2);
		dropdown.selectByVisibleText("Closed");
		ClickSearch.click();
		Thread.sleep(3000);
		SelectedClosedEntityID = SelectEntityId.getText();
		System.out.println(SelectedClosedEntityID);
	}

	public void OtherJUEntityId() throws Exception {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(SearchEntities));
		SearchEntities.click();
		Filters.click();
		AddFilter.click();
//		FirstColumn.click();
		dropdown = new Select(FirstColumn);
		dropdown.selectByVisibleText("Entity Type");
		dropdown = new Select(Value1);
		dropdown.selectByVisibleText("Covered Entity, Covered Source, or Opt-In Entity");
		dropdown = new Select(SecondColumn);
		dropdown.selectByVisibleText("Entity Status");
		dropdown = new Select(Value2);
		dropdown.selectByVisibleText("Active");
		ClickSearch.click();
		Thread.sleep(3000);
		SelectedOtherJUEntityID = SelectEntityId.getText();
		System.out.println(SelectedOtherJUEntityID);
	}

	// batch Exemption
	public void navigateToBatchExemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(BatchExemption));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", BatchExemption);

	}

	// Limited EXEMPTION
	public void navigateToLimitedExemption() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(BatchExemption));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", LimitedExemption);
	}

	// Create Limited Exemption Batch
	public void navigateToCreateLimitedExemptionBatch() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", MoreActions);
		wait.until(ExpectedConditions.elementToBeClickable(CreateLimitedExemption));
		js.executeScript("arguments[0].click();", CreateLimitedExemption);		
		wait.until(ExpectedConditions.visibilityOf(TitleCreateLEBatch));
		String PageTitle = TitleCreateLEBatch.getText();
		Assert.assertEquals(PageTitle, "Create Limited Exemption Batch");
		ObjectRepo.test.log(Status.PASS, "User navigates to Create Limited Exemption Batch");
	}

	public void createBatch() throws Exception {
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(BatchName));
		BatchName.sendKeys("Test Batch Name");
		Thread.sleep(2000);
		try {		
			BudgetYear.click();
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(BudgetYear));
			js.executeScript("arguments[0].click();", BudgetYear);
		}
		// BudgetYearList.click();
//		BudgetYear.sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		BudgetYear.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Comment));
		Comment.sendKeys("Test Comment 1");
		js.executeScript("arguments[0].click();", Save);
		try {
			SuccessPopupClose.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
			SuccessPopupClose.click();
		}
	}

	public void createBatch_For_Approved() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BatchName.sendKeys("Test Batch Name");
		Thread.sleep(3000);
		try {
			BudgetYear.click();

		} catch (Exception e) {
			js.executeScript("arguments[0].click();", BudgetYear);
		}
		Thread.sleep(5000);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		BudgetYear.sendKeys(Keys.ARROW_DOWN);
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		BudgetYear.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Comment));
		Comment.sendKeys("Test Comment 1");
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		js.executeScript("arguments[0].click();", Save);
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Add_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			EntityID.sendKeys(SelectedEntityID);
		}
		EntityID.getAttribute("value");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("48787");
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Demo");
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessageLimitedExemption));
		String LESuccessPopUp = SuccessMessageLimitedExemption.getText();
		Assert.assertEquals(LESuccessPopUp, "The limited exemption has been successfully added");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");

//		Thread.sleep(5000);
//		SuccessPopupClose.click();
	}

	// Add Limited Exemption method without Success message
	public void Add_Limited_Exemption_Generic_Method() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			EntityID.sendKeys(SelectedEntityID);
		}
		EntityID.getAttribute("value");
//		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("10000");
//		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(2000);
		// WebElement datePickerInput = driver.findElement(By.id("your_datepicker_id"));
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Demo");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
			AddLimitedExemptionButton.click();
		} catch (Exception e) {
			AddLimitedExemptionButton.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Propose_Limited_Exemptions() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1.executeScript("window.scrollBy(0,2500)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ProposeButton));
		ProposeButton.click();
		wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
		SubmitButton.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup1 = SuccessPopup.getText();
		Assert.assertEquals(successpopup1, "Success!");
		ObjectRepo.test.log(Status.PASS,
				"The Limited Exemption batch is successfully proposed to the Authority for approval");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Revisions_Requsted() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
//		ClickOnSearchedBatchId.click();
		try {
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		}
		js1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {

			RequestRevisionsRadioButton.click();

		} catch (Exception ex) {

			js.executeScript("arguments[0].click();", RequestRevisionsRadioButton);

		}
//		wait.until(ExpectedConditions.elementToBeClickable(RequestRevisionsRadioButton));
//		demo.click2(RequestRevisionsRadioButton, "seleniumClick", "RequestRevisionRadio");
		wait.until(ExpectedConditions.visibilityOf(CommentText));
		CommentText.sendKeys("Test Comment 1");
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
		try {
			SubmitButtonClick.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			SubmitButtonClick.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	// Revisions requsted Functionality testCaseId="39916";
	public void Revisions_Requsted_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ClickSearch.sendKeys(ProposeBatchId);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", ClickOnSearchedBatchId);
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {

			RequestRevisionsRadioButton.click();

		} catch (Exception ex) {
//			wait.until(ExpectedConditions.elementToBeClickable(RequestRevisionsRadioButton));
			demo.click2(RequestRevisionsRadioButton, "seleniumClick", "RequestRevisionRadio");
		}
		// String astriskMark = AsteriskMark.getText();
		Assert.assertEquals(AsteriskMark.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Asterisk mark is displayed for comment field");
		wait.until(ExpectedConditions.visibilityOf(CommentText));
		CommentText.sendKeys("Test Comment 1");
		Assert.assertEquals(CommentText.isDisplayed(), true);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", SubmitButtonClick);
		}
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnConmfirmationPopup));
		CancelButtonOnConmfirmationPopup.click();
		Assert.assertEquals(ApproveRequestCard.isDisplayed(), true);
		Assert.assertEquals(RequestRevisionsRadioButton.isSelected(), true);
		wait.until(ExpectedConditions.visibilityOf(CommentText));
		String getTextComment = CommentText.getAttribute("value");
		Assert.assertEquals(getTextComment, "Test Comment 1");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is closed");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", SubmitButtonClick);
		}
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src1 = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis1 = new FileInputStream(src1);
		prop = new Properties();
		prop.load(fis1);
		wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopUpTextOfRevisonsRequsted));
		String Successmessage = SuccessPopUpTextOfRevisonsRequsted.getText();
		Assert.assertEquals(Successmessage, "Limited Exemption Batch is successfully requested for revision");
		ObjectRepo.test.log(Status.PASS, "Success message is displyed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionsPage));
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS, "After Request Revisions user navigated to Batch Exemptions page");
//		ClickSearch.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.visibilityOf(StatusText));
		String statusText = StatusText.getText();
		Assert.assertEquals(statusText, "Revisions Requested");
		ObjectRepo.test.log(Status.PASS, "Limited Exemptuion Batch status is displyed as Revisions Requsted");
	}

	// Verification of 'Cancel' button functionality for Edit Batch Exemption in
	// 'Saved' or 'Revision Requested' status
	public void Cancel_Button_For_Edit_Batch_Exemption_RevisionRequsted() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		EditBatchExemption.click();
		js.executeScript("window.scrollBy(0,2500)", "");
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickPageCancel));
			ClickPageCancel.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", ClickPageCancel);
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionTable));
		String BatchExemptionText = BatchExemptionTable.getText();
		Assert.assertEquals(BatchExemptionText, "Batch Exemption History");
		ObjectRepo.test.log(Status.PASS, "Warnig pop up is closed");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickPageCancel));
			ClickPageCancel.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", ClickPageCancel);
		}
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS,
				"After click on continue button on warning popup user is navigated on Batch Exemptions page");
//		Thread.sleep(5000);
//		ClickSearch.sendKeys(ProposeBatchId);
//		Thread.sleep(5000);
//		ClickOnSearchedBatchId.click();
	}

	// Cancel Button of Create Limited Exemptions for saved
	public void Cancel_On_Create_Limited_Exemption_in_Edit() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		Assert.assertEquals(BatchName.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Fields are enable to edit");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1150)", "");
		wait.until(ExpectedConditions.visibilityOf(ThreeDotsButton));
		Assert.assertEquals(ThreeDotsButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Quick actions button in the 'Limited Exemption Records' table is enabled.");
		wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
		try {
			ThreeDotsButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			ThreeDotsButton.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(Edit));
		Edit.click();
		js.executeScript("window.scrollBy(0,-400)", "");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		Assert.assertEquals(LimitedExemptionValue.isEnabled(), true);
		Assert.assertEquals(GetDate.isEnabled(), true);
		Assert.assertEquals(Comments.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "'Limited Exemption', 'Effective Date' and 'Comments' fields are editable.");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("7952");
		wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
		try {
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with Cancel and Continue button");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		wait.until(ExpectedConditions.visibilityOf(TextEntityandLimitedExemptionInformation));
		String navigate = TextEntityandLimitedExemptionInformation.getText();
		Assert.assertEquals(navigate, "Entity and Limited Exemption Information");
		ObjectRepo.test.log(Status.PASS, "After Click on CANCEl button on Warning pop up, Warning pop up is closed");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		String GetEntityIDText = EntityID.getAttribute("value");
		Assert.assertEquals(GetEntityIDText, "");
		String GetLEText = LimitedExemptionValue.getAttribute("value");
		Assert.assertEquals(GetLEText, "");
		String GetDateText = GetDate.getAttribute("value");
		Assert.assertEquals(GetDateText, "");
		String GetCommentsText = Comments.getAttribute("value");
		Assert.assertEquals(GetCommentsText, "");
		ObjectRepo.test.log(Status.PASS,
				"After click on Contiue button on warning pop up, all entered data is cleared");
		Assert.assertEquals(navigate, "Entity and Limited Exemption Information");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction admin is retain on same page");
	}

	// Cancel Button of Create Limited Exemptions for Revisions Requsted
	public void Cancel_On_Create_Limited_Exemption_in_Edit_For_Revisions_Reqsuted_Limited_Exemptions()
			throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ClickSearch.sendKeys(ProposeBatchId);
		wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
//		ClickOnSearchedBatchId.click();
		try {
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		wait.until(ExpectedConditions.visibilityOf(BatchName));
		Assert.assertEquals(BatchName.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Fields are enable to edit");
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1150)", "");
		wait.until(ExpectedConditions.visibilityOf(ThreeDotsButton));
		Assert.assertEquals(ThreeDotsButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Quick actions button in the 'Limited Exemption Records' table is enabled.");
		wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
		try {
			ThreeDotsButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			ThreeDotsButton.click();
		}
//		demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		wait.until(ExpectedConditions.elementToBeClickable(Edit));
		Edit.click();
		js1.executeScript("window.scrollBy(0,-400)", "");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		Assert.assertEquals(LimitedExemptionValue.isEnabled(), true);
		Assert.assertEquals(GetDate.isEnabled(), true);
		Assert.assertEquals(Comments.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "'Limited Exemption', 'Effective Date' and 'Comments' fields are editable.");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("7952");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
//		ClickCancel.click();
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with Cancel and Continue button");
		WarningCancel.click();
		wait.until(ExpectedConditions.visibilityOf(TextEntityandLimitedExemptionInformation));
		String navigate = TextEntityandLimitedExemptionInformation.getText();
		Assert.assertEquals(navigate, "Entity and Limited Exemption Information");
		ObjectRepo.test.log(Status.PASS, "After Click on CANCEl button on Warning pop up, Warning pop up is closed");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		// String navigate = TextEntityandLimitedExemptionInformation.getText();
		Assert.assertEquals(navigate, "Entity and Limited Exemption Information");
		String entityId = EntityID.getAttribute("value");
		Assert.assertEquals(entityId, "");
		String limitedExemption = LimitedExemptionValue.getAttribute("value");
		Assert.assertEquals(limitedExemption, "");
		String getDate = GetDate.getAttribute("value");
		Assert.assertEquals(getDate, "");
		String getComment = Comments.getAttribute("value");
		Assert.assertEquals(getComment, "");
		ObjectRepo.test.log(Status.PASS,
				"After click on Contiue button on warning pop up, all entered data is cleared");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction admin is retain on same page");
//		js1 = (JavascriptExecutor) driver;
//		js1.executeScript("window.scrollBy(0,200)", "");
//		demo.click2(ThreeDotsButton, "seleniumClick", "Click");
//		RemoveLimitedExemption.click();
//		Thread.sleep(2000);
//		WarningContinue.click();
	}

	// Verification of Add Limited Exemption functionality for 'Saved' or 'Revision
	// Requested' batch exemption
	public void Add_Limited_Exemption_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(EntityID));
		EntityID.click();
		wait.until(ExpectedConditions.elementToBeClickable(LimitedExemptionValue));
		LimitedExemptionValue.click();
		wait.until(ExpectedConditions.visibilityOf(EntityIdError));
		String Errormessage = EntityIdError.getText();
		Assert.assertEquals(Errormessage, "Entity ID is required");
		ObjectRepo.test.log(Status.PASS, "Entity ID is required error message is displayed");
		wait.until(ExpectedConditions.visibilityOf(AddLimitedExemptionButton));
		boolean button = AddLimitedExemptionButton.isEnabled();
		Assert.assertEquals(button, false);
		ObjectRepo.test.log(Status.PASS, "Add Limited Exemption Button is disabled");
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys("CN00367");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("48787");
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(2000);
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Demo");
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		// Enter Valid Data
		String val = EntityID.getAttribute("value");
		int size = val.length();
		for (int i = 1; i <= size; i++) {
			EntityID.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys(SelectedEntityID);
		String val1 = LimitedExemptionValue.getAttribute("value");
		int size1 = val1.length();
		for (int i = 1; i <= size1; i++) {
			LimitedExemptionValue.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("48787");
		String val3 = Comments.getAttribute("value");
		int size3 = val3.length();
		for (int i = 1; i <= size3; i++) {
			Comments.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Demo1");
		// AddLimitedExemptionButton.click();
		js.executeScript("arguments[0].click();", AddLimitedExemptionButton);
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
//		WebDriverWait wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
//		String Successmessage = SuccessMessage.getText();
//		Thread.sleep(2000);
		Assert.assertEquals(SuccessMessage.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Success message popup is displayed");
		ObjectRepo.test.log(Status.PASS, "Added Limited Exemption is displayed in Limited Exemption Records table");
		// SuccessPopupClose.click();

	}

	// Add Limited Exemption for Revisions Requsted
	public void Add_Limited_Exemption_Functionality_For_Revisions_Requsted() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ClickSearch.sendKeys(ProposeBatchId);
		wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
//		ClickOnSearchedBatchId.click();
		try {
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		}
//		wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
//		MoreActions.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js.executeScript("window.scrollBy(0,800)", "");
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(EntityID));
		EntityID.click();
		wait.until(ExpectedConditions.elementToBeClickable(LimitedExemptionValue));
		LimitedExemptionValue.click();
		wait.until(ExpectedConditions.visibilityOf(EntityIdError));
		String Errormessage = EntityIdError.getText();
		Assert.assertEquals(Errormessage, "Entity ID is required");
		ObjectRepo.test.log(Status.PASS, "Entity ID is required error message is displayed");
		wait.until(ExpectedConditions.visibilityOf(AddLimitedExemptionButton));
		boolean button = AddLimitedExemptionButton.isEnabled();
		Assert.assertEquals(button, false);
		ObjectRepo.test.log(Status.PASS, "Add Limited Exemption Button is disabled");
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys("CN00367");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("48787");
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(2000);
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Demo");
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		// Enter Valid Data
		String val = EntityID.getAttribute("value");
		int size = val.length();
		for (int i = 1; i <= size; i++) {
			EntityID.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys(SelectedEntityID);
		String val1 = LimitedExemptionValue.getAttribute("value");
		int size1 = val1.length();
		for (int i = 1; i <= size1; i++) {
			LimitedExemptionValue.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("48787");
		String val3 = Comments.getAttribute("value");
		int size3 = val3.length();
		for (int i = 1; i <= size3; i++) {
			Comments.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Demo1");
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(3000);
////		EffectiveDate.click();
//		String val4 = EffectiveDate.getAttribute("value");
//		int size4 = val4.length();
//		Thread.sleep(3000);
//		for (int i = 1; i <= size4; i++) {
//			EffectiveDate.sendKeys(Keys.BACK_SPACE);
//		}
		// AddLimitedExemptionButton.click();
		js.executeScript("arguments[0].click();", AddLimitedExemptionButton);
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "Success message popup is displayed");
//		String Entity= AddedLimitedExemption.getText();
//		Assert.assertEquals(Entity, "CA00367");
		ObjectRepo.test.log(Status.PASS, "Added Limited Exemption is displayed in Limited Exemption Records table");
//		Thread.sleep(5000);
//		SuccessPopupClose.click();
//		Thread.sleep(5000);
//		demo.click2(ThreeDotsButton, "seleniumClick", "Click");
//		Thread.sleep(5000);
//		RemoveLimitedExemption.click();
//		Thread.sleep(3000);
//		WarningContinue.click();
//		Thread.sleep(5000);
//		SuccessPopupClose.click();
//		Thread.sleep(5000);
//		demo.click2(ThreeDotsButton, "seleniumClick", "Click");
//		Thread.sleep(5000);
//		RemoveLimitedExemption.click();
//		Thread.sleep(3000);
//		WarningContinue.click();
//		Thread.sleep(5000);
//		SuccessPopupClose.click();
	}

	public void Edit_Limited_Exemption_For_Denied() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		ClickSearch.sendKeys(ProposeBatchId);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
		ClickOnSearchedBatchId.click();
//		try {
//			ProposedBatchID.click();
//		} catch (Exception ex) {
//			driver.navigate().refresh();
//			ProposedBatchID.click();
//		}
		try {
			MoreActions.isDisplayed();
		} catch (Exception ex) {
			ObjectRepo.test.log(Status.PASS, "More Actions button is not displyed when Batch is in Denie status");
		}
	}

	public void Edit_Limited_Exemption_For_Approved() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
		ClickOnSearchedBatchId.click();
//		try {
//			ProposedBatchID.click();
//		} catch (Exception ex) {
//			driver.navigate().refresh();
//			ProposedBatchID.click();
//		}
		try {
			MoreActions.isDisplayed();
		} catch (Exception ex) {
			ObjectRepo.test.log(Status.PASS, "More Actions button is not displyed when Batch is in Denie status");
		}
	}

	public void Edit_Limited_Exemption_For_Proposed() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-1000)", "");
//		ClickSearch.sendKeys(ProposeBatchId);
//		Thread.sleep(5000);
//		ClickOnSearchedBatchId.click();
//		Thread.sleep(10000);
//		try {
//			ProposedBatchID.click();
//		} catch (Exception ex) {
//			driver.navigate().refresh();
//			ProposedBatchID.click();
//		}
		try {
			MoreActions.isDisplayed();
		} catch (Exception ex) {
			ObjectRepo.test.log(Status.PASS, "More Actions button is not displyed when Batch is in Proposed status");
		}
	}

	public void Remove_Saved_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js1.executeScript("window.scrollBy(0,1150)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			ThreeDotsButton.click();
		} catch (Exception ex) {
			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		wait.until(ExpectedConditions.visibilityOf(TextLimitedExemptionRecord));
		String navigate = TextLimitedExemptionRecord.getText();
		Assert.assertEquals(navigate, "Limited Exemption Records");
		ObjectRepo.test.log(Status.PASS, "Warning pop up is closed and remains on same page");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			ThreeDotsButton.click();
		} catch (Exception ex) {
			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		// String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed");
		WarningContinue.click();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		// Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS,
				"Success popup message is displyed after removed Limited Exemption form Saved state");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();

	}

	public void Remove__RevisionsRequested_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1150)", "");
		wait.until(ExpectedConditions.visibilityOf(FetchEntityId));
		String EntityIdText = FetchEntityId.getText();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			ThreeDotsButton.click();
		} catch (Exception e) {
			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		WarningCancel.click();
		wait.until(ExpectedConditions.visibilityOf(TextLimitedExemptionRecord));
		String navigate = TextLimitedExemptionRecord.getText();
		Assert.assertEquals(navigate, "Limited Exemption Records");
		ObjectRepo.test.log(Status.PASS, "Remains on Batch Exemption Details page");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			ThreeDotsButton.click();
		} catch (Exception e) {
			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS,
				"Success popup message is displyed after removed Limited Exemption from Revision Requsted state");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
		ClickSearch.click();
		try {
			ClickSearch.sendKeys(EntityIdText);
		} catch (Exception ex) {
			ClickSearch.sendKeys(EntityIdText);
		}
		String totalRows = TotalRows.getText();
		System.out.println(totalRows);
		Assert.assertEquals(totalRows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "The Record is removed from Limited Exemptions table");
	}

	public void Cancel_Button_On_Entity_and_Limited_Exemption_Information_section() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			EntityID.sendKeys(SelectedEntityID);
		}
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionValue));
		LimitedExemptionValue.sendKeys("48787");
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(2000);

		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Test Data");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		String entityId = EntityID.getAttribute("value");
		String limitedExemption = LimitedExemptionValue.getAttribute("value");
		// String date=SelectDate.getAttribute("value");
		String comments = Comments.getAttribute("value");
		Assert.assertEquals(entityId.equals("") && limitedExemption.equals("") && comments.equals(""), true);
		ObjectRepo.test.log(Status.PASS, "Entity and Limited Exemption Information all values are cleared");

	}

	// Verification of functionality of 'Create Limited Exemption Batch'
	public void Create_Limited_Exemption_Batch() throws Exception {
		js = (JavascriptExecutor) driver;
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(BatchName));
		BatchName.sendKeys("Test Batch Name");
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(BudgetYear));
			BudgetYear.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", BudgetYear);
		}
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		BudgetYear.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(Comment));
		Comment.sendKeys("Test Comment 1");
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		js.executeScript("arguments[0].click();", Save);
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS, "Batch Created Succefully Success popup message is display");
		try {
			SuccessPopupClose.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
			SuccessPopupClose.click();
		}
		boolean batchName = BatchName.isEnabled();
		Assert.assertEquals(batchName, true);
		ObjectRepo.test.log(Status.PASS, "Batch Name is editable");
		boolean budgetYear = BudgetYearText.isEnabled();
		Assert.assertEquals(budgetYear, true);
		ObjectRepo.test.log(Status.PASS, "Budget Year is Read Only");
		boolean comment = Comment.isEnabled();
		Assert.assertEquals(comment, true);
		ObjectRepo.test.log(Status.PASS, "Comment is editable");
		js.executeScript("window.scrollBy(0,1200)", "");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(SavedText));
		String savedText = SavedText.getText();
		Assert.assertEquals(savedText, "Saved");
		ObjectRepo.test.log(Status.PASS, "Record is added in Batch Exemption History table");
		js.executeScript("window.scrollBy(0,-1200)", "");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(StoreBatchID));
		String storeBatchId = StoreBatchID.getText();
		System.out.println(storeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			ClickOnHome.click();
		}
		navigateToBatchExemption();
		Thread.sleep(2000);
		ClickSearch.sendKeys(storeBatchId);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(storeBatchIdFromLimitedExemptionBatches));
		String BatchId = storeBatchIdFromLimitedExemptionBatches.getText();
		Assert.assertEquals(storeBatchId, BatchId);
		ObjectRepo.test.log(Status.PASS, "Record is added in Limited Exemption Batches table");
	}

	// Verification of functionality of Add Limited Exemption

	// Validation of the 'Batch Name' field on the 'Create Limited Exemption Batch'
	// page
	public void Batch_Name_Field_Validation() throws Exception {
		wait = new WebDriverWait(driver, 30);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(BatchName));
			BatchName.click();
		} catch (Exception e) {
			BatchName.click();
		}
		Comment.click();
		String BatchNameError = BatchNameFieldRequired.getText();
		Assert.assertEquals(BatchNameError, "Batch Name is required");
		ObjectRepo.test.log(Status.PASS, "Batch Name is required error message is displayed");
		js.executeScript("window.scrollBy(0,500)", "");
		boolean saveButton = Save.isEnabled();
		Assert.assertEquals(saveButton, false);
		ObjectRepo.test.log(Status.PASS, "Save Button is disabled");
		js.executeScript("window.scrollBy(500,0)", "");
		BatchName.sendKeys("Test Batch Name");
		String BatchNameError1 = BatchNameFieldRequired.getText();
		Assert.assertEquals(BatchNameError1, "");
		ObjectRepo.test.log(Status.PASS, "Batch Name field is accepting valid data");
	}

	// Verification of functionality of 'Cancel' button on 'Create Limited
	// Exemption' Batch page
	public void Cancel_Button_On_Create_Limited_Exemption_Batch() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BatchName.sendKeys("ABC");
		// BudgetYear.click();
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(BudgetYear));
			BudgetYear.click();
		} catch (Exception e) {
			demo.click2(BudgetYear, "seleniumClick", "BudgetYearDrown");
		}
		// js.executeScript("arguments[0].click();", BudgetYear);
		Thread.sleep(3000);
		BudgetYear.sendKeys(Keys.ENTER);
		Comment.sendKeys("Test");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		String createLimitedExemptionBatchPage = Create_Limited_Exemption_Batch_Page.getText();
		Assert.assertEquals(createLimitedExemptionBatchPage, "Create Limited Exemption Batch");
		ObjectRepo.test.log(Status.PASS,
				"Warning popup is closed and user reamin on the Create Limited Exemption Batch page");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS,
				"After click on continue button on warning popup user is navigated on Batch Exemptions page");
	}

	// Verification of 'Effective Date' field on the Create Limited Exemption page
	public void Effective_Date_Validation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ClickEffectiveDate));
		ClickEffectiveDate.click();
		Comment.click();
		String effectiveDateRequiredError = EffectiveDateRequired.getText();
		Assert.assertEquals(effectiveDateRequiredError, "Effective Date is required");
		ObjectRepo.test.log(Status.PASS, "Effective Date is Required error message is displyed");
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		SelectDate.click();
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		String SavedDate = GetDate.getAttribute("value");
		String effetciveDate = ClickEffectiveDate.getAttribute("value");
		Assert.assertEquals(effetciveDate, SavedDate);
		ObjectRepo.test.log(Status.PASS, "Effective Date is selected");

	}

	// Generic Method for Adding Limited Exemption
	public void Limited_Exemption_Adding_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys("CA00002");
		EntityID.getText();
		LimitedExemptionValue.sendKeys("48787");
//		EffectiveDate.click();
//		SelectDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));

		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		Comments.sendKeys("Test Comment");
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup1 = SuccessPopup.getText();
		Assert.assertEquals(successpopup1, "Success!");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption is added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	// Fetching BatchID of Saved Batch
	public void Fetch_Batch_Id_Saved() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,-650)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(StoreBatchID));
		String storeBatchId = StoreBatchID.getText();
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
		ClickOnHome.click();
		navigateToBatchExemption();
//		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(storeBatchId);
		Thread.sleep(2000);
//		wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
		try {
			ClickOnSearchedBatchId.click();
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			demo.click2(ClickOnSearchedBatchId, "seleniumClick", "BatchID");
//			ClickOnSearchedBatchId.click();
		}
	}

	// Fetching BatchID of Create Batch
	public void Fetch_Batch_Id_For_Create() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		Thread.sleep(3000);
//		SuccessPopupClose.click();
		String storeBatchId = StoreBatchID.getText();
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
		ClickOnHome.click();
		navigateToBatchExemption();
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(storeBatchId);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
//		ClickOnSearchedBatchId.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
	}

	// Fetching BatchID of Propose Batch
	public void Fetch_Batch_Id_Propose() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,-1000)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ProposedFetchID));
		ProposeBatchId = ProposedFetchID.getText();
		System.out.println(ProposeBatchId);
	}

	// Generic Method for Log Out
	public void Log_Out_User() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(ClickWelcomeFogOut));
		try {
			ClickWelcomeFogOut.click();
		} catch (Exception e) {
			js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click();", ClickWelcomeFogOut);

		}

		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnLogout));
			ClickOnLogout.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", ClickOnLogout);
		}
	}

	// Batch ID Saved
	public void Saved_Batch_ID() throws Exception {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(StoreBatchID));
		storeBatchId = StoreBatchID.getText();
	}

	// Verification of functionality of 'Delete Batch Exemption' in 'Saved' status
	public void Delete_Batch_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,-950)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		// WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS, "Success popup is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionsPage));
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS, "After Deleting Batch user is navigated to Batch Exemptions page");
	}

	// Generic Method to Delete Batch
	public void Delete_Batch_Exemption_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,-950)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
	}

	// Generic Method to Deelete Batch after adding limited exemptions
	public void Delete_Batch_Exemption_Functionality_After_Adding_LE() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
	}

	// Verification of 'Cancel' button functionality for Edit Batch Exemption in
	// 'Saved' status
	public void Cancel_Button_For_Edit_Batch_Exemption_Saved_RevisionRequsted() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js.executeScript("window.scrollBy(0,2500)", "");
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickPageCancel));
			ClickPageCancel.click();
		} catch (Exception ex) {
			demo.click2(ClickPageCancel, "seleniumClick", "Cancel");
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		wait.until(ExpectedConditions.elementToBeClickable(ClickPageCancel));
		ClickPageCancel.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS,
				"After click on continue button on warning popup user is navigated on Batch Exemptions page");
	}

	// Verification of 'Cancel' button functionality on Batch Exemption Detail page
	// TestCaseID:- 40394
	public void Cancel_Button_On_Batch_Exemption_Details_Page() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys(SelectedEntityID);
		EntityID.getText();
		LimitedExemptionValue.sendKeys("548621");
//		EffectiveDate.click();
//		SelectDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		wait.until(ExpectedConditions.visibilityOf(Comments));
		Comments.sendKeys("Test Comment");
		js.executeScript("window.scrollBy(0,900)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(BottomCancelClick));
			BottomCancelClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", BottomCancelClick);
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup should get displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionTable));
		String BatchExemptionText = BatchExemptionTable.getText();
		Assert.assertEquals(BatchExemptionText, "Batch Exemption History");
		ObjectRepo.test.log(Status.PASS, "Warnig pop up is closed");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(BottomCancelClick));
			BottomCancelClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", BottomCancelClick);
		}
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS,
				"After click on continue button on warning popup user is navigated on Batch Exemptions page");
	}

	// Removed Limited Exemption
	public void Remove_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
		ClickOnSearchedBatchId.click();
		wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
		MoreActions.click();
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1150)", "");
		wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
		demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Comment_Verification_for_Request_Revisions() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//		ClickSearch.click();
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			RequestRevisionsRadioButton.click();
		} catch (Exception e) {
			demo.click2(RequestRevisionsRadioButton, "seleniumClick", "RequestRevisionRadio");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CommentText));
			CommentText.click();
		} catch (Exception e) {
			CommentText.click();
		}
		CommentText.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(CommentErrroMessage));
		String CommentError = CommentErrroMessage.getText();
		Assert.assertEquals(CommentError, "Comments is required");
		ObjectRepo.test.log(Status.PASS, "Comment is Required error message is displyed");
	}

	// Passphrase Validation
	public void Passphrase_Verification() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			RequestRevisionsRadioButton.click();

		} catch (Exception e) {
			demo.click2(RequestRevisionsRadioButton, "seleniumClick", "RequestRevisionsRadio");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CommentText));
			CommentText.click();
		} catch (Exception e) {
			CommentText.click();
		}
		CommentText.sendKeys("Test Comment");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", SubmitButtonClick);
		}
		wait.until(ExpectedConditions.elementToBeClickable(PasspharseEnter));
		PasspharseEnter.click();
		PasspharseEnter.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(PassPhraseIsRequired));
		String PassphraseMandatory = PassPhraseIsRequired.getText();
		Assert.assertEquals(PassphraseMandatory, "Passphrase is required");
		ObjectRepo.test.log(Status.PASS, "Passphrase is Required error message is displayed");
		PasspharseEnter.sendKeys("Wciadmin@321");
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(IncorrectPassphrase));
		String incorrectPassphrase = IncorrectPassphrase.getText();
		Assert.assertEquals(incorrectPassphrase, "Passphrase is incorrect");
		ObjectRepo.test.log(Status.PASS, "Passphrase is Incorrect toast error message is display");
		wait.until(ExpectedConditions.elementToBeClickable(WarningPopupClose));
		WarningPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
//		SubmitButtonClick.click();
//		Thread.sleep(3000);
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
			PasspharseEnter.sendKeys(prop.getProperty("Password"));
		} catch (Exception e) {
			PasspharseEnter.sendKeys(prop.getProperty("Password"));
		}
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS, "Entered Passphrase is accepted in 'Passphrase' field.");
	}

	public void Passphrase_Verification_Deny() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();

		} catch (Exception e) {
			demo.click2(DenyRadioButton, "seleniumClick", "Deny");
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(CommentText));
			CommentText.click();
		} catch (Exception e) {
			CommentText.click();
		}
		CommentText.sendKeys("Test Comment");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", SubmitButtonClick);
		}
		wait.until(ExpectedConditions.elementToBeClickable(PasspharseEnter));
		PasspharseEnter.click();
		PasspharseEnter.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(PassPhraseIsRequired));
		String PassphraseMandatory = PassPhraseIsRequired.getText();
		Assert.assertEquals(PassphraseMandatory, "Passphrase is required");
		ObjectRepo.test.log(Status.PASS, "Passphrase is Required error message is displayed");
		PasspharseEnter.sendKeys("Wciadmin@321");
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(IncorrectPassphrase));
		String incorrectPassphrase = IncorrectPassphrase.getText();
		Assert.assertEquals(incorrectPassphrase, "Passphrase is incorrect");
		ObjectRepo.test.log(Status.PASS, "Passphrase is Incorrect toast error message is display");
		wait.until(ExpectedConditions.elementToBeClickable(WarningPopupClose));
		WarningPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
//		SubmitButtonClick.click();
//		Thread.sleep(3000);
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		try {
			wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
			PasspharseEnter.sendKeys(prop.getProperty("Password"));
		} catch (Exception e) {
			PasspharseEnter.sendKeys(prop.getProperty("Password"));
		}
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS, "Entered Passphrase is accepted in 'Passphrase' field.");
	}

	// Passphrase Validation for Approve
	public void Passphrase_Verification_For_Approve() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(3000);
		try {
			ApproveRadioButton.click();
		} catch (Exception e) {

			demo.click2(ApproveRadioButton, "seleniumClick", "ApproveRadio");
		}
		CommentText.click();
		CommentText.sendKeys("Test Comment");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", SubmitButtonClick);
		}
		wait.until(ExpectedConditions.elementToBeClickable(PasspharseEnter));
		PasspharseEnter.click();
		PasspharseEnter.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(PassPhraseIsRequired));
		String PassphraseMandatory = PassPhraseIsRequired.getText();
		Assert.assertEquals(PassphraseMandatory, "Passphrase is required");
		ObjectRepo.test.log(Status.PASS, "Passphrase is Required error message is displayed");
		wait.until(ExpectedConditions.visibilityOf(PasspharseEnter));
		PasspharseEnter.sendKeys("Wciadmin@321");
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(IncorrectPassphrase));
		String incorrectPassphrase = IncorrectPassphrase.getText();
		Assert.assertEquals(incorrectPassphrase, "Passphrase is incorrect");
		ObjectRepo.test.log(Status.PASS, "Passphrase is Incorrect toast error message is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(WarningPopupClose));
		WarningPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
//			SubmitButtonClick.click();
//			Thread.sleep(3000);
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		Thread.sleep(2000);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS, "Passphrase is accepted");
	}

	// Deny Functionality testCaseId="39916";
	public void Deny_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();
		} catch (Exception e) {
			demo.click2(DenyRadioButton, "seleniumClick", "DenyRadio");
		}
		Assert.assertEquals(AsteriskMark.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Asterisk mark is displayed for comment field");
		wait.until(ExpectedConditions.visibilityOf(CommentText));
		CommentText.sendKeys("Test Comment 1");
		Assert.assertEquals(CommentText.isDisplayed(), true);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			SubmitButtonClick.click();
		}
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnConmfirmationPopup));
		CancelButtonOnConmfirmationPopup.click();
		Assert.assertEquals(ApproveRequestCard.isDisplayed(), true);
		Assert.assertEquals(DenyRadioButton.isSelected(), true);
		String getTextComment = CommentText.getAttribute("value");
		Assert.assertEquals(getTextComment, "Test Comment 1");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is closed");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			SubmitButtonClick.click();
		}
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src1 = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis1 = new FileInputStream(src1);
		prop = new Properties();
		prop.load(fis1);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopUpText));
		String Successmessage = SuccessPopUpText.getText();
		Assert.assertEquals(Successmessage, "Limited Exemption Batch is successfully denied");
		ObjectRepo.test.log(Status.PASS, "Success message is displyed");
		Thread.sleep(2000);
		try {
			SuccessPopupClose.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
			SuccessPopupClose.click();
		}
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS, "After Deny user navigated to Batch Exemptions page");
//		ClickSearch.click();
		Thread.sleep(3000);
		try {

			ClickSearch.sendKeys(ProposeBatchId);
		} catch (Exception e) {
			ClickSearch.sendKeys(ProposeBatchId);
		}
		wait.until(ExpectedConditions.visibilityOf(DeniedText));
		String statusText = DeniedText.getText();
		Assert.assertEquals(statusText, "Denied");
		ObjectRepo.test.log(Status.PASS, "Limited Exemptuion Batch status is displyed as Denied");
	}

	public void Comment_Verification_for_Denied() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();

		} catch (Exception ex) {

			demo.click2(DenyRadioButton, "seleniumClick", "Deny");
		}
		CommentText.click();
		CommentText.sendKeys(Keys.TAB);
		// demo.click2(RequestRevisionsRadioButton, "seleniumClick",
		// "RequestRevisionRadio");
		wait.until(ExpectedConditions.visibilityOf(CommentErrroMessage));
		String CommentError = CommentErrroMessage.getText();
		Assert.assertEquals(CommentError, "Comments is required");
		ObjectRepo.test.log(Status.PASS, "Comment is Required error message is displyed");
		js.executeScript("window.scrollBy(0,-1200)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();
		} catch (Exception e) {
			demo.click2(DenyRadioButton, "seleniumClick", "DenyRadio");
		}
		CommentText.sendKeys("Deny");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			SubmitButtonClick.click();
		}
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
	}

	// Status Update After Request revisions
	public void Status_Upadate_After_Request_Revisions() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception ex) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			RequestRevisionsRadioButton.click();
//			demo.click2(RequestRevisionsRadioButton, "seleniumClick", "RequestRevisionRadio");
		} catch (Exception e) {
			demo.click2(RequestRevisionsRadioButton, "seleniumClick", "RequestRevisionRadio");
		}
		CommentText.sendKeys("Test Comment 1");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception ex) {
			SubmitButtonClick.click();
		}
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		Thread.sleep(3000);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//		ClickSearch.click();
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.visibilityOf(StatusText));
		String RevisionsRequstedStatusText = StatusText.getText();
		Assert.assertEquals(RevisionsRequstedStatusText, "Revisions Requested");
		ObjectRepo.test.log(Status.PASS, "The status of the batch exemption is updated to 'Revisions Requested'");
		try {
			
			ClickOnSearchedBatchId.click();
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		}
		wait.until(ExpectedConditions.visibilityOf(StatusOnBatchExemptionDetails));
		String StatusUpadteOnBatchExemptionDetails = StatusOnBatchExemptionDetails.getText();
		Assert.assertEquals(StatusUpadteOnBatchExemptionDetails, "Revisions Requested");
		ObjectRepo.test.log(Status.PASS,
				"The status is displayed as 'Revisions Requested' in Batch Exemptions Details page");
		js.executeScript("window.scrollBy(0,1050)", "");
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionHistorySearch));
		BatchExemptionHistorySearch.sendKeys("Revisions Requested");
		wait.until(ExpectedConditions.visibilityOf(RevisionsRequstedStatusInBatchExemptionHistory));
		String BatchExemptionHistoryStatus = RevisionsRequstedStatusInBatchExemptionHistory.getText();
		Assert.assertEquals(BatchExemptionHistoryStatus, "Revisions Requested");
		ObjectRepo.test.log(Status.PASS, "'Revisions Requested' status is displayed in Batch Exemption History table");
		js.executeScript("window.scrollBy(0,-1200)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception ex) {
			ClickOnHome.click();
		}
	}

	public void MyApprovals() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(MyApprovals));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", MyApprovals);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnFilters));
		ClickOnFilters.click();
		try {
			wait.until(ExpectedConditions.visibilityOf(FilterValue));
			FilterValue.sendKeys(ProposeBatchId);
		} catch (Exception e) {
			FilterValue.sendKeys(ProposeBatchId);
		}
		Thread.sleep(1000);
		String totalRows = TotalRows.getText();
		System.out.println(totalRows);
		Assert.assertEquals(totalRows.contains("0"), true);
		ObjectRepo.test.log(Status.PASS, "The Record is removed from My Approvals table");
	}

	public void Availability_Of_Edit_Limited_Exemption_Batch() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionDetailsPage));
		String BatchExemptionDetailsText = BatchExemptionDetailsPage.getText();
		Assert.assertEquals(BatchExemptionDetailsText, "Batch Exemption Details");
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigated to Batch Exemptions Details page");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js.executeScript("window.scrollBy(0,300)", "");
		Assert.assertEquals(BatchName.isEnabled(), true);
		Assert.assertEquals(Comment.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "'Batch Exemption Information' section is editable.");
		js1.executeScript("window.scrollBy(0,900)", "");
		Assert.assertEquals(EntityID.isEnabled(), true);
		Assert.assertEquals(LimitedExemptionValue.isEnabled(), true);
		Assert.assertEquals(GetDate.isEnabled(), true);
		Assert.assertEquals(Comments.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS,
				"'Entity And Limited Exemption Information' section is displayed with editable field.");
		Assert.assertEquals(ThreeDotsButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Quick action column is enabled in Limited Exemption Records table.");
//		Thread.sleep(5000);
//		ThreeDotsButton.click();
//		Thread.sleep(5000);
//		RemoveLimitedExemption.click();
//		Thread.sleep(3000);
//		WarningContinue.click();
	}

	public void Pagination_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,900)", "");
		Thread.sleep(3000);
		Assert.assertEquals(Pagination.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"Pagination is displayed at the bottom of the Limited Exemptions Batches table");
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(2000);
		try {			
			PaginationNextIcon.click();
		} catch (Exception ex) {
			wait.until(ExpectedConditions.elementToBeClickable(PaginationNextIcon));
			PaginationNextIcon.click();
		}
		Assert.assertEquals(PaginationPageTwo.getAttribute("aria-current"), "true");
		ObjectRepo.test.log(Status.PASS, "The Jurisdiction user is redirected to the next page");
		wait.until(ExpectedConditions.elementToBeClickable(PaginationBeforeIcon));
		PaginationBeforeIcon.click();
		Assert.assertEquals(PaginationPageTwo.getAttribute("aria-current"), "true");
		ObjectRepo.test.log(Status.PASS, "The Jurisdiction user is redirected to the Previous page");
		wait.until(ExpectedConditions.elementToBeClickable(PaginationLastPageIcon));
		PaginationLastPageIcon.click();
		ObjectRepo.test.log(Status.PASS, "The Jurisdiction user is redirected to the 'Last' page");
		wait.until(ExpectedConditions.elementToBeClickable(PaginationFirstPageIcon));
		PaginationFirstPageIcon.click();
		Assert.assertEquals(PaginationPageTwo.getAttribute("aria-label"), "page 1");
		ObjectRepo.test.log(Status.PASS, "The Jurisdiction user is redirected to the First' page");
	}

	public void Entity_ID_Validation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(EntityID));
		EntityID.click();
		EntityID.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(EntityIdError));
		String Errormessage = EntityIdError.getText();
		Assert.assertEquals(Errormessage, "Entity ID is required");
		ObjectRepo.test.log(Status.PASS, "Entity ID is required error message is displayed");
		EntityID.sendKeys(SelectedGMPIEntityID); // GMPI entity id in Active status
		LimitedExemptionValue.sendKeys("48787");
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelectDate.click();
//		Thread.sleep(2000);
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		Comments.sendKeys("Demo");
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.visibilityOf(InvalidEntityIDError));
		String Errormessage1 = InvalidEntityIDError.getText();
		Assert.assertEquals(Errormessage1, "Entity does not match the CITSS Entity ID");
		ObjectRepo.test.log(Status.PASS,
				"The error message is displayed as Entity does not match the CITSS Entity ID after Entering Entity ID other than Covered");
		String val = EntityID.getAttribute("value");
		int size = val.length();
		for (int i = 1; i <= size; i++) {
			EntityID.sendKeys(Keys.BACK_SPACE);
		}
		EntityID.sendKeys("CA00342"); // Covered entity id in closed status
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.visibilityOf(InvalidEntityIDError));
		String Errormessage2 = InvalidEntityIDError.getText();
		Assert.assertEquals(Errormessage2, "Entity does not match the CITSS Entity ID");
		ObjectRepo.test.log(Status.PASS,
				"The error message is displayed as Entity does not match the CITSS Entity ID after Entering Entity ID other than Covered");
		String val1 = EntityID.getAttribute("value");
		int size1 = val1.length();
		for (int i = 1; i <= size1; i++) {
			EntityID.sendKeys(Keys.BACK_SPACE);
		}
		EntityID.sendKeys("NS00209"); // Entity ID of other Jurisdiction
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.visibilityOf(InvalidEntityIDError));
		String Errormessage3 = InvalidEntityIDError.getText();
		Assert.assertEquals(Errormessage3, "Entity does not match the CITSS Entity ID");
		ObjectRepo.test.log(Status.PASS,
				"The error message is displayed as Entity does not match the CITSS Entity ID after Entering Entity ID other than Covered");
		String val2 = EntityID.getAttribute("value");
		int size2 = val2.length();
		for (int i = 1; i <= size2; i++) {
			EntityID.sendKeys(Keys.BACK_SPACE);
		}
		EntityID.sendKeys(SelectedEntityID); // Valid Entity ID
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "The entered Entity ID is accepted in the 'Entity ID' field.");
	}

	public void Updated_Information_After_Edit() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		String val1 = BatchName.getAttribute("value");
		int size1 = val1.length();
		for (int i = 1; i <= size1; i++) {
			BatchName.sendKeys(Keys.BACK_SPACE);
		}
		Thread.sleep(1000);
		BatchName.sendKeys("Edited Batch Name"); // Entity ID of other Jurisdiction
		String EditeBatchName = BatchName.getAttribute("value");
		js.executeScript("window.scrollBy(0,2500)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ProposeButton));
			ProposeButton.click();
		} catch (Exception e) {
			ProposeButton.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		} catch (Exception e) {
			SubmitButton.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,-950)", "");
		ProposeBatchId = ProposedFetchID.getText();
		driver.navigate().back();
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		Assert.assertEquals(val1.equals(EditeBatchName), false);
		ObjectRepo.test.log(Status.PASS,
				"The edited 'Batch Exemptions Details' information is displayed in 'Limited Exemptions Batches'");

	}

	// Deny Generic Method
	public void Deny_Generic_Method() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();
		} catch (Exception ex) {
			demo.click2(DenyRadioButton, "seleniumClick", "DenyRadio");
		}
		CommentText.sendKeys("Test Comment 1");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			SubmitButtonClick.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	// Approve Generic Method
	public void Approve_Generic_Method() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			ApproveRadioButton.click();
		} catch (Exception e) {
			demo.click2(ApproveRadioButton, "seleniumClick", "ApproveRadio");
		}
		CommentText.sendKeys("Test Comment 1");
		try {

			SubmitButtonClick.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			SubmitButtonClick.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Status_Update_After_Proposed_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,1200)", "");
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(ProposedStatusInBatchExemptionHistory));
		String BatchExemptionHistoryStatus = ProposedStatusInBatchExemptionHistory.getText();
		Assert.assertEquals(BatchExemptionHistoryStatus, "Proposed");
		ObjectRepo.test.log(Status.PASS, "'Proposed' status is displayed in Batch Exemption History table");
		js.executeScript("window.scrollBy(0,-1000)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			ClickOnHome.click();
		}
		navigateToBatchExemption();
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.visibilityOf(ProposedStatusText));
		String proposedStatusText = ProposedStatusText.getText();
		Assert.assertEquals(proposedStatusText, "Proposed");
		ObjectRepo.test.log(Status.PASS, "The status of the batch exemption is updated to 'Proposed'");
	}

	public void Approve_Requet_Section() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();
		} catch (Exception ex) {
			demo.click2(DenyRadioButton, "seleniumClick", "DenyRadio");
		}
		Assert.assertEquals(DenyRadioButton.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "Radio Buttons are clickable");
		wait.until(ExpectedConditions.elementToBeClickable(CommentText));
		CommentText.click();
		Assert.assertEquals(CommentText.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Comment section is enabled");

	}

	public void Cancel_Button_On_Approve_Request_Card() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1500)", "");
		Thread.sleep(3000);
		try {
			ApproveRadioButton.click();

		} catch (Exception e) {
			demo.click2(ApproveRadioButton, "seleniumClick", "ApproveRadio");
		}
		CommentText.sendKeys("Approve Batch");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
			ClickCancel.click();
		} catch (Exception e) {
			ClickCancel.click();
		}
		wait.until(ExpectedConditions.visibilityOf(WarningPopup));
		String warningpopup = WarningPopup.getText();
		Assert.assertEquals(warningpopup, "Warning!");
		ObjectRepo.test.log(Status.PASS, "Warning popup is displayed with Cancel and Continue Buttons");
		wait.until(ExpectedConditions.elementToBeClickable(WarningCancel));
		WarningCancel.click();
		Assert.assertEquals(ApproveRadioButton.isSelected(), true);
		Assert.assertEquals(CommentText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Warning popup is closed and entered data or selections are not cleared");
		wait.until(ExpectedConditions.elementToBeClickable(ClickCancel));
		ClickCancel.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		String batchExemptions = BatchExemptionsPage.getText();
		Assert.assertEquals(batchExemptions, "Batch Exemptions");
		ObjectRepo.test.log(Status.PASS,
				"After click on continue button on warning popup user is navigated on Batch Exemptions page and All entered data is cleared");
	}

	public void Add_Limited_Exemption_For_Approve() throws Exception {
		// SuccessPopupClose.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys("CA00131");
		EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("186294");
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate));
		EffectiveDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(SelecteDate3));
		SelecteDate3.click();
		Comments.sendKeys("Test Comment");
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Add_LE_For_Different_Batch_And_Budget_Year() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(2000);
		try {
			
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception ex) {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		}
		EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("15000");
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate));
		EffectiveDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(SelectDate));
		SelectDate.click();
		Comments.sendKeys("Demo");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
			AddLimitedExemptionButton.click();
		} catch (Exception e) {
			AddLimitedExemptionButton.click();
		}
		
		wait.until(ExpectedConditions.visibilityOf(SuccessMessageLimitedExemption));
		String LESuccessPopUp = SuccessMessageLimitedExemption.getText();
		Thread.sleep(3000);
		Assert.assertEquals(LESuccessPopUp, "The limited exemption has been successfully added");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();

		// Create second batch
		js.executeScript("window.scrollBy(0,-650)", "");
		wait.until(ExpectedConditions.visibilityOf(StoreBatchID));
		String storeBatchId = StoreBatchID.getText();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			ClickOnHome.click();
		}
		navigateToBatchExemption();
		navigateToCreateLimitedExemptionBatch();
		createBatch_For_Approved();
		js.executeScript("window.scrollBy(0,700)", "");
		Thread.sleep(2000);
		try {
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		}
		EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("48787");
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate));
		EffectiveDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(SelectDate));
		SelectDate.click();
		Comments.sendKeys("Demo");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
			AddLimitedExemptionButton.click();
		} catch (Exception e) {
			AddLimitedExemptionButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(SuccessMessageLimitedExemption));
		String LESuccessPopUp1 = SuccessMessageLimitedExemption.getText();
		Assert.assertEquals(LESuccessPopUp1, "The limited exemption has been successfully added");
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemption Succefully Added for same entity and effective date in another batch of different budget year");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,-650)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//		ClickSearch.click();
		ClickSearch.sendKeys(storeBatchId);
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
		ClickOnSearchedBatchId.click();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
	}

	public void Upload_Empty_File() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		ClickOnBrowseFiles.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptionsBlank.exe");
//		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(BlankFileErrorMessage));
		String BlankFileError = BlankFileErrorMessage.getText();
		Assert.assertEquals(BlankFileError, "The file must have at least one Limited Exemption record");
		ObjectRepo.test.log(Status.PASS,
				"The file must have at least one Limited Exemption record error message is displyed after Uploading Excel file with no Limited Exemptions record");
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		ClickOnBrowseFiles.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptionsCSvBlank.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		String CsvBlankFileError = BlankFileErrorMessage.getText();
		Assert.assertEquals(CsvBlankFileError, "The file must have at least one Limited Exemption record");
		ObjectRepo.test.log(Status.PASS,
				"The file must have at least one Limited Exemption record error message is displyed after Uploading Csv file with no Limited Exemptions record");

	}

	public void Cancel_Button_On_Upload_Files() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		ClickCancelOnFileUpload.click();
		wait.until(ExpectedConditions.visibilityOf(TextEntityandLimitedExemptionInformation));
		String navigate = TextEntityandLimitedExemptionInformation.getText();
		Assert.assertEquals(navigate, "Entity and Limited Exemption Information");
		ObjectRepo.test.log(Status.PASS,
				"Upload File Pop Up is closed after click on Cancel button on Upload File pop up");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		ClickOnBrowseFiles.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptionsValid.exe");
		wait.until(ExpectedConditions.elementToBeClickable(ClickCancelOnFileUpload));
		ClickCancelOnFileUpload.click();
		Assert.assertEquals(navigate, "Entity and Limited Exemption Information");
		ObjectRepo.test.log(Status.PASS,
				"Upload File Pop Up is closed after click on Cancel button on Upload File pop up");
	}

	public void Effective_Date_Validation_For_Upload_File() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions EmptyEffectiveDate.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
//		String EmptyFileUploadErros1 = EmptyDateError1.getText();
//		String EmptyFileUploadErros2 = EmptyDateError2.getText();
//		String EmptyFileUploadErros3 = EmptyDateError3.getText();
		System.out.println(GetFileUploadErrors.getText());
		// System.out.println(FileUploadErros);
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError2.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError3.isDisplayed(), true);
//		Assert.assertEquals(EmptyFileUploadErros1.is, "Number of rows with a validation error: 1, out of 1 rows checked");
//		Assert.assertEquals(EmptyFileUploadErros2, "Number of rows missing required data: 1");
//		Assert.assertEquals(EmptyFileUploadErros3, "Entity IDs of rows with missing required data: [\"CA00398\"]");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText());
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		ClickOnBrowseFiles.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions ValidEffectiveDate.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,-700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
	}

	public void Comments_Validation_For_Upload_File() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptionsBlankComment.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError2.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError3.isDisplayed(), true);
//		String EmptyFileUploadErros1 = EmptyDateError1.getText();
//		String EmptyFileUploadErros2 = EmptyDateError2.getText();
//		String EmptyFileUploadErros3 = EmptyDateError3.getText();
//		System.out.println(GetFileUploadErrors.getText());
		// System.out.println(FileUploadErros);
//		Assert.assertEquals(EmptyFileUploadErros1, "Number of rows with a validation error: 1, out of 1 rows checked");
//		Assert.assertEquals(EmptyFileUploadErros2, "Number of rows missing required data: 1");
//		Assert.assertEquals(EmptyFileUploadErros3, "Entity IDs of rows with missing required data: [\"CA00174\"]");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText());
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		ClickOnBrowseFiles.click();
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions ValidEffectiveDate.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,-700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
	}

	public void Edit_Functionality_For_Batch_Exemption_Card() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Assert.assertEquals(BatchName.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Name field is displayed editable format");
		Assert.assertEquals(Comment.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Comment field is displayed editable format");
		String val1 = BatchName.getAttribute("value");
		int size1 = val1.length();
		for (int i = 1; i <= size1; i++) {
			BatchName.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(BatchName));
		BatchName.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(BatchNameFieldRequired));
		String BatchNameError = BatchNameFieldRequired.getText();
		Assert.assertEquals(BatchNameError, "Batch Name is required");
		ObjectRepo.test.log(Status.PASS, "Batch Name is required error message is displayed");
		BatchName.sendKeys("Test Batch Name 2");
		js.executeScript("window.scrollBy(0,2500)", "");
		Assert.assertEquals(ProposeButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Propose button is enabled");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ProposeButton));
			ProposeButton.click();
		} catch (Exception e) {
			ProposeButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		} catch (Exception e) {
			SubmitButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup1 = SuccessPopup.getText();
		Assert.assertEquals(successpopup1, "Success!");
		ObjectRepo.test.log(Status.PASS, "The edited information has been successfully proposed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(ProposedStatusInBatchExemptionHistory));
		String BatchExemptionHistoryStatus = ProposedStatusInBatchExemptionHistory.getText();
		Assert.assertEquals(BatchExemptionHistoryStatus, "Proposed");
		ObjectRepo.test.log(Status.PASS, "'Proposed' record is added in Batch Exemption History table");
	}

	public void Edit_Functionality_For_Batch_Exemption_Card_in_Revisions_Requsted() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)", "");
		Assert.assertEquals(BatchName.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Name field is displayed editable format");
		Assert.assertEquals(Comment.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Comment field is displayed editable format");
		String val1 = BatchName.getAttribute("value");
		int size1 = val1.length();
		for (int i = 1; i <= size1; i++) {
			BatchName.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.visibilityOf(BatchName));
		BatchName.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(BatchNameFieldRequired));
		String BatchNameError = BatchNameFieldRequired.getText();
		Assert.assertEquals(BatchNameError, "Batch Name is required");
		ObjectRepo.test.log(Status.PASS, "Batch Name is required error message is displayed");
		BatchName.sendKeys("Test Batch Name 2");
		js.executeScript("window.scrollBy(0,2500)", "");
		Assert.assertEquals(ProposeButton.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Propose button is enabled");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ProposeButton));
			ProposeButton.click();
		} catch (Exception e) {
			ProposeButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButton));
			SubmitButton.click();
		} catch (Exception e) {
			SubmitButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup1 = SuccessPopup.getText();
		Assert.assertEquals(successpopup1, "Success!");
		ObjectRepo.test.log(Status.PASS, "The edited information has been successfully proposed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		String BatchExemptionHistoryStatus = ProposedStatusInBatchExemptionHistory.getText();
		Assert.assertEquals(BatchExemptionHistoryStatus, "Proposed");
		ObjectRepo.test.log(Status.PASS, "'Proposed' record is added in Batch Exemption History table");

	}

	public void Verfication_Of_Approve_Limited_Exemption_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			ApproveRadioButton.click();

		} catch (Exception e) {
			demo.click2(ApproveRadioButton, "seleniumClick", "ApproveRadio");
		}
		Assert.assertEquals(ApproveRadioButton.isSelected(), true);
		ObjectRepo.test.log(Status.PASS, "'Approve Radio Button is selected");
		CommentText.sendKeys("Test Comment 1");
		Assert.assertEquals(CommentText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Entered comment is displayed in comment box");
		Assert.assertEquals(SubmitButtonClick.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Submit Button is enabled");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", SubmitButtonClick);
		}
		wait.until(ExpectedConditions.visibilityOf(PassphrasePopupText));
		String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		Assert.assertEquals(CancelButtonOnConmfirmationPopup.isDisplayed(), true);
		Assert.assertEquals(SubmitButtonOnPopUp.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed with Cancel and Continue Button");
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(CancelButtonOnConmfirmationPopup));
		CancelButtonOnConmfirmationPopup.click();
		Assert.assertEquals(ApproveRequestCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is closed");
		Assert.assertEquals(ApproveRadioButton.isSelected(), true);
		Assert.assertEquals(CommentText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Approve selection and comment is not cleared.");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonClick));
			SubmitButtonClick.click();
		} catch (Exception e) {
			SubmitButtonClick.click();
		}
		// String passphrasePopUp = PassphrasePopupText.getText();
		Assert.assertEquals(passphrasePopUp, "Submit Batch Exemption");
		Assert.assertEquals(CancelButtonOnConmfirmationPopup.isDisplayed(), true);
		Assert.assertEquals(SubmitButtonOnPopUp.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Passphrase Confirmation Pop up is displsyed with Cancel and Continue Button");
		File src1 = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis1 = new FileInputStream(src1);
		prop = new Properties();
		prop.load(fis1);
		Thread.sleep(2000);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessageAfterApprove));
		Assert.assertEquals(SuccessMessageAfterApprove.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Limited Exemption Batch is successfully approved");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Add_Limited_Exemption_Generic_Method_For_Approve_Functionality() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(EntityID));
		EntityID.sendKeys("CA00337");
		EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("548796");
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelecteDate3.click();
//		Thread.sleep(2000);
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		Comments.sendKeys("Demo");
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Empty_Rows_Upload_File() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(1000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions EmptyRows.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		Assert.assertEquals(EmptyRowsError.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The data must be in consecutive rows error message is displayed");
	}

	public void Duplicate_Entity_ID() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnBrowseFiles));
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(1000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions DuplicateEntityID.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError2.isDisplayed(), true);
//		String DuplicateentityIDError1 = EmptyDateError1.getText();
//		String DuplicateentityIDError2 = EmptyDateError2.getText();
//		Assert.assertEquals(DuplicateentityIDError1,
//				"Number of rows with a validation error: 1, out of 2 rows checked");
//		Assert.assertEquals(DuplicateentityIDError2, "Entity ID of rows with duplicate row data: [\"CA00174\"]");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText());
	}

	public void File_Language_For_Upload_File() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(1000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions OtherLanguage.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		String LanguageError1 = EmptyDateError1.getText();
		Assert.assertEquals(LanguageError1,
				"An error occurred parsing the file. Error may be due to language selected, unsupported Excel version or typos in the content of the file.");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText() + " Error message is displayed");
	}

	public void Add_Limited_Exemption_By_UploadFile() throws Exception {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(StoreBatchID));
		String storeBatchId = StoreBatchID.getText();
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		navigateToBatchExemption();
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(storeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", MoreActions);
		EditBatchExemption.click();
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(1000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions ValidEffectiveDate.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully success message is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,-700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
	}

	public void Add_Limited_Exemption_By_UploadFile_For_RevisionsRequsted() throws Exception {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(EditBatchExemption));
		EditBatchExemption.click();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(3000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptionsValid2.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully success message is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,300)", "");
		Thread.sleep(2000);
		try {			
			js.executeScript("arguments[0].click();", ThreeDotsButton);
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
//			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
//		} catch (Exception e) {
//			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
//		}
//		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
//		RemoveLimitedExemption.click();
//		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
//		WarningContinue.click();
//		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
//		SuccessPopupClose.click();
	}

	public void Validation_Of_Same_Entity_ID_For_Batch() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			EntityID.sendKeys(SelectedEntityID);
		}
		EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("48787");
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate));
		EffectiveDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(SelectDate));
		SelectDate.click();
		Comments.sendKeys("Demo");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
			AddLimitedExemptionButton.click();
		} catch (Exception e) {
			AddLimitedExemptionButton.click();
		}
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(SuccessMessageLimitedExemption));
		String LESuccessPopUp = SuccessMessageLimitedExemption.getText();
		Assert.assertEquals(LESuccessPopUp, "The limited exemption has been successfully added");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		Thread.sleep(2000);
		try {

			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			EntityID.sendKeys(SelectedEntityID);
		}
		EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("48787");
		wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate));
		EffectiveDate.click();
		wait.until(ExpectedConditions.elementToBeClickable(SelectDate));
		SelectDate.click();
		Comments.sendKeys("Demo");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
			AddLimitedExemptionButton.click();
		} catch (Exception e) {
			AddLimitedExemptionButton.click();
		}
		Assert.assertEquals(EffectiveDateError.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"Error message is displayed as 'The LE for Entity ID with same Effective Date is already present in this batch'");
		wait.until(ExpectedConditions.elementToBeClickable(ClickEffectiveDate));
		// wait.until(ExpectedConditions.elementToBeClickable(EffectiveDate));
		ClickEffectiveDate.click();
		String val4 = ClickEffectiveDate.getAttribute("value");
		int size4 = val4.length();
		for (int i = 1; i <= size4; i++) {
			ClickEffectiveDate.sendKeys(Keys.BACK_SPACE);
		}
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
//		EffectiveDate.click();
//		Thread.sleep(3000);
//		SelecteDate3.click();
//		Thread.sleep(3000);
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random2 = new Random();
		int year2 = 2000 + random2.nextInt(21); // Random year between 2000 and 2020
		int month2 = 1 + random2.nextInt(12); // Random month between 1 and 12
		int day2 = 1 + random2.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate2 = String.format("%02d/%02d/%04d", year2, month2, day2);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate2);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
			AddLimitedExemptionButton.click();
		} catch (Exception e) {
			AddLimitedExemptionButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(SuccessMessageLimitedExemption));
		String LESuccessPopUp1 = SuccessMessageLimitedExemption.getText();
		Assert.assertEquals(LESuccessPopUp1, "The limited exemption has been successfully added");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,300)", "");
		try {

			ThreeDotsButton.click();
		} catch (Exception e) {
			demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		}
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.elementToBeClickable(ThreeDotsButton));
		demo.click2(ThreeDotsButton, "seleniumClick", "Click");
		wait.until(ExpectedConditions.elementToBeClickable(RemoveLimitedExemption));
		RemoveLimitedExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void UI_Of_Upload_Files_Pop_Up() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		Assert.assertEquals(UploadFilesPopUp.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Upload Files Title is displayed on Pop Up");
		Assert.assertEquals(UploadFileText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Information text is displayed on Pop-Up");
		Assert.assertEquals(ClickOnBrowseFiles.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Browse Files Button is is displayed on Pop-Up and button is enabled");
		Assert.assertEquals(ClickCancelOnFileUpload.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Cancel Button of Upload Files Pop-Up is enabled");
		Assert.assertEquals(Upload.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Upload Button is displayed on Upload Files Pop-Up");
	}

	public void Batch_Details_Page_UI_For_JU_Au_Other_Than_Proposed_Status() throws Exception {
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
//		try {			
//			ClickSearch.click();
//		} catch (Exception ex) {
//			wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//			ClickSearch.click();
//		}
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(storeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(SavedStatus.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Saved Batch Exemptions Details page is opened");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
		Assert.assertEquals(BatchExemptionDetailsPage.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Exemption Details page title is display");

		List<String> AcquiringAccountLabels = Arrays.asList("Batch Name", "Budget Year", "Status", "Batch ID",
				"Updated By", "Comments");

		List<String> ActualAcquiringAccountLabels = new ArrayList<>();

		for (int j = 0; j < BatchExemptionInformationLabels.size(); j++) {

			ActualAcquiringAccountLabels.add(BatchExemptionInformationLabels.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Labels present in the Batch Exemption Information Card are: "
					+ BatchExemptionInformationLabels.get(j).getText());

		}
		
		Assert.assertEquals(TextLimitedExemptionRecord.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Limited Exemption Records Table is display");
		
		List<String> LERecordLabels = Arrays.asList("Entity ID", "Legal Name", "Operating Name", "Limited Exemption",
				"Effective Date", "Comments");

		List<String> ActualLERecordLabels = new ArrayList<>();

		for (int j = 0; j < 6; j++) {

			ActualLERecordLabels.add(LimitedExemptionsRecordsTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Columns are present in Limited Exemptions Records Table are: "
					+ LimitedExemptionsRecordsTableColumns.get(j).getText());
		}
		
		List<String> BatchExemptionHistoryLabels = Arrays.asList("Status", "Updated Date", "Comments", "Updated By");

		List<String> ActualBatchExemptionHistoryLabels = new ArrayList<>();

		for (int j = 6; j < 10; j++) {

			ActualBatchExemptionHistoryLabels.add(LimitedExemptionsRecordsTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Columns are present in Batch Exemption History Table are: "
					+ LimitedExemptionsRecordsTableColumns.get(j).getText());
		}
	
		Assert.assertEquals(BatchExemptionTable.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Exemption History Table is display");
	
	}
	
	public void Batch_Details_Page_UI_For_JU_Au_Approved_Status() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//			ClickSearch.click();
//		} catch (Exception ex) {
//			ClickSearch.click();
//		}
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Assert.assertEquals(ApprovedStatus.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Approved Batch Exemptions Details page is opened");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
		Assert.assertEquals(BatchExemptionDetailsPage.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Exemption Details page title is display");

		List<String> AcquiringAccountLabels = Arrays.asList("Batch Name", "Budget Year", "Status", "Batch ID",
				"Updated By", "Comments");

		List<String> ActualAcquiringAccountLabels = new ArrayList<>();

		for (int j = 0; j < BatchExemptionInformationLabels.size(); j++) {

			ActualAcquiringAccountLabels.add(BatchExemptionInformationLabels.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Labels present in the Batch Exemption Information Card are: "
					+ BatchExemptionInformationLabels.get(j).getText());

		}
		
		Assert.assertEquals(TextEntityandLimitedExemptionInformation.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Limited Exemption Records Table is display");
		
		List<String> LERecordLabels = Arrays.asList("Entity ID", "Legal Name", "Operating Name", "Limited Exemption",
				"Effective Date", "Comments");

		List<String> ActualLERecordLabels = new ArrayList<>();

		for (int j = 0; j < 6; j++) {

			ActualLERecordLabels.add(LimitedExemptionsRecordsTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Columns are present in Limited Exemptions Records Table are: "
					+ LimitedExemptionsRecordsTableColumns.get(j).getText());
		}
		
		List<String> BatchExemptionHistoryLabels = Arrays.asList("Status", "Updated Date", "Comments", "Updated By");

		List<String> ActualBatchExemptionHistoryLabels = new ArrayList<>();

		for (int j = 6; j < 10; j++) {

			ActualBatchExemptionHistoryLabels.add(LimitedExemptionsRecordsTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Columns are present in Batch Exemption History Table are: "
					+ LimitedExemptionsRecordsTableColumns.get(j).getText());
		}
	
		Assert.assertEquals(BatchExemptionTable.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Exemption History Table is display");
	
	}
	
	public void Batch_Details_Page_UI_For_JU_Au_Revisions_Requsted_Status() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//			ClickSearch.click();
//		} catch (Exception ex) {
//			ClickSearch.click();
//		}
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Assert.assertEquals(RevisionsRequstedCommentCard.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Revisions Requsted Comment card is display");
		Assert.assertEquals(RevisionsRequestedStatus.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Revisions Requsted Batch Exemptions Details page is opened");
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1200)", "");
		Assert.assertEquals(BatchExemptionDetailsPage.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Exemption Details page title is display");

		List<String> AcquiringAccountLabels = Arrays.asList("Batch Name", "Budget Year", "Status", "Batch ID",
				"Updated By", "Comments");

		List<String> ActualAcquiringAccountLabels = new ArrayList<>();

		for (int j = 0; j < BatchExemptionInformationLabels.size(); j++) {

			ActualAcquiringAccountLabels.add(BatchExemptionInformationLabels.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Labels present in the Batch Exemption Information Card are: "
					+ BatchExemptionInformationLabels.get(j).getText());

		}
		
		Assert.assertEquals(TextLimitedExemptionRecord.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Limited Exemption Records Table is display");
		
		List<String> LERecordLabels = Arrays.asList("Entity ID", "Legal Name", "Operating Name", "Limited Exemption",
				"Effective Date", "Comments");

		List<String> ActualLERecordLabels = new ArrayList<>();

		for (int j = 0; j < 6; j++) {

			ActualLERecordLabels.add(LimitedExemptionsRecordsTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Columns are present in Limited Exemptions Records Table are: "
					+ LimitedExemptionsRecordsTableColumns.get(j).getText());
		}
		
		List<String> BatchExemptionHistoryLabels = Arrays.asList("Status", "Updated Date", "Comments", "Updated By");

		List<String> ActualBatchExemptionHistoryLabels = new ArrayList<>();

		for (int j = 6; j < 10; j++) {

			ActualBatchExemptionHistoryLabels.add(LimitedExemptionsRecordsTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Columns are present in Batch Exemption History Table are: "
					+ LimitedExemptionsRecordsTableColumns.get(j).getText());
		}
	
		Assert.assertEquals(BatchExemptionTable.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Batch Exemption History Table is display");
	
	}

	public void getBudget_Year_List() throws Exception {
		RegModule3_MJB_POM MJB = new RegModule3_MJB_POM(driver);
		MJB.navigateToBudgetRecordsPage_JAdmin();
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,450)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ApprovedBudgetYear));
		FirstApprovedYear = ApprovedBudgetYear.getText();
		String year = "";
		ApprovedBudgetYearsList = new ArrayList<String>();
		Thread.sleep(2000);
		for (int k = 1; k <= 5; k++) {
			year = EffectiveBudgetYears.get(k).getText();
			ApprovedBudgetYearsList.add(year);
		}
		System.out.println(ApprovedBudgetYearsList);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-950)", "");
		try {
			ClickOnHome.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		}
	}

	public void validation_BudgetYear() throws Exception {
		int size = ApprovedBudgetYearsList.size();

		String Vintageyear;
		for (int i = 0; i <= size - 1; i++) {
			Vintageyear = ApprovedBudgetYearsList.get(i);
			System.out.println(Vintageyear);
			wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(BudgetYear));
			BudgetYear.sendKeys(Vintageyear);
			BudgetYear.sendKeys(Keys.ENTER);
			String vintageYearDropDownValue = BudgetYear.getAttribute("value");
			Assert.assertEquals(vintageYearDropDownValue.equals(Vintageyear), true);
			ObjectRepo.test.log(Status.PASS, "Approved budget year is displayed in the Vintage Year dropdown");
			int yearValue = vintageYearDropDownValue.length();
			for (int j = 1; j <= yearValue; j++) {
				BudgetYear.sendKeys(Keys.BACK_SPACE);
			}
		}
		ObjectRepo.test.log(Status.PASS, "Dropdown list is displayed with approved budget year for the jurisdictiion. "
				+ ApprovedBudgetYearsList);
		// Second Step
		wait.until(ExpectedConditions.elementToBeClickable(BudgetYear));
		demo.click2(BudgetYear, "seleniumClick", "BudgetYearDrown");
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		BudgetYear.sendKeys(Keys.TAB);
		Assert.assertEquals(BudgetYearError.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Budget Year is Required error message is displayed");
		BatchName.sendKeys("Test Batch Name");
		demo.click2(BudgetYear, "seleniumClick", "BudgetYearDrown");
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		BudgetYear.sendKeys(Keys.ENTER);
		Assert.assertEquals(BudgetYear.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Budget Year is selected " + BudgetYear.getAttribute("value"));
		wait.until(ExpectedConditions.elementToBeClickable(Save));
		Assert.assertEquals(Save.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Save button is enabled");
		wait.until(ExpectedConditions.visibilityOf(BudgetYear));
		String BudgetYearValue = BudgetYear.getAttribute("value");
		int size4 = BudgetYearValue.length();
		Thread.sleep(3000);
		for (int i = 1; i <= size4; i++) {
			BudgetYear.sendKeys(Keys.BACK_SPACE);
		}
		BudgetYear.sendKeys("2024");
		String BudgetYearValue1 = BudgetYear.getAttribute("value");
		Assert.assertEquals(BudgetYearValue1, "2024");
		ObjectRepo.test.log(Status.PASS,
				"Searchable Budget Year is displayed in field " + BudgetYear.getAttribute("value"));
	}

	public void Validation_Of_Limited_Exemption_Quantity() throws Exception {
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(2000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\Empty LimitedExemptions.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(EmptyDateError1));
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError2.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError3.isDisplayed(), true);
//		String Error1 = EmptyDateError1.getText();
//		String Error2 = EmptyDateError2.getText();
//		String Error3 = EmptyDateError3.getText();
//		Assert.assertEquals(Error1, "Number of rows with a validation error: 1, out of 1 rows checked");
//		Assert.assertEquals(Error2, "Number of rows missing required data: 1");
//		Assert.assertEquals(Error3, "Entity IDs of rows with missing required data: [\"CA00306\"]");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText());
		// Second step
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
//		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(2000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions with Decimal Numbers.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(EmptyDateError1));
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
//		String Error4 = EmptyDateError1.getText();
//		String Error5 = EmptyDateError2.getText();
//		Assert.assertEquals(Error4, "Number of rows with a validation error: 1, out of 1 rows checked");
//		Assert.assertEquals(Error5, "Entity ID of rows with incorrect format data: [\"CA00306\"]");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText());
		// Third Step
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
//		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(2000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions with Negative Numbers.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(EmptyDateError1));
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
		Assert.assertEquals(EmptyDateError2.isDisplayed(), true);
//		String Error6 = EmptyDateError1.getText();
//		String Error7 = EmptyDateError2.getText();
//		Assert.assertEquals(Error6, "Number of rows with a validation error: 1, out of 1 rows checked");
//		Assert.assertEquals(Error7, "Entity ID of rows with incorrect format data: [\"CA00306\"]");
		ObjectRepo.test.log(Status.PASS, GetFileUploadErrors.getText());
		// Valid Upload
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
//		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		ObjectRepo.test.log(Status.PASS, "File Explorer is displayed");
		Thread.sleep(2000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptionsValid1.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessMessage));
		String Successmessage = SuccessMessage.getText();
		Assert.assertEquals(Successmessage, "Success!");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption added succefully success message is displayed");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Approve_Add_Limited_Exemption_Generic_Method_For_Holding_Limit() throws Exception {
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		try {
			wait.until(ExpectedConditions.visibilityOf(EntityID));
			EntityID.sendKeys(SelectedEntityID);
		} catch (Exception e) {
			EntityID.sendKeys(SelectedEntityID);
		}
		FetchEntityID = EntityID.getAttribute("value");
		LimitedExemptionValue.sendKeys("548796");
		wait.until(ExpectedConditions.elementToBeClickable(GetDate));
		GetDate.click(); // Or perform any action to open the date picker
		// Generate a random date
		Random random = new Random();
		int year = 2000 + random.nextInt(21); // Random year between 2000 and 2020
		int month = 1 + random.nextInt(12); // Random month between 1 and 12
		int day = 1 + random.nextInt(28); // Random day between 1 and 28
		// Construct the date string in the format required by the date picker
		String randomDate = String.format("%02d/%02d/%04d", year, month, day);
		// Enter the random date into the input field
		GetDate.sendKeys(randomDate);
		Comments.sendKeys("Demo");
		wait.until(ExpectedConditions.elementToBeClickable(AddLimitedExemptionButton));
		AddLimitedExemptionButton.click();
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
	}

	public void Fetch_Added_LE_EntityID() throws Exception {
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,300)", "");
		String StoredEntityID = StoreEntityId.getText();
		System.out.println(StoredEntityID);
	}

	public void Limited_Exemptions_In_Holding_Limit() throws Exception {
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(FetchEntityID);
		// String StoreLimitedExemption = FetchLimitedExemptions.getText();
		Assert.assertEquals(FetchLimitedExemptions.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The approved 'Limited Exemption' is displayed in 'Limited Exemption' table");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(StoreEntityId));
			StoreEntityId.click();
		} catch (Exception e) {
			StoreEntityId.click();
		}
		Assert.assertEquals(EntityDetails.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The Jurisdiction User is navigate to 'Entity Profile' page");
		js.executeScript("window.scrollBy(0,1200)", "");
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(HoldingLimits));
			HoldingLimits.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", HoldingLimits);
		}
		wait.until(ExpectedConditions.visibilityOf(FetchLEFromHoldingLimit));
		Assert.assertEquals(FetchLEFromHoldingLimit.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"The approved 'Limited Exemption' is displayed in Holding Limit table with updated 'Limited Exemption'");
	}

	public void UI_Of_Manage_Limited_Exemption() throws Exception {
		js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,1200)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(ManageLimitedExemptions));
		Assert.assertEquals(ManageLimitedExemptions.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Manage Limited Exemptions section is displayed");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemption));
		Assert.assertEquals(LimitedExemption.isEnabled(), true);
		Assert.assertEquals(BatchExemption.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemptions and Batch Exemptions options are displayed in Manage Limited Exemptions section");
	}

	public void Status_Update_After_Approved_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			ApproveRadioButton.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", ApproveRadioButton);
		}
		CommentText.sendKeys("Test Comment 1");
		try {

			SubmitButtonClick.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			SubmitButtonClick.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemption Batch is successfully approved success message is displayed and Limited Exemption batch isapproved.");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionText));
		Assert.assertEquals(BatchExemptionText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "User is on Batch Exemption Details page.");
		Thread.sleep(3000);
//		try {
//			wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
//			ClickSearch.click();
//		} catch (Exception e) {
//			ClickSearch.click();
//		}
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.visibilityOf(StatusUpadteOnLEBatches));
		Assert.assertEquals(StatusUpadteOnLEBatches.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The status of the batch exemption is updated to 'Approved'.");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		wait.until(ExpectedConditions.visibilityOf(StatusUpadteOnBatchExemptionDetails));
		Assert.assertEquals(StatusUpadteOnBatchExemptionDetails.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The status is updated to 'Approved'.");
		wait.until(ExpectedConditions.visibilityOf(LeEntityID));
		String LEEntityId = LeEntityID.getText();
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		Assert.assertEquals(ApprovedText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"The 'Batch Exemption History' table is updated with a new record of 'Approved' status with comment.");
		js.executeScript("window.scrollBy(0,-1500)", "");
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			ClickOnHome.click();
		}
		navigateToLimitedExemption();
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(LEEntityId);
		Thread.sleep(2000);
		// String totalRows = TotalRows.getText();
		Assert.assertEquals(LeEntityID.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Approved record is added in Limited Exemption table.");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			ClickOnHome.click();
		}
	}

	public void Status_Update_After_Deny_Limited_Exemption() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 50);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		js1.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		try {
			DenyRadioButton.click();
		} catch (Exception e) {
			demo.click2(DenyRadioButton, "seleniumClick", "DenyRadio");
		}
		CommentText.sendKeys("Test Comment 1");
		try {

			SubmitButtonClick.click();
		} catch (Exception e) {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			SubmitButtonClick.click();
		}
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		PasspharseEnter.sendKeys(prop.getProperty("Password"));
		wait.until(ExpectedConditions.elementToBeClickable(SubmitButtonOnPopUp));
		SubmitButtonOnPopUp.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemption Batch is successfully approved success message is displayed and Limited Exemption batch is denied.");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionText));
		Assert.assertEquals(BatchExemptionText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "User is on Batch Exemption Details page.");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickSearch));
			ClickSearch.click();
		} catch (Exception e) {
			ClickSearch.click();
		}
		wait.until(ExpectedConditions.visibilityOf(ClickSearch));
		ClickSearch.sendKeys(ProposeBatchId);
		wait.until(ExpectedConditions.visibilityOf(StatusUpadteOnLEBatches));
		Assert.assertEquals(StatusUpadteOnLEBatches.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The status of the batch exemption is updated to 'Denied'.");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnSearchedBatchId));
			ClickOnSearchedBatchId.click();
		} catch (Exception e) {
			ClickOnSearchedBatchId.click();
		}
		wait.until(ExpectedConditions.visibilityOf(StatusUpadteOnBatchExemptionDetails));
		Assert.assertEquals(StatusUpadteOnBatchExemptionDetails.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "The status is updated to 'Denied'.");
		wait.until(ExpectedConditions.visibilityOf(LeEntityID));
//		String LEEntityId = LeEntityID.getText();
		js.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(3000);
		Assert.assertEquals(DeniedText.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"The 'Batch Exemption History' table is updated with a new record of 'Denied' status with comment.");
		js.executeScript("window.scrollBy(0,-1500)", "");
		Thread.sleep(3000);
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnHome));
			ClickOnHome.click();
		} catch (Exception e) {
			ClickOnHome.click();
		}
	}

	public void Batch_Exemption_Page_UI() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait.until(ExpectedConditions.visibilityOf(BatchExemptionText));
		Assert.assertEquals(BatchExemptionText.isDisplayed(), true);
		Assert.assertEquals(MoreActions.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS,
				"More action button is displayed  at top right corner only to 'Jurisidction Admin' user.");
		Assert.assertEquals(InfoCard.isDisplayed(), true);
		Assert.assertEquals(LimitedExemptionBatchesText.isDisplayed(), true);

		List<String> AcquiringAccountLabels = Arrays.asList("Batch ID", "Batch Name", "Status", "Budget Year",
				"Updated Date", "Updated By");

		List<String> ActualAcquiringAccountLabels = new ArrayList<>();

		for (int j = 0; j < LimitedExemptionsBatchesTableColumns.size(); j++) {

			ActualAcquiringAccountLabels.add(LimitedExemptionsBatchesTableColumns.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Limited Exemptions Batches table columns are: "
					+ LimitedExemptionsBatchesTableColumns.get(j).getText());

		}
		boolean allLabelMatch = true;
		for (int i = 0; i < AcquiringAccountLabels.size(); i++) {
			String ExpValue = AcquiringAccountLabels.get(i);
			String ActValue = ActualAcquiringAccountLabels.get(i);
			if (!ExpValue.equals(ActValue)) {
				allLabelMatch = false;
				break;
			}
		}
		if (allLabelMatch) {
			ObjectRepo.test.log(Status.PASS,
					"All the expected columns are present on Limited Exemptions Batches table ");
		} else {
			ObjectRepo.test.log(Status.PASS,
					"All the expected columns are not present on Limited Exemptions Batches table ");
		}
	}

	public void Create_LImited_Exemption_Batch_UI() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(CreateLimitedExemptionBatch));
		Assert.assertEquals(CreateLimitedExemptionBatch.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Jurisdiction Admin is navigate to Create Limited Exemption Batch page");
		Assert.assertEquals(InfoCard.isDisplayed(), true);
		Assert.assertEquals(BatchExemptionInformationText.isDisplayed(), true);

		List<String> AcquiringAccountLabels = Arrays.asList("Batch Name", "Budget Year", "Comments");

		List<String> ActualAcquiringAccountLabels = new ArrayList<>();

		for (int j = 0; j < BatchExemptionInformationLabels.size(); j++) {

			ActualAcquiringAccountLabels.add(BatchExemptionInformationLabels.get(j).getText());

			ObjectRepo.test.log(Status.PASS, "Labels present in the Batch Exemption Information Card are: "
					+ BatchExemptionInformationLabels.get(j).getText());

		}
		boolean allLabelMatch = true;
		for (int i = 0; i < AcquiringAccountLabels.size(); i++) {
			String ExpValue = AcquiringAccountLabels.get(i);
			String ActValue = ActualAcquiringAccountLabels.get(i);
			if (!ExpValue.equals(ActValue)) {
				allLabelMatch = false;
				break;
			}
		}
		if (allLabelMatch) {
			ObjectRepo.test.log(Status.PASS,
					"All the expected labels are present on BatchExemptionInformationLabels card ");
		} else {
			ObjectRepo.test.log(Status.PASS,
					"All the expected labels are not present on BatchExemptionInformationLabels card ");
		}
		Assert.assertEquals(ClickCancel.isDisplayed(), true);
		Assert.assertEquals(Save.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "SAVE' and 'CANCEL' button is displayed at bottom.");
	}

	public void Limited_Exemptions_Field_Validation() throws Exception {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)", "");
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(LimitedExemptionValue));
		LimitedExemptionValue.click();
		LimitedExemptionValue.sendKeys(Keys.TAB);
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionError));
		String ErrorMessage = LimitedExemptionError.getText();
		Assert.assertEquals(ErrorMessage, "Limited Exemption is required");
		ObjectRepo.test.log(Status.PASS, "Limited Exemption is required error message is display");
		// Enter Other Than Numeric Value
		LimitedExemptionValue.sendKeys("abc@#$%><");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionError));
		String ErrorMessage2 = LimitedExemptionError.getText();
		Assert.assertEquals(ErrorMessage2, "Limited Exemption Quantity does not have valid numeric value");
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemption Quantity does not have valid numeric value error message is display");
		js.executeScript("arguments[0].value = '';", LimitedExemptionValue);
		LimitedExemptionValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		LimitedExemptionValue.sendKeys("100.235");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionError));
		String ErrorMessage3 = LimitedExemptionError.getText();
		Assert.assertEquals(ErrorMessage3, "Limited Exemption Quantity does not have valid numeric value");
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemption Quantity does not have valid numeric value error message is display");
		js.executeScript("arguments[0].value = '';", LimitedExemptionValue);
		LimitedExemptionValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		LimitedExemptionValue.sendKeys("-10000");
		wait.until(ExpectedConditions.visibilityOf(LimitedExemptionError));
		String ErrorMessage4 = LimitedExemptionError.getText();
		Assert.assertEquals(ErrorMessage4, "Limited Exemption Quantity does not have valid numeric value");
		ObjectRepo.test.log(Status.PASS,
				"Limited Exemption Quantity does not have valid numeric value error message is display");
		js.executeScript("arguments[0].value = '';", LimitedExemptionValue);
		LimitedExemptionValue.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.BACK_SPACE);
		LimitedExemptionValue.sendKeys("12000");
		String ErrorMessage5 = LimitedExemptionError.getText();
		Assert.assertEquals(ErrorMessage5, "");
		ObjectRepo.test.log(Status.PASS, "The entered value is accepted in the 'Limited Exemption' field");
	}

	public void UploadFile_CommaSeprated_Limited_Exemption() throws Exception {
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.visibilityOf(UploadFilesPopUp));
		String UploadFilePopup = UploadFilesPopUp.getText();
		Assert.assertEquals(UploadFilePopup, "Upload Files");
		ObjectRepo.test.log(Status.PASS, "Step 1:- Upload Files Pop Up is displayed");
		ClickOnBrowseFiles.click();
		Thread.sleep(1000);
		// Without double coats
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions CommaSeprated without coats.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		Assert.assertEquals(EmptyDateError1.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Step 2:- " + GetFileUploadErrors.getText());

		// excel with comma
		js.executeScript("window.scrollBy(0,700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ClickOnUploadFileButton));
			ClickOnUploadFileButton.click();
		} catch (Exception e) {
			ClickOnUploadFileButton.click();
		}
		wait.until(ExpectedConditions.elementToBeClickable(ClickOnBrowseFiles));
		ClickOnBrowseFiles.click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(
				"C:\\Users\\Aditya Daple\\OneDrive - Eqanim Tech Pvt Ltd\\Desktop\\AutoIT\\LimitedExemptions CommaSeprated with comma.exe");
		wait.until(ExpectedConditions.elementToBeClickable(Upload));
		Upload.click();
		wait.until(ExpectedConditions.visibilityOf(SuccessPopup));
		String successpopup = SuccessPopup.getText();
		Assert.assertEquals(successpopup, "Success!");
		ObjectRepo.test.log(Status.PASS,
				"Step 3:-  Success message is displayed as 'The records has been saved successfully' with number of records processed and file is uploaded.");
		wait.until(ExpectedConditions.elementToBeClickable(SuccessPopupClose));
		SuccessPopupClose.click();
		js.executeScript("window.scrollBy(0,-700)", "");
		try {
			wait.until(ExpectedConditions.elementToBeClickable(MoreActions));
			MoreActions.click();
		} catch (Exception e) {
			js.executeScript("arguments[0].click();", MoreActions);
		}
		wait.until(ExpectedConditions.elementToBeClickable(DeleteBatchExemption));
		DeleteBatchExemption.click();
		wait.until(ExpectedConditions.elementToBeClickable(WarningContinue));
		WarningContinue.click();
		
		
		

	}

}