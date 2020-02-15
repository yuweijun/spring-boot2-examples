package com.example.cucumber;

import io.cucumber.java.en.Given;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Weijun Yu
 * @since 2020-02-14
 */
public class DataTableSteps {

  private static final Logger LOGGER = LoggerFactory.getLogger(DataTableSteps.class);

  @Given("I create user")
  public void createUser(io.cucumber.datatable.DataTable dataTable) {
    List<List<String>> table = dataTable.asLists(String.class);
    for (List<String> row : table) {
      LOGGER.info("row is : {}", row);
    }
  }

}
