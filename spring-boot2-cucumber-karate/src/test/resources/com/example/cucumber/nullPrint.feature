@nullprint
Feature: Print NULL value test
  can't print null value in examples

  Scenario Outline: print the words <word>
    Then print the word in the examples "<word>"

    Examples:
      | word     |
      | 1234     |
      | null     |
      | NULL     |
      | #null    |
      | #omit    |
      |          |