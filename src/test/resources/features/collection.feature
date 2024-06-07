Feature: Collection API

  @smoke
  Scenario: Search artworks with valid query
    Given I have a valid API key
    When I send a GET request to "/collection?q=rembrandt"
    Then the response status code should be 200
    And the response should contain artworks

  @regression @e2e
  Scenario Outline: Search artworks with optional parameters
    Given I have a valid API key
    When I send a GET request to "/collection?q=<query>&imgonly=<imgonly>&ps=<ps>"
    Then the response status code should be 200
    And the response should contain artworks

    Examples:
      | query     | imgonly | ps  |
      | rembrandt | true    | 10  |
      | vermeer   | false   | 5   |
      | rembrandt | true    | 20  |

  @e2e
  Scenario: Search artworks with invalid API key
    Given I have an invalid API key
    When I send a GET request to "/collection?q=rembrandt"
    Then the response status code should be 401


    # TODO: Add culture NL test