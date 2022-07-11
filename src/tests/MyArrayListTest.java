package tests;

import utilities.*;
import org.junit.*;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import utilities.MyArrayList;

public class MyArrayListTest {
	
	// Test objects
	private static MyArrayList<String> myList;
	private static MyArrayList<String> myList2;
	private String one;
	private String two;
	private String three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myList = new MyArrayList<String>();
		myList2 = new MyArrayList<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myList=null;
		myList2=null;
	}

	@Before
	public void setUp() throws Exception {
		myList = new MyArrayList<String>();
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
	public void test_isEmpty() {
		
		myList.add(0, one);
		myList.add(1, two);
		myList.add(2, three);
		myList.clear();
		
		boolean expected = true;
		boolean actual = myList.isEmpty();
		assertEquals(expected, actual);
	}
	
	@Test
	public void test_add() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		assertEquals(one,myList.get(0));
		assertEquals(three,myList.get(2));
	}
	
	@Test
	public void test_addIndex() {
		myList.add(one);
		myList.add(one);
		myList.add(one);
		myList.add(one);
		myList.add(one);
		myList.add(1,two);
		
		assertEquals(two,myList.get(1));
	}
	
	@Test
	public void test_addOverCapacity() {
		for (int i = 0; i < 100; i++) {
			String x = String.valueOf(i);
			myList.add(x);
		}
		
		assertEquals("99",myList.get(99));
		assertEquals(100,myList.size());
	}
	
	@Test
	public void test_size() {
		myList.add(one);
		myList.add(one);
		myList.add(one);
		
		assertEquals(3,myList.size());
	}
	
	@Test
	public void test_get() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		myList.add(one);
		myList.add(two);
		myList.add(three);
		
		assertEquals(three,myList.get(5));
	}
	
	@Test
	public void test_removeIndex() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		
		myList.remove(2);
		
		assertEquals(2,myList.size());
		assertEquals(two,myList.get(1));
	}
	
	@Test
	public void test_removeElement() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		
		
		myList.remove(two);
		assertEquals(2,myList.size());
		assertEquals(three,myList.get(1));
		
	}
	
	@Test
	public void test_set() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		
		assertEquals(three,myList.set(2, "four"));
		
		assertEquals("four",myList.get(2));
		
	}
	
	@Test
	public void test_addAll() {
		myList.add(one);
		myList.add(two);
		myList2.add("hello");
		myList2.add("hi");
		
		myList.addAll(myList2);
		
		assertEquals(4,myList.size());
		assertEquals("hi",myList.get(myList.size() - 1));
	}
	
	@Test
	public void test_toArray() {
		String[] arr = {one,two,three};
		myList.add(one);
		myList.add(two);
		myList.add(three);
		
		Object[] arr2 =  myList.toArray();
		
		assertEquals(arr,arr2);
	}
	@Test
	public void test_toArrayToExistingArray() {
		String[] arr = {one,two,three};
		myList.add(one);
		myList.add(one);
		myList.add(one);
		
		assertNotEquals(arr,myList);
		
		String[]arr2 = myList.toArray(arr);
		
		assertEquals(arr,arr2);
	}
	
	@Test
	public void test_contains() {
		myList.add(one);
		myList.add(two);
		myList.add(three);
		
		assertTrue(myList.contains(three));
		assertFalse(myList.contains("Five"));
	}
}
