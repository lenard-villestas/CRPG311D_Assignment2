package utilities;

import exceptions.*;

/**
 * Class of MyQueue Type which implements QueueADT and uses myDLL
 * @author Lenard
 *
 * @param <E>
 */
public class MyQueue<E> implements QueueADT<E> {
	MyDLL myDll = new MyDLL();
	int capacity;
	
	/**
	 * default constructor for an empty queue without capacity
	 */
	public MyQueue() {

	}
	
	/**
	 * constructor for a queue with defined capacity
	 * @param cap
	 */
	public MyQueue(int cap) {
		this.capacity = cap;
	}

	/**
	 * @return the capacity
	 */
	public int getCapacity() {
		return capacity;
	}

	/**
	 * @param capacity the capacity to set
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		myDll.add(toAdd);

	}

	@Override
	public E dequeue() throws EmptyQueueException {
		// TODO Auto-generated method stub
		if (myDll.size() == 0) {
			throw new EmptyQueueException();
		}
		return (E) myDll.remove(0);

	}

	@Override
	public E peek() throws EmptyQueueException {
		// TODO Auto-generated method stub
		return (E) myDll.get(0);
	}

	@Override
	public void dequeueAll() {
		myDll.clear();

	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return myDll.isEmpty();
	}

	@Override
	public Iterator<E> iterator() {
		return myDll.iterator();
	}

	@Override
	public boolean equals(QueueADT<E> that){
		Object[] arr1 = this.toArray();
		Object[] arr2 = that.toArray();
		if (arr1.length != arr2.length) {
			return false;
		}
		for (int i =0; i< arr1.length; i++) {
			if(arr1[i] != arr2[i]) {
				return false;
			}
		}
		
		return true;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return myDll.toArray();
	}

	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		// TODO Auto-generated method stub
		return (E[]) myDll.toArray(holder);
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		return (myDll.size() == this.capacity);
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return myDll.size();
	}

}
