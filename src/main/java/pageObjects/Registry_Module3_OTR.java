package pageObjects;

import java.util.concurrent.TimeUnit;

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

public class Registry_Module3_OTR extends base {
	public WebDriver driver;
	CommonMethods demo = new CommonMethods(driver);
	publicHomePage sc;
	JavascriptExecutor js;

	
	WebDriverWait wait;
	
	@FindBy(xpath= "//a[text()=\"Offset Tracking\"]")
	WebElement NavigateToOffsetTracking;
	@FindBy(xpath= "//button[@data-testid=\"more-actions\"]")
	WebElement MoreActions;
	@FindBy(xpath ="//p[@class=\"MuiTypography-root MuiTypography-body1 css-1yfaah8\"]")
	WebElement CreateOffsetTrackingRecord;
	@FindBy(xpath ="//h1[@class=\"MuiTypography-root MuiTypography-h1 css-1l7rfk3\"]")
	WebElement CreateOffsetTrackingRecordTitle;
	@FindBy(xpath ="//input[@data-testid=\"name\"]")
	WebElement Name;
	@FindBy(xpath ="//input[@data-testid=\"projectName\"]")
	WebElement ProjectName;
	@FindBy(xpath ="//textarea[@data-testid=\"comment\"]")
	WebElement Comment;
	@FindBy(xpath ="//p[@id=\"name-helper-text\"]")
	WebElement NameError;
	@FindBy(xpath ="//p[@id=\"projectName-helper-text\"]")
	WebElement ProjectNameError;
	@FindBy(xpath ="//p[@id=\"comment-helper-text\"]")
	WebElement CommentError;
	@FindBy(xpath ="//button[@data-testid=\"cancelBtn\"]")
	WebElement Cancel_Button;
	@FindBy(xpath ="//button[@data-testid=\"saveBtn\"]")
	WebElement Save_Button;
	@FindBy(xpath ="//h6[text()=\"Warning!\"]")
	WebElement Warning;
	@FindBy(xpath ="//button[@data-testid=\"priv_modal_Cancel\"]")
	WebElement Cancel_Button_On_PopUp;
	@FindBy(xpath ="//button[@data-testid=\"priv_modal_Continue\"]")
	WebElement Continue_Button_On_PopUp;
	@FindBy(xpath ="//h1[@class=\"MuiTypography-root MuiTypography-h1 css-1l7rfk3\"]")
	WebElement OffsetTrackingRecordTitle;
	@FindBy(xpath ="//h6[text()=\"Confirm!\"]")
	WebElement Confirm;
	@FindBy(xpath= "//p[@class=\"MuiTypography-root MuiTypography-body2 css-1eifdk0\"]")
	WebElement SavedSucessMessage;
	@FindBy(xpath ="//button[@class=\"MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-5zd7v5\"]")
	WebElement CloseIcon;
	@FindBy(xpath ="//p[@data-testid=\"status\"]")
	WebElement OTRStatus;
	@FindBy(xpath ="//a[text()=\"HOME\"]")
	WebElement HOME;
	@FindBy(xpath ="(//p[@class=\"MuiTypography-root MuiTypography-body2 css-j4m1we\"])[2]")
	WebElement OtrID;
	@FindBy(xpath ="//input[@class=\"MuiInputBase-input MuiInput-input MuiInputBase-inputTypeSearch MuiInputBase-inputAdornedStart MuiInputBase-inputAdornedEnd css-c6bojz\"]")
	WebElement Search;
	@FindBy(xpath= "(//div[@class=\"MuiDataGrid-cellContent\"])[3]")
	WebElement Status_On_OTR_Table;
	@FindBy(xpath ="//button[@data-testid=\"priv_btn_Reset\"]")
	WebElement Cancel_Button_On_Confirmation_PopUp;
	@FindBy(xpath ="//button[@data-testid=\"priv_btn_Search\"]")
	WebElement Confirm_Button_On_ConfirmationPopUp;
	
	String FetchedOTRID;
	
	public Registry_Module3_OTR(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	public void NavigateToOffsetTracking() throws Exception{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(NavigateToOffsetTracking));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", NavigateToOffsetTracking);
		
	}
	
