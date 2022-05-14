@smoke
Feature: User should be able to filter listings by color

  Background: User could log in with valid email and password
    When User navigates to login page
    And User enters a valid "test@email.com" and "P@ssw0rd"
    And User clicks on login
    Then User should login successfully

  Scenario:  Logged user could filter with color
    When that the user has navigated to a PLP page with color filter available
    And user selects a color
    Then listings are filtered to only show products with this color