package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC002 extends ProjectWrappers{
	
	@BeforeClass
	public void setValues() {
		testcaseName = "TC002";
		testCaseDescription = "Login with Invalid credentials";
		Author = "chandu";
		Category = "dryRun";
		browser = "chrome";
		//dataSheetName = "TC002";
	}
	@Test(priority=1)
	public void levrxPage1() throws InterruptedException {
		new LoginPage(driver, test).clickOnAccept().clickOnLogin();
		new LoginPage(driver, test).verifyinvalidEmailText().verifyInvalidPasswordText();
	
		

		
	}
}
