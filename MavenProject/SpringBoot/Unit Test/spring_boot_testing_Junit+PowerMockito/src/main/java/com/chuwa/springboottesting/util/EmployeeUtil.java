package com.chuwa.springboottesting.util;

import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author b1go
 * @date 7/13/22 12:13 AM
 */
public class EmployeeUtil {


    private static List<Employee> employees = new ArrayList<>();

    public static List<Employee> initEmployees(int num) {
        EmployeeRepository employeeRepository = BeanUtil.getBean("employeeRepository", EmployeeRepository.class);

        for (int i = 0; i < num; i++) {
            String domain = i % 2 == 0 ? "@gmail.com" : "@outlook.com";

            Employee employee = Employee.builder()
                    .firstName("chuwa" + i)
                    .lastName("america" + i)
                    .email("chuwa" + i + domain)
                    .build();

            employees.add(employee);
        }


        List<Employee> savedEmployees = employeeRepository.saveAll(employees);

        return savedEmployees;
    }

    public static void deleteEmployees() {
        EmployeeRepository employeeRepository = BeanUtil.getBean("employeeRepository", EmployeeRepository.class);

        employeeRepository.deleteAll(employees);
    }
}
