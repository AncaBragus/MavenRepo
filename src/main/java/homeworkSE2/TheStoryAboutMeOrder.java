package homeworkSE2;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

/*1. Cautam in search bar titlul cartii mentionate
-Dupa ce o gasim (atentie ca nu este pe prima pagina de rezultate!), vom da click pe ea 
-Pe pagina de produs verificam url ca este matching cu https://keybooks.ro/shop/the-story-about-me/
- apasam pe add to cart si verificam daca ne apare textul cu added to cart
*/

public class TheStoryAboutMeOrder extends BaseTest{

	@Test
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
			Thread.sleep(2000);
			WebElement book = driver.findElement(By.cssSelector("article[class*='post_item'] > h4[class='post_title'] > a[href*='the-story-about-me']"));
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", book);
			Thread.sleep(2000);
			driver.findElement(By.cssSelector("article[class*='post_item'] > h4[class='post_title'] > a[href*='the-story-about-me']")).click();
			String bookURL = driver.getCurrentUrl();
			assertEquals(bookURL,"https://keybooks.ro/shop/the-story-about-me/");
			driver.findElement(By.cssSelector("button[class*='single_add_to_cart']")).click();
			String messageCart = driver.findElement(By.cssSelector("div[class*='woocommerce-message']")).getText();
			System.out.println(messageCart);	
			assertTrue(messageCart.contains("“The story about me” has been added to your cart."));
			
		}catch (Exception e) {
				System.out.println(e);
			}		
		}	
	}


