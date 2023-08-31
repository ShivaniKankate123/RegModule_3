package Tests;

import org.testng.annotations.Test;
import pageObjects.Registry_Module3_OM;
import pageObjects.publicHomePage;
import resources.base;

public class Registry_Module3_OM_Test extends base{
	Registry_Module3_OM OM;
	publicHomePage PH;
	
	@Test(priority=0,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_UI_of_Add_Offset_Project_Name_screen_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39990"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyUI_addOffsetProjectName();
	}
	
	@Test(priority=1,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_functionality_for_Offset_Project_Name_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39995"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyCancelBtn_addOffsetProjectName();
	}
	
	@Test(priority=2,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Quick_Action_menu_on_Offset_Project_Name_Management_page() throws Exception {
		//testCaseId ="39997"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyQuickAction_OffsetProjectNameManagement();
	}
	
	@Test(priority=3,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Cancel_button_in_the_Edit_Offset_Project_Name_screen() throws Exception {
		//testCaseId ="40114"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyCancelBtn_EditOffsetProjectName();
	}
	
	@Test(priority=4,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Offset_Project_Name_functionality_on_Add_Offset_Project_Name_page_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="39994"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyAddedOffsetProjectNameInOffsetIssuance();
	}
	
	// In Progress
	@Test(priority=5,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_Offset_Project_Name_functionality() throws Exception {
		//testCaseId ="40095"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verify_EditOffsetProjectNameFunctionality();
	}
	
	@Test(priority=6,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_functionality_for_Offset_Project_Operator_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40103"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyCancelBtn_AddOffsetProjectOperator();
	}
	
	@Test(priority=7,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Cancel_functionality_for_Verification_Body_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40111"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyCancelBtn_AddVerificationBody();
	}
	
	@Test(priority=8,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_UI_of_Offset_Project_Name_Management_page() throws Exception {
		//testCaseId ="39996"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyUI_OffsetProjectNameManagement();
	}
	
	@Test(priority=9,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_UI_of_Add_Offset_Project_Operator_screen_for_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40098"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyUI_AddOffsetProjectOperator();
	}
	
	@Test(priority=10,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_CANCEL_button_in_the_Edit_Offset_Project_Operator_screen() throws Exception {
		//testCaseId ="40121"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyCancelBtn_EditOffsetProjectOperator();
	}
	
	@Test(priority=11,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Cancel_button_in_the_Edit_Verification_Body_screen() throws Exception {
		//testCaseId ="40128"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyCancelBtn_EditVerificationBody();
	}
	
	@Test(priority=12,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Displayed_in_DropDown_on_Edit_Offset_Project_Name_screen() throws Exception {
		//testCaseId ="40112"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyDisplayInDropDownFunctionality_EditOffsetProjectName();
	}
	
	@Test(priority=13,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_DisplayOrStop_Display_In_Dropdown_submenu_functionality_from_Quick_Actions_menu_in_Offset_Project_Name_table() throws Exception {
		//testCaseId ="40113"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyDisplayOrStopDisplayInDropdownFunctionality_QuickActions_OffsetProjectName();
	}
	
	@Test(priority=14,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Offset_Project_Operator_functionality_on_Add_Offset_Project_Operator_page_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40102"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyAddOffsetProjectOperatorFunctionality();
	}
	
	@Test(priority=15,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Displayed_in_DropDown_on_Edit_Offset_Project_Operator_screen() throws Exception {
		//testCaseId ="40119"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyDisplayInDropDownFunctionality_EditOffsetProjectOperator();
	}
	
	@Test(priority=16,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Quick_Action_menu_on_Offset_Project_Operator_Management_page() throws Exception {
		//testCaseId ="40097"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyQuickAction_OffsetProjectOperatorManagement();
	}
	
	@Test(priority=17,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Quick_Action_menu_on_Verification_Body_Management_Screen() throws Exception {
		//testCaseId ="40105"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyQuickAction_VerificationBodyManagement();
	}
	
	@Test(priority=18,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_Offset_Project_Operator_functionality() throws Exception {
		//testCaseId ="40118"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verify_EditOffsetProjectOperatorFunctionality();
	}
	
	@Test(priority=19,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Add_Verification_Body_functionality_on_Add_Verification_Body_page_by_Jurisdiction_Admin() throws Exception {
		//testCaseId ="40110"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyAddVerificationBodyFunctionality();
	}
	
	@Test(priority=20,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Edit_Verification_Body_functionality() throws Exception {
		//testCaseId ="40125"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verify_EditVerificationBodyFunctionality();
	}
	
	@Test(priority=21,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Display_Stop_Display_In_Dropdown_submenu_functionality_from_Quick_Actions_menu_in_Offset_Project_Operator_table() throws Exception {
		//testCaseId ="40120"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyDisplayOrStopDisplayInDropdownFunctionality_QuickActions_OffsetProjectOperator();
	}
	
	@Test(priority=22,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_Display_Stop_Display_In_Dropdown_submenu_functionality_from_Quick_Actions_menu_in_Verification_Body_table() throws Exception {
		//testCaseId ="40120"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyDisplayOrStopDisplayInDropdownFunctionality_QuickActions_VerificationBody();
	}
	
	@Test(priority=23,retryAnalyzer = Analyzer.RetryAnalyzer.class)
	public void Verification_of_functionality_of_Displayed_in_Drop_Down_on_Edit_Verification_Body_screen() throws Exception {
		//testCaseId ="40119"
		OM = new Registry_Module3_OM(driver);
		PH= new publicHomePage(driver, prop);
		PH.selectJurisdiction("California");
		PH.loginFunctionality("California", "JurisdictionAdmin");
		PH.secQueAns();
		OM.verifyDisplayInDropDownFunctionality_EditVerificationBody();
	}

}
