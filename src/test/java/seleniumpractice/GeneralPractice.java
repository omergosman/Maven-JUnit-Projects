package seleniumpractice;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class GeneralPractice {

	@Test
	public void webElementPractice() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(" https://docs.oracle.com/javase/8/docs/api/");
		driver.manage().window().maximize();

//		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("techfiosdemo@gmail.com");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
//		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		System.out.println(driver.findElement(By.tagName("frame")).getSize());
		//System.out.println(driver.findElement(By.tagName("iframe")).getSize());
//		
//		Thread.sleep(5000);
//
//		String expectedtitle = "Dashboard- TechFios Test Application - Billing";
//
//		String actualtitle = driver.getTitle();
//
//		Assert.assertEquals("Test Pass", expectedtitle, actualtitle);

//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		String dashbutton = "//div[@class='col-lg-12']//child::h2";

		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dashbutton)));

		// WebElement accountDropDown =
		// driver.findElement(By.id("select2-account-container"));
		// Select dropdown = new Select(accountDropDown);

		// dropdown.selectByVisibleText("am testing");
		driver.close();
		driver.quit();

	}
}
