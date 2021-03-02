package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import wrappers.ProjectWrappers;

public class HomePage extends ProjectWrappers {
	
	public HomePage(RemoteWebDriver driver, ExtentTest test) {
		this.driver=driver;
		this.test=test;
	}
	
	public HomePage clickOnUser() throws InterruptedException {
		//clickByXpath(objprop.getProperty("HomePage.clickByXpath"));
		
		WebElement element = driver.findElement(By.xpath("//small[contains(text(),'Test Provider1Levrx')]"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		Thread.sleep(3000);
		
		//clickByXpath("//small[contains(text(),'Test Provider1Levrx')]");
		//System.out.println("clicked on user");
		return this;
		
	}
	public HomePage clickOnLogout() {
		//clickByXpath(objprop.getProperty("HomePage.clickByXpath"));
		clickByXpath("//small[contains(text(),'Sign Out')]");
		
		return this;
		
	}

	
}
