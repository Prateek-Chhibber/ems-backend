package com.ernest.emsbackend.service.impl;

import com.ernest.emsbackend.dto.EmployeeDto;
import com.ernest.emsbackend.entity.Employee;
import com.ernest.emsbackend.mapper.EmployeeMapper;
import com.ernest.emsbackend.repository.EmployeeRepository;
import com.ernest.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

//    Injected EmployeeRepository
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {
//        Convert Employee Dto to JPA
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);
        Employee savedEmployee = employeeRepository.save(employee);
//        Convert JPA to Dto to return
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }
}
