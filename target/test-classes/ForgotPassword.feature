@Forgotpassword
Feature:  To validate the forgot password functionality
@PassingInvalidEmail
Scenario Outline: verify user able to retrive the password 

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

@PassingvalidEmail
Scenario Outline: verify user able to retrive the password 

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


