package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.lang.reflect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAll(){

        List<Employee> list = new ArrayList<>();
        employeeRepository.findAll().forEach(list::add);
        return  list;

    }

    @Override
    public Employee getById(int id)
    {
        Optional<Employee> temp = employeeRepository.findById(id);
        return temp.isPresent()? temp.get() : null;
    }

    @Override
    public Employee add(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(int id, Employee newEmployee) throws IllegalAccessException {

        Employee oldEmployee = getById(id);

        for(Field field : Employee.class.getFields())
        {
            if(!field.get(oldEmployee).equals(field.get(newEmployee)))
                field.set(oldEmployee, field.get(newEmployee));
        }

        return employeeRepository.save(oldEmployee);
    }

    @Override
    public boolean deleteById(int id)
    {
        if(getById(id) == null)
            return false;
        employeeRepository.deleteById(id);
        return true;
    }



}
