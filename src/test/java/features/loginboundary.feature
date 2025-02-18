Feature: Login Boundary Test
  @TDD
  Scenario Outline: Boundary test login for username and password
    Given sauce demo login page
    When user input <username> as username
    And user input <password> as password
    And click login button
    Then user should see <expected_result> as expected_result

    Examples:
      | username       | password      | expected_result                       |
      | standard_user  | ""            | "Epic sadface: Password is required"  |