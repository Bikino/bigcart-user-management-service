package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.VendorService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class VendorControllerTest {

    @Mock
    VendorService vendorService;
    @InjectMocks
    VendorController vendorController;

    @Test
    void getVendors() {
        Vendor vendor = new Vendor();
        List<Vendor> vendors= new ArrayList<>();
        vendors.add(vendor);
        when(vendorService.getAll()).thenReturn(vendors);
        vendorController.getVendors();
        Mockito.verify(vendorService, times(1)).getAll();
    }

    @Test
    void getPendingVendors() {
        Vendor vendor = new Vendor();
        List<Vendor> vendors= new ArrayList<>();
        vendors.add(vendor);
        when(vendorService.getAllPending()).thenReturn(vendors);
        vendorController.getVendors();
        Mockito.verify(vendorService, times(1)).getAllPending();
    }

    @Test
    void getVendor() {
        Vendor vendor = new Vendor();
        when(vendorService.getById(1)).thenReturn(vendor);
        vendorController.getVendor(1);
        Mockito.verify(vendorService, times(1)).getById(1);
    }

    @Test
    void login() {
    }

    @Test
    void searchByName() {
        Vendor vendor = new Vendor();
        List<Vendor> vendors= new ArrayList<>();
        vendors.add(vendor);
        when(vendorService.searchByName("amz")).thenReturn(vendors);
        vendorController.searchByName("amz");
        Mockito.verify(vendorService, times(1)).searchByName("amz");
    }
}