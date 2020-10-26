package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Guest;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guest")
public class GuestController {
    @Autowired
    GuestService guestService;

    @GetMapping
    public ResponseEntity<List<Guest>> getGuests() {
        HttpHeaders headers = new HttpHeaders();
        List<Guest> Guests = guestService.getAll();
        if (Guests == null) {
            return new ResponseEntity<List<Guest>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Guest>>(Guests, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Guest> getGuest(@PathVariable int id) {

        Guest Guest = guestService.getById(id);
        if (Guest == null) {

            return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Guest>(Guest, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Guest> addGuest(@RequestBody Guest guest) {

        HttpHeaders headers = new HttpHeaders();

        if (guest == null) {
            return new ResponseEntity<Guest>(HttpStatus.BAD_REQUEST);
        }
        guestService.add(guest);

        return new ResponseEntity<Guest>(guest, headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Guest> editGuest(@PathVariable int id, @RequestBody Guest guest) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Guest oldGuest = guestService.getById(id);

        if (oldGuest == null) {

            return new ResponseEntity<Guest>(HttpStatus.NOT_FOUND);
        }

        Guest updatedGuest = guestService.update(id, guest);

        return new ResponseEntity<Guest>(updatedGuest, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteGuest(@PathVariable int id) {

       return new ResponseEntity( guestService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
