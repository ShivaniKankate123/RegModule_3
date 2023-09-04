package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import pageObjects.CommonMethods;
import pageObjects.Registry_Module3_MLE;
import pageObjects.publicHomePage;
import resources.ObjectRepo;
import resources.base;

public class Registry_Module3_MLE_Tests extends base {
	publicHomePage sc;
	Registry_Module3_MLE src;

	@Test(priority = 0, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_on_Edit_Limited_Exemption_Records_card() throws Exception {
		// testCaseId ="39616";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Fetch_Batch_Id_Saved();
		src.Cancel_On_Create_Limited_Exemption_in_Edit();
	}

	// Revisions Requsted testcaseId=39616
	@Test(priority = 1, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_on_Edit_Limited_Exemption_Records_card_for_Revisions_Requsted_Limited_Exemptions()
			throws Exception {
		// testcaseId="39616"
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Cancel_On_Create_Limited_Exemption_in_Edit_For_Revisions_Reqsuted_Limited_Exemptions();

	}

	@Test(priority = 2, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Limited_Exemption_functionality_for_Saved_or_Revision_Requested_batch_exemption()
			throws Exception {
		// testCaseId ="39613";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Fetch_Batch_Id_For_Create();
		src.Add_Limited_Exemption_Functionality();
	}

	// Add Limited Exemption for Revision Requsted status
	@Test(priority = 3, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Limited_Exemption_functionality_for_Revision_Requested_batch_exemption()
			throws Exception {
		// testCaseId ="39613";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security question is not display");
		}
		src.navigateToBatchExemption();
		src.Add_Limited_Exemption_Functionality_For_Revisions_Requsted();

	}

	// For Denied
	@Test(priority = 4, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_Limited_Exemption_information_functionality_in_Denied_status_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId="39617";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Deny_Generic_Method();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Edit_Limited_Exemption_For_Denied();
	}

	// For Proposed
	@Test(priority = 5, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_Limited_Exemption_information_functionality_in_Proposed_status_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId="39617";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Edit_Limited_Exemption_For_Proposed();

	}

	// For Approved
	@Test(priority = 6, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_Limited_Exemption_information_functionality_in_Approved_status_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId="39617";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		Thread.sleep(3000);
		src.navigateToBatchExemption();
		src.Approve_Generic_Method();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Edit_Limited_Exemption_For_Approved();
	}

	@Test(priority = 7, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Remove_Limited_Exemption_from_batch_by_jurisdiction_admin_in_Saved_status()
			throws Exception {
		// testCaseId="39902";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Fetch_Batch_Id_Saved();
		src.Remove_Saved_Limited_Exemption();
	}

	@Test(priority = 8, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Remove_Limited_Exemption_from_batch_by_jurisdiction_admin_in_Revision_Requested_status()
			throws Exception {
		// testCaseId="39903";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Remove__RevisionsRequested_Limited_Exemption();
	}

	@Test(priority = 9, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_Cancel_button_on_Entity_and_Limited_Exemption_Information_section_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="40392";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Cancel_Button_On_Entity_and_Limited_Exemption_Information_section();
	}

	@Test(priority = 10, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Create_Limited_Exemption_Batch() throws Exception {
		// testCaseId="39607";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.Create_Limited_Exemption_Batch();
	}

	@Test(priority = 11, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Add_Limited_Exemption() throws Exception {
		// testCaseId="40226";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption();
	}

	@Test(priority = 12, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_the_Batch_Name_field_on_the_Create_Limited_Exemption_Batch_page() throws Exception {
		// testCaseId="39603";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.Batch_Name_Field_Validation();
	}

	@Test(priority = 13, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Cancel_button_on_Create_Limited_Exemption_Batch_page()
			throws Exception {
		// testCaseId="39606";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.Cancel_Button_On_Create_Limited_Exemption_Batch();
	}

	@Test(priority = 14, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Effective_Date_field_on_the_Create_Limited_Exemption_page() throws Exception {
		// testCaseId="39648";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Effective_Date_Validation();
	}

	// This test case is for saved status Limited Exemptions
	@Test(priority = 15, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_for_Edit_Batch_Exemption_in_Saved_or_Revision_Requested_status()
			throws Exception {
		// testCaseId="39611";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Fetch_Batch_Id_Saved();
		src.Cancel_Button_For_Edit_Batch_Exemption_Saved_RevisionRequsted();
	}

	// This test case is for Revisions Requsted Limited Exemptions
	@Test(priority = 16, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_for_Edit_Batch_Exemption_in_Revision_Requested_status()
			throws Exception {
		// testCaseId="39611";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Cancel_Button_For_Edit_Batch_Exemption_RevisionRequsted();

	}

	@Test(priority = 17, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Batch_Exemption_Detail_page() throws Exception {
		// testCaseId="40394";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Cancel_Button_On_Batch_Exemption_Details_Page();
	}

	// Verification of functionality of 'Delete Batch Exemption' in 'Saved' status
	@Test(priority = 18, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Delete_Batch_Exemption_in_Saved_status() throws Exception {
		// testCaseId="39927";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Fetch_Batch_Id_Saved();
		src.Delete_Batch_Exemption();
	}

	@Test(priority = 19, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Request_revision_functionality_for_Jurisdiction_Authority() throws Exception {
		// testCaseId="39916";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted_Functionality();
	}

	@Test(priority = 20, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Comment_field_on_Batch_Exemption_Details_page_for_Request_Revision_functionality()
			throws Exception {
		// testCaseId="39917";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Comment_Verification_for_Request_Revisions();

	}

	@Test(priority = 21, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Passphrase_field_on_Passphrase_confirmation_popup_on_Batch_Exemption_Details_page_for_Request_Revision_functionality()
			throws Exception {
		// testCaseId="39918";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Passphrase_Verification();
	}

	@Test(priority = 22, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Passphrase_field_on_Passphrase_confirmation_popup_for_Deny_Batch_Exemption_Details_functionality()
			throws Exception {
		// testCaseId="39915";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Passphrase_Verification_Deny();
	}

	@Test(priority = 23, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Deny_Limited_exemption_batch_functionality_for_Jurisidiction_Authority()
			throws Exception {
		// testCaseId="39913";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Deny_Functionality();
	}

	@Test(priority = 24, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Comment_field_on_Batch_Exemption_Details_page_for_Deny_functionality()
			throws Exception {
		// testCaseId="39914";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Comment_Verification_for_Denied();
	}

	@Test(priority = 25, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Status_Update_after_Limited_Exemption_Batch_is_Revisions_Requested_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId="39924";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Status_Upadate_After_Request_Revisions();
		src.MyApprovals();
	}

	@Test(priority = 26, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_availibility_of_Edit_Limited_exemption_batch_to_Jurisidiction_Admin_in_Revision_Requested_status()
			throws Exception {
		// testCaseId="39925";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Availability_Of_Edit_Limited_Exemption_Batch();
	}

	@Test(priority = 27, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Pagination_on_Limited_Exemptions_Batches_table() throws Exception {
		// testCaseId="39890";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Pagination_Functionality();
	}

	@Test(priority = 28, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Entity_ID_field_on_the_Create_Limited_Exemption_page() throws Exception {
		// testCaseId="39646";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("Nova Scotia");
		sc.loginFunctionality("Nova Scotia", "JurisdictionAdmin");
		sc.secQueAns();
		src.OtherJUEntityId();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.GMPIEntityId();
		src.ClosedEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Entity_ID_Validation();
	}

	@Test(priority = 29, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_display_updated_information_on_the_Batch_Exemptions_page()
			throws Exception {
		// testCaseId="39612";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Fetch_Batch_Id_Saved();
		src.Updated_Information_After_Edit();
	}

	@Test(priority = 30, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_status_update_after_Limited_Exemption_batch_is_proposed_by_Jurisdiction_Admin()
			throws Exception {
		// testCaseId="39905";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Status_Update_After_Proposed_Limited_Exemption();
	}

	@Test(priority = 31, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Approve_Request_section_on_Proposed_Limited_Exemption_batch_page_for_Jurisdiction_Authority()
			throws Exception {
		// testCaseId="39906";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Approve_Requet_Section();
	}

	@Test(priority = 32, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_on_Batch_Exemption_Details_page() throws Exception {
		// testCaseId="39912";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Cancel_Button_On_Approve_Request_Card();
	}

	@Test(priority = 33, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Passphrase_field_on_Passphrase_confirmation_popup_for_approve_Batch_Exemption_Details_functionality()
			throws Exception {
		// testCaseId="39911";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Passphrase_Verification_For_Approve();
	}

	@Test(priority = 34, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Add_Limited_Exemption_for_same_entity_and_effective_date_in_another_batch_of_different_budget_year()
			throws Exception {
		// testCaseId="40130";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
//		src.Add_Limited_Exemption();
		src.Add_LE_For_Different_Batch_And_Budget_Year();
	}

	@Test(priority = 35, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Upload_File_functionality_with_file_having_no_records_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="39896";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Upload_Empty_File();
	}

	@Test(priority = 36, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Cancel_button_functionality_for_Upload_Files_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="39901";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Cancel_Button_On_Upload_Files();
	}

	@Test(priority = 37, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Effective_date_field_for_Upload_File_functionality_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="39898";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Effective_Date_Validation_For_Upload_File();
	}

	@Test(priority = 38, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Comments_field_for_Upload_File_functionality_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="39899";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Comments_Validation_For_Upload_File();
	}

	// saved Status
	@Test(priority = 39, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_functionality_for_Batch_Exemption_Information_card_in_Saved_or_Revision_Requested_status()
			throws Exception {
		// testCaseId="39610";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Fetch_Batch_Id_Saved();
		src.Edit_Functionality_For_Batch_Exemption_Card();
	}

	// Revisions Requsted status
	@Test(priority = 40, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_functionality_for_Batch_Exemption_Information_card_in_Revision_Requested_status()
			throws Exception {
		// testCaseId="39610";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Edit_Functionality_For_Batch_Exemption_Card_in_Revisions_Requsted();
	}

	@Test(priority = 41, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Approve_Limited_exemption_batch_functionality_for_Jurisidction_Authority()
			throws Exception {
		// testCaseId="39910";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Verfication_Of_Approve_Limited_Exemption_Functionality();
	}

	@Test(priority = 42, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Upload_File_Functionality_with_file_having_no_records_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="40400";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Upload_Empty_File();
	}

	@Test(priority = 43, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_number_of_rows_missing_for_Upload_File_functionality_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="40397";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Empty_Rows_Upload_File();
	}

	@Test(priority = 44, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Entity_ID_for_Uploading_duplicate_data() throws Exception {
		// testCaseId="40398";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Duplicate_Entity_ID();
	}

	@Test(priority = 45, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_file_language_for_Upload_File_functionality_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="40399";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.File_Language_For_Upload_File();
	}

	// For Saved Status
	@Test(priority = 46, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Verification_of_Add_Limited_Exemption_by_Upload_File_functionality_for_Saved_or_Revision_Requested_batch_exemption()
			throws Exception {
		// testCaseId="39614";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		// src.Fetch_Batch_Id_Saved();
		src.Add_Limited_Exemption_By_UploadFile();
	}

	// For Revisions Requsted
	@Test(priority = 47, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = false)
	public void Verification_of_Add_Limited_Exemption_by_Upload_File_functionality_for_Revision_Requested_batch_exemption()
			throws Exception {
		// testCaseId="39614";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToBatchExemption();
		src.Add_Limited_Exemption_By_UploadFile_For_RevisionsRequsted();
	}

	@Test(priority = 48, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Add_Limited_Exemption_for_same_entity_in_a_batch() throws Exception {
		// testCaseId="39649";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Validation_Of_Same_Entity_ID_For_Batch();
	}

	@Test(priority = 49, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_UI_of_Upload_Files_pop_up_of_Create_Limited_Exemptions_page() throws Exception {
		// testCaseId="40401";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.UI_Of_Upload_Files_Pop_Up();
	}
	//Saved Status
	@Test(priority = 50, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Batch_Details_page_for_Jurisidction_Authority_when_Limited_Exemption_batch_is_in_other_than_Proposed_status()
			throws Exception {
		// testCaseId="39909";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Saved_Batch_ID();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Batch_Details_Page_UI_For_JU_Au_Other_Than_Proposed_Status();
	}
	//Approved Status
	@Test(priority = 51, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Batch_Details_page_for_Jurisidction_Authority_when_Limited_Exemption_batch_is_in_other_than_Proposed_status_Approved()
			throws Exception {
		// testCaseId="39909";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Approve_Generic_Method();
		src.Batch_Details_Page_UI_For_JU_Au_Approved_Status();
	}
	//Revisions Requsted
	@Test(priority = 52, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Batch_Details_page_for_Jurisidction_Authority_when_Limited_Exemption_batch_is_in_other_than_Proposed_status_Revisions_Requsted()
			throws Exception {
		// testCaseId="39909";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Revisions_Requsted();
		src.Batch_Details_Page_UI_For_JU_Au_Revisions_Requsted_Status();
	}
	
	@Test(priority = 53, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Budget_Year_field_on_the_Create_Limited_Exemption_Batch_page() throws Exception {
		// testCaseId="39604";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.getBudget_Year_List();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.validation_BudgetYear();

	}

	@Test(priority = 54, retryAnalyzer = Analyzer.RetryAnalyzer.class, enabled = true)
	public void Validation_of_Limited_Exemption_quantity_for_Upload_File_functionality_on_Create_Limited_Exemption_page()
			throws Exception {
		// testCaseId="39894";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Validation_Of_Limited_Exemption_Quantity();
		src.Delete_Batch_Exemption_Functionality();
	}

	@Test(priority = 55, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_display_approved_Limited_Exemptions_in_Holding_Limits_table_on_Entity_Profile_page()
			throws Exception {
		// testCaseId="39920";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Approve_Add_Limited_Exemption_Generic_Method_For_Holding_Limit();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.Approve_Generic_Method();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "JurisdictionAdmin");
		try {
			sc.secQueAns();
		} catch (Exception e) {
			System.out.println("Security Question is not display");
		}
		src.navigateToLimitedExemption();
		src.Limited_Exemptions_In_Holding_Limit();
	}

	@Test(priority = 56, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_verification_of_Manage_Limited_Exemption_section_on_home_page() throws Exception {
		// testCaseId="39651";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.UI_Of_Manage_Limited_Exemption();
	}

	@Test(priority = 57, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Status_Update_after_Limited_Exemption_Batch_is_approved_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId="39919";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		Thread.sleep(3000);
		src.navigateToBatchExemption();
		src.Status_Update_After_Approved_Limited_Exemption();
		src.MyApprovals();
	}

	@Test(priority = 58, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Status_Update_after_Limited_Exemption_Batch_is_Denied_by_Jurisdiction_Authority()
			throws Exception {
		// testCaseId="39922";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Add_Limited_Exemption_Generic_Method();
		src.Propose_Limited_Exemptions();
		src.Fetch_Batch_Id_Propose();
		src.Log_Out_User();
		Thread.sleep(3000);
		sc.loginFunctionality("California", "Authority");
		sc.secQueAns();
		Thread.sleep(3000);
		src.navigateToBatchExemption();
		src.Status_Update_After_Deny_Limited_Exemption();
		src.MyApprovals();
	}

	@Test(priority = 59, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Batch_Exemptions_page() throws Exception {
		// testCaseId="39643";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.Batch_Exemption_Page_UI();

	}
	@Test(priority = 60, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_UI_of_Create_Limited_Exemption_Batch_page() throws Exception {
		// testCaseId="39602";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.SelectEntityId();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.Create_LImited_Exemption_Batch_UI();
	}
	@Test(priority = 61, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Limited_Exemption_field_on_the_Create_Limited_Exemption_page() throws Exception{
		// testCaseId="39647";
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.Limited_Exemptions_Field_Validation();
	}
	@Test(priority = 62, retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_comma_seperated_numeric_values_Limited_Exemption_for_Upload_File_functionality_on_Create_Limited_Exemption_page() throws Exception{
		// testCaseId="39895"
		sc = new publicHomePage(driver, prop);
		src = new Registry_Module3_MLE(driver);
		sc.selectJurisdiction("California");
		sc.loginFunctionality("California", "JurisdictionAdmin");
		sc.secQueAns();
		src.navigateToBatchExemption();
		src.navigateToCreateLimitedExemptionBatch();
		src.createBatch();
		src.UploadFile_CommaSeprated_Limited_Exemption();
	}

}