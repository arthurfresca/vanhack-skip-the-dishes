package com.skipthedishes.service;

import com.skipthedishes.dataaccessobject.ProductRepository;
import com.skipthedishes.domainobject.ProductDO;
import com.skipthedishes.exception.ConstraintsViolationException;
import com.skipthedishes.exception.EmptyListException;
import com.skipthedishes.exception.EntityNotFoundException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service to encapsulate the link between DAO and controller and to have business logic for some producet specific things.
 * <p/>
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static org.slf4j.Logger LOG = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(final ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    /**
     * Selects a product by id.
     *
     * @param productId
     * @return found product
     * @throws EntityNotFoundException if no product with the given id was found.
     */
    @Override
    public ProductDO find(Long productId) throws EntityNotFoundException {
        return findProductChecked(productId);
    }

    @Override
    public ProductDO createOrUpdate(ProductDO productDO) throws ConstraintsViolationException {
        return null;
    }

    @Override
    public void delete(Long productId) throws EntityNotFoundException {

    }

    @Override
    public List<ProductDO> find(String text) throws EmptyListException {
        return findProductChecked(text);
    }

    @Override
    public List<ProductDO> findAll() {
        return null;
    }


    private ProductDO findProductChecked(Long productId) throws EntityNotFoundException {
        ProductDO productDO = productRepository.findOne(productId);
        checkExceptions(productDO);
        return productDO;
    }

    private List<ProductDO> findProductChecked(String text) throws EmptyListException {
        List<ProductDO> productsDO = productRepository.findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(text, text);
        checkExceptions(productsDO);
        return productsDO;
    }

    private void checkExceptions(ProductDO productDO) throws EntityNotFoundException {
        if (productDO == null) {
            String ex = "Could not find entity.";
            throw new EntityNotFoundException(ex);
        }
    }

    private void checkExceptions(List<ProductDO> productDO) throws EmptyListException {
        if (productDO.size() == 0) {
            String ex = "Product list is empty";
            throw new EmptyListException(ex);
        }
    }


}
