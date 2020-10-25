package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Address;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<Address> getAll(){

        List<Address> list = new ArrayList<>();
        addressRepository.findAll().forEach(list::add);
        return  list;

    }

    @Override
    public Address getById(int id)
    {
        Optional<Address> temp = addressRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Address add(Address Address) {
        return addressRepository.save(Address);
    }

    @Override
    public Address update(int id, Address newAddress) throws IllegalAccessException {

        Address oldAddress = getById(id);

        for(Field field : Address.class.getFields())
        {
            if(!field.get(oldAddress).equals(field.get(newAddress)))
                field.set(oldAddress, field.get(newAddress));
        }

        return addressRepository.save(oldAddress);
    }

    @Override
    public boolean deleteById(int id)
    {
        if(getById(id) == null)
            return false;
        addressRepository.deleteById(id);
        return true;
    }



}
