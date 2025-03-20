package testCases;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.ARCreationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.ProjectResourcesPage;
import testBase.TestCaseBase;
import utilities.DataProvidersTest;
import utilities.ExcelUtility;

public class TC_001_CreateAR extends TestCaseBase {
//	Properties pr;
//	String tempPatth = ".//testData/Automation_TestData.xlsx";

	@Test(dataProvider = "CreateAR", dataProviderClass = DataProvidersTest.class,groups = {"Sanity"})
	public void verifyCreateAR(String arId, String projectNumber, String Location, String quantity, String sDate,
			String fDate, String role, String conValue, String serviceLine, String country, String fulFilmentBy,
			String resourceType, String tsr, String grade, String vertical, String percentageAllocation,
			String billingStatus) throws InterruptedException, IOException {
		
		try {
//			pr= readPropertiedFile();
//			LoginPage lp=new LoginPage(driver);
//			lp.setUserId(pr.getProperty("userId"));
//			lp.setPassword(pr.getProperty("password"));
//			lp.clickLogin();
			
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickHome();
			hp.clickProjects();
			hp.clickProjectResources();
			// projectResourcesPage
			ProjectResourcesPage prp = new ProjectResourcesPage(driver);
			prp.clickTask();
			prp.clickManageProjectResourceRequest();

			// get row count
//			ExcelUtility eu = new ExcelUtility(tempPatth);
//			int rowcount = eu.getRowCount("ARCreation");
//			System.out.println(rowcount);

//			for(int a=1;a<=rowcount;a++) {
				
				System.out.println("arId................"+arId);
				// ARCreation
				prp.clickCreateAR();
				ARCreationPage ap = new ARCreationPage(driver);

				ap.setARID(arId); // 1
				ap.clickProjectNameDropDown();
				ap.clickProjectNameSearch();
				ap.setProjectNumber(projectNumber); // 2
				ap.clickProjectSearch();
				ap.selectProject();
				ap.clickOkButtonProject();
				ap.setLocation(Location); // 3
//				Thread.sleep(3000);
				ap.selectAssignmentType();
				Thread.sleep(2000);
				ap.setRequestedQuantity(quantity); // 4
				ap.setRequestedStartDate(sDate); // 5
				ap.setRequestedFinishDate(fDate); // 6
				ap.setRequestedProjectRole(role); // 7
				ap.selectContextSegment(conValue); // 8
				ap.setServiceLine(serviceLine); // 9
				ap.setCountry(country); // 10
				ap.setFulfilmentBy(fulFilmentBy); // 11
				ap.setResourceType(resourceType); // 12
				ap.setTSR(tsr); // 13
				ap.setGrade(grade); // 14
				ap.setVertical(vertical); // 15
				ap.setPercentageofAllocation(percentageAllocation); // 16
				ap.setBillingStatus(billingStatus); // 17
				ap.clickSubmitAr();
				ap.clickYes();
				Thread.sleep(2000);
				ap.clickCloseARScreen();
				
			//Validation of new AR
			//SearchAR
				prp.clickExpandSearchAR();
				prp.enterARID(arId);
				prp.clickStatusDropdown();
				prp.selectStatusAll();
				prp.enterProjectNumber(projectNumber);
				prp.clearStaffingOwner();
				prp.clickSearchButton();
				String ARNum= prp.getARNumResult();
				Assert.assertEquals(ARNum, arId);
				
				//double click
				
//				}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			Assert.fail();
		}
		
	}
}
