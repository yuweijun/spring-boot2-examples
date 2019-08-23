package com.example.jpa.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Weijun Yu
 * @since 2019-08-23.
 */
@Entity
@Table(name = "t_user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class User {

  @Id
  @GeneratedValue
  private int id;

  private String name;

  private String nickName;

  private String mobile;

  @Column(updatable = false)
  @CreationTimestamp
  private Date createTime;

  @UpdateTimestamp
  private Date updateTime;
}
