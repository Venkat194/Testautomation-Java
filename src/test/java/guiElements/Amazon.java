package guiElements;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Amazon {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/s?k=chairs&crid=262H79OPGC32L&sprefix=chair%2Caps%2C245&ref=nb_sb_noss_2");
		List<WebElement> titles = driver.findElements(By.xpath("//h2[@class=\"a-size-base-plus a-spacing-none a-color-base a-text-normal\"]/span"));

		for(WebElement title:titles)
		{
			System.out.println(title);
		}
	}

}
