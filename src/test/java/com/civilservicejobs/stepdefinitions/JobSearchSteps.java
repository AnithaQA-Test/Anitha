package com.civilservicejobs.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CivilServiceCodePage;
import pages.HomePage;
import pages.JobDetailsPage;
import pages.SearchResultsPage;
import utilities.AssertionUtils;
import utilities.LoggingUtils;
import utilities.WaitUtils;
import utilities.WebDriverUtils;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static utilities.Constants.BASE_URL;
import static utilities.Constants.TIMEOUT_IN_SECONDS;

public class JobSearchSteps {

    static WebDriver driver = WebDriverUtils.getDriver();
    HomePage homePage = new HomePage(driver);
    SearchResultsPage searchResultsPage = new SearchResultsPage(driver);
    JobDetailsPage jobDetailsPage = new JobDetailsPage(driver);
    CivilServiceCodePage civilServiceCodePage = new CivilServiceCodePage(driver);

    @Given("I launch the Civil Service Jobs website")
    public void launchWebsite() {
        LoggingUtils.logInfo("Launching the Civil Service Jobs website");
        driver.manage().window().maximize();
        driver.get(BASE_URL);

        try {
            homePage.clickCaptchaCheck();
            LoggingUtils.logInfo("Clicked the CAPTCHA checkbox");

            if (homePage.isVerifiedTextVisible()) {
                LoggingUtils.logInfo("Verified text is visible");
            }
        } catch (NoSuchElementException e) {
            LoggingUtils.logInfo("CAPTCHA checkbox is not present");
        }

        homePage.clickContinueButton();
        LoggingUtils.logInfo("Clicked the Continue button");
    }

    @When("I search for jobs with title containing {string} in {string}")
    public void searchJobs(String jobTitle, String location) {
        LoggingUtils.logInfo("Searching for jobs with title containing '" + jobTitle + "' in '" + location + "'");
        homePage.searchForJob(jobTitle, location);
        LoggingUtils.logInfo("Search completed");
    }

    @Then("I should see relevant job listings")
    public void validateSearchResults() {
        LoggingUtils.logInfo("Validating search results");
        List<WebElement> jobListings = searchResultsPage.getJobListings();
        WaitUtils.waitForVisibilityOfAllElements(driver, jobListings, TIMEOUT_IN_SECONDS);
        AssertionUtils.assertJobListingsContain(jobListings, "Analyst");
        LoggingUtils.logInfo("Search results validated successfully");
    }

    @Given("I filter by department {string}")
    public void filterByDepartment(String department) {
        LoggingUtils.logInfo("Filtering by department '" + department + "'");
        searchResultsPage.selectDepartment(department);
    }

    @When("I should see the number of jobs available in the job details page")
    public int getJobCount() {
        int jobCount = jobDetailsPage.getJobCount();
        LoggingUtils.logInfo("Total job listings found: " + jobCount);
        return jobCount;
    }

    @Then("I select the first job listing")
    public void selectFirstJob() {
        LoggingUtils.logInfo("Selecting the first job listing");
        jobDetailsPage.clickFirstJobListing();
    }

    @Given("I click on {string}")
    public void i_click_on(String linkText) {
        LoggingUtils.logInfo("Clicking on " + linkText + " link");
        civilServiceCodePage.clickLink(linkText);
    }

    @When("I should be redirected to the {string}")
    public void i_should_be_redirected_to_the(String expectedPage) {
        String currentWindowHandle = driver.getWindowHandle();
        LoggingUtils.logInfo("Stored the current window handle");

        WaitUtils.waitForNumberOfWindowsToBe(driver, 2, TIMEOUT_IN_SECONDS);
        LoggingUtils.logInfo("Waited for a new window to open");

        Set<String> windowHandles = driver.getWindowHandles();
        if (windowHandles.size() <= 1) {
            LoggingUtils.logError("New window did not open");
            throw new RuntimeException("New window did not open");
        }

        for (String windowHandle : windowHandles) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                LoggingUtils.logInfo("Switched to the new window");
                break;
            }
        }

        WaitUtils.waitForUrlContains(driver, "civilservicecommission.independent.gov.uk/code", TIMEOUT_IN_SECONDS);
        LoggingUtils.logInfo("Waited for the URL to contain 'civilservicecommission.independent.gov.uk/code'");

        String currentUrl = driver.getCurrentUrl();
        LoggingUtils.logInfo("Current URL after redirection: " + currentUrl);

        assertTrue("Expected redirection to the 'Code' section, but found: " + currentUrl,
                currentUrl.contains("civilservicecommission.independent.gov.uk/code"));
        LoggingUtils.logInfo("Redirected to the 'Code' section, the URL is: " + currentUrl);

        // Add validation to confirm the new page is correct
        String actualTitle = driver.getTitle();
        // Log the title using the logger
        LoggingUtils.logInfo("The title of the page is: " + actualTitle);
        if (actualTitle.equals(expectedPage)) {
            LoggingUtils.logInfo("Title matches expected value : " + expectedPage);
        } else {
            LoggingUtils.logInfo("Title does not match. Expected : , Actual : " + expectedPage + actualTitle);
        }

    }

    @Then("I close the browser")
    public void quitDriver() {
        if (driver != null) {
            try {
                LoggingUtils.logInfo("Closing the browser...");
                for (String handle : driver.getWindowHandles()) {
                    driver.switchTo().window(handle).close();
                    LoggingUtils.logInfo("Closed window with handle: " + handle);
                }
                driver.quit();
                LoggingUtils.logInfo("Driver quit successfully.");
            } catch (Exception e) {
                LoggingUtils.logError("Exception while quitting driver: " + e.getMessage());
            } finally {
                driver = null;
                LoggingUtils.logInfo("Driver reference set to null.");
            }
        } else {
            LoggingUtils.logWarn("Driver is already null, no action taken.");
        }
    }

}