package com.employee.springboot.service;

import java.util.List;

import com.employee.springboot.model.*;

public interface ToDoListService {
	List< ToDoList > getAllTDL();
	void saveTDL(ToDoList tdl);
	ToDoList getTDL(long tid);
	void deleteTDL(long tid);
	//get Employee in Charge
	String getEIC(long tid);
}
