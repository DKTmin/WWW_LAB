package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping
    public String index(Model model){
        List<Employee> employeeList = employeeService.getList();
        model.addAttribute("employees", employeeList);
        return "employee_list";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult result) {

        if (result.hasErrors()) {
            return "employee_register";
        }

        employeeService.save(employee);

        return "redirect:";
    }
}
