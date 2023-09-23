Feature: Demo for the basic automation framework

  Scenario: As a user I am able to search anything on google
    Given Open the browser given in properties file
    When type automation in google search and press enter
    Then Validate it should open top website available on google