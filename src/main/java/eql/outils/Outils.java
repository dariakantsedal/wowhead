package eql.outils;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Outils {
	
	public static void renseignerChamp(WebElement we, String s) {
		we.clear();
		we.sendKeys(s);
	}
	public static void verificationTextWebElement(String expected, WebElement we) {
		try{
			assertEquals(expected, we.getText());
		}
		catch(Error e) {
			System.out.println("[FAIL] verificationTextWebElement \n expected : "+expected+"\n real="+ we.getText());
			throw e;
		}
	}
	
	public static WebDriver choisirNavigateur(String browser) {
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
			return new FirefoxDriver();
			
		case "ie":
			System.setProperty("webdriver.ie.driver", "src/main/resources/drivers/IEDriverServer.exe");
			return new InternetExplorerDriver();
			

		case "chrome":
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			return new ChromeDriver();
			

		default:
			System.out.println("Browser était mal renseigné, Chrome se lance par default");
			System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
			return new ChromeDriver();
		}
	}

	public static List<String> loadFile(String filePath) throws FileNotFoundException {
	   
	    URI uri = null;
	    Scanner s = new Scanner(new File(filePath), "UTF-8");
	    ArrayList<String> list = new ArrayList<String>();
	    while (s.hasNextLine()){
	        list.add(s.nextLine());
	    }
	    s.close();
	   
	    return list;
	}

}
