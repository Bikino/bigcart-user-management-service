package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface BuyerRepository extends CrudRepository<Buyer, Long>, QueryByExampleExecutor<Buyer> {

    public default Buyer findByUserName(String userName){
        Buyer buyer = new Buyer();
        buyer.setUserName(userName);
        Example<Buyer> BuyerExample = Example.of(buyer);
        return this.findOne(BuyerExample).get();
    }

}
