package edu.shum.productexample.api;

import edu.shum.productexample.model.CatalogDto;
import edu.shum.productexample.service.CatalogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class CatalogController {

    private final CatalogService catalogService;

    @GetMapping("catalogs")
    public List<CatalogDto> getCatalogs(@RequestParam(value = "catalogId", required = false) UUID id, @RequestParam int page, @RequestParam int size) {
        return catalogService.findAll(id, page, size);
    }

    @GetMapping("catalogs/{id}")
    public CatalogDto getCatalog(@PathVariable("id") UUID id) {
        return catalogService.getOne(id);
    }

    @PostMapping("catalogs")
    public void upsertCatalog(@RequestBody CatalogDto dto) {
        catalogService.upsert(dto);
    }

    @DeleteMapping("catalogs/{id}")
    public void deleteCatalog(@PathVariable("id") UUID id) {
        catalogService.delete(id);
    }


}
