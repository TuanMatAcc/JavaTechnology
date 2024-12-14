package com.example.Ex2.Service;

import com.example.Ex2.Model.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee save(Employee employee);
    public List<Employee> findAll();
    public Employee update(Integer employeeId, Employee updatedEmployee);
    public void delete(Integer employeeId);
    public Employee findById(Integer id);
}
