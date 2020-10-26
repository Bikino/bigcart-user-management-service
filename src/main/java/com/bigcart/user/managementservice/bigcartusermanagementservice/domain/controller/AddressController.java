package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Address;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    AddressService AddressService;

    @GetMapping
    public ResponseEntity<List<Address>> getAddresss() {
        HttpHeaders headers = new HttpHeaders();
        List<Address> Addresss = AddressService.getAll();
        if (Addresss == null) {
            return new ResponseEntity<List<Address>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Address>>(Addresss, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Address> getAddress(@PathVariable int id) {

        Address Address = AddressService.getById(id);
        if (Address == null) {

            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Address>(Address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Address> addAddress(@RequestBody Address address) {

        HttpHeaders headers = new HttpHeaders();

        if (address == null) {
            return new ResponseEntity<Address>(HttpStatus.BAD_REQUEST);
        }
        AddressService.add(address);

        return new ResponseEntity<Address>(address, headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Address> editAddress(@PathVariable int id, @RequestBody Address address) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Address oldAddress = AddressService.getById(id);

        if (oldAddress == null) {

            return new ResponseEntity<Address>(HttpStatus.NOT_FOUND);
        }

        Address updatedAddress = AddressService.update(id, address);

        return new ResponseEntity<Address>(updatedAddress, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteAddress(@PathVariable int id) {

       return new ResponseEntity( AddressService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
