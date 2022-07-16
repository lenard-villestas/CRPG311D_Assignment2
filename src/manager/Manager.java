/**
 * 
 */
package manager;

import utilities.XMLParser;

/**
 * @author Lenard
 *
 */
public class Manager {
	
	XMLParser xp;
	
	
	public Manager(String filePath) {
		
		xp = new XMLParser(filePath);
	}
	
	
	
}
