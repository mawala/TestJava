Scenario:  message is sent
Given server's address by <server>
And message by <message>
When message can be sent
And messenger sends message
Then result should equal <result>

Examples:
|server|message|result|
|google.pl|message|0|
|inf.ug.edu.pl|some message|0|
