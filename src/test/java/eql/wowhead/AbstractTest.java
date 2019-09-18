package eql.wowhead;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractTest {
	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp() {
		System.out.println("\n@Before");
		System.setProperty("webdriver.chrome.driver", "C:/Installation/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://fr.wowhead.com/");
	}

	@After
	public void tearDown() {
		System.out.println("\n@After");
		driver.close();
	}

}
