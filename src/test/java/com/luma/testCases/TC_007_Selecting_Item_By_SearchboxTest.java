package com.luma.testCases;

import org.testng.annotations.Test;
import com.luma.base.BaseClass;
import com.luma.pageObjects.HomePage1;

public class TC_007_Selecting_Item_By_SearchboxTest extends BaseClass {

    @Test
    public void searchItemBySearchBar() {
        // Initialize the HomePage object
        HomePage1 homePage = new HomePage1(driver);

        // Perform any necessary navigation or setup
        homePage.clickSignInLink(); // Example if needed to log in

        // Enter search text
        homePage.enterSearchText("shir");

        // Wait for results and retrieve items
        homePage.waitForSearchResults();

        // Optionally, click on a specific item based on text
        homePage.selectItemByText("shirt for men");
    }
}
