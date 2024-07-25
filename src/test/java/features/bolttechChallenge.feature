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
@challenge
Feature: Selenium automation challenge

  Background: 
  	Given I navigate to the Main Page

  @req1
  Scenario: Verify device price dropdown loads
    When I wait for the dropdown list of price ranges to be visible
    Then the dropdown list should be visible
  @req2 
  Scenario: Select a random device purchase price
    When I select a random price from the dropdown
    Then the selected price should be correctly displayed in the dropdown
  @req2
  Scenario: Select a specific device purchase price
    When I select the price "2,000 - 6,000" from the dropdown
    Then the selected price "2,000 - 6,000" should be correctly displayed in the dropdown
  @req3-4
  Scenario: Navigate to checkout page
    Given I have selected a device purchase price
    When I click on the Select button on the card
    Then I should be navigated to the checkout page
    And the URL should contain "/device-protection/checkout/payment"
    And the URL should contain the utm_source parameter from the previous page
	@req5
  Scenario: Validate checkout summary information
    When I navigate to the checkout page
    Then the price displayed should match the price from the previous page
    And the product name should match the card title from the previous page
    And the provider should be "bolttech"
    And the contract start date should be todays date in Thailand timezone
    And the contract renewal should be "Monthly"

