package com.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedList<E> implements List<E>{
	
	private class Node{
		Node next;
		E value;
	}
	Node next;
	Node head = new Node();
	
	@Override
	public boolean add(E element) {
		Node node = new Node();
		node.value = element;
		Node last = head;
		while(last.next != null){
			last = last.next;
		}
		last.next = node;
		return true;
	}
	
	@Override
	public E remove(int index) {
		
		Node before = head;
		int i = index-1;
		while(i >= 0){
			before = before.next;
			i--;
		}
		Node toBeDeleted = before.next;
		before.next = toBeDeleted.next;;
		return toBeDeleted.value;
	}
	
	@Override
	public void add(int index, E element) {
		Node node = new Node();
		node.value = element;
		Node indexNode = head;
		int i = index-1;
		while(i-- >= 0){
			indexNode = indexNode.next;
		}
		Node indexNodeNext = indexNode.next;
		indexNode.next = node;
		node.next = indexNodeNext;
	}
	
	@Override
	public E set(int index, E element) {
		Node node = new Node();
		node.value = element;
		Node indexNode = head;
		int i = index;
		while(i-- >= 0){
			indexNode = indexNode.next;
		}
		indexNode.value = element;
		
		return element;
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		Node node = head;
		while(node.next != null){
			node = node.next;
			sb.append(node.value);
		}
		return sb.toString();
	}
	
	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return 0 == 0;
	}




	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int lastIndexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

}
