package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> getAll();

    Address getById(int id);

    Address add(Address Address);

    Address update(int id, Address newAddress) throws IllegalAccessException;

    boolean deleteById(int id);
}
