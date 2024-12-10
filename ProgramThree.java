package SeleniumPrograms;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProgramThree {
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		browserInstantiate();
		SignUp();
		fillSignUpForm();
		clickSignUpButton();
		signUpPageTwo();
		login();
		clickLoginButton();
		waitForFixTime(2000);
		driver.quit();
	}

	public static void browserInstantiate() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.guvi.in");
		driver.manage().window().maximize();
		
	}

	public static void waitForFixTime(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public static void SignUp() {
		WebElement myElement = driver.findElement(By.xpath("//a[contains(text(),'Sign up')]"));
		myElement.click();
	}

	public static void fillSignUpForm() {
		WebElement myElementName = driver.findElement(By.id("name"));
		myElementName.sendKeys("Suba");
		WebElement myElementEmail = driver.findElement(By.id("email"));
		myElementEmail.sendKeys("dharshuzia@gmail.com");
		WebElement myElementPassWord = driver.findElement(By.id("password"));
		myElementPassWord.sendKeys("1528Suukbe1001#");
		WebElement myElementMobileNumber = driver.findElement(By.id("mobileNumber"));
		myElementMobileNumber.sendKeys("8838925801");
	}

	public static void clickSignUpButton() throws InterruptedException {
		WebElement myElementSignUpButton = driver.findElement(By.id("signup-btn"));
		myElementSignUpButton.click();
		waitForFixTime(2000);

	}

	public static void signUpPageTwo() throws InterruptedException {
		WebElement myElementCurrentProfile = driver.findElement(By.id("profileDrpDwn"));
		myElementCurrentProfile.click();
		List<WebElement> myElements = driver.findElements(By.xpath("//select[@id='profileDrpDwn']//option"));
		waitForFixTime(2000);
		for (int index = 0; index < myElements.size(); index++) {
			if (myElements.get(index).getText().equalsIgnoreCase("Looking for a career")) {
				myElements.get(index).click();
				break;
			}
		}

		WebElement myElementDegree = driver.findElement(By.id("degreeDrpDwn"));
		myElementDegree.click();
		List<WebElement> myElements2 = driver.findElements(By.xpath("//select[@id='degreeDrpDwn']//option"));
		waitForFixTime(1000);
		for (int index = 0; index < myElements2.size(); index++) {
			if (myElements2.get(index).getText().equalsIgnoreCase("B.E. / B.Tech. (others)")) {
				myElements2.get(index).click();
				break;
			}
		}

		WebElement myElementYearOfPassing = driver.findElement(By.id("year"));
		myElementYearOfPassing.sendKeys("2021");
		WebElement myElementSubmitButton = driver.findElement(By.id("details-btn"));
		myElementSubmitButton.click();

	}

	public static void login() {
		driver.get("https://www.guvi.in");
		driver.manage().window().maximize();
		WebElement myElementLoginButton = driver.findElement(By.id("login-btn"));
		myElementLoginButton.click();
		WebElement myElementEmailAddress = driver.findElement(By.id("email"));
		myElementEmailAddress.sendKeys("dharshuzia@gmail.com");
		WebElement myElementPassword = driver.findElement(By.id("password"));
		myElementPassword.sendKeys("1528Suukbe1001#");
	}

	public static void clickLoginButton() {
		WebElement myElementLoginButton = driver.findElement(By.id("login-btn"));
		myElementLoginButton.click();

	}
}
