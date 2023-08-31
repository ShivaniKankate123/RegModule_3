package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterNG {
	public static ExtentReports extent;
	public static ExtentSparkReporter reporter;

	public static ExtentReports getReportObject() {

		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test Results");
		reporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Eqanim QA");
		extent.setSystemInfo("Enviornment", "QA Env");
		extent.setSystemInfo("OS", "Windows11");
		extent.setSystemInfo("Browser", "Chrome");
		return extent;

	}

}
