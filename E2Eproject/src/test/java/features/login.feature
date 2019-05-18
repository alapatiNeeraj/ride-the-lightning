Feature: login into application
Scenario Outline: test case validation
Given intialization of browser with chrome
And navigate to "https://www.qaclickacademy.com" website
And click on login link and navigate to login page
When enter the <username> and <password> and click on login
Then verify if the user has successfully logged in
And close the browsers

Examples:
|username           |password    |
|test99@gmail.com   |123456      |
|test123@gmail.com  |12345       |