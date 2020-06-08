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
public class ProductListDto {
    private UUID id;
    private String name;

    public static ProductListDto toDto(Product entity) {
        var dto = ProductListDto.builder()
                .name(entity.getName())
                .id(entity.getId());

        return dto.build();

    }
}
