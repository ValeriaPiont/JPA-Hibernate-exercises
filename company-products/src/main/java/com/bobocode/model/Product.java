package com.bobocode.model;

import jdk.jfr.Enabled;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

/**
 * todo:
 * - implement no arguments constructor
 * - implement getters and setters for all fields
 * - implement equals() and hashCode() based on identifier field
 * <p>
 * - configure JPA entity
 * - specify table name: "product"
 * - configure auto generated identifier
 * - configure mandatory column "name" for field {@link Product#name}
 * <p>
 * - configure lazy many-to-one relation between {@link Product} and {@link Company}
 * - configure foreign key column "company_id" references company table
 */
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
