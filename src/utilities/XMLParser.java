package utilities;

import exceptions.EmptyQueueException;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import utilities.*;

/**
 * Class of XMLParser type, a utility class that aims to parse an XML files for error and print it
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

	// Attributess
	private MyStack<XMLTag> errorStack;
	private MyArrayList<String> xmlLines;
	private MyQueue<XMLTag> tagQueue;
	
	private String fileName;

	/**
	 *Default constructor of XML Parser that will invoke readFile
	 *@param String fileName
	 */
	public XMLParser(String fileName) {
		this.fileName = fileName;
		readFile();
	}
	
	/**
	 * Opens the specified file, then scans it with Scanner
	 */
	public void readFile() {
		try {
			xml = new File(fileName);
			scan = new Scanner(xml);
			System.out.println("File Loaded ..");
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
			e.printStackTrace();
		}

		parse();
	}
	/**
	 * This method intends to catch errors while parsing the xml file
	 */
	private void parse() {
		int counter = 0;
		String line = "";
		xmlLines = new MyArrayList<String>();
		tagQueue = new MyQueue<XMLTag>();
		errorStack = new MyStack<XMLTag>();
		
		// assign each lines to a string
		while (scan.hasNextLine()) {
			line = scan.nextLine();
		
			xmlLines.add(line);

		}
		
		//makes each xmlLines to a queue as xmlTags
		for (int i = 0; i< xmlLines.size(); i++) {
			line = xmlLines.get(i);
			
			if (charCounter(line,'<') >1 || charCounter(line,'>') > 1) {
				System.out.println("Error: " + line);
			}

			line.replaceAll(OPEN_TAG, "");
			line.replaceAll(CLOSE_TAG, "");
			
			String[] lineSplit = line.split(" ");
		}
		
		
		
		// check if open tags have closing tags
		// only one root tag
		// check if intercrossing
		// self closing tags

	}
	
	
	/**
	 * This method counts the occurence of a char in a string
	 * @param line
	 * @param toMatch
	 * @return int counter
	 */
	private int charCounter(String line, char toMatch) {
		int counter = 0;
		
		for(int i =0; i < line.length() -1; i++) {
			if (line.charAt(i) == toMatch) {
				counter++;
			}
		}
		
		return counter;
	}

}
