@smoke
Feature: User can change currency for us to euro

  Background: User open browser and log in


  Scenario: Logged User could switch between currencies US-Euro
    When Logged in user clicks on currency dropdown list
    And user selects another currency
    Then products' prices should change to this currency
