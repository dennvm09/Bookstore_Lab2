package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import queue_Linny.LinnyQueue;

class QueueTest {

	private LinnyQueue<String> queue;
	
	
	void stage1() {
		queue = new LinnyQueue<>();
		
		queue.linnyOffer("Daniela");
		queue.linnyOffer("Julián");
		queue.linnyOffer("Adiós");
		queue.linnyOffer("Amor");
	}
	
	void stage2() {
		queue = new LinnyQueue<>();
		
		queue.linnyOffer("Daniela");
		queue.linnyOffer("Julián");
		queue.linnyOffer("Adiós");
		queue.linnyOffer("Amor");
		queue.linnyOffer("Me voy");
		queue.linnyOffer("De ti");
	}
	
	@Test
	public void offerTest() {
		stage1();
		assertEquals(queue.linnyPeek(), "Daniela");
		assertNotNull(queue);
	}
	
	@Test
	public void peekTest() {
		stage1();
		queue.linnyPoll();
		String h = queue.linnyPeek();
		assertEquals(h, "Julián");
	}
	
	@Test
	public void isEmptyTest() {
		stage2();
		int size = queue.linnySize();
		
		for(int i = 0; i < size; i++) {
			System.out.println(queue.linnyPoll());
		}
		boolean n = queue.isEmpty();
		assertTrue(n);
	}
	
	@Test
	public void pollTest() {
		stage1();
		int size = queue.linnySize();
		
		queue.linnyPoll();
		queue.linnyPoll();
		
		assertNotEquals(size, queue.linnySize());
	}
	
	
	

}
