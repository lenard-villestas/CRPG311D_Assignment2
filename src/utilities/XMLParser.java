package utilities;

import exceptions.EmptyQueueException;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner; 
import utilities.*;

/**
 * 
 * @author Lenard
 * @version 1
 */
public class XMLParser {
	
		// Constants
		private static final String OPEN_TAG = "<";
		private static final String CLOSE_TAG = ">";
		private static final String END_TAG = "/";
		private static final String XML_OPEN = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		
		private File xml;
		private Scanner scan;
		
		// Attributes
		private MyStack<XMLTag> tagStack;
		private MyArrayList<String> xmlLines;
		private String fileName;
		
		/**
		 * method to read in the xml file to a MyArrayList of string object
		 * String per line of XML
		 */
		
		// Constructors
		public XMLParser(String fileName)
		{
			this.fileName = fileName;
			readFile();
		}
		
		
		
		
		public void readFile() {
			try {
			xml = new File(fileName);
			scan = new Scanner(xml);
			
			} catch (FileNotFoundException e) {
				System.out.println("Error: File not found");
				e.printStackTrace();
			}
			
			parse();
		}




		private void parse() {
			int lineCounter =0;
			String line = "";
			while (scan.hasNext()) {
				lineCounter++;
				
				line = scan.next().replaceAll(OPEN_TAG, "");
				line = scan.next().replaceAll(CLOSE_TAG, "");
				
				//check if open tags have closing tags
				//only one root tag
				//check if intercrossing
				//self closing tags
			}
			
		}
	

}
 