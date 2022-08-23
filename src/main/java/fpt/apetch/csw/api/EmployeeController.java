package fpt.apetch.csw.api;

import fpt.apetch.csw.entity.Employee;
import fpt.apetch.csw.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "employee", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> findAllEmployee() {
        List<Employee> list = employeeService.findAll();
        if (list.size() == 0) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(list, HttpStatus.OK);
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public ResponseEntity<Employee> save(@RequestBody Employee employees) {
        employeeService.save(employees);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.PUT)
    public ResponseEntity<Employee> update(@PathParam("id") Integer id, @RequestBody Employee employees) {
        Employee employee = employeeService.updateEmployee(id, employees);
        employee.setName(employees.getName());
        employee.setSalary(employees.getSalary());
        employeeService.save(employee);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateE(@PathVariable(value = "id") Integer id, @RequestBody Employee employees) {
       Employee employee1 = employeeService.updateEmployee(id, employees);
        employee1.setName(employees.getName());
        employee1.setSalary(employees.getSalary());
        employeeService.save(employee1);
        return new ResponseEntity<Employee>(employees, HttpStatus.OK);
    }
}