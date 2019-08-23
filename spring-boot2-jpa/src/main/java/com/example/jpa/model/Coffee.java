package com.example.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "t_menu")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coffee implements Serializable {
    
    @Id
    @GeneratedValue
    private int id;

    private String name;

    @Column
    private Long price;

    @Column(updatable = false)
    @CreationTimestamp
    private Date createTime;

    @UpdateTimestamp
    private Date updateTime;
}
