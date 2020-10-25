package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    VendorService vendorService;

    @GetMapping(value = "/")
    public ResponseEntity<List<Vendor>> getVendors() {
        HttpHeaders headers = new HttpHeaders();
        List<Vendor> Vendors = vendorService.getAll();
        if (Vendors == null) {
            return new ResponseEntity<List<Vendor>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Vendor>>(Vendors, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vendor> getVendor(@PathVariable int id) {

        Vendor Vendor = vendorService.getById(id);
        if (Vendor == null) {

            return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Vendor>(Vendor, HttpStatus.OK);
    }

    @PostMapping(value = "/")
    public ResponseEntity<Vendor> addVendor(@RequestBody Vendor vendor) {

        HttpHeaders headers = new HttpHeaders();

        if (vendor == null) {
            return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
        }
        vendorService.add(vendor);

        return new ResponseEntity<Vendor>(vendor, headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Vendor> editVendor(@PathVariable int id, @RequestBody Vendor vendor) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Vendor oldVendor = vendorService.getById(id);

        if (oldVendor == null) {

            return new ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
        }

        Vendor updatedVendor = vendorService.update(id, vendor);

        return new ResponseEntity<Vendor>(updatedVendor, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteVendor(@PathVariable int id) {

       return new ResponseEntity( vendorService.deleteById(id)? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
