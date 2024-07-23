package stepDefinitions;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {
	public WebDriver driver;
	@Before 
	public void BoltChallengeSetup(){
		System.out.println("before");
		System.setProperty("webdriver.chrome.driver","chromedriver-win64/chromedriver.exe");
		
	    Map<String, String> mobileEmulation = new HashMap<>();
	    mobileEmulation.put("deviceName", "Nexus 5");
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
		
		driver = new ChromeDriver(chromeOptions);
		driver.get("https://bolttech.co.th/en/ascend/device-protection?utm_source=ascend");
	}
	
	@After 
	public void tearDown(){
		System.out.println("tearDown");
		driver.quit();
	}
	


}
