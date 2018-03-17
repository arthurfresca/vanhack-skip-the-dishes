package com.skipthedishes.dataaccessobject;

import com.skipthedishes.domainobject.OrderDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Database Access Object for order table.
 * <p/>
 */

@Repository
public interface OrderRepository extends CrudRepository<OrderDO, Long> {
    OrderDO findFirstByIdAndIsActiveTrue(long id);
}
