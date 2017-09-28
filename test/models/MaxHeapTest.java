package models;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaxHeapTest {
	MaxHeap<String> heap;
	
	@Before
	public void setUp(){
		heap = new MaxHeap<String>();
	}

	@Test
	public void testAdd() {
		String first = "John";
		String second = "Jane";
		heap.add(second);
		assertEquals(heap.getSize(), 1);
		heap.add(first);
		assertEquals(heap.getSize(), 2);
	}
	
	@Test
	public void testGetMax() {
		String third = "Audi";
		String fourth = "BMW";
		String fifth = "Opel";
		String sixth = "Cnrysler";
		heap.add(fourth);
		heap.add(fifth);
		heap.add(sixth);
		heap.add(third);
		assertEquals(heap.getMax(), "Opel");
		}

	@Test
	public void testRemoveMax() {
		String third = "Audi";
		String fourth = "BMW";
		String fifth = "Opel";
		String sixth = "Chrysler";
		heap.add(fourth);
		heap.add(fifth);
		heap.add(sixth);
		heap.add(third);
		heap.removeMax();
		assertEquals(heap.getMax(), "Chrysler");
		assertEquals(heap.getSize(), 3);
		heap.removeMax();
		assertEquals(heap.getMax(), "BMW");
		assertEquals(heap.getSize(), 2);
		heap.removeMax();
		assertEquals(heap.getMax(), "Audi");
		assertEquals(heap.getSize(), 1);
	}
	
	@Test
	public void testIsEmpty() {
		String first = "John";
		assertTrue(heap.isEmpty());
		heap.add(first);
		assertFalse(heap.isEmpty());
	}
		
}