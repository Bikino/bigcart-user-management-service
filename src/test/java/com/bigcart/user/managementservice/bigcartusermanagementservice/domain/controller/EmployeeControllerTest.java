package com.bigcart.user.managementservice.bigcartusermanagementservice.domain.controller;

import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.dto.LoginDTO;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.model.Employee;
import com.bigcart.user.managementservice.bigcartusermanagementservice.domain.service.EmployeeService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

@SpringBootTest
class EmployeeControllerTest {

    @Mock
    EmployeeService employeeService;
    @InjectMocks
    EmployeeController employeeController;

    @Test
    void getEmployees() throws URISyntaxException {
        Employee employee = new Employee();
        List<Employee> employees= new ArrayList<>();
        employees.add(employee);
        when(employeeService.getAll()).thenReturn(employees);
        employeeController.getEmployees();
        Mockito.verify(employeeService, times(1)).getAll();
    }

    @Test
    void getEmployee() {
        Employee employee = new Employee();
        when(employeeService.getById(1l)).thenReturn(employee);
        employeeController.getEmployee(1l);
        Mockito.verify(employeeService, times(1)).getById(1l);
    }

    @Test
    void searchByName() {
        Employee employee = new Employee();
        List<Employee> employees= new ArrayList<>();
        employees.add(employee);
        when(employeeService.searchByName("amz")).thenReturn(employees);
        employeeController.searchByName("amz");
        Mockito.verify(employeeService, times(1)).searchByName("amz");
    }

    @Test
    void login()
    {
        Employee employee = new Employee();
        LoginDTO loginDTO = new LoginDTO("amz", "123456");
        when(employeeService.login(loginDTO.getUserName(), loginDTO.getPassword())).thenReturn(employee);
        employeeController.login(loginDTO);
        Mockito.verify(employeeService, times(1)).login(loginDTO.getUserName(),loginDTO.getPassword());
    }
}