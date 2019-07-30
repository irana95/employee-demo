package com.example.api.services;


import com.example.api.domain.Employee;
import com.example.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public Employee getEmployeeById(long id){
            return  repository.findById(id).get();

    }
    public void deleteEmployeeById(long id){
        repository.deleteById(id);

    }

    public List<Employee> getEmployeeList(){
            return  repository.findAll();
    }



    public void AddEmployee(Employee employee){
       repository.save(employee);
    }

    public void updateEmployee(Employee employee){
       repository.save(employee);
    }
}
