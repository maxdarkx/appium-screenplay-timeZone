package co.com.sofka.certification.tasks;

import static co.com.sofka.certification.userinterfaces.CoordinatesUI.BUTTON_CONSULT_COORDINATES;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.DriverTask;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.function.Consumer;


public class RequestCoordinates implements Task {
    private Actor actor;
    private Object Consumer;

    @Override
    public <T extends Actor> void performAs(T actor) {
        this.actor = actor;
        actor.attemptsTo(
                Click.on(BUTTON_CONSULT_COORDINATES),
                swipeDown(BUTTON_CONSULT_COORDINATES)
        );
    }

    public static RequestCoordinates current() {
        return Tasks.instrumented(RequestCoordinates.class);
    }

    public Performable swipeDown(Target target) {
        WebElement element = target.resolveFor(actor).getElement();
        return new DriverTask(
                driver -> {
                    new TouchActions(driver).scroll(element, 0, 25).perform();
                }
        );
    }
}
