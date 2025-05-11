package io.java_brains.reactive_workshop.repositories;

import io.java_brains.reactive_workshop.entities.Employee;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

// ReactiveMongoRepository extents ReactiveCrudRepository
// We could also extend ReactiveCrudRepository if we just wanted to use those methods
public interface EmployeeRepository extends ReactiveMongoRepository<Employee, String> {
}
