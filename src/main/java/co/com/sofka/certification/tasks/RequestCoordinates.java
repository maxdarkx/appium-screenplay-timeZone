package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.sofka.certification.userinterfaces.CoordinatesUI.BUTTON_CONSULT_COORDINATES;

public class RequestCoordinates implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(BUTTON_CONSULT_COORDINATES)
        );
    }

    public static RequestCoordinates current()
    {
        return Tasks.instrumented(RequestCoordinates.class);
    }
}
