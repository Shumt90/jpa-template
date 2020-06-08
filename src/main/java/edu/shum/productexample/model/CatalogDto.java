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
public class CatalogDto {

    private UUID id;
    private String name;
    private UUID parentId;

    public static Catalog toEntity(CatalogDto dto) {
        return Catalog.builder()
                .id(dto.id)
                .name(dto.name)
                .parentId(dto.parentId)
                .build();
    }

    public static CatalogDto toDto(Catalog entity) {

        return CatalogDto.builder()
                .name(entity.getName())
                .id(entity.getId())
                .parentId(entity.getParentId())
                .build();

    }

}
