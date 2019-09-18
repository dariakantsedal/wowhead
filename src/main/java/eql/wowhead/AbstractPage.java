package eql.wowhead;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import eql.outils.*;

public abstract class AbstractPage {
	@FindBy(xpath = "(//form/input[@name='q'])")
	private WebElement barre_recherche;
	@FindBy(xpath = "//*[@class='header-search-button fa fa-search']")
	private WebElement rechercher;

	public PagePreResultats rechercherDansLaBarre(String s, WebDriver driver) {
		Outils.renseignerChamp(barre_recherche, s);
		rechercher.click();
		return PageFactory.initElements(driver, PagePreResultats.class);
	}

	@FindBy(xpath = "//span[contains(.,'Les cookies')]")
	private WebElement frame;

	@FindBy(xpath = "//span[contains(.,'Continuer')]/..")
	private WebElement button_continuer;

	public void passer_cookies(WebDriver driver) {
		Actions actions = new Actions(driver);
		if (frame.isDisplayed())

			System.out.println("je vais cliquer sur cookies");
		actions.moveToElement(button_continuer).click().perform();

		// button_continuer.click();
	}

}
