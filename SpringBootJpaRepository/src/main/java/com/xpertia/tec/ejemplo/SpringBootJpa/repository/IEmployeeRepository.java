package com.xpertia.tec.ejemplo.SpringBootJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xpertia.tec.ejemplo.SpringBootJpa.model.Employee;

/**
 * The Interface IEmployeeRepository.
 */
@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {

}
