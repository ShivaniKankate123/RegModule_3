package Tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import pageObjects.RegModule3_MJB_POM;
import pageObjects.publicHomePage;
import resources.base;

public class RegModule3_MJB_Tests extends base {

	@Test (priority=22,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_MANAGE_JURISDICTIONS_Grid_UI_and_navigation_to_Manage_Jurisdiction_Page_for_WCI_Inc_Admin()
			throws Exception {
		// testCaseId ="39412"; RPM3-197

		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.selectJurisdictionToAddBudgetRecord();
	}

	@Test(priority=23,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Budget_Records_page_UI_for_WCI_Inc_Admin() throws Exception {
		// testCaseId ="39413"; RPM3-106

		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.navigateToAddBudgetRecordsPage_WCIAdmin();
		ref.addBudgetRecordPageUI();
	}

	@Test(priority=24,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Budget_Records_functionality_for_WCI_Inc_Admin() throws Exception {
		// testCaseId ="39414"; RPM3-106

		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.navigateToAddBudgetRecordsPage_WCIAdmin();
		ref.addBudgetRecordPopup();
	}

	// C39415 is pending (Validation Test Case)

	@Test(priority=25,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Add_Budget_Records_for_WCI_Inc_Admin_with_added_mandatory_inputs()
			throws Exception {
		// testCaseId ="39416"; RPM3-106
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.navigateToAddBudgetRecordsPage_WCIAdmin();
		ref.cancelButtonOnAddBudgetRecordPage();
	}

	@Test(priority=26,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Validation_on_Duplicate_Budget_Records_for_Budget_Year_Validation_on_Add_Budget_Records_page()
			throws Exception {
		// testCaseId ="39417"; RPM3-124
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.addBudgetRecordValidations();
	}

	@Test(priority=27,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_validation_of_Mandatory_Fields_on_Add_Budget_Records_page_by_keeping_it_empty()
			throws Exception {
		// testCaseId ="39418"; RPM3-124
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();		
		ref.addBudgetRecordValidationsbykeepingMandatoryFieldsempty();
	}
	
	// C39419, 20 are pending (Validation Test Case)

	@Test(priority=1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Functionality_of_Cancel_Button_on_Add_Budget_Record_Page() throws Exception {
		// testCaseId ="39426"; RPM3-126
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.navigateToAddBudgetRecordsPage_WCIAdmin();
		ref.cancelButtonFunctionalityOnAddBudgetRecordPage();
	}

	@Test(priority=2,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Edit_Budget_Record_card_by_WCI_Inc_Admin_for_the_Budget_Record_from_Effective_Budget_Records_table()
			throws Exception {
		// testCaseId ="39841"; RPM3-131
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.cancelButtonFunctionalityOnEditBudgetRecordPageForEffectiveBudgetRecords();
	}

	@Test(priority=3,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Edit_Record_card_by_WCI_Inc_Admin_for_the_Budget_Record_from_Proposed_Budget_Records_table()
			throws Exception {
		// testCaseId ="39842"; RPM3-131
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.cancelButtonFunctionalityOnEditBudgetRecordPageForProposedRequestRevisionBudgetRecords();
	}

	@Test(priority=4,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Reset_button_on_Proposed_Budget_Records_section_on_Budget_Records_page_Admin()
			throws Exception {
		// testCaseId ="39444"; RPM3-135
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.verifyFunctionalityOfResetButton0nProposedBudgetRecordsForAdmin();
	}

	@Test(priority=5,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Reset_button_functionality_on_Proposed_Budget_section_Authority() throws Exception {
		// testCaseId ="39459"; RPM3-140
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "Authority");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.verifyFunctionalityOfResetButton0nProposedBudgetRecordsForAuthority();
	}

	@Test(priority=6,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_view_Jurisdiction_Allowance_Request_Status_History_Grid_for_All_Jurisdiction_Users()
			throws Exception {
		// testCaseId ="39432"; RPM3-181 []
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.verifyJurisdictionAllowanceRequestStatusHistoryGridForAdmin();
		// driver.close();
		Thread.sleep(4000);
		publicHomePage php1 = new publicHomePage(driver,prop);
		// php1.selectJurisdiction("California");
		php1.loginFunctionality("California", "Authority");
		php1.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref1 = new RegModule3_MJB_POM(driver);
		ref1.verifyJurisdictionAllowanceRequestStatusHistoryGridForAuthority();		
	}

	@Test(priority=7,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Deny_functionality_of_Jurisdiction_Budget_by_Jurisdiction_Admin() throws Exception {
		// testCaseId ="39854"; RPM3-136
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.DenyRecord_JAdmin1();
	}

	@Test(priority=8,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_status_and_Budget_Record_Status_for_Jurisdiction_Admin_after_Denial_of_Budget_Record_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39856"; RPM3-136
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.DenyRecord_JAdmin();
		ref.VerifyRequeststatusBudgetRecordStatusforJuriAdminAfterDenialofBudgetRecord();
	}

	@Test(priority=9,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Pending_Queue_of_Approval_after_Denial_of_Budget_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39857"; RPM3-136
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.DenyRecord_JAdmin();
		ref.VerifyPendingQueueofApprovalafterDenialofBudget();
	}

	@Test(priority=10,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_status_and_Budget_Record_Status_for_WCI_Inc_Admin_after_Denial_of_Budget_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39858"; RPM3-136
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.DenyRecord_JAdmin();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "WciincAdmin");
//		php.secQueAns();
		Thread.sleep(8000);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.VerifyRequestStatusForWCIIncAdminAfterDenial();
	}

	@Test(priority=11,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Proposed_Budget_Record_table_after_Denial_of_Budget_by_Jurisdiction_Admin_for_WCI_Inc_Admin()
			throws Exception {
		// testCaseId ="39859"; RPM3-136
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.DenyRecord_JAdmin();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "WciincAdmin");
		// php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.VerifyBudgetRecordStatusAfterDenialForWCIIncAdmin();
	}

	@Test(priority=12,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Budget_Year_is_display_on_the_Add_Budget_screen_for_WCI_Inc_Admin_after_denial_of_the_Budget_record_by_the_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39860"; RPM3-136
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.DenyRecord_JAdmin();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "WciincAdmin");
		// php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.VerifyBudgetYearIsDisplayOnTheAddBudgetScreenFoWCIncAdminAfterDenial();
	}

	@Test(priority=13,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_functionality_of_Jurisdiction_Budget_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39874"; RPM3-137
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.RequestRevisionRecord_JAdmin1();
	}

	@Test(priority=14,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_status_and_Budget_Record_Status_for_Jurisdiction_Admin_after_Request_Revision_of_Budget_Record_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39876"; RPM3-137
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.RequestRevisionRecord_JAdmin();
		ref.VerifyRequeststatusBudgetRecordStatusforJuriAdminAfterRequestRevisionofBudgetRecord();
		ref.VerifyRequeststatusBudgetRecordStatusforJuriAuthorityAfterRequestRevisionofBudgetRecord();
	}

	@Test(priority=15,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Proposed_Budget_Record_table_after_Request_Revision_of_Budget_by_Jurisdiction_Admin_for_WCI_Inc_Admin()
			throws Exception {
		// testCaseId ="39877"; RPM3-137
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.RequestRevisionRecord_JAdmin();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "WciincAdmin");
		// php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();		
		ref.VerifyBudgetRecordStatusAfterRequestRevisionForWCIIncAdmin();
	}

	@Test(priority=16,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_budget_records_in_Proposed_Budget_Queue_for_WCI_Inc_Admin_after_Request_Revision_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId ="39878"; RPM3-137
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.Propose_Record_Functionality();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "JurisdictionAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToBudgetRecordsPage_JAdmin();
		ref.RequestRevisionRecord_JAdmin();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "WciincAdmin");
		// php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.VerifyRequestRevisionRecordsInProposedBudgetQueueForWCIIncAdminAfterRequestRevision();
	}

	@Test(priority=17,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_View_Request_History_Table_for_WCI_Inc_Admin_User() throws Exception {
		// testCaseId ="39416"; RPM3-127
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.VerifyViewRequestHistoryTableforWCIIncAdmin();
	}

	@Test(priority=18,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_functionality_of_Jurisdiction_Budget_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId ="39882"; RPM3-142
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.RequestRevision_Functionality_ByJAuth();
	}

	@Test(priority=19,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Budget_Record_status_and_Request_status_after_Request_Revision_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId ="39884"; RPM3-142
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.RequestRevision_Functionality_ByJAuth();
		ref.VerifyRequeststatusBudgetRecordStatusforJuriAuthorityAfterRequestRevisionofBudgetRecord();
	}

	@Test(priority=20,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_budget_records_in_the_Pending_Approval_Queue_after_Request_Revision_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId ="39885"; RPM3-142
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.RequestRevision_Functionality_ByJAuth();
		ref.VerifyBudgetRecordStatusforJuriAuthorityAfterRequestRevisionofBudgetRecord();
	}

	@Test(priority=21,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_Revision_budget_records_in_Proposed_Budget_Queue_for_WCI_Inc_Admin_after_Request_Revision_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId ="39886"; RPM3-142
		publicHomePage php = new publicHomePage(driver,prop);
		php.selectJurisdiction("California");
		php.loginFunctionality("California", "WciincAdmin");
		php.secQueAns();
		Thread.sleep(4000);
		RegModule3_MJB_POM ref = new RegModule3_MJB_POM(driver);
		ref.RequestRevision_Functionality_ByJAuth();
		ref.LogoutFunctionality();
		Thread.sleep(4000);
		php.loginFunctionality("California", "WciincAdmin");
		//php.secQueAns();
		Thread.sleep(4000);
		ref.navigateToManageJurisdictionBudget_WCIAdmin();
		ref.VerifyRRBudgetRecordsInProposedBudgetQueueForWCIIncAdminAfterRRByJuriAuthority();
	}
}
