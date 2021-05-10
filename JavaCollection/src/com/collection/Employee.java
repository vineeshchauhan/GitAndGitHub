package com.collection;

public class Employee implements Comparable<Employee>{
	
	private Integer id;
	private String name;
	private float salary;
	
	public Employee(Integer id, String name, float salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}
	@Override
	public int compareTo(Employee o) {
		if(o == null){
			return -1;
		}
		if(id < o.getId()){
			return -1; 
		}else if(id > o.getId()){
			return 1;
		}
		return 0;
	}

	

}
