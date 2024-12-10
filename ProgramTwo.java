package SeleniumPrograms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v129.css.CSS.GetBackgroundColorsResponse;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgramTwo {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		browserInstantiate();
		methodForDragAndDrop();
		colorVerificatin();
		driver.quit();
	}

	public static void browserInstantiate() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
	}

	public static void methodForDragAndDrop() throws InterruptedException {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@src='/resources/demos/droppable/default.html']"));
		driver.switchTo().frame(iframe);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions act = new Actions(driver);
		act.dragAndDrop(source, target).perform();
		WebElement myElement = driver.findElement(By.xpath("//div//p[contains(text(),'Dropped!')]"));
		System.out.println(myElement.getText());
		if (myElement.getText().equalsIgnoreCase("dropped!")) {
			System.out.println("Target Element has changed to Dropped!");
		}

	}

	public static void colorVerificatin() {
		WebElement target = driver.findElement(By.id("droppable"));
		String Expected_color = "#fffa90";
		String color = target.getCssValue("background-color");
		String hex = org.openqa.selenium.support.Color.fromString(color).asHex();
		System.out.println("Hex of the Background Color :: " + hex);

		if (hex.equals(Expected_color)) {
			System.out.println("Drag and drop has been sucessfull");

		} else {
			System.out.println("Drag and drop is not sucessfull");
		}
	}

}
