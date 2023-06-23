package curs13;

import org.testng.annotations.Test;

/*
 * @Test la nivel de clasa sau la nivel de metoda
 * la nivel de clasa e pune rar, cnd sunt multe metode, smoke test,
 * daca o metoda e privata nu o ruleaza cand @Test e pusa la clasa
 */

@Test
public class TestAnnotation {
	 	
	//@Test
	public void test1() {
		System.out.println("Test 1");
	}

	
	//@Test
	public void test2() {
		System.out.println("Test 2");
	}
	
	@Test
	public void test3() {
		System.out.println("Test 3");
	}
}
