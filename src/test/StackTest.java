package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import stack_Linny.LinnyStack;

class StackTest {

	private LinnyStack<String> stack;
	
	void stage1() {
		stack = new LinnyStack<>();
		stack.linnyPush("Hola");
		stack.linnyPush("Hello");
		stack.linnyPush("Arigato");
		stack.linnyPush("Sayonara");
		stack.linnyPush("Bye");
		stack.linnyPush("Ciao");
	}
	
	void stage2() {
		stack = new LinnyStack<>();
		stack.linnyPush("Hola");
		stack.linnyPush("Hello");
		stack.linnyPush("Arigato");
		stack.linnyPush("Te quiero yo");
		stack.linnyPush("y tú a mi");
		stack.linnyPush("nuestra amistad");
		stack.linnyPush("es lo mejor");
	}
	@Test
	public void pushTest() {
		stage1();
		int s = stack.linnySize();
		stack.linnyPush("Bebecita");
		stack.linnyPush("Brrrr");
		int sf = stack.linnySize();
		assertTrue(s < sf);
	}
	
	@Test
	public void peekTest() {
		stage1();
		
		stack.linnyPop();
		stack.linnyPop();
		stack.linnyPop();
		
		String s = stack.linnyPeek();
		
		assertEquals(s, "Arigato");
	}
	
	@Test
	public void popTest() {
		stage2();
		
		String s = stack.linnyPop();
		
		assertEquals(s, "es lo mejor");
	}
	
	@Test
	public void isEmptyTest() {
		stage2();
		
		int t = stack.linnySize();
		
		for(int i = 0; i < t; i++) {
			stack.linnyPop();
		}
		
		boolean e = stack.isEmpty();
		
		assertTrue(e);
	}

}
