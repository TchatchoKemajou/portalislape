package com.empereur.security.RestController;


import com.empereur.security.Models.Employee;
import com.empereur.security.Services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeRestCotroller {
    @Autowired
    private EmployeeServices employeeServices;

    @PostMapping("saveemployee")
    public void saveEmployee(@RequestBody Employee employee){
        employeeServices.saveEmployee(employee);
    }


    @PutMapping("/desactivateemployee/{id}")
    public void desactivate(@PathVariable Long id){
        employeeServices.desactivateEmployeeCarte(id);
    }

}
