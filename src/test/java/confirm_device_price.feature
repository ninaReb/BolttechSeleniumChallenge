#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Confirm device price

  @tag1
  Scenario: Verify device price dropdown loads
    Given I navigate to "https://www.bolttech.co.th/en/ascend/device-protection?utm_source=ascend"
    And I disable any ad blocker on my browser
    When I wait for the dropdown list of price ranges to be visible
    Then the dropdown list should be visible


