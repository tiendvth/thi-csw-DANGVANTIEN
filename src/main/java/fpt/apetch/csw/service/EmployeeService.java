package fpt.apetch.csw.service;

import fpt.apetch.csw.entity.Employee;
import fpt.apetch.csw.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    final EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(int id, Employee employeeUpdate) {
        Optional<Employee> tblClassOptional = employeeRepository.findById(id);
        if(tblClassOptional.isPresent()) {
            Employee employee = tblClassOptional.get();
            employee.setName(employeeUpdate.getName());
            employee.setSalary(employeeUpdate.getSalary());
            employee.setStatus(employeeUpdate.getStatus());
            return employeeRepository.save(employee);
        }
        return null;
    }
}
