@datatabletype
Feature: Type Registry
  https://cucumber.io/docs/cucumber/configuration/

  Scenario: print authors using type registry

    Given There are my favorite authors
      | firstName | lastName | famousBook |
      | fn1       | ln1      | book1      |
      | fn2       | ln2      | book2      |
