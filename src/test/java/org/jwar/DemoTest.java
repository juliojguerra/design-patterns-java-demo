package org.jwar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jwar.PageObjects.TravelHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DemoTest {

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
    }
}
