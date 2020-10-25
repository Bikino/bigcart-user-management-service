package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;

    @Override
    public List<Vendor> getAll(){

        List<Vendor> list = new ArrayList<>();
        vendorRepository.findAll().forEach(list::add);
        return  list;

    }

    @Override
    public Vendor getById(int id)
    {
        Optional<Vendor> temp = vendorRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Vendor add(Vendor vendor) {
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor update(int id, Vendor newVendor) throws IllegalAccessException {

        Vendor oldVendor = getById(id);

        for(Field field : Vendor.class.getFields())
        {
            if(!field.get(oldVendor).equals(field.get(newVendor)))
                field.set(oldVendor, field.get(newVendor));
        }

        return vendorRepository.save(oldVendor);
    }

    @Override
    public boolean deleteById(int id)
    {
        if(getById(id) == null)
            return false;
        vendorRepository.deleteById(id);
        return true;
    }



}
