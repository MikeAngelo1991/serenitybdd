Feature: Registration

  Scenario Outline: Successful registration
    Given Pepito wants to sing up in the application
    When Pepito sends the required information to sign up
      | <name> | <last name> | <age> | <email> | <country> |
    Then Pepito should have a new account created
    Examples:
      | name   | last name | age | email           | country  |
      | Miguel | Muñoz     | 20  | test@gmail.com  | Colombia |
      | Angel  | Montoya   | 25  | test1@gmail.com | Colombia |

  Scenario: Missing required fields for registration
    Given Pepito wants to sing up in the application
    When Pepito does not send the required information
    Then Pepito should be told all fields are required

