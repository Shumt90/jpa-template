package edu.shum.productexample.service;

import edu.shum.productexample.dao.CatalogDao;
import edu.shum.productexample.dao.ProductDao;
import edu.shum.productexample.exception.ValidationException;
import edu.shum.productexample.model.Catalog;
import edu.shum.productexample.model.ProductDto;
import edu.shum.productexample.model.ProductListDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private final ProductDao productDao;
    private final CatalogDao catalogDao;

    public List<ProductListDto> findAll(UUID catalogId, int page, int size) {

        if (page < 0 || size < 1 || size > 50) {
            throw new ValidationException("too much page size, limit 50. Or page<0 or size<1");
        }

        return productDao.getByCatalogId(catalogId, PageRequest.of(page, size)).stream()
                .map(ProductListDto::toDto).collect(toList());
    }

    public ProductDto getOne(UUID id) {
        return productDao.findOneById(id).map(ProductDto::toDto)
                .orElseThrow(() -> new ValidationException(String.format("product not found: %s", id.toString())));
    }

    @Transactional
    public void upsert(ProductDto dto) {

        Catalog catalog = null;
        if (dto.getCatalog() != null && dto.getCatalog().getId() != null)
            catalog = catalogDao.getOne(dto.getCatalog().getId());

        var product = ProductDto.toEntity(dto, catalog);

        productDao.save(product);
    }

    public void delete(UUID id) {
        productDao.deleteById(id);
    }

}
