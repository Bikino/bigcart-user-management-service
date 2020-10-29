package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getById(long id);

    Employee add(Employee employee);

    Employee update(long id, Employee newEmployee) throws IllegalAccessException;

    boolean deleteById(long id);

    Employee login(String userName, String password);
}
