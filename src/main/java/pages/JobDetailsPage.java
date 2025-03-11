package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class JobDetailsPage {
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(JobDetailsPage.class);

    @FindBy(className = "search-results-job-box-title")
    private List<WebElement> jobListings;

    @FindBy(xpath = "(//h3[@class='search-results-job-box-title'])[1]")
    private WebElement firstJobListing;

    public JobDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public int getJobCount() {
        int jobCount = jobListings.size();
        logger.info("Extracted job count: " + jobCount);

        if (jobCount == 0) {
            logger.error("No job listings found");
            throw new IllegalStateException("No job listings found");
        }

        return jobCount;
    }

    public void clickFirstJobListing() {
        firstJobListing.click();
    }
}