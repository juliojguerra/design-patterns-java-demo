package org.jwar.PageComponents;

import org.jwar.AbstractComponents.AbstractComponent;
import org.jwar.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class RoundTrip extends AbstractComponent implements SearchFlightAvail {
    private final By radioButton = By.id("ctl00_mainContent_rbtnl_Trip_1");
    private final By fromDropdown = By.name("ctl00_mainContent_ddl_originStation1_CTXT");
    private final By toDropdown = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");
    private final By indianCheckBox = By.id("ctl00_mainContent_chk_IndArm");
    private final By search = By.id("ctl00_mainContent_btn_FindFlights");

    public RoundTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void CheckAvail(HashMap<String, String> reservationDetails) {
        MakeStateReady(s-> SelectOriginCity(reservationDetails.get("origin")));
        // SelectOriginCity(origin);
        SelectDestinationCity(reservationDetails.get("destination"));
        FindElement(indianCheckBox).click();
        FindElement(search).click();
    }

    public void SelectOriginCity(String origin){
        FindElement(fromDropdown).click();
        FindElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void SelectDestinationCity(String destination){
        FindElement(toDropdown).click();
        FindElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }

    public void MakeStateReady(Consumer<RoundTrip> consumer){
        System.out.println("I am inside Round trip");
        FindElement(radioButton).click();
        consumer.accept(this);
        System.out.println("I am done");
    }
}
