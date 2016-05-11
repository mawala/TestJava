Scenario: User does not log in
Given user is on login page
When user gives correct email
And user gives incorrect password
And user clicks submit
Then user does not log in

Scenario: User logs in
Given user is on login page
When user gives correct email
And user gives correct password
And user clicks submit
Then user logs in
