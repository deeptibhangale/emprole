package com.employee_info.repositories;
import com.employee_info.entities.EmployeeRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeRole,Integer> {

}
