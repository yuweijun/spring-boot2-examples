package com.example.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 这里注解的配置会被 Honey.hbm.xml 文件中的配置覆盖，如果 Honey.hbm.xml 文件配置出错，可能导致程序运行错误
 *
 * @author Weijun Yu
 * @since 2019-09-05.
 */
@Entity
@Table(name = "t_honey")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "honey_seq", sequenceName = "honey_id_seq")
public class Honey implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "honey_seq")
  private Integer id;

  private String name;

  private String taste;

  @OneToMany(mappedBy = "honey")
  private Set<Bee> bees = new HashSet<>();

  @Override
  public boolean equals(Object o) {
    return super.equals(o);
  }

  /**
   * 不用 lombok 生成的这 2 个方法，避免死循环
   */
  @Override
  public int hashCode() {
    return super.hashCode();
  }

  @Override
  public String toString() {
    return "Honey{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", taste='" + taste + '\'' +
        '}';
  }
}
