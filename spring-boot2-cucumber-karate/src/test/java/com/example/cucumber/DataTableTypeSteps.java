package com.example.cucumber;

import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

/**
 * @author Weijun Yu
 * @since 2020-02-16
 */
public class DataTableTypeSteps {

  @DataTableType
  public Author author(Map<String, String> entry) {
    System.out.println(entry);
    return new Author(entry.get("firstName"), entry.get("lastName"), entry.get("famousBook"));
  }

  @Given("There are my favorite authors")
  public void theseAreMyFavouriteAuthors(List<Author> authors) {
    for (Author author : authors) {
      System.out.println(author);
    }
  }

}
