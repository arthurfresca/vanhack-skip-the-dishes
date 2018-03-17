package com.skipthedishes.controller.mapper;

import com.skipthedishes.datatransferobject.v1.ProductDTO;
import com.skipthedishes.domainobject.ProductDO;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ProductMapper {

    public static ProductDO makeProductDO(ProductDTO productDTO) {
        return new ProductDO.ProductDOBuilder()
                .withDescription(productDTO.getDescription())
                .withId(productDTO.getId())
                .withPrice(productDTO.getPrice()).build();
    }


    public static ProductDTO makeProductDTO(ProductDO productDO) {
        return ProductDTO.ProductDTOBuilder.aProductDTO()
                .withDescription(productDO.getDescription())
                .withId(productDO.getId())
                .withPrice(productDO.getPrice())
                .withStoreId((productDO.getStore() != null) ? productDO.getStore().getId() : 0)
                .build();
    }


    public static List<ProductDTO> makeProductDTOList(Collection<ProductDO> products) {
        return products.stream()
            .map(ProductMapper::makeProductDTO)
            .collect(Collectors.toList());
    }
}
