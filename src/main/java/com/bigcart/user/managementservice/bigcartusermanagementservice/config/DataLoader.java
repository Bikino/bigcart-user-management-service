package com.bigcart.user.managementservice.bigcartusermanagementservice.config;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.*;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.BuyerService;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.EmployeeService;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.net.URISyntaxException;

//@Component
public class DataLoader implements ApplicationRunner {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    VendorService vendorService;
    @Autowired
    BuyerService buyerService;
    @Override
    public void run(ApplicationArguments args) throws Exception {

        Vendor vendor1 = new Vendor();
        vendor1.setFirstName("Omar");
        vendor1.setLastName("Abdeltwab");
        vendor1.setUserName("omar");
        vendor1.setPassword("12345");
        vendor1.setEmail("oabdeltwab@miu.edu");
        vendor1.setStatus(Status.Approved);
        vendor1.setBalance(25000.0);

        Vendor vendor2 = new Vendor();
        vendor2.setFirstName("Furkan");
        vendor2.setLastName("Ozbudak");
        vendor2.setUserName("Furk");
        vendor2.setPassword("12345");
        vendor2.setEmail("fozbudak@miu.edu");

        Vendor vendor3 = new Vendor();
        vendor3.setFirstName("Mark");
        vendor3.setLastName("Ghatas");
        vendor3.setUserName("mrk");
        vendor3.setPassword("12345");
        vendor3.setEmail("mghatas@miu.edu");

        try {
            vendorService.add(vendor1);
            vendorService.add(vendor2);
            vendorService.add(vendor3);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }



        Employee employee1 = new Employee();
        employee1.setFirstName("Mohamed");
        employee1.setLastName("Abdelzaher");
        employee1.setUserName("MEssam");
        employee1.setPassword("12345");
        employee1.setEmail("MAbdelzaher@miu.edu");
        employee1.setAdmin(true);
        employee1.setStatus(Status.Approved);
        employee1.setSalary(5000);

        Employee employee2 = new Employee();
        employee2.setFirstName("Youssoupha");
        employee2.setLastName("Mar");
        employee2.setUserName("Youss");
        employee2.setPassword("12345");
        employee2.setEmail("ymar@miu.edu");
        employee2.setSalary(10000);

        try {
            employeeService.add(employee1);
            employeeService.add(employee2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Buyer buyer = new Buyer();
        buyer.setFirstName("Mohamed");
        buyer.setLastName("Farahat");
        buyer.setUserName("MFarahat");
        buyer.setPassword("12345");
        buyer.setEmail("MFarahat@miu.edu");




//        Address address = new Address();
//        address.setAddressLineOne("1000 N 4ht st.");
//        address.setAddressLineTwo("MR 000");
//        address.setCity("Fairfield");
//        address.setState("Iowa");
//        address.setZip(52556);
//        address.setShipping(true);
//
//        Address address1 = new Address();
//        address1.setAddressLineOne("1000 N 4ht st.");
//        address1.setAddressLineTwo("MR 000");
//        address1.setCity("Fairfield");
//        address1.setState("Iowa");
//        address1.setZip(52556);
//        address1.setShipping(true);

        Buyer buyer2 = new Buyer();
        buyer2.setFirstName("Duong");
        buyer2.setLastName("Nguyen");
        buyer2.setUserName("DNguyen");
        buyer2.setPassword("12345");
        buyer2.setEmail("DuongNguyen@miu.edu");

        try {
            buyerService.add(buyer);
            buyerService.add(buyer2);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Guest guest = new Guest();
        guest.setFirstName("Bassem");
        guest.setLastName("Elsawy");
        guest.setEmail("BElsawy@miu.edu");
    }
}
