package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.controllers;

import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto.EmployeeDTO;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.entities.EmployeeEntity;
import com.codingshuttle.springbootwebtutorial.springbootwebtutorial.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(path="/getSecretMessage")
    public String getMyMessage(){
        return "Secret message: 3904w";
    }

    @GetMapping("/{employeeID}")
    public EmployeeEntity getEmployeeById(@PathVariable(name="employeeID") Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getAllEmployees(@RequestParam(required = false, name="inputAge") Integer age,
                                                @RequestParam(required = false) String sortBy){
        return employeeRepository.findAll();
        // http://localhost:8091/employees?age=12
        // http://localhost:8091/employees?inputAge=12
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){
        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){
        return "Hello from Put";
    }
}
