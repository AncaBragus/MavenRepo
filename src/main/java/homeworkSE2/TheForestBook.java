package homeworkSE2;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import java.util.List;

import org.testng.annotations.*;

import utils.BaseTest;
/*
 * Vom face un script care verifica daca cartea The Forest se afla in cele 4 
categorii din pagina principala si daca linkul cartii ne deschide pagina de 
produs cand ajungem in ultima categorie.

Scriptul are 1 metoda @Test
u 1. Elementele meniului le vom identifica pe baza attributului class “sc_tabs_title” si
vom crea o lista cu ele.
u 2. Vom itera lista cu un for si vom da click pe fiecare element al listei astfel incat sa
trecem prin toate cele 4 categorii
u 3. In fiecare dintre categorii vom face o verificare, din care sa stim daca cartea
mentionata mai sus este displayed.
u 4. Cand ajungem la ultimul element al listei, vom da click pe carte si vom verifica
daca ne face redirect catre URL-ul : “https://keybooks.ro/shop/the-forest/
 * 
 */


public class TheForestBook extends BaseTest{

	@Test
	public void checkTheForest() {
		try {
		List<WebElement> catNames = driver.findElements(By.cssSelector("li[class*='sc_tabs_title'] > a[class*='theme_button']"));
		System.out.println(catNames.size());
		for (int i=0; i<=catNames.size()-1; i++) {
			WebElement cat = catNames.get(i);
			System.out.println(cat.getText());
			cat.click();
			Thread.sleep(1000);
			//WebElement book =  driver.findElement(By.cssSelector("div[class*='sc_tabs_content']  div[class*='sc_column_item'] > h3[class*= 'sc_title'] > a[href = 'the-forest']"));
			List<WebElement> books =  driver.findElements(By.cssSelector("h3[class*='sc_title'] > a[href = 'the-forest']"));
			//System.out.println(books.size());
				for (int j=0; j<=books.size()-1; j++) {
					WebElement book = books.get(j);
					if (book.isDisplayed()) {
						System.out.println("Category " + cat.getText() + ": " + book.getText() + " book is displayed" );	
					if (i == catNames.size() - 1) {
						book.click();
						Thread.sleep(1000);
						String bookURL = driver.getCurrentUrl();
						System.out.println(bookURL);
						assertEquals(bookURL,"https://keybooks.ro/shop/the-forest/");
						}
					}
				}
			}
		}catch (Exception e) {
				System.out.println(e);
			}		
		}	
	}

