package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ARCreationPage extends BasePage{

	public ARCreationPage(WebDriver driver) {
		super(driver);
	}
	
	WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(15));
	
	//@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:it4::content']") WebElement txtArId;
	@FindBy(xpath = "//label[text()='AR ID']//..//following-sibling::td//input[@type='text']") WebElement txtArId;
	@FindBy(xpath = "//a[contains(@title,'Search: Project Name')]") WebElement drpProjectName;
	@FindBy(xpath = "//a[text()='Search...']") WebElement lnkSearchProjectName;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:name1Id::_afrLovInternalQueryId:value20::content']") WebElement txtProjectNumber;
	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:name1Id::_afrLovInternalQueryId::search']") WebElement btnProjectSearch;
	@FindBy(xpath = "(//table[contains(@class,'x1hi x1i6')]//tbody//span)[2]") WebElement lnkselectProject;
	@FindBy(xpath = "//button[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:name1Id::lovDialogId::ok']") WebElement btnClickOkProject;
	@FindBy(xpath = "//label[text()='Location']//..//following-sibling::td//input[@type='text']") WebElement txtLocation;
	@FindBy(xpath = "//select[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:soc3::content']") WebElement drpAssignment;
	@FindBy(xpath = "//select[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:soc3::content']//option[@value='0']") WebElement drpAssignmentTypeValue;
	@FindBy(xpath = "//input[@aria-label='Requested Quantity']") WebElement txtRequestedQuantity;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:id1::content']") WebElement txtRequestedStartDate;
	@FindBy(xpath = "//input[@aria-describedby='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:id2_afrdescBy']") WebElement txtRequestedFinishDate;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:projectRoleId::content']") WebElement txtRequestedProjectRole;
	@FindBy(xpath = "//select[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1Iterator__FLEX_Context__FLEX_EMPTY::content']") WebElement drpContextSegment;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorserviceLineAssociateRequestDetails::content']") WebElement txtServiceLine;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorcountryAssociateRequestDetails::content']") WebElement txtCountry;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorfulfilmentByAssociateRequestDetails::content']") WebElement txtFulfilmentBy;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorresourceTypeAssociateRequestDetails::content']") WebElement txtResourceType;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratortsrAssociateRequestDetails::content']") WebElement txtTSR;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorgradeAssociateRequestDetails::content']") WebElement txtGrade;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorverticalAssociateRequestDetails::content']") WebElement txtVertical;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorpercentageOfAllocationAssociateRequestDetails::content']") WebElement txtPercentageofAllocation;
	@FindBy(xpath = "//input[@id='pt1:_FOr1:1:_FONSr2:0:MAt3:0:pt1:AP1:df1_ResourceRequestDFF1IteratorbillingStatusAssociateRequestDetails::content']") WebElement txtBillingStatus;
	
	//submit
	@FindBy(xpath = "//a[@accesskey='m']") WebElement btnSubmitAr;
	@FindBy(xpath = "//a[@class='xri' and @accesskey='Y']") WebElement lnkClickYes;
	@FindBy(xpath = "//a[@accesskey='C']") WebElement lnkCloseARScreen;
	
	
	
	public void setARID(String arID) {
	    txtArId.sendKeys(arID);
	}

	public void clickProjectNameDropDown() {
	    drpProjectName.click();
	}

	public void clickProjectNameSearch() {
	    lnkSearchProjectName.click();
	}

	public void setProjectNumber(String projectNumber) {
	    txtProjectNumber.sendKeys(projectNumber);
	}

	public void clickProjectSearch() {
	    btnProjectSearch.click();
	}

	public void selectProject() {
	    lnkselectProject.click();
//		Actions ac=new Actions(driver);
//		ac.doubleClick(lnkselectProject);
	}

	public void clickOkButtonProject() {
	    btnClickOkProject.click();
	}

	public void setLocation(String location) {
	    txtLocation.sendKeys(location);
	}

	public void selectAssignmentType() {
	    Select sel = new Select(drpAssignment);
	    sel.selectByIndex(0);
	}

	public void setRequestedQuantity(String quantity) {
		txtRequestedQuantity.clear();
	    txtRequestedQuantity.sendKeys(quantity);
	}

	public void setRequestedStartDate(String startData) {
	    txtRequestedStartDate.clear();
	    txtRequestedStartDate.sendKeys(startData);
	}

	public void setRequestedFinishDate(String endData) {
	    txtRequestedFinishDate.clear();
	    txtRequestedFinishDate.sendKeys(endData);
	}

	public void setRequestedProjectRole(String role) {
	    txtRequestedProjectRole.sendKeys(role);
	}

	public void selectContextSegment(String conValue) {
	    Select sel = new Select(drpContextSegment);
	    sel.selectByVisibleText(conValue);
	}

	public void setServiceLine(String serviceLine) {
	    txtServiceLine.sendKeys(serviceLine);
	}

	public void setCountry(String country) {
	    txtCountry.sendKeys(country);
	}

	public void setFulfilmentBy(String fulfilmentBy) {
	    txtFulfilmentBy.clear();
	    txtFulfilmentBy.sendKeys(fulfilmentBy);
	}

	public void setResourceType(String resourceType) {
	    txtResourceType.clear();
	    txtResourceType.sendKeys(resourceType);
	}

	public void setTSR(String tsr) {
	    txtTSR.sendKeys(tsr);
	}

	public void setGrade(String grade) {
	    txtGrade.sendKeys(grade);
	}

	public void setVertical(String vertical) {
	    txtVertical.sendKeys(vertical);
	}

	public void setPercentageofAllocation(String percentage) {
	    txtPercentageofAllocation.sendKeys(percentage);
	}

	public void setBillingStatus(String billingStatus) {
	    txtBillingStatus.sendKeys(billingStatus);
	    // Select sel = new Select(txtBillingStatus);
	    // sel.selectByVisibleText(billingStatus);
	}

	public void clickSubmitAr() {
	    btnSubmitAr.click();
	}

	public void clickYes() {
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='xri' and @accesskey='Y']"))).click();
//	    lnkClickYes.click();
	}

	public void clickCloseARScreen() {
//		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@accesskey='C']"))).click();
		mywait.until(ExpectedConditions.elementToBeClickable(lnkCloseARScreen)).click();
//	    lnkCloseARScreen.click();
	}
	
}
