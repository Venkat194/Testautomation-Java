package guiElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
//
public class BaseTest {
    public static WebDriver driver;
//
    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
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

