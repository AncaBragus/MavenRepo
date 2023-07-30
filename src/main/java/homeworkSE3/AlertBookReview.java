package homeworkSE3;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

/*Scriem un script care are urmatorii pasi Folosim doar css selectors:
-Deschide keybooks.ro
-Deschide pagina unei carti (oricare)
-In partea de jos a paginii deschide sectiunea de Review
-Assert pe checkbox ca nu este selectat
-Apasam pe butonul Submit si tratam Alerta JS care apare
-Completam toate detaliile din review 
-Assert pe checkbox ca este este selectat
-Apas Submit
-Facem assert ca ne apare textul : “Your review is awaiting approval"
 */
public class AlertBookReview extends BaseTest {
	
	@Test
	public void sendMesage() {
		try {
			driver.findElement(By.cssSelector("h3[class*='sc_title'] > a[href = 'the-son']")).click();
			Thread.sleep(1000);
			String bookURL = driver.getCurrentUrl();
			assertEquals(bookURL,"https://keybooks.ro/shop/the-son/");
			driver.findElement(By.cssSelector("li[class*='reviews'] > a[href = '#tab-reviews']")).click();
			Thread.sleep(1000);
			
			WebElement checkbox = driver.findElement(By.cssSelector("input[name*='cookies-consent']"));
			assertFalse(checkbox.isSelected());
			
			driver.findElement(By.cssSelector("input[name='submit']")).click();
			Thread.sleep(1000);
			
			System.out.println(driver.switchTo (). alert (). getText ());
			driver.switchTo (). alert (). accept (); 
			
			driver.findElement(By.cssSelector("a[class='star-3']")).click();
			driver.findElement(By.cssSelector("textarea[name='comment']")).sendKeys("My review for The Son");
			driver.findElement(By.cssSelector("input[name='author']")).sendKeys("My Name");
			driver.findElement(By.cssSelector("input[name='email']")).sendKeys("My_Name@gmail.com");
			
			driver.findElement(By.cssSelector("input[name*='cookies-consent']")).click();
			WebElement checkbox1 = driver.findElement(By.cssSelector("input[name*='cookies-consent']"));
			assertTrue(checkbox1.isSelected());
			driver.findElement(By.cssSelector("input[name='submit']")).click();
			Thread.sleep(1000);
			
			String messageDisplayed = driver.findElement(By.cssSelector("em[class*='awaiting-approval']")).getText();	
			assertTrue(messageDisplayed.contains("Your review is awaiting approval"));
			
			
		}catch (Exception e) {
			System.out.println(e);
}		
}
}