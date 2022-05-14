@smoke
Feature: user can add different products to cart

  Background: User could log in with valid email and password
    When User navigates to login page
    And User enters a valid "test@email.com" and "P@ssw0rd"
    And User clicks on login
    Then User should login successfully

  Scenario:  Logged user could compare products

    When the user has navigated to a category page: "https://demo.nopcommerce.com/books"
    And user clicks on add to comparlist button of products
    Then user is shown an add comparlist success notification
    And clicking on success bar's link navigates user to compare page