package curs17;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

import utils.BaseTest;

public class RelativeLocatorsExample extends BaseTest {
	
	@Test
	public void relativeLocatorsTest() {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		//RelativeLocator
		WebElement price10__20 = driver.findElement(RelativeLocator.with
				(By.cssSelector("h3[class*='sc_title']")).
				toLeftOf(By.cssSelector("a[href='life-in-the-garden']")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", price10__20);
	
		//RelativeLocator
		WebElement price2 = driver.findElement(RelativeLocator.with
				(By.cssSelector("h3[class*='sc_title']")).
				toRightOf(By.cssSelector("a[href='life-in-the-garden']")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", price2);
	

		//RelativeLocator
		WebElement price3 = driver.findElement(RelativeLocator.with
				(By.cssSelector("h3[class*='sc_title']")).
				above(By.cssSelector("a[href='life-in-the-garden']")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", price3);
	
		//RelativeLocator
		WebElement title = driver.findElement(RelativeLocator.with
				(By.cssSelector("h3[class*='sc_title']")).
				below(By.cssSelector("a[href='life-in-the-garden']")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", title);
	
		//RelativeLocator
		WebElement title2 = driver.findElement(RelativeLocator.with
				(By.cssSelector("div[class='wpb_wrapper>p']")).
				near(By.cssSelector("img[src=''")));
		jse.executeScript("arguments[0].setAttribute('style', 'background:orange; border:5px solid red')", title2);
	} 
}
