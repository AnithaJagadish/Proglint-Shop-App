@Login,Dashboard
Feature: To validate the login and Dashboard screen functionalites

Scenario Outline: Login the application with invalid username and empty password

Given Lanuch the correct url
When Print the tittle of the page
When passing the valid and invalid username "<Username1>"
When passing the empty password "<Password1>"
And click on the login button
When check the error message
Then refresh the page

Examples:
|Username1|Password1|
|support@proglint.com||
|anitha@proglint.com||

Scenario: Login the application with empty username and valid password

When passing the empty username
When passing the valid password
And click on the login button
When check the error message empty username and valid password
Then refresh the page

Scenario: Login the application with valid username and invalid password

When passing the valid username
When passing the invalid password
And click on the login button
When check the error message for valid username and invalid password
Then refresh the page

Scenario Outline: verify  unable to retrive the password with invalid email
Given Lanuch the correct url
When Print the tittle of the page
When Checking Forgot password button active or not
When click on the forgot password button
And Passing invalid email address "<invalidemail>"
Then click on the sumbit button

Examples:
|invalidemail|
|anitha|
|support@proglintcom|


Scenario Outline: verify able to retrive the password with valid email
Given Lanuch the correct url
When Print the tittle of the page
When Checking Forgot password button active or not
When click on the forgot password button
And enter the correct email "<validemail>"
And click on the sumbit button
And enter the invaild otp
Then click on the verify otp button

Examples:
|validemail|
|support@proglint.com| 

Scenario: verify user able to login the application with vaild username and password

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
