package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private BuyerRepository buyerRepository;

    @Override
    public List<Buyer> getAll(){

        List<Buyer> list = new ArrayList<>();
        buyerRepository.findAll().forEach(list::add);
        return  list;

    }

    @Override
    public Buyer getById(int id)
    {
        Optional<Buyer> temp = buyerRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Buyer add(Buyer Buyer) {
        return buyerRepository.save(Buyer);
    }

    @Override
    public Buyer update(int id, Buyer newBuyer) throws IllegalAccessException {

        Buyer oldBuyer = getById(id);

        for(Field field : Buyer.class.getFields())
        {
            if(!field.get(oldBuyer).equals(field.get(newBuyer)))
                field.set(oldBuyer, field.get(newBuyer));
        }

        return buyerRepository.save(oldBuyer);
    }

    @Override
    public boolean deleteById(int id)
    {
        if(getById(id) == null)
            return false;
        buyerRepository.deleteById(id);
        return true;
    }



}
