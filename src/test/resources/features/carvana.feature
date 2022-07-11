@Regression
Feature: Carvana Tools Functionalities

  Scenario: Validate CAR FINDER menu item
    Given user is on "https://www.carvana.com/"
    When user clicks on "CAR FINDER" menu item
    Then user should be navigated to "https://www.carvana.com/help-me-search/"
    And user should see "WHAT CAR SHOULD I GET?" text
    And user should see "Car Finder can help! Answer a few quick questions to find the right car for you." text
    And user should see "TRY CAR FINDER" link
    When user clicks on "TRY CAR FINDER" link
    Then user should be navigated to "https://www.carvana.com/help-me-search/qa"
    And user should see "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?" text
    And user should see "Select up to 4 in order of importance" text

  Scenario: Validate SELL/TRADE invalid vin search
    Given user is on "https://www.carvana.com/"
    When user clicks on "SELL/TRADE" menu item
    Then user should be navigated to "https://www.carvana.com/sell-my-car"
    And user should see "GET A REAL OFFER IN 2 MINUTES" text
    And user should see "We pick up your car. You get paid on the spot." text
    When user clicks on "VIN" button
    And user enters vin number as "42069123123561273"
    And user clicks on "GET MY OFFER" button
    Then user should see "We couldn’t find that VIN. Please check your entry and try again." text

  @Smoke
  Scenario: Validate AUTO LOAN CALCULATOR under FINANCING menu item
    Given user is on "https://www.carvana.com/"
    When user hovers over on "FINANCING" menu item
    And user clicks on "AUTO LOAN CALCULATOR" menu item
    Then user should be navigated to "https://www.carvana.com/auto-loan-calculator"
    When user enters "10,000" for "Cost of Car I want"
    And user selects "Excellent: 780" for "What's Your Credit Score?"
    And user selects "60 Months" for "Choose Your Loan Term"
    And user enters "1,500" for "What is Your Down Payment?"
    Then user should see the monthly payment as "167.00"
