package com.example.springapi;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getEmployees();
    Employee getEmployeeById(Long id);
    void createEmployee(Employee employee);
    void updateEmployee(Long id, Employee employee);
    void deleteEmployee(Long id);
}
