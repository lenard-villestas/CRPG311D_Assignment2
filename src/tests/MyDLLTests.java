package tests;

import utilities.*;
import org.junit.*;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.MyDLL;

/**
 * JUnit test set for DLL implementation
 * @author Lenard
 *
 */
public class MyDLLTests {
	
	// Test objects
	private static MyDLL<String> myDLL;
	private static MyDLL<String> myDLL2;
	private String one;
	private String two;
	private String three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myDLL = new MyDLL<String>();
		myDLL2 = new MyDLL<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myDLL = null;
		myDLL2 = null;
	}

	@Before
	public void setUp() throws Exception {
		myDLL = new MyDLL<String>();
		myDLL2 = new MyDLL<String>();
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
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		assertEquals(3, myDLL.size());
		myDLL.clear();
		assertEquals(0, myDLL.size());
	}

	@Test
	public void test_isEmpty() {
		
		myDLL.add(0, one);
		myDLL.add(1, two);
		myDLL.add(2, three);
		myDLL.clear();
		
		boolean expected = true;
		boolean actual = myDLL.isEmpty();
		assertEquals(expected, actual);
	}
	
	
	@Test
	public void test_add() {
		myDLL.add(0,one);
		myDLL.add(1,two);
		myDLL.add(2,two);
		myDLL.add(3,three);
		
		
		assertEquals(4,myDLL.size());
		
		assertEquals(three,myDLL.get(3));
		
	
	}
	
	
	@Test
	public void test_addIndex() {		
		myDLL.add(0, one);
		assertEquals(one, myDLL.get(0));
		myDLL.add(1, two);
		assertEquals(two, myDLL.get(1));
		myDLL.add(2, three);
		assertEquals(three, myDLL.get(2));
	}
	
	
	@Test
	public void test_head() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		assertEquals(one,myDLL.getHead().getData());
	}
	
	@Test
	public void test_tail() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		assertEquals(three,myDLL.getTail().getData());
		
		myDLL.add(3, "four");
		assertEquals("four",myDLL.getTail().getData());
	}
	
	@Test
	public void test_size() {
		myDLL.add(one);
		myDLL.add(one);
		myDLL.add(one);
		
		assertEquals(3,myDLL.size());
	}
	
	@Test
	public void test_get() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		assertEquals(three,myDLL.get(5));
	}
	
	@Test
	public void test_removeIndex() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		myDLL.remove("two");
		
		assertEquals(2,myDLL.size());
		assertEquals(three,myDLL.get(1));
	}
	
	@Test
	public void test_removeElement() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		
		myDLL.remove(two);
		assertEquals(2,myDLL.size());
		assertEquals(three,myDLL.get(1));
		
	}
	
	@Test
	public void test_set() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		
		myDLL.set(1, one);
		
		assertEquals(one,myDLL.get(1));
		
	}
	
	@Test
	public void test_getNodeIndex() {
		myDLL.add(0,one);
		myDLL.add(1,two);
		myDLL.add(2,three);
		myDLL.add(3,three);
		myDLL.add(4,"four");
		
		
		assertEquals(5,myDLL.size());
		assertEquals("four",myDLL.getNodeIndex(4).getData());
		
	}

	
	@Test
	public void test_toArray() {
		String[] arr = {one,two,three};
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		Object[] arr2 =  myDLL.toArray();
		
		assertEquals(arr,arr2);
	}
	@Test
	public void test_toArrayToExistingArray() {
		String[] arr = {one,two,three};
		myDLL.add(one);
		myDLL.add(one);
		myDLL.add(one);
		
		assertNotEquals(arr,myDLL);
		
		String[]arr2 = myDLL.toArray(arr);
		
		assertEquals(arr,arr2);
	}
	
	@Test
	public void test_contains() {
		myDLL.add(one);
		myDLL.add(two);
		myDLL.add(three);
		
		assertTrue(myDLL.contains(three));
		assertFalse(myDLL.contains("Five"));
	}
	
}
