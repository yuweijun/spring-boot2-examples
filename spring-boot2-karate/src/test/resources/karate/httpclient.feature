Feature: Testing a REST API
  Users should be able to submit GET and POST requests to a web service, represented by WireMock

  Scenario: Testing valid GET endpoint
    Given url 'http://localhost:8097/user/get'
    When method GET
    Then status 200

  Scenario Outline: Testing user name endpoint : <name>
    Given url 'http://localhost:8097/user/name?name=<name>'
    When method GET
    Then status 200

    Examples:
      | name  |
      | Tim   |
      | Tom   |
      | David |
      | John  |
      | Luise |

  Scenario: Testing the exact response of a GET endpoint
    Given url 'http://localhost:8097/user/get'
    When method GET
    Then status 200
    And match $ == {id:"1", name:"Test UserName"}

  Scenario: Testing that GET response contains specific field
    Given url 'http://localhost:8097/user/get'
    When method GET
    Then status 200
    And match $ contains {id:"1"}

  Scenario: Test GET request exact response
    Given url 'http://localhost:8097/user/get'
    When method GET
    Then status 200
    And match $ == {id:"#notnull", name:"Test UserName"}

  Scenario: Testing a POST endpoint with request body
    Given url 'http://localhost:8097/user/create'
    And request { id: '1', name: 'Test UserName'}
    When method POST
    Then status 200
    And match $ contains {id:"#notnull"}

  Scenario: Testing httpbin.org GET endpoint
    Given url 'https://httpbin.org/get'
    When method GET
    Then status 200
    And match $ contains {url: "#notnull"}
