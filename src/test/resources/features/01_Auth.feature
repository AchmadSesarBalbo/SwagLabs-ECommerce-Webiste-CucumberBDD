Feature: Login Functionality on SauceDemo

  Background:
    Given The user opens the login page

  Scenario Outline: Failed login with invalid credentials
    When I login with invalid credentials "<username>" and "<password>"
    Then I should see error message "<error_message>"

    Examples:
      | username        | password     | error_message                                                             |
      |                 | secret_sauce | Epic sadface: Username is required                                        |
      | standard_user   |              | Epic sadface: Password is required                                        |
      | fake_user       | fake_pass    | Epic sadface: Username and password do not match any user in this service |
      | locked_out_user | secret_sauce | Epic sadface: Sorry, this user has been locked out.                       |

  Scenario: Successful login
    When I login with valid credentials "standard_user" and "secret_sauce"
    Then I should see the products page