package utilities;
/**
 * Class for DLLNode used by myDLL to be used as elemen containers for a doubly linked list
 * @author Lenard, Group1
 *
 * @param <E>
 */
public class MyDLLNode<E> {
	E data;
	MyDLLNode next;
	MyDLLNode prev;
	
	/**
	 * Constructor of a DLL Node that will set the data
	 * @param data
	 */
	public MyDLLNode(E data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	/**
	 * get the data
	 * @return E data
	 */
	public E getData() {
		return data;
	}
	
	/**
	 * set the data
	 * @param E item
	 */
	public void setData (E item) {
		this.data = data;
	}
	
	/**
	 * get the previous node linked to this node
	 * @return prev
	 */
	public MyDLLNode getPrev() {
		return prev;
	}
	
	/**
	 * set the previous node
	 * @param myDLLNode prev
	 */
	public void setPrev (MyDLLNode prev) {
		this.prev = prev;
	}
	
	/**
	 * get the next node linked to this node
	 * @return next
	 */
	public MyDLLNode getNext() {
		return next;
	}
	
	/**
	 * set the next Node
	 * @param MyDLLNode next
	 */
	public void setNext (MyDLLNode next) {
		this.next = next;
	}
	
	/**
	 * check whether this node has a next node linked
	 * @return boolean
	 */
	public boolean hasNext() {
		return (this.next != null);
	}
	
	/**
	 * check whether this node has a previous node linked
	 * @return boolean
	 */
	public boolean hasPrev() {
		return (this.next != null);
	}
	
	@Override
	public boolean equals(Object e) {
		
		if (this.data.equals(e)) {
			return true;
		}
		
		return false;
	}
}
