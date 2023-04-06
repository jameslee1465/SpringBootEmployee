package com.employee.springboot.model;

import java.util.Date;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(nullable = false, columnDefinition = "varchar(20) not null default 'Staff'")
	@Enumerated(EnumType.STRING)
	private EmpPositionEnum position;
	
	@Column(nullable = false, columnDefinition = "varchar(20) not null default 'general'")
	@Enumerated(EnumType.STRING)
	private EmpStatusEnum status;
	
	@CreationTimestamp
	@Column(name = "created_at", updatable = false)
	private Date created_at;
	
	@UpdateTimestamp
	@Column(name = "updated_at")
	private Date updated_at;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EmpPositionEnum getPosition() {
		return position;
	}

	public void setPosition(EmpPositionEnum position) {
		this.position = position;
	}

	public EmpStatusEnum getStatus() {
		return status;
	}

	public void setStatus(EmpStatusEnum status) {
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
