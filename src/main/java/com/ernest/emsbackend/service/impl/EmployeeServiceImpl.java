package com.ernest.emsbackend.service.impl;

import com.ernest.emsbackend.dto.EmployeeDto;
import com.ernest.emsbackend.entity.Employee;
import com.ernest.emsbackend.exception.ResourceNotFoundExeption;
import com.ernest.emsbackend.mapper.EmployeeMapper;
import com.ernest.emsbackend.repository.EmployeeRepository;
import com.ernest.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(()->
                        new ResourceNotFoundExeption("Employee does not exist with given id : " + employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(employee -> EmployeeMapper.mapToEmployeeDto(employee)).collect(Collectors.toList());
    }
}
