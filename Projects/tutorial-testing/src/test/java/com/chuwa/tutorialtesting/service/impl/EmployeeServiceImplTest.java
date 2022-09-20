package com.chuwa.tutorialtesting.service.impl;

import com.chuwa.tutorialtesting.model.Employee;
import com.chuwa.tutorialtesting.repository.EmployeeRepository;
import com.chuwa.tutorialtesting.service.EmployeeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

public class EmployeeServiceImplTest {
    private EmployeeRepository employeeRepository;
    private EmployeeService employeeService;

    @BeforeEach
    void setUp() {
        employeeRepository = Mockito.mock(EmployeeRepository.class);
        employeeService = new EmployeeServiceImpl(employeeRepository);
    }

    /**
     * JUnit test for saveEmployee
     */
    @Test
    public void testSaveEmployee() {

        //given - precondition or setup
        Employee employee = Employee.builder()
                .id(1L)
                .firstName("chuwa")
                .lastName("america")
                .email("chuwa@gmail.com")
                .build();
        BDDMockito.given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());
        BDDMockito.given(employeeRepository.save(employee))
                .willReturn(employee);

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        // when - action or the behaviour that we are going test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        System.out.println(savedEmployee);

        // then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }
}
