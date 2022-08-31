package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.CoordinatesUI.BUTTON_SEND;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

public class SendCoordinates implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_SEND)
        );
    }

    public static SendCoordinates pressSendCoordinates() {
        return new SendCoordinates();
    }
}
