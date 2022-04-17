package stepDefinations;


import org.testng.Assert;

import PageObjects.HomePO;
import PageObjects.OfferPO;
import PageObjects.PageObjectManager;
import Utils.DependacyInjection;



import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Offer {
	
	public String OfferpageProductName;
	DependacyInjection dependacyInjection;
	PageObjectManager pageobjectmanager;
	
	public Offer(DependacyInjection dependacyInjection) {
		this.dependacyInjection=dependacyInjection;
	}
	
		
	@Then("^user searched for (.+) shortname in offers page$")
	public void user_searched_for_shortname_in_offers_page(String shortname) throws InterruptedException {
		
		SwitchToWindow();
		OfferPO Opo = dependacyInjection.pageObjectManager.getOfferPage();
		Opo.searchItem(shortname);
		Thread.sleep(2000);
	    OfferpageProductName = Opo.getproductName();
	    System.out.println(OfferpageProductName +"is extracted from Home Page.");
	}
	
	public void SwitchToWindow()
	{
		HomePO hp = new HomePO(dependacyInjection.driver);
		hp.TopDealsPage();
		dependacyInjection.genericUtils.SwitchWindowToChild();
	}
		
	
	@And("validate product name in offers page matches with landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
		Assert.assertEquals(dependacyInjection.HomepageProductName, OfferpageProductName);
	}
}
