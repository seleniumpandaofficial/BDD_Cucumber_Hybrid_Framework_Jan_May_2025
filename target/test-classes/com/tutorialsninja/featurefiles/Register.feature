#Author: panda@piit.us
@Register
Feature: Validating scenarios of Register functionality for TutorialsNinja application

  @MandatoryFields
  Scenario: Register with mandatory fields
    Given User navigates to RegisterPage
    And User enters firstname as "Selenium"
    And User enters lastname as "Panda"
    And User enters email as "Random Email"
    And User enters telephone as "9876543210"
    And User enters password as "Selenium@123"
    And User enters confirmpassword as "Selenium@123"
    And User checks the PrivacyPolicy checkbox
    And User clicks on Continue button
    Then User is navigated to AccountSuccessPage

  @AllFields
  Scenario: Register with all fields
    Given User navigates to RegisterPage
    And User enters firstname as "Selenium"
    And User enters lastname as "Panda"
    And User enters email as "Random Email"
    And User enters telephone as "9876543210"
    And User enters password as "Selenium@123"
    And User enters confirmpassword as "Selenium@123"
    And User selects the Yes radiobutton
    And User checks the PrivacyPolicy checkbox
    And User clicks on Continue button
    Then User is navigated to AccountSuccessPage
    
  
   @DuplicateEmail
   Scenario: Register with duplicate email
    Given User navigates to RegisterPage
    And User enters firstname as "Selenium"
    And User enters lastname as "Panda"
    And User enters email "seleniumpanda@gmail.com" as duplicate email
    And User enters telephone as "9876543210"
    And User enters password as "Selenium@123"
    And User enters confirmpassword as "Selenium@123"
    And User selects the Yes radiobutton
    And User checks the PrivacyPolicy checkbox
    And User clicks on Continue button
    Then User gets warning message about duplicate email
    
    @IncorrectConfirmPassword
    Scenario: Register with incorrect confirm password
    Given User navigates to RegisterPage
    When User enters below fields
    |   firstname   |   Selenium  |
    |   lastname    |   Panda     |
    |   telephone   | 9876543210  |
    |   password    | Selenium@123|
    |confirmpassword|Selenium@123456|
    And User checks the PrivacyPolicy checkbox
    And User clicks on Continue button
    Then User gets warning message about password confirmation
    
    
    
    
    
    
    
    

