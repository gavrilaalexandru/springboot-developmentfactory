package com.example.springapi;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return findAndValidateByIdOrThrow(id);
    }

    @Override
    public void createEmployee(Employee employee) {
        validateEmail(employee.getEmailAddress());
        employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Long id, Employee employee) {
        Employee employeeToUpdate = findAndValidateByIdOrThrow(id);
        validateEmail(employee.getEmailAddress(), id);

        employeeToUpdate.setFirstName(employee.getFirstName());
        employeeToUpdate.setLastName(employee.getLastName());
        employeeToUpdate.setAge(employee.getAge());
        employeeToUpdate.setHomeAddress(employee.getHomeAddress());
        employeeToUpdate.setEmailAddress(employee.getEmailAddress());
        employeeToUpdate.setRole(employee.getRole());

        employeeRepository.save(employeeToUpdate);
    }

    private void validateEmail(String email) {
        Optional<Employee> employeeOptional = employeeRepository.getEmployeeByEmailAddress(email);
        if (employeeOptional.isPresent()) {
            throw new IllegalStateException(String.format("Email address %s is already in use", email));
        }
    }
    private void validateEmail(String email, Long excludeId) {
        Optional<Employee> employeeOptional = employeeRepository.getEmployeeByEmailAddress(email);
        if (employeeOptional.isPresent() &&
                (excludeId == null || !employeeOptional.get().getId().equals(excludeId))) {
            throw new IllegalStateException(String.format("Email address %s is already in use", email));
        }
    }

    private Employee findAndValidateByIdOrThrow(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new IllegalStateException(String.format("Employee with id %s doesn't exist", id))
        );
    }

    @Override
    public void deleteEmployee(Long id) {
        findAndValidateByIdOrThrow(id);
        employeeRepository.deleteById(id);
    }
}
