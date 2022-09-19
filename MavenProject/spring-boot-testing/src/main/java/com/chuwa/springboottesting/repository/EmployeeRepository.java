package com.chuwa.springboottesting.repository;

import com.chuwa.springboottesting.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByEmail(String email);

    /**
     * define custom query using JPQL with index params
     */
    @Query("select e from Employee e where e.firstName = ?1 and e.lastName = ?2")
    Employee findByJPQL(String firstName, String lastName);

    /**
     * define custom query using JPQL with named params
     * @param firstName
     * @param lastName
     * @return
     */
    @Query("select e from Employee e where e.firstName =:firstName and e.lastName =:lastName")
    Employee findByJPQLNamedParams(@Param("firstName") String firstName, @Param("lastName") String lastName);

    /**
     * @param firstName
     * @param lastName
     * @return
     * define custom query using Native SQL with index params
     */
    @Query(value = "select * from employees e where e.first_name =?1 and e.last_name =?2", nativeQuery = true)
    Employee findByNativeSQL(String firstName, String lastName);

    /**
     * define custom query using Native SQL with named params
     * @param firstName
     * @param lastName
     * @return
     */
    @Query(value = "select * from employees e where e.first_name =:firstName and e.last_name =:lastName",
            nativeQuery = true)
    Employee findByNativeSQLNamed(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
