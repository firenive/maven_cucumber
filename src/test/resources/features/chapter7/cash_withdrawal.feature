
Feature: Cash Withdrawal
  Scenario: Successful withdrawal from an account in credit
    Given I have deposited $20.00 in my account
    When I withdraw $20.00
    Then $20.00 should be dispensed

  Scenario: Successful withdrawal from an account in credit 2
    Given I have deposited $20.00 in my account
    When I withdraw $30.00
    Then $10.00 should be dispensed
