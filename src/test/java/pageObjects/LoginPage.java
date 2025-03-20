package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//input[@id='userid']") WebElement txtUserId;
	@FindBy(xpath = "//input[@id='password']") WebElement txtPassword;
	@FindBy(xpath = "//button[@id='btnActive']") WebElement btnSignIn;
	
	public void setUserId(String userId) {
		txtUserId.sendKeys(userId);
	}
	
	public void setPassword(String password) {
		txtPassword.sendKeys(password);
	}
	public void clickLogin() {
		btnSignIn.click();
	}
}
