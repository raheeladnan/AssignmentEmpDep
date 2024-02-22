package com.example.AssignmentEmpDep.repository;

import com.example.AssignmentEmpDep.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByIsActive(boolean isActive);
    List<Employee> findAllByRole(String role);

    @Transactional
    @Modifying
    @Query("UPDATE Employee e SET e.isActive = :isActive WHERE e.id = :employeeId")
    int updateEmployeeStatus(@Param("employeeId") Long employeeId, @Param("isActive") boolean isActive);

}