package pages;

import java.io.IOException;
import java.util.concurrent.Semaphore;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.TestBase;

public class LoginPage extends TestBase {
	
	@FindBy(name = "email")
	public static WebElement email;
	@FindBy(id = "continue")
	public static WebElement continueButton;
	@FindBy(name = "password")
	public static WebElement password;
	@FindBy(id = "signInSubmit")
	public static WebElement signInButton;
	@FindBy(linkText = "Forgot Password")
	public static WebElement forgotPasswordLink;
	@FindBy(name = "rememberMe")
	public static WebElement checkBox;
	@FindBy(xpath = "//span[@class='a-list-item']")
	public static WebElement wrongEmailPasswordErr;
	@FindBy(id = "auth-email-missing-alert")
	public static WebElement emptyEmailErr;
	@FindBy(xpath = "//span[@class='a-list-item']")
	public static WebElement wrongPasswordErr;	
	@FindBy(xpath = "//span[@id='glow-ingress-line1']")
	public WebElement deliverTO;
	
	public LoginPage() throws IOException {
		super();
		PageFactory.initElements(driver,this);
	}
	
	public  void enterEmail(String a) {
		email.sendKeys(a);	
	}
	public void clickOnContinue() {
		continueButton.click();
	}
	public void enterPassword(String a) {
		password.sendKeys(a);	
	}
	public void clickOnSignIn() {
		signInButton.click();
	}
	public String readWrongEmailPasswordErr() {
		String actualErr = wrongEmailPasswordErr.getText();
		return actualErr;
	}
	public String readEmptyEmailErr() {
		String actualErr = emptyEmailErr.getText();
		return actualErr;
	}	
	public String readWrongPasswordErr() {
		String actualErr = wrongPasswordErr.getText();
		return actualErr;	
	}
	public HomePage logIn(String ph,String ps) throws InterruptedException, IOException {
		enterEmail(ph);
		Thread.sleep(2000);
		clickOnContinue();
		enterPassword(ps);
		clickOnSignIn();
		
		
		return new HomePage();
	}	
}

	
