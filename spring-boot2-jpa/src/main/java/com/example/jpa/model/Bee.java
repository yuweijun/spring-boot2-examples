package com.example.jpa.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Weijun Yu
 * @since 2019-09-05.
 */
@Entity
@Table(name = "t_bee")
@Builder
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Bee implements Serializable {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bee_gen")
  @SequenceGenerator(name = "bee_gen", sequenceName = "bee_id_seq")
  private Integer id;

  @NonNull
  private String name;

  @ManyToOne
  private Honey honey;

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
    return "Bee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }
}
