@smoke
Feature: User can forget password

  Scenario: User is able to reset password successfully
    When User navigates to login page
    And User Clicks on forget password
    And enter "test@email.com" and clicks on recover
    Then User is shown a success message