package org.jwar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jwar.PageComponents.MultiTrip;
import org.jwar.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;

public class DemoTest {
    By sectionElement = By.id("flightSearchContainer");
    @Test
    public void flightTest(){
        // Setup WebDriverManager for Chrome
        WebDriverManager.chromedriver().setup();

        // Create a new instance of ChromeDriver
        WebDriver driver = new ChromeDriver();

        TravelHomePage travelHomePage = new TravelHomePage(driver);
        travelHomePage.GoTo();
        System.out.println(travelHomePage.GetFooterNav().GetFlightAttribute());
        System.out.println(travelHomePage.GetNavigationBar().GetFlightAttribute());
        System.out.println(travelHomePage.GetFooterNav().GetLinkCount());
        System.out.println(travelHomePage.GetNavigationBar().GetLinkCount());

        // travelHomePage.SetBookingStrategy(new MultiTrip(driver, sectionElement));
        travelHomePage.SetBookingStrategy("multitrip");
        // travelHomePage.SetBookingStrategy("roundtrip");
        HashMap<String, String> reservationDetails = new <String, String>HashMap();
        reservationDetails.put("origin", "MAA");
        reservationDetails.put("destination", "HYD");
        reservationDetails.put("destination2", "DEL");
        travelHomePage.CheckAvail(reservationDetails);


    }
}
