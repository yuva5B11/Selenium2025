package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TestCaseBase {

	public String URL = "";

	public static WebDriver driver;
	Properties pr;

	public Properties readPropertiedFile() throws IOException {
		FileReader fr = new FileReader(".//src//test//resources//config.properties");
		pr = new Properties();
		pr.load(fr);
		return pr;
	}

	@BeforeClass(groups = { "Regression", "Master", "Sanity" })
	@Parameters({ "browser", "os" })
	public void setUp(String br, String os) throws IOException {
		readPropertiedFile();
		// OS
		if (pr.getProperty("Environment").equalsIgnoreCase("hub")) {
			DesiredCapabilities capabilities = new DesiredCapabilities();

			if (os.equalsIgnoreCase("Windows")) {
				capabilities.setPlatform(Platform.WIN11);
			} else if (os.equalsIgnoreCase("mac")) {
				capabilities.setPlatform(Platform.MAC);
			} else if (os.equalsIgnoreCase("linux")) {
				capabilities.setPlatform(Platform.LINUX);
			} else {
				System.out.println("invalid operating system......");
			}
			// browser
			switch (br.toLowerCase()) {
			case "chrome":
				capabilities.setBrowserName("chrome");
				break;
			case "edge":
				capabilities.setBrowserName("MicrosoftEdge");
				break;
			default:
				System.out.println("invalid browser....");
				return;
			}

			driver = new RemoteWebDriver(new URL(pr.getProperty("BROWSERSTACK_HUB")), capabilities);
		} else if (pr.getProperty("Environment").equalsIgnoreCase("browserstack")) {
			MutableCapabilities capabilities = new MutableCapabilities();
			HashMap<String, Object> bstackOptions = new HashMap<String, Object>();
			capabilities.setCapability("browserName", "Edge");
			bstackOptions.put("os", "Windows");
			bstackOptions.put("osVersion", "11");
			bstackOptions.put("browserVersion", "latest");
//			bstackOptions.put("userName", "yuvarajk_U7xLYt");
			bstackOptions.put("userName",pr.getProperty("BROWSERSTACK_USERNAME"));
//			bstackOptions.put("accessKey", "7t4eyWh6ad4H6krxnYV7");BROWSERSTACK_ACCESS_KEY
			bstackOptions.put("accessKey", pr.getProperty("BROWSERSTACK_ACCESS_KEY"));
			bstackOptions.put("seleniumVersion", "4.29.0");
			capabilities.setCapability("bstack:options", bstackOptions);
			driver = new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), capabilities);
		} else if (pr.getProperty("Environment").equalsIgnoreCase("local")) {
			switch (br.toLowerCase()) {
			case "chrome":
				driver = new ChromeDriver();
				break;
			case "edge":
				driver = new EdgeDriver();
				break;
			case "firefox":
				driver = new FirefoxDriver();
				break;
			default:
				System.out.println("invalid browser..........." + br);
				return;
			}
		}else if(pr.getProperty("Environment").equalsIgnoreCase("SauceLabs")) {
			ChromeOptions browserOptions = new ChromeOptions();
			browserOptions.setPlatformName("Windows 11");
			browserOptions.setBrowserVersion("latest");
			Map<String, Object> sauceOptions = new HashMap<>();
			sauceOptions.put("username", "oauth-yuvarajkanderi0909-643a5");
			sauceOptions.put("accessKey", "34b48513-fcbd-4155-b28f-7b0ddff875ed");
			sauceOptions.put("build", "selenium-build-H2E98");
			sauceOptions.put("name", "sampleTest");
			browserOptions.setCapability("sauce:options", sauceOptions);
			
			// start the session
			URL url = new URL("https://ondemand.us-west-1.saucelabs.com:443/wd/hub");
			RemoteWebDriver driver = new RemoteWebDriver(url, browserOptions);

			// run commands and assertions
			driver.get("https://saucedemo.com");
			String title = driver.getTitle();
			boolean titleIsCorrect = title.contains("Swag Labs");
			String jobStatus = titleIsCorrect ? "passed" : "failed";

			// end the session
			driver.executeScript("sauce:job-result=" + jobStatus);
		}
		
		

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().deleteAllCookies();
		driver.get(pr.getProperty("appUrl"));

		// loginPage
		LoginPage lp = new LoginPage(driver);
		lp.setUserId(pr.getProperty("userId"));
		lp.setPassword(pr.getProperty("password"));
		lp.clickLogin();
	}

	@AfterClass(groups = { "Regression", "Master", "Sanity" })
	public void closeBrowser() {
		HomePage hp = new HomePage(driver);
		hp.clickLogOut();
		driver.quit();
	}

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

		String targetFilePath = System.getProperty("user.dir") + "//screenshots//" + tname + "_" + timeStamp + ".png";

		// String
		// targetPath=System.getProperty("user.dir")+"//screenShots//"+tname+"_"+timeStamp+".png";

		File targetFile = new File(targetFilePath);

		sourceFile.renameTo(targetFile);

		return targetFilePath;

	}

}
