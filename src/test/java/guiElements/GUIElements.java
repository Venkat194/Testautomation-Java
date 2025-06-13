package guiElements;


import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class GUIElements extends BaseTest {
	
	@Test(groups = {"sanity"})
	public void GUIinput() throws InterruptedException 
	{
		driver.findElement(By.id("name")).sendKeys("Venkat");
		driver.findElement(By.id("email")).sendKeys("Venkat@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9876543210");
		driver.findElement(By.xpath("//label[text()='Address:']/following::textarea")).sendKeys("5-102,BBSR");
		Thread.sleep(3000);
	}

	@Test
	public void radiobuttons() throws InterruptedException {
		WebElement female = driver.findElement(By.id("female"));
		System.out.println("Radiobutton1" + female);
		Actions action=new Actions(driver);
		action.moveToElement(female).build().perform();
		female.click();
		driver.findElement(By.id("male")).click();
		Thread.sleep(3000);
	}

	@Test
	public void checkboxes() throws InterruptedException {
		List<WebElement> checkboxes = driver.findElements(By.xpath("//label[text()='Days:']/following::input[@class=\"form-check-input\"]"));
		driver.findElement(By.xpath("//label[text()='Sunday']")).click();
		driver.findElement(By.xpath("//label[text()='Monday']")).click();
		driver.findElement(By.xpath("//label[text()='Tuesday']")).click();
		Thread.sleep(3000);
	}

	@Test
	public void dropdowns() throws InterruptedException {
		WebElement dropdown = driver.findElement(By.id("country"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("India");
		Thread.sleep(3000);
	}

	@Test
	public void m1dropdwons() throws InterruptedException {
		WebElement mdrop = driver.findElement(By.id("colors"));
		Select select = new Select(mdrop);
		select.selectByVisibleText("Yellow");
		select.selectByVisibleText("Red");
		Thread.sleep(3000);
	}

	@Test
	public void m2dropdowns() throws InterruptedException {
		WebElement m2drop = driver.findElement(By.id("animals"));
		Select select = new Select(m2drop);
		select.selectByVisibleText("Cat");
		select.selectByVisibleText("Cheetah");
		select.selectByVisibleText("Deer");
		select.selectByVisibleText("Dog");
		Thread.sleep(3000);
	}

	@Test
	public void datepicker1() throws InterruptedException {
		driver.findElement(By.id("datepicker")).click();
		driver.findElement(By.xpath("//td[@data-handler=\"selectDay\"]/a[@data-date=\"11\"]")).click();
		Thread.sleep(3000);
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(3000));
	}

	@Test
	public void datepicke2() throws InterruptedException {
		driver.findElement(By.id("txtDate")).click();
		WebElement Month = driver.findElement(By.xpath("//select[@data-handler=\"selectMonth\"]"));
		WebElement Year = driver.findElement(By.xpath("//select[@data-handler=\"selectYear\"]"));
		Select select = new Select(Month);
		select.selectByVisibleText("May");
		Thread.sleep(2000);
		Select select1 = new Select(Year);
		select1.selectByIndex(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//td[@data-handler=\"selectDay\"]/a[@data-date=\"20\"]")).click();
		Thread.sleep(3000);
	}

	@Test
	public void datepicker3() throws InterruptedException {
		driver.findElement(By.id("start-date")).sendKeys("15-07-2000");
		Thread.sleep(2000);
		driver.findElement(By.id("end-date")).sendKeys("10-05-2025");
		driver.findElement(By.xpath("(//button[text()=\"Submit\"])[1]")).click();
		WebElement result = driver.findElement(By.id("result"));
		System.out.println("Selected dates range----  " + result.getText());
		String exptxt = "You selected a range of 9065 days.";
		String acttxt = result.getText();
		Assert.assertEquals(exptxt, acttxt);
	}

	@Test
	public void filupload() throws InterruptedException {

		WebElement fileupload = driver.findElement(By.id("singleFileInput"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", fileupload);
		Thread.sleep(3000);
		fileupload.sendKeys("C:\\Users\\Venkatesh Yedla\\Downloads\\Test1.docx");
		Thread.sleep(3000);
	}

	@Test
	public void scrolling() throws InterruptedException {
		WebElement submit = driver.findElement(By.id("btn3"));
		Actions actions = new Actions(driver);
		actions.moveToElement(submit).perform();
		Thread.sleep(3000);

	}

	@Test
	public void statiswebtable() {
		// getting the number of rows in the table
		List<WebElement> Rows = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr"));
		System.out.println("Number of rows present in the static webtable-----  " + Rows.size());
		// getting number of columns in the table
		List<WebElement> Columns = driver.findElements(By.xpath("//table[@name=\"BookTable\"]/tbody/tr[1]/th"));
		System.out.println("Number of columns present in the static webtable-----   " + Columns.size());
		System.out.println(driver.findElement(By.xpath("//table[@name=\"BookTable\"]/tbody/tr[5]/td[1]")).getText());
	}

	@Test
	public void pagination() throws InterruptedException {
		List<WebElement> options = driver.findElements(By.xpath("//div[@class=\"table-container\"]//ul/li"));
		int pages= options.size();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//h2[text()=\"Pagination Web Table\"]"))).perform();

		for(int i=1;i<=pages;i++)
		{
			WebElement page =driver.findElement(By.xpath("//a[text()='" + i + "']"));
			page.click();
			Thread.sleep(2000);
			List<WebElement> checkbox= driver.findElements(By.xpath("//table[@id=\"productTable\"]/tbody/tr/td[4]/input"));
			for (WebElement check : checkbox) {
				check.click();
			}
			}
	}

	@Test
	public void dynamicbutton() throws InterruptedException
	{
		driver.findElement(By.xpath("//button[text()='START']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text()='STOP']")).click();
		Thread.sleep(3000);
	}

	@Test
	public void simplealert() throws InterruptedException
	{
		driver.findElement(By.id("alertBtn")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

	@Test
	public void confirmation() throws InterruptedException
	{
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		driver.findElement(By.id("confirmBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().dismiss();
	}

	@Test
	public void promptalert() throws InterruptedException
	{
		driver.findElement(By.id("promptBtn")).click();
		Thread.sleep(2000);
		driver.switchTo().alert().sendKeys("Venky");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String prompt = driver.findElement(By.id("demo")).getText();
		System.out.println(prompt);
	}

	@Test(enabled = true)
	public void newtab() 
	{
		String parentwindow= driver.getWindowHandle();
		driver.findElement(By.xpath("//button[text()=\"New Tab\"]")).click();

		Set<String> Allwindows= driver.getWindowHandles();

		for (String window : Allwindows) {
			if (!window.equals(parentwindow)) {
				driver.switchTo().window(window);

				break;
			}
		}
		driver.findElement(By.id("logo")).isDisplayed();
	}



	@Test(enabled = true)
	public void popupwindow() {
		// Store the parent window handle
		String parentWindow = driver.getWindowHandle();

		
		driver.findElement(By.id("PopUp")).click();

		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.numberOfWindowsToBe(2));

		// Get all window handles
		Set<String> allWindows = driver.getWindowHandles();

	
		for (String window : allWindows) {
			if (!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				break;
			}
		}

		// Check if the element exists in the new window
		WebElement seleniumIDE = driver.findElement(By.xpath("//h4[text()='Selenium IDE']"));
		Assert.assertTrue(seleniumIDE.isDisplayed());

		// Close the popup window
		driver.close();

		// Switch back to the original window
		driver.switchTo().window(parentWindow);
	}

	@Test
	public void mouseover() throws InterruptedException
	{
		WebElement mouseoverbtn=driver.findElement(By.xpath("//button[text()=\"Point Me\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(mouseoverbtn).perform();
		Thread.sleep(3000);
	}

	@Test
	public void doubleclick() throws InterruptedException
	{
		WebElement dbclick = driver.findElement(By.xpath("//button[text()=\"Copy Text\"]"));
		Actions actions = new Actions(driver);
		WebElement header = driver.findElement(By.xpath("//h2[text()=\"Double Click\"]"));
		actions.moveToElement(header).perform();
		actions.doubleClick(dbclick).perform();
		Thread.sleep(3000);
	}

	@Test
	public void dragdrop() throws InterruptedException 
	{
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		WebElement heading = driver.findElement(By.xpath("//h2[text()='Drag and Drop']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(heading).build().perform();
		actions.moveToElement(source).perform();
		Thread.sleep(3000);
		actions.dragAndDrop(source, target).build().perform();
		Thread.sleep(3000);
	}

	@Test
	public void scrollingdropdown() throws InterruptedException
	{
		WebElement dropdown= driver.findElement(By.id("comboBox"));
		dropdown.click();
		Actions actions = new Actions(driver);
		WebElement heading= driver.findElement(By.xpath("//h2[text()='Scrolling DropDown']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", heading);
		Thread.sleep(3000);
		WebElement option100 = driver.findElement(By.xpath("//div[text()='Item 100']"));
		//js1.executeScript("arguments[0].scrollIntoView(true);", option100);
		option100.click();
		Thread.sleep(3000);
	}
	
	@Test
	public void mwindow() throws InterruptedException 
	{
		String parentwindow= driver.getWindowHandle();
		driver.findElement(By.id("PopUp")).click();
		Set<String> allwindows = driver.getWindowHandles();
		for (String window : allwindows) {
			if(!window.equals(parentwindow))
			{
				driver.switchTo().window(window);
				driver.manage().window().maximize();
				Thread.sleep(2000);
				String title= driver.getTitle();
				System.out.println(title);
			}
		}
		
	}
	
		
	@Test
	public void scrolldown() throws InterruptedException
	{
		WebElement heading= driver.findElement(By.xpath("//ul[@id=\"pagination\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(heading).build().perform();
		Thread.sleep(3000);
	}
	
	@Test(enabled = true)
	public void slider() throws InterruptedException, IOException
	{
		WebElement start= driver.findElement(By.xpath("//div[@id=\"slider-range\"]/span"));
		WebElement heading= driver.findElement(By.xpath("//h2[text()=\"Slider\"]"));
		Actions action = new Actions(driver);
		action.moveToElement(heading).perform();
		action.dragAndDropBy(start, 70, 0).perform();
		Thread.sleep(3000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("C:\\Users\\Venkatesh Yedla\\Desktop\\venkatesh\\screenshot1.png"));       
	}

	
	
	@Test
	public void brokenlinks() throws IOException
	{
		List<WebElement> brokenlinks= driver.findElements(By.xpath("//div[@id='broken-links']/a"));
		System.out.println(brokenlinks.size());
		WebElement linkheading = driver.findElement(By.xpath("//h2[text()=\"Visitors\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(linkheading).build().perform();		
		for (WebElement brokenlink : brokenlinks) {
			String linkurl= brokenlink.getAttribute("href");
			URL url= new URL(linkurl);
			URLConnection urlconnection = url.openConnection();
			HttpURLConnection httpURLConnection= (HttpURLConnection) urlconnection;
			httpURLConnection.setConnectTimeout(2000);
			httpURLConnection.connect();
			
			if(httpURLConnection.getResponseCode()!=200)
			{
				System.out.println(linkurl+"---"+httpURLConnection.getResponseMessage()+"---is broken link");
			}
			httpURLConnection.disconnect();
		}
		
	}

	@Test(enabled = false)
	public void checkboxes1() {
		
		List<WebElement> chks= driver.findElements(By.xpath("//table[@id='countries']/tbody/tr/td/input"));
		System.out.println("Number of checkboxes are present in the table   ---   "+chks.size());
		for (WebElement chk : chks) {
			chk.click();
		}
	}
	
}