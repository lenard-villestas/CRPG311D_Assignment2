package exceptions;

/**
 * Class exception that should be thrown if Queue is empty
 * @author Lenard
 *
 */
public class EmptyQueueException extends Exception{
	public EmptyQueueException(String errorMessage) {
		super(errorMessage);
	}
	public EmptyQueueException() {
		System.out.println("Error: Queue is Empty");
	}
}
