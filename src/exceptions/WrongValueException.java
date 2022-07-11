package exceptions;

public class WrongValueException extends Exception{
	public WrongValueException(String error) {
		super(error);
	}
}
