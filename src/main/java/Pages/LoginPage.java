package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import PageComponents.BasePage;

public class LoginPage extends BasePage{
	
	WebDriver driver=null;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css ="input[name=username]")
	private WebElement username;
	
	@FindBy(css="input[name=password]")
	private WebElement password;
	
	@FindBy(css="button[class*=login]")
	private WebElement login;
	
	@FindBy(css="img[class^=employee]")
	private WebElement userProfile;
	
	@FindBy(css="div[class$=error] > p")
	private WebElement invalidLoginMessage;
	
	
	public void loginUser(String user,String pwd) {
		waitForWebElement(username);
		username.sendKeys(user);
		
		waitForWebElement(password);
		password.sendKeys(pwd);
		
		waitForWebElement(login);
		clickElement(login);
	}

	public boolean isLoginSuccessful() {
		return isElementPresent(userProfile);
	}
	
	public boolean isLoginErrorVisible() {
		return isElementPresent(invalidLoginMessage);
	}
	
}
