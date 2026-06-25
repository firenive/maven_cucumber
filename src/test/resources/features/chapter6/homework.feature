Feature: Homework
  # Start by just trying to work out what’s going on: what do you think this system does?
  # What is the purpose of the scenario? What behavior is it trying to test?
  # Notice how the incidental details are like overgrown weeds, getting in the way
  # of you figuring out what the test is actually trying to do.
  # Now that you understand the essence of the scenario, rewrite it in your own words.
  # You should need much fewer steps, but you might want to consider using more than one scenario.

  Scenario:Create an invoice (original)
    Given I am a signed-in user with role: admin
    And a client "Test Client" exists with name: "Test Client"
    And a project "Test Project" exists with:
      | name   | "Test Project"       |
      | client | client "Test Client" |
    And an issue "Test Issue" exists with:
      | project | project "Test Project" |
      | name    | "Test Issue"           |
    And a work_unit "Test Work Unit" exists with:
      | issue        | issue "Test Issue" |
      | completed_on | "2011-08-24"       |
      | hours        | "7.5"              |
    And I am on the admin invoices page
    Then I should see "Test Client"
    And I follow "Test Client"
    And I fill in "invoice_id" with "abc"
    And I press "Submit"
    Then I am on the admin invoices page
    And I should not see "Test Client"

      # 1. Not clearly defining goal in section Then. Scenario is "Create invoice",
      # Then doesn't check result of creating
      # 2. overloaded Given section with a lot of parameters

  Scenario: Create an invoice (rewritten)
    Given I am a signed-in user with role: admin
    And a client "Test Client" exists with name: "Test Client"
    And I am on the admin invoices page
    When I follow "Test Client"
    And I create new invoice filling "invoice_id"
    Then In admin invoices page I see the created invoice







