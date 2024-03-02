package org.jwar.PageObjects;

import org.jwar.PageComponents.FooterNav;
import org.jwar.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;
    public TravelHomePage(WebDriver driver){
        this.driver = driver;
    }
    public void GoTo() {
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
    }

    public NavigationBar GetNavigationBar() {
        return new NavigationBar(driver, footerNavSectionElement);
    }

    public FooterNav GetFooterNav() {
        return new FooterNav(driver, sectionElement);
    }
}
