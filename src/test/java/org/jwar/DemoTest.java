package org.jwar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.jwar.PageComponents.MultiTrip;
import org.jwar.PageObjects.TravelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DemoTest extends BaseTest{
    WebDriver driver;
    TravelHomePage travelHomePage;
    @BeforeTest
    public void setup(){
        driver = InitializeDriver();
        travelHomePage = new TravelHomePage(driver);
    }
    @Test(dataProvider = "getData")
    public void flightTest(HashMap<String, String> reservationDetails){
        travelHomePage.GoTo();
        System.out.println(travelHomePage.GetFooterNav().GetFlightAttribute());
        System.out.println(travelHomePage.GetNavigationBar().GetFlightAttribute());
        System.out.println(travelHomePage.GetFooterNav().GetLinkCount());
        System.out.println(travelHomePage.GetNavigationBar().GetLinkCount());

        travelHomePage.SetBookingStrategy("multitrip");

        travelHomePage.CheckAvail(reservationDetails);
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> list =
                GetJsonData(
                        System.getProperty("user.dir")
                                +"/src/test/java/org/jwar/DataLoads/reservationDetails.json");
        return new Object[][]{
                { list.get(0) }, { list.get(1) }
        };
    }
}
