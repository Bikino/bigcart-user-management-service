package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Status;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.VendorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class VendorServiceImpl implements VendorService{

    @Autowired
    private VendorRepository vendorRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Vendor> getAll(){

        List<Vendor> list = new ArrayList<>();
        vendorRepository.findAllByStatus(Status.Approved).forEach(list::add);
        return  list;
    }

    @Override
    public List<Vendor> getAllPending() {
        List<Vendor> list = new ArrayList<>();
        vendorRepository.findAllByStatus(Status.Pending).forEach(list::add);
        return  list;
    }

    @Override
    public Vendor getById(long id)
    {
        Optional<Vendor> temp = vendorRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Vendor add(Vendor vendor) {
        vendor.setUserName(vendor.getUserName().toLowerCase());
        vendor.setPassword(passwordEncoder.encode(vendor.getPassword()));
        return vendorRepository.save(vendor);
    }

    @Override
    public Vendor update(long id, Vendor newVendor) throws IllegalAccessException {

        Vendor oldVendor = getById(id);

        for(Field field : Vendor.class.getFields())
        {
            if(!field.get(oldVendor).equals(field.get(newVendor)))
                field.set(oldVendor, field.get(newVendor));
        }

        return vendorRepository.save(oldVendor);
    }

    @Override
    public boolean deleteById(long id)
    {
        if(getById(id) == null)
            return false;
        vendorRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateStatus(long id, boolean status) {
        return vendorRepository.updateStatusById(id, status? Status.Approved : Status.Decline)>0;
    }

    @Override
    public Vendor login(String userName, String password) {
        Vendor ven = vendorRepository.findByUserName(userName.toLowerCase());
        if(ven == null)
            return null;
        if(passwordEncoder.matches(password, ven.getPassword()))
            return ven;
        return null;
    }
}
