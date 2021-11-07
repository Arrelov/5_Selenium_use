#language: en
Feature: Wikipedia main page search test

  Background:
    Given I open wikipedia main page

      # здесь проверяется поиск по одной строчке
  Scenario: check search "a cap is a lie" returns > 1 results
    When I write text "a cap is a lie" to search field
    And I click search button
    Then  Wikipedia return > 1 results

  Scenario: check search "John Smith" returns > 1 results
    When I write text "John Smith" to search field
    And I click search button
    Then  Wikipedia return > 1 results

  Scenario: check search "оолфадр  рлоыврла" returns > 1 results
    When I write text "оолфадр  рлоыврла" to search field
    And I click search button
    Then  Wikipedia return > 1 results