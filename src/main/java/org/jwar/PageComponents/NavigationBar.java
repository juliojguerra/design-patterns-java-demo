package org.jwar.PageComponents;

import org.jwar.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationBar extends AbstractComponent{
    By flights = By.cssSelector("[title='Flights']");
    By links = By.cssSelector("a");
    public NavigationBar(WebDriver driver, By sectionElement){
        super(driver, sectionElement);
    }
    public String GetFlightAttribute(){
        return FindElement(flights).getAttribute("class");
    }
    public int GetLinkCount(){
        return FindElements(links).size();
    }
}

