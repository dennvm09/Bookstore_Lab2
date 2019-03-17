package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import hash_Linny.HashTableLinny;

class HashTableTest {

	
	private HashTableLinny<Integer, String> hash;
	
	
	void stage1() {
		
		hash = new HashTableLinny<>();
		
		hash.insert(2, "Valentina");
		hash.insert(5, "Fanny");
		hash.insert(3, "Daniel");
		hash.insert(7, "Luis");
		hash.insert(23,"Chris");
		hash.insert(4, "Camilo");
	}
	

	void stage2() {
		hash = new HashTableLinny<>();
		
		hash.insert(50, "Valentina");
		hash.insert(5, "Fanny");
		hash.insert(32, "Daniel");
		hash.insert(7, "Luis");
		hash.insert(23,"Chris");
		hash.insert(5, "Camilo");
		hash.insert(6, "Holalala");
		hash.insert(11, "Que mira");
	}
	
	@Test
	public void searchTest() {
		stage1();
		String v = hash.search(23).getValue();
		assertEquals(v, "Chris");
	}
	
	@Test
	public void removeTest() {
		stage1();
		hash.remove(4, "Camilo");
		boolean isthere = hash.contains(4);
		assertFalse(isthere);	
	}

	@Test
	public void getSlotTest() {
		stage1();
		int slot = hash.getSlot(5);
		
		assertEquals(slot,5);
	}
	
	@Test 
	public void isEmptyTest() {
		stage1();
		boolean empty = hash.isEmpty();
		assertFalse(empty);
	}

	@Test
	public void contaTest() {
		stage2();
		hash.remove(50, "Valentina");
		boolean isthere = hash.contains(50);
		assertFalse(isthere);
	}
	
	@Test 
	public void removeTest2() {
		stage2();
		hash.remove(11, "Que mira");
		
	}
	
}
