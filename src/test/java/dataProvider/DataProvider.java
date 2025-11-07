package dataProvider;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class DataProvider {
	
	WebDriver driver;
	@BeforeTest
	void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
	}

	@Test(dataProvider = "dp")
	void login(String username,String pwd)
	{
		driver.findElement(By.id("input-email")).sendKeys(username);
		driver.findElement(By.id("input-password")).sendKeys(pwd);
		driver.findElement(By.xpath("(//button[text()='Login'])[1]")).click();
	}
	@AfterTest
	void teardown()
	{
		driver.quit();
	}
	
	@org.testng.annotations.DataProvider(name="dp")
	Object[][] logindata()
	{
		Object data[][]= {
				{"abcd@gmail.com","12344321"},
				{"abcdefg@gmail.com","123321123"}
				};
		return data;
		}
		
	}