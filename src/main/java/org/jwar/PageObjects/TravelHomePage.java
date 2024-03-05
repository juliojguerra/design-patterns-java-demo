package org.jwar.PageObjects;

import org.jwar.AbstractComponents.SearchFlightAvail;
import org.jwar.AbstractComponents.StrategyFactor;
import org.jwar.PageComponents.FooterNav;
import org.jwar.PageComponents.MultiTrip;
import org.jwar.PageComponents.NavigationBar;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;

public class TravelHomePage {
    By sectionElement = By.id("traveller-home");
    By footerNavSectionElement = By.id("buttons");
    WebDriver driver;
    SearchFlightAvail searchFlightAvail;
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
    public void SetBookingStrategy(String strategyType){
        StrategyFactor strategyFactor = new StrategyFactor(driver);
        this.searchFlightAvail = strategyFactor.CreateStrategy(strategyType);
    }
    public void CheckAvail(HashMap<String, String> reservationDetails){
        this.searchFlightAvail.CheckAvail(reservationDetails);
    }
}
