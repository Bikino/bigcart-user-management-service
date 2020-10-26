package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.BuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Buyer>> getBuyers() {
        HttpHeaders headers = new HttpHeaders();
        List<Buyer> Buyers = buyerService.getAll();
        if (Buyers == null) {
            return new ResponseEntity<List<Buyer>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Buyer>>(Buyers, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Buyer> getBuyer(@PathVariable int id) {

        Buyer Buyer = buyerService.getById(id);
        if (Buyer == null) {

            return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Buyer>(Buyer, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Buyer> addBuyer(@RequestBody Buyer buyer) {

        HttpHeaders headers = new HttpHeaders();

        if (buyer == null) {
            return new ResponseEntity<Buyer>(HttpStatus.BAD_REQUEST);
        }
        buyer.setPassword(passwordEncoder.encode(buyer.getPassword()));
        buyerService.add(buyer);

        return new ResponseEntity<Buyer>(buyer, headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Buyer> editBuyer(@PathVariable int id, @RequestBody Buyer buyer) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Buyer oldBuyer = buyerService.getById(id);

        if (oldBuyer == null) {

            return new ResponseEntity<Buyer>(HttpStatus.NOT_FOUND);
        }

        Buyer updatedBuyer = buyerService.update(id, buyer);

        return new ResponseEntity<Buyer>(updatedBuyer, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteBuyer(@PathVariable int id) {

       return new ResponseEntity( buyerService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
