package co.com.sofka.certification.stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static co.com.sofka.certification.tasks.CheckGPS.verifyGpsStatus;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.INPUT_LATITUDE;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.INPUT_LONGITUDE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import co.com.sofka.certification.questions.AreCoordinatesPresent;
import co.com.sofka.certification.tasks.RequestCoordinates;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaptureCoordinatesStepDefinition {
    private Actor actor;

    @Before
    public void prepareStage() {
        setTheStage(new OnlineCast());
        actor = OnStage.theActorCalled("Juan");
    }

    @When("Request the coordinates")
    public void requestTheCoordinates() {
        actor.attemptsTo(
                RequestCoordinates.current(),
                verifyGpsStatus()
        );
    }

    @Then("The system displays latitude and longitude of the current location")
    public void theSystemDisplaysLatitudeAndLongitudeOfTheCurrentLocation() {
        actor.attemptsTo(
                Ensure.that(INPUT_LATITUDE).isDisplayed(),
                Ensure.that(INPUT_LATITUDE).not().text().isEmpty(),
                Ensure.that(INPUT_LONGITUDE).isDisplayed(),
                Ensure.that(INPUT_LONGITUDE).not().text().isEmpty(),
                Ensure.that(AreCoordinatesPresent.isCorrect()).isTrue()
        );
    }
}
