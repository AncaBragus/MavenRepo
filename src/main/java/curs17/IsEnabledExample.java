package curs17;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import utils.BaseTest;

public class IsEnabledExample extends BaseTest{

	@Test
	public void isEnabled() {
			
		driver.findElement(By.cssSelector("menu_user_login")).click();
		WebElement userName = driver.findElement(By.cssSelector("input[id=log]"));
		System.out.println(userName.isEnabled());
		
		//just an example, it's not recommended :)
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('disabled','true')", userName);
		
		System.out.println(userName.isEnabled());
	}
}
