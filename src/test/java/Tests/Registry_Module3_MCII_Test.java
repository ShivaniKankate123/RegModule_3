package Tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.Registry_Module3_MCII;
import pageObjects.publicHomePage;
import resources.ObjectRepo;
import resources.base;

public class Registry_Module3_MCII_Test extends base{
	Registry_Module3_MCII MCII;
	publicHomePage PH;
	
	@Test(priority=0,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_of_Offset_Issuance_page() throws Exception {
		//testCaseId ="39560"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
		MCII.PopUpCancel_Cancel_BtnClick();
		MCII.PopUpContinue_Cancel_BtnClick();
	}
	
	@Test(priority=1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Create_New_Project_Name_functionality_on_Offset_Issuance_Page_by_entering_existing_Project_Name() throws Exception  {
		//testCaseId ="39555"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
    	MCII.AddExistingProjectname();	
	}
	
	@Test(priority=2,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Create_New_Project_Operator_functionality_of_Offset_Issuance_Page_by_entering_existing_Project_Operator() throws Exception { 
		//testCaseId ="39557"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
    	MCII.AddExistingProjectOperator();	
	}
	
	@Test(priority=3,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Create_New_Verification_Body_functionality_of_Offset_Issuance_Page_by_entering_existing_Verification_Body() throws Exception {
		//testCaseId ="39559"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
    	MCII.AddExistingVerificationBody();
	}
	 
	@Test(priority=4,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Offset_Project_Operator_dropdown_menu_on_Offset_Issuance_Page() throws Exception {
		//testCaseId ="39547"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
    	MCII.verifyOffsetProjectOperatorDropdown();
	}
	
	@Test(priority=5,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Verification_Body_dropdown_menu_on_Offset_Issuance_Page() throws Exception {
		//testCaseId ="39550"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
    	MCII.verifyVerificationBodyDropdown();	
	}
	
	@Test(priority=6,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_the_Special_Category_dropdown_menu_on_Offset_Issuance_Page() throws Exception{
		//testCaseId ="39552"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
    	MCII.verifySpecialCategoryDropdown();
	}
	
	@Test(priority=7,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Start_and_End_Reporting_Period_on_Offset_Issuance_Page() throws Exception {
		//testCaseId ="39569"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
    	MCII.verifyStartAndEndReportingPeriod();
	}
	
	@Test(priority=8,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Start_and_End_Reporting_Period_on_Offset_Issuance_Page_if_the_Begin_Reporting_Period_date_is_earlier_than_the_End_Reporting_Period() throws Exception {
		//testCaseId ="39570"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
    	MCII.validationStartAndEndReportingPeriod();
	}
	
	@Test(priority=9,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Proposed_Offset_issuance_page_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40073"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
		MCII.PopUpCancel_Cancel_BtnClick();
		MCII.PopUpContinue_Cancel_BtnClick();
	}
	
	@Test(priority=10,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Deny_Proposed_Offset_Issuance_by_Jurisdiction_Authority () throws Exception {
		//testCaseId ="39933"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
//    	MCII.ProposeOffsetIssuance();
//    	MCII.navigateOffsetIssuanceDetailPage_Auth();
    	MCII.DeniedOffsetIssuance();
    	MCII.verifyTransferEventHistory_DeniedOffsetIssuanceRecord();
    	MCII.verifyMyApprovals_DeniedOffsetIssuanceRecord();
	}
	
	@Test(priority=11,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_of_Offset_Issuance_details_page() throws Exception {
		//testCaseId ="39564"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
    	MCII.verifyCancelBtnOffsetIssuanceDetail_Auth();
    	ObjectRepo.test.log(Status.PASS, "Cancel button functionality is working as expected");
	}
	
	@Test(priority=12,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Vintage_year_and_subtype_If_neither_are_specified() throws Exception{
		//testCaseId ="39583"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		Thread.sleep(5000);
		MCII.navigateToAllowanceIssuancePage();
		MCII.verifySubTypeAndVintageYear_Withoutselecting();
	}
	
	@Test(priority=13,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_both_Vintage_year_and_Sub_type_are_selected() throws Exception {
		//testCaseId ="39584"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.navigateToAllowanceIssuancePage();
		MCII.verifySubTypeAndVintageYear_WithSelectingBoth();
	}
	
	@Test(priority=14,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_of_Allowance_Issuance_page() throws Exception {
		//testCaseId ="39586"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.navigateToAllowanceIssuancePage();
		MCII.verifyCancelBtnAllowanceIssuance_JAuth();
		ObjectRepo.test.log(Status.PASS, "Cancel button functionality is working as expected");
	}
	
	@Test(priority=15,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Propose_Allowance_Issuance_by_Jurisdiction_Admin() throws Exception{
		//testCaseId ="39942"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.navigateToAllowanceIssuancePage();
		MCII.ProposeAllowanceIssuance_SubType();
		MCII.verifyTransferEventHistoryTable_ProposeAllowanceIssuance();
		MCII.navigateToIssuanceRecordsPage_MegaMenu();
		MCII.search_TransferId_IssuanceRecordGrid();
	}
	

	@Test(priority=16,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Proposed_offset_issuance_details_page_for_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39939"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
    	MCII.NavigateToOffsetIssuance();
    	MCII.verifyCancelBtnOffsetIssuanceDetail_Auth();
    	ObjectRepo.test.log(Status.PASS, "Cancel button functionality is working as expected");
	}
	
	@Test(priority=17,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_quick_actions_button_on_Issuance_Account_page_to_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39538"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verify_MoreActionBtn_IssuanceAccPage();
		MCII.NavigateToOffsetIssuance();
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		MCII.navigateToAllowanceIssuancePage();
	}
	
	@Test(priority=18,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_quick_actions_button_on_Issuance_Account_page_to_Jurisdiction_Users_other_than_Admin() throws Exception {
		//testCaseId ="39539"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verify_MoreActionBtn_IssuanceAccPage_JAuth();
	}
	
	@Test(priority=19,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Quantity_of_Vintaged_Allowance_issuance_against_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_when_another_issuance_is_proposed_for_the_vintage_year() throws Exception {
		//testCaseId ="39597"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "WciincAdmin");
		PH.secQueAns();
		MCII.verify_Quantity_against_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_ForSameBudYear();	
	}
	
	//Cannot Automate
	@Test(priority=20,retryAnalyzer = Analyzer.RetryAnalyzer.class,enabled=false)
	public void Validation_of_Quantity_field_against_Total_Adjusted_Allowance_Budget_Summed_for_all_budget_years_for_Vintaged_allowance_issuance() throws Exception {
		//testCaseId ="39956"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.navigateToAllBudgetRecordsPage();
		MCII.Add_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_AllBudgetYear();
	}
	
	@Test(priority=21,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Passphrase_field_on_Confirm_Issuance_Proposal_Popup() throws Exception {
		//testCaseId ="39581"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyPassphraseField_Confirm_Issuance_Proposal_Popup();	
	}
	
	@Test(priority=22,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_status_update_after_Offset_issuance_is_denied_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39940"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.DeniedOffsetIssuance();
		MCII.verifyTransferEventHistory_DeniedOffsetIssuanceRecord();
		MCII.verifyStatus_IssuanceRecord_DeniedOffset();
	}
	
	@Test(priority=23,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Issuance_Account_page_for_Jurisdiction_User() throws Exception {
		//testCaseId ="39535"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verify_UI_IssuanceRecordPage();
	}
	
	@Test(priority=24,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_status_update_after_Offset_issuance_is_Revisions_Requested_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39941"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.RequestRevisionOffsetIssuance();
		MCII.verifyTransferEventHistory_RevisionRequestOffsetIssuanceRecord();
		MCII.verifyStatus_IssuanceRecord_RevisionRequestOffset();
		
	}
	
	@Test(priority=25,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Vintage_Year_dropdown_field_on_Allowance_Issuance_page() throws Exception {
		//testCaseId ="39578"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();	
		MCII.getEffectiveVintageYears();    //pending
		MCII.verifyListApprovedVintageYearAllowanceIssuance();
		MCII.verifyErrorMsg_EmptyVintageYearDropDown_AllowanceIssuance();
		MCII.verifyValidVintageYear();
	}
	
	@Test(priority=26,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Proposed_Allowance_issuance_page_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40013"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();	
		MCII.verifyCancelBtnAllowanceIssuance_JAdmin();
	}
	
	@Test(priority=27,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Jurisdiction_Admin_to_create_multiple_Allowance_Issuance_Proposals() throws Exception {
		//testCaseId ="39582"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "WciincAdmin");
		PH.secQueAns();
		MCII.verifyMultipleAlloawnaceIssuanceProposal();
	}
	
	@Test(priority=28,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Functionality_Prepare_and_Propose_an_Allowance_Issuance() throws Exception {
		//testCaseId ="39580"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.VerifY_Functionality_Prepare_and_Propose_AllowanceIssuance();
	}
	
	@Test(priority=29,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Create_New_Project_Name_functionality_from_Project_name_dropdown_of_Offset_Issuance_Page() throws Exception {
		//testCaseId ="39554"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyEmptyOffsetProjectnameDropDown();
		MCII.verifyAddedOffsetProjectNameDropdown_ManagementTable();
	}
	
	@Test(priority=30,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Create_New_Project_Operator_functionality_from_Project_name_dropdown_of_Offset_Issuance_Page() throws Exception {
		//testCaseId ="39556"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyEmptyOffsetProjectOperatorDropDown();
		MCII.verifyAddedOffsetProjectOperaorDropdown_ManagementTable();
	}
	
	@Test(priority=31,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Create_New_Verification_Body_functionality_from_Verification_Body_dropdown_of_Offset_Issuance_Page() throws Exception {
		//testCaseId ="39558"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyEmptyVerificationBodyDropDown();
		MCII.verifyAddedVerificationBodyDropdown_ManagementTable();
	}
	
	@Test(priority=32,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_My_Approvals_page_for_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39587"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		MCII.navigateToMyApprovals_JAuth();
		MCII.getMyApprovalTableColumn();
	}
	
	
	@Test(priority=33,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Updated_status_after_Approval_of_Allowance_Issuance() throws Exception {
		//testCaseId ="39591"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyApproveAllowanceFunctionality_JAuth();
		MCII.verifyTransferStatus_ApprovedAllowanceIssuance_DetailsPage();
		MCII.verifyTransferEventHistory_ApprovedAllowanceIssuanceRecord();
		MCII.verifyStatus_IssuanceRecord_ApprovedAllowance();
	}
	
	@Test(priority=34,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Proposed_Allowance_issuance_details_page_for_Jurisdiction_Authority() throws Exception {
		//testCaseId ="40072"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.CancelBtnFunctionality_Allowance_Issuance_details_page();
	}
	
	@Test(priority=35,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Deny_Allowance_Issuance_without_providing_comment() throws Exception {
		//testCaseId ="39952"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyDeny_AllowanceIssuance_withoutProvidingComment();
	}
	
	@Test(priority=36,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Denial_of_Allowance_Issuance_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39953"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyDenyFunctionality_AllowanceIssuance();
		MCII.verifyMyApproval_DenyAllowanceIssuanceRecord();
	}
	
	@Test(priority=37,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Serialized_Block_code_Start_and_End_on_Compliance_Instruments_table_for_Denied_Allowance_Issuance() throws Exception {
		//testCaseId ="39954"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyStartAndEndSerializedCode_DenyAllowanceIssuanceRecord();
	}
	
	@Test(priority=38,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_status_update_after_Allowance_issuance_is_denied_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39955"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyDenyFunctionality_AllowanceIssuance();
		MCII.verifyTransferStatus_DenyAllowanceIssuanceRecord();
		MCII.verifyTransferEventHistory_DenyAllowanceIssuanceRecord();
		MCII.verifyStatus_IssuanceRecord_DenyAllowanceIssuanceRecord();
	}
	
	@Test(priority=39,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_status_update_after_Allowance_issuance_is_Revisions_Requested_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39932"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyRequestRevisionFunctionality_AllowanceIssuance();
		MCII.verifyTransferStatus_RequestRevisionAllowanceIssuanceRecord();
		MCII.verifyTransferEventHistory_RequestRevisionAllowanceIssuanceRecord();
		MCII.verifyStatus_IssuanceRecord_RequestRevisionAllowanceIssuanceRecord();
	}
	
	
	@Test(priority=40,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Approve_Proposed_Offset_Issuance_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39563"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.ApprovedOffsetIssuance();
		MCII.verifyTransferEventHistory_ApprovedOffsetIssuanceRecord();
		MCII.verifyMyApprovals_ApprovedOffsetIssuanceRecord();
	}
	
	@Test(priority=41,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Deny_Proposed_Offset_Issuance_without_providing_comment() throws Exception {
		//testCaseId ="39934"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyDeny_OffsetIssuance_withoutProvidingComment();
	}
	
	@Test(priority=42,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Serialized_Block_code_Start_and_End_when_Jurisidiction_Authority_denies_the_Offset_Issuance() throws Exception {
		//testCaseId ="39935"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyStartAndEndSerializedCode_DenyOffsetIssuanceRecord();
	}
	
	@Test(priority=43,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_status_update_after_Offset_issuance_is_approved_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39571"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.ApprovedOffsetIssuance();
		MCII.verifyTransferEventHistory_ApprovedOffsetIssuanceRecord();
		MCII.verifyStatus_IssuanceRecord_ApprovedOffsetIssuance();
	}
	
	@Test(priority=44,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Subtype_dropdown_menu_functionality_on_Allowance_Issuance_page() throws Exception {
		//testCaseId ="39579"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.navigateToAllowanceIssuancePage();
		MCII.verifySubTypeDropdown();
	}
	
	@Test(priority=45,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Approved_offset_records_on_Issuance_Account_page() throws Exception {
		//testCaseId ="39565"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.ApprovedOffsetIssuance();
		MCII.verifyHoldingTable_ApprovedOffsetIssuance();
		MCII.VerifyTransferTable_ApprovedOffsetIssuance();
	}
	
	@Test(priority=46,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Allowance_Issuance_page_UI_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39576"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyUI_AllowanceIssuancePage();
	}
	
	@Test(priority=47,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Offset_Issuance_page_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39540"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyUI_OffsetIssuancePage();
	}
	
	@Test(priority=48,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Quantity_of_Vintaged_Allowance_issuance_against_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget() throws Exception {
		//testCaseId ="39596"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "WciincAdmin");
		PH.secQueAns();
		MCII.verify_Quantity_against_Allowance_Outstanding_for_Reserve_Adjusted_Allowance_Budget_ForFirstTime();
	}
	
	@Test(priority=49,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Quantity_field_on_Allowance_Issuance_page() throws Exception {
		//testCaseId ="39585"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.validateQuantityField_AllowanceIssuance();
	}
	
	@Test(priority=50,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_update_issuance_records_after_allowance_issuance_is_proposed() throws Exception {
		//testCaseId ="39957"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyIssuanceRecord_AllowanceIssuanceProposal();
	}
	
	@Test(priority=51,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Quantity_against_Reserve_Budget_for_Price_Containment_Reserve_Allowance_Issuance() throws Exception {
		//testCaseId ="39958"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.validateQuantity_PCRAIssuance();
	}
	
	 // Hold 2nd Step
//	@Test(priority=52,retryAnalyzer = Analyzer.RetryAnalyzer.class)
//	public void Verification_of_update_issuance_records_after_offset_issuance_is_proposed() throws Exception {
//		//testCaseId ="39957"
//		MCII = new Registry_Module3_MCII(driver);
//		PH= new publicHomePage(driver, prop);
//		PH.selectJurisdiction("California");
//		PH.loginFunctionality("California", "JurisdictionAdmin");
//		PH.secQueAns();
//		MCII.verifyIssuanceRecord_OffsetIssuanceProposal();
//	}
	
	@Test(priority=53,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Issued_Allowances_on_the_Issuance_Account_page_for_Approved_Allowances_Issuance() throws Exception {
		//testCaseId ="39944"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyAccountBalance_IssuanceAccount_ApprovalAllowanceIssuance();
	}
	
	@Test(priority=54,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_details_of_the_proposed_Allowance_Issuance_Details_page_for_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39595"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyProposedAllowanceIssuanceDetailsPage_JAuth();
	}
	
	@Test(priority=55,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_to_the_Allowance_Issuance_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39929"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyRequestRevision_AllowanceIssuance_MyApprovals();
	}
	
	@Test(priority=56,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_to_the_Allowance_Issuance_without_providing_comment() throws Exception {
		//testCaseId ="39952"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyRequestRevision_AllowanceIssuance_withoutProvidingComment();
	}
	
	@Test(priority=57,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Serialized_Block_code_Start_End_when_Jurisdiction_Authority_Requests_Revision_to_the_Allowance_Issuance() throws Exception {
		//testCaseId ="39931"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.verifyStartAndEndSerializedCode_RequestRevisionAllowanceIssuanceRecord();
	}
	
	@Test(priority=58,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Revision_Request_Proposed_Offset_Issuance_by_Jurisdiction_Authority() throws Exception {
		//testCaseId ="39566"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.RequestRevisionOffsetIssuance();
		MCII.verifyTransferEventHistory_RevisionRequestOffsetIssuanceRecord();
		MCII.verifyMyApprovals_RequestRevisionOffsetIssuanceRecord();
	}
	
	@Test(priority=59,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Revision_Request_Proposed_Offset_Issuance_without_providing_comment() throws Exception {
		//testCaseId ="39567"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyRequestRevision_OffsetIssuance_withoutProvidingComment();
	}
	
	@Test(priority=60,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Serialized_Block_code_Start_End_will_not_generate_on_Compliance_Instruments_table() throws Exception {
		//testCaseId ="39568"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.Navigate_To_IssuanceAccount();
		MCII.NavigateToOffsetIssuance();
		MCII.verifyStartAndEndSerializedCode_RequestRevisionOffsetIssuanceRecord();
	}
	
	@Test(priority=61,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Serialized_Block_code_Start_End_on_Compliance_Instruments_table_for_Approved_Allowance_Issuance() throws Exception {
		//testCaseId ="39943"
		MCII = new Registry_Module3_MCII(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MCII.verifyStartAndEndSerializedCode_ApprovedAllowanceIssuanceRecord();
	}
	
}
