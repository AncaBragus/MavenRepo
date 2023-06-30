package curs15;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import org.openqa.selenium.interactions.Actions;

import utils.BaseTest;

public class CssSelectors extends BaseTest {
	
	//@Test
	public void cssSelectors () {
		
		//#menu-user -- gaseste orice element care are  attributul Id (#) egal cu  menu_user
		//ul#menu-user -- gaseste orice element care are  attributul Id (#) egal cu  menu_user
		//ul[id='menu-user'] -- recomandat ; gaseste orice element ul care are  attributul Id  egal cu  menu_user
		
		WebElement loginMenu = driver.findElement(By.cssSelector("#menu_user"));
		//loginMenu.click(); nu se duce corect
        JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		//jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", poza1,poza2,poza0);
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", loginMenu);
		
		// . --> class   referinta catre clasa
		// div.logo_slogan
		WebElement logo = driver.findElement(By.cssSelector(".logo_slogan"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", logo);
		
		WebElement inspireText = driver.findElement(By.cssSelector("div[class='column-1_2 sc_column_item sc_column_item_2 even'] h3.sc_title_underline"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", inspireText);
		// face scroll;
		jse.executeScript("arguments[0].scrollIntoView();", inspireText);
		
		//sau cu Actions
		Actions action = new Actions (driver);
		action.moveToElement(inspireText).perform();
	
	}
	
	
	//@Test
	@Ignore
	public void cssSeletor2 () {
		driver.findElement(By.cssSelector("li[class='menu_user_login']")).click();
		//AND
		driver.findElement(By.cssSelector("input[id='log'][name='log'][placeholder='Login or Email']")).sendKeys("Test");
		//OR
		driver.findElement(By.cssSelector("input[type='passowrd'],[name='pwd']")).sendKeys("Test");
		// >   -- direct child  
		driver.findElement(By.cssSelector("div[class='popup_form_field remember_field']>input")).sendKeys("Test");
		//  space  ->nephew  
		driver.findElement(By.cssSelector("form[class='popup_form login_form'] input[class='submit_button']")).sendKeys("Test");
	}
	
	@Test
	public void cssSeletor3 () {
		//contains
		
			//a[href='the-son']
		// * contains
		//	a[href*='-son']
		WebElement bookTitle = driver.findElement(By.cssSelector("a[href*='-son']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", bookTitle);
		jse.executeScript("window.scrollBy(0, 500)");
		
		// ~ contine substring, dar nu e recomndat
		// p[style~='center']
		WebElement bookAuthor = driver.findElement(By.cssSelector("p[style~='center;']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", bookAuthor);
		jse.executeScript("window.scrollBy(0, 500)");
		// ^  starts with
		// a[href^='life-']
		WebElement book= driver.findElement(By.cssSelector("a[href^='life-']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", book);
		jse.executeScript("window.scrollBy(0, 500)");

		// $  end with
		//a[href$='silence']
		WebElement bookSilence= driver.findElement(By.cssSelector("a[href$='silence']"));
		jse.executeScript("arguments[0].setAttribute('style', 'border:10px solid red')", bookSilence);
		jse.executeScript("window.scrollBy(0, 500)");
		
}
}
