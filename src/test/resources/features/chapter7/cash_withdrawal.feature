
Feature: Cash Withdrawal
  Scenario: Successful withdrawal 20 from an account in credit
    Given my account has been credited with $100.00
    When I withdraw $20.00
    Then $20.00 should be dispensed
    And the balance of my account should be $80.00

  Scenario: Successful withdrawal 50 from an account in credit
    Given my account has been credited with $100.00
    When I withdraw $50.00
    Then $50.00 should be dispensed
    And the balance of my account should be $50.00

  Scenario: Successful withdrawal 100 from an account in credit
    Given my account has been credited with $100.00
    When I withdraw $100.00
    Then $100.00 should be dispensed
    And the balance of my account should be $0.00


