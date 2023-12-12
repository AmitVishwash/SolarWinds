package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.OverviewPage;
import pageObjects.Papertrail_LoginPage;
import pageObjects.SolarWinds_HomePage;

public class HomePageImpl {

    SolarWinds_HomePage homePage = new SolarWinds_HomePage(Hooks.driver);
    Papertrail_LoginPage loginPage = new Papertrail_LoginPage(Hooks.driver);

    OverviewPage overviewPage = new OverviewPage(Hooks.driver);

    @Given("User  is on home page of application")
    public void user_is_on_home_page_of_application() {
        homePage.openApplication();
        homePage.isHomePageDisplayed();

    }
    @Given("User clicks on the {string} product category")
    public void user_clicks_on_the_product_category(String productName) {
        homePage.selectProduct(productName);
        loginPage.isLoginPageDisplayed();

    }
    @When("User enters email and password")
    public void user_enters_email_and_password() {
        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickLogin();

    }
    @Then("User should be redirected to Papertrail Overview page")
    public void user_should_be_redirected_to_papertrail_overview_page() {
        overviewPage.isOverviewPageDisplayed();

    }
    @When("user edits the name to {string}")
    public void user_edits_the_name_to(String changedUserName) {
        overviewPage.editUserName(changedUserName);

    }
    @Then("the new user name should be reflected")
    public void the_new_user_name_should_be_reflected() {
        overviewPage.checkUserName();
    }
}
