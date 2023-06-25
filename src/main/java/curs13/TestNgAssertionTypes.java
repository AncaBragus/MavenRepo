package curs13;

import org.testng.annotations.Test;
import static org.testng.Assert.*;
import org.testng.asserts.SoftAssert;

public class TestNgAssertionTypes{
	
	//@Test
	public void softAssertExample(){
		//nu se face stop
		System.out.println("Soft Assert incepe aici");
		SoftAssert sa = new SoftAssert();
	//	sa.equals("123", "abc");
		sa.assertTrue(false);
		System.out.println("Soft Assert incepe aici");
		//sa.assertAll;
	}
	
	@Test
	public void hardAssertExample() {
		// se face exit din metoda; se face stop
		System.out.println("Hard Assert incepe aici");
		assertEquals("123", "abc");
		System.out.println("Hard Assert cntinua aici");
		assertTrue(false);
		System.out.println("Hard Assert se opreste aici");
	}
	 
	
}
