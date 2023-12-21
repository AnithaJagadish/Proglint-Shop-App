@Receiptlist
Feature: To validate the Receiptlist screen functionalites

Scenario: Receiptlist functionality
Given  Navigate to Receipt screen
When Checking Searchicon,Filter,List of Receiptdetails & Pagination button is displayed
When Applying filter & capturing list
When Close the receipt by close button
When Open the receipt and capture the details of the order
And Checking the search bar 
Then Checking the pagination
