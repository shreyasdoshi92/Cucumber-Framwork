package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OfferPO {
	By Search = By.xpath("//input[@type='search']");
	By OfferProdctName = By.cssSelector("tr td:nth-child(1)");
	WebDriver driver;
	
	public OfferPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchItem(String name)
	{
		driver.findElement(Search).sendKeys(name);
	}
	public void getsearchItem()
	{
		driver.findElement(Search).getText();
	}
	public String getproductName()
	{
		return driver.findElement(OfferProdctName).getText();
	}
	

}
