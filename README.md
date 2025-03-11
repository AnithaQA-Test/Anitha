# Civil Service Jobs Search - Cucumber Test Automation

This project contains automated tests for the Civil Service Jobs Search functionality using Cucumber, a behavior-driven
development (BDD) tool. The tests are written in Gherkin syntax and executed using Cucumber-JVM with Gradle as the build
tool.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Features and Scenarios](#features-and-scenarios)
3. [Prerequisites](#prerequisites)
4. [Setup and Installation](#setup-and-installation)
5. [Running the Tests](#running-the-tests)
6. [Test Reports](#test-reports)

---

## Project Overview

This project automates the testing of the Civil Service Jobs Search functionality. It includes scenarios for searching
jobs, filtering by department, and verifying links. The tests are written in Gherkin syntax and executed using
Cucumber-JVM with Gradle as the build tool.

---

## Features and Scenarios

### Feature: Civil Service Jobs Search

- **Scenario: Search for Analyst jobs in London**
    - Given I launch the Civil Service Jobs website
    - When I search for jobs with title containing "Analyst" in "London"
    - Then I display all job listings
    - Then I should see relevant job listings

- **Scenario: Filter jobs by Department and verify job count** (Tagged with `@StretchGoal`)
    - Given I filter by department "Medicines and Healthcare products Regulatory Agency"
    - When I should see the number of jobs available in the job details page
    - Then I select the first job listing

- **Scenario: Verify Civil Service Code link** (Tagged with `@ChallengeGoal`)
    - Given I click on Civil Service Code
    - When I should be redirected to the Civil Service Commission Website

---

## Prerequisites

Before running the tests, ensure you have the following installed:

- **Java Development Kit (JDK)**: Version 17 or higher.
- **Gradle**: For dependency management and building the project.
- **Cucumber-JVM**: Included in the project dependencies.
- **WebDriver**: Ensure the appropriate WebDriver (e.g., ChromeDriver) is installed and configured.

---

## Setup and Installation

1. Clone the repository:
   ```bash
   https://gitlab.com/anithaqa_test/CivilService.git

---

## Running the Tests

1. To run all the tests, use the following Gradle command:
   ```bash
   ./gradlew test
    gradle test

---

## Running the Tests

1. Run All Tests
   To execute all the tests in the project, use the following Gradle command:

   ```bash
   ./gradlew test
     gradle test
2. Using Test Runner
   You can also run tests directly from your IDE by executing the TestRunner class. This class is typically located in
   the src/test/java directory and is configured to run Cucumber tests.

---

## Test Reports

1. After running the tests, an HTML report is generated in the target/cucumber-reports/cucumber-reports directory. Open
   the cucumber-reports.html file to view the detailed test results, including:

---

