package org.jwar.AbstractComponents;

import org.jwar.PageComponents.MultiTrip;
import org.jwar.PageComponents.RoundTrip;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StrategyFactor {
    WebDriver driver;
    By sectionElement = By.id("flightSearchContainer");
    public StrategyFactor(WebDriver driver){
        this.driver = driver;
    }
    public SearchFlightAvail CreateStrategy(String strategyType){
        if(strategyType.equalsIgnoreCase("multitrip")){
            return new MultiTrip(driver, sectionElement);
        }
        if (strategyType.equalsIgnoreCase("roundtrip")){
            return new RoundTrip(driver, sectionElement);
        }

        return null;
    }
}
