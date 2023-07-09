package homeworkSE1;
/*
 * Vom face un script care verifica daca anumite elemente sunt vizibile inainte si dupa efectuarea unei actiuni.
u Deschidem https://keybooks.ro/
u Identificam urmatorul element: Login  ; Acest element trebuie sa fie vizibil dupa ce deschidem pagina

 * 
 */
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import utils.BaseTest;

public class VisibleElements extends BaseTest{
	
	@Test
	public void loginIsVisible() {
		
		WebElement login =  driver.findElement(By.className("menu_user_login"));
		assertTrue(login.isDisplayed());
		login.click();
		WebElement user =  driver.findElement(By.id("log"));
		assertTrue(user.isDisplayed());
		WebElement pass =  driver.findElement(By.id("password"));
		assertTrue(pass.isDisplayed());
		
	}
}
