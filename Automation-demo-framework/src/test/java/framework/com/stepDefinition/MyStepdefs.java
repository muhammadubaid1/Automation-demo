package framework.com.stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

import static framework.com.locators.Homepage.*;
import static framework.com.utils.Base.getDriver;

public class MyStepdefs {
    @Given("Open sauce demo website")
    public void openSauceDemoWebsite() {
        getDriver().get("https://www.google.com");
    }

    @When("I add sauce lab back pack")
    public void iAddSauceLabBackPack() {
        Assert.assertEquals(getDriver().findElement(PRODUCT_TITLE).getText(), "Sauce Labs Backpack");
        getDriver().findElement(BTN_ADD_TO_CART).click();
    }

    @Then("Validate it should add to the cart")
    public void validateItShouldAddToTheCart() {
        Assert.assertTrue(getDriver().findElement(CART).isDisplayed(), "Product is not added to cart successfully");
    }
}
