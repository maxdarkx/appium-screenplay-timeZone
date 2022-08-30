Feature: As QA of the timezone mobile app
  I want to test the operation of the longitude and latitude data capture
  To guarantee the quality of the application

  Scenario: Test that the capture of coordinates works when the access to cell location has been granted
    When Request the coordinates
    Then The system displays latitude and longitude of the current location