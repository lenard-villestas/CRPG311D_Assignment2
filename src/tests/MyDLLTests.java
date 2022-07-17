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

public class MyDLLTests {
	
	// Test objects
	private static MyDLL<String> myNode;
	private static MyDLL<String> myNode2;
	private String one;
	private String two;
	private String three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myNode = new MyDLL<String>();
		myNode2 = new MyDLL<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myNode = null;
		myNode2 = null;
	}

	@Before
	public void setUp() throws Exception {
		myNode = new MyDLL<String>();
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
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		assertEquals(3, myNode.size());
		myNode.clear();
		assertEquals(0, myNode.size());
	}

	@Test
	public void test_isEmpty() {
		
		myNode.add(0, one);
		myNode.add(1, two);
		myNode.add(2, three);
		myNode.clear();
		
		boolean expected = true;
		boolean actual = myNode.isEmpty();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_add() {
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		assertEquals(one,myNode.get(0));
		assertEquals(three,myNode.get(2));
	}
	
//	@Test
//	public void test_addAll() {
//		List<String> array = new ArrayList<String>();
//		array.add(one);
//		array.add(two);
//		array.add(three);
//		myNode.addAll(array);
//		assertEquals(one, myNode.get(0));
//		assertEquals(two, myNode.get(1));
//		assertEquals(three, myNode.get(2));
//	}
	
	@Test
	public void test_addIndex() {		
		assertEquals(0, myNode.size());
		myNode.add(0, one);
		assertEquals(one, myNode.get(0));
		myNode.add(1, two);
		assertEquals(two, myNode.get(1));
		myNode.add(2, three);
		assertEquals(three, myNode.get(2));
	}
	
	@Test
	public void test_addOverCapacity() {
		for (int i = 0; i < 100; i++) {
			String x = String.valueOf(i);
			myNode.add(x);
		}
		
		assertEquals("99",myNode.get(99));
		assertEquals(100,myNode.size());
	}
	
	@Test
	public void test_size() {
		myNode.add(one);
		myNode.add(one);
		myNode.add(one);
		
		assertEquals(3,myNode.size());
	}
	
	@Test
	public void test_get() {
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		
		assertEquals(three,myNode.get(5));
	}
	
	@Test
	public void test_removeIndex() {
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		
		myNode.remove(2);
		
		assertEquals(2,myNode.size());
		assertEquals(two,myNode.get(1));
	}
	
	@Test
	public void test_removeElement() {
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		
		
		myNode.remove(two);
		assertEquals(two,myNode.size());
		assertEquals(three,myNode.get(1));
		
	}
	
	@Test
	public void test_set() {
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		myNode.set(1, two);
		
		assertEquals(three,myNode.set(2, "four"));
		
		assertEquals("four",myNode.get(2));
		
	}

	
	@Test
	public void test_toArray() {
		String[] arr = {one,two,three};
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		
		Object[] arr2 =  myNode.toArray();
		
		assertEquals(arr,arr2);
	}
	@Test
	public void test_toArrayToExistingArray() {
		String[] arr = {one,two,three};
		myNode.add(one);
		myNode.add(one);
		myNode.add(one);
		
		assertNotEquals(arr,myNode);
		
		int[]arr2 = myNode.toArray(arr);
		
		assertEquals(arr,arr2);
	}
	
	@Test
	public void test_contains() {
		myNode.add(one);
		myNode.add(two);
		myNode.add(three);
		
		assertTrue(myNode.contains(three));
		assertFalse(myNode.contains("Five"));
	}
}
