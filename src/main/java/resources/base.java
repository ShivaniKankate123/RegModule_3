package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;

import com.qa.testrailmanager.TestRailManager;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners(resources.listeners.class)
public class base {

	protected static WebDriver driver;
	public static Properties prop;
	public static ConfigDataProvider config;
	protected String testCaseId;
//	public static ExcelDataProvider excel;
//	public static ExcelDataProvider excel;

	@BeforeSuite
	public void start() throws Exception { 
		config = new ConfigDataProvider(); 
//		excel = new ExcelDataProvider();
	}

	@AfterMethod
	public void addResultToTestrail(ITestResult result) {
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_PASS_STATUS,
//					"testcase passed through script" + "  " + result.getName() + "  is passed");
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			TestRailManager.addResultsForTestCase(testCaseId, TestRailManager.TEST_CASE_FAIL_STATUS,
//					"testcase failed through script" + "  " + result.getName() + "is Failed");
//		}
//		driver.quit();
	}

	@AfterClass
	public void closeBrowser() {
//		driver.close();
	} 
 
	@BeforeMethod
	public void setup() throws IOException {
		File src = new File(System.getProperty("user.dir") + "/config.properties");
		FileInputStream fis = new FileInputStream(src);
		prop = new Properties();
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get(config.getBaseUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browserName.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			driver.get(config.getBaseUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		} else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			driver.get(config.getBaseUrl());
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
	}

	public String getScreenShotPath(String testCaseName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\Screenshots\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public void mail() throws InterruptedException {
		final String username = "eqanimautotestuser@outlook.com";
		final String password = "Eqanim@1234";
		final String from = "eqanimautotestuser@outlook.com";
		final String to = "vishal.giram@eqanim.com,ppanigrahi@wci-inc.org,padmakar.mohire@eqanim.com,vikram.kankure@eqanim.com,tushar@eqanim.com,seema.sandbhor@eqanim.com";
		final String cc = " ";
		final String subject = "Report-Daily Healthcheck testrail run -R102";
		final String msg = "Report after test suite RUN";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.outlook.com"); 
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.ssl.protocols", "TLSv1.2");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setRecipients(Message.RecipientType.CC, InternetAddress.parse(cc));
			message.setSubject(subject);
			message.setText(msg);
			MimeBodyPart messageBodyPart = new MimeBodyPart();
			Multipart multipart = new MimeMultipart();
			messageBodyPart = new MimeBodyPart();
			String file1 = System.getProperty("user.dir")+"\\reports\\index.html"; // change
			System.out.println("filePath : "+file1);
			String fileName1 = "index.html";
			DataSource source1 = new FileDataSource(file1);
			messageBodyPart.setDataHandler(new DataHandler(source1));
			messageBodyPart.setFileName(fileName1);
			multipart.addBodyPart(messageBodyPart);
			message.setContent(multipart);
			System.out.println("Sending");
			Transport.send(message); 
			System.out.println("Done");
		} catch (MessagingException e) {
			e.printStackTrace(); 
		}
	}

	@AfterSuite
	public void sentReportToTheMail() throws InterruptedException {
		base ref = new base();
//		ref.mail();
	}

}
