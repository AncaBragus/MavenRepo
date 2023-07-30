package homeworkSE3;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import utils.BaseTest;


/*Scriem un script care trimite un mesaj din pagina de contact.
- Vom folosi doar CSS selectors pentru locatori
- url-ul paginii de contact : https://keybooks.ro/contacts/
-La final verificam (assert)daca ne apare textul Thank you for your message. It has been sent.
 */
public class ContactMessage extends BaseTest {
	
	@Test
	public void sendMesage() {
		try {
			driver.findElement(By.cssSelector("a[href*='contacts']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("input[name='your-name']")).sendKeys("My Name");
			driver.findElement(By.cssSelector("input[name='your-email']")).sendKeys("My_Name@gmail.com");
			driver.findElement(By.cssSelector("input[name='your-s']")).sendKeys("Homewrk3.1");
			driver.findElement(By.cssSelector("textarea[name='your-message']")).sendKeys("Testing Send Message");
			driver.findElement(By.cssSelector("input[type='submit'][value='Send Message']")).click();
			Thread.sleep(3000);
			String messageSent = driver.findElement(By.cssSelector("div[class*='response-output']")).getText();
			System.out.println(messageSent);	
			assertTrue(messageSent.contains("Thank you for your message. It has been sent."));
			
		}catch (Exception e) {
			System.out.println(e);
		}		
	}
}
