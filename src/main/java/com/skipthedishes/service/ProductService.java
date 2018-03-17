package com.skipthedishes.service;

import com.skipthedishes.domainobject.ProductDO;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.EmptyListException;
import com.skipthedishes.exception.EntityNotFoundException;

import java.util.List;

public interface ProductService {

    ProductDO find(Long productId) throws EntityNotFoundException;

    ProductDO createOrUpdate(ProductDO productDO) throws ConstraintsViolationException;

    void delete(Long productId) throws EntityNotFoundException;

    List<ProductDO> find(String text) throws EmptyListException;

    List<ProductDO> findAll();

}
