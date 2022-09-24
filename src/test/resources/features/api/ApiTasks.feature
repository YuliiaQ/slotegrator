Feature: API tasks

  Scenario: Getting guest token
    When User send Get guest token request and see 200 code in response

  Scenario: Registration of a new player
    When User send Get guest token request and see 200 code in response
    Then User send register a new player request and see 201 code and a new player in response

  Scenario: Authorization under a player
    When User send Get guest token request and see 200 code in response
    And User send register a new player request and see 201 code and a new player in response
    When User send Authorization under a player request and see 200 for authorization code in response

  Scenario: Get existing player profile
    When User send Get guest token request and see 200 code in response
    Then User send register a new player request and see 201 code and a new player in response
    When User send Authorization under a player request and see 200 for authorization code in response
    When User send Get existing player's profile request and see existing player's information

  Scenario: Get not existing player profile
    When User send Get guest token request and see 200 code in response
    Then User send register a new player request and see 201 code and a new player in response
    When User send Authorization under a player request and see 200 for authorization code in response
    When User send Get not existing player's profile request and see 404 code response
