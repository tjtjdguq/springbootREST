package com.basic.myspringboot.controller;

import com.basic.myspringboot.entity.Employee;
import com.basic.myspringboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeRestController {
    private final EmployeeService employeeService;

    //Constructor Injection (생성자 주입 방식)
//    public EmployeeRestController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }

    //POST http://localhost:8087/api/users
    @PostMapping
    public Employee addEmployee(@RequestBody Employee user) {
        return employeeService.insertEmployee(user);
    }

    //GET http://localhost:8087/api/users
    @GetMapping
    public List<Employee> getEmployees(){
        return employeeService.selectAllEmployee();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.selectEmployee(id);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee userDetail){
        return employeeService.updateEmployee(id, userDetail);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

}
