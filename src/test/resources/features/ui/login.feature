Feature: UI task
  As authorised user
  user wants to sort the table by row
  So user can see the sorted table

  Background: Successful user login with valid email, password
    When user enters valid data to login fields
    Then DASHBOARD is opened

  @ui
  Scenario: Successful sorting of table
    When user clicks PLAYER_MANAGEMENT box
    And user checks that the table is present
    And user clicks on table row name USERNAME to sort it
    Then user sees the sorted table

