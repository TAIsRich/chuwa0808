package com.chuwa.springboottesting.service.impl;

import com.chuwa.springboottesting.exception.ResourceNotFoundException;
import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest_withMockAnnotation {
    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest.class);

    @Mock
    EmployeeRepository employeeRepository;

    @InjectMocks
    EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        logger.info("set up employee for each test");
        employee = Employee.builder()
                .id(1L)
                .firstName("chuwa")
                .lastName("america")
                .email("chuwa@gmail.com")
                .build();
    }

    @BeforeAll
    static void beforeAll() {
        logger.info("Start test");
    }

    @Test
    public void testSaveEmployee() {
        given(employeeRepository.findByEmail(anyString())).willReturn(Optional.empty());
        given(employeeRepository.save(any(Employee.class))).willReturn(employee);
        Employee saveEmployee = employeeService.saveEmployee(employee);
        Assertions.assertThat(saveEmployee.getFirstName()).isEqualTo(employee.getFirstName());
        Assertions.assertThat(saveEmployee.getLastName()).isEqualTo(employee.getLastName());
        Assertions.assertThat(saveEmployee.getEmail()).isEqualTo(employee.getEmail());
    }

    @Test
    public void testSaveEmployee_ThrowException() {
        given(employeeRepository.findByEmail(anyString())).willReturn(Optional.of(employee));
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.saveEmployee(employee);
        });
    }

    @Test
    public void testGetAllEmployees() {
        Employee employee1 = Employee.builder()
                .id(2l)
                .lastName("hello")
                .firstName("hi")
                .email("thiz@gmail.com")
                .build();
        given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));
        List<Employee> employees = employeeService.getAllEmployees();
        Assertions.assertThat(employees).isNotNull();
        Assertions.assertThat(employees).size().isEqualTo(2);
    }

    @Test
    public void testGetAllEmployees_Negative_emptyEmployees() {
        given(employeeRepository.findAll()).willReturn(Collections.emptyList());
        List<Employee> employees = employeeService.getAllEmployees();
        Assertions.assertThat(employees).isNotNull();
        Assertions.assertThat(employees).size().isEqualTo(0);
    }

    @Test
    public void testFindByEmployeeId() {
        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));
        Optional<Employee> responseEmployee = employeeService.getEmployeeById(1);
        Assertions.assertThat(responseEmployee.get().getEmail()).isEqualTo(employee.getEmail());
        Assertions.assertThat(responseEmployee.get().getFirstName()).isEqualTo(employee.getFirstName());
        Assertions.assertThat(responseEmployee.get().getLastName()).isEqualTo(employee.getLastName());
    }

    @Test
    public void testUpdateEmployee() {
        given(employeeRepository.save(any(Employee.class))).willReturn(employee);
        Employee saveEmployee = employeeService.saveEmployee(employee);

        Assertions.assertThat(saveEmployee.getEmail()).isEqualTo(employee.getEmail());
        Assertions.assertThat(saveEmployee.getFirstName()).isEqualTo(employee.getFirstName());
        Assertions.assertThat(saveEmployee.getLastName()).isEqualTo(employee.getLastName());
    }

    @Test
    public void testDeleteEmployee() {
        willDoNothing().given(employeeRepository).deleteById(anyLong());
        employeeService.deleteEmployee(1);
        verify(employeeRepository, times(1)).deleteById(1l);
    }
}