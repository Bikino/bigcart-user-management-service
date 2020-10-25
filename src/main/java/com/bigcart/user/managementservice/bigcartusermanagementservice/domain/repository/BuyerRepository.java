package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;
import org.springframework.data.repository.CrudRepository;





// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BuyerRepository extends CrudRepository<Buyer, Integer> {

}
