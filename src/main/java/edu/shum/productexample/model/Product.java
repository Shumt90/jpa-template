package edu.shum.productexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.UUID;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "product-catalog", attributeNodes = {@NamedAttributeNode("catalog")})
public class Product {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ManyToOne
    private Catalog catalog;
}
