package com.xpertia.tec.ejemplo.app.emgr.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Repository;

import com.xpertia.tec.ejemplo.app.emgr.model.Employee;

/**
 * The Class EmployeeRepository.
 */
@Repository
public class EmployeeRepository implements IEmployeeRepository {
	
	/** The entity manager. */
	@PersistenceContext
	private EntityManager entityManager;
	
	/** The Constant OK. */
	private static final String OK = "OK";


	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> findAll() {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_EMPLOYEES.PRC_FIND_ALL",Employee.class);
		query.registerStoredProcedureParameter(1,void.class,ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.OUT);
		query.execute();
		List<Employee> lista = query.getResultList();
		return lista;
	}

	/**
	 * Find by id.
	 *
	 * @param id the id
	 * @return the employee
	 */
	@SuppressWarnings("unchecked")
	@Override
	public Employee findById(Long id) {
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_EMPLOYEES.PRC_FIND_BY_ID",Employee.class);		
		query.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,void.class,ParameterMode.REF_CURSOR);
		query.registerStoredProcedureParameter(3,void.class,ParameterMode.REF_CURSOR);
		query.setParameter(1,id);				
		query.execute();
		List<Employee> lista = query.getResultList();
		Employee employee = new Employee();	
		employee.setId(lista.get(0).getId());
		employee.setFirstName(lista.get(0).getFirstName());
		employee.setLastName(lista.get(0).getLastName());
		employee.setEmailAddress(lista.get(0).getEmailAddress());
		return employee;
	}

	/**
	 * Count.
	 *
	 * @return the int
	 */
	@Override
	public int count() {
		int total = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_EMPLOYEES.PRC_COUNT");		
		query.registerStoredProcedureParameter("P_TOTAL",Long.class,ParameterMode.OUT);
		query.registerStoredProcedureParameter("P_MENSAJE",String.class,ParameterMode.OUT);
		query.execute();		
		String msg = (String) query.getOutputParameterValue("P_MENSAJE");
		if(OK.equals(msg)) {
			total = (int) query.getOutputParameterValue("P_TOTAL");
		}								
		return total;
	}

	/**
	 * Save.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int save(Employee employee) {
		int result = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_EMPLOYEES.PRC_SAVE");		
		query.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);			
		query.registerStoredProcedureParameter(3,void.class,ParameterMode.REF_CURSOR);
		query.setParameter(1,employee.getId());
		query.setParameter(2,employee.getFirstName());
		query.setParameter(3,employee.getLastName());
		query.setParameter(4,employee.getEmailAddress());
		query.execute();
		String msg = (String) query.getOutputParameterValue("P_MENSAJE");
		if(OK.equals(msg)) {
			result = 1;
		}
		
		return result;
	}

	/**
	 * Update.
	 *
	 * @param employee the employee
	 * @return the int
	 */
	@Override
	public int update(Employee employee) {
		int result = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_EMPLOYEES.PRC_UPDATE");		
		query.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(3,String.class,ParameterMode.IN);
		query.registerStoredProcedureParameter(4,String.class,ParameterMode.IN);			
		query.registerStoredProcedureParameter(3,void.class,ParameterMode.REF_CURSOR);
		query.setParameter(1,employee.getId());
		query.setParameter(2,employee.getFirstName());
		query.setParameter(3,employee.getLastName());
		query.setParameter(4,employee.getEmailAddress());
		query.execute();
		String msg = (String) query.getOutputParameterValue("P_MENSAJE");
		if(OK.equals(msg)) {
			result = 1;
		}		
		return result;
	}

	/**
	 * Delete by id.
	 *
	 * @param id the id
	 * @return the int
	 */
	@Override
	public int deleteById(Long id) {
		int result = 0;
		StoredProcedureQuery query = entityManager.createStoredProcedureQuery("PKG_EMPLOYEES.PRC_UPDATE");		
		query.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN);				
		query.registerStoredProcedureParameter(3,void.class,ParameterMode.REF_CURSOR);
		query.setParameter(1,id);		
		query.execute();
		String msg = (String) query.getOutputParameterValue("P_MENSAJE");
		if(OK.equals(msg)) {
			result = 1;
		}		
		return result;
	}

}
