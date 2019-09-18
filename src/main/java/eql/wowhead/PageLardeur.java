package eql.wowhead;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageLardeur extends AbstractPage {
	@FindBy(xpath = "//a/div[contains(.,'Butin')]")
	private WebElement butin;

	@FindBy(xpath = "//tbody/following::a[@class='q3 listview-cleartext']/ancestor::tbody")
	private WebElement elements;

	public void cliquer_butin() {
		butin.click();
	}

	public PageObjetRecupere choisir_un_objet(WebDriver driver, String name_of_object) {
		elements.findElement(By.xpath("//a[contains(.,'" + name_of_object + "')]")).click();

		return PageFactory.initElements(driver, PageObjetRecupere.class);

	}

}
