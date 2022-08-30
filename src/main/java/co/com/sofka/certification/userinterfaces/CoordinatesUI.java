package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class CoordinatesUI {
    public static final Target BUTTON_CONSULT_COORDINATES = Target.the("Button to show the current coordinates")
            .located(By.id("btnConsGeo"));

    public static final Target INPUT_LATITUDE = Target.the("EditText who contains the latitude").located(By.id("txtLatIn"));
    public static final Target INPUT_LONGITUDE = Target.the("EditText who contains the longitude").located(By.id("txtLngIn"));
    public static final Target BUTTON_SEND = Target.the("Button to send the coordinates").located(By.id("btnEnviar"));



}
