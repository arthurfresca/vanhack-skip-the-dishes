package com.skipthedishes.dataaccessobject;

import com.skipthedishes.domainobject.CustomerDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Database Access Object for customer table.
 * <p/>
 */

@Repository
public interface CustomerRepository extends CrudRepository<CustomerDO, Long> {

    @Query("SELECT c FROM CustomerDO c WHERE c.email = :email and  c.password = :password")
    List<CustomerDO> findExisting(@Param("email") String email, @Param("password") String password);
}
