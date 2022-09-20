package com.chuwa.springboottesting.service.impl;

import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.util.DateUtil;
import com.chuwa.springboottesting.util.EmployeeUtil;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.List;

/**
 * @author b1go
 * @date 7/13/22 4:16 PM
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({EmployeeUtil.class })
class CommonServiceImplTest {

    @Test
    void getEmailEmployees() {
        // 已经创建好 mock 对象。
        PowerMockito.mockStatic(EmployeeUtil.class);
        // non-void method, just define the behavior for that method
        PowerMockito.when(EmployeeUtil.initEmployees(ArgumentMatchers.anyInt())).thenReturn(null);
        // void method, we need set doNothign for that class, then specify do nothing for which method
        PowerMockito.doNothing().when(EmployeeUtil.class);
        EmployeeUtil.deleteEmployees();

        CommonServiceImpl commonService = new CommonServiceImpl();
        List<Employee> emailEmployees = commonService.getEmailEmployees("@gmail.com");
        Assertions.assertThat(emailEmployees).isNull();
//        Whitebox.setInternalState(EmployeeUtil.class, "employees", BDDMockito.mock(List.class));

    }
}