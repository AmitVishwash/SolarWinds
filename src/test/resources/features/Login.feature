Feature: Editing a User Name

  Scenario Outline: Editing a  user name after login to application
    Given User  is on home page of application
    And User clicks on the "<productCategory>" product category
    When User enters email and password
    Then User should be redirected to Papertrail Overview page
    When user edits the name to "<changedUserName>"
    Then the new user name should be reflected
    Examples:
    |productCategory|changedUserName|
    |papertrail     |Rahul V.       |
