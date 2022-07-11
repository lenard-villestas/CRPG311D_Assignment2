package exceptions;

public class EmptyQueueException extends Exception{
	public EmptyQueueException(String errorMessage) {
		super(errorMessage);
	}
	public EmptyQueueException() {
		System.out.println("Error: Queue is Empty");
	}
}
