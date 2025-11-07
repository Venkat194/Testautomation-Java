package pageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pageobject1 {

	WebDriver driver;
	Pageobject1(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//locators
	@FindBy(id = "name")
	WebElement name;
	
	
	@FindBy(id = "email")
	WebElement email;
	
	void namefiled(String username)
	{
		name.sendKeys(username);
	}
	
	void emailfiled(String email1)
	{
		email.sendKeys(email1);
	}

	
	}

