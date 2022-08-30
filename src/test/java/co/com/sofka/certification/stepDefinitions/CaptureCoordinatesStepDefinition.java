package co.com.sofka.certification.stepDefinitions;

import co.com.sofka.certification.exceptions.CoordinateQueryException;
import co.com.sofka.certification.questions.AreCoordinatesPresent;
import co.com.sofka.certification.tasks.RequestCoordinates;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import static co.com.sofka.certification.exceptions.CoordinateQueryException.MSG_COORD_EXCEPTION;
import static co.com.sofka.certification.tasks.CheckGPS.verifyGpsStatus;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static org.hamcrest.Matchers.equalTo;

public class CaptureCoordinatesStepDefinition {
    private Actor actor ;

    @Before
    public void prepareStage()
    {
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
                       Ensure.that(AreCoordinatesPresent.isCorrect()).isTrue()
       );
    }
}
