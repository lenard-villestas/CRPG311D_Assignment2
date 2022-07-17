package utilities;

import java.lang.reflect.Array;

import exceptions.*;
/**
 * The class of type MyDLL with the methods to navigate through our custom DLL
 * @author Lenard, Group1
 *
 * @param <E>
 */
public class MyDLL<E> implements ListADT<E> {

	private int size;
	private MyIterator iterator;
	MyDLLNode head;
	MyDLLNode tail;
	
	/**
	 * Default constructor of an empty DLL where we set head, tail to null and size to 0
	 */
	public MyDLL() {

		head = null;
		tail = null;
		size = 0;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	@Override
	public void clear() {
		size = 0;
		head = null;
		tail = null;

	}

	/**
	 * Get the head of DLL
	 * @return the head
	 */
	public MyDLLNode getHead() {
		return head;
	}

	/**
	 * SET THE HEAD OF DLL
	 * @param head the head to set
	 */
	public void setHead(MyDLLNode head) {
		this.head = head;
	}

	/**
	 * get the tail of DLL
	 * @return the tail
	 */
	public MyDLLNode getTail() {
		return tail;
	}

	/**
	 * Set the tail of DLL
	 * @param tail the tail to set
	 */
	public void setTail(MyDLLNode tail) {
		this.tail = tail;
	}
	
	/**
	 * Psuedo Iterator to get to position in our DLL
	 * @param index
	 * @return MyDLLNode pointer, the node in the specified index
	 */
	public MyDLLNode getNodeIndex(int index) {

		int i = 0;
		if (index == 0) {
			return head;
		}
		if (index == size - 1) {
			return tail;
		}

		MyDLLNode pointer = head;

		for (i = 0; i < index; i++) {

			pointer = pointer.next;
		}

		return pointer;
	}

	/*
	 * add to index
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		MyDLLNode toAddNode = new MyDLLNode(toAdd);

		// check if index is out of bounds
		if (index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		// check if null
		if (toAdd.equals(null)) {
			throw new NullPointerException("Cannot add null element");
		}

		// if index is to be added as head
		if (index == 0 && size != 0) {
			MyDLLNode newNode = (MyDLLNode) toAddNode;
			MyDLLNode oldNode = this.head;
			newNode.setNext(oldNode);

			this.head = newNode;
			oldNode.setPrev(this.head);

			size++;
			return true;

		}

		// if node is to be added to last index
		if (index == size) {
			return add(toAdd);

		}

		// insert in the DLL using index
		if (index != size) {

			MyDLLNode oldNode = getNodeIndex(index);
			MyDLLNode newNode = toAddNode;
			MyDLLNode oldNextNode = oldNode.getNext();

			oldNextNode.setPrev(newNode);
			newNode.setNext(oldNextNode);
			newNode.setPrev(oldNode);

			oldNode.setNext(newNode);

			size++;
			return true;
		}

		return false;
	}

	/*
	 * adds a new node to tail position
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException {
		MyDLLNode toAddNode = new MyDLLNode(toAdd);

		// check if null
		if (toAdd.equals(null)) {
			throw new NullPointerException("Cannot add null element");
		}

		// add the first Node of the MyDll
		if (this.size == 0) {
			MyDLLNode newNode = toAddNode;

			this.tail = newNode;
			this.head = newNode;

			size++;
			return true;

		}

		// if size is not empty add to tail;
		if (this.size != 0) {
			MyDLLNode newNode = toAddNode;
			MyDLLNode oldNode = this.tail;

			oldNode.setNext(newNode);
			newNode.setPrev(oldNode);

			this.tail = newNode;

			size++;
			return true;

		}

		return false;
	}

	/*
	 * Iterates to an array while adding them to our DLL
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		// check if null
		if (toAdd.equals(null)) {
			throw new NullPointerException("Cannot add null elements");
		}

		MyIterator itr = (MyIterator) toAdd.iterator();

		while (itr.hasNext()) {
			add((E) itr.next());
		}

		return true;
	}

	// RETURN DATA OF THE NODE IN THIS INDEX
	@Override
	public E get(int index) throws IndexOutOfBoundsException {

		if (index > size) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		MyDLLNode temp = getNodeIndex(index);

		return (E) temp.getData();

	}

	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}

		// if index to be removed is last
		if (index == size) {
			MyDLLNode newNode = this.tail.getPrev();
			MyDLLNode oldNode = this.tail;

			newNode.setNext(null);
			this.tail = newNode;

			size--;
			return (E) oldNode;

		}
		// if index is to be removed is head
		if (index == 0) {
			MyDLLNode newNode = this.head.getNext();
			MyDLLNode oldNode = this.head;

			this.head = newNode;
			this.head.setPrev(null);

			size--;

			return (E) oldNode;

		}

		// remove from DLL using index
		if (index != size) {

			MyDLLNode oldNode = getNodeIndex(index);
			MyDLLNode newNextNode = oldNode.getNext();
			MyDLLNode newNodePrevious = oldNode.getPrev();

			newNodePrevious.setNext(newNextNode);
			newNextNode.setPrev(newNodePrevious);

			size--;
			return (E) oldNode;
		}

		return null;
	}

	/*
	 * remove node that contains this element E
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		MyDLLNode pointer = this.head;
		int index = 0;

		if (toRemove.equals(pointer.getData())) {
			return remove(index);
		}
		index++;
		pointer = pointer.getNext();

		while (pointer.hasNext()) {
			if (toRemove.equals(pointer.getData())) {
				return remove(index);
			}
			index++;
			pointer = pointer.getNext();
		}

		if (this.tail.getData().equals(toRemove)) {
			return remove(size - 1);
		}

		return null;
	}

	/*
	 * replaces the node data at the index position, will return the old data
	 */
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

		E x = get(index);

		add(index, toChange);
		remove(index - 1);

		return x;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (size == 0);
	}

	@Override
	public boolean contains(E toFind) throws NullPointerException {
		// check if null
		if (toFind.equals(null)) {
			throw new NullPointerException("Cannot add null element");
		}

		iterator();

		while (iterator.hasNext()) {
			if (iterator.next().equals(toFind)) {
				return true;
			}
		}

		return false;
	}

	/*
	 * returns the given array with the DLL's Nodes inside
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if (toHold.length < size) {
			// make new instance of the holding array with this array's size
			toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), size);
		}

		MyDLLNode pointer = head;
		int index = 0;

		while (index < this.size) {

			toHold[index] = (E) pointer.getData();
			index++;
			pointer = pointer.getNext();
		}

		return toHold;
	}

	/*
	 * put the elements in this DLL to an array
	 */
	@Override
	public Object[] toArray() {
		Object[] arr = new Object[size];

		MyDLLNode pointer = head;
		int index = 0;

		while (index < this.size) {

			arr[index] = pointer.getData();
			index++;
			pointer = pointer.getNext();
		}

		return arr;
	}

	@Override
	public Iterator<E> iterator() {
		MyDLLNode[] nodes = new MyDLLNode[this.size];
		int index = 0;
		MyDLLNode pointer = this.head;
		while (index < this.size) {

			nodes[index] = pointer;
			index++;
			pointer = pointer.getNext();
		}

		return iterator = new MyIterator(nodes);
	}

}
