package edu.shum.productexample.dao;

import edu.shum.productexample.model.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public interface ProductDao extends JpaRepository<Product, UUID> {

    @EntityGraph("product-catalog")
    List<Product> getByCatalogId(UUID catalogId, Pageable page);

    @EntityGraph("product-catalog")
    Optional<Product> findOneById(UUID id);
}
