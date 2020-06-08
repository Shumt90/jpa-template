package edu.shum.productexample.api;

import edu.shum.productexample.model.ProductDto;
import edu.shum.productexample.model.ProductListDto;
import edu.shum.productexample.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("products")
    public List<ProductListDto> getProducts(@RequestParam(value = "catalogId", required = false) UUID id, @RequestParam int page, @RequestParam int size) {
        return productService.findAll(id, page, size);
    }

    @GetMapping("products/{id}")
    public ProductDto getProduct(@PathVariable("id") UUID id) {
        return productService.getOne(id);
    }

    @PostMapping("products")
    public void upsertProduct(@RequestBody ProductDto dto) {
        productService.upsert(dto);
    }

    @DeleteMapping("products/{id}")
    public void deleteProduct(@PathVariable("id") UUID id) {
        productService.delete(id);
    }


}
