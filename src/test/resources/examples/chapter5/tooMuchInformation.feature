Feature: Too much information

  # It’s entirely appropriate to go into this much detail about the authentication process
  # in this scenario, because that’s where our focus is.”
  # Now consider our cash withdrawal scenario from earlier, which has a different focus
  # but  still needs to be authenticated.

  Scenario: Withdraw fixed amount of $50
    Given I have $500 in my account
    And I have pushed my card into the slot
    And I enter my PIN  And I press "OK"
    When I choose to withdraw the fixed amount of $50
    Then I should receive $50 cash
    And the balance of my account should be $450
# “There’s so much noise about authentication that we hardly notice the important part:
# the part about withdrawing cash.”

  # Let’s take the three authentication steps and summarize what they do with a single high-level step:

  Scenario: Withdraw fixed amount of $50
    Given I have authenticated with the correct PIN
    When I choose to withdraw the fixed amount of $50
    Then I should receive $50 cash
    And the balance of my account should be $450

