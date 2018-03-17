package com.skipthedishes.dataaccessobject;

import com.skipthedishes.domainobject.ProductDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Database Access Object for product table.
 * <p/>
 */

@Repository
public interface ProductRepository extends CrudRepository<ProductDO, Long> {

    List<ProductDO> findByNameIgnoreCaseContainingOrDescriptionIgnoreCaseContaining(String name, String description);

}
