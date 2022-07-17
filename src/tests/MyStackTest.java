package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.MyArrayList;
import utilities.*;
import org.junit.*;

public class MyStackTest {
	// Test objects
	private static MyStack<String> myStack;
	private String one;
	private String two;
	private String three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myStack = new MyStack<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myStack=null;
	}

	@Before
	public void setUp() throws Exception {
		myStack = new MyStack<String>();
		one = "one";
		two = "two";
		three = "three";
	}

	@After
	public void tearDown() throws Exception {
		one = null;
		two = null;
		three = null;
	}

	@Test
	public void test_clear() {
		
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		myStack.clear();
		
		boolean expected = true;
		boolean actual = myStack.isEmpty();
		assertEquals(expected, actual);
	}
	@Test
	public void test_isEmpty() {
		
		
		assertEquals(true, myStack.isEmpty());
	}
	
	@Test
	public void test_push() {
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		myStack.peek();
	}
	
	
	@Test
	public void test_dynamicSize() {
		for (int i = 0; i < 100; i++) {
			String x = String.valueOf(i);
			myStack.push(x);
		}
		

		assertEquals(100,myStack.size());
		assertEquals("99",myStack.peek());
	}
	
	@Test
	public void test_size() {
		myStack.push(one);
		myStack.push(one);
		myStack.push(one);
		
		assertEquals(3,myStack.size());
	}
	
	@Test
	public void test_peek() {
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		
		assertEquals(three,myStack.peek());
	}
	
	
	@Test
	public void test_pop() {
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		
		
		myStack.pop();
		assertEquals(2,myStack.size());
		assertEquals(two,myStack.peek());
		
	}

	@Test
	public void test_toArray() {
		String[] arr = {one,two,three};
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		
		Object[] arr2 =  myStack.toArray();
		
		assertEquals(arr,arr2);
	}
	@Test
	public void test_toArrayToExistingArray() {
		String[] arr = {one,two,three};
		myStack.push(one);
		myStack.push(one);
		myStack.push(one);
		
		assertNotEquals(arr,myStack);
		
		String[]arr2 = myStack.toArray(arr);
		
		assertEquals(arr,arr2);
	}
	
	@Test
	public void test_contains() {
		myStack.push(one);
		myStack.push(two);
		myStack.push(three);
		
		assertTrue(myStack.contains(three));
		assertFalse(myStack.contains("Five"));
	}
}
