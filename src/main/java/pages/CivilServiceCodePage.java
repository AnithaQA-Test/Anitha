package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

import java.time.Duration;

public class CivilServiceCodePage {

    WebDriver driver;

    @FindBy(xpath = "//a[contains(text(),'Civil Service Code')]")
    private WebElement civilServiceCodeLink;

    @FindBy(id = "code")
    private WebElement codeSection;

    public CivilServiceCodePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickLink(String linkText) {
        if (linkText.equals("Civil Service Code")) {
            WaitUtils.waitForVisibility(driver, civilServiceCodeLink, 10);
            WaitUtils.waitForElementToBeClickable(driver, civilServiceCodeLink, 10);
            civilServiceCodeLink.click();
        }
    }

}