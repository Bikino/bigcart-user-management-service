package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface VendorRepository extends PersonBaseRepository<Vendor>, QueryByExampleExecutor<Vendor> {

    public default Vendor findByUserName(String userName){
        Vendor vendor = new Vendor();
        vendor.setUserName(userName);
        Example<Vendor> VendorExample = Example.of(vendor);
        return this.findOne(VendorExample).get();
    }

}
