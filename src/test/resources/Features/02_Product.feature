Feature: Product Display and Interaction on SauceDemo

  Background:
    Given The user is logged in and on the Product page

  Scenario: View product details
    When The user clicks on a product
    Then The system displays the product detail page

  Scenario: Add one product to the cart
    When The user clicks the Add to cart button on a product
    Then The cart badge displays the number "1"

  Scenario: Add all products to the cart
    When The user clicks the Add to cart button on all products
    Then The cart badge displays the number "6"