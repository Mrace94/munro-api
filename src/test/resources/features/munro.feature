Feature: Basic end-to-end tests

  Scenario: Search for a munro
    Given the client searches for a munro
    When the client submits the request
    Then the service returns a page of munros

  Scenario: Validation error
    Given the client searches for a munro with invalid query params
    When the client submits the request
    Then a validation exception should be thrown