package com.employee.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.employee.springboot.service.EmployeeService;
import com.employee.springboot.model.Employee;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // display list of employees
    @GetMapping("/emp")
    public String indexPage(Model model) {
        model.addAttribute("empList", employeeService.getAllEmp());
        return "index_emp";
    }

    @GetMapping("/createEmp")
    public String createPage(Model model) {
        // create model attribute to bind form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_emp";
    }

    @GetMapping("/updateEmp/{id}")
    public String updatePage(@PathVariable(value = "id") long id, Model model) {

        // get employee from the service
        Employee employee = employeeService.getEmp(id);

        // set employee as a model attribute to pre-populate the form
        model.addAttribute("employee", employee);
        return "update_emp";
    }
    
    @PostMapping("/saveEmp")
    public String saveAndIndex(@ModelAttribute("employee") Employee employee) {
        // save employee to database
        employeeService.saveEmp(employee);
        return "redirect:/emp";
    }

    @GetMapping("/deleteEmp/{id}")
    public String deleteAndIndex(@PathVariable(value = "id") long id) {

        // call delete employee method 
        this.employeeService.deleteEmp(id);
        return "redirect:/emp";
    }
}
