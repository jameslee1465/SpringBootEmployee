package com.employee.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.springboot.model.Employee;
import com.employee.springboot.model.ToDoList;
import com.employee.springboot.repository.EmployeeRepository;
import com.employee.springboot.repository.ToDoListRepository;


@Service
public class ToDoListServiceImp implements ToDoListService{
	
	@Autowired
	ToDoListRepository TDLRepository;
	@Autowired
	EmployeeRepository EmpRepository;
	
	@Override
	public List < ToDoList > getAllTDL(){
		return TDLRepository.findAll();
	}

	@Override
	public void saveTDL(ToDoList TDL) {
		this.TDLRepository.save(TDL);
	}
	
	@Override
	public ToDoList getTDL(long tid) {
		Optional < ToDoList > optional = TDLRepository.findById(tid);
		ToDoList TDL = null;
		if(optional.isPresent()) {
			TDL = optional.get();
		}else {
			throw new RuntimeException(" ToDoList not found for id :: " + tid);
		}
		return TDL;
	}
	
	@Override
	public void deleteTDL(long tid) {
		this.TDLRepository.deleteById(tid);
	}
	
	@Override
	public String getPIC(long tid) {
		Optional < ToDoList > optional = TDLRepository.findById(tid);
		ToDoList TDL = null;
		String name = "";
		if(optional.isEmpty()) {
			throw new RuntimeException(" ToDoList not found for tid :: " + tid);
		}else if(optional.get().getEmpId() == 0 ) {
			throw new RuntimeException(" Person in Charge not found for tid :: " + tid);
		}else {
			TDL = optional.get();
			name = EmpRepository.findById(TDL.getEmpId()).get().getName();
		}
		return name;
	}
}
