package curs13;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestDependencies {

	@Test
	public void  method1() {
		assertTrue(false);
		System.out.println("M1");
	}
	
	@Test(dependsOnMethods = "method1")
	public void  method2() {
		System.out.println("M2");
	}
	
	@Test(dependsOnMethods = "method2", alwaysRun = true ) // nu face sens aici ..// as putea  pune priority =2 ca ar avea sens
	public void  method3() {
		System.out.println("M3");
	}
	//TestNG nu are o verficare/validare cross parameters
}
