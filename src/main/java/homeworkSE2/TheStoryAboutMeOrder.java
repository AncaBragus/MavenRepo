package homeworkSE2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import utils.BaseTest;

/*1. Cautam in search bar titlul cartii mentionate
-Dupa ce o gasim (atentie ca nu este pe prima pagina de rezultate!), vom da click pe ea 
-Pe pagina de produs verificam url ca este matching cu https://keybooks.ro/shop/the-story-about-me/
- apasam pe add to cart si verificam daca ne apare textul cu added to cart “The story about me” has been added to your cart.
-Dupa verificarea textului, apasam pe View Cart si validam ca ne duce pe URL : https://keybooks.ro/cart/
- De aici pentru ce se intampla in cart facem o metoda noua @Test
-In noua metoda @Test vom face update de cantitate pentru carte la 2
- Verificam mesajul dupa update
- Apasam pe Proceed to checkout
In noul screen verificam URL ca este egal cu :https://keybooks.ro/checkout/
u Verificam daca ne apare textul Biling details si Aditional information
*/

public class TheStoryAboutMeOrder extends BaseTest{

	@Test(priority=1)
	public void findTheStoyAboutMe() {
		try {
			driver.findElement(By.cssSelector("button[class*='search_submit'][title='Open search']")).click();
			driver.findElement(By.cssSelector("input[class='search_field']")).sendKeys("The story about me");
			driver.findElement(By.cssSelector("button[class*='search_submit'][title='Open search']")).click();
			String searchText = driver.findElement(By.cssSelector("span[class*='breadcrumbs_item current']")).getText();
			System.out.println(searchText);
			assertEquals(searchText,"Search: The story about me");
			driver.findElement(By.cssSelector("a[id*='viewmore']")).click();
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("a[id*='viewmore']")).click();
			Thread.sleep(1000);
			WebElement book = driver.findElement(By.cssSelector("article[class*='post_item'] > h4[class='post_title'] > a[href*='the-story-about-me']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", book);
			
			driver.findElement(By.cssSelector("article[class*='post_item'] > h4[class='post_title'] > a[href*='the-story-about-me']")).click();
			Thread.sleep(1000);
			String bookURL = driver.getCurrentUrl();
			assertEquals(bookURL,"https://keybooks.ro/shop/the-story-about-me/");
			
			driver.findElement(By.cssSelector("button[class*='single_add_to_cart']")).click();
			String messageCart = driver.findElement(By.cssSelector("div[class*='woocommerce-message']")).getText();
			System.out.println(messageCart);	
			assertTrue(messageCart.contains("“The story about me” has been added to your cart."));
			
			driver.findElement(By.cssSelector("div[class*='notices-wrapper'] a[href*='keybooks.ro/cart'][class*='button wc-forward']")).click();
			Thread.sleep(1000);

			String cartURL = driver.getCurrentUrl();
			assertEquals(cartURL,"https://keybooks.ro/cart/");
		}catch (Exception e) {
				System.out.println(e);
			}		
		}	
	
	@Test(priority=2)
	public void updateCart() {
		 
		 try {
			driver.findElement(By.cssSelector("input[class*='qty']")).clear();
			driver.findElement(By.cssSelector("input[class*='qty']")).sendKeys("2");
			Thread.sleep(1000);
			driver.findElement(By.cssSelector("button[name='update_cart']")).click();
			String messageCartUpdated = driver.findElement(By.cssSelector("div[class*='woocommerce-message']")).getText();	
			assertTrue(messageCartUpdated.contains("Cart updated."));
			Thread.sleep(1000);
			
			driver.findElement(By.cssSelector("a[href*='checkout'")).click();
			Thread.sleep(1000);
			String cartURL = driver.getCurrentUrl();
			assertEquals(cartURL,"https://keybooks.ro/checkout/");
			String bilInfo = driver.findElement(By.cssSelector("div[class*='woocommerce-billing'] > h3")).getText();	
			assertTrue(bilInfo.contains("Billing details"));
			String addInfo = driver.findElement(By.cssSelector("div[class*='woocommerce-additional'] > h3")).getText();	
			assertTrue(addInfo.contains("Additional information"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}

