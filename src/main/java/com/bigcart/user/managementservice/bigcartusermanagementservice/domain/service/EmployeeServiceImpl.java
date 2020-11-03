package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Status;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Vendor;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository.EmployeeRepository;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.util.Email;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.util.ServiceConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.lang.reflect.*;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    ServiceConsumer serviceConsumer;

    @Override
    public List<Employee> getAll(){
        List<Employee> list = new ArrayList<>();
        employeeRepository.findAllByStatus(Status.Approved).forEach(list::add);
        return  list;

    }

    @Override
    public Employee getById(long id)
    {
        Optional<Employee> temp = employeeRepository.findById(id);
        return temp.orElse(null);
    }

    @Override
    public Employee add(Employee employee) {
        employee.setUserName(employee.getUserName().toLowerCase());
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
        employee.setCreationDateTime(new Date());
        return employeeRepository.save(employee);
    }

    @Override
    public Employee update(long id, Employee newEmployee) throws IllegalAccessException {

        Employee oldEmployee = getById(id);

        for(Field field : Employee.class.getFields())
        {
            if(!field.get(oldEmployee).equals(field.get(newEmployee)))
                field.set(oldEmployee, field.get(newEmployee));
        }

        return employeeRepository.save(oldEmployee);
    }

    @Override
    public boolean deleteById(long id)
    {
        if(getById(id) == null)
            return false;
        employeeRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateStatus(long id, boolean status) {
        return employeeRepository.updateStatusById(id, status? Status.Approved : Status.Decline)>0;
    }

    @Override
    public Employee login(String userName, String password) {
        Employee emp = employeeRepository.findByUserName(userName.toLowerCase());
        if(emp == null)
            return null;
        if(passwordEncoder.matches(password, emp.getPassword()))
            return emp;
        return null;
    }

    @Override
    public List<Employee> searchByName(String name) {
        List<Employee> list = new ArrayList<>();
        employeeRepository.findByName(name).forEach(list::add);
        return list;
    }

    @Override
    public void notifyAdmins(String subject, String body) {
        employeeRepository.findAllAdmins().forEach(x -> {
            try {
                serviceConsumer.sendNotification(new Email(x.getUserName(), subject, body, x.getEmail()));
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        });
    }
}
