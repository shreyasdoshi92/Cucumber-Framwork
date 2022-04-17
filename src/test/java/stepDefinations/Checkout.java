package stepDefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import PageObjects.CheckoutPO;
import Utils.DependacyInjection;
import io.cucumber.java.en.Then;

public class Checkout 
{
	public WebDriver driver;
	public CheckoutPO checkoutpo;
	public String HomepageProductName;
	public String OfferpageProductName;
	DependacyInjection dependacyInjection;
	
	
	
	public Checkout(DependacyInjection dependacyInjection) 
	{
		this.dependacyInjection=dependacyInjection;
		this.checkoutpo = dependacyInjection.pageObjectManager.getCheckoutPage();
	}
	
	@Then("verify user has ability to enter promo code and place the order")
	public void  verify_user_has_ability_enter_promo()
	{	
		Assert.assertTrue(checkoutpo.VerifyPromoBtn());
		Assert.assertTrue(checkoutpo.VerifyPlaceOrder());
	}
		
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void user_proceeds_to_checkout(String name) throws InterruptedException
	{
		checkoutpo.CheckoutItems();
		
	}	
}
