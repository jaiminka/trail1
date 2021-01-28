package tests;

import static org.junit.Assert.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import Base.TestBase;
import data.SignInData;
import pages.HomePage;
import pages.LoginPage;

public class LoginTest extends TestBase {
	LoginPage lp;
	SignInData sd;
	HomePage homepage;
	public LoginTest() throws IOException {
		super();
	}

	@Before
	public void setUp() throws Exception {
		openBrowser();
		openAmazon();
		lp = new LoginPage();
		sd = new SignInData();
	}

	@After
	public void tearDown() throws Exception {
		closeBrowser();
	}

	//@Test
	public void WrongEmailTest() {
		lp.enterEmail(sd.wromgEmail);
		lp.clickOnContinue();
		Assert.assertEquals(sd.wrongEmailErr, lp.readWrongEmailPasswordErr());
	}
	//@Test
	public void EmptyEmailTest() {
		lp.enterEmail("");
		lp.clickOnContinue();
		Assert.assertEquals(sd.emptyEmailErr, lp.readEmptyEmailErr());
	}
	//@Test
	public void WrongPhoneNumberTest() {
		lp.enterEmail(sd.wrongPhoneNumber);
		lp.clickOnContinue();
		Assert.assertEquals(sd.wrongEmailErr, lp.readWrongEmailPasswordErr());	
	}
	//@Test
	public void WrongPasswordTest() {
		lp.enterEmail(sd.correctPhoneNumber);
		lp.clickOnContinue();
		lp.enterPassword(sd.wrongPassword);
		lp.clickOnSignIn();
		Assert.assertEquals(sd.wrongPasswordErr, lp.readWrongPasswordErr());
	}
	@Test
	public void LogInTest() throws InterruptedException, IOException {
		System.out.println(sd.correctPhoneNumber);
		System.out.println(sd.correctPassword);
		//homepage = lp.logIn(sd.correctPhoneNumber,sd.correctPassword);
		homepage = lp.logIn(sd.correctEmail,sd.correctPassword);
		Assert.assertTrue(lp.deliverTO.isDisplayed());
	}
}
