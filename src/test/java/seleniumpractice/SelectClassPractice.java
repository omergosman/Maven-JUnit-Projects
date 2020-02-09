package seleniumpractice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class SelectClassPractice {
	@Test
	public void addandValidateDeposit() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://techfios.com/test/billing/?ng=login/");
		driver.manage().window().maximize();

		driver.findElement(By.className("form-control")).sendKeys("techfiosdemo@gmail.com");
		driver.findElement(By.cssSelector("input[id='password']")).sendKeys("abc123");
		driver.findElement(By.name("login")).click();
		driver.findElement(By.linkText("Add Deposit")).click();

		Thread.sleep(3000);
		//WebElement account_dropdown= driver.findElement(By.id("account"));
		
		Select account_dd = new Select(driver.findElement(By.id("account")));
		
		account_dd.selectByVisibleText("housedownpayment");
		
		//driver.findElement(By.xpath("//*[@id=\"account\"]/option[5]")).click();
		driver.findElement(By.xpath("//*[@id=\"description\"]")).sendKeys("Selenium Practice");
		driver.findElement(By.xpath("//*[@id=\"amount\"]")).sendKeys("$100");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();

		Thread.sleep(5000);
		String expected_description = "Selenium Practice";
		String actual_description = driver.findElement(By.xpath("//table[@class='table table-bordered sys_table']//descendant::a[contains(text(), 'Selenium Practice')]")).getText();
		Assert.assertEquals("Deposit has not been added!", expected_description, actual_description);

		String Expected_amount = "$ 100.00";
		String Actual_amount = driver.findElement(By.xpath("//table[@class='table table-bordered sys_table']//descendant::a[contains(text(), 'Selenium Practice')]/following::td[1]")).getText();
		Assert.assertEquals("Amount has not been Added!", Expected_amount, Actual_amount);
		driver.close();
		driver.quit();
	}
}
