package com.chuwa.tutorialtesting.service;

import com.chuwa.tutorialtesting.model.Employee;

import java.util.List;
import java.util.Optional;

/**
 * @author b1go
 * @date 7/10/22 6:44 PM
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(long id);
    Employee updateEmployee(Employee updatedEmployee);
    void deleteEmployee(long id);
}