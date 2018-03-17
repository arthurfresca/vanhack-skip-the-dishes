package com.skipthedishes.controller.v1;

import com.skipthedishes.controller.mapper.ProductMapper;
import com.skipthedishes.datatransferobject.v1.ProductDTO;
import com.skipthedishes.exception.EmptyListException;
import com.skipthedishes.exception.EntityNotFoundException;
import com.skipthedishes.service.AuthenticateService;
import com.skipthedishes.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * All operations with a product will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("api/v1/Product")
public class ProductController {

    private final ProductService productService;

    private final AuthenticateService authenticateService;

    @Autowired
    public ProductController(final ProductService productService, final AuthenticateService authenticateService) {
        this.productService = productService;
        this.authenticateService = authenticateService;
    }

    @GetMapping("/")
    public List<ProductDTO> getAll(@RequestHeader(value = "Authorization") String token) {
        return ProductMapper.makeProductDTOList(productService.findAll());
    }

    @GetMapping("/search/{searchText}")
    public List<ProductDTO> searchByText(@RequestHeader(value = "Authorization") String token,
                                         @Valid @PathVariable String searchText) throws EmptyListException {
        return ProductMapper.makeProductDTOList(productService.find(searchText));
    }

    @GetMapping("/{productId}")
    public ProductDTO getProductById(@RequestHeader(value = "Authorization") String token,
                                     @Valid @PathVariable long productId) throws EntityNotFoundException {
        return ProductMapper.makeProductDTO(productService.find(productId));
    }
}
