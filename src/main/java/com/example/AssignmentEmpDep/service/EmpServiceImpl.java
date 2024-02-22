package com.example.AssignmentEmpDep.service;

import com.example.AssignmentEmpDep.entity.Employee;
import com.example.AssignmentEmpDep.enums.Role;
import com.example.AssignmentEmpDep.exception.UserNotFoundException;
import com.example.AssignmentEmpDep.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee saveEmp(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> findAllEmployee(int page, int size) {
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    @Override
    public List<Employee> findAllManagers() {
        return employeeRepository.findAllByRole(Role.MANAGER.name());
    }

    @Override
    public ResponseEntity<Employee> updateEmployee(Long id, Employee updatedEmployee) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setEmpName(updatedEmployee.getEmpName());
            employee.setActive(updatedEmployee.isActive());
            employee.setDepartment(updatedEmployee.getDepartment());
            return ResponseEntity.ok(employeeRepository.save(employee));
        } else {
            return ResponseEntity.notFound().build();
        }
    }



    public void updateEmployeeStatus(Long employeeId, boolean isActive) throws Exception {
        int rowsUpdated = employeeRepository.updateEmployeeStatus(employeeId, isActive);
        if (rowsUpdated != 1) {
            throw new UserNotFoundException("User not found with ID: " + employeeId, 402);
        }
    }

}
