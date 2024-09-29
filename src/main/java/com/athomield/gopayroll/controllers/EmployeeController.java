package com.athomield.gopayroll.controllers;

import com.athomield.gopayroll.entities.Company;
import com.athomield.gopayroll.entities.Employee;
import com.athomield.gopayroll.entities.employee.EmployeeEmploymentDetails;
import com.athomield.gopayroll.entities.requestbodies.EmployeeRequestBody;
import com.athomield.gopayroll.services.CompanyService;
import com.athomield.gopayroll.services.EmployeeService;
import com.athomield.gopayroll.services.employee.EmployeeEmploymentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private EmployeeEmploymentDetailsService employeeEmploymentDetailsService;

    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeRequestBody employeeRequestBody) {
        Company employeeCompany = companyService.getCompanyById(employeeRequestBody.getCompany_id());

        Employee newEmployee = new Employee(employeeRequestBody.getName(), employeeRequestBody.getEmail(), employeeRequestBody.getSalary(), employeeCompany);
        newEmployee.setCompany(employeeCompany);
        newEmployee.setAddress(employeeRequestBody.getAddress());
        Employee savedEmployee = employeeService.saveEmployee(newEmployee);

        EmployeeEmploymentDetails employeeEmploymentDetails = new EmployeeEmploymentDetails();
        employeeEmploymentDetails.setEmployee(savedEmployee);
        employeeEmploymentDetailsService.saveEmployeeEmploymentDetails(employeeEmploymentDetails);

        employeeEmploymentDetails.setDepartmentId(employeeRequestBody.getDepartment_id());

        Employee gotEmployee = employeeService.getEmployeeById(savedEmployee.getId());
        gotEmployee.setEmployeeEmploymentDetails(employeeEmploymentDetails);
        employeeService.updateEmployee(gotEmployee.getId(),gotEmployee);

        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
        if (updatedEmployee != null) {
            return ResponseEntity.ok(updatedEmployee);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}