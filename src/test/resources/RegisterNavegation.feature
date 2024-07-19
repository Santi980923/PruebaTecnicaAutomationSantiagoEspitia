Feature: User Registration And Login
  As a new user
  i want to register on the website
  So that I can access the services


  Scenario: User registers successfully
    Given I navigate to the register page
    When I click on "¡Comienza gratis!" for login or register
    And I fill in the registration form
    And I select "Colombia" as the country
    And I accept the terms and conditions
    Then  I click on "Regístrate ahora" button

  Scenario: User sign in succesfully
    Given I navigate to the register page
    When I click on "Inicia sesión"
    And I fill in the login form
    Then  I click on "Iniciar sesión" button for sign in



