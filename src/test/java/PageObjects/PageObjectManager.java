package PageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	public HomePO home;
	public OfferPO offer;
	public CheckoutPO checkout;
	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public HomePO getHomePage()
	{
		home= new HomePO(driver);
		return home;
	}
	public OfferPO getOfferPage()
	{
		offer= new OfferPO(driver);
		return offer;
	}
	
	public CheckoutPO getCheckoutPage()
	{
		checkout= new CheckoutPO(driver);
		return checkout;
	}

}
