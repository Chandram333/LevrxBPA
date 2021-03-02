package pom.testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import pom.pages.LoginPage;
import wrappers.ProjectWrappers;

public class TC001 extends ProjectWrappers{
	@BeforeClass
	public void setValues() {
		testcaseName = "TC001";
		testCaseDescription = "Login with valid credentials";
		Author = "chandu";
		Category = "dryRun";
		browser = "chrome";
		//dataSheetName = "TC001";
	}
	@Test(priority =0)
	public void LevrxPage() throws InterruptedException {
		
new LoginPage(driver, test)
.clickOnAccept()
.enteremailAddress()
.enterPassword()
.clickOnLogin()
.clickOnUser()
.clickOnLogout()
;





	}
	
	}


