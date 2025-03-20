package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectResourcesPage extends BasePage {

	public ProjectResourcesPage(WebDriver driver) {
		super(driver);
	}

	WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(15));
	
	@FindBy(xpath = "//img[@title='Tasks']") WebElement imgTask;// taskbar
	@FindBy(xpath = "//a[@id='pt1:_FOr1:1:_FONSr2:0:_FOTRaT:0:RAtl1']") WebElement lnkManageProjectResourceRequests; // ManageProjectResourceRequests
	@FindBy(xpath = "//a[@title='Expand Search']") WebElement lnkExpandSearchAR;
	@FindBy(xpath = "//input[@name='pt1:_FOr1:1:_FONSr2:0:MAt2:0:pt1:AP1:qryId1:value00']") WebElement txtARID;
	@FindBy(xpath = "//a[@class='x1kt']") WebElement drpStatus;
	@FindBy(xpath = "//label[normalize-space()='All']") WebElement selStatus;
	@FindBy(xpath = "//input[contains(@aria-label,'Project Number')]") WebElement txtProjectNumber;
	@FindBy(xpath = "//input[@aria-label=' Staffing Owner']") WebElement txtStaffingOwner;
	@FindBy(xpath = "//button[text()='Search']") WebElement btnSearch;
	// CreateAR
	@FindBy(xpath = "//img[@title='Create']") WebElement imgCreateAR;
	
	//validation points
	@FindBy(xpath = "//a[@id='pt1:_FOr1:1:_FONSr2:0:MAt2:0:pt1:AP1:AT1:_ATp:ATt1:0:cl1']") WebElement linkARNumResult;

	public void clickTask() {
			imgTask.click();
	}

	// Method to click on lnkManageProjectResourceRequests
	public void clickManageProjectResourceRequest() {
			lnkManageProjectResourceRequests.click();
	}

	// Method to click on the Expand Search link
	public void clickExpandSearchAR() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Expand Search']"))).click();
//		lnkExpandSearchAR.click();
	}

	// Method to enter text into the AR ID field
	public void enterARID(String arID) {
			txtARID.sendKeys(arID);
	}

	// Method to click on the Status dropdown
	public void clickStatusDropdown() {
			drpStatus.click();
	}

	// Method to select the "All" status
	public void selectStatusAll() {
			selStatus.click();
	}

	// Method to enter text into the Project Number field
	public void enterProjectNumber(String projectNumber) {
			txtProjectNumber.sendKeys(projectNumber);
	}

	// Method to click on the Create AR image
	public void clickCreateAR() {
			imgCreateAR.click();
	}

	// Method to enter text into the Staffing Owner field
	public void clearStaffingOwner() {
			txtStaffingOwner.clear();
	}

	// Method to click on the Search button
	public void clickSearchButton() {
			btnSearch.click();
	}
	
	public String getARNumResult() {
		String newARNumRes= linkARNumResult.getText();
		return newARNumRes;
	}
}
