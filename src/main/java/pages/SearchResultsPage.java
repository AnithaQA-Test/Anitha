package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.WaitUtils;

import java.util.List;

import static utilities.Constants.TIMEOUT_IN_SECONDS;

public class SearchResultsPage {

    WebDriver driver;

    @FindBy(xpath = "(//*[text()=' Department '])[1]")
    private WebElement departmentDropdown;

    @FindBy(xpath = "//*[contains(text(),'Medicines and Healthcare Products Regulatory Agency')]/..//input")
    private WebElement departmentInput;

    @FindBy(id = "submitSearch")
    private WebElement searchButton;

    @FindBy(xpath = "//ul[@title='Job list']/li[contains(@class, 'search-results-job-box')]")
    private List<WebElement> jobListings;

    @FindBy(xpath = "(//h3[@class='search-results-job-box-title'])[1]")
    private WebElement firstJobListing;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void selectDepartment(String department) {
        WaitUtils.waitForElementToBeClickable(driver, departmentDropdown, TIMEOUT_IN_SECONDS);
        departmentDropdown.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", departmentInput);
        departmentInput.sendKeys(department);
        WaitUtils.waitForElementToBeClickable(driver, searchButton, TIMEOUT_IN_SECONDS);
        searchButton.click();
    }

    public List<WebElement> getJobListings() {
        return WaitUtils.waitForVisibilityOfAllElements(driver, jobListings, TIMEOUT_IN_SECONDS);
    }

    public boolean areResultsDisplayed() {
        return !WaitUtils.waitForVisibilityOfAllElements(driver, jobListings, TIMEOUT_IN_SECONDS).isEmpty();
    }

    public void clickFirstJobListing() {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstJobListing);
        WaitUtils.waitForElementToBeClickable(driver, firstJobListing, TIMEOUT_IN_SECONDS);
        firstJobListing.click();
    }
}