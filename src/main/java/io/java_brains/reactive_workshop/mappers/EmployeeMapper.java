package io.java_brains.reactive_workshop.mappers;

import io.java_brains.reactive_workshop.dtos.EmployeeDto;
import io.java_brains.reactive_workshop.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeDto entityToDto(Employee employee);

    Employee dtoToEntity(EmployeeDto employeeDto);
}
