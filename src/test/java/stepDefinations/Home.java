package stepDefinations;


import org.openqa.selenium.WebDriver;

import org.testng.Assert;

import PageObjects.HomePO;
import PageObjects.PageObjectManager;
import Utils.DependacyInjection;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class Home {
	public	WebDriver driver;
	public String HomepageProductName;
	public String OfferpageProductName;
	DependacyInjection dependacyInjection;
	PageObjectManager pageobjectmanager;
	public HomePO hp;
	
	public Home(DependacyInjection dependacyInjection) 
	{
		this.dependacyInjection=dependacyInjection;
		this.hp = dependacyInjection.pageObjectManager.getHomePage();
	}
	
	
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(hp.getHomePageTitle().contains("GreenKart"));
	}
	
	
	@When("^user searched with Shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {
	
		hp.searchItem(shortname);
		Thread.sleep(2000);
		dependacyInjection.HomepageProductName= hp.getproductNameTrim();
		System.out.println(dependacyInjection.HomepageProductName +" is extracted from Home Page.");
	}
	
	@And("Added {string} items of the selected product to cart")
	public void Added_items_product(String quantity)
	{
		hp.incrementQuantity(Integer.parseInt(quantity));
		hp.addToCart();
		
	}
	
	
	
}
