package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	public String testcaseName, testCaseDescription,Author,Category;
	public static ExtentReports extent ;
	public ExtentTest test;
	
	public void startReport() {
		extent = new ExtentReports("./report/report.html");
		
	}
	public void startTest(String testName, String description) {
	test = extent.startTest(testName,description);
	}
	public void logStatus(String status, String desc, boolean bflag) {
		
		if(bflag) {
			if(status.equalsIgnoreCase("PASS")) {
				test.log(LogStatus.PASS, desc);
			}else if(status.equalsIgnoreCase("fail")) {
				test.log(LogStatus.FAIL, desc);
			}
		}
	}
	
	public void logStatus(String status, String desc) {
		
		long number =100000l;
		number = takeSnap();
		
		
		if(status.equalsIgnoreCase("PASS")) {
			test.log(LogStatus.PASS, desc+test.addScreenCapture("../screenshots/snap"+number+".jpeg"));
		}else if(status.equalsIgnoreCase("FAIL")) {
			test.log(LogStatus.FAIL, desc+test.addScreenCapture("../screenshots/snap"+number+".jpeg"));
		}
			
		
	}
	public abstract long takeSnap();
	public void endTest() {
	extent.endTest(test);
	}
	public void endReport() {
		extent.flush();
	}

}

