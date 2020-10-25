package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;

import java.util.List;

public interface BuyerService {

    List<Buyer> getAll();

    Buyer getById(int id);

    Buyer add(Buyer Buyer);

    Buyer update(int id, Buyer newBuyer) throws IllegalAccessException;

    boolean deleteById(int id);
}
