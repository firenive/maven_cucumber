@featureTag
Feature: tags

  You tag a scenario by putting a word prefixed with the @ character on the line
  before the Scenario keyword, like this:

  @slow @widgets @nightly @scenarioTag
  Scenario: Generate overnight report
    Given I am logged in
    And there is a report "Total widget sales history"

  # if you want to tag all the scenarios in a feature at once, just tag the Feature element
  # at the top, and all the scenarios will inherit the tag. You can still tag individual scenarios as well.

  # There are three main reasons for tagging scenarios:
  #Documentation: You want to use a tag to attach a label to certain scenarios,
    # for example to label them with an ID from a project management tool.
  # Filtering: Cucumber allows you to use tags as a filter to pick out specific
    # scenarios to run or report on. You can even have Cucumber fail your
      # test run if a certain tag appears too many times.
  # Hooks: Run a block of code whenever a scenario with a particular tag is about to start or has just finished.

