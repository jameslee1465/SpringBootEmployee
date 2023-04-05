package com.employee.springboot.service;

import java.util.List;

import com.employee.springboot.model.Employee;

public interface EmployeeService {
	List < Employee > getAllEmp();
    void saveEmp(Employee employee);
    Employee getEmp(long id);
    void deleteEmp(long id);
}
