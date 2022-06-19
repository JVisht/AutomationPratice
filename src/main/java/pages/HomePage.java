package pages;

import base.base.CommonAPI;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends CommonAPI {
    public HomePage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
    @FindBy(css = "\".title\"")
    private WebElement header;

    public String getHeaderText() {
        String headerText = getElementText(header);
        System.out.println("header text" +headerText);
        return headerText;

}

}


