package co.com.sofka.certification.exceptions;

public class CoordinateQueryException  extends AssertionError{
    public static final String MSG_COORD_EXCEPTION = "El sistema no puede encontrar los datos requeridos";
    public CoordinateQueryException(String message, Throwable cause)
    {
        super(message, cause);
    }
}
