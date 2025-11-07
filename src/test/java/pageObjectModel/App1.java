package pageObjectModel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.*;

public class App1 {

	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@Test
	void test1() throws InterruptedException
	{
		Pageobject1 po = new Pageobject1(driver);
		po.namefiled("venkatesh");
		po.emailfiled("venkatesh112233@gmail.com");
		Thread.sleep(3000);
	}

	@AfterClass
	void teardown()
	{
		driver.quit();
	}
	}
