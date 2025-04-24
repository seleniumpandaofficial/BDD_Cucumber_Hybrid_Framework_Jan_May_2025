#Author: panda@piit.us

@Login
Feature: Validating scenarios of Login functionality for TutorialsNinja application

#Background: Given User navigates to LoginPage

@ValidCredentials
 Scenario Outline: Login with valid credentials
 Given User navigates to LoginPage
 When User enters valid email <email> into email textBox
 And User enters valid password <password> into password textBox
 And User clicks on Login button
 Then User is re-directed to AccountPage
 Examples:
 |   email                 |   password   |
 |seleniumpanda@gmail.com  | Selenium@123 |
 |seleniumpanda1@gmail.com | Selenium@123 |
 |seleniumpanda2@gmail.com | Selenium@123 |
 |seleniumpanda3@gmail.com | Selenium@123 |
 |seleniumpanda4@gmail.com | Selenium@123 |
 
@InvalidCredentials
 Scenario: Login with invalid credentials
  Given User navigates to LoginPage
  When User enters invalid email "seleniumpanda@gmaill.com"
  And User enters invalid password "Selenium@123456"
  And User clicks on Login button
  Then User gets warning message about credentials mismatch
  
@InvalidPasswordValidEmail
 Scenario: Login with invalid password and valid email
  Given User navigates to LoginPage
  When User enters valid email "seleniumpanda@gmail.com" into email textBox
  And User enters invalid password 123456 into password textBox
  And User clicks on Login button
  Then User gets warning message about credentials mismatch

  
@InvalidEmailValidPassword
 Scenario: Login with invalid email and valid password
  Given User navigates to LoginPage
  When User enters invalid email "seleniumpanda@gmaill.com"
  And User enters valid password "Selenium@123" into password textBox
  And User clicks on Login button
  Then User gets warning message about credentials mismatch
  
@NoCredentials
  Scenario: Login with no credentials
  Given User navigates to LoginPage
  When User clicks on Login button
  Then User gets warning message about credentials mismatch
 