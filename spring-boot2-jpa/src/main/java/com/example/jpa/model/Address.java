package com.example.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

/**
 * @author Weijun Yu
 * @since 2019-09-06.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

  private String street;

  private String city;

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  @Override
  public int hashCode() {
    return super.hashCode();
  }

}