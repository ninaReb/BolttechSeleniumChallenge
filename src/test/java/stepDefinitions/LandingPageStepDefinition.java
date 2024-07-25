package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPageStepDefinition {
	TestContext testContext;
	public LandingPageStepDefinition(TestContext testContext) {
		this.testContext = testContext;
	};
	
	@Given("I navigate to the Main Page")
	public void i_navigate_to_main_page() {

		System.out.println("Background");
	}
	@When("I wait for the dropdown list of price ranges to be visible")
	public void i_wait_for_the_dropdown_list_of_price_ranges_to_be_visible() {
		System.out.println("wait for dropdown");
		WebDriverWait wait = new WebDriverWait(testContext.driver, Duration.ofSeconds(10));
		WebElement shadowHost = testContext.driver.findElement(By.cssSelector("edi-section > edi-device-protection-form"));
		SearchContext rootNode = shadowHost.getShadowRoot();
		WebElement secondaryRootHost = rootNode.findElement(By.cssSelector(".form-component"));
		SearchContext secondaryRootNode = secondaryRootHost.getShadowRoot();
        WebElement container = secondaryRootNode.findElement(By.cssSelector("#container.container"));

        try {
        	Thread.sleep(10000);
        	} catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
        
        WebElement purchasePriceDropdown = container.findElement(By.cssSelector("#purchasePrice"));
        wait.until(ExpectedConditions.visibilityOf(purchasePriceDropdown));

	}
	@Then("the dropdown list should be visible")
	public void the_dropdown_list_should_be_visible() {
		System.out.println("hello");
	}
}
