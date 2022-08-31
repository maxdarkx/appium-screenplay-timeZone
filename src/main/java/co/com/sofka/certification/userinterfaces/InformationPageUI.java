package co.com.sofka.certification.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;

import org.openqa.selenium.By;

public class InformationPageUI {
    public static final Target ET_LONGITUDE = Target.the("EditText containing the longitude")
            .located(By.id("txtLng"));
    public static final Target ET_LATITUDE = Target.the("EditText containing the latitude")
            .located(By.id("txtLat"));
    public static final Target ET_COUNTRY_CODE = Target.the("EditText containing the country code")
            .located(By.id("txtCountryCode"));
    public static final Target ET_GMT_OFFSET = Target.the("EditText containing the GMT offset")
            .located(By.id("txtGmtOffset"));
    public static final Target ET_TIMEZONE_ID = Target.the("EditText containing the selected zone timezone")
            .located(By.id("txtTimezoneId"));
    public static final Target ET_COUNTRY_NAME = Target.the("EditText containing the country Name")
            .located(By.id("txtCountryName"));
}
