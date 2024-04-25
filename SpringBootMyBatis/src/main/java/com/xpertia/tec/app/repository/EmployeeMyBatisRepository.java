package com.xpertia.tec.app.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.xpertia.tec.app.model.Employee;

/**
 * The Interface EmployeeMyBatisRepository.
 */
@Mapper
public interface EmployeeMyBatisRepository {

	/**
	 * Find all.
	 * @return the list
	 */
	@Select("select id,first_name as firstName,last_name as lastName,email_address as emailAddress from employees")
	List<Employee> findAll();
	
	/**
	 * Find by id.
	 * @param id the id
	 * @return the employee
	 */
	@Select("select id,first_name as firstName,last_name as lastName,email_address as emailAddress from employees where id = #{id}")
	Employee findById(Long id);
	
	/**
	 * Save.
	 * @param employee the employee
	 * @return the long
	 */
	@Insert("insert into employees(id,first_name,last_name,email_address) " +
			" values( #{id},#{firstName},#{lastName},#{emailAddress} ) ")
	Long save(Employee employee);
	
	/**
	 * Update.
	 * @param employee the employee
	 * @return the long
	 */
	@Update("update employees set first_name = #{firstName},last_name = #{lastName},"
			+ " email_address = #{emailAddress} where id = #{id} ")
	Long update(Employee employee);
	
	/**
	 * Delete by id.
	 * @param id the id
	 */
	@Delete("delete from employees where id = #{id}")
	void deleteById(Long id);
	
}
