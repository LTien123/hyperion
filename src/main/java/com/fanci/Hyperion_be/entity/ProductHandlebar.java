package com.fanci.Hyperion_be.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_handlebars")
public class ProductHandlebar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "style")
    private String style;

    @OneToMany(mappedBy = "productHandlebar")
    private List<ProductDetail> productDetails;
}
