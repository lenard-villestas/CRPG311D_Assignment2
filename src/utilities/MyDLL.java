package utilities;
import exceptions.*;

public class MyDLL<E> implements ListADT<E>{
	
	private int size;
	private MyIterator iterator;
	MyDLLNode head;
	MyDLLNode tail;

	public MyDLL() {
		
		head = null;
		tail = null;
		size = 0;
	}

	public int size() {
		MyDLLNode nodeIndex = head;
		while (nodeIndex.next != null) {
			nodeIndex = nodeIndex.next;
			size++;
		}
		return size;
	}

	public void clear() {
		size = 0;
		head = null;
		tail = null;
		
	}

	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean add(E toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E remove(E toRemove) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	


}
