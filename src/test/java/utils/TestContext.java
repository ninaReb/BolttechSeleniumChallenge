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
	public  WebDriver driver;
	public WebDriverWait wait;
	
	public WebElement getDropdown() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement shadowHost = driver.findElement(By.cssSelector("edi-section > edi-device-protection-form"));
		SearchContext rootNode = shadowHost.getShadowRoot();
		WebElement secondaryRootHost = rootNode.findElement(By.cssSelector(".form-component"));
		SearchContext secondaryRootNode = secondaryRootHost.getShadowRoot();
        WebElement container = secondaryRootNode.findElement(By.cssSelector("#container.container"));

        try {
        	Thread.sleep(5000);
        	} catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
        
        WebElement purchasePriceDropdown = container.findElement(By.cssSelector("#purchasePrice"));
        
        
        return purchasePriceDropdown;
		
	};
	

	//System.setProperty("webdriver.chrome.driver","chromedriver-win64/chromedriver.exe");
   // Map<String, String> mobileEmulation = new HashMap<>();
    //mobileEmulation.put("deviceName", "Nexus 5");
   // ChromeOptions chromeOptions = new ChromeOptions();
   // chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
	
	//driver = new ChromeDriver(chromeOptions);
	//driver.get("https://bolttech.co.th/en/ascend/device-protection?utm_source=ascend");

}
