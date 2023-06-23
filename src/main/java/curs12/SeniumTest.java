package curs12;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

//https://keybooks.ro/

@Test
public class SeniumTest {
	public void openBrwser() {
		WebDriver driver = new ChromeDriver();
							// new FirefoxDriver();
							// new EdgeDriver();		
		
		driver.get("https://keybooks.ro/");
		System.err.println("test teste pe my proj");
		
	}

}
