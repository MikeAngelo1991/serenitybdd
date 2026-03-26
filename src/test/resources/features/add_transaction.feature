Feature: Add transaction

  Scenario: Add new transaction
    Given Pepito is logged into the application
    |user|pass|
    When Pepito enters the required information to add a new transaction
    |12-12-2023|500|testing description|
    Then Pepito should see a new transaction in the transaction list with correct details
      |2023-12-12|500|testing description|

