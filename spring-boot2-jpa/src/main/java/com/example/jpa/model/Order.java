package com.example.jpa.model;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author Weijun Yu
 * @since 2019-08-23.
 */
@Data
@Builder
@ToString
public class Order {

  private int id;

  private String description;

  private Date date;

  private User user;
}
