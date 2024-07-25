package stepDefinitions;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContext;

import java.time.Duration;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LandingPageStepDefinition {
	TestContext testContext;
	public LandingPageStepDefinition(TestContext testContext) {
		this.testContext = testContext;
	};
	WebElement randomItem;
	String landingUTM;
	String paymentUTM;
	@Given("I navigate to the Main Page")
	public void i_navigate_to_main_page() {
		String currentURL = testContext.driver.getCurrentUrl();
		landingUTM = currentURL.substring(currentURL.lastIndexOf("?") + 1);
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
        	Thread.sleep(5000);
        	} catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
        
        WebElement purchasePriceDropdown = container.findElement(By.cssSelector("#purchasePrice"));
        wait.until(ExpectedConditions.visibilityOf(purchasePriceDropdown));

	}
	
	@Then("the dropdown list should be visible")
	public void the_dropdown_list_should_be_visible() {
		WebElement dropdown = testContext.getDropdown();
		Assert.assertTrue(dropdown.isDisplayed(), "Dropdown is not visible");
	}
	
	@When("I select a random price from the dropdown")
	public void i_select_a_random_price_from_the_dropdown() {
		WebElement dropdown = testContext.getDropdown();
		SearchContext dropdownNode = dropdown.getShadowRoot();
		Random random = new Random();
		int randomNumber = random.nextInt(7);
		System.out.println(randomNumber);
		String selector = "#list li:nth-child(" + randomNumber + ")";
		System.out.println(selector);
		randomItem = dropdownNode.findElement(By.cssSelector(selector));
		dropdown.click();
		randomItem.click();

	}

	
	@Then("the selected price should be correctly displayed in the dropdown")
	public void the_selected_price_should_be_correctly_displayed_in_the_dropdown() {
		// Write code here that turns the phrase above into concrete actions
		WebElement dropdown = testContext.getDropdown();
		SearchContext dropdownNode = dropdown.getShadowRoot();
		dropdown.click();
		String listItemText = dropdownNode.findElement(By.cssSelector("li.item-selected")).getAttribute("innerText");
		String dropDownText = dropdownNode.findElement(By.cssSelector("#selected")).getAttribute("innerText");
		System.out.println("in list " + listItemText);
		System.out.println("displayed " + dropDownText);
		Assert.assertEquals(listItemText, dropDownText);
		
		
	}
	
	@When("I select the price {string} from the dropdown")
	public void i_select_the_price_from_the_dropdown(String string) {
		WebElement dropdown = testContext.getDropdown();
		dropdown.click();
		String script = "return Array.from(document.querySelectorAll('#list li')).find(element => element.innerText === 'THB " + string + "');";
		System.out.println(script);
		WebElement listItemByText = (WebElement) ((JavascriptExecutor) testContext.driver).executeScript(script);
		listItemByText.click();
		
	}
	
	@Then("the selected price {string} should be correctly displayed in the dropdown")
	public void the_selected_price_should_be_correctly_displayed_in_the_dropdown(String string) {
		WebElement dropdown = testContext.getDropdown();
		SearchContext dropdownNode = dropdown.getShadowRoot();
		dropdown.click();
		String listItemText = dropdownNode.findElement(By.cssSelector("li.item-selected")).getAttribute("innerText");
		String dropDownText = dropdownNode.findElement(By.cssSelector("#selected")).getAttribute("innerText");
		System.out.println("in list " + listItemText);
		System.out.println("displayed " + dropDownText);
		Assert.assertEquals(listItemText, dropDownText);
	}
	
	@Given("I have selected a device purchase price")
	public void i_have_selected_a_device_purchase_price() {
		WebElement dropdown = testContext.getDropdown();
		SearchContext dropdownNode = dropdown.getShadowRoot();
		Random random = new Random();
		int randomNumber = random.nextInt(6) + 1;
		System.out.println(randomNumber);
		String selector = "#list li:nth-child(" + randomNumber + ")";
		System.out.println(selector);
		randomItem = dropdownNode.findElement(By.cssSelector(selector));
		dropdown.click();
		randomItem.click();


	}
	@When("I click on the Select button on the card")
	public void i_click_on_the_button_on_the_card_with_price() {
		
		WebElement secondaryRootHost = testContext.driver.findElement(By.cssSelector("edi-card-slider > edi-card-vertical"));
		SearchContext secondaryRootNode = secondaryRootHost.getShadowRoot();
		WebElement tertiaryRootHost = secondaryRootNode.findElement(By.cssSelector("edi-card-vertical-content"));
		SearchContext tertiaryRootNode = tertiaryRootHost.getShadowRoot();
		WebElement buttonRootHost = tertiaryRootNode.findElement(By.cssSelector(".edi-submit-cta"));
		SearchContext buttonRootNode = buttonRootHost.getShadowRoot();
		WebElement selectButton = tertiaryRootNode.findElement(By.cssSelector("edi-cta__button"));
		selectButton.click();
		System.out.println("clicked select");
	}
	@Then("I should be navigated to the checkout page")
	public void i_should_be_navigated_to_the_checkout_page() {
        try {
        	Thread.sleep(30000);
        	} catch (InterruptedException e) {
        	// TODO Auto-generated catch block
        	e.printStackTrace();
        	}
        
		WebElement shadowHost = testContext.driver.findElement(By.cssSelector("edi-checkout"));
		SearchContext rootNode = shadowHost.getShadowRoot();
		WebElement secondaryRootHost = rootNode.findElement(By.cssSelector("edi-product-summary"));
		SearchContext secondaryRootNode = secondaryRootHost.getShadowRoot();
		WebElement summary = secondaryRootHost.findElement(By.cssSelector("#productSummary"));

		
		Assert.assertTrue(summary.isDisplayed(), "Summary is not visible");
	}
	@Then("the URL should contain {string}")
	public void the_url_should_contain(String string) {
		String strUrl = testContext.driver.getCurrentUrl();
		Assert.assertTrue(strUrl.contains(string));
		
	}
	@Then("the URL should contain the utm_source parameter from the previous page")
	public void the_url_should_contain_the_utm_source_parameter_from_the_previous_page() {
		String currentURL = testContext.driver.getCurrentUrl();
		paymentUTM = currentURL.substring(currentURL.lastIndexOf("?") + 1);
		Assert.assertTrue(paymentUTM.contains(landingUTM));
	}

}
