package com.xiao.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bidirectional one to many relationship. Many is usually the owner
 * @author yi
 *
 */
@Entity
@Table(name="employee")
public class Employee {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@ManyToOne(fetch=FetchType.LAZY,cascade=CascadeType.PERSIST)
	@JoinColumn(name="department_id")
	private Department department;
	
	public Employee(){
		this(null);
	}
	
	public Employee(String name){
		this.name=name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString(){
		return name;
	}
	
}
