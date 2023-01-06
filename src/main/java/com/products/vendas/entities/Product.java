package com.products.vendas.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "tb_product")
public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private Long id;
    private String name;

    private String description;

    private Double price;

    private String imgURL;

    @ManyToMany
    private Set<Category> categories = new HashSet<>();
}