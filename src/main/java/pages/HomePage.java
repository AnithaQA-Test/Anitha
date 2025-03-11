package pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

public class HomePage {

    WebDriver driver;
    @FindBy(name = "what")
    private WebElement jobTitleInput;
    @FindBy(name = "where")
    private WebElement locationInput;
    @FindBy(name = "search_button")
    private WebElement searchButton;
    @FindBy(id = "altcha_checkbox")
    private WebElement captchaCheckbox;
    @FindBy(xpath = "//span[text()='Verified']")
    private WebElement verifiedText;
    @FindBy(xpath = "//button[text()='Continue']")
    private WebElement continueButton;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForJob(String title, String location) {
        jobTitleInput.sendKeys(title);
        locationInput.sendKeys(location);
        searchButton.click();
    }

    public void clickCaptchaCheck() {
        captchaCheckbox.click();
    }

    public boolean isVerifiedTextVisible() {
        try {
            WaitUtils.waitForVisibility(driver, verifiedText, 10);
            return verifiedText.isDisplayed();
        } catch (NoSuchElementException | TimeoutException e) {
            return false;
        }
    }

    public void clickContinueButton() {
        continueButton.click();
    }
}