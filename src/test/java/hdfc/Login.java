package hdfc;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Login extends BaseTesthdfc {

	
	@Test
	public void login() throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		Thread.sleep(3000);
		WebElement s2= driver.findElement(By.xpath("//input[@class=\"form-control text-muted\"]"));
		s2.sendKeys("183426094");
		s2.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		WebElement s3= driver.findElement(By.xpath("//input[@id=\"fldPasswordDispId\"]"));
		s3.sendKeys("Venky@195");
		s3.sendKeys(Keys.ENTER);
	}

	@Test(dependsOnMethods = "login")
	public void homepage()
	{
		String exp_title= "Welcome to HDFC Bank NetBanking";
		
		String Act_title= driver.getTitle();
		
		if(exp_title.equals(Act_title)) {
			System.err.println("Loggedin successfully");
		}
		else {
			System.err.println("not logged in");
		}
	}
	
	@Test(dependsOnMethods = "homepage")
	public void avlbalance()
	{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.switchTo().frame(2);
		 WebElement Avlbalance= driver.findElement(By.xpath("//table[@class=\"datatable landTable\"]//tbody//tr//td//span[3]"));
		 String balance= Avlbalance.getText();
		 System.out.println(balance);
	}
	
	
	@Test(dependsOnMethods = "avlbalance")
	public void accountsummary()
	{
		driver.switchTo().frame("frameID"); // Replace with actual frame ID
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//li[@id=\"enquirytab\"]//a[@id=\"enquiryatag\"]")).click();
		driver.findElement(By.xpath("(//li[@id=\"enquirytab\"]//li)[1]")).click();
		WebElement typeofAC= driver.findElement(By.xpath("//select[@name=\"selAccttype\"]"));
		Select select = new Select(typeofAC);
		select.selectByValue("SCA");	
	}
	
	
}

