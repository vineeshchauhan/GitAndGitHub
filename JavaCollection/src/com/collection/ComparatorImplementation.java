package com.collection;

import java.util.Arrays;
import java.util.List;

public class ComparatorImplementation {

	public static void main(String[] args) {
		
		Employee e1 = new Employee(1,"Vineesh",100);
		Employee e4 = new Employee(4,"Abhilasha",500);
		Employee e3 = new Employee(3,"Shiv",300);
		Employee e2 = new Employee(2,"Amit",200);
		
		
		List<Employee> listOfEmployees = Arrays.asList(e1,e2,e3,e4);
		
		listOfEmployees.sort(null);
		
		System.out.println(listOfEmployees.toString());
		
		listOfEmployees.sort((t1,t2) -> {
			return t1.getName().compareTo(t2.getName());
		});
		
		System.out.println(listOfEmployees.toString());
		

		listOfEmployees.sort((t1,t2) -> {
			return Float.compare(t1.getSalary(),t2.getSalary());
		});
		
		System.out.println(listOfEmployees.toString());

	}

}
