package guiElements;

import java.time.Duration;

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
        //driver = new EdgeDriver();
        driver = new ChromeDriver();
        //driver.get("http://www.deadlinkcity.com/");
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();  
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
//
    @AfterTest
    public void teardown() {
        if (driver != null) { // Check for null before closing
            driver.quit();
        }
    }
}

