package exceptions;

/**
 * Class exception for invalid values
 * @author Lenard
 *
 */
public class WrongValueException extends Exception{
	public WrongValueException(String error) {
		super(error);
	}
}
