@test
Feature: To Proglint shop application functionalites

Scenario Outline: Login the application with invalid username and empty password

Given Lanuch the correct url
When Print the tittle of the page
When passing the valid username
When passing the valid password
And click on the login button

Scenario: Dashboard functionality
Given Navigation to Dashboard screen
When Requested order click
 When Checking the dashboard orders count(Inprogress, Yet to deliver,refund accept and reject)
 When Set Max Visitor-->Increase 
 When Set Max Visitor-->Decrease
 When TC11 Store open close status , radio button checking
 When WIWO page navigating
 When Hybrid Order page navigation from Dashboard
 When  Online Order page navigation from Dashboard
 When Refund Requests page navigation from Dashboard
 When Notifications page Navigation
 When Blocked Customer Page navigation from Dashboard
 When No Notifications
 When PIM opened after clicking Goto PIM
 When Navigate to orders- verify
 When Navigate to Receipt List- verify
 When Navigate to Product Search- verify
 When Navigate to Store Timing - verify
 When Navigate to Promotions- verify
 When Navigate to reports - verify
 When Navigate to planogram- verify
 When Navigate to Refund- verify
 When Navigate to Blocked Customer- verify
 When Navigate to chat- verify
 When Navigate to members- verify
 And  Navigate to notification- verify
 Then Navigate to settings- verify
 
Scenario: verify the order screen functionality
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

Scenario: Receiptlist functionality
Given Navigate to Receipt screen
When Checking Searchicon,Filter,List of Receiptdetails & Pagination button is displayed
When Applying filter & capturing list
When Close the receipt by close button
When Open the receipt and capture the details of the order
And Checking the search bar 
Then Checking the pagination

Scenario: Verify the Findproduct functionality
Given To verify the Find Product tab is displayed in the side bar menu and click on the same
When Verify the Find Product header is displayed in the screen if not throw error message
When Verify the Search box is displayed
When Verify the drop down field is displayed
When Verify the placeholder is displayed in the Search box
When Click on the Products which is displayed in the list
When Search the products by Product name 
When Verify the Searched product name is displayed in the Search box and displayed in the list
When Clear the product name in the search box
When Search the product by SKU id and clear the id
When Verify the grocery is selected in the drop down
And Verify two options is displayed in the dropdown and print the options
Then Verify the grocery is displayed after selecting it

Scenario: To validate the Store Timing screen functionalites
Given click on the store timing tab
When checking the 'Store hours' title is present on the screen
When checking all the days and timings are present on the screen
And Click on the Edit button and changing the start time and checking the same and checking the cancel functionality
Then Click on the Edit button and changing the end time

Scenario: verify user able to see and add the Promotions screen
Given Navigating to Promotions screen
When Verify the combo offer add and edit option
When Verify the multibuy offer add and edit option
When Verify the Free item offer add and edit option
When Verify the Dollar off offer add and edit option
And Verify the Happy hours offer add and edit option
Then Verify the customer coupon offer add and edit option


Scenario: To validate the Reports screen functionalites

Given click on the Reports tab
And checking the Reports title is present on the screen
When click on the Download report button to check the validation
When Checking the From input field and Choosing the current date
When Checking the To input field and Choosing the current date
When selecting the report type
When clicking the view report button
When clicking on the download button to download the report
Then Checking the clear button functionality

Scenario: To validate the refund request screen functionalites

Given click on the refundrequest tab
When checking the Refund requests title is present on the screen
When Launching the order and check the refund action in admin
When checking the dropdown options and results
Then checking the Filter conditions and results


Scenario: Chat screen functionality
Given  Navigate to Chat screen and priniting and send message to customer

Scenario: Members functionality
Given Navigate to Members screen
When Adding the new members
And Checking the pagination on Members screen
Then Checking the view,edit,search employee functionality




