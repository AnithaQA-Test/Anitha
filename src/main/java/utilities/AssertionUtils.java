package utilities;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AssertionUtils {

    private static final Logger logger = LogManager.getLogger(AssertionUtils.class);

    public static void assertJobListingsContain(List<WebElement> jobListings, String expectedJobTitle) {
        Assert.assertFalse(jobListings.isEmpty(), "No job listings found");
        boolean found = false;
        for (WebElement jobListing : jobListings) {
            String jobText = jobListing.getText();
            logger.info("Job listing found: " + jobText);
            if (jobText.contains(expectedJobTitle)) {
                found = true;
                break;
            }
        }
        if (!found) {
            Assert.fail("Job listing does not contain '" + expectedJobTitle + "'");
        }
    }
}