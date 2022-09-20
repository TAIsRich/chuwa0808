package com.chuwa.springboottesting.service.impl;

import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.repository.EmployeeRepository;
import com.chuwa.springboottesting.service.CommonService;
import com.chuwa.springboottesting.util.EmployeeUtil;
import com.chuwa.springboottesting.util.BeanUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author b1go
 * @date 7/12/22 11:57 PM
 */
@Service
public class CommonServiceImpl implements CommonService {


    @Override
    public List<Employee> getEmailEmployees(String emailDomain) {
        EmployeeUtil.initEmployees(10);

        EmployeeRepository bean = BeanUtil.getBean(EmployeeRepository.class);
        List<Employee> employees = bean.findByEmailEndingWith(emailDomain);

        EmployeeUtil.deleteEmployees();



        return employees;
    }
}
