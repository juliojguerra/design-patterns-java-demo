package org.jwar.AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractComponent {

    WebElement sectionElement;
    public AbstractComponent(WebDriver driver, By sectionElement) {
        this.sectionElement = driver.findElement(sectionElement);
    }

    public WebElement FindElement(By findElementBy){
        return sectionElement.findElement(findElementBy);
    }
    public List<WebElement> FindElements(By findElementBy){
        return sectionElement.findElements(findElementBy);
    }
}
