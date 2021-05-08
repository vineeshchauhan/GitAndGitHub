package com.collection;

public class Node<V, N> {

	private V value;
	private N next;
	
	public V getValue() {
		return value;
	}
	public void setValue(V value) {
		this.value = value;
	}
	public N getNext() {
		return next;
	}
	public void setNext(N next) {
		this.next = next;
	}
	
	
}
