package curs13;

import static org.testng.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class BeforeAfterAnnotations {

	@BeforeSuite
	public void beforeSuite() {
		assertTrue(false);
		System.out.println("Before Suite");
	}
	@AfterSuite
	public void afterSuite() {
		System.out.println("After Suite");
	}
	
	@BeforeClass
	public void beforeClass() {
		System.out.println("Before Class");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("After Class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("Before Method");
	}
	@AfterMethod
	public void afterMethod() {
		System.out.println("After Method");
	}
	
	@Test
	public void method1() {
		System.out.println("Method 1");
	}
	@Test
	public void method2() {
		System.out.println("Method 2");
	}
	
}
