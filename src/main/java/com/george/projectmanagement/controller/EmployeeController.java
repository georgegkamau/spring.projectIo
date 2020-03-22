package com.george.projectmanagement.controller;

import com.george.projectmanagement.model.Employee;
import com.george.projectmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeRepository.findAll();
        model.addAttribute("employee", employees);
        return "employee/employees";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee/new-employee";
    }

    @PostMapping("/save")
    public String createProject(Employee employee, Model model) {
        employeeRepository.save(employee);
        // use a redirect to prevent duplicate submissions
        return "redirect:/employees/new ";
    }


    // end
}
