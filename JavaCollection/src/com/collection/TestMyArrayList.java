package com.collection;

public class TestMyArrayList {

	public static void main(String[] args) {
		
		MyLinkedList list = new MyLinkedList<>();
		//MyArrayList list = new MyArrayList<>();
		list.add("A");
		list.add("B");
		System.out.println(list.toString());
		list.add(0, "C");
		System.out.println(list.toString());
		list.set(0, "D");
		System.out.println(list.toString());
		System.out.println(list.size());
		list.remove(2);
		System.out.println(list.toString());
		System.out.println(list.size());
		list.add(0, "E");
		System.out.println(list.toString());
		System.out.println(list.size());
	}

}
