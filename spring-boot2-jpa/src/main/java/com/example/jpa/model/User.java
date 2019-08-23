package com.example.jpa.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

/**
 * @author Weijun Yu
 * @since 2019-08-23.
 */
@Data
@Builder
@ToString
public class User {
  private int id;

  private String name;

  private String nickName;

  private int age;
}
