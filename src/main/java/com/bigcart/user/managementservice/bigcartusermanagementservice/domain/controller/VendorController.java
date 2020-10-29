package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.dto.VendorDTO;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.VendorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/vendor")
public class VendorController {
    @Autowired
    VendorService vendorService;



    ModelMapper modelMapper = new ModelMapper();
    @GetMapping
    public ResponseEntity<List<VendorDTO>> getVendors() {
        HttpHeaders headers = new HttpHeaders();
        List<Vendor> vendors = vendorService.getAll();
        if (vendors == null) {
            return new ResponseEntity<List<VendorDTO>>(HttpStatus.NOT_FOUND);
        }
        List<VendorDTO> res = new ArrayList<>();
        vendors.forEach(x-> res.add(modelMapper.map(x, VendorDTO.class)));
        return new ResponseEntity<List<VendorDTO>>(res, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<VendorDTO> getVendor(@PathVariable long id) {

        Vendor vendor = vendorService.getById(id);
        if (vendor == null) {

            return new ResponseEntity<VendorDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<VendorDTO>(modelMapper.map(vendor, VendorDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VendorDTO> addVendor(@RequestBody Vendor vendor) {

        HttpHeaders headers = new HttpHeaders();

        if (vendor == null) {
            return new ResponseEntity<VendorDTO>(HttpStatus.BAD_REQUEST);
        }
        vendorService.add(vendor);

        return new ResponseEntity<VendorDTO>(modelMapper.map(vendor, VendorDTO.class), headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<VendorDTO> editVendor(@PathVariable long id, @RequestBody VendorDTO vendorDTO) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Vendor oldVendor = vendorService.getById(id);

        if (oldVendor == null) {

            return new ResponseEntity<VendorDTO>(HttpStatus.NOT_FOUND);
        }

        Vendor updatedVendor = vendorService.update(id, modelMapper.map(vendorDTO, Vendor.class));

        return new ResponseEntity<VendorDTO>(modelMapper.map(updatedVendor, VendorDTO.class), headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteVendor(@PathVariable long id) {

       return new ResponseEntity( vendorService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
