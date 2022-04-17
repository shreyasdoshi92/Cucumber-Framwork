package stepDefinations;

import java.io.IOException;

import Utils.DependacyInjection;
import java.io.File;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;


public class Hooks {
	DependacyInjection DI;
	
	public Hooks(DependacyInjection DI)
	{
		this.DI=DI;
	}
	
	@After
	public void AfterScenario() throws IOException
	{
		
		DI.testBaseClass.driver.quit();
		
	}
	
	@AfterStep
	public void AddScreenshot(Scenario scenario) throws IOException
	{
		WebDriver driver =DI.testBaseClass.WebDriverManager();
		if(scenario.isFailed())
		{
		//screenshot
		File sourcePath= 	((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
		scenario.attach(fileContent, "image/png", "image");
		
		}
		
	}
	
	
	
}
