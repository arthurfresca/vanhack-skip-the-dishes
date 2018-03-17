package com.skipthedishes.controller.v1;

import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * All operations with a cousine will be routed by this controller.
 * <p/>
 */
@RestController
@RequestMapping("api/v1/Cousine")
public class CousineController {


    @GetMapping("/")
    public String getAll(@RequestHeader(value = "Authorization") String token) {
        return "";
    }

    @GetMapping("/search/{searchText}")
    public String searchByText(@RequestHeader(value = "Authorization") String token,
                               @Valid @PathVariable String searchText) {
        return "";
    }

    @GetMapping("/{cousineId}/stores")
    public String getStoresByCousineId(@RequestHeader(value = "Authorization") String token,
                                       @Valid @PathVariable long cousineId) {
        return "";
    }

}
