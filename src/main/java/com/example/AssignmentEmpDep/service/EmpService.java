package com.example.AssignmentEmpDep.service;

import com.example.AssignmentEmpDep.entity.Employee;
import com.example.AssignmentEmpDep.enums.Role;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmpService {

    ResponseEntity<Employee> updateEmployee(Long id, Employee updatedEmployee);

    Employee saveEmp(Employee employee);

    Page<Employee> findAllEmployee(int page, int size);

    List<Employee> findAllManagers();
}
