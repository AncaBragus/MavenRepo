package curs13;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

public class AssertionExamples {
/* verificare
 * assertEquals arunc sie exceptie
 */
	
	String actualTitle ="Test";
	String expectedTitle ="TEST";
	
	@Test
	public void checkEquality(){
		if (actualTitle.equals(actualTitle)) {
			System.out.println("Passed");
		}else {
			System.out.println("Failed");
		}
	}
	
	@Test
	public void checkStringQuality() {
		assertEquals(actualTitle,expectedTitle);
		//java.lang.AssertionError: expected [TEst] but found [Test]
	}
		
	}
	
