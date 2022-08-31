package co.com.sofka.certification.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.targets.Target;

import java.util.Locale;

public class CoordinateFormat implements Question<String> {
    private Target coordinate;

    @Override
    public String answeredBy(Actor actor) {
        String dataCoordinate = coordinate.resolveFor(actor).getText().split(" ")[1];
        Float formatCoordinate = Float.valueOf(dataCoordinate);
        return String.format(Locale.ROOT,"%.4f",formatCoordinate );
    }

    public static CoordinateFormat fixedCoordinateFormat() {
        return new CoordinateFormat();
    }

    public CoordinateFormat usingCoordinate(Target givenCoordinate) {
        coordinate = givenCoordinate;
        return this;
    }
}
