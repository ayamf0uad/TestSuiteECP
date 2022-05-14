Feature: user can add different products to cart
  Scenario:  Logged user could add different products to Shopping cart

    When the user has navigated to a category page: "https://demo.nopcommerce.com/books"
    And user clicks on add to cart button of products
    Then user is shown an add to cart success notification
    And clicking on success bar's link navigates user to cart page