package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {
    @Autowired
    private Employee employee;
    @RequestMapping("/hello")
    public ModelAndView hello(){
        Employee employee=new Employee();
        employee.setName("Ak");
        employee.setId(101);
        employee.setSalary(1000000);
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.addObject("Name",employee.getName());
        modelAndView.addObject("Id",employee.getId());
        modelAndView.addObject("Sal",employee.getSalary());
        return modelAndView;
    }
}
