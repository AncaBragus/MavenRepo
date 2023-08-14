package homeworkSE4_c17;
import static org.testng.Assert.assertEquals;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import utils.BaseTest;

public class TheWickedKing extends BaseTest{
	
	@Test
	public void findKing() throws InterruptedException {

	try {
		driver.findElement(By.cssSelector("button[class*='search_submit'][title='Open search']")).click();
		driver.findElement(By.cssSelector("input[class='search_field']")).sendKeys("king");
		driver.findElement(By.cssSelector("div[class='search_results_content'] h6>a[href*='wicked-king']")).click();
		
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
				(By.cssSelector("div[class='summary entry-summary']> h1[class='product_title entry-title']"),"The Wicked King"));
		
		String bookURL = driver.getCurrentUrl();
		System.out.println(bookURL);
		assertEquals(bookURL,"https://keybooks.ro/shop/the-wicked-king/");
		
		//String categoryText = driver.findElement(By.cssSelector("div[class='product_meta'] a[rel='tag']")).getText();
		
		WebElement categoryTextRelative = driver.findElement(RelativeLocator.with(By.cssSelector("a[rel='tag']")).
				  below(By.cssSelector("form[class='cart']")));
		System.out.println(categoryTextRelative.getText());
		assertEquals(categoryTextRelative.getText(),"New releases");
			
		String productId = driver.findElement(By.cssSelector("div[class='product_meta']>span[class='product_id']>span")).getText();
		System.out.println(productId);
		assertEquals(productId,"1709");
		
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("div[class*='gallery']>ol>li>img[src*='TheWickedKing1'][src$='png']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("div[class*='gallery']>ol>li>img[src*='TheWickedKing2'][src$='png']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("div[class*='gallery']>ol>li>img[src*='TheWickedKing3'][src$='png']")));
		wait.until(ExpectedConditions.visibilityOfElementLocated
				(By.cssSelector("div[class*='gallery']>ol>li>img[src*='TheWickedKing4'][src$='png']")));
				
	}catch (Exception e) {
		System.out.println(e);
	}		
}
}
