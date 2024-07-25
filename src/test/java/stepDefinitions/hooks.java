package stepDefinitions;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.TestContext;

public class hooks {
	TestContext testContext;
	public hooks(TestContext testContext) {
		this.testContext = testContext;
	};
	
	@Before 
	public void BoltChallengeSetup(){
		System.out.println("before");
		System.setProperty("webdriver.chrome.driver","chromedriver-win64/chromedriver.exe");
	    Map<String, String> mobileEmulation = new HashMap<>();
	    mobileEmulation.put("deviceName", "Nexus 5");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		
	    testContext.driver = new ChromeDriver(chromeOptions);
	    testContext.driver.get("https://bolttech.co.th/en/ascend/device-protection?utm_source=ascend");
	    testContext.driver.findElement(By.xpath("//*[@id='onetrust-close-btn-container']/button")).click();
	}
	
	@After 
	public void tearDown(){
		System.out.println("tearDown");
		testContext.driver.quit();
	}
	


}
