package pom.pages;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.GenericWrappers;

public class LoginPage extends GenericWrappers {
	public LoginPage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	public LoginPage clickOnAccept() {
		clickByXpath(objprop.getProperty("LoginPage.clickByXpath"));
		return this;
		
	
	}
	
	
	public LoginPage enteremailAddress() {
		enterByXpath("//input[@id = 'ember9']","TestProvider1Levrx@gmail.com");
		//enterByXpath(objprop.getProperty("LoginPage.enterByXpath"),"TestProvider1Levrx@gmail.com");
		
		return this;
		
	}
	
	public LoginPage enterPassword() {
		enterByXpath(objprop.getProperty("LoginPage.enterByXpath"), "LevrxDemo1!");
		return this;
		
		}
	public LoginPage verifyinvalidEmailText() {
		verifyTextByXpath("(//div[@class='invalid-feedback'])[1]", "Email address can't be blank");
		return this;
		
	}
	public LoginPage verifyInvalidPasswordText() {
		verifyTextByXpath("(//div[@class='invalid-feedback'])[2]", "Password can't be blank");
		return this;
		
	}
	
	public LoginPage clickOnForgotPassword() {
		clickByXpath("//a[@id='ember46']");
		return this;
	}
	
	
	public HomePage clickOnLogin() throws InterruptedException {
		clickByXpath(objprop.getProperty("HomePage.clickByXpath"));
		//clickByXpath("//span[contains(text(),'Sign In')]");
		Thread.sleep(3000);
		return new HomePage(driver, test);
	}

}
