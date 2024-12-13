package com.luma.testCases;

import org.testng.annotations.Test;
import com.luma.base.BaseClass;
import com.luma.pageObjects.HomePage;
import com.luma.pageObjects.JaketTopsMenPage;
import com.luma.utilities.LumaUtils;

public class TC_003_AddToCartWithOutLoginTest extends BaseClass {

    @Test(groups={"sanity","regression"})
    public void verifyAddToCartWithoutLogin() throws InterruptedException {
        HomePage hp = new HomePage(driver);
        Thread.sleep(3000);
        hp.toHoverMemMenu();
        hp.toHoverTopsSubMenu();
        hp.toClickJacketsOption();

        // Instantiate the JaketTopsMenPage
        JaketTopsMenPage jtp = new JaketTopsMenPage(driver);

        // Dynamic values for size and colour
        String size = "l"; // You can externalize or parameterize this
        String colour = "blue"; // You can externalize or parameterize this

        // Select size and colour using LumaUtils
        LumaUtils.selectSize(size, jtp);
        LumaUtils.selectColour(colour, jtp, driver);

        // Add to cart
        jtp.clickAddToCartBtn();
    }
}
