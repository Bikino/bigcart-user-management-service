package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.BuyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BuyerServiceImpl implements BuyerService{

    @Autowired
    private BuyerRepository buyerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Buyer> getAll(){

        List<Buyer> list = new ArrayList<>();
        buyerRepository.findAll().forEach(list::add);
        return  list;

    }

    @Override
    public Buyer getById(long id)
    {
        Optional<Buyer> temp = buyerRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Buyer add(Buyer buyer) {
        buyer.setUserName(buyer.getUserName().toLowerCase());
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));
        return buyerRepository.save(buyer);
    }

    @Override
    public Buyer update(long id, Buyer newBuyer) throws IllegalAccessException {

        Buyer oldBuyer = getById(id);

        for(Field field : Buyer.class.getFields())
        {
            if(!field.get(oldBuyer).equals(field.get(newBuyer)))
                field.set(oldBuyer, field.get(newBuyer));
        }

        return buyerRepository.save(oldBuyer);
    }

    @Override
    public boolean deleteById(long id)
    {
        if(getById(id) == null)
            return false;
        buyerRepository.deleteById(id);
        return true;
    }

    @Override
    public Buyer login(String userName, String password) {
        Buyer buyer = buyerRepository.findByUserName(userName.toLowerCase());
        if(buyer == null)
            return null;
        if(passwordEncoder.matches(password, buyer.getPassword()))
            return buyer;
        return null;
    }


}
