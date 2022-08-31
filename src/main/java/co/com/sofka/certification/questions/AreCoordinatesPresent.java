package co.com.sofka.certification.questions;

import static co.com.sofka.certification.userinterfaces.CoordinatesUI.BUTTON_SEND;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.INPUT_LATITUDE;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.INPUT_LONGITUDE;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class AreCoordinatesPresent implements Question<Boolean> {

    @Override
    public Boolean answeredBy(Actor actor) {
       return  INPUT_LATITUDE.resolveFor(actor).isVisible() &&
               !INPUT_LATITUDE.resolveFor(actor).getText().isEmpty() &&
               INPUT_LONGITUDE.resolveFor(actor).isVisible() &&
               !INPUT_LONGITUDE.resolveFor(actor).getText().isEmpty() &&
               BUTTON_SEND.resolveFor(actor).isVisible();
    }

    public static AreCoordinatesPresent isCorrect()
    {
        return new AreCoordinatesPresent();
    }
}
