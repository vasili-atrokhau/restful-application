package by.teachmeskills.controller;

import by.teachmeskills.entity.Employee;
import by.teachmeskills.entity.EmployeeRequest;
import by.teachmeskills.exception.EmployeeException;
import by.teachmeskills.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @PostMapping("/employees")
    @PreAuthorize("hasRole('ADMIN')")
    public Employee createEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.createEmployee(request);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.updateEmployee(request);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/employees/{id}")
    @PreAuthorize("hasAuthority('USER_READ')")
    public Employee getById(@PathVariable("id") Long id) throws EmployeeException {
        return employeeService.getEmployeeById(id);
    }
}