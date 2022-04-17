package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePO {
	By Search = By.xpath("//input[@type='search']");
	By HomeProdctName = By.cssSelector("h4.product-name");
	By topDeals =  By.linkText("Top Deals");
	By increment=   By.cssSelector("a.increment");
	By addToCart = By.cssSelector(".product-action button");
	WebDriver driver;
	
	public HomePO(WebDriver driver) {
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
		return driver.findElement(HomeProdctName).getText();
	}
	public String getproductNameTrim()
	{
		return driver.findElement(HomeProdctName).getText().split("-")[0].trim();
	}
	public void TopDealsPage()
	{
		driver.findElement(topDeals).click();
	}

	public String getHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public void incrementQuantity(int quantity)
	{
		int i = quantity-1;
		while(i>0)
		{
			driver.findElement(increment).click();
			i--;
		}
		
	}
	
	public void addToCart()
	{
		driver.findElement(addToCart).click();
	}
	
	
}
