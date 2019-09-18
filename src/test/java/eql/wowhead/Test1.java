package eql.wowhead;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;

import eql.outils.Outils;

public class Test1 extends AbstractTest {

	@Test
	public void tester() throws InterruptedException, FileNotFoundException {
		Assert.assertEquals("Wowhead", driver.getTitle().substring(0, 7));
		PageAccueil page_accueil = PageFactory.initElements(driver, PageAccueil.class);
		System.out.println("Page ouverte");

		Thread.sleep(3000);

		page_accueil.passer_cookies(driver);
		
		Thread.sleep(1000);

		String objet_de_recherche = "lardeur";
		PagePreResultats resultats = page_accueil.rechercherDansLaBarre(objet_de_recherche, driver);
		System.out.println("recherche est effectué");
		resultats.cliquer_sur_PNG();
		System.out.println("cliqué sur PNG");

		PageLardeur lardeur = resultats.cliquer_sur_tete(driver);
		System.out.println("cliqué sur la tete de mort");

		String bete1 = "Chahuteurs de cadavre";
		PageObjetRecupere page_de_bete = lardeur.choisir_un_objet(driver, bete1);
		System.out.println("cliqué sur " + bete1);

		List<String> comparaison = Outils.loadFile("src/main/resources/files/chauteur");

		for (int i = 0; i < page_de_bete.get_info().size(); i++) {
			Assert.assertEquals("contenu n'est pas le meme", comparaison.get(i), page_de_bete.get_info().get(i));
		}

		String bete2 = "Chausses de Lardeur";
		String bete3 = "Pioche en fer froid";
		String bete4 = "Grèves de geôlier volées";
		String bete5 = "Espauliers de Tourne-Clé";

		driver.navigate().back();
		System.out.println("Navigate back");

		page_de_bete = lardeur.choisir_un_objet(driver, bete2);
		System.out.println("cliqué sur " + bete2);

		comparaison = Outils.loadFile("src/main/resources/files/chausseDeLardeur");
		for (int i = 0; i < page_de_bete.get_info().size(); i++) {
			Assert.assertEquals("contenu n'est pas le meme", comparaison.get(i), page_de_bete.get_info().get(i));
		}

		driver.navigate().back();
		System.out.println("Navigate back");

		page_de_bete = lardeur.choisir_un_objet(driver, bete4);
		System.out.println("cliqué sur " + bete4);

		comparaison = Outils.loadFile("src/main/resources/files/greves");
		for (int i = 0; i < page_de_bete.get_info().size(); i++) {
			Assert.assertEquals("contenu n'est pas le meme", comparaison.get(i), page_de_bete.get_info().get(i));
		}
		driver.navigate().back();
		System.out.println("Navigate back");

		page_de_bete = lardeur.choisir_un_objet(driver, bete5);
		System.out.println("cliqué sur " + bete5);

		comparaison = Outils.loadFile("src/main/resources/files/espaulier");
		for (int i = 0; i < page_de_bete.get_info().size(); i++) {
			Assert.assertEquals("contenu n'est pas le meme", comparaison.get(i), page_de_bete.get_info().get(i));
		}
		Assert.assertEquals("contenu n'est pas le meme", comparaison, page_de_bete.get_info());

	}

}
