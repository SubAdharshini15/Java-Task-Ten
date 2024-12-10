package SeleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgramOne {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		browserInstantiate();
		waitForFixTime(2000);
		switchToIframe();
		methodForYearSelection();
		waitForFixTime(2000);
		driver.quit();
	}

	public static void browserInstantiate() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
	}

	public static void waitForFixTime(int Time) throws InterruptedException {
		Thread.sleep(Time);
	}

	public static void switchToIframe() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/resources/demos/datepicker/default.html']"));
		driver.switchTo().frame(iframe);
	}

	public static void methodForYearSelection() {
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		datePicker.click();
		WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
		nextButton.click();
		WebElement date = driver.findElement(By.xpath("//a[@data-date='22']"));
		date.click();
		WebElement selectDate = driver.findElement(By.xpath("//input[@class='hasDatepicker']"));
		String SelectedDate = selectDate.getAttribute("value");
		System.out.println("Selected Date is :: " + SelectedDate);
	}

}
