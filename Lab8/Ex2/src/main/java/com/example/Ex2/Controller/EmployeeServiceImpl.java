package com.example.Ex2.Controller;

import com.example.Ex2.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> findAll() {
        return (List<Employee>)employeeRepository.findAll();
    }
    public Employee update(Integer employeeId, Employee updatedEmployee) {
        if(employeeRepository.existsById(employeeId)) {
            updatedEmployee.setId(employeeId);
            return employeeRepository.save(updatedEmployee);
        }
        return null;
    }
    public void delete(Integer employeeId) {
        employeeRepository.deleteById(employeeId);
    }
}
