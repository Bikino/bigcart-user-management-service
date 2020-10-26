package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees() {
        HttpHeaders headers = new HttpHeaders();
        List<Employee> employees = employeeService.getAll();

        if (employees == null) {
            return new ResponseEntity<List<Employee>>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<List<Employee>>(employees, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {

        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {

        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<Employee>(HttpStatus.BAD_REQUEST);
        }
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employeeService.add(employee);

        return new ResponseEntity<Employee>(employee, headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Employee> editEmployee(@PathVariable int id, @RequestBody Employee employee) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Employee oldEmployee = employeeService.getById(id);

        if (oldEmployee == null) {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        Employee updatedEmployee = employeeService.update(id, employee);

        return new ResponseEntity<Employee>(updatedEmployee, headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEmployee(@PathVariable int id) {

       return new ResponseEntity( employeeService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
}
