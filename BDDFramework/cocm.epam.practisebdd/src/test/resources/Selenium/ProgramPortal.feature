Feature: Portal Login Test
  Description: to perform curd operation on programs portal page

  Background: Open Browser and land to programs HomePage
    Given launch the base url
    When user enter username and password on SignIn page
    Then user should be landed on HomePage
    And click on hamburger menu and further select the batch

  Scenario Outline: to add the details of new participant
    Given user should be on add participant page
    When enter the details "<name>","<email>","<gender>","<status>","<isFaculty>","<college>" and "<mobile>" and click save
    Then participant should be added successfully
    Examples:
      |name         |email             |gender  |status|isFaculty|college         |mobile    |
      |Atique Rahman|atiq87@gmail.com|MALE    |ACTIVE|YES      |GITAM UNIVERSITY|8787878778|
     #  |Shanu        |shanu17@gmail.com |MALE    |ACTIVE|YES      |IIIT            |9922878778|

  Scenario: to read the added participant Details
    When search with name as in search box
    |Rahman|
    Then able to read participant details

  Scenario: to update the added participant Details
      When search with name as in search box
        |Atique|
      And when click on the edit button
      Then update the name of participant
        |Ateeq|

    Scenario: to delete the added participant Details
      When search with name as in search box
        |Rahman|
      Then click on delete button and delete the participant

    Scenario: to verify the deleted participant
      When search with name as in search box
        |Ateeq|
      Then participant details should not be visible

   Scenario: to verify from API
     When search with name as in search box
     |Rahman|
    Then enter the details as email
     |atique87@gmail.com|

    Scenario: verify Participant details from DataBase
      When search with name as in search box
        |Rahman|
      Then to verify with name
