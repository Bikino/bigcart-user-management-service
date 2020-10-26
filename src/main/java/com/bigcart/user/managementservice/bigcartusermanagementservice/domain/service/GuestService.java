package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> getAll();

    Guest getById(long id);

    Guest add(Guest Guest);

    Guest update(long id, Guest newGuest) throws IllegalAccessException;

    boolean deleteById(long id);
}