	public void navigateToCreateOffsetTrackingRecord() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 50);
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", MoreActions);
		wait.until(ExpectedConditions.elementToBeClickable(CreateOffsetTrackingRecord));
		js.executeScript("arguments[0].click();", CreateOffsetTrackingRecord);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOf(CreateOffsetTrackingRecordTitle));
		String PageTitle = CreateOffsetTrackingRecordTitle.getText();
		Assert.assertEquals(PageTitle, "Create Offset Tracking Record");
		ObjectRepo.test.log(Status.PASS, "User navigates to Create Offset Tracking Record page");
	}
	
	public void Mandatory_Fields_Verification_On_Create_Offset_Tracking_Record_Page() throws Exception{
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.elementToBeClickable(Name));
		Name.click();
		Name.sendKeys(Keys.TAB);
		String Name_Error = NameError.getText();
		Assert.assertEquals(Name_Error, "Name is a required field.");
		ProjectName.click();
		ProjectName.sendKeys(Keys.TAB);
		String ProjectName_Error = ProjectNameError.getText();
		Assert.assertEquals(ProjectName_Error, "Project Name is a required field.");
		Comment.click();
		Comment.sendKeys(Keys.TAB);
		String Comment_Error = CommentError.getText();
		Assert.assertEquals(Comment_Error, "Comment is a required field.");
		ObjectRepo.test.log(Status.PASS, "Step 1 - Error messages are displayed for mandatory fields");	
	}
	
	public void Cancel_Button_On_Create_Offset_Tracking_Record_Page() throws Exception{
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(Name));
		Name.sendKeys("Test Name");
		String Value_Name = Name.getAttribute("value");
		ProjectName.sendKeys("Test Project Name");
		String Value_Projectname = ProjectName.getAttribute("value");
		Comment.sendKeys("Test Comment");
		String Value_Comment = Comment.getAttribute("value");
		Cancel_Button.click();
		Assert.assertEquals(Warning.isDisplayed(), true);
		Assert.assertEquals(Cancel_Button_On_PopUp.isDisplayed(), true);
		Assert.assertEquals(Continue_Button_On_PopUp.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Step 1 - Warning pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons.");
		Cancel_Button_On_PopUp.click();
		wait.until(ExpectedConditions.visibilityOf(CreateOffsetTrackingRecordTitle));
		String PageTitle = CreateOffsetTrackingRecordTitle.getText();
		Assert.assertEquals(PageTitle, "Create Offset Tracking Record");
		String Name_Value = Name.getAttribute("value");
		String ProjectName_Value= ProjectName.getAttribute("value");
		String Comment_Value = Comment.getAttribute("value");
		Assert.assertEquals(Value_Name, Name_Value);
		Assert.assertEquals(Value_Projectname, ProjectName_Value);
		Assert.assertEquals(Value_Comment, Comment_Value);
		ObjectRepo.test.log(Status.PASS, "Step 2 - Warning pop-up is closed  and Entered data by Jurisdiction Admin is remain as it is.");
		Cancel_Button.click();
		Assert.assertEquals(Warning.isDisplayed(), true);
		Assert.assertEquals(Cancel_Button_On_PopUp.isDisplayed(), true);
		Assert.assertEquals(Continue_Button_On_PopUp.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Step 3 - Warning pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons.");
		Continue_Button_On_PopUp.click();
		wait.until(ExpectedConditions.visibilityOf(OffsetTrackingRecordTitle));
		String PageTitle1 = OffsetTrackingRecordTitle.getText();
		Assert.assertEquals(PageTitle1, "Offset Tracking Record");
		ObjectRepo.test.log(Status.PASS, "Step 4 - Warning pop-up is displayed with the 'CANCEL' & 'CONTINUE' buttons.");	
	}
	
	public void Create_Offset_Tracking_Record() throws Exception{
		wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(Name));
		Name.sendKeys("Test Name 1");
		ProjectName.sendKeys("Test Project Name 1");
		Comment.sendKeys("Test Comment 1");
		Assert.assertEquals(Save_Button.isEnabled(), true);
		ObjectRepo.test.log(Status.PASS, "Step 1 - 	OTR name is accepted");
		ObjectRepo.test.log(Status.PASS, "Step 2 - 	Project name is accepted");
		ObjectRepo.test.log(Status.PASS, "Step 3 - 	Comment is accepted");
		Save_Button.click();
		Assert.assertEquals(Confirm.isDisplayed(), true);
		Assert.assertEquals(Cancel_Button_On_Confirmation_PopUp.isDisplayed(), true);
		Assert.assertEquals(Confirm_Button_On_ConfirmationPopUp.isDisplayed(), true);
		ObjectRepo.test.log(Status.PASS, "Step 4 - 	Confirmation pop up is displayed with CANCEL and CONTINUE button");
		Continue_Button_On_PopUp.click();
		String SuccessMessage = SavedSucessMessage.getText();
		Assert.assertEquals(SuccessMessage, "The Offset Tracking Record with a Saved state is created successfully.");
		wait.until(ExpectedConditions.elementToBeClickable(CloseIcon));
		CloseIcon.click();
		FetchedOTRID = OtrID.getText();
		String Fetched_Status = OTRStatus.getText();
		Assert.assertEquals(Fetched_Status, "Saved");
		ObjectRepo.test.log(Status.PASS, "Step 5.1 - 	A success message is displayed as 'The Offset Tracking Record with a Saved state is created successfully.'");
		ObjectRepo.test.log(Status.PASS, "Step 5.2 - 	OTR status is displayed as 'Saved'");
		wait.until(ExpectedConditions.elementToBeClickable(HOME));
		HOME.click();
		NavigateToOffsetTracking();
		Thread.sleep(2000);
		Search.sendKeys(FetchedOTRID);
		wait.until(ExpectedConditions.visibilityOf(Status_On_OTR_Table));
		String OTRstatus = Status_On_OTR_Table.getText();
		Assert.assertEquals(OTRstatus, "Saved");
		ObjectRepo.test.log(Status.PASS, "Step 6 - 	OTR with Saved status is displayed in Offset Tracking Record table");	
	}
	

}