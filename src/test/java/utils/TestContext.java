package utils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestContext {
	public WebDriver driver;
	public WebDriverWait wait;
	

	//System.setProperty("webdriver.chrome.driver","chromedriver-win64/chromedriver.exe");
   // Map<String, String> mobileEmulation = new HashMap<>();
    //mobileEmulation.put("deviceName", "Nexus 5");
   // ChromeOptions chromeOptions = new ChromeOptions();
   // chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	
	//driver = new ChromeDriver(chromeOptions);
	//driver.get("https://bolttech.co.th/en/ascend/device-protection?utm_source=ascend");

}
