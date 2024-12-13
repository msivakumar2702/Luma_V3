package com.luma.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.pageObjects.HomePage;
import com.luma.pageObjects.JaketTopsMenPage;
import com.luma.pageObjects.ShopppingCartPage;
import com.luma.utilities.LumaUtils;

public class TC_005_AddToCart_and_delete extends BaseClass {
	
	@Test(groups={"sanity", "master"})
	public void deleteAddedItem() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(2000);
		hp.toHoverMemMenu();
		hp.toHoverTopsSubMenu();
		hp.toClickJacketsOption();
		
		JaketTopsMenPage jtp = new JaketTopsMenPage(driver);

        // Dynamic values for size and colour
        String size = "l"; // You can externalize or parameterize this
        String colour = "Blue"; // You can externalize or parameterize this

        // Select size and colour using LumaUtils
        LumaUtils.selectSize(size, jtp);
        LumaUtils.selectColour(colour, jtp, driver);

        // Add to cart
        jtp.clickAddToCartBtn();
        jtp.clickShippingCartLink();
        
        //detele item
        ShopppingCartPage scp = new ShopppingCartPage(driver);
        scp.clickDeleteItem();
        String cnfMsg = scp.noItemCnfMsg();
        Assert.assertEquals(cnfMsg, "You have no items in your shopping cart.");
	}

}
