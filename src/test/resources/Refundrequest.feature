@refundrequest
Feature: To validate the refund request screen functionalites
Scenario: To validate the refund request screen functionalites

Given Lanuch the correct url
When Print the tittle of the page
When passing the valid username
When passing the valid password
And click on the login button

When click on the refundrequest tab
When checking the Refund requests title is present on the screen
When Launching the order and check the refund action in admin,dropdown,filter
