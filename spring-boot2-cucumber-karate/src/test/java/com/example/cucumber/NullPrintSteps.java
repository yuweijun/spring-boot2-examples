package com.example.cucumber;

import io.cucumber.java.en.Then;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Weijun Yu
 * @since 2020-02-14
 */
public class NullPrintSteps {

  private static final Logger LOGGER = LoggerFactory.getLogger(NullPrintSteps.class);

  @Then("print the word in the examples {string}")
  public void printWordInTheExamples(String value) {
    LOGGER.info("Is the value null? " + (value == null));
    LOGGER.info("Print the word " + value);
  }

}
