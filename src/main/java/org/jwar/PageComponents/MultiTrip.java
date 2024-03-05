package org.jwar.PageComponents;

import org.jwar.AbstractComponents.AbstractComponent;
import org.jwar.AbstractComponents.SearchFlightAvail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.HashMap;
import java.util.function.Consumer;

public class MultiTrip extends AbstractComponent implements SearchFlightAvail {
    private final By fromDropdown = By.name("ctl00_mainContent_ddl_originStation1_CTXT");
    private final By toDropdown = By.id("ctl00_mainContent_ddl_destinationStation1_CTXT");

    private final By search = By.id("ctl00_mainContent_btn_FindFlights");
    private final By multiCityRadioButton = By.id("ctl00_mainContent_rbtnl_Trip_2");
    private final By destination2Dropdown = By.id("ctl00_mainContent_ddl_originStation2_CTXTaction");
    private final By modalPopUp = By.id("MultiCityModelAlert");

    public MultiTrip(WebDriver driver, By sectionElement) {
        super(driver, sectionElement);
    }

    @Override
    public void CheckAvail(HashMap<String, String> reservationDetails) {
        MakeStateReady(s-> SelectOriginCity(reservationDetails.get("origin")));
        //SelectOriginCity(origin);
        SelectDestinationCity(reservationDetails.get("destination"));
        SelectDestinationCity2(reservationDetails.get("destination2"));
    }
    public void SelectOriginCity(String origin){
        FindElement(fromDropdown).click();
        FindElement(By.xpath("//a[@value='"+origin+"']")).click();
    }
    public void SelectDestinationCity(String destination){
        FindElement(toDropdown).click();
        FindElement(By.xpath("(//a[@value='"+destination+"'])[2]")).click();
    }
    public void SelectDestinationCity2(String destination2){
        FindElement(destination2Dropdown).click();
        FindElement(By.xpath("(//a[@value='"+destination2+"'])[3]")).click();
    }
    public void MakeStateReady(Consumer<MultiTrip> consumer){
        System.out.println("I am inside Multi trip");
        FindElement(multiCityRadioButton).click();
        FindElement(modalPopUp).click();
        WaitForElementToDisappear(modalPopUp);
        consumer.accept(this);
        System.out.println("I am done");
    }
}
