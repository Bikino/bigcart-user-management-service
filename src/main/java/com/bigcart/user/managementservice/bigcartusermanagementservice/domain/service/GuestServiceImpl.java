package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Guest;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GuestServiceImpl implements GuestService{

    @Autowired
    private GuestRepository guestRepository;

    @Override
    public List<Guest> getAll(){

        List<Guest> list = new ArrayList<>();
        guestRepository.findAll().forEach(list::add);
        return  list;

    }

    @Override
    public Guest getById(long id)
    {
        Optional<Guest> temp = guestRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Guest add(Guest Guest) {
        return guestRepository.save(Guest);
    }

    @Override
    public Guest update(long id, Guest newGuest) throws IllegalAccessException {

        Guest oldGuest = getById(id);

        for(Field field : Guest.class.getFields())
        {
            if(!field.get(oldGuest).equals(field.get(newGuest)))
                field.set(oldGuest, field.get(newGuest));
        }

        return guestRepository.save(oldGuest);
    }

    @Override
    public boolean deleteById(long id)
    {
        if(getById(id) == null)
            return false;
        guestRepository.deleteById(id);
        return true;
    }



}
