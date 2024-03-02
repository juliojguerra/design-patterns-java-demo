package org.jwar.PageComponents;

import org.jwar.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class FooterNav extends AbstractComponent {
    WebDriver driver;
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");

    public FooterNav(WebDriver driver, By sectionElement) {
        super(driver, sectionElement); // In inheritance, you should invoke parent class constructor
    }

    // method to handle flights
    // when selenium executes any method in this class
    // scope should be in footer only

    public String GetFlightAttribute(){
        return FindElement(flights).getAttribute("class");
    }
    public int GetLinkCount(){
        return FindElements(links).size();
    }


}
