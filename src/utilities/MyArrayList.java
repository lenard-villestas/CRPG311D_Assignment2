package utilities;

import java.lang.reflect.Array;

import exceptions.*;

public class MyArrayList<E> implements ListADT<E> {
	private int size;
	private E[] data;
	private final int DEFAULT_SIZE = 10;
	private MyIterator iterator;

	// initialize with size
	public MyArrayList(int size) throws WrongValueException {
		if (size <= 0) {
			throw new WrongValueException("Size cannot be negative or 0");
		} else {
			data = (E[]) new Object[size];
		}
	}

	// initialize without size
	public MyArrayList() {
		data = (E[]) new Object[DEFAULT_SIZE];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return size;
	}

	// clear size and data
	@Override
	public void clear() {

		this.size = 0;
		data = null;

	}

	// dynamically increase data array size
	public void increaseCap(int newCap) {
		int currentCap = data.length;

		if (newCap > currentCap) {
			E[] newData = (E[]) new Object[newCap];
			System.arraycopy(this.data, 0, newData, 0, this.size);
			this.data = newData;
		}
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {

		// check if index is out of bounds
		if (index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		// check if null
		if (toAdd.equals(null)) {
			throw new NullPointerException("Cannot add null element");
		}

		if (size == data.length) {
			increaseCap(size + 1);
		}

		// if index is to be added to last
		if (index == size) {
			return add(toAdd);

		}

		// shift the array
		if (index != size) {
			System.arraycopy(data, index, data, index + 1, size - index);
			data[index] = toAdd;
			size++;
			return true;
		}
		
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		// check if null
		if (toAdd.equals(null)) {
			throw new NullPointerException("Cannot add null element");
		}

		if (size == data.length) {
			increaseCap(size + 1);
		}

		data[size++] = toAdd;
		return true;

	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// check if null
		if (toAdd.equals(null)) {
			throw new NullPointerException("Cannot add null elements");
		}
		
		//increase cap
		if (toAdd.size() + size > data.length) {
			increaseCap(size + toAdd.size());
		}
		MyIterator itr = (MyIterator) toAdd.iterator();
		
		while(itr.hasNext()) {
			data[size++] = (E) itr.next();
		}
		
		return true;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// check if index is out of bounds
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return data[index];
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		E x = data[index];

		if (index != --size) {
			System.arraycopy(data, index + 1, data, index, size - index);
		}

		data[size] = null;

		return x;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		if (toRemove.equals(null)) {
			throw new NullPointerException("Cant remove NUll");
		}

		
		int i = 0;
		MyIterator iterator = (MyIterator) iterator();
		
		while (iterator.hasNext()) {

			if (iterator.next().equals(toRemove)) {
				return remove(i);
			}

			i++;
		}

		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {

		// check index bound
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		// check if null
		if (toChange.equals(null)) {
			throw new NullPointerException("Cannot add null element");
		}

		E x = data[index];
		data[index] = toChange;

		return x;
	}

	@Override
	public boolean isEmpty() {
		if (this.size() == 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		
		for (int i = 0; i < size; i++) {
			if(toFind.equals(data[i])) {
				return true;
			}
		}
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length < size) {
			//make new instance of the holding array with this array's size
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
		} else if (toHold.length > size) {
			toHold[size] = null;
		}
		System.arraycopy(data, 0, toHold, 0, size);
		return toHold;
	}

	@Override
	public Object[] toArray() {
		E[] array = (E[]) new Object[size];
		System.arraycopy(data, 0, array, 0, size);
		return array;
	}
	
	@Override
	public Iterator<E> iterator() {
		MyIterator iterator = new MyIterator(data);
		return iterator;
	}

}
