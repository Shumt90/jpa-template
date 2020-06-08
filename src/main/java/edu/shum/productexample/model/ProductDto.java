package edu.shum.productexample.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
    private UUID id;
    private String name;
    private CatalogDto catalog;

    public static Product toEntity(ProductDto dto, Catalog catalog) {
        var entity = Product.builder()
                .id(dto.id)
                .name(dto.name);

        if (catalog != null) {
            entity.catalog(catalog);
        }

        return entity.build();
    }

    public static ProductDto toDto(Product entity) {
        var dto = ProductDto.builder()
                .name(entity.getName())
                .id(entity.getId());

        if (entity.getCatalog() != null)
            dto.catalog(CatalogDto.toDto(entity.getCatalog()));

        return dto.build();

    }
}
