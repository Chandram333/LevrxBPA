package wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.ElementNotSelectableException;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import utils.Reporter;

public class GenericWrappers extends Reporter  implements Wrappers {
	
	public RemoteWebDriver driver;
	public static Properties objprop;
	
	public void loadObjects() {
		 objprop = new Properties();
		 
		 try {
			objprop.load(new FileInputStream("./src/main/resources/object.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void unloadObjects() {
		objprop = null;
	}
	
	public void invokeApp(String browser, String url) {
		// TODO Auto-generated method stub
		try {
		if(browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium_Workspace\\chromedriver.exe");
		     driver = new ChromeDriver();
			}
		else if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "./driver.firefoxdriver.exe");
			driver = new FirefoxDriver();
			}
		else if(browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "./driver.ie.exe");
			driver = new InternetExplorerDriver();
			}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		//System.out.println("The given URL '" + url + "' is launched in '" + browser + "' browser successfully.");
	
		logStatus("PASS","The given URL '" + url + "' is launched in '" + browser + "' browser successfully ");
		
	} catch (TimeoutException e) {
		//System.err.println("The specified time got expired. Unable to launch the URL with all webelements.");
		logStatus("FAIL", "The specified time got expired. Unable to launch the URL with all webelements.");
		
	} catch (WebDriverException e) {
		//System.err.println("The given URL '" + url + "' is not launched in '" + browser + "' browser successfully.");
		logStatus("FAIL", "The given URL '" + url + "' is not launched in '" + browser + "' browser successfully.");
	}
       
		
	}

