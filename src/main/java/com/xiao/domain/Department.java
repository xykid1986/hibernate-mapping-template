package com.xiao.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bidirectional one to many relationship. Many is usually the owner, so here just use mappedBy.
 * @author yi
 *
 */
@Entity
@Table(name="department")
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	@OneToMany(mappedBy="department")
	private List<Employee> employees;
	
	public Department(){
		this(null);
	}
	
	public Department(String name){
		this.name = name;
		employees = new ArrayList<Employee>();
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

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	
}
