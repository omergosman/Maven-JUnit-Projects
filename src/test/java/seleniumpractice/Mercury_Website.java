package seleniumpractice;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Mercury_Website {

	@Test
	public void webElementPractice() throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		//Deleting cookies and history   = driver.manage.deletallcookies();
		
		driver.get(" http://newtours.demoaut.com/mercurywelcome.php");
		driver.manage().window().maximize();
		Thread.sleep(3000);

//		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("mercury");
//		driver.findElement(By.name("password")).sendKeys("mercury");
//		driver.findElement(By.name("login")).click();
		
		Thread.sleep(3000);

		driver.close();
		driver.quit();

	}
}
