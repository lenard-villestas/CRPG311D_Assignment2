/**
 * 
 */
package manager;

import utilities.XMLParser;

/**
 * Manager class for invoking functions
 * @author Lenard
 *
 */
public class Manager {
	
	XMLParser xp;
	
	
	public Manager(String filePath) {
		
		xp = new XMLParser(filePath);
	}
	
	
	
}
