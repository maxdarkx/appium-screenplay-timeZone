package co.com.sofka.certification.stepDefinitions;

import static net.serenitybdd.screenplay.actors.OnStage.setTheStage;
import static co.com.sofka.certification.questions.CoordinateFormat.fixedCoordinateFormat;
import static co.com.sofka.certification.tasks.CheckGPS.verifyGpsStatus;
import static co.com.sofka.certification.tasks.SendCoordinates.pressSendCoordinates;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.INPUT_LATITUDE;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.INPUT_LONGITUDE;
import static co.com.sofka.certification.userinterfaces.InformationPageUI.ET_COUNTRY_CODE;
import static co.com.sofka.certification.userinterfaces.InformationPageUI.ET_COUNTRY_NAME;
import static co.com.sofka.certification.userinterfaces.InformationPageUI.ET_GMT_OFFSET;
import static co.com.sofka.certification.userinterfaces.InformationPageUI.ET_LATITUDE;
import static co.com.sofka.certification.userinterfaces.InformationPageUI.ET_LONGITUDE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;

import java.util.List;
import java.util.Map;

import co.com.sofka.certification.questions.AreCoordinatesPresent;
import co.com.sofka.certification.tasks.RequestCoordinates;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CaptureCoordinatesStepDefinition {
    private Actor actor;

    @ParameterType(".*")
    public Actor actor(String actorName) {
        return OnStage.theActorCalled(actorName);
    }

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
                Ensure.that(INPUT_LATITUDE).text().isNotEmpty(),
                Ensure.that(INPUT_LONGITUDE).isDisplayed(),
                Ensure.that(INPUT_LONGITUDE).text().isNotEmpty(),
                Ensure.that(AreCoordinatesPresent.isCorrect()).isTrue()
        );
    }

    @When("{actor} navigates into the application and it display all coordinates data")
    public void juanNavigatesIntoTheApplicationAndItDisplayAllCoordinatesData(Actor actorJuan) {
        actorJuan.attemptsTo(
                RequestCoordinates.current(),
                verifyGpsStatus(),
                pressSendCoordinates()
        );
    }

    @Then("{actor} must see all the correct data according to entered data:")
    public void heMustSeeAllTheCorrectDataAccordingToEnteredData(Actor actorJuan, List<Map<String, String>> requestedData) {
        Map<String, String> collectedData = requestedData.get(0);
        actorJuan.attemptsTo(
                Ensure.that(fixedCoordinateFormat().usingCoordinate(ET_LONGITUDE)).contains(collectedData.get("Longitude")),
                Ensure.that(fixedCoordinateFormat().usingCoordinate(ET_LATITUDE)).contains(collectedData.get("Latitude")),
                Ensure.that(ET_COUNTRY_CODE).text().endsWith(collectedData.get("CountryCode")),
                Ensure.that(ET_COUNTRY_NAME).text().endsWith(collectedData.get("CountryName")),
                Ensure.that(ET_GMT_OFFSET).text().endsWith(collectedData.get("GmtOffset"))
        );
    }
}