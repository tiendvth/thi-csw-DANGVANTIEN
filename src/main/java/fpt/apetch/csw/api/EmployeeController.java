package fpt.apetch.csw.api;

import fpt.apetch.csw.entity.Employee;
import fpt.apetch.csw.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
public class EmployeeController {
    final EmployeeService employeeService;

    @GetMapping
    public ResponseEntity<?> getEmployees() {
        return ResponseEntity.ok(employeeService.getEmployee());
    }
    @PostMapping("/add")
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.addEmployee(employee));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        Employee tblClass1 = employeeService.updateEmployee(id, employee);
        if(employee == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService);
    }
}
