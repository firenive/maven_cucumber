#Doc strings allow you to specify a larger piece of text than you could fit  on a single line.
Feature: doc strings

  Scenario: Ban Unscrupulous Users
    When I behave unscrupulously
    Then I should receive an email containing:
  """
  Dear Sir,
  Your account privileges have been revoked due to your unscrupulous behavior.
      Sincerely,
      The Management
  """
    And my account should be locked

# Just like a data table, the entire string between the """ triple quotes is attached to the step above it.