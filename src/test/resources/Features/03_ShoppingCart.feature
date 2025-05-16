Feature: Shopping Cart Functionality

  Scenario: Remove a product from the cart
    Given The user is on the Product page
    When The user clicks the Cart button
    And The user clicks the Remove button on a product
    Then The product should be removed from the cart

  Scenario: Click the checkout button
    Given The user is on the Cart page
    When The user clicks the Checkout button
    Then The user should be redirected to the Checkout Information page