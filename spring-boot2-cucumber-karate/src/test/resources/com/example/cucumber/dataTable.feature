@datatable
Feature: How to use the default DataTable in cucumber
  Cucumber support to define a table to test matrix data. For example

  Scenario: print the words

    Given I create user
      | userId | userName  |
      | adam   | adamZhang |
      | adam2  | Adam      |