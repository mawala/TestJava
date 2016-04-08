Scenario:  message is not sent
Given server's address by <server>
And message by <message>
When message cannot be sent
And messenger sends message
Then result should equal <result>

Examples:
|server|message|result|
|google.pl|message|1|
|inf.ug.edu.pl|some message|1|
