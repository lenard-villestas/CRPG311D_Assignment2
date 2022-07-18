package tests;

import static org.junit.Assert.assertTrue;

import org.junit.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;

import exceptions.EmptyQueueException;
import utilities.*;

/**
 * JUnit test set for Queue implementation
 * 
 * @author Lenard,Group1
 *
 */
public class MyQueueTests {

	// Test objects
	private static MyQueue<String> myQueue;
	private static MyQueue<String> myQueue2;
	private String one;
	private String two;
	private String three;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		myQueue = new MyQueue<String>();
		myQueue2 = new MyQueue<String>();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		myQueue = null;
		myQueue2 = null;
	}

	@Before
	public void setUp() throws Exception {
		one = "one";
		two = "two";
		three = "three";
	}

	@After
	public void tearDown() throws Exception {
		one = null;
		two = null;
		three = null;
		myQueue.dequeueAll();
		myQueue2.dequeueAll();
	}

	@Test
	public void test_isEmpty() {
		assertTrue(myQueue.isEmpty());
		myQueue.enqueue(one);
		myQueue.dequeueAll();
		assertTrue(myQueue.isEmpty());
	}

	@Test
	public void test_size() {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		assertEquals(3, myQueue.size());
	}

	@Test
	public void test_enqueue() throws EmptyQueueException {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		assertEquals(3, myQueue.size());

		assertEquals(one, myQueue.peek());

	}

	@Test
	public void test_dequeueAll() {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		myQueue.dequeueAll();

		assertEquals(0, myQueue.size());
		assertTrue(myQueue.isEmpty());
	}

	@Test
	public void test_dequeue() throws EmptyQueueException {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);

		myQueue.dequeue();
		assertEquals(two, myQueue.peek());
		myQueue.dequeue();
		assertEquals(three, myQueue.peek());
		assertEquals(1, myQueue.size());
	}

	@Test
	public void test_capacity() {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		
		myQueue.setCapacity(3);
		assertEquals(3, myQueue.getCapacity());
		
	}
	@Test
	public void test_isFull() {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		
		myQueue.setCapacity(3);
		assertTrue( myQueue.isFull());
	}

	@Test
	public void test_peek() throws EmptyQueueException {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		assertEquals(one, myQueue.peek());
		myQueue.dequeue();
		assertEquals(two, myQueue.peek());
	}
	
	@Test
	public void test_toArray() {
		String[] arr = {one,two,three};
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		
		Object[] arr2 =  myQueue.toArray();
		
		assertEquals(arr,arr2);
	}
	
	@Test
	public void test_toArrayToExistingArray() {
		String[] arr = {one,two,three};
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		
		assertNotEquals(arr,myQueue);
		
		String[]arr2 = myQueue.toArray(arr);
		
		assertEquals(arr,arr2);
	}
	
	@Test
	public void test_equals() {
		myQueue.enqueue(one);
		myQueue.enqueue(two);
		myQueue.enqueue(three);
		
		myQueue2.enqueue(one);
		myQueue2.enqueue(two);
		myQueue2.enqueue(three);
		
		assertTrue(myQueue.equals(myQueue2));
		
	}
	

}
