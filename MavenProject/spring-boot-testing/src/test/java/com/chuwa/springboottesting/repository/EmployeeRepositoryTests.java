package com.chuwa.springboottesting.repository;

import com.chuwa.springboottesting.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    private Employee employee;

    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .firstName("chuwa")
                .lastName("America")
                .email("chuwa@gmail,com")
                .build();
    }

    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

        Employee savedEmployee = employeeRepository.save(employee);

        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }

    @Test
    public void testFindAll(){
        Employee employee1 = Employee.builder()
                .firstName("icc")
                .lastName("llc")
                .email("icc@gmail,com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        List<Employee> employeeList = employeeRepository.findAll();

        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    @DisplayName("get employee by id operation")
    @Test
    public void testFindById(){
        employeeRepository.save(employee);

        Employee employeeDB = employeeRepository.findById(employee.getId()).get();

        assertThat(employeeDB).isNotNull();
    }

    @DisplayName("get employee by email operation")
    @Test
    public void testFindByEmail(){
        employeeRepository.save(employee);
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();
        assertThat(employeeDB).isNotNull();
    }

    @DisplayName("update employee operation")
    @Test
    public void testUpdateEmployee(){
        employeeRepository.save(employee);
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("Richard@gmail.com");
        savedEmployee.setFirstName("Richard");
        Employee updatedEmployee =  employeeRepository.save(savedEmployee);

        assertThat(updatedEmployee.getEmail()).isEqualTo("Richard@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Richard");
    }

    /**
     * JUnit test for delete employee operation
     */
    @DisplayName("delete employee operation")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee(){
        employeeRepository.save(employee);

        employeeRepository.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        assertThat(employeeOptional).isEmpty();
    }

    @DisplayName("custom query using JPQL with index")
    @Test
    public void testFindByJPQL(){
        employeeRepository.save(employee);
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();

        Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);

        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("custom query using JPQL with Named params")
    @Test
    public void testFindByJPQLNamedParams(){
        employeeRepository.save(employee);
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();
        Employee savedEmployee = employeeRepository.findByJPQLNamedParams(firstName, lastName);

        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("JUnit test for custom query using native SQL with index")
    @Test
    public void testFindByNativeSQL(){
        employeeRepository.save(employee);

        Employee savedEmployee = employeeRepository.findByNativeSQL(employee.getFirstName(), employee.getLastName());

        assertThat(savedEmployee).isNotNull();
    }

    @DisplayName("custom query using native SQL with named params")
    @Test
    public void testFindByNativeSQLNamed(){
        employeeRepository.save(employee);

        Employee savedEmployee = employeeRepository.findByNativeSQLNamed(employee.getFirstName(), employee.getLastName());

        assertThat(savedEmployee).isNotNull();
    }
}
