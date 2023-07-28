package curs17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.time.Duration;

import utils.BaseTest;

//https://the-internet.herokuapp.com/dynamic_loading/1
public class ImplicitWait extends BaseTest{
	@Test
	public void implicitWaitExample() throws InterruptedException {
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		//implicit wait
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.findElement(By.cssSelector("div[id='start']>button")).click();
		//Thread.sleep(8000);
		WebElement finish = driver.findElement(By.cssSelector("div[id='finish']>h4"));
		assertEquals(finish.getText(),"Hello World!");
	}
}
