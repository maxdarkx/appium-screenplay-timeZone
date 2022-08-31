Feature: As QA of the timezone mobile app
  I want to test the operation of the longitude and latitude data capture
  To guarantee the quality of the application

  Scenario: Test that the capture of coordinates works when the access to cell location has been granted
    When Request the coordinates
    Then The system displays latitude and longitude of the current location

  Scenario Outline: Test that the capture of coordinates works in the final application page
    When Juan navigates into the application and it display all coordinates data
    Then He must see all the correct data according to entered data:
      | Name   | Latitude   | Longitude   | CountryName   | CountryCode   | GmtOffset   |
      | <Name> | <Latitude> | <Longitude> | <CountryName> | <CountryCode> | <GmtOffset> |

    Examples:
      | Name      | Latitude | Longitude | CountryName | CountryCode | GmtOffset |
      #| Fabricato | 6.3262   | -75.5587  | Colombia    | CO          | -5        |
      | Casa      | 6.3036   | -75.5590  | Colombia    | CO          | -5        |
      #| Alamedas  | 8.7632   | -75.8734  | Colombia    | CO          | -5        |
      #| Maracaibo | 10.6606  | -71.6545  | Venezuela   | VE          | -4        |
