Feature: Checkout Process on SauceDemo

  Scenario Outline: Checkout with invalid data form input
    Given The user is on the Checkout: Your Information page
    When The user enters "<firstName>" "<lastName>" and "<postalCode>"
    And The user clicks the Continue button
    Then The system displays "<expectedResult>"

    Examples:
      | firstName | lastName | postalCode | expectedResult                                |
      |           |          |            | Error: First Name is required                 |
      | John      |          |            | Error: Last Name is required                  |
      | John      | Doe      |            | Error: Postal Code is required                |

  Scenario: Checkout with valid data form input
    Given The user is on the Checkout: Your Information page
    When The user enters "John" "Doe" and "12345"
    And The user clicks the Continue button

  Scenario: Complete the checkout process
    Given The user is on the Checkout: Overview page
    When The user clicks the Finish button
    Then The system navigates to the Finish page and displays the message “THANK YOU FOR YOUR ORDER”