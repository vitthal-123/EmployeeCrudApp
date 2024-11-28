package com.vitthal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitthal.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
