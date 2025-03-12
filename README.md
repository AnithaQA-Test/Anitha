# Civil Service Jobs Search - Cucumber Test Automation

This project contains automated tests for the Civil Service Jobs Search functionality using **Cucumber**, a behavior-driven development (BDD) tool. The tests are written in **Gherkin syntax** and executed using **Cucumber-JVM** with **Gradle** as the build tool.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Framework Structure](#framework-structure)
3. [Features and Scenarios](#features-and-scenarios)
4. [Prerequisites](#prerequisites)
5. [Setup and Installation](#setup-and-installation)
6. [Running the Tests](#running-the-tests)
7. [Test Reports](#test-reports)

---

## Project Overview

This project automates the testing of the **Civil Service Jobs Search** functionality. It includes scenarios for:
- Searching for jobs by title and location.
- Filtering jobs by department.
- Verifying the Civil Service Code link.

The framework is designed to be **modular**, **scalable**, and **easy to maintain**. It uses the **Page Object Model (POM)** design pattern and includes utility classes for common functionalities.

---

## Framework Structure

The project follows a well-organized directory structure:
Anitha
├── gradle/ # Gradle configuration files
├── idea/ # IntelliJ IDEA configuration files
├── build/ # Compiled classes and build artifacts
├── logs/ # Log files generated during test execution
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ ├── pages/ # Page Object Model (POM) classes
│ │ │ │ ├── CivilServiceCodePage.java
│ │ │ │ ├── HomePage.java
│ │ │ │ ├── JobDetailsPage.java
│ │ │ │ └── SearchResultsPage.java
│ │ │ └── utilities/ # Utility classes for common functionalities
│ │ │ ├── AssertionUtils.java
│ │ │ ├── BrowserUtils.java
│ │ │ ├── ConfigReader.java
│ │ │ ├── ConfigUtils.java
│ │ │ ├── Constants.java
│ │ │ ├── LoggingUtils.java
│ │ │ ├── WaitUtils.java
│ │ │ └── WebDriverUtils.java
│ └── test/
│ ├── java/
│ │ └── com.civilservicejobs/
│ │ ├── runners/ # Cucumber test runner
│ │ │ └── TestRunner.java
│ │ └── stepdefinitions/ # Step definitions for Cucumber scenarios
│ │ └── JobSearchSteps.java
│ └── resources/
│ ├── config/ # Configuration files
│ │ └── config.properties
│ └── features/ # Cucumber feature files
│ └── JobSearch.feature
├── target/
│ └── cucumber-reports/ # Cucumber test reports
│ └── cucumber-reports.html
├── .gitignore # Specifies files to ignore in Git
├── .gitlab-ci.yml # GitLab CI/CD configuration
├── build.gradle # Gradle build script
├── gradlew # Gradle wrapper for Unix-based systems
├── gradlew.bat # Gradle wrapper for Windows
└── README.md # Project documentation

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
    - Then I close the browser

---

## Prerequisites

Before running the tests, ensure you have the following installed:

- **IntelliJ IDEA**: Recommended IDE for development and testing.
- **Java Development Kit (JDK)**: Version 17 or higher.
- **Gradle**: For dependency management and building the project.
- **Cucumber-JVM**: Included in the project dependencies.
- **WebDriver**: Ensure the appropriate WebDriver (e.g., ChromeDriver) is installed and configured.

---

## Setup and Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/AnithaQA-Test/Anitha.git
---  
## Install dependencies:

./gradlew build
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
After running the tests, an HTML report is generated in the target/cucumber-reports directory. Open the cucumber-reports.html file to view the detailed test results.

---



