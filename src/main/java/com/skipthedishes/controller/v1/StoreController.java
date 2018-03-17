package com.skipthedishes.controller.v1;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * All operations with a store will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("api/v1/Store")
public class StoreController {

    @GetMapping("/")
    public String getAll(@RequestHeader(value = "Authorization") String token) {
        return "";
    }

    @GetMapping("/search/{searchText}")
    public String searchByText(@RequestHeader(value = "Authorization") String token,
                               @Valid @PathVariable String searchText) {
        return "";
    }

    @GetMapping("/{storeId}/products")
    public String getProductsByStore(@RequestHeader(value = "Authorization") String token,
                                     @Valid @PathVariable long storeId) {
        return "";
    }

    @GetMapping("/{storeId}")
    public String getStore(@RequestHeader(value = "Authorization") String token,
                           @Valid @PathVariable long storeId) {
        return "";
    }
}
