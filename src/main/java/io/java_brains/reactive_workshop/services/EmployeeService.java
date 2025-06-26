package io.java_brains.reactive_workshop.services;

import io.java_brains.reactive_workshop.dtos.EmployeeDto;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);
}
