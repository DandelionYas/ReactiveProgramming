package io.java_brains.reactive_workshop.services.impl;

import io.java_brains.reactive_workshop.dtos.EmployeeDto;
import io.java_brains.reactive_workshop.entities.Employee;
import io.java_brains.reactive_workshop.mappers.EmployeeMapper;
import io.java_brains.reactive_workshop.repositories.EmployeeRepository;
import io.java_brains.reactive_workshop.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.INSTANCE.dtoToEntity(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);
        return savedEmployee.map(EmployeeMapper.INSTANCE::entityToDto);
    }
}
