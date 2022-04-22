package com.empereur.security.RestController;


import com.empereur.security.Models.Employee;
import com.empereur.security.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestCotroller {
    @Autowired
    private EmployeeServices employeeServices;

    @GetMapping("/allemployees")
    public List<Employee> allEmployee(){
        return  employeeServices.findAllEmployee();
    }

    @PostMapping("/saveemployee")
    public Employee saveEmployee(@RequestBody Employee employee){
        return  employeeServices.saveEmployee(employee);
    }


    @PutMapping("/desactivateemployee/{id}")
    public Employee desactivate(@PathVariable Long id){
        return employeeServices.desactivateEmployeeCarte(id);
    }

}
