import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	public static void main(String[] args) {
		WebDriver driver;
		ChromeOptions options = new ChromeOptions();

		
		@BeforeMethod()
		public void setup() 
		{
			driver=new ChromeDriver(options);
			options.addArguments("--incognito");
			driver.get("https://testautomationpractice.blogspot.com/");
			driver.manage().window().maximize();
			
		}
		@AfterMethod
		public void teardown() 
		{
			driver.quit();
		}
	}

}
