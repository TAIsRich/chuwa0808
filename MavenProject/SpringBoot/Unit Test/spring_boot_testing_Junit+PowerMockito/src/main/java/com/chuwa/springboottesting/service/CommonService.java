package com.chuwa.springboottesting.service;

import com.chuwa.springboottesting.model.Employee;

import java.util.List;

/**
 * @author b1go
 * @date 7/12/22 11:53 PM
 */
public interface CommonService {
    List<Employee> getEmailEmployees(String emailDomain);
}
