package curs17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import utils.BaseTest;

//https://the-internet.herokuapp.com/dynamic_loading/2
public class ExplicitWait extends BaseTest{
	@Test
	public void implicitWaitExample() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		
		driver.findElement(By.cssSelector("div[id='start']>button")).click();
		
		WebDriverWait wait = new WebDriverWait (driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.textToBePresentInElementLocated
				(By.cssSelector("div[id='finish']>h4"),"Hello World!"));
		//Thread.sleep(8000);
		WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
		assertEquals(finish.getText(),"Hello World!");
	}
}
