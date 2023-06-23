package curs13;

import org.testng.annotations.Test;

public class TestPriority {

	/* ordinea este by default a numelui metodelor!!!
	 * afiseaza alfabetic: 
	    First
		Third
		Second
	 * din acest motiv se foloseste priority in fct de necesitate
	 */
	
	@Test (priority=1)
	public void one() {
	System.out.println("First");
	}
	
	@Test(priority=2)
	public void two() {
	System.out.println("Second");
	}
	
	@Test(priority=3)
	public void three() {
	System.out.println("Third");
	}
	
	@Test
	public void four() {
	System.out.println("Fourh");
	}
	@Test
	public void five() {
	System.out.println("Five");
	}
}
