package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.repository;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Status;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface EmployeeRepository extends PersonBaseRepository<Employee>, QueryByExampleExecutor<Employee> {

    public default Employee findByUserName(String userName){
        Employee employee = new Employee();
        employee.setUserName(userName);
        Example<Employee> employeeExample = Example.of(employee);
        return this.findOne(employeeExample).get();
    }
}
