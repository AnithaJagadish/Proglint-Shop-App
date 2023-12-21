@Promotions
Feature: To check the Promotions screen

Scenario: verify user able to see and add the Promotions screen
Given Lanuch the correct url
When Print the tittle of the page
When passing the valid username
When passing the valid password
And click on the login button
When Navigating to Promotions screen
When Verify the combo offer add and edit option
When Verify the multibuy offer add and edit option
When Verify the Free item offer add and edit option
When Verify the Dollar off offer add and edit option
And Verify the Happy hours offer add and edit option
Then Verify the customer coupon offer add and edit option





