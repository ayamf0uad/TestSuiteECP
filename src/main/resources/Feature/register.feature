
Feature: User could register with valid data

  Background: User open browser
    And User navigates to registration page


  #Test Scenario 1 - Valid Credentials
  @smoke
  Scenario: User registering with valid data
    When User enters valid credentials 'Aya' and "Fouad" and "supernewemail@test.com" and "password" and "password"
    And User clicks register button
    Then User can register successfully

  #Test Scenario 2 - First name can't be blank
  Scenario: User registering without first name
    When User enters valid credentials '' and "Fouad" and "email@test.com" and "password" and "password"
    And User clicks register button
    Then First name error message appears

  #Test Scenario 3 - Last name can't be blank
  Scenario: User registering without last name
    When User enters valid credentials 'Aya' and "" and "email@test.com" and "password" and "password"
    And User clicks register button
    Then Last name error message appears

  #Test Scenario 4 - email can't be blank
  Scenario: User registering without email
    When User enters valid credentials 'Aya' and "Fouad" and " " and "password" and "password"
    And User clicks register button
    Then Email error message appears

  #Test Scenario 5 - email must be in valid email format
  Scenario: User registering with invalid email
    When User enters valid credentials 'Aya' and "Fouad" and "invalidemailformat" and "password" and "password"
    And User clicks register button
    Then Invalid email error message appears

  #Test Scenario 6 - password and confirm password must match
  Scenario: User registering with mis-matched passwords
    When User enters valid credentials 'Aya' and "Fouad" and "email@test.com" and "password" and "password123"
    And User clicks register button
    Then Password match error message appears

  #Test Scenario 7 - password can't be less than 6 characters
  Scenario: User registering with invalid password
    When User enters valid credentials 'Aya' and "Fouad" and "email@test.com" and "1234" and "1234"
    And User clicks register button
    Then Valid password error message appears

  #Test Scenario 8 - User can't register with the same email twice
  Scenario: User registering with an already registered email
    When User enters valid credentials 'Aya' and "Fouad" and "newemail@test.com" and "password" and "password"
    And User clicks register button
    Then Email exists error message appears

