package eql.wowhead;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PagePreResultats extends AbstractPage {
	@FindBy(xpath = "//h2[@class='heading-size-1']")
	private WebElement titre_resultats;
	@FindBy(xpath = "//a/b[contains(.,'PNJ')]/..")
	private WebElement onglet_PNG;
	@FindBy(xpath = "//tbody/tr/td[@class='icon-boss-padded']/a")
	private WebElement tete_morte;

	public void cliquer_sur_PNG() {
		onglet_PNG.click();
	}

	public PageLardeur cliquer_sur_tete(WebDriver driver) {
		tete_morte.click();
		return PageFactory.initElements(driver, PageLardeur.class);
	}
}
