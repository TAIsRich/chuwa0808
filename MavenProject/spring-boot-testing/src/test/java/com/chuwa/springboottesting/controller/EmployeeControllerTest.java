package com.chuwa.springboottesting.controller;

import com.chuwa.springboottesting.model.Employee;
import com.chuwa.springboottesting.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.CoreMatchers.is;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebMvcTest
public class EmployeeControllerTest {
    @Resource
    private MockMvc mockMvc;

    @MockBean
    private EmployeeService employeeService;

    @Resource
    private ObjectMapper objectMapper;

    private Employee employee;
    @BeforeEach
    void setUp() {
        employee = Employee.builder()
                .firstName("chuwa")
                .lastName("america")
                .email("chuwa@gmail.com")
                .build();
    }

    @Test
    public void testCreateEmployee() throws Exception {
        given(employeeService.saveEmployee(any(Employee.class))).willReturn(employee);
        mockMvc.perform(post("/api/v1/employees")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(employee)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())))
                .andExpect(jsonPath("$.email", is(employee.getEmail())));
    }

    @Test
    public void testGetAllEmployees() throws Exception {
        List<Employee> employees = new ArrayList<>();
        employees.add(employee);
        employees.add(Employee.builder().firstName("chuwa1").lastName("america1").email("chuwa1@gmail.com").build());
        given(employeeService.getAllEmployees()).willReturn(employees);
        mockMvc.perform(get("/api/v1/employees"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(employees.size())));
    }

    @Test
    public void testGetByEmployeeId() throws Exception {
        long employeeId = 1;
        given(employeeService.getEmployeeById(anyLong())).willReturn(Optional.of(employee));
        mockMvc.perform(get("/api/v1/employees/{id}", employeeId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.email", is(employee.getEmail())))
                .andExpect(jsonPath("$.firstName", is(employee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(employee.getLastName())));
    }

    @Test
    public void testInvalidEmployeeId_ReturnEmpty() throws Exception {
        long employeeId = 1;
        given(employeeService.getEmployeeById(anyLong())).willReturn(Optional.empty());
        mockMvc.perform(get("/api/v1/employees/{id}", employeeId))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testUpdatedEmployee() throws Exception {
        long employeeId = 1L;

        Employee updatedEmployee = Employee.builder()
                .firstName("John")
                .lastName("Snow")
                .email("John@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.of(employee));
        given(employeeService.updateEmployee(any(Employee.class)))
                .willAnswer((invocation) -> invocation.getArgument(0));

        mockMvc.perform(put("/api/v1/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)))
                .andExpect(status().isOk())
                .andDo(print())
                .andExpect(jsonPath("$.firstName", is(updatedEmployee.getFirstName())))
                .andExpect(jsonPath("$.lastName", is(updatedEmployee.getLastName())))
                .andExpect(jsonPath("$.email", is(updatedEmployee.getEmail())));
    }

    @Test
    public void testUpdatedEmployee_Return404() throws Exception {
        long employeeId = 1L;

        Employee updatedEmployee = Employee.builder()
                .firstName("John")
                .lastName("Snow")
                .email("John@gmail.com")
                .build();
        given(employeeService.getEmployeeById(employeeId)).willReturn(Optional.empty());
        mockMvc.perform(put("/api/v1/employees/{id}", employeeId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(updatedEmployee)))
                .andExpect(status().isNotFound())
                .andDo(print());
    }

    @Test
    public void testDeleteByEmployeeId_Return200() throws Exception {
        long employeeId = 1L;
        willDoNothing().given(employeeService).deleteEmployee(employeeId);
        mockMvc.perform(delete("/api/v1/employees/{id}", employeeId)).andExpect(status().isOk()).andDo(print());
    }
}