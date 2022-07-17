package utilities;

public class MyDLLNode<E> {
	E data;
	MyDLLNode next;
	MyDLLNode prev;
	
	public MyDLLNode(E data) {
		this.data = data;
		this.next = null;
		this.prev = null;
	}
	
	public E getData() {
		return data;
	}
	
	public void setData (E item) {
		this.data = data;
	}
	
	public MyDLLNode getPrev() {
		return prev;
	}
	
	public void setPrev (MyDLLNode prev) {
		this.prev = prev;
	}
	
	public MyDLLNode getNext() {
		return next;
	}
	
	public void setNext (MyDLLNode next) {
		this.next = next;
	}

}
