package com.employee.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.springboot.model.Employee;
import com.employee.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService{
	
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List < Employee > getAllEmp() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmp(Employee employee) {
        this.employeeRepository.save(employee);
    }

    @Override
    public Employee getEmp(long id) {
        Optional < Employee > optional = employeeRepository.findById(id);
        Employee employee = null;
        if (optional.isPresent()) {
            employee = optional.get();
        } else {
            throw new RuntimeException(" Employee not found for id :: " + id);
        }
        return employee;
    }

    @Override
    public void deleteEmp(long id) {
        this.employeeRepository.deleteById(id);
    }
    
    @Override
    public Optional<Employee> getTDLByEmpId(long id){
    	Optional<Employee> employee = employeeRepository.findById(id);
    	return employee;
    }

}
