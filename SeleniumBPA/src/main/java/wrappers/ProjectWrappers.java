package wrappers;




import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;


//import utils.POM_DataProvider;

public class ProjectWrappers extends GenericWrappers {
	public String browser, url;
	//public String dataSheetName;
	
	@BeforeSuite
	public void beforeSuite() {
		startReport();
	}
	@BeforeTest
	public void beforeTest() {
		loadObjects();
		
	}
	@BeforeMethod
	public void beforeMethod() {
		startTest(testcaseName, testCaseDescription);
		test.assignAuthor(Author);
		test.assignCategory(Category);
		invokeApp(browser, "https://test-my.levrx.com/login");
		
	}
	@AfterMethod
	public void afterMethod() {
	closeAllBrowsers();
	}
	
	@AfterClass
	public void afterClass() {
		endTest();
		
	}
	@AfterTest
	public void afterTest() {
		unloadObjects();
		
	}
	
	@AfterSuite
	public void afterSuite() {
		endReport();
	}
	
	//@DataProvider(name = "fetchData")
	//public String[][] fetchData() throws IOException{
	//	return POM_DataProvider.getData(dataSheetName);
		
	//}
	
	

}

