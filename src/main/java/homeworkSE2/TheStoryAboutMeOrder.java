package homeworkSE2;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utils.BaseTest;

/*1. Cautam in search bar titlul cartii mentionate
-Dupa ce o gasim (atentie ca nu este pe prima pagina de rezultate!), vom da click pe ea 
*/

public class TheStoryAboutMeOrder extends BaseTest{

	@Test
	public void findTheStoyAboutMe() {
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


