@smoke
Feature: User actions

  Background: User open browser


  Scenario: Logged User could search for any product
    When Logged in user type a search keyword "book"
    And User clicks on search
    Then User should be navigated to search result page for "book"
    And Search results contains search keyword "book"