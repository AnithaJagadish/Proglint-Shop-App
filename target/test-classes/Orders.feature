@Orders
Feature: To check the order screen

Scenario: verify user able to see the order screen
Given Lanuch the correct url
When Print the tittle of the page
When passing the valid username
When passing the valid password
And click on the login button
When click on the orders tab
When Navigate to pending order details
When Navigate to first order
When Accept the order
When Ready to pickup the order
When Confirm Delivery the order
When Back to orders screen
When Navigate to order screen to reject order
When Searching the valid number(search functionality) 
When Searching the invalid number(search functionality)
And Navigate to Bistro order
Then Lanuch the correct customer url for order lanching
