package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Person;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Status;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface PersonBaseRepository<T extends Person>  extends CrudRepository<T, Long> {
    public Iterable<T> findAllByStatus(@Param("status") Status status);

    @Override
    public default void deleteById(Long id)
    {
        updateStatusById(id, Status.Deleted);
    }

    @Query("UPDATE Person c SET c.status = :status WHERE c.id = :personId")
    int updateStatusById(@Param("personId") Long id, @Param("status") Status status);
}
