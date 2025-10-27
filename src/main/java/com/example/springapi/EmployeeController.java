package com.example.springapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/employees")
public class EmployeeController {

//    @GetMapping
//    public Employee getEmployee() {
//        return new Employee("Bogdan", "Petre", 22,
//                "bogdan@email.com", "Bucuresti", "programmer");
//    }

    @GetMapping
    public List<Employee> getEmployee() {
        return List.of(new Employee("Bogdan", "Petre", 22,
                "bogdan@email.com", "Bucuresti", "Software Developer"),
                new Employee("Alex", "Mihai", 25,
                        "alex@email.com", "Bucuresti", "Ethical Hacker"),
                new Employee("Virgil", "Bosk", 31, "virgil@email.com", "Ukraine", "QA Tester")
                );
    }
}