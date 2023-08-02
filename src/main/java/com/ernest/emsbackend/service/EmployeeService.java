package com.ernest.emsbackend.service;

import com.ernest.emsbackend.dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long employeeId);
}
