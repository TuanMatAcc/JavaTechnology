package com.example.Ex2.Controller;

import com.example.Ex2.Model.Employee;
import com.example.Ex2.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "index";
    }

    @GetMapping("/add")
    public String showAddPage() {
        return "add";
    }

    @PostMapping("/add")
    public String addEmployee(Model model, @ModelAttribute Employee employee) {
        System.out.println(employee);
        employeeService.save(employee);
        model.addAttribute("employees", employeeService.findAll());
        return "redirect:/employees";
    }

    @GetMapping("/edit/{id}")
    public String showEditPage(Model model, @PathVariable Integer id) {
        Employee employee = employeeService.findById(id);
        if(employee == null) {
            return "notfound";
        }
        model.addAttribute("employee", employee);
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editEmployee(Model model, @PathVariable Integer id, @ModelAttribute Employee employee) {
        employeeService.update(id, employee);
        return "redirect:/employees";
    }

    @PostMapping("/delete/{id}")
    public String deleteEmployee(Model model, @PathVariable Integer id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
