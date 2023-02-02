package com.suryatejasunkoju.EmployeeManagementSystem.controller;

import com.suryatejasunkoju.EmployeeManagementSystem.model.Employee;
import com.suryatejasunkoju.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    //Create
    @RequestMapping(method = RequestMethod.POST, value = "/new")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.createEmployee(employee), HttpStatus.ACCEPTED);
    }
    //Read
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Employee> readAllEmployees(){
        return employeeService.getEmployees();
    }
    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public Employee readEmployee(@PathVariable("id") Integer id){
        return employeeService.getEmployee(id);
    }
    //Update
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public Employee updateEmployee(@PathVariable("id") Integer id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }
    //Delete
    @RequestMapping(path = "/delete_all", method = RequestMethod.DELETE)
    public void deleteAllEmployees(){
        employeeService.deleteAllEmployees();
    }
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteEmployee(@RequestParam("id") Integer id){
        employeeService.deleteEmployee(id);
    }
}
