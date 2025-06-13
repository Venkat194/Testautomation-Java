package hdfc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTesthdfc {

	public static WebDriver driver;
	@BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://netbanking.hdfcbank.com/netbanking/");
        //driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
    }
//
    @AfterTest
    public void teardown() {
        if (driver != null) { // Check for null before closing
            driver.quit();
        }
    }
}


