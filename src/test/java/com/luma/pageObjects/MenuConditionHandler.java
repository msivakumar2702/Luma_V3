package com.luma.pageObjects;

import org.openqa.selenium.WebElement;

public class MenuConditionHandler {

    public  WebElement getMenu(String section, HomePage homePage) {
        switch (section.toLowerCase()) {
            case "men":
                return homePage.menMenu;
            case "women":
                return homePage.womenMenu;
            case "gear":
                return homePage.gearMenu;
            default:
                return null;
        }
    }

    public WebElement getSubmenu(String section, String subSection, HomePage homePage) {
        switch (section.toLowerCase()) {
            case "men":
                if (subSection.equalsIgnoreCase("tops")) {
                    return homePage.menTopsSubmenu;
                } else if (subSection.equalsIgnoreCase("bottoms")) {
                    return homePage.menBottomSubmenu;
                }
                break;
            case "women":
                if (subSection.equalsIgnoreCase("tops")) {
                    return homePage.womenTopsSubmenu;
                } else if (subSection.equalsIgnoreCase("bottoms")) {
                    return homePage.womenBottomSubmenu;
                }
                break;
            default:
                return null;
        }
        return null;
    }

    public WebElement getProductOption(String section, String product, HomePage homePage) {
        switch (section.toLowerCase()) {
            case "men":
                return getMenProductOption(product, homePage);
            case "women":
                return getWomenProductOption(product, homePage);
            default:
                return null;
        }
    }

    private WebElement getMenProductOption(String product, HomePage homePage) {
        switch (product.toLowerCase()) {
            case "jackets":
                return homePage.menJacketsOptions;
            case "hoodies and sweatshirts":
                return homePage.menHdAndSsOptions;
            case "tees":
                return homePage.menTeesOption;
            case "tanks":
                return homePage.menTanks;
            default:
                return null;
        }
    }

    private WebElement getWomenProductOption(String product, HomePage homePage) {
        switch (product.toLowerCase()) {
            case "jackets":
                return homePage.womenJacketsOptions;
            case "hoodies and sweatshirts":
                return homePage.womenHdAndSsOptions;
            case "tees":
                return homePage.womenTeesOption;
            case "bras & tanks":
                return homePage.womenBrasAndTanks;
            default:
                return null;
        }
    }
}
