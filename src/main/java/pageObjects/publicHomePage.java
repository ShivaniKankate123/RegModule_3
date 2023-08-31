package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import resources.ObjectRepo;
import resources.base;

public class publicHomePage {
	private WebDriver driver;
	Properties prop;

	@FindBy(xpath = "//div[text()='Select Jurisdiction']")
	WebElement SelectJurisdiction;
	@FindBy(xpath = "//span[text()=\"California\"]")
	WebElement CaliforniaJurisdiction;
	@FindBy(xpath = "//span[text()=\"Quebec\"]")
	WebElement QuebecJurisdiction;
	@FindBy(xpath = "//span[text()=\"Nova Scotia\"]")
	WebElement NSJurisdiction;
	@FindBy(xpath = "//span[text()=\"Washington\"]")
	WebElement WashingtonJurisdiction;
	@FindBy(xpath = "//button[text()='CONTINUE']")
	WebElement ContinueBtn;
	@FindBy(xpath = "//input[@name='email']")
	WebElement Username;
	@FindBy(xpath = "//input[@name='password']")
	WebElement Password;
	@FindBy(xpath = "//button[@id='login_btn']")
	WebElement LognBtn;
	@FindBy(xpath = "//h6[@class=\"MuiTypography-root MuiTypography-h6 css-1etlmxt\"]")
	WebElement SecQueAnswer;
	@FindBy(xpath = "//input[@id='Answer']")
	WebElement InputAnswer;
	@FindBy(xpath = "//button[@data-testid='priv_btn_ContinueBtn']")
	WebElement Continue;

	public publicHomePage(WebDriver driver,Properties prop) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
		this.prop=prop;
	}

	public void selectJurisdiction(String Jurisdiction) throws Exception {
		if (Jurisdiction.equals("California")) {
			SelectJurisdiction.click();
			CaliforniaJurisdiction.click();
			Thread.sleep(3000);
			ContinueBtn.click();
			ObjectRepo.test.log(Status.PASS, "Selects California Jurisdiction ");
		} else if (Jurisdiction.equals("Quebec")) {
			SelectJurisdiction.click();
			QuebecJurisdiction.click();
			Thread.sleep(3000);
			ContinueBtn.click();
			ObjectRepo.test.log(Status.PASS, "Selects Quebec Jurisdiction ");
		} else if (Jurisdiction.equals("Nova Scotia")) {
			SelectJurisdiction.click();
			NSJurisdiction.click();
			Thread.sleep(3000);
			ContinueBtn.click();
			ObjectRepo.test.log(Status.PASS, "Selects Nova Scotia Jurisdiction ");
		} else if (Jurisdiction.equals("Washington")) {
			SelectJurisdiction.click();
			WashingtonJurisdiction.click();
			Thread.sleep(3000);
			ContinueBtn.click();
			ObjectRepo.test.log(Status.PASS, "Selects Washington Jurisdiction ");
		}

	}

	public void loginFunctionality(String JurisdictionUser, String UserType) throws Exception {
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		if (UserType.contains("JurisdictionAdmin")) {
			if (JurisdictionUser.equals("California")) {
				Username.sendKeys(prop.getProperty("CaliforniaAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with California Jurisdiction Admin ");
			} else if (JurisdictionUser.equals("Quebec")) {
				Username.sendKeys(prop.getProperty("QuebecAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Quebec Jurisdiction Admin ");
			} else if (JurisdictionUser.equals("Nova Scotia")) {
				Username.sendKeys(prop.getProperty("NSAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Nova Scotia Jurisdiction Admin ");

			} else if (JurisdictionUser.equals("Washington")) {
				Username.sendKeys(prop.getProperty("WashingtonAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Washington Jurisdiction Admin ");

			}
		}

		else if (UserType.contains("Authority")) {
			if (JurisdictionUser.equals("California")) {
				Username.sendKeys(prop.getProperty("CaliforniaAuthUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with California Jurisdiction Authority ");
			} else if (JurisdictionUser.equals("Quebec")) {
				Username.sendKeys(prop.getProperty("QuebecAuthUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Quebec Jurisdiction Authority ");
			} else if (JurisdictionUser.equals("Nova Scotia")) {
				Username.sendKeys(prop.getProperty("NSAduthUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Nova Scotia Jurisdiction Authority ");

			} else if (JurisdictionUser.equals("Washington")) {
				Username.sendKeys(prop.getProperty("WashingtonAuthUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Washington Jurisdiction Authority ");

			}

		} else if (UserType.contains("WciincAdmin")) {
			if (JurisdictionUser.equals("California")) {
				Username.sendKeys(prop.getProperty("WCiAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with WCI Inc Admin ");
			} else if (JurisdictionUser.equals("Quebec")) {
				Username.sendKeys(prop.getProperty("WCiAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with WCI Inc Admin ");
			} else if (JurisdictionUser.equals("Nova Scotia")) {
				Username.sendKeys(prop.getProperty("WCiAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with WCI Inc Admin ");
			} else if (JurisdictionUser.equals("Washington")) {
				Username.sendKeys(prop.getProperty("WCiAdminUsername"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with WCI Inc Admin ");
			}
		}
		else if (UserType.contains("Registrar")) {
			if (JurisdictionUser.equals("California")) {
				Username.sendKeys(prop.getProperty("CaliforniaRegistrar"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with California Registrar Admin ");
			} else if (JurisdictionUser.equals("Quebec")) {
				Username.sendKeys(prop.getProperty("QuebecRegistrar"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Quebec Registrar Admin ");
			} else if (JurisdictionUser.equals("Nova Scotia")) {
				Username.sendKeys(prop.getProperty("NSRegistrar"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with NS Registrar Admin ");
			} else if (JurisdictionUser.equals("Washington")) {
				Username.sendKeys(prop.getProperty("WashingtonRegistrar"));
				Password.sendKeys(prop.getProperty("Password"));
				LognBtn.click();
				ObjectRepo.test.log(Status.PASS, "Logged in with Washington Registrar Admin ");
			}
		}
		
		
	}
	public void secQueAns(){
		if(SecQueAnswer.isDisplayed()) {
			String SecQue = SecQueAnswer.getText();
			if(SecQue.contains("first car?")) {
				InputAnswer.sendKeys("cccc");	
				Continue.click();
			}
			else if(SecQue.contains("maiden name?")) {
				InputAnswer.sendKeys("bbbb");
				Continue.click();
			}
			else if(SecQue.contains("first job?")) {
				InputAnswer.sendKeys("aaaa");
				Continue.click();
			}
		}
		else {
			System.out.println("Security Question is not displayed");
		}
	}
	
	
	
}
