package com.example.AssignmentEmpDep.controller;

import com.example.AssignmentEmpDep.entity.Employee;
import com.example.AssignmentEmpDep.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/employee")
public class EmpController {
    @Autowired
    private EmpService empService;

    @PostMapping(value = "/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return empService.saveEmp(employee);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
            return empService.updateEmployee(id,updatedEmployee);
    }


    @GetMapping(value = "/getAll")
    public Page<Employee> getAllEmployees(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "50") int size) {
       return empService.findAllEmployee(page,size);
    }


    @GetMapping("/managers")
    public List<Employee> getManagers() {
        return empService.findAllManagers();
    }

    @PutMapping(value = "/changeStatus")
    public void updateEmployeeStatus(){

    }

}
