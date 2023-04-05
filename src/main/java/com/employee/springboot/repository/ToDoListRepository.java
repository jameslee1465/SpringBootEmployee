package com.employee.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.springboot.model.ToDoList;

@Repository
public interface ToDoListRepository extends JpaRepository<ToDoList, Long> {

}
