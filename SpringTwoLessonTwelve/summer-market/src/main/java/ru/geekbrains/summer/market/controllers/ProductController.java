package ru.geekbrains.summer.market.controllers;

import io.swagger.annotations.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.summer.market.dto.ProductDto;
import ru.geekbrains.summer.market.model.Product;
import ru.geekbrains.summer.market.repositories.specifications.ProductSpecifications;
import ru.geekbrains.summer.market.services.ProductService;
import ru.geekbrains.summer.market.exceptions.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
@Api("Set of endpoints for products")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "/{id}")
    @ApiOperation("Returns a specific product by their identifier. 404 if does not exist.")
    public ProductDto findById(@ApiParam("Id of the product. Cannot be empty.") @PathVariable Long id) {
        Product p = productService.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found, id: " + id));
        return new ProductDto(p);
    }

    @GetMapping
    @ApiOperation("Returns list of all products in the store.")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "title", example = "Bread", type = "String", required = false, paramType = "query"),
            @ApiImplicitParam(name = "min_price", example = "100.0", type = "BigDecimal", required = false, paramType = "query"),
            @ApiImplicitParam(name = "max_price", example = "2000.0", type = "BigDecimal", required = false, paramType = "query")
    })
    public Page<ProductDto> findAll(
            @RequestParam(name = "p", defaultValue = "1") int pageIndex,
            @RequestParam MultiValueMap<String, String> params
    ) {
        return productService.findPage(pageIndex - 1, 5, params).map(ProductDto::new);
    }

    @PostMapping
    public ProductDto createNewProduct(@RequestBody ProductDto newProductDto) {
        Product product = new Product();
        product.setPrice(newProductDto.getPrice());
        product.setTitle(newProductDto.getTitle());
        return new ProductDto(productService.save(product));
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.deleteById(id);
    }
}
