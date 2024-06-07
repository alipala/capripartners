Feature: Art Object API

  @smoke
  Scenario: Get details of an artwork by ID
    Given I have a valid API key
    When I send a GET request to "/api/en/collection/SK-C-5"
    Then the response status code should be 200
    And the response should contain the title "The Night Watch"

  @regression @e2e
  Scenario Outline: Get details of an artwork with optional parameters
    Given I have a valid API key
    When I send a GET request to "/api/en/collection/<id>?imgonly=<imgonly>"
    Then the response status code should be 200
    And the response should contain the title "<title>"

    Examples:
      | id       | imgonly | title            |
      | SK-C-5   | true    | The Night Watch  |
      | SK-A-1505| false   | The Milkmaid     |

  @e2e
  Scenario: Get details of a non-existent artwork
    Given I have a valid API key
    When I send a GET request to "/api/en/collection/INVALID_ID"
    Then the response status code should be 404
