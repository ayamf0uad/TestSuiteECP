@smoke
Feature: filter by tag

  Background: User could log in with valid email and password
    Given User navigates to login page
    And User enters a valid "test@email.com" and "P@ssw0rd"
    And User clicks on login
    Then User should login successfully

  Scenario: Logged user could select different tags
    When user navigates to a product listing page and filter by tags
    And user clicks on another tag
    Then user is navigated to the related page of this tag