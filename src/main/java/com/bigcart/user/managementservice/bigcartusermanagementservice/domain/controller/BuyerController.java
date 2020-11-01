package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.dto.BuyerDTO;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.dto.EmployeeDTO;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Buyer;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.BuyerService;
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
@RequestMapping("/buyer")
public class BuyerController {
    @Autowired
    BuyerService buyerService;

    ModelMapper modelMapper = new ModelMapper();
    @GetMapping
    public ResponseEntity<List<BuyerDTO>> getBuyers() {
        HttpHeaders headers = new HttpHeaders();
        List<Buyer> buyers = buyerService.getAll();
        if (buyers == null) {
            return new ResponseEntity<List<BuyerDTO>>(HttpStatus.NOT_FOUND);
        }
        List<BuyerDTO> res = new ArrayList<>();
        buyers.forEach(x-> res.add(modelMapper.map(x, BuyerDTO.class)));
        return new ResponseEntity<List<BuyerDTO>>(res, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<BuyerDTO> getBuyer(@PathVariable long id) {

        Buyer buyer = buyerService.getById(id);
        if (buyer == null) {

            return new ResponseEntity<BuyerDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<BuyerDTO>(modelMapper.map(buyer, BuyerDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BuyerDTO> addBuyer(@RequestBody Buyer buyer) {

        HttpHeaders headers = new HttpHeaders();

        if (buyer == null) {
            return new ResponseEntity<BuyerDTO>(HttpStatus.BAD_REQUEST);
        }

        buyerService.add(buyer);

        return new ResponseEntity<BuyerDTO>(modelMapper.map(buyer, BuyerDTO.class), headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<BuyerDTO> editBuyer(@PathVariable long id, @RequestBody BuyerDTO buyerDTO) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Buyer oldBuyer = buyerService.getById(id);

        if (oldBuyer == null) {

            return new ResponseEntity<BuyerDTO>(HttpStatus.NOT_FOUND);
        }

        Buyer updatedBuyer = buyerService.update(id, modelMapper.map(buyerDTO, Buyer.class));

        return new ResponseEntity<BuyerDTO>(modelMapper.map(updatedBuyer, BuyerDTO.class), headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteBuyer(@PathVariable long id) {

       return new ResponseEntity( buyerService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<BuyerDTO> login(@RequestParam(required = true) String userName, @RequestParam(required = true) String password)
    {
        Buyer emp = buyerService.login(userName.toLowerCase(), password);
        if(emp == null)
            return new ResponseEntity<BuyerDTO>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<BuyerDTO>(modelMapper.map(emp, BuyerDTO.class), HttpStatus.OK);

    }
}
