package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {
	
	static ExtentReports extentReport;
	static ExtentSparkReporter htmlReport;
	static ExtentTest  testcase;
	
	
	public static void report() {
		
		//Creating object for ExtentReport class
		extentReport = new ExtentReports();
		//Creating object for ExtentSparkReporter class
		htmlReport = new ExtentSparkReporter("ExtentReport.html");
		//Attach the html report to extent Report
		extentReport.attachReporter(htmlReport);
	}
	
	public static void createTestcase(String testcaseName) {
		//Creating testcase in report
		testcase=extentReport.createTest(testcaseName);
	}
	public static void status(Status status,String message) {
		
		//Writing the information about testcase in report
		testcase.log(status,message);
		
	}
	
	public static void addScreenShot(String path) {
		//Adding screenshot for testcase
		testcase.addScreenCaptureFromPath(path);
	}
	public static void writeReport() {
		
		//Writing the information in report
		extentReport.flush();
	}


}
