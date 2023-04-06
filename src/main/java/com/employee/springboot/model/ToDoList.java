package com.employee.springboot.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "todolist")
public class ToDoList {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(nullable = false)
	private long tid;
	
	@Column(name = "empId")
	private long empId;
	
	@Column(name = "task")
	private String task;
	
	@Lob
	private String description;
	
	@Column(nullable = false, columnDefinition = "varchar(20) not null default 'PENDING'")
	@Enumerated(EnumType.STRING)
	private TaskStatusEnum status;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date created_at;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updated_at;

	public long getTid() {
		return tid;
	}

	public void setTid(long tid) {
		this.tid = tid;
	}
	
	public long getEmpId() {
		return empId;
	}

	public void setEmpId(long empId) {
		this.empId = empId;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TaskStatusEnum getStatus() {
		return status;
	}

	public void setStatus(TaskStatusEnum status) {
		this.status = status;
	}
	
	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}	

}
