package com.example.Ex2.Service;

import com.example.Ex2.Model.Employee;
import com.example.Ex2.Repository.EmployeeRepository;
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
        return employeeRepository.findAll();
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
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
