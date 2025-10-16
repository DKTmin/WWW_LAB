package iuh.fit.se.services;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    public Employee save(Employee employee);
    public List<Employee> getList();
}
