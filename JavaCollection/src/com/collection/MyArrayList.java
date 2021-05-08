package com.collection;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<E> implements List<E>{
	
	int INITIAL_CAPACITY = 10;
	
	private E [] data = (E[])new Object[INITIAL_CAPACITY];
	private int count = 0;
	
	private void ensureCapacity(int capacity) {
		if(count == INITIAL_CAPACITY){
			data = Arrays.copyOf(data, capacity);
		}
	}
	
	@Override
	public boolean add(E e) {
		ensureCapacity(count+1);
		data[count++] = e;
		return true;
	}

	@Override
	public void add(int index, E element) {
		if(index < 0 || index > count){
			throw new IndexOutOfBoundsException();
		}
		if(index == count){
			add(element);
		}
		ensureCapacity(count+1);
		/*for(int i = index ; index < count; i++){
			data[i++] = data[i];
		}*/
		System.arraycopy(data, index, data, index+1, count - index);
		data[index] = element;
		count++;
		
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
	public void clear() {
		Arrays.fill(data, 0, count, null);
		count = 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) {
		if (index < count && index >= 0){
			return data[index];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		return count == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
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
	public boolean remove(Object o) {
		return false;
	}

	@Override
	public E remove(int index) {
		E rv = data[index];
		System.arraycopy(data, index+1, data, index, count - index -1);
		count--;
		return rv;
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
	public E set(int index, E element) {
		if (index < count && index >= 0){
			E rv = data[index];
			data[index] = element;
			return rv;
		} else {
			throw new IndexOutOfBoundsException();
		}
	}

	@Override
	public int size() {	
		return count;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < count ; i++){
			sb.append(data[i]);
		}
		return sb.toString();
	}
	
	
}
