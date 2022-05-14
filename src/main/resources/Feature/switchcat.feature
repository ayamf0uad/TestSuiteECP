@smoke
Feature: user can switch between categories
  Background: User could log in with valid email and password
    When User navigates to login page
    And User enters a valid "test@email.com" and "P@ssw0rd"
    And User clicks on login
    Then User should login successfully

  Scenario: Logged user could select different Categories
    When user hovers over a category from nav menu
    Then user should be navigated to this new subcategory