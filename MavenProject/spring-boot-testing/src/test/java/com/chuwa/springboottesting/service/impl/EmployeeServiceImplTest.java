package com.chuwa.springboottesting.service.impl;

import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.Optional;

public class EmployeeServiceImplTest {

    private EmployeeRepository employeeRepository;
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    @Test
    public void testSaveEmployee() {
        Employee employee = Employee.builder()
                .id(1l)
                .firstName("chuwa")
                .lastName("america")
                .email("chuwa@gmail.com")
                .build();
        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail())).willReturn(Optional.empty());
        BDDMockito.given(employeeRepository.save(employee)).willReturn(employee);

        Employee saveEmployee = employeeService.saveEmployee(employee);
        Assertions.assertThat(saveEmployee).isNotNull().isEqualTo(employee);
    }
}