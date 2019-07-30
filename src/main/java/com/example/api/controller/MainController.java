package com.example.api.controller;

import com.example.api.domain.Employee;
import com.example.api.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    EmployeeService service;

    @RequestMapping(value = "/getEmployeeList", method = RequestMethod.GET)
    public List<Employee> getEmployeeList(){
        return  service.getEmployeeList();
    }

    @RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
    public List<Employee> addEmployee(@RequestBody  Employee emp){
        service.AddEmployee(emp);
        return  service.getEmployeeList();
    }

    @RequestMapping(value = "/getEmployeeById/id/{id}", method = RequestMethod.GET)
    public Employee getEmployeeById(@PathVariable("id") long id){
        return  service.getEmployeeById( id);
    }

    @RequestMapping(value = "/deleteEmployee/id/{id}", method = RequestMethod.GET)
    public void deleteEmployeeById(@PathVariable("id") long id){
        if(id!=0) {
            service.deleteEmployeeById(id);
        }
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.POST)
    public void updateEmployee(@RequestBody Employee emp){
        if(emp.getId()!=0){
            service.updateEmployee(emp);
        }

    }

}
