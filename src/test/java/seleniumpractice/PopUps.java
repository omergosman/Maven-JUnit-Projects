package seleniumpractice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;




public class PopUps {
	WebDriver driver;
	@Test
	public void handlePopUps() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		driver.get("http://demo.guru99.com/test/delete_customer.php");
		WebElement SUBMIT_ELEMENT = driver.findElement(By.xpath("//input[@type='submit']"));
		Thread.sleep(3000);
		SUBMIT_ELEMENT.click();
		Thread.sleep(5000);
		String Expected_POP_UP_TEXT=driver.switchTo().alert().getText();
		String actual_pop_up_text ="Do you really want to delete this Customerc?";
		
		//System.out.println(driver.switchTo().alert().getText());
		  driver.switchTo().alert().dismiss();
		  Assert.assertEquals("the pop_up text doesn't match", Expected_POP_UP_TEXT, actual_pop_up_text);
		  
		// driver.switchTo().alert().accept();
		// Thread.sleep(3000);
		// driver.switchTo().alert().accept();
		driver.close();
		driver.quit();
	}

}
