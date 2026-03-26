package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actions.*;

import starter.tasks.registration.CheckNewAccountCreatedTask;
import starter.tasks.registration.RegisterUserTask;
import starter.tasks.registration.ShouldSeeAllFieldsAreRequiered;
import starter.tasks.registration.DoNotSendAllRequiredInformationTask;
import starter.ui.registration.RegisterPage;

import java.util.List;


public class RegistrationStepDefinitions {

    String expectedName = "";
    String expectedLastName = "";
    String expectedAge = "";
    String expectedEmail = "";
    String expectedCountry = "";



    @Given("{actor} wants to sing up in the application")
    public void pepitoWantsToSingUpInTheApplication(Actor actor){

        actor.attemptsTo(
                //Open.url("http://127.0.0.1:5500/registration/register.html")); //
                Open.browserOn(new RegisterPage()));
    }

    @When("{actor} sends the required information to sign up")
    public void SendsTheRequiredInformationToSignUp(Actor actor, DataTable userInfo) {

        List<List<String>> rows = userInfo.asLists(String.class);

        for (List<String> columns: rows){

            expectedName = columns.get(0);
            expectedLastName = columns.get(1);
            expectedAge = columns.get(2);
            expectedEmail = columns.get(3);
            expectedCountry = columns.get(4);

        }

        actor.attemptsTo(
                new RegisterUserTask(expectedName, expectedLastName, expectedAge, expectedEmail, expectedCountry)
        );
    }

    @Then("{actor} should have a new account created")
    public void ShouldHaveANewAccountCreated(Actor actor) {
        actor.attemptsTo(
                new CheckNewAccountCreatedTask(expectedName, expectedLastName)
        );
    }

    @When("{actor} does not send the required information")
    public void pepitoDoesNotSendTheRequiredInformation(Actor actor) {
        actor.attemptsTo(
                new DoNotSendAllRequiredInformationTask(expectedName,expectedLastName)
        );

    }


    @Then("{actor} should be told all fields are required")
    public void pepitoShouldBeToldAllFieldsAreRequired(Actor actor) {

        actor.attemptsTo(
                new ShouldSeeAllFieldsAreRequiered()
        );

    }


}
