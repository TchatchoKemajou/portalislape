package com.empereur.security.Services;


import com.empereur.security.Models.Employee;
import com.empereur.security.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {

    @Autowired
    private EmployeeRepository employeeRepository;

    public  void  saveEmployee(Employee employee){
        employeeRepository.save(employee);
    }

    public  void desactivateEmployeeCarte(Long id){
        Employee employee = employeeRepository.getById(id);
        Employee newemplyee = employee;

        employee.setEtatCarte(false);

        employeeRepository.save(newemplyee);
    }



    public Employee findEmployeeByCode(String code){
        List<Employee> employeeList = employeeRepository.findAll();

        for (Employee employee:employeeList){
            if (employee.getEmpCode().equals(code) && employee.isEtatCarte() == true){
                return  employee;
            }
        }

        return  null;
    }

}
