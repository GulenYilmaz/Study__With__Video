package F__Dibi__Selenium;


	import java.util.List;

	import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.Select;



	public class class06__Calendars {

		public static void main(String[] args) throws InterruptedException {

			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");

			System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			String url =  "https://opensource-demo.orangehrmlive.com/";
			driver.get(url);

			
			driver.findElement(By.id("txtUsername")).sendKeys("Admin");
			WebElement password = driver.findElement(By.name("txtPassword"));
			password.sendKeys("admin123");
			driver.findElement(By.className("button")).click();

			driver.findElement(By.linkText("Leave")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Leave List")).click();

			// click on calendar image
			// You can enter an input, image---> XPath
			driver.findElement(By.xpath("//img[@class='ui-datepicker-trigger']")).click();

			// lets select the desired month
			WebElement months = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));

			// Because it is a dropdown we use select class
			Select select = new Select(months);
			select.selectByVisibleText("Sep");

			// lets select the desired year
			WebElement years = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
			Select select1 = new Select(years);
			select1.selectByVisibleText("2019");

			// lets select the desired day--- WebTable

			List<WebElement> days = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td"));

			for (WebElement day : days) {
				String dayVal = day.getText();

				if (dayVal.equals("16")) {
					day.click();
					break;
				}

			}
			driver.quit();
		}

	}
