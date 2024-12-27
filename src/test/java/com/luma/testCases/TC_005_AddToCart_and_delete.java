package com.luma.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.luma.base.BaseClass;
import com.luma.pageObjects.HomePage1;
import com.luma.pageObjects.JaketTopsMenPage;
//import com.luma.pageObjects.HoodiesMenPage; // Assuming you have this page object
import com.luma.pageObjects.ShopppingCartPage;
import com.luma.utilities.LumaUtils;

public class TC_005_AddToCart_and_delete extends BaseClass {
    
    @Test(groups={"sanity", "master"})
    public void deleteAddedItem() throws InterruptedException {
        HomePage1 hp = new HomePage1(driver);
        Thread.sleep(2000);
        
        // Provide the product name dynamically
        String menuType="men";
        String subMenu="tops";
        String product = "jackets"; 
        
        // Navigate to the menu based on the product
        hp.toHoverMenu(menuType, subMenu, product);
        
        // Initialize the correct page object based on the product
        if (product.equalsIgnoreCase("jackets")) {
            JaketTopsMenPage jtp = new JaketTopsMenPage(driver);
            
            // Dynamic values for size and color
            String size = "l"; // You can externalize or parameterize this
            String colour = "Blue"; // You can externalize or parameterize this

            // Select size and colour using LumaUtils
            LumaUtils.selectSize(size, jtp);
            LumaUtils.selectColour(colour, jtp, driver);

            // Add to cart
            jtp.clickAddToCartBtn();
            jtp.clickShippingCartLink();

        }
        /*
        else if (product.equalsIgnoreCase("hoodies")) {
            // Handle "hoodies" product type
            HoodiesMenPage hmp = new HoodiesMenPage(driver);
            
            // Dynamic values for size and color
            String size = "m"; // Example size
            String colour = "Red"; // Example colour

            // Select size and colour using LumaUtils
            LumaUtils.selectSize(size, hmp);
            LumaUtils.selectColour(colour, hmp, driver);

            // Add to cart
            hmp.clickAddToCartBtn();
            hmp.clickShippingCartLink();
            
        }
        */
        // Continue with the rest of the test case for shopping cart operations
        ShopppingCartPage scp = new ShopppingCartPage(driver);
        scp.clickDeleteItem();
        String cnfMsg = scp.noItemCnfMsg();
        Assert.assertEquals(cnfMsg, "You have no items in your shopping cart.");
    }
}
