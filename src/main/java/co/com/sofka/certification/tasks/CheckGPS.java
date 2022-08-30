package co.com.sofka.certification.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import static co.com.sofka.certification.userinterfaces.CoordinatesUI.BUTTON_ALLOW_GPS_PERMISSION;

public class CheckGPS implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Check.whether(BUTTON_ALLOW_GPS_PERMISSION.resolveFor(actor).isVisible())
                        .andIfSo(
                                Click.on(BUTTON_ALLOW_GPS_PERMISSION),
                                RequestCoordinates.current()
                        )
        );
    }

    public static CheckGPS verifyGpsStatus()
    {
        return new CheckGPS();
    }
}
