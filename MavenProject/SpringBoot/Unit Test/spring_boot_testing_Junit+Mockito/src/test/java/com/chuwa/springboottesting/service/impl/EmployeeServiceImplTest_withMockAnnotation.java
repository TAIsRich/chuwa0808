package com.chuwa.springboottesting.service.impl;

import com.chuwa.springboottesting.exception.ResourceNotFoundException;
import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.repository.EmployeeRepository;
import com.chuwa.springboottesting.service.EmployeeService;
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


/**
 * @author b1go
 * @date 7/10/22 6:51 PM
 */

@ExtendWith(MockitoExtension.class)
public class EmployeeServiceImplTest_withMockAnnotation {

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImplTest_withMockAnnotation.class);

    @Mock
    private EmployeeRepository employeeRepository;

    // 这里必须提供实现类，不能提供interface
    @InjectMocks
    private EmployeeServiceImpl employeeService;

    private Employee employee;

    @BeforeEach
    void setUp() {
        logger.info("set up employee for each test");

        // 这里为什么不放到before All里？
        employee = Employee.builder()
                .id(1L)
                .firstName("chuwa")
                .lastName("america")
                .email("chuwa@gmail.com")
                .build();
    }

    @BeforeAll
    static void beforeAll() {
        logger.info("START test");
    }

    /**
     * JUnit test for saveEmployee
     */
    @Test
    public void testSaveEmployee() {

        //given - precondition or setup
        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.empty());
        given(employeeRepository.save(employee))
                .willReturn(employee);

        System.out.println(employeeRepository);
        System.out.println(employeeService);

        // when - action or the behaviour that we are going test
        Employee savedEmployee = employeeService.saveEmployee(employee);

        System.out.println(savedEmployee);

        // then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }

    /**
     * JUnit test for saveEmployee throws exception
     */
    @Test
    public void testSaveEmployee_ThrowException() {

        //given - precondition or setup
        given(employeeRepository.findByEmail(employee.getEmail()))
                .willReturn(Optional.of(employee));

        // when - action or the behaviour that we are going test
        org.junit.jupiter.api.Assertions.assertThrows(ResourceNotFoundException.class, () -> {
            employeeService.saveEmployee(employee);
        });

        // then - verify the output
        verify(employeeRepository, never()).save(any(Employee.class));
    }

    @Test
    public void testGetAllEmployees() {

        //given - precondition or setup
        Employee employee1 = Employee.builder()
                .id(2L)
                .firstName("John")
                .lastName("Snow")
                .email("KnowNothing@gmail.com")
                .build();

        given(employeeRepository.findAll()).willReturn(List.of(employee, employee1));

        // when - action or the behaviour that we are going test
        List<Employee> employees = employeeService.getAllEmployees();

        // then - verify the output
        Assertions.assertThat(employees).isNotNull();
        Assertions.assertThat(employees.size()).isEqualTo(2);
    }

    /**
     *
     */
    @Test
    public void testGetAllEmployees_Negative_emptyEmployees() {

        //given - precondition or setup
        given(employeeRepository.findAll()).willReturn(Collections.emptyList());

        // when - action or the behaviour that we are going test
        List<Employee> employees = employeeService.getAllEmployees();

        // then - verify the output
        Assertions.assertThat(employees).isEmpty();
        Assertions.assertThat(employees.size()).isEqualTo(0);
    }

    @Test
    public void testFindByEmployeeId() {
        //given - precondition or setup
        given(employeeRepository.findById(anyLong())).willReturn(Optional.of(employee));

        // when - action or the behaviour that we are going test
        Employee savedEmployee = employeeService.getEmployeeById(this.employee.getId()).get();

        // then - verify the output
        Assertions.assertThat(savedEmployee).isNotNull();
    }

    @Test
    public void testUpdateEmployee() {

        //given - precondition or setup
        String email = "John.Snow@gmail.com";
        String fName = "Ygritte";
        given(employeeRepository.save(employee)).willReturn(employee);
        employee.setEmail(email);
        employee.setFirstName(fName);

        // when - action or the behaviour that we are going test
        Employee updatedEmployee = employeeService.updateEmployee(employee);

        // then - verify the output
        Assertions.assertThat(updatedEmployee.getEmail()).isEqualTo(email);
        Assertions.assertThat(updatedEmployee.getFirstName()).isEqualTo(fName);
    }

    /**
     * void method is different with non-void method
     */
    @Test
    public void testDeleteEmployee() {
        long id = 1L;

        //given - precondition or setup
        willDoNothing().given(employeeRepository).deleteById(anyLong());

        // when - action or the behaviour that we are going test
        employeeService.deleteEmployee(id);

        // then - verify the output
        verify(employeeRepository, times(1)).deleteById(id);
    }
}