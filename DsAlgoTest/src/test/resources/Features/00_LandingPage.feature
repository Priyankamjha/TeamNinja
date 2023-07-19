Feature: Landing Page

  Background: 
    Given The user opens DS Algo portal link
    When The user clicks the Get Started button
    Then The user should be redirected to homepage

  @Test_LandingPage_01
  Scenario: User Validates the Title of the Page
    Then user gets the Page Title as "NumpyNinja"
