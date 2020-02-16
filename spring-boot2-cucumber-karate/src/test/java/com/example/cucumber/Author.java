package com.example.cucumber;

/**
 * @author Weijun Yu
 * @since 2020-02-16
 */
public class Author {

  private String firstName;

  private  String lastName;

  private String famousBook;

  public Author() {
  }

  public Author(String firstName, String lastName, String famousBook) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.famousBook = famousBook;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFamousBook() {
    return famousBook;
  }

  public void setFamousBook(String famousBook) {
    this.famousBook = famousBook;
  }

  @Override
  public String toString() {
    return "Author{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", famousBook='" + famousBook + '\'' +
        '}';
  }
}
