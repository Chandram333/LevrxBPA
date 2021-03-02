package wrappers;




	public interface Wrappers {
		/**
		 * This method will launch the given browser and maximise the browser and set the
		 * wait for 30 seconds and load the url
		 * @param browser - The browser of the application to be launched
		 * @param url - The url with http or https
		 * @throws Exception 
		 * 
		 */
		public void invokeApp(String browser, String url);

		
		
		/**
		 * This method will enter the value to the text field using xpath attribute to locate
		 * 
		 * @param xpathValue - name of the webelement
		 * @param data - The data to be sent to the webelement
		 */
		public void enterByXpath(String xpathValue, String data);


		
		
		/**
		 * This method will verify the given text with exact match
		 * @param xpath - The locator of the object in id
		 * @param text  - The text to be verified
		 */
		public void verifyTextByXpath(String xpath, String text);
		
		/**
		 * This method will verify the given text with partial match
		 * @param xpath - The locator of the object in xpath
		 * @param text  - The text to be verified
		 */
		public void verifyTextContainsByXpath(String xpath, String text);


		
		/**
		 * This method will click the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element to be clicked
		 * @author Basha - LibertyTestingCenter
		 */
		public void clickByXpath(String xpathVal);
		
		

		/**
		 * This method will get the text of the element using xpath as locator
		 * @param xpathVal  The xpath (locator) of the element 
		 */
		public String getTextByXpath(String xpathVal);

		
		
		/**
		 * This method will switch to the parent Window
		 */
		public void switchToParentWindow();
		
		/**
		 * This method will move the control to the last window
		 */
		public void switchToLastWindow();
		
		/**
		 * This method will accept the alert opened
		 */
		public void acceptAlert();
		
		/**
		 * This method will dismiss the alert opened
		 */
		public void dismissAlert();
		
		/**
		 * This method will return the text of the alert
		 */
		public String getAlertText();
		
		/**
		 * This method will take snapshot of the browser
		 */
		//public void takeSnap();
			
		/**
		 * This method will close the active browser
		 */
		public void closeBrowser();
		
		
		/**
		 * This method will close all the browsers
		 */
		public void closeAllBrowsers();
		
		public void selectValueById(String id, String value);
		
		public void selectVisibileTextByXpath(String Xpath, String value);
		public void selectIndexByXpath(String Xpath, int value);
		public void selectValueByXpath(String Xpath, String Value);
		//public void takeSnap();
		public void mouseOverByXpath(String xpath);
		public String getAttValByXpath(String xpathVal, String strAttribute);
		public void threadSleep(long miliSecs);
		public void clickByXpath1(String xpath);
		
		

	 

	}

	/**
	 * This method will click the element using id as locator
	 * @param id  The id (locator) of the element to be clicked
	 */
	//public void clickById(String id) ;

	/**
	 * This method will click the element using ClassName as locator
	 * @param class  The class (locator) of the element to be clicked
	 * @throws Exception 
	 */
	//public void clickByClassName(String classVal);
	
	/**
	 * This method will click the element using name as locator
	 * @param name  The name (locator) of the element to be clicked
	 */
	//public void clickByName(String name) ;
	

	/**
	 * This method will click the element using link name as locator and do take snap
	 * @param name  The link name (locator) of the element to be clicked
	 */
	//public void clickByLink(String name);
	
	/**
	 * This method will click the element using link name as locator and do not take snap
	 * @param name  The link name (locator) of the element to be clicked
	 */
	//public void clickByLinkNoSnap(String name);

	/**
	 * This method will click the element using xpath as locator
	 * @param xpathVal  The xpath (locator) of the element to be clicked
	 */
	//public void clickByXpathNoSnap(String xpathVal);
	
	/**
	 * This method will get the text of the element using id as locator
	 * @param xpathVal  The id (locator) of the element 
	 */
	//public String getTextById(String idVal);
	/**
	 * This method will select the drop down visible text using id as locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 */
	//public void selectVisibileTextById(String id, String value);
	
	/**
	 * This method will select the drop down using index as id locator
	 * @param id The id (locator) of the drop down element
	 * @param value The value to be selected (visibletext) from the dropdown 
	 */
	//public void selectIndexById(String id, int value);

	/**
	 * This method will enter the value to the text field using id attribute to locate
	 * 
	 * @param idValue - id of the webelement
	 * @param data - The data to be sent to the webelement
	 * @return 
	 * @throws Exception 
	 */
	//public void enterById(String idValue, String data);
	
	/**
	 * This method will enter the value to the text field using name attribute to locate
	 * 
	 * @param nameValue - name of the webelement
	 * @param data - The data to be sent to the webelement
	 */
	//public void enterByName(String nameValue, String data) ;	
	/**
	 * This method will verify the title of the browser 
	 * @param title - The expected title of the browser
	 */
	//public void verifyTitle(String title);
	
	/**
	 * This method will verify the given text
	 * @param id - The locator of the object in id
	 * @param text  - The text to be verified
	 */
	//public void verifyTextById(String id, String text);