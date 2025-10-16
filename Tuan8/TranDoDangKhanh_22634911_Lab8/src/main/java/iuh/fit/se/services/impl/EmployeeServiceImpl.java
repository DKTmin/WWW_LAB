package iuh.fit.se.services.impl;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.repository.EmployeeRepository;
import iuh.fit.se.services.EmployeeService;
import jakarta.transaction.Transactional;

import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getList() {
        return employeeRepository.findAll();
    }


}
