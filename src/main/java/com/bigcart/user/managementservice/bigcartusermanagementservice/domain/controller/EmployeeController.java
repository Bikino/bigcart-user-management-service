package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;


import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.dto.EmployeeDTO;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    ModelMapper modelMapper = new ModelMapper();
    @GetMapping
    public ResponseEntity<List<EmployeeDTO>> getEmployees() {
        HttpHeaders headers = new HttpHeaders();
        List<Employee> employees = employeeService.getAll();

        if (employees == null) {

            return new ResponseEntity<List<EmployeeDTO>>(HttpStatus.NOT_FOUND);
        }
        List<EmployeeDTO> res = new ArrayList<>();
        employees.forEach(x-> res.add(modelMapper.map(x, EmployeeDTO.class)));
        return new ResponseEntity<List<EmployeeDTO>>(res, headers, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> getEmployee(@PathVariable long id) {

        Employee employee = employeeService.getById(id);
        if (employee == null) {
            return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<EmployeeDTO>(modelMapper.map(employee, EmployeeDTO.class), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody Employee employee) {

        HttpHeaders headers = new HttpHeaders();

        if (employee == null) {
            return new ResponseEntity<EmployeeDTO>(HttpStatus.BAD_REQUEST);
        }

        employeeService.add(employee);

        return new ResponseEntity<EmployeeDTO>(modelMapper.map(employee, EmployeeDTO.class), headers, HttpStatus.CREATED);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<EmployeeDTO> editEmployee(@PathVariable long id, @RequestBody EmployeeDTO employeeDTO) throws IllegalAccessException {

        HttpHeaders headers = new HttpHeaders();
        Employee oldEmployee = employeeService.getById(id);

        if (oldEmployee == null) {
            return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
        }

        Employee updatedEmployee = employeeService.update(id, modelMapper.map(employeeDTO, Employee.class));

        return new ResponseEntity<EmployeeDTO>(modelMapper.map(updatedEmployee, EmployeeDTO.class), headers, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteEmployee(@PathVariable long id) {

       return new ResponseEntity( employeeService.deleteById(id)? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/login")
    public ResponseEntity<EmployeeDTO> login(@PathVariable String userName, @PathVariable String password)
    {
        Employee emp = employeeService.login(userName.toLowerCase(), password);
        if(emp == null)
            return new ResponseEntity<EmployeeDTO>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<EmployeeDTO>(modelMapper.map(emp, EmployeeDTO.class), HttpStatus.OK);

    }
}
