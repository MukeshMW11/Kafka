package com.mw.pub.entities;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false,length = 50)
    private String name;
    @Column(length = 200)
    private String description;
    @NotNull
    @Column(nullable = false, precision = 19, scale =2)
    private BigDecimal price;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",  nullable=false)
    @EqualsAndHashCode.Exclude
    private User user;

}
