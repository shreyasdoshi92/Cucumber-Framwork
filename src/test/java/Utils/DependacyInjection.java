package Utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import PageObjects.PageObjectManager;

public class DependacyInjection {
	public	WebDriver driver;
	public String HomepageProductName;
	public PageObjectManager pageObjectManager;
	public TestBaseClass testBaseClass;
	public GenericUtils genericUtils;
	
	public DependacyInjection() throws IOException
	{
		testBaseClass = new TestBaseClass();
		pageObjectManager = new PageObjectManager(testBaseClass.WebDriverManager());
		genericUtils = new GenericUtils(testBaseClass.WebDriverManager());
	}
}
