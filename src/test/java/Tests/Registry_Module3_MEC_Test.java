package Tests;

import org.testng.annotations.Test;

import pageObjects.Registry_Module3_MEC;
import pageObjects.publicHomePage;
import resources.base;

public class Registry_Module3_MEC_Test extends base {
	Registry_Module3_MEC MEC;
	publicHomePage PH;
	
	
	@Test(priority=0,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_added_Exchange_and_Contract_Description_code_on_Exchange_and_Contract_Description_codes_Table() throws Exception{
		//testCaseId ="39969"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.addMEC();
		MEC.VerifyCodeAddedToMECTable();;
	}
	
	@Test(priority=1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_added_Exchange_and_Contract_Description_code_on_Edit_Exchange_and_Contract_Description_code_page() throws Exception {
		//testCaseId ="39970"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.addMEC();
		MEC.VerifyExchangeandContractDescriptionCodeHistoryTable();	
	}
	
	@Test(priority=2,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_of_Add_Exchange_and_Contract_Description_Code_page_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39971"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.verifyCancelBtnOnAddMEC();
	}
	
	@Test(priority=3,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_submenu_functionality_from_Quick_Actions_menu_in_Exchange_and_Contract_Description_Codes_table() throws Exception {
		//testCaseId ="39973"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.addMEC();
		MEC.navigateToEditExchangeandContractDescriptionCode();
	}
	
	@Test(priority=4,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Exchange_and_Contract_Description_Code_functionality_from_More_Actions_menu_in_Manage_Exchange_and_Contract_Description_Codes_page() throws Exception {
		//testCaseId ="39974"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
	}
	
	@Test(priority=5,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Quick_actions_and_More_Actions_button_on_Manage_Exchange_and_Contract_Description_Code_page_to_Jurisdiction_Users_other_than_Admin() throws Exception {
		//testCaseId ="39975"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "Authority");
		PH.secQueAns();
		MEC.verifyMECForAuth();
	}
	
	@Test(priority=6,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_button_functionality_while_editing_Exchang_and_Contract_Description_Code() throws Exception {
		//testCaseId ="39981"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.addMEC();
		MEC.navigateToEditExchangeandContractDescriptionCode();
		MEC.verifyCancelBtnOnEditMEC();
	}
	

	@Test(priority=7,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Displayed_in_DropDown_is_checked_on_Edit_Exchange_and_Contract_Description_Code_card() throws Exception {
		//testCaseId ="39977"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();	
		MEC.Verify_Displayed_in_Drop_Down_is_checked_on_Edit_Exchange_and_Contract_Description_Code_card();
	}
	

	@Test(priority=8,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Exchange_Contract_Description_Code_in_English_and_Contract_Description_Code_in_French_fields_by_keeping_fields_empty_on_Add_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39967"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();	
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_BykeepingFields_Empty_AddPage();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Sapce_AddPage();
	}
	
	@Test(priority=9,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Exchange_Contract_Description_Code_in_English_and_Contract_Description_Code_in_French_fields_on_Add_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39966"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Morethan63Char_AddPage();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_ExistingCode_AddPage();
	    MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Validdata_AddPage();
		
	}
	
	@Test(priority=10,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Displayed_in_Drop_Down_is_unchecked_in_Edit_Exchange_and_Contract_Description_Code_card() throws Exception {
		//testCaseId ="39979"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.Verify_Displayed_in_Drop_Down_is_Unchecked_on_Edit_Exchange_and_Contract_Description_Code_card();
	}
	
	@Test(priority=11,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Exchange_Contract_Description_Code_in_English_and_Contract_Description_Code_in_French_fields_by_keeping_fields_empty_on_Edit_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39985"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.Verify_previous_filled_data_Edit_Page();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_ByClearingFields_Empty_EditPage();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Sapce_EditPage();
	}
	
	@Test(priority=12,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Validation_of_Exchange_Contract_Description_Code_in_English_Contract_Description_Code_in_French_and_Comments_fields_on_Edit_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39984"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.Verify_previous_filled_data_Edit_Page();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_Morethan63Char_EditPage();
		MEC.Verify_Exchange_CDCEng_And_CDCFrench_Fields_By_Entering_ExistingCode_EditPage();
		MEC.verify_Comment_Field_EditPage();
	}
	
	@Test(priority=13,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Updated_data_after_Edit_Functionality_on_Manage_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39987"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.addMEC();
		MEC.verify_EditFunctionality_Other_JurisdictionAdmin();
	}
	
	@Test(priority=14,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Updated_data_after_Edit_Functionality_on_Edit_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39988"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.navigateToAddMEC();
		MEC.addMEC();
		MEC.verify_EditFunctionalityon_Edit_Exchange_and_Contract_Description_Code_page_Other_JurisdictionAdmin();
	}
	
	@Test(priority=15,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Manage_Exchange_and_Contract_Description_Code_Screen_for_All_Jurisdiction_Users() throws Exception {
		//testCaseId ="39962"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.verifyUI_ManageMECPage();
	}
	
	@Test(priority=16,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void UI_Verification_of_Add_Exchange_and_Contract_Description_Code_page_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39964"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.verifyUI_AddMEC();
	}
	
	@Test(priority=17,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_UI_of_Edit_Exchange_and_Contract_Description_Code_page() throws Exception {
		//testCaseId ="39982"
		MEC = new Registry_Module3_MEC(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		MEC.verifyUI_EditExchangeandContractDescriptionCode();
	}

}
