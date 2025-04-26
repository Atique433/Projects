package com.stepdefs;
import api.ApiAddParticipant;
import api.ParticipantPojo;
import DataBase.ProgramsDb;
import io.restassured.response.Response;
import org.testng.Assert;
import pagefactory.*;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utility.UtilityClass;

public class ProgramsStepdefs extends BaseClass
{
    Logger logger = LogManager.getLogger(ProgramsStepdefs.class);
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @Given("launch the base url")
    public void launchTheBaseUrl() throws InterruptedException {

        portalSignIn =new PortalSignIn(driver);
        portalSignIn.baseUrl();
    }
    @When("user enter username and password on SignIn page")
    public void userEnterUsernameAndPasswordOnSignInPage() throws InterruptedException {
        portalSignIn.signIn();
    }
    @Then("user should be landed on HomePage")
    public void userShouldBeLandedOnHomePage() {
        portalSignIn.navigateToHomePage();
    }

    @And("click on hamburger menu and further select the batch")
    public void clickOnHamburgerMenuAndFurtherSelectTheBatch() throws InterruptedException {
        homePage=new HomePage(driver);
        homePage.portalHomePage();
    }
    @Given("user should be on add participant page")
    public void userShouldBeOnAddParticipantPage() {
        homePage.navigateToAddParticipant();
    }

    @When("enter the details {string},{string},{string},{string},{string},{string} and {string} and click save")
    public void enterTheDetailsAndAndClickSave(String name, String email, String gender, String status, String isFaculty, String college, String mobile) throws InterruptedException {
        homePage.navigateToAddParticipant().addDetails(name,email,gender);
        homePage.navigateToAddParticipant().addAdditionalDetails(status,isFaculty,college,mobile);
    }

    @Then("participant should be added successfully")
    public void participantAddedSuccessfully() throws IOException {
        UtilityClass.takeScreenShot(driver,"AddParticipant");
        logger.info("participant Added successfully");
    }
    @When("search with name as in search box")
    public void searchWithNameAsInSearchBox(List<String> search) throws InterruptedException {
        for (String e:search){
            homePage.navigateToReadParticipant().searchByName(e);
        }
        // homePage.navigateToReadParticipant().searchByName(search.get(1));
    }
    @Then("able to read participant details")
    public void ableToReadParticipantDetails() throws IOException {
        UtilityClass.takeScreenShot(driver,"ReadParticipant");
        logger.info("participant details visible");
    }

    @And("when click on the edit button")
    public void whenClickOnTheEditButton(){
        homePage.navigateToUpdateParticipant().editButton();
    }

    @Then("update the name of participant")
    public void updateTheNameOfParticipant(List<String> update)throws IOException {
        homePage.navigateToUpdateParticipant().updateDetails(update.get(0));
        UtilityClass.takeScreenShot(driver,"UpdateParicipant");
    }

    @Then("click on delete button and delete the participant")
    public void clickOnDeleteButtonAndDeleteTheParticipant() throws InterruptedException, IOException {
        homePage.navigateToDeleteParticipant().deleteParticipant();
        UtilityClass.takeScreenShot(driver,"DeleteParticipant");
    }

    @Then("participant details should not be visible")
    public void participantDetailsShouldNotBeVisible() throws InterruptedException {
        homePage.navigateToVerifyParticipant().verifyByName();
        homePage.navigateToVerifyParticipant().check();
    }
    @When("enter the details as email")
    public void enterTheDetailsAsEmail( List<String> verify) throws IOException {
        UtilityClass.takeScreenShot(driver,"verifyParticipant");
        apiAddParticipant=new ApiAddParticipant();
        Response apiResponse=apiAddParticipant.getParticipantDetails(verify.get(0));
        ParticipantPojo participantPojo =apiResponse.as(ParticipantPojo.class);
        logger.info(participantPojo.getParticipantEmail());
        logger.info(verify.get(0));
        Assert.assertEquals(participantPojo.getParticipantEmail(),verify.get(0));
    }
    @Given("to verify with name")
    public void toVerifyWithName() throws SQLException, ClassNotFoundException {
        ProgramsDb programsDb=new ProgramsDb();
        programsDb.programs();
    }
//    @After
//    public void tearDown(){
//        driver.quit();
//    }
}


