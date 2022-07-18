/**
 * 
 */
package driver;
import manager.Manager;

/**
 * AppDriver Class where our main method is, this starts the program
 * @author Lenard
 *
 */
public class AppDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("ERROR: Please specify a file path (Just One)");
			System.exit(0);
		}
		if (args[0].equals(null) || args[0].equals("") ) {
			System.out.println("ERROR: File Path is NULL");
			System.exit(0);
		}
		
		String filePath = args[0];
		
		new Manager(filePath);
	}

}
