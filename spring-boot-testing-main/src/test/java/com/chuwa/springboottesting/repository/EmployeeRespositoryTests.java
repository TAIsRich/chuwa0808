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
public class EmployeeRespositoryTests {

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

    /**
     * JUnit test for save employee operation
     */
    //@DisplayName("JUnit test for save employee operation")
    @Test
    public void givenEmployeeObject_whenSave_thenReturnSavedEmployee() {

        //given - precondition or setup

        // when - action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.save(employee);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
        assertThat(savedEmployee.getId()).isGreaterThan(0);
    }


    /**
     * JUnit test for get all employees operation
     */
//    @DisplayName("JUnit test for get all employees operation")
    @Test
    public void testFindAll(){
        // given - precondition or setup
        Employee employee1 = Employee.builder()
                .firstName("icc")
                .lastName("llc")
                .email("icc@gmail,com")
                .build();

        employeeRepository.save(employee);
        employeeRepository.save(employee1);

        // when -  action or the behaviour that we are going test
        List<Employee> employeeList = employeeRepository.findAll();

        // then - verify the output
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(2);
    }

    /**
     * JUnit test for get employee by id operation
     */
    @DisplayName("get employee by id operation")
    @Test
    public void testFindById(){
        // given - precondition or setup
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee employeeDB = employeeRepository.findById(employee.getId()).get();

        // then - verify the output
        assertThat(employeeDB).isNotNull();
    }

    /**
     * JUnit test for get employee by email operation
     */
    @DisplayName("get employee by email operation")
    @Test
    public void testFindByEmail(){
        // given - precondition or setup
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee employeeDB = employeeRepository.findByEmail(employee.getEmail()).get();

        // then - verify the output
        assertThat(employeeDB).isNotNull();
    }

    /**
     * update employee operation
     */
    @DisplayName("update employee operation")
    @Test
    public void testUpdateEmployee(){
        // given - precondition or setup
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findById(employee.getId()).get();
        savedEmployee.setEmail("Richard@gmail.com");
        savedEmployee.setFirstName("Richard");
        Employee updatedEmployee =  employeeRepository.save(savedEmployee);

        // then - verify the output
        assertThat(updatedEmployee.getEmail()).isEqualTo("Richard@gmail.com");
        assertThat(updatedEmployee.getFirstName()).isEqualTo("Richard");
    }

    /**
     * JUnit test for delete employee operation
     */
    @DisplayName("delete employee operation")
    @Test
    public void givenEmployeeObject_whenDelete_thenRemoveEmployee(){
        // given - precondition or setup
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        employeeRepository.deleteById(employee.getId());
        Optional<Employee> employeeOptional = employeeRepository.findById(employee.getId());

        // then - verify the output
        assertThat(employeeOptional).isEmpty();
    }

    /**
     * JUnit test for custom query using JPQL with index
     */
    @DisplayName("custom query using JPQL with index")
    @Test
    public void testFindByJPQL(){
        // given - precondition or setup
        employeeRepository.save(employee);
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findByJPQL(firstName, lastName);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    /**
     * JUnit test for custom query using JPQL with Named params
     */
    @DisplayName("custom query using JPQL with Named params")
    @Test
    public void testFindByJPQLNamedParams(){
        // given - precondition or setup
        employeeRepository.save(employee);
        String firstName = employee.getFirstName();
        String lastName = employee.getLastName();

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findByJPQLNamedParams(firstName, lastName);

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    /**
     * JUnit test for custom query using native SQL with index
     */
    @DisplayName("JUnit test for custom query using native SQL with index")
    @Test
    public void testFindByNativeSQL(){
        // given - precondition or setup
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findByNativeSQL(employee.getFirstName(), employee.getLastName());

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

    /**
     * JUnit test for custom query using native SQL with named params
     */
    @DisplayName("custom query using native SQL with named params")
    @Test
    public void testFindByNativeSQLNamed(){
        // given - precondition or setup
        employeeRepository.save(employee);

        // when -  action or the behaviour that we are going test
        Employee savedEmployee = employeeRepository.findByNativeSQLNamed(employee.getFirstName(), employee.getLastName());

        // then - verify the output
        assertThat(savedEmployee).isNotNull();
    }

}
