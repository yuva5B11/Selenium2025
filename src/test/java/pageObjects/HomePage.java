package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(15));
	@FindBy(xpath = "//a[@id='pt1:_UIShome']")
	WebElement lnkHome;
	@FindBy(xpath = "//a[@id='groupNode_projects']")
	WebElement lnkProjects;
	@FindBy(xpath = "//a[@id='itemNode_projects_pjr_project_resources_0']")
	WebElement lnkProjectResources; // Project Resources
	// logout
	@FindBy(xpath = "//img[@id='pt1:_UIScmil2u']")
	WebElement lnkProfile;
	@FindBy(xpath = "//a[@id='pt1:_UISlg1']")
	WebElement lnkLogOut;
	@FindBy(xpath = "//button[@id='Confirm']")
	WebElement lnkLogoutConfirmation;

	public void clickHome() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='pt1:_UIShome']"))).click();
//		lnkHome.click();
	}

	public void clickProjects() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='groupNode_projects']"))).click();
//		lnkProjects.click();
	}

	public void clickProjectResources() {
		lnkProjectResources.click();
	}

	public void clickLogOut() {
		lnkProfile.click();
		lnkLogOut.click();
		lnkLogoutConfirmation.click();

	}
}
