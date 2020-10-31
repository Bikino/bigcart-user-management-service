package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAll();

    List<Vendor> getAllPending();

    Vendor getById(long id);

    Vendor add(Vendor Vendor);

    Vendor update(long id, Vendor newVendor) throws IllegalAccessException;

    boolean updateStatus(long id, boolean status);

    boolean deleteById(long id);

    Vendor login(String userName, String password);
}
