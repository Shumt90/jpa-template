package edu.shum.productexample.service;

import edu.shum.productexample.dao.CatalogDao;
import edu.shum.productexample.exception.ValidationException;
import edu.shum.productexample.model.CatalogDto;
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
public class CatalogService {

    private final CatalogDao catalogDao;

    public List<CatalogDto> findAll(UUID parentId, int page, int size) {

        if (page < 0 || size < 1 || size > 50) {
            throw new ValidationException("too much page size, limit 50. Or page<0 or size<1");
        }

        return catalogDao.getByParentId(parentId, PageRequest.of(page, size)).stream()
                .map(CatalogDto::toDto).collect(toList());
    }

    public CatalogDto getOne(UUID id) {
        return catalogDao.findOneById(id).map(CatalogDto::toDto)
                .orElseThrow(() -> new ValidationException(String.format("Catalog not found: %s", id.toString())));
    }

    @Transactional
    public void upsert(CatalogDto dto) {
        var catalog = CatalogDto.toEntity(dto);
        catalogDao.save(catalog);
    }


    public void delete(UUID id) {
        catalogDao.deleteById(id);
    }

}
