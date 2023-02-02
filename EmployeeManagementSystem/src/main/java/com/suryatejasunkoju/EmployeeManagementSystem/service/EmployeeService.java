package com.suryatejasunkoju.EmployeeManagementSystem.service;

import com.suryatejasunkoju.EmployeeManagementSystem.model.Employee;
import com.suryatejasunkoju.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    //CREATE
    public Employee createEmployee(Employee emp){
        return employeeRepository.save(emp);
    }
    // READ
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
    public Employee getEmployee(Integer id){
        return employeeRepository.findById(id).get();
//        return employeeRepository.getById(id);
    }
    //UPDATE
    public Employee updateEmployee(Integer empId, Employee employeeDetails){
        Employee employee=employeeRepository.findById(empId).get();
        employee.setFirstName(employeeDetails.getFirstName());
        employee.setLastName(employeeDetails.getLastName());
        employee.setEmail(employeeDetails.getEmail());
        return employeeRepository.save(employee);
    }
    // DELETE
    public void deleteEmployee(Integer empId) {
        employeeRepository.deleteById(empId);
    }
    public void deleteAllEmployees(){
        employeeRepository.deleteAll();
    }
}
