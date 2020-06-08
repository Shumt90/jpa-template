package edu.shum.productexample.dao;

import edu.shum.productexample.model.Catalog;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Transactional
public interface CatalogDao extends JpaRepository<Catalog, UUID> {
    List<Catalog> getByParentId(UUID parentId, Pageable page);

    Optional<Catalog> findOneById(UUID id);
}
