package eql.wowhead;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PageObjetRecupere {
	@FindBy(xpath = "//div[@id][contains(@style,'float: left')]//span")
	private List<WebElement> info;

	public List<String> get_info() {
		List<String> list = new ArrayList<String>();
//		for (WebElement element : info) {
//			list.add(element.getText());
//		}
		info.stream().map(WebElement::getText).forEach(list::add);
		return list;
	}
}
