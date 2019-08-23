package com.example.jpa.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Weijun Yu
 * @since 2019-08-23.
 */
@Entity
@Table(name = "t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Order {

    @Id
    @GeneratedValue
    private int id;

    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "t_order_coffee", joinColumns = {@JoinColumn(name = "order_id")})
    private List<Coffee> coffee;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
}
