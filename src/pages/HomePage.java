package pages;

import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id = "nav-logo-sprites")
	public static WebElement amazonLogo;
	@FindBy(id = "twotabsearchtextbox")
	public static WebElement searchBox;
	//@FindBy(xpath = "//div[@id='suggestions']")
	//public static List<WebElement> suggestions;
	@FindBy(xpath = "//input[@class='nav-input'][2]")
	public static WebElement searchButton;
	@FindBy(xpath = "//span[contains(text(),'Shop All Fans')]")
	public static WebElement shopAllSearchItemTag;
	@FindBy(how = How.XPATH, using = "//div[@id='suggestions']/div")
	public static  List<WebElement> suggestions;

	public HomePage() throws IOException {
		super();
		PageFactory.initElements(driver, this);
	}
	public void search(String a) {
		searchBox.sendKeys(a);
	}
	public void clickOnSearch() {
		searchButton.click();	
	}
	
	public  LinkedList<String> suggestion() {
		LinkedList<String> suggestionlist = new LinkedList();
		for(WebElement a:suggestions) {
			suggestionlist.add(a.getText());
		}
		
		return suggestionlist;
	}
}
