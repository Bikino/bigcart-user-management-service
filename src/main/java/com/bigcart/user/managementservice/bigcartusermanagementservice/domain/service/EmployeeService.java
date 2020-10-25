package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(int id);

    Employee add(Employee employee);

    Employee update(int id, Employee newEmployee) throws IllegalAccessException;

    boolean deleteById(int id);
}
