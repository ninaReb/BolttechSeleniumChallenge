package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MainSteps {
	
	@Given("I navigate to the Main Page")
	public void i_navigate_to_main_page() {
		System.out.println("Background");
	}
	@Given("I disable any ad blocker on my browser")
	public void i_disable_any_ad_blocker_on_my_browser() {
		System.out.println("hello");
	}
	@When("I wait for the dropdown list of price ranges to be visible")
	public void i_wait_for_the_dropdown_list_of_price_ranges_to_be_visible() {
		System.out.println("hello");
	}
	@Then("the dropdown list should be visible")
	public void the_dropdown_list_should_be_visible() {
		System.out.println("hello");
	}
}
