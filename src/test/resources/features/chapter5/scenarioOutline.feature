# “Sometimes you have several scenarios that follow exactly the same pattern of steps,
# just with different input values or expected outcomes.

Feature:Withdraw Fixed Amount
  The "Withdraw Cash" menu contains several fixed amounts to speed up transactions for users.

  Scenario: Withdraw fixed amount of $50
    Given I have $500 in my account
    When I choose to withdraw the fixed amount of $50
    Then I should receive $50 cash
    And the balance of my account should be $450

  Scenario:Withdraw fixed amount of $100
    Given I have $500 in my account
    When I choose to withdraw the fixed amount of $100
    Then I should receive $100 cash
    And the balance of my account should be $400

  Scenario:Withdraw fixed amount of $200
    Given I have $500 in my account
    When I choose to withdraw the fixed amount of $200
    Then I should receive $200 cash
    And the balance of my account should be $300

# “We can use a scenario outline to specify the steps once and then play multiple sets of values through them.”
Feature: Withdraw Fixed Amount
  The "Withdraw Cash" menu contains several fixed amounts to  speed up transactions for users.

  Scenario Outline:Withdraw fixed amount
    Given I have <Balance> in my account
    When I choose to withdraw the fixed amount of <Withdrawal>
    Then I should receive <Received> cash
    And the balance of my account should be <Remaining>
    Examples:
      | Balance | Withdrawal | Received | Remaining |
      | $500    | $50        | $50      | $450      |
      | $500    | $100       | $100     | $400      |
      | $500    | $200       | $200     | $300      |
        # Remember that although the syntax for writing them in Gherkin is the same,
        # these tables are totally different from the data tables we described earlier
        # in this chapter. Data tables just describe a lump of data to attach to a single
        # step of a single scenario. In a scenario outline, each row of an Examples table
        # represents a whole scenario to be executed by Cucumber. In fact, you might want
        # to use the keyword Scenarios (note the extra s) in place of Examples if you find that more readable.”

  Scenario: Try to withdraw too much
    Given I have $100 in my account
    When I choose to withdraw the fixed amount of $200
    Then I should see an error message
    And the balance of my account should be $100”
# There’s still a good deal of duplication here with the flow of the scenarios above it
# , but because the Then step is so different, we can’t put this one into the scenario outline.
  # Let’s change the scenario outline, replacing the <Received> placeholder with a more abstract <Outcome>:
  Scenario Outline:Withdraw fixed amount
    Given I have <Balance> in my account
    When I choose to withdraw the fixed amount of <Withdrawal>
    Then I should <Outcome>
    And the balance of my account should be <Remaining>
    Examples:
      | Balance | Withdrawal | Remaining | Outcome              |
      | $500    | $50        | $450      | receive $50 cash     |
      | $500    | $100       | $400      | receive $100 cash    |
      | $500    | $200       | $300      | receive $200 cash    |
      | $100    | $200       | $100      | see an error message |

    #Cucumber will happily handle any number of Examples elements beneath a Scenario Outline,
      # meaning you can group different kinds of examples together

  Scenario Outline: Withdraw fixed amount
    Given I have <Balance> in my account
    When I choose to withdraw the fixed amount of <Withdrawal>
    Then I should <Outcome>
    And the balance of my account should be <Remaining>
    Examples: Successful withdrawal
      | Balance | Withdrawal | Outcome           | Remaining |
      | $500    | $50        | receive $50 cash  | $450      |
      | $500    | $100       | receive $100 cash | $400      |
    Examples: Attempt to withdraw too much
      | Balance | Withdrawal | Outcome              | Remaining |
      | $100    | $200       | see an error message | $100      |
      | $0      | $50        | see an error message | $0        |
# Remember to include a plain-language description of the underlying rule that the examples
# are supposed to illustrate!

  Scenario Outline: Password validation
    Given I try to create an account with password <Password>
    Then I should see that the password <Valid or Invalid>
    Examples: Too Short
    Passwords are invalid if less than 4 characters
      | Password | Valid or Invalid |
      | abc      | invalid          |
      | ab1      | invalid          |
    Examples: Letters and Numbers
    Passwords need both letters and numbers to be valid
      | Password | Valid or Invalid |
      | abc1     | valid            |
      | abcd     | invalid          |
      | abcd1    | valid            |

