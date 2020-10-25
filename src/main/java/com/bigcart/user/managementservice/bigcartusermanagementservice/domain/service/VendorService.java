package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;

import java.util.List;

public interface VendorService {

    List<Vendor> getAll();

    Vendor getById(int id);

    Vendor add(Vendor Vendor);

    Vendor update(int id, Vendor newVendor) throws IllegalAccessException;

    boolean deleteById(int id);
}
