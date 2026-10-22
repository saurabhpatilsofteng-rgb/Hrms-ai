package com.example.hrmsbackend.service;


import com.example.hrmsbackend.entity.Employee;
import com.example.hrmsbackend.repository.EmployeeRepository;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeTools {

    private final EmployeeRepository repository;

    public EmployeeTools(EmployeeRepository repository){
        this.repository = repository;
    }

    @Tool(description = "Get all employees in the hrms ")
    public List<Employee> getEmployees(){
        return repository.findAll();
    }

    @Tool(description = "Find employees by department name")
    public List<Employee> getEmployeesByDepartment(String department){

        return repository.findAll()
                .stream()
                .filter(employee -> employee.getDepartment() != null && employee.getDepartment()
                        .equalsIgnoreCase(department))
                .toList();




            }


}