	public void enterByXpath(String xpathValue, String data) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathValue).sendKeys(data);
			//System.out.println("The webelement with the XPATH: '" + xpathValue+ "' is identified and entered with the data '" + data + "' successfully.");
			logStatus("PASS", "The webelement with the XPATH: '" + xpathValue+ "' is identified and entered with the data '" + data + "' successfully.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathValue + "' is not found.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathValue + "' is not found.");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathValue + "' is not visible.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathValue + "' is not visible.");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The webelement with the XPATH '" + xpathValue + "' is not enabled.");
			logStatus("FAIL", "The webelement with the XPATH '" + xpathValue + "' is not enabled.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		}
		
	}

	public void verifyTextByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String strTextAct = null;
		try {
			strTextAct = driver.findElementByXPath(xpath).getText();
			if (strTextAct.equals(text)) {
				//System.out.println("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath + "' exactly matches with the Expected Text '" + text + "'.");
				logStatus("PASS", "The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath+ "' exactly matches with the Expected Text '" + text + "'.");
			} else {
				//System.err.println("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath + "' doesn't exactly matches with the Expected Text '" + text + "'.");
				logStatus("FAIL", "The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath + "' doesn't exactly matches with the Expected Text '" + text + "'.");
			}
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public void verifyTextContainsByXpath(String xpath, String text) {
		// TODO Auto-generated method stub
		String strTextAct = null;
		try {
			strTextAct = driver.findElementByXPath(xpath).getText();
			if (strTextAct.contains(text)) {
				//System.out.println( "The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath+ "' partially matches with the Expected Text '" + text + "'.");
				logStatus("PASS", "The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath+ "' partially matches with the Expected Text '" + text + "'.");
			} else {
				//System.err.println("The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath+ "' doesn't partially matches with the Expected Text '" + text + "'.");
				logStatus("FAIL", "The Actual Text '" + strTextAct + "' from the XPATH: '" + xpath+ "' doesn't partially matches with the Expected Text '" + text + "'.");
			}
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public void clickByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		try {
			driver.findElementByXPath(xpathVal).click();
			//System.out.println("The webelement with the XPATH: '" + xpathVal + "' is identified and clicked successfully.");
			logStatus("PASS", "The webelement with the XPATH: '" + xpathVal + "' is identified and clicked successfully.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not found.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not found.");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not visible.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not visible.");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not enabled.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not enabled.");
			
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
	}

	public String getTextByXpath(String xpathVal) {
		// TODO Auto-generated method stub
		String strText = null;
		try {
			strText = driver.findElementByXPath(xpathVal).getText();
			//System.out.println("The webelement with the XPATH: '" + xpathVal+ "' is identified and the available text is '" + strText + "'.");
			logStatus("PASS", "The webelement with the XPATH: '" + xpathVal+ "' is identified and the available text is '" + strText + "'.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not found.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not found.");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not visible.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not visible.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		return strText;
	}
		
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		String strWinsName = null;
		boolean blnFound = false;
		try {
			Set<String> allWins = driver.getWindowHandles();
			for (String eachWins : allWins) {
				driver.switchTo().window(eachWins);
				blnFound = true;
				break;
			}
			if (blnFound) {
				//System.out.println("The latest window (" + strWinsName + ") is focused successfully.");
				logStatus("PASS", "The latest window (" + strWinsName + ") is focused successfully.");
			} else {
				//System.err.println("The parent window is not found.");
				logStatus("FAIL", "The parent window is not found");
			}
		} catch (NoSuchWindowException e) {
			//System.err.println("the 	target window is unavailable so the window switch is unsuccessful.");
			logStatus("FAIL", "the 	target window is unavailable so the window switch is unsuccessful.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public void switchToLastWindow() {
		// TODO Auto-generated method stub
		String strWinsName = null;
		boolean blnFound = false;
		try {
			Set<String> allWins = driver.getWindowHandles();
			for (String eachWins : allWins) {
				driver.switchTo().window(eachWins);
				strWinsName = eachWins;
				blnFound = true;
			}
			if (blnFound) {
				//System.out.println("The latest window (" + strWinsName + ") is focused successfully.");
			//	logStatus("PASS", "The latest window (" + strWinsName + ") is focused successfully.");
			} else {
				//System.err.println("The lastest window is not found.");
			//	logStatus("FAIL", "The lastest window is not found.");
			}
		} catch (NoSuchWindowException e) {
			//System.err.println("The window switch is unsuccessful as the 	target window is unavailable.");
			logStatus("FAIL", "The window switch is unsuccessful as the 	target window is unavailable.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
	}

	public void acceptAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().accept();
			//System.out.println("The alert has been accepted successfully.");
		//	logStatus("PASS", "The alert has been accepted successfully.");
		} catch (NoAlertPresentException e) {
			//System.err.println("There is not alert displayed to handle.");
			logStatus("FAIL", "There is not alert displayed to handle.");
			
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public void dismissAlert() {
		// TODO Auto-generated method stub
		try {
			driver.switchTo().alert().dismiss();
			//System.out.println("The alert has been dismissed successfully.");
			logStatus("PASS", "The alert has been dismissed successfully.");
		} catch (NoAlertPresentException e) {
			//System.err.println("There is not alert displayed to handle.");
			logStatus("FAIL", "There is not alert displayed to handle.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public String getAlertText() {
		// TODO Auto-generated method stub
		String strAlertText = null;
		try {
			strAlertText = driver.switchTo().alert().getText();
			//System.out.println("The text in the displayed alert is '" + strAlertText + "'.");
			logStatus("PASS", "The text in the displayed alert is '" + strAlertText + "'.");
		} catch (NoAlertPresentException e) {
			//System.err.println("There is not alert displayed to handle.");
			logStatus("FAIL", "There is not alert displayed to handle.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		return strAlertText;
	}
	

	public void closeBrowser() {
		// TODO Auto-generated method stub
		try {
			driver.close();
			//System.out.println("The active browser is closed successully.");
			logStatus("PASS", "The active browser is closed successully.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
	}

	public void closeAllBrowsers() {
		// TODO Auto-generated method stub
		try {
			if (driver != null) {
				driver.quit();
				//System.out.println("All the browsers are closed successully.");
				logStatus("PASS", "All the browsers are closed successully.", true);
			}
		} catch (Exception e) {
			//System.err.println("The application got crashed for unknown error.");
		//	logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public void selectValueById(String id, String value) {
		// TODO Auto-generated method stub
		
	}

	public void selectVisibileTextByXpath(String xpath, String value) {
		// TODO Auto-generated method stub+
		try {
			Select sel = new Select(driver.findElementByXPath(xpath));
			sel.selectByVisibleText(value);
			//System.out.println("The webelement with an XPATH: '" + xpath + "' is identified and selected the text '"+ value + "' successfully.");
			logStatus("PASS", "The webelement with an XPATH: '" + xpath + "' is identified and selected the text '"+ value + "' successfully.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not found.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not found.");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not visible.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not visible.");
			
		} catch (ElementNotSelectableException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not enabled.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not enabled.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	public void selectIndexByXpath(String xpath, int value) {
		// TODO Auto-generated method stub+
		try {
			Select sel = new Select(driver.findElementByXPath(xpath));
			sel.selectByIndex(value);
			//System.out.println("The webelement with an XPATH: '" + xpath + "' is identifed and selected the index '"+ value + "' successfully.");
			logStatus("PASS", "The webelement with an XPATH: '" + xpath + "' is identifed and selected the index '"+ value + "' successfully.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not found.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not found.");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not visible.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not visible.");
		} catch (ElementNotSelectableException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not enabled.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not enabled.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
	}

	public void selectValueByXpath(String xpath, String value) {
		// TODO Auto-generated method stub+
		try {
			Select sel = new Select(driver.findElementByXPath(xpath));
			sel.selectByValue(value);
			//System.out.println("The webelement with an XPATH: '" + xpath + "' is identified and selected the value '"+ value + "' successfully.");
			logStatus("PASS", "The webelement with an XPATH: '" + xpath + "' is identified and selected the value '"+ value + "' successfully.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not found.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not found.");
			
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not visible.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not visible.");
		} catch (ElementNotSelectableException e) {
			//System.err.println("The webelement with an XPATH: '" + xpath + "' is not enabled.");
			logStatus("FAIL", "The webelement with an XPATH: '" + xpath + "' is not enabled.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
		
	}

	
	public void mouseOverByXpath(String xpath) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElementByXPath(xpath)).build().perform();
			//System.out.println("The mouse pointer is focused over the webelement with the XPATH: '" + xpath + "' successfully.");
			logStatus("PASS", "The mouse pointer is focused over the webelement with the XPATH: '" + xpath + "' successfully.");
		} catch (NoSuchElementException e) {
			//System.err.println("The webelement with the XPATH: '" + xpath + "' is not found.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpath + "' is not found.");
		} catch (ElementNotVisibleException e) {
			//System.err.println("The webelement with the XPATH: '" + xpath + "' is not visible.");
			logStatus("FAIL", "The webelement with the XPATH: '" + xpath + "' is not visible.");
		} catch (ElementNotInteractableException e) {
			//System.err.println("The webelement with the XPATH '" + xpath + "' is not enabled.");
			logStatus("FAIL", "The webelement with the XPATH '" + xpath + "' is not enabled.");
		} catch (WebDriverException e) {
			//System.err.println("The application got crashed for unknown error.");
			logStatus("FAIL", "The application got crashed for unknown error.");
		} 
	}
		public String getAttValByXpath(String xpathVal, String strAttribute) {
			String strText = null;
			try {
				strText = driver.findElementByXPath(xpathVal).getAttribute(strAttribute);
				//System.out.println("The webelement with the XPATH: '" + xpathVal + "' and having attribute '" + strAttribute+ "' is identified successfully and the available text is '" + strText + "'.");
				logStatus("PASS", "The webelement with the XPATH: '" + xpathVal + "' and having attribute '" + strAttribute+ "' is identified successfully and the available text is '" + strText + "'.");
			} catch (NoSuchElementException e) {
				//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not found.");
				logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not found.");
			} catch (ElementNotVisibleException e) {
				//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not visible.");
				logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not visible.");
			} catch (ElementNotInteractableException e) {
				//System.err.println("The webelement with the XPATH: '" + xpathVal + "' is not enabled.");
				logStatus("FAIL", "The webelement with the XPATH: '" + xpathVal + "' is not enabled.");
			} catch (WebDriverException e) {
				//System.err.println("The application got crashed for unknown error.");
				logStatus("FAIL", "The application got crashed for unknown error.");
			} 
			return strText;

}
		public void threadSleep(long miliSecs) {
			try {
				Thread.sleep(miliSecs);
				
			} catch (Exception e) {
				System.err.println();
			} 
		}

		

		public void clickByXpath1(String xpath) {
			// TODO Auto-generated method stub
			try {
				WebElement element = driver.findElement(By.xpath(xpath));
				JavascriptExecutor executor = (JavascriptExecutor)driver;
				executor.executeScript("arguments[0].click();", element);
				logStatus("PASS", "JAVA executer clicks on the element");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				logStatus("FAIL", "JAVA execuer no clicked");
			}
			
		}

		public long takeSnap() {
			// TODO Auto-generated method stub
			long snapNumber = 100000l;
			
				try {
					snapNumber = (long) Math.floor(Math.random()*100000+100000l);
					File image = driver.getScreenshotAs(OutputType.FILE);
					File path = new File("./screenshots/snap"+snapNumber+".jpeg");
					FileUtils.copyFile(image, path);
				
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return snapNumber;
				}}
				

		        

			
	

	
		
