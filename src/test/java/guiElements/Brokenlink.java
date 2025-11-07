package guiElements;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Brokenlink extends BaseTest {

	@Test
	public void brokenlinks() throws IOException
	{
		List<WebElement> links =driver.findElements(By.tagName("a"));
		for (WebElement link : links) {
			String hrefattribute= link.getAttribute("href");
			URL url = new URL(hrefattribute);
			URLConnection urlconnection = url.openConnection();
			HttpURLConnection httpsUrlConnection = (HttpURLConnection) urlconnection;
			httpsUrlConnection.setConnectTimeout(5000);
			httpsUrlConnection.connect();
			if (httpsUrlConnection.getResponseCode()!=200)
			{
				System.out.println(url+"  ---  "+httpsUrlConnection.getResponseMessage()+"------is broken link");
			}
			
			httpsUrlConnection.disconnect();
		}
	}
}
