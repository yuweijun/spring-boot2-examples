package com.example.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FridaySteps {

  private String today;

  private String actualAnswer;

  @Given("today is {string}")
  public void todayIsSunday(String day) {
    this.today = day;
  }

  @When("I ask whether it's Friday yet")
  public void iAskWhetherItsFridayYet() {
    if (this.today.equals("Friday")) {
      this.actualAnswer = "TGIF";
    } else {
      this.actualAnswer = "Nope";
    }
  }

  @Then("I should be told {string}")
  public void iShouldBeTold(String expectedAnswer) {
    Assert.assertEquals(expectedAnswer, actualAnswer);
  }

}