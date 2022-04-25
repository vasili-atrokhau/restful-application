package by.teachmeskills.service;

import by.teachmeskills.entity.Employee;
import by.teachmeskills.entity.EmployeeRequest;
import by.teachmeskills.exception.EmployeeException;
import by.teachmeskills.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeService {

    private final EmployeeRepository repository;

    public List<Employee> getEmployees() {
        return null;
    }

    public Employee createEmployee(EmployeeRequest request) {
        Employee employee = Employee.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .build();

        return repository.save(employee);
    }

    public Employee updateEmployee(EmployeeRequest request) {
        return null;
    }

    public void deleteEmployee(Long id) {

    }

    public Employee getEmployeeById(Long id) throws EmployeeException {
        log.info("Start getEmployeeById() with id: " + id);

        Employee employee;
        Optional<Employee> employeeOptional = repository.findById(id);

        if (employeeOptional.isPresent()) {
            employee = employeeOptional.get();
        } else {
            throw new EmployeeException("Employee with id: " + id + " was not found");
        }

        log.info("Finish getEmployeeById() with id: " + id);

        return employee;
    }
}