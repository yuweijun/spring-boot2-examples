package com.example.cucumber;

/**
 * @author Weijun Yu
 * @since 2020-02-16
 */
public class Book {

  private String bookName;

  public Book(String bookName) {
    this.bookName = bookName;
  }

  public String getBookName() {
    return bookName;
  }

  public void setBookName(String bookName) {
    this.bookName = bookName;
  }

  @Override
  public String toString() {
    return "Book{" +
        "bookName='" + bookName + '\'' +
        '}';
  }
}
