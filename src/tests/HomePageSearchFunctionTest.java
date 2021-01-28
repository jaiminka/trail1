package tests;

import static org.junit.Assert.*;
import java.awt.RenderingHints.Key;
import java.io.IOException;
import java.util.LinkedList;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Keys;
import Base.TestBase;
import data.SignInData;
import pages.HomePage;
import pages.LoginPage;

public class HomePageSearchFunctionTest extends TestBase {
	LoginPage lp;
	SignInData sd;
	HomePage hp;
	public HomePageSearchFunctionTest() throws IOException {
		super();
	}

	@Before
	public void setUp() throws Exception {
		openBrowser();
		openAmazon();
		
		lp = new LoginPage();
		sd = new SignInData();
		hp = new HomePage();
		lp.logIn(sd.correctEmail,sd.correctPassword);
		
	}

	@After
	public void tearDown() throws Exception {
		closeBrowser();
	}

	@Test
	public void seachItemTest() throws InterruptedException {
		hp.search(sd.searchItem+Keys.ENTER);
		Assert.assertTrue(hp.shopAllSearchItemTag.isDisplayed());
	}
	@Test
	public void validateSearchSuggestion() throws InterruptedException {
		Thread.sleep(5000);
		hp.search(sd.searchItem);
		Thread.sleep(3000);
		LinkedList suggestions = hp.suggestion();
			System.out.println(suggestions.size());
			for(int i=0; i<suggestions.size();i++) {			
			Assert.assertTrue(suggestions.get(i).toString().contains(sd.searchItem));
		}
		
		
	}

}
