package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Guest;

import java.util.List;

public interface GuestService {

    List<Guest> getAll();

    Guest getById(int id);

    Guest add(Guest Guest);

    Guest update(int id, Guest newGuest) throws IllegalAccessException;

    boolean deleteById(int id);
}
