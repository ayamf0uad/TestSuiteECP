@smoke
Feature: User Can login successfully
  Background: User opens website

  Scenario: User could log in with valid email and password
    Given User navigates to login page
    When User enters a valid "test@email.com" and "P@ssw0rd"
    And User clicks on login
    Then User should login successfully
    And Navigates to HP