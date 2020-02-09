package seleniumpractice;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class MoneyTransfer {
	@Test
	public void userTransferMoney() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.findElement(By.id("username")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();

		driver.findElement(By.xpath("//span[@class='nav-label'][contains(text(), 'Transactions')]")).click();
		driver.findElement(By
				.xpath("//ul[@class='nav nav-second-level collapse in']//descendant::a [contains(text(), 'Transfer')]"))
				.click();

		//driver.findElement(By.xpath("//*[@id=\"side-menu\"]/li[3]/ul/li[3]/a")).click();

		driver.findElement(By.xpath("//select[@id='faccount']//child::*[contains(text(), 'housedown')]")).click();
		driver.findElement(By.cssSelector("#taccount > option:nth-child(15)")).click();
		driver.findElement(By.xpath("//input[@id='description']")).sendKeys("Selenium practice");
		driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("$500");
		driver.findElement(By.id("submit")).click();
		
		Thread.sleep(5000);
		
		String expected_description = "Slenium practice";
		String actual_description = driver.findElement(By.xpath("//table[@class='table table-bordered sys_table']//descendant::a[text()='Selenium practice']")).getText();
		
		Assert.assertEquals("Deposit proccess has FAILED!", expected_description, actual_description);
		
		
		driver.close();
		driver.quit();

	}
}
