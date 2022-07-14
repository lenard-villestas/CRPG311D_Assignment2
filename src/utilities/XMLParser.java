package utilities;

import exceptions.EmptyQueueException;

import Utilities.MyArrayList;
import Utilities.MyQueue;
import Utilities.MyStack;

public class XMLParser {
	
	// Constants
		private static final char OPEN_TAG = '<';
		private static final char CLOSE_TAG = '>';
		private static final String END_TAG = "/";
		private static final String XML_OPEN = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		
		// Attributes
		private MyQueue<XMLTag> errorQue;
		private MyStack<XMLTag> tagStack;
		private MyQueue<XMLTag> extrasQue;
		private MyArrayList<String> xmlLines;
		private String fileName;
		
		/**
		 * method to read in the xml file to a MyArrayList of string object
		 * String per line of XML
		 */
		
		// Constructors
		public XMLParser(String fileName)
		{
			// TODO Auto-generated method stub
		}
		
	

}
